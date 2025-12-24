package br.com.domFelipe.screenMusicProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.domFelipe.screenMusicProject.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
