package com.example.taxas.controllers;

@WebMvcTest(BrazilTaxesController.class)
public class BrazilTaxesControllerTest {

    @MockBean
    private BrazilTaxesService service;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;
    private TaxesDto taxesDto;
    private List<TaxesDto> taxesList;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        taxesDto = new TaxesDto(1, "ICMS", "Imposto sobre Mercadorias", 18.0f);
        taxesList = new ArrayList<>();
        taxesList.add(taxesDto);
    }

    @Test
    public void testRegisterTax() throws Exception {
        TaxesRegisterDto registerDto = new TaxesRegisterDto("ICMS", "Imposto sobre Mercadorias", 18.0f);
        String json = mapper.writeValueAsString(registerDto);

        Mockito.when(service.registerTax(Mockito.any(TaxesRegisterDto.class))).thenReturn(taxesDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/tipos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(taxesDto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is("ICMS")));
    }

    @Test
    public void testGetTaxById() throws Exception {
        Mockito.when(service.findById(1)).thenReturn(taxesDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/tipos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(taxesDto.getId())));
    }

    @Test
    public void testGetAllTaxes() throws Exception {
        Mockito.when(service.getAllTaxes()).thenReturn(taxesList);

        mockMvc.perform(MockMvcRequestBuilders.get("/tipos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", CoreMatchers.is(1)));
    }

    @Test
    public void testDeleteTaxById() throws Exception {
        Mockito.doNothing().when(service).deleteTaxes(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/tipos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}