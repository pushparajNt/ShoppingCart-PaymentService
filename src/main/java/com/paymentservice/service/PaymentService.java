package com.paymentservice.service;

import com.paymentservice.model.PaymentRequest;
import com.paymentservice.model.PaymentResponse;

public interface PaymentService {

	long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetails(Long id);

}
