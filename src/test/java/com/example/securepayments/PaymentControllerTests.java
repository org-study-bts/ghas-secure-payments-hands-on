package com.example.securepayments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentControllerTests {
    @Autowired MockMvc mvc;

    @Test
    @Order(1)
    void healthIsAvailable() throws Exception {
        mvc.perform(get("/health")).andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

    @Test
    @Order(2)
    void createGetAndAuthorizePayment() throws Exception {
        String body = "{\"amount\":12.50,\"currency\":\"BRL\",\"description\":\"Demo payment\"}";
        mvc.perform(post("/payments").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.status").value("CREATED"));
        mvc.perform(get("/payments")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))));
        mvc.perform(post("/payments/1/authorize")).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void rejectsInvalidPayment() throws Exception {
        mvc.perform(post("/payments").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\":0,\"currency\":\"br\",\"description\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(4)
    void missingPaymentIsNotExposedAsAnErrorPage() throws Exception {
        mvc.perform(get("/payments/999999")).andExpect(status().isNotFound());
    }
}
