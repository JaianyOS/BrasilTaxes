package com.example.taxas.controllers;

import com.example.taxas.controllers.dtos.CalculationTaxDto;
import com.example.taxas.controllers.dtos.CalculationTaxResponseDto;
import com.example.taxas.services.BrazilTaxesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculo")
public class TaxesCalculationController {

    @Autowired
    private BrazilTaxesService service;

    @PostMapping
    public ResponseEntity<CalculationTaxResponseDto> calculateTax(@RequestBody @Valid CalculationTaxDto taxDto) {
        return ResponseEntity.ok(service.calculateTax(taxDto));
    }
}