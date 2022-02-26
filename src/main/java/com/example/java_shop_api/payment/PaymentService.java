package com.example.java_shop_api.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createdPayment(UserPayment userPayment){

        Payment payment = new Payment();
        payment.setId(1);
        payment.setUserGuid(userPayment.getUserGuid());
        payment.setName(userPayment.getUserName());
        payment.setAmount(userPayment.getAmount());
        payment.setInvoiceNo("231564623");
        payment.setBarcode("000874841510");
        payment.setTransactionDate("25/02/2018 23:33");
        payment.setExpiredDate("27/02/2018 23:33");
        payment.setDetail("JavaShop");
        payment.setPayee("www.JavaShop.com \n Tel:0009900");

        Payment result = paymentRepository.save(payment);
        return result;
    }

    public Optional<Payment> findPaymentById(Integer paymentId){
        Optional<Payment>  result = paymentRepository.findPaymentById(paymentId);
        return  result;
    }
}
