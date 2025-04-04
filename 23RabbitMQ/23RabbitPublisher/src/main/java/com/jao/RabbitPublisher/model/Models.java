package com.jao.RabbitPublisher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Models {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Client{
		private String dni;
		private String fullName;
		private String adress;
		private String numberCount;
	}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Order{
		private String id;
		private String productDesc;
		private Integer number;
	}
	
}
