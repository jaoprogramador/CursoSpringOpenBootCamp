package com.jao._MapStructExample.controller;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao._MapStructExample.dtos.CountryDto;
import com.jao._MapStructExample.service.CountryService;

@RestController
@RequestMapping(path = "country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping(path = "{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.countryService.readById(id));
    }
}