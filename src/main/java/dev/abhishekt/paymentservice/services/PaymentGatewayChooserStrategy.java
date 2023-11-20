package dev.abhishekt.paymentservice.services;

import dev.abhishekt.paymentservice.services.paymentgateway.PaymentGateway;
import dev.abhishekt.paymentservice.services.paymentgateway.RazorPayPaymentGateway;
import dev.abhishekt.paymentservice.services.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorPayPaymentGateway razorPayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;
    public PaymentGatewayChooserStrategy(RazorPayPaymentGateway razorPayPaymentGateway,StripePaymentGateway stripePaymentGateway) {
        this.razorPayPaymentGateway = razorPayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }
    public PaymentGateway getBestPaymentGateway() {
        //Logic to choose the best payment gateway
//        int randomInt = new Random().nextInt();
//        if(randomInt % 2 == 0){
//            return razorPayPaymentGateway;
//        }
        return stripePaymentGateway;//For Now always returning Stripe PG
//        return razorPayPaymentGateway;//For Now always returning RazorPay PG
    }
}
