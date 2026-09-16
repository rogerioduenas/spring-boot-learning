package com.rogerio.ex_04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ProductService productService;

  @ParameterizedTest
  @CsvSource(value = {
      "'', 10.0, 5",
      "Notebook, -1.0, 5",
      "Notebook, 10.0, -1, null"
  })
  @DisplayName("Should return 400 Bad Request and not call service when request is invalid")
  void givenInvalidProductRequest_whenCreateProduct_thenReturn400BadRequestAndNeverCallService(
      String name, Double price, Integer quantity
  ) throws Exception {
    // Given
    ProductRequest request = new ProductRequest(name, price, quantity);

    // When
    ResultActions result = mockMvc.perform(post(
        "/api/v1/products")
        .content(objectMapper.writeValueAsString(request))
        .contentType(MediaType.APPLICATION_JSON_VALUE));

    // Then
    result.andExpect(status().isBadRequest());
    then(productService).shouldHaveNoInteractions();
  }

  @Test
  @DisplayName("Should return 201 Created when request is valid")
  void givenValidProductRequest_whenCreateProduct_thenReturn201CreatedAndProductResponse() throws Exception {
    // Given
    ProductRequest request = new ProductRequest("VALID_NAME", 100.0, 10);
    ProductResponse response = new ProductResponse(1L, "VALID_NAME", 100.0, 10);

    given(productService.createProduct(any())).willReturn(response);

    // When
    ResultActions result = mockMvc.perform(post(
        "/api/v1/products")
        .content(objectMapper.writeValueAsString(request))
        .contentType(MediaType.APPLICATION_JSON_VALUE));

    // Then
    result.andExpect(status().isCreated())
        .andExpect(header().string("Location", "/api/v1/products/1"))
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.name").value("VALID_NAME"))
        .andExpect(jsonPath("$.price").value(100.0))
        .andExpect(jsonPath("$.quantityInStock").value(10));
  }
}
