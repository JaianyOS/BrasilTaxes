package com.example.taxas.services;

import com.example.taxas.controllers.dtos.CalculationTaxDto;
import com.example.taxas.controllers.dtos.CalculationTaxResponseDto;
import com.example.taxas.controllers.dtos.TaxesDto;
import com.example.taxas.controllers.dtos.TaxesRegisterDto;
import com.example.taxas.exceptions.ResourceNotFoundException;
import com.example.taxas.mappers.MapperTaxes;
import com.example.taxas.models.Tax;
import com.example.taxas.repositories.TaxRepository;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrazilTaxesServiceImpl implements BrazilTaxesService {

    private final List<TaxesDto> taxesList = new ArrayList<>();
    private final TaxRepository taxRepository;

    public BrazilTaxesServiceImpl(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public Tax registerTax(TaxesRegisterDto taxesRegisterDto) {
        Tax tax = new Tax();
        tax.setName(taxesRegisterDto.getName());
        tax.setDescription(taxesRegisterDto.getDescription());
        tax.setAliquota(taxesRegisterDto.getAliquota());
        FileCredentialsCache taxRepository;
        return taxRepository.save(tax);
    }


    @Override
    public TaxesDto registerTax(TaxesRegisterDto taxesRegisterDto) {
        TaxesDto taxesDto = MapperTaxes.toTaxesDto(taxesRegisterDto);
        taxesList.add(taxesDto);
        return taxesDto;
    }

    @Override
    public CalculationTaxResponseDto calculateTax(CalculationTaxDto calculationTaxDto) {
        TaxesDto taxesDto = findById(calculationTaxDto.getTypeTaxId());
        float calculatedTax = (taxesDto.getAliquota() * calculationTaxDto.getBaseValue()) / 100;
        return new CalculationTaxResponseDto(taxesDto.getName(), calculationTaxDto.getBaseValue(),
                taxesDto.getAliquota(), calculatedTax);
    }

    @Override
    public TaxesDto findById(int id) {
        return taxesList.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Tax type not found"));
    }

    @Override
    public List<TaxesDto> getAllTaxes() {
        return new ArrayList<>(taxesList);
    }

    @Override
    public void deleteTaxes(int id) {
        TaxesDto taxesDto = findById(id);
        taxesList.remove(taxesDto);
    }
}
