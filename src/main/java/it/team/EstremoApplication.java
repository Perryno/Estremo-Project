package it.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("it.team.services")
@EntityScan("it.team.entities")
@ComponentScan("it.team.Controllers")
public class EstremoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstremoApplication.class, args);
	}

}