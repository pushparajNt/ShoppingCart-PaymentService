package com.paymentservice.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long orderId;
	private String paymentMode;
	private String referenceNumber;
	private Instant paymentDate;
	private String paymentStatus;
	private long amount;
}
