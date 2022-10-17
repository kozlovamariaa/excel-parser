package com.kozlovam.excelparser;

import com.kozlovam.excelparser.util.HibernateSessionFactoryUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExcelFileParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelFileParserApplication.class, args);
	}
	@Bean
	public HibernateSessionFactoryUtil hibernateSessionFactoryUtil(){
		return new HibernateSessionFactoryUtil();
	}
}
