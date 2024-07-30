package com.example.discount.service.impl;

import com.example.discount.model.DiscountFilter;
import com.example.discount.repository.DiscountRepository;
import com.example.discount.dto.CreateDiscountRequestDto;
import com.example.discount.dto.DiscountDto;
import com.example.discount.entity.DiscountEntity;
import com.example.discount.mapper.DiscountMapper;
import com.example.discount.service.DiscountService;
import com.example.domain.exception.discount.DiscountNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountMapper mapper;
    private final DiscountRepository repository;

    @Override
    public DiscountDto create(final CreateDiscountRequestDto request) {
        final DiscountEntity entity = mapper.map(request);
        return mapper.map(repository.save(entity));
    }

    @Override
    public DiscountDto findById(final Long id) {
        return mapper.map(this.tryFindById(id));
    }

    @Override
    public List<DiscountDto> findAll() {
        return repository.findAll().stream().map(mapper::map).toList();
    }

    @Override
    public List<DiscountDto> findAllFilters(final DiscountFilter filter) {
        return this.repository.findFilters(filter).stream().map(mapper::map).toList();
    }

    @Override
    public Page<DiscountDto> findAllPage(final PageRequest pageable) {
        return repository.findAll(pageable).map(mapper::map);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public void activate(final Long id) {
        final DiscountEntity entity = tryFindById(id);
        entity.getFlags().setIsActive(true);
    }

    @Override
    public void deactivate(final Long id) {
        final DiscountEntity entity = tryFindById(id);
        entity.getFlags().setIsActive(false);
    }

    private DiscountEntity tryFindById(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DiscountNotFoundException(id));
    }

}