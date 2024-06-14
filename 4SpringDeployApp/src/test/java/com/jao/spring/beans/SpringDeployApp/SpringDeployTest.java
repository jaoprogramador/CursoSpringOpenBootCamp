package com.jao.spring.beans.SpringDeployApp;

import org.junit.Test;

//@SpringBootTest
public class SpringDeployTest {

    @Test
    public void contextLoads() {
    	System.getenv().forEach(
    			(key,value) -> System.out.println(key+" "+value)
    	);
    }
    }

