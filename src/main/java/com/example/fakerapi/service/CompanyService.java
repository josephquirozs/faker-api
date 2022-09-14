package com.example.fakerapi.service;

import com.example.fakerapi.model.Company;
import com.example.fakerapi.model.CompanySearchArgs;
import com.example.fakerapi.model.CompanySearchCriteria;
import com.example.fakerapi.model.CustomPage;
import com.example.fakerapi.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static com.example.fakerapi.repository.CompanySpecifications.nameContains;
import static com.example.fakerapi.repository.CompanySorts.modifiedOnDescending;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CustomPageMapper<Company> customPageMapper;

    public CustomPage<Company> search(CompanySearchArgs args) {
        Assert.notNull(args, "Argument 'args' must not be null");
        // Formatting search value
        args.setSearchValue(args.getSearchValue() == null ? null : args.getSearchValue().trim().toUpperCase());
        // Decoding search criteria
        final CompanySearchCriteria searchCriteria = decodeSearchCriteria(args.getSearchValue());
        // Use 'searchCriteria' to scale
        final Page<Company> rawPage = searchByDescription(args);
        return customPageMapper.fromPage(rawPage);
    }

    private CompanySearchCriteria decodeSearchCriteria(String searchValue) {
        // Use 'searchValue' to scale
        return CompanySearchCriteria.DESCRIPTION;
    }

    private Page<Company> searchByDescription(CompanySearchArgs args) {
        final String description = args.getSearchValue() == null ? "" : args.getSearchValue();
        final Specification<Company> specification = Specification.where(nameContains(description));
        final int pageNumber = args.getPage() == null ? ServiceConstants.DEFAULT_PAGE_NUMBER : args.getPage() - 1;
        final int pageSize = args.getPerPage() == null ? ServiceConstants.DEFAULT_PAGE_SIZE : args.getPerPage();
        final Sort sort = modifiedOnDescending();
        final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return companyRepository.findAll(specification, pageRequest);
    }
}
