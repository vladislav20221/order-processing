package com.example.service;

import com.example.domain.exception.ResponseCodeError;
import com.example.inventory.entity.ProductEntity;
import com.example.domain.exception.inventory.ProductBlockingException;
import com.example.domain.exception.inventory.ProductImpossibleByException;
import com.example.domain.exception.inventory.ProductNotFoundException;
import com.example.inventory.mapper.ProductMapperImpl;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.service.ProductService;
import com.example.inventory.service.impl.ProductServiceImpl;
import com.example.utils.ProductGenerator;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest(classes = {ProductRepository.class, ProductServiceImpl.class, ProductMapperImpl.class})
@ActiveProfiles("test")
@DisplayName("module test product service")
public class ProductServiceTest {
    @MockBean
    private ProductRepository repository;
    @Autowired
    private ProductService service;

    private ProductEntity product;

    @BeforeEach
    public void initProduct() {
        product = ProductGenerator.create();
        Mockito.when(repository.findById(product.getId()))
                .thenReturn(Optional.of(product));
    }

    @Test
    @DisplayName("exception [by] blocked")
    public void testExceptionBlocked() {
        product.setIsBlocked(true);
        ResponseCodeError exception = Assertions.assertThrows(ProductBlockingException.class, () -> {
            service.by(product.getId().toString(), 5);
        });
    }

    @Test
    @DisplayName("exception [by] quantity")
    public void testExceptionNotQuantity() {
        final int count = 20;
        product.setIsBlocked(false);
        product.setQuantity(count - 10);
        ResponseCodeError exception = Assertions.assertThrows(ProductImpossibleByException.class, () -> {
            service.by(product.getId().toString(), count);
        });
    }

    @Test
    @DisplayName("exception [find by uid] not found")
    public void testExceptionNotFoundFindByUid() {
        ResponseCodeError exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.findByUid(UUID.randomUUID().toString());
        });
    }

    @Test
    @DisplayName("exception [unlock] not found")
    public void testExceptionNotFoundUnlock() {
        ResponseCodeError exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.unlock(UUID.randomUUID().toString());
        });
    }

    @Test
    @DisplayName("exception [block] not found")
    public void testExceptionNotFoundBlock() {
        ResponseCodeError exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.block(UUID.randomUUID().toString());
        });
    }

    @Test
    @DisplayName("exception [by] not found")
    public void testExceptionNotFoundBy() {
        ResponseCodeError exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.by(UUID.randomUUID().toString(), 10);
        });
    }

    @Test
    @DisplayName("exception [update quantity] not found")
    public void testExceptionNotFoundQuantity() {
        ResponseCodeError exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.updateQuantity(UUID.randomUUID().toString(), 10);
        });
    }

    @Test
    @DisplayName("exception [update price] not found")
    public void testExceptionNotFoundPrice() {
        ResponseCodeError exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.updatePrice(UUID.randomUUID().toString(), 10);
        });
    }

}