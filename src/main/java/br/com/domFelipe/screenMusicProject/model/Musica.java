package br.com.domFelipe.screenMusicProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_musicas")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String album;

	@ManyToOne()
	@JoinColumn(name = "id_artista")
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
