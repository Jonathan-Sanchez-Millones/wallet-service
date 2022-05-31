package com.bootcamp.reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDto {

	private Long phoneNumberSender;
	private Long phoneNumberReceiver;
	private double amount;
}
