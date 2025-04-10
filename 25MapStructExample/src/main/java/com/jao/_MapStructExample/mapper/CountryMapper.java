package com.jao._MapStructExample.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.jao._MapStructExample.dtos.CountryDto;
import com.jao._MapStructExample.dtos.LanguageDto;
import com.jao._MapStructExample.models.Country;
import com.jao._MapStructExample.models.Language;


@Mapper
public interface CountryMapper {

    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "continent", source = "location.continent")
    CountryDto toCountryDto(Country country);

    @Mapping(target = "isOfficialLanguage", source = "isOfficial")
    @Mapping(target = "speakersTotal", source = "speakersCount")
    LanguageDto toLanguageDto(Language language);

}