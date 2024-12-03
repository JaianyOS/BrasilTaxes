package com.example.taxas.mappers;

import com.example.taxas.controllers.dtos.TaxesDto;
import com.example.taxas.controllers.dtos.TaxesRegisterDto;

import java.util.concurrent.atomic.AtomicInteger;

public class MapperTaxes {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public static TaxesDto toTaxesDto(TaxesRegisterDto registerDto) {
        return new TaxesDto(
                ID_GENERATOR.incrementAndGet(),
                registerDto.getName(),
                registerDto.getDescription(),
                registerDto.getAliquota()
        );
    }
}