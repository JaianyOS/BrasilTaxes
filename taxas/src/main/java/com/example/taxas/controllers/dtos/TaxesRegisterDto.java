package com.example.taxas.controllers.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TaxesRegisterDto {

    @NotNull(message = "O nome não pode ser nulo")
    @NotEmpty(message = "O nome não pode estar vazio")
    private String name;

    @NotNull(message = "A descrição não pode ser nula")
    @NotEmpty(message = "A descrição não pode estar vazia")
    private String description;

    @NotNull(message = "A alíquota não pode ser nula")
    private Float aliquota;

    public TaxesRegisterDto(String name, String description, Float aliquota) {
        this.name = name;
        this.description = description;
        this.aliquota = aliquota;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAliquota() {
        return aliquota;
    }

    public void setAliquota(Float aliquota) {
        this.aliquota = aliquota;
    }
}