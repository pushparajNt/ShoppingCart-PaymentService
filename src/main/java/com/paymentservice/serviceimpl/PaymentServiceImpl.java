package com.paymentservice.serviceimpl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.entity.PaymentDetails;
import com.paymentservice.model.PaymentRequest;
import com.paymentservice.repository.PaymentDetailsRepository;
import com.paymentservice.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;

	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		
		log.info("Recording payment details",paymentRequest);
		
		PaymentDetails details =PaymentDetails.builder()
				.paymentDate(Instant.now())
				.paymentMode(paymentRequest.getPaymentMode().name())
				.paymentStatus("SUCCESS")
				.orderId(paymentRequest.getOrderId())
				.referenceNumber(paymentRequest.getReferenceNumber())
				.amount(paymentRequest.getAmount())
				.build();
		
		paymentDetailsRepository.save(details);
		log.info("Payment is completed with the transaction id",details.getId());
		return details.getId();
	}

}
