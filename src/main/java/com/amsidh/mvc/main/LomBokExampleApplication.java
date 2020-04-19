package com.amsidh.mvc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amsidh.config.PersonConfig;

@SpringBootApplication
public class LomBokExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{LomBokExampleApplication.class,PersonConfig.class}, args);
	}
}
