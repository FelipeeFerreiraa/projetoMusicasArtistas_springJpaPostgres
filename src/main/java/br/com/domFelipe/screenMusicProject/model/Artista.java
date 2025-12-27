package br.com.domFelipe.screenMusicProject.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_artistas")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@OneToMany(mappedBy = "artista")
	private List<Musica> musicas;

	public Artista() {
	}

	public Artista(String nome) {
		this.nome = nome;
	}

	public Artista(String nome, Categoria categoria) {
		this.categoria = categoria;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	@Override
	public String toString() {
		return "Artista [nome=" + nome + ", categoria=" + categoria + "]";
	}

}
