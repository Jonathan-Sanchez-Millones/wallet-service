package com.bootcamp.reactive.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.bootcamp.reactive.config.CacheConfig;
import com.bootcamp.reactive.dto.PayDto;
import com.bootcamp.reactive.entity.User;
import com.bootcamp.reactive.entity.Wallet;
import com.bootcamp.reactive.repository.WalletRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WalletService {

	
	@Autowired
	private WalletRepository repository;
	
	@Bean
	Consumer<User> saveWallet() {
		
		
		return user -> {
			log.info("User: " + user);
			Wallet yunki = new Wallet();
			yunki.setPhoneNumber(user.getPhoneNumber());
			yunki.setSaldo(0);
			repository.save(yunki);
		};
	}
	
	@Cacheable(cacheNames = CacheConfig.WALLET_CACHE, key="#phoneNumber", unless="#result == null")
	public Wallet findByPhoneNumber(Long phoneNumber) {
		
		return repository.findByPhoneNumber(phoneNumber);
	}
	
	@CachePut(cacheNames = CacheConfig.WALLET_CACHE, unless = "#result == null")
    public Wallet doPay(PayDto pago) {
        Wallet sender = repository.findByPhoneNumber(pago.getPhoneNumberSender());
        sender.setSaldo(sender.getSaldo()-pago.getAmount());
        repository.save(sender);
        Wallet receiver = repository.findByPhoneNumber(pago.getPhoneNumberReceiver());
        receiver.setSaldo(receiver.getSaldo()+pago.getAmount());
        return repository.save(receiver);
    }
}

