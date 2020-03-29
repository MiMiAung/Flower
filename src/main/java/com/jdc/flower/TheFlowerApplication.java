package com.jdc.flower;

import com.jdc.flower.base.BaseRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class TheFlowerApplication {



	public static void main(String[] args) {
		SpringApplication.run(TheFlowerApplication.class, args);



    }




}
