package com.example.taxas.services;

import com.example.taxas.controllers.dtos.CalculationTaxDto;
import com.example.taxas.controllers.dtos.CalculationTaxResponseDto;
import com.example.taxas.controllers.dtos.TaxesDto;
import com.example.taxas.controllers.dtos.TaxesRegisterDto;

import java.util.List;

public interface BrazilTaxesService {
    TaxesDto registerTax(TaxesRegisterDto taxesRegisterDto);
    CalculationTaxResponseDto calculateTax(CalculationTaxDto calculationTaxDto);
    TaxesDto findById(int id);
    List<TaxesDto> getAllTaxes();
    void deleteTaxes(int id);
}
