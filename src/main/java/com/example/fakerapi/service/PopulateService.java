package com.example.fakerapi.service;

import com.example.fakerapi.model.Company;
import com.example.fakerapi.repository.CompanyRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class PopulateService {
    private final CompanyRepository companyRepository;

    @Transactional
    public void populate() {
        final LocalDateTime currentDateTime = LocalDateTime.now();
        final Faker faker = new Faker(new Locale("es"));
        final List<Company> newCompanies = new ArrayList<>();
        for (int index = 1; index <= 100; index++) {
            final Company company = Company.builder()
                    .id(UUID.randomUUID())
                    .createdOn(currentDateTime)
                    .modifiedOn(currentDateTime)
                    .name(faker.company().name())
                    .address(faker.address().fullAddress())
                    .phone(faker.phoneNumber().cellPhone())
                    .build();
            newCompanies.add(company);
        }
        companyRepository.saveAll(newCompanies);
    }
}
