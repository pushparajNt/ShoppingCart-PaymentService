package com.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.entity.PaymentDetails;
import com.paymentservice.model.PaymentRequest;
import com.paymentservice.model.PaymentResponse;
import com.paymentservice.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {

	
	@Autowired
	private PaymentService paymentService;


	@PostMapping("/doPayment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest)
	{
		
		
		return new ResponseEntity<>(paymentService.doPayment(paymentRequest),
				HttpStatus.OK);
	}
	
	@GetMapping("/get/{paymentId}")
	public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable Long paymentId)
	{
		log.info("inside the paymentcontroller");
		
		PaymentResponse paymentResponse=paymentService.getPaymentDetails(paymentId);
		
		return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
	
}
