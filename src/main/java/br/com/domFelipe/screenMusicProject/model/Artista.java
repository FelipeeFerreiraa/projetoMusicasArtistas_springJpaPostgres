package br.com.domFelipe.screenMusicProject.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Artista {

	@Id
	private Long id;

	private String nome;
	private LocalDate nascimento;

	@Enumerated
	private Categoria categoria;

	@ManyToOne()
	private List<Musica> musicas;

	public Artista() {
	}

	public Artista(String nome, LocalDate nascimento) {
		this.nome = nome;
		this.nascimento = nascimento;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Artista [nome=" + nome + ", nascimento=" + nascimento + ", categoria=" + categoria + ", musicas="
				+ musicas + "]";
	}

}
