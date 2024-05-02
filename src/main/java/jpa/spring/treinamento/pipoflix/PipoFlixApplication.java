package jpa.spring.treinamento.pipoflix;

import jpa.spring.treinamento.pipoflix.principal.Principal;
import jpa.spring.treinamento.pipoflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PipoFlixApplication implements CommandLineRunner {


	@Autowired
	private SerieRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(PipoFlixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
