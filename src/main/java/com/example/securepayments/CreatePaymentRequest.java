package com.example.securepayments;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record CreatePaymentRequest(
        @DecimalMin(value = "0.01", message = "amount deve ser maior que zero")
        BigDecimal amount,
        @NotBlank @Pattern(regexp = "[A-Z]{3}", message = "currency deve usar três letras maiúsculas")
        String currency,
        @NotBlank @Size(max = 140, message = "description deve ter no máximo 140 caracteres")
        String description) {
}
