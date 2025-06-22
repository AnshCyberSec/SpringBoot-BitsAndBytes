package com.bitsnbytes.product;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(ProductApplication.class, args);

	}

}
