package com.example.fakerapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomPage<T> {
    private List<T> content;
    private int page;
    private int perPage;
    private long totalElements;
    private int totalPages;
}
