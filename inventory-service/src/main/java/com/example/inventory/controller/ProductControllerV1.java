package com.example.inventory.controller;

import com.example.inventory.dto.CreateProductRequest;
import com.example.inventory.dto.ProductDto;
import com.example.inventory.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Tag(name = "product controller")
public class ProductControllerV1 {
    private final ProductService service;

    @Operation(summary = "get page product")
    @GetMapping("/page")
    public Page<ProductDto> getPage(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return service.getPage(PageRequest.of(page, size));
    }

    @Operation(summary = "get all product")
    @GetMapping("")
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "product find by uid")
    @GetMapping("/{uid}")
    public ProductDto findByUid(
            @PathVariable("uid") String uid
    ) {
        return service.findByUid(uid);
    }

    @Operation(summary = "create product")
    @PostMapping("")
    public ProductDto create(
            @RequestBody CreateProductRequest request
    ) {
        return service.create(request);
    }

    @Operation(summary = "product price update")
    @PatchMapping("/price/{uid}/{price}")
    public ProductDto updatePrice(
            @PathVariable("uid") String uid,
            @PathVariable("price") Integer price
    ) {
        return service.updatePrice(uid, price);
    }

    @Operation(summary = "product quantity update")
    @PatchMapping("/quantity/{uid}/{quantity}")
    public ProductDto updateQuantity(
            @PathVariable("uid") String uid,
            @PathVariable("quantity") Integer quantity
    ) {
        return service.updateQuantity(uid, quantity);
    }

    @Operation(summary = "delete product by uid")
    @DeleteMapping("/{uid}")
    public void delete(
            @PathVariable("uid") String uid
    ) {
        this.service.delete(uid);
    }

    @Operation(summary = "block product")
    @PatchMapping("/{uid}/block")
    public void block(
            @PathVariable("uid") String uid
    ) {
        this.service.block(uid);
    }

    @Operation(summary = "unlock product")
    @PatchMapping("/{uid}/unlock")
    public void unlock(
            @PathVariable("uid") String uid
    ) {
        this.service.unlock(uid);
    }

    @Operation(summary = "by product")
    @PatchMapping("/by/{uid}/{count}")
    public void by(
            @PathVariable("uid") String uid,
            @PathVariable("count") Integer count
    ) {
        service.by(uid, count);
    }

}