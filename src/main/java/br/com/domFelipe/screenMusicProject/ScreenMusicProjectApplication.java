package br.com.domFelipe.screenMusicProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.domFelipe.screenMusicProject.repository.ArtistaRepository;
import br.com.domFelipe.screenMusicProject.repository.MusicaRepository;
import br.com.domFelipe.screenMusicProject.util.Principal;

@SpringBootApplication
public class ScreenMusicProjectApplication implements CommandLineRunner {

	@Autowired()
	private ArtistaRepository artistaRepository;

	@Autowired()
	private MusicaRepository musicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal p1 = new Principal(artistaRepository, musicaRepository);
		p1.exibeMenu();

	}

}
