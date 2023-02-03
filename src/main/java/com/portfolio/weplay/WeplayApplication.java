package com.portfolio.weplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan
@SpringBootApplication
public class WeplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeplayApplication.class, args);
	}

}
