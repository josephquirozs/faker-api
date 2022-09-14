package com.example.fakerapi.controller;

import com.example.fakerapi.model.CustomInfo;
import com.example.fakerapi.service.PopulateService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "populate")
@RestController
@AllArgsConstructor
public class PopulateController {
    private final PopulateService service;

    @PostMapping(value = "/populate")
    public CustomInfo populate() {
        service.populate();
        return CustomInfo.builder()
                .message("Completed request")
                .build();
    }
}
