package com.example.inventory.service.impl;

import com.example.inventory.dto.CreateProductRequest;
import com.example.inventory.dto.ProductDto;
import com.example.inventory.entity.ProductEntity;
import com.example.domain.exception.inventory.ProductBlockingException;
import com.example.domain.exception.inventory.ProductImpossibleByException;
import com.example.domain.exception.inventory.ProductNotFoundException;
import com.example.inventory.mapper.ProductMapper;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public Page<ProductDto> getPage(final PageRequest pageRequest) {
        return this.repository.findAll(pageRequest).map(mapper::map);
    }

    @Override
    public Page<ProductDto> getPage(final Integer page, final Integer size) {
        return this.getPage(PageRequest.of(page, size));
    }

    @Override
    public List<ProductDto> getAll() {
        return this.repository.findAll().stream().map(mapper::map).toList();
    }

    @Override
    public ProductDto findByUid(final String uid) {
        return mapper.map(this.tryFindByUid(UUID.fromString(uid)));
    }

    @Override
    public ProductDto create(final CreateProductRequest request) {
        final ProductEntity product = mapper.map(request);
        product.setIsBlocked(false);
        product.setSoldCount(0);
        return mapper.map(this.repository.save(product));
    }

    @Override
    public ProductDto updatePrice(final String uid, final Integer price) {
        final ProductEntity product = this.tryFindByUid(UUID.fromString(uid));
        product.setPrice(price);
        return mapper.map(product);
    }

    @Override
    public ProductDto updateQuantity(final String uid, final Integer quantity) {
        final ProductEntity product = this.tryFindByUid(UUID.fromString(uid));
        product.setQuantity(quantity);
        return mapper.map(product);
    }

    @Override
    public void delete(final String uid) {
        this.repository.deleteById(UUID.fromString(uid));
    }

    @Override
    public void block(final String uid) {
        final ProductEntity product = this.tryFindByUid(UUID.fromString(uid));
        product.setIsBlocked(true);
    }

    @Override
    public void unlock(final String uid) {
        final ProductEntity product = this.tryFindByUid(UUID.fromString(uid));
        product.setIsBlocked(false);
    }

    @Override
    public void by(final String uid, final Integer count) {
        final ProductEntity product = this.tryFindByUid(UUID.fromString(uid));
        tryCheckBlocked(product);
        tryCheckQuantity(product, count);
        product.setQuantity(product.getQuantity() - count);
        product.setSoldCount(product.getSoldCount() + count);
    }

    private ProductEntity tryFindByUid(final UUID uid) {
        return this.repository.findById(uid)
                .orElseThrow(() -> new ProductNotFoundException(uid));
    }

    private void tryCheckQuantity(final ProductEntity product, final Integer count) {
        if (product.getQuantity() < count) {
            throw new ProductImpossibleByException(product.getId(), product.getQuantity(), count);
        }
    }

    private void tryCheckBlocked(final ProductEntity product) {
        if (product.getIsBlocked()) {
            throw new ProductBlockingException(product.getId());
        }
    }

}