package com.example.fakerapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanySearchArgs {
    private Integer page;
    private Integer perPage;
    private String searchValue;
}
