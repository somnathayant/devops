package com.ayantsoft.springbootdeploy.springbootdeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootdeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdeployApplication.class, args);
	}

}
