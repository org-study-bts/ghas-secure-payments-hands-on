package com.example.securepayments;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("ok");
    }

    @GetMapping("/payments")
    public List<Payment> payments() {
        return service.all();
    }

    @GetMapping("/payments/{id}")
    public Payment payment(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@Valid @RequestBody CreatePaymentRequest request) {
        return service.create(request);
    }

    @PostMapping("/payments/{id}/authorize")
    public Payment authorize(@PathVariable long id) {
        return service.authorize(id);
    }

    public record HealthResponse(String status) {}
}
