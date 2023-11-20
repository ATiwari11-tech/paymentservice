package dev.abhishekt.paymentservice.services;

import com.razorpay.RazorpayException;
import dev.abhishekt.paymentservice.services.paymentgateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;
    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy) {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }
    public String initiatePayment(String orderId,String email,String phoneNumber,Long amount) {
        //Assume below
        //Order order = orderService.getOrderDetails(orderId);
        //Long amount = order.getAmount();
//        Long amount = 1010L;//store number * 100 i.e. 1010 says last 2 are decimal or 10.00 => 1000
        //String orderId,String email,String phoneNumber,Long amount
        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.getBestPaymentGateway();
        return paymentGateway.generatePaymentLink(orderId,email,phoneNumber,amount);
//        return "Payment initiated:"+orderId;
    }

}
