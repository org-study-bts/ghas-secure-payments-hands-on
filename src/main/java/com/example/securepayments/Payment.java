package com.example.securepayments;

import java.math.BigDecimal;
import java.time.Instant;

public record Payment(long id, BigDecimal amount, String currency, String description,
                      Status status, Instant createdAt) {
    public enum Status { CREATED, AUTHORIZED }
}
