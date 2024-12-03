package com.example.taxas.models;

public class Calculation {
    private float baseValue;
    private float taxValue;
    private Tax tax;

    public Calculation(Tax tax) {
        this.tax = tax;
    }

    public float getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
    }

    public float getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(float taxValue) {
        this.taxValue = taxValue;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
