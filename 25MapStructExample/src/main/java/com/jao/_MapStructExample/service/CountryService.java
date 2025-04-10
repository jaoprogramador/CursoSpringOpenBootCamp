package com.jao._MapStructExample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jao._MapStructExample.dtos.CountryDto;
import com.jao._MapStructExample.mapper.CountryMapper;

import dao.CountryDao;

@Service
@Slf4j
public class CountryService {

    public CountryDto readById(UUID id) {

        if (CountryDao.db.containsKey(id)) {
            return CountryMapper.mapper.toCountryDto(CountryDao.db.get(id));
        } else {
            log.error("Country with id {} not found", id);
            throw  new RuntimeException("Country with id: " + id  + " not found");
        }
    }
}
