package ro.mycode.bicicletaapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.bicicletaapi.repository.BicicletaRepo;

@SpringBootApplication
public class BicicletaApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BicicletaApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BicicletaRepo bicicletaRepo){
		return args -> {

		};
	}

}

