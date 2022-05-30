package com.ram.banking.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private int cardId;
	
	@NotBlank(message = "Card Number should not be blank")
	@Column(name = "card_number")
	private String cardNumber;
	
	@Min(value = 0, message = "Customer Id  should be valid")
	@Column(name = "customer_id")
	private int customerId;
	
	@NotBlank(message = "Card Type should not be blank")
	@Column(name = "card_type")
	private String cardType;
	
	@Min(value = 0, message = "Total Limit should be valid")
	@Column(name = "total_limit")
	private int totalLimit;
	
	@Min(value = 0, message = "Amount Used should be valid")
	@Column(name = "amount_used")
	private int amountUsed;
	
	@Min(value = 0, message = "Available Amount should be valid")
	@Column(name = "available_amount")
	private int availableAmount;
	
	@Column(name = "create_dt")
	private LocalDate createDate;
	
}

