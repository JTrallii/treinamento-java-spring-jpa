package jpa.spring.treinamento.pipoflix;

import jpa.spring.treinamento.pipoflix.principal.Principal;
import jpa.spring.treinamento.pipoflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PipoFlixApplication{
	public static void main(String[] args) {
		SpringApplication.run(PipoFlixApplication.class, args);
	}
}
