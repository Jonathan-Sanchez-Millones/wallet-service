package com.bootcamp.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.reactive.dto.PayDto;
import com.bootcamp.reactive.entity.Wallet;
import com.bootcamp.reactive.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService service;
	
	@GetMapping("/{phoneNumber}")
	public Wallet findById(@PathVariable Long phoneNumber) {
		
		return service.findByPhoneNumber(phoneNumber);
	}
	
	@PostMapping("/pago")
	public Wallet doPay(@RequestBody PayDto pago) {
		
		return service.doPay(pago);
	}
}