package com.Greentech.CQRS;

import com.Greentech.CQRS.command.repo.ZonegéographiqueCommandRepository;
import com.Greentech.CQRS.query.repo.ZonegéographiqueQueryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;




@EnableJpaRepositories(basePackageClasses = ZonegéographiqueCommandRepository.class)
@EnableMongoRepositories(basePackageClasses = ZonegéographiqueQueryRepository.class)
//@EnableSwagger2
@EnableScheduling
@SpringBootApplication
//@EnableSwagger2
public class CqrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsApplication.class, args);
	}

}
