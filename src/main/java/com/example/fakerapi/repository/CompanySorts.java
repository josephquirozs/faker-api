package com.example.fakerapi.repository;

import org.springframework.data.domain.Sort;

public abstract class CompanySorts {
    public static Sort modifiedOnDescending() {
        return Sort.by("modifiedOn").descending();
    }
}
