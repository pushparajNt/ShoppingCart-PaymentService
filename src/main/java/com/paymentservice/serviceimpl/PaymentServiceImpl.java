package com.paymentservice.serviceimpl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.paymentservice.entity.PaymentDetails;
import com.paymentservice.model.PaymentMode;
import com.paymentservice.model.PaymentRequest;
import com.paymentservice.model.PaymentResponse;
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

	@Override
	public PaymentResponse getPaymentDetails(Long id) {
		
		log.info("Going to get the payment details for order id"+id);
		PaymentDetails paymentDetails=paymentDetailsRepository.findByOrderId(id);
				
		PaymentResponse paymentResponse=
				PaymentResponse.builder()
				.paymentId(paymentDetails.getId())
				.orderId(paymentDetails.getOrderId())
				.paymentDate(paymentDetails.getPaymentDate())
				.paymentStatus(paymentDetails.getPaymentStatus())
				.paymentMode(PaymentMode.valueOf(paymentDetails.getPaymentMode()))
				.amount(paymentDetails.getAmount())
				.build();
		log.info("Successfully retrived  payment details for order id"+id);
		return paymentResponse;
	}

	
}
