package br.com.domFelipe.screenMusicProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.domFelipe.screenMusicProject.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
