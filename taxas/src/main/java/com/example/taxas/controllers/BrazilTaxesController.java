package com.example.taxas.controllers;

import com.example.taxas.controllers.dtos.TaxesDto;
import com.example.taxas.controllers.dtos.TaxesRegisterDto;
import com.example.taxas.services.BrazilTaxesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class BrazilTaxesController {

    @Autowired
    private BrazilTaxesService service;

    @PostMapping
    public ResponseEntity<TaxesDto> registerBrazilTaxes(@RequestBody @Valid TaxesRegisterDto registerDto) {
        return ResponseEntity.status(201).body(service.registerTax(registerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxesDto> getBrazilTaxesById(@PathVariable int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TaxesDto>> getAllTaxes() {
        return ResponseEntity.ok(service.getAllTaxes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaxesById(@PathVariable int id) {
        service.deleteTaxes(id);
        return ResponseEntity.noContent().build();
    }
}