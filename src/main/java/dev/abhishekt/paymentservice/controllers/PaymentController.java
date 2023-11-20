package dev.abhishekt.paymentservice.controllers;

import dev.abhishekt.paymentservice.dtos.InitiatePaymentRequestDTO;
import dev.abhishekt.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO request) {
        return paymentService.initiatePayment(request.getOrderId(),request.getEmail(),request.getPhoneNumber(),request.getAmount());
//        return "Payment initiated:"+orderId;
    }
}
