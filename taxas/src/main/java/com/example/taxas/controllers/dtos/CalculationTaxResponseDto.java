package com.example.taxas.controllers.dtos;

public class CalculationTaxResponseDto {

    private String typeTax;
    private float baseValue;
    private float aliquota;
    private float valueTax;

    public CalculationTaxResponseDto(String typeTax, float baseValue, float aliquota, float valueTax) {
        this.typeTax = typeTax;
        this.baseValue = baseValue;
        this.aliquota = aliquota;
        this.valueTax = valueTax;
    }

    public String getTypeTax() {
        return typeTax;
    }

    public void setTypeTax(String typeTax) {
        this.typeTax = typeTax;
    }

    public float getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
    }

    public float getAliquota() {
        return aliquota;
    }

    public void setAliquota(float aliquota) {
        this.aliquota = aliquota;
    }

    public float getValueTax() {
        return valueTax;
    }

    public void setValueTax(float valueTax) {
        this.valueTax = valueTax;
    }
}
