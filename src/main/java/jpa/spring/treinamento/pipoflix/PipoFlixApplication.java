package jpa.spring.treinamento.pipoflix;

import jpa.spring.treinamento.pipoflix.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PipoFlixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PipoFlixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
