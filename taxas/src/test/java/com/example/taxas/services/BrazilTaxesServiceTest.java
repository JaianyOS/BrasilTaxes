package com.example.taxas.services;

public class BrazilTaxesServiceTest {

    private BrazilTaxesService service;
    private TaxesDto taxesDto;

    @BeforeEach
    public void setUp() {
        service = new BrazilTaxesServiceImpl();
        taxesDto = new TaxesDto(1, "ICMS", "Imposto sobre Mercadorias", 18.0f);
        service.registerTax(new TaxesRegisterDto("ICMS", "Imposto sobre Mercadorias", 18.0f));
    }

    @Test
    public void testRegisterTax() {
        TaxesDto result = service.registerTax(new TaxesRegisterDto("ISS", "Imposto sobre Serviços", 5.0f));
        assertNotNull(result);
        assertEquals("ISS", result.getName());
    }

    @Test
    public void testCalculateTax() {
        CalculationTaxResponseDto response = service.calculateTax(new CalculationTaxDto(1, 1000f));
        assertEquals(180f, response.getValueTax());
    }

    @Test
    public void testFindTaxById() {
        TaxesDto result = service.findById(1);
        assertNotNull(result);
        assertEquals("ICMS", result.getName());
    }

    @Test
    public void testDeleteTax() {
        service.deleteTaxes(1);
        assertThrows(ResourceNotFoundException.class, () -> service.findById(1));
    }
}