package com.example.taxas.controllers.dtos;

public class CalculationTaxDto {

    private int typeTaxId;
    private float baseValue;

    public CalculationTaxDto(int typeTaxId, float baseValue) {
        this.typeTaxId = typeTaxId;
        this.baseValue = baseValue;
    }

    public int getTypeTaxId() {
        return typeTaxId;
    }

    public void setTypeTaxId(int typeTaxId) {
        this.typeTaxId = typeTaxId;
    }

    public float getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
    }
}