package com.paymentservice.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private long amount;
	private String referenceNumber;
	private PaymentMode paymentMode;
	
}
