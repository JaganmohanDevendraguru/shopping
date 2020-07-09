package com.fixthepro.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fixthepro.shopping","com.fixthepro.shopping_back"})
public class ShoppingFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingFrontApplication.class, args);
	}

}
