package com.example.fakerapi.controller;

import com.example.fakerapi.model.Company;
import com.example.fakerapi.model.CompanySearchArgs;
import com.example.fakerapi.model.CustomPage;
import com.example.fakerapi.service.CompanyService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "companies")
@RestController
@AllArgsConstructor
public class CompanyController {
    private final CompanyService service;

    @GetMapping(value = "/companies")
    public CustomPage<Company> search(
            @RequestParam(name = "page", required = false, defaultValue = ControllerConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "perPage", required = false, defaultValue = ControllerConstants.DEFAULT_PAGE_SIZE) Integer perPage,
            @RequestParam(name = "searchValue", required = false) String searchValue
    ) {
        final CompanySearchArgs args = CompanySearchArgs.builder()
                .page(page)
                .perPage(perPage)
                .searchValue(searchValue)
                .build();
        return service.search(args);
    }
}
