package com.example.discount.controller;

import com.example.discount.dto.CreateDiscountRequestDto;
import com.example.discount.dto.DiscountDto;
import com.example.discount.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discounts")
@RequiredArgsConstructor
public class DiscountManagementControllerV1 {
    private final DiscountService service;

    @PostMapping("")
    public DiscountDto create(
            @RequestBody final CreateDiscountRequestDto request
    ) {
        return this.service.create(request);
    }

    @GetMapping("/{id}")
    public DiscountDto findById(
            @PathVariable("id") final Long id
    ) {
        return this.service.findById(id);
    }

    @GetMapping("/list")
    public List<DiscountDto> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/page")
    public Page<DiscountDto> findAllPage(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return this.service.findAllPage(PageRequest.of(page, size));
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") final Long id
    ) {
        this.service.deleteById(id);
    }

    @PatchMapping("/activate/{id}")
    public void activate(
            @PathVariable("id") final Long id
    ) {
        this.service.activate(id);
    }

    @PatchMapping("/deactivate/{id}")
    public void deactivate(
            @PathVariable("id") final Long id
    ) {
        this.service.deactivate(id);
    }

}