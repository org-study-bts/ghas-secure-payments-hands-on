package com.example.securepayments;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PaymentService {
    private final AtomicLong ids = new AtomicLong();
    private final ConcurrentHashMap<Long, Payment> payments = new ConcurrentHashMap<>();

    public Payment create(CreatePaymentRequest request) {
        long id = ids.incrementAndGet();
        Payment payment = new Payment(id, request.amount(), request.currency(),
                request.description().strip(), Payment.Status.CREATED, Instant.now());
        payments.put(id, payment);
        return payment;
    }

    public List<Payment> all() {
        return payments.values().stream().sorted(java.util.Comparator.comparing(Payment::id)).toList();
    }

    public Payment get(long id) {
        Payment payment = payments.get(id);
        if (payment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado");
        }
        return payment;
    }

    public Payment authorize(long id) {
        Payment current = get(id);
        Payment authorized = new Payment(current.id(), current.amount(), current.currency(),
                current.description(), Payment.Status.AUTHORIZED, current.createdAt());
        payments.put(id, authorized);
        return authorized;
    }
}
