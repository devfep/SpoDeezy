package com.devfep.SpoDeezy;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpoDeezyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpoDeezyApplication.class, args);
	}

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient();
	}
}
