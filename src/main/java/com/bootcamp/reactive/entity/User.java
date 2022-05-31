package com.bootcamp.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Long id;
	private String typeDocument;
	private String document;
	private Long phoneNumber;
	private String imei;
	private String email;
}
