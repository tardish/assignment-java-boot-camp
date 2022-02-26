package com.example.java_shop_api.payment;

import com.example.java_shop_api.basket.Basket;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment createdPayment(@NotNull UserPayment userPayment){
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String invoiceNo = "00"+dateString;
        String barcode = "01"+dateString;
        String transactionDate = dateString;
        String expireDate = dateString;

        Payment payment = new Payment();
        payment.setUserGuid(userPayment.getUserGuid());
        payment.setName(userPayment.getUserName());
        payment.setAmount(userPayment.getAmount());
        payment.setInvoiceNo(invoiceNo);
        payment.setBarcode(barcode);
        payment.setTransactionDate(transactionDate);
        payment.setExpiredDate(expireDate);
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
