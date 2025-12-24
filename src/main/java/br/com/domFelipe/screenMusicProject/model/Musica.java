package br.com.domFelipe.screenMusicProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Musica {

	@Id
	private Long id;

	private String nome;
	private String album;

	@OneToMany(mappedBy = "musicas")
	private Artista artista;

	public Musica() {
	}

	public Musica(String nome, String album, Artista artista) {
		this.nome = nome;
		this.album = album;
		this.artista = artista;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getAlbum() {
		return album;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Musica [nome=" + nome + ", album=" + album + ", artista=" + artista + "]";
	}

}
