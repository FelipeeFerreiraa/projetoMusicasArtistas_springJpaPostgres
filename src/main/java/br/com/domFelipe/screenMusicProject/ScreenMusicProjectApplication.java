package br.com.domFelipe.screenMusicProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.domFelipe.screenMusicProject.util.Principal;

@SpringBootApplication
public class ScreenMusicProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal p1 = new Principal();
		p1.exibeMenu();

	}

}
