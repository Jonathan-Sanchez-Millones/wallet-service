package com.bootcamp.reactive.dto;

import com.bootcamp.reactive.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private User user;
	private double saldoInicial;
}

