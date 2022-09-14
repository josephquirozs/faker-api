package com.example.fakerapi.service;

import com.example.fakerapi.model.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CustomPageMapper<T> {
    public CustomPage<T> fromPage(Page<T> source) {
        return CustomPage.<T>builder()
                .content(source.getContent())
                .page(source.getNumber() + 1)
                .perPage(source.getSize())
                .totalElements(source.getTotalElements())
                .totalPages(source.getTotalPages())
                .build();
    }
}
