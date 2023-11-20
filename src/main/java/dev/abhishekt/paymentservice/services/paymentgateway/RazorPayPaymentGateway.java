package dev.abhishekt.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import java.time.Instant;

@Service
public class RazorPayPaymentGateway implements PaymentGateway{
    private RazorpayClient razorpayClient;
    public RazorPayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String generatePaymentLink(String orderId,String email,String phoneNumber,Long amount) {
        try {
            //Call RazorPay API
//        RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
//            paymentLinkRequest.put("expire_by", Instant.EPOCH.getEpochSecond() + 1800);//payment page will expire after x amount of time
            paymentLinkRequest.put("expire_by", 1700364241);//payment page will expire after x amount of time
            paymentLinkRequest.put("reference_id", orderId);//Order Id
            paymentLinkRequest.put("description", "Payment for order #" + orderId);
            JSONObject customer = new JSONObject();
            customer.put("name", "Abhishek Tiwari");
            customer.put("contact", phoneNumber);
            customer.put("email", email);
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
            JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
//        paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");//Dynamic Page for both Pass and Fail
            paymentLinkRequest.put("callback_method", "get");
            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url").toString();
        }
        catch(Exception e){
            System.out.println(e);
            return "Something is Wrong";
        }
    }
}
