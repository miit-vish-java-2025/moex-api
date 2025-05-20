package ru.vish.moex_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MoexApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoexApiApplication.class, args);
	}
}
