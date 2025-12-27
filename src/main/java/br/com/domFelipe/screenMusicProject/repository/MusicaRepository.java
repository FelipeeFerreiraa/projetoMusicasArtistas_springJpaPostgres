package br.com.domFelipe.screenMusicProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.domFelipe.screenMusicProject.model.Artista;
import br.com.domFelipe.screenMusicProject.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
	
	@Query("SELECT m FROM Musica m JOIN m.artista a ON a = :artista")
	List<Musica> buscaPorArtista(Artista artista);

}
