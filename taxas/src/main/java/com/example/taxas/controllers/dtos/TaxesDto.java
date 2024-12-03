package com.example.taxas.controllers.dtos;

public class TaxesDto {

    private int id;
    private String name;
    private String description;
    private Float aliquota;

    public TaxesDto(int id, String name, String description, Float aliquota) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.aliquota = aliquota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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