package com.example.taxas.controllers;

import com.example.taxas.controllers.dtos.CalculationTaxDto;
import com.example.taxas.controllers.dtos.CalculationTaxResponseDto;
import com.example.taxas.services.BrazilTaxesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TaxesCalculationController.class)
public class TaxesCalculationControllerTest {

    @MockBean
    private BrazilTaxesService service;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;
    private CalculationTaxDto calculationDto;
    private CalculationTaxResponseDto responseDto;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        calculationDto = new CalculationTaxDto(1, 1000f);
        responseDto = new CalculationTaxResponseDto("ICMS", 1000f, 18f, 180f);
    }

    @Test
    public void testCalculateTax() throws Exception {
        String json = mapper.writeValueAsString(calculationDto);

        Mockito.when(service.calculateTax(Mockito.any(CalculationTaxDto.class))).thenReturn(responseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeTax", CoreMatchers.is("ICMS")));
    }
}
