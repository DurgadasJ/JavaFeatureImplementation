package com.exmpl.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class JavaFeaturedApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaFeaturedApplication.class, args);
		System.out.println("Project Started");
	}

}
