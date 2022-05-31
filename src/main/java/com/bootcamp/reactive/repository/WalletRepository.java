package com.bootcamp.reactive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.reactive.entity.Wallet;


public interface WalletRepository extends JpaRepository<Wallet, Long>{

	Wallet findByPhoneNumber(Long phoneNumber);

}
