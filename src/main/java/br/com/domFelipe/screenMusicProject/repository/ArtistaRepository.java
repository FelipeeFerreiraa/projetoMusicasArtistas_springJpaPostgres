package br.com.domFelipe.screenMusicProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.domFelipe.screenMusicProject.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
	
	Optional<Artista> findByNomeContainsIgnoreCase(String nome);

	@Query("SELECT a FROM Artista a WHERE a.nome ILIKE %:nome% LIMIT 1")
	Optional<Artista> buscaArtistaBanco(String nome);
}
