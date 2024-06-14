package com.jao.spring.test;

import org.junit.jupiter.api.Test;

import com.jao.spring.service.CalculatorService;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculatorTest {
	@Test
	void name(){
		CalculatorService service = new CalculatorService();
		double result = service.sum(5,5);
		
		assertEquals(10,result);
	}

}
