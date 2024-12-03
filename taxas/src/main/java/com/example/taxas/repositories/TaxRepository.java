package com.example.taxas.repositories;

import com.example.taxas.models.Tax;

import java.util.List;

public class TaxRepository {
    List<Tax> findAll();
    Tax findById(int id);
    Tax save(Tax tax);
    void deleteById(int id);
}
