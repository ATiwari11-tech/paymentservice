package dev.abhishekt.paymentservice.services.paymentgateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generatePaymentLink(String orderId,String email,String phoneNumber,Long amount);

}
