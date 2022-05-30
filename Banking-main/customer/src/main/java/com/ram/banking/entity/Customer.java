package com.ram.banking.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Customer ID is mandatory")
	@Column(name = "customer_id", unique = true)
	private String customerId;
	@NotBlank(message = "Customer Name is mandatory")
	private String name;
	@NotBlank(message = "Customer Email is mandatory")
	@Email(message = "Please provide valid email id")
	private String email;
	@NotBlank(message = "Customer Mobile No. is mandatory")
	@Column(name = "mobile_number")
	private String mobileNo;
	@Column(name = "create_dt")
	private LocalDate createdAt;

}
