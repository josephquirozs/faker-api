package com.example.fakerapi.repository;

import com.example.fakerapi.model.Company;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

public abstract class CompanySpecifications {
    private static String contains(String value) {
        return "%" + value + "%";
    }

    public static Specification<Company> nameContains(String value) {
        Assert.notNull(value, "Argument 'value' must not be null");
        return (root, query, builder) -> builder.like(root.get("name"), contains(value));
    }
}
