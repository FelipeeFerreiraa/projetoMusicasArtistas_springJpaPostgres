package br.com.domFelipe.screenMusicProject.util;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.domFelipe.screenMusicProject.model.Artista;
import br.com.domFelipe.screenMusicProject.model.Categoria;
import br.com.domFelipe.screenMusicProject.model.Musica;
import br.com.domFelipe.screenMusicProject.repository.ArtistaRepository;
import br.com.domFelipe.screenMusicProject.repository.MusicaRepository;
import br.com.domFelipe.screenMusicProject.services.ConsultaChatGPT2;

public class Principal {

	private Scanner sc = new Scanner(System.in);
	private int escolha = -1;

	private ArtistaRepository artistaRepository;
	private MusicaRepository musicaRepository;

	public Principal() {
	}

	public Principal(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
		this.artistaRepository = artistaRepository;
		this.musicaRepository = musicaRepository;
	}

	public void exibeMenu() {

		while (escolha != 0) {

			try {

				StringBuilder sb = new StringBuilder();
				sb.append("\n### ScreenMusicProject ###\n\n");
				sb.append("[0] - SAIR\n");
				sb.append("[1] - CADASTRAR ARTISTA\n");
				sb.append("[2] - CADASTRAR MÚSICA\n");
				sb.append("[3] - LISTAR ARTISTAS\n");
				sb.append("[4] - LISTAR MÚSICAS\n");
				sb.append("[5] - BUSCAR MÚSICAS POR ARTISTAS\n");
				sb.append("[6] - PESQUISAR DADOS SOBRE UM ARTISTA\n");
				sb.append("[7] - LISTAR ARTISTAS POR CATEGORIA\n");

				System.out.println(sb);
				escolha = sc.nextInt();
				sc.nextLine();

				switch (escolha) {

				case 0:
					break;

				case 1:
					cadastrarArtista();
					break;

				case 2:
					System.out.println("2222222222222");
					cadastrarMusica();
					break;

				case 3:
					listarArtistas();
					break;

				case 4:
					listarMusicas();
					break;

				case 5:
					buscarMusicasPorArtistas();
					break;

				case 6:
					pesquisarInformacoesArtista();
					break;

				case 7:
					listarArtistasPorCategoria();
					break;

				default:
					System.out.println("VALOR INVÁLIDO!");
					break;

				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("VALOR INVÁLIDO!");

			}

		}

	}

	private void listarArtistasPorCategoria() {
		List<Artista> artistas = artistaRepository.findAll();
		List<Artista> novaLista = artistas.stream().sorted(Comparator.comparing(x -> x.getCategoria()))
				.collect(Collectors.toList());

		novaLista.forEach(x -> System.out.println("Categoria: " + x.getCategoria() + ", Artista: " + x.getNome()));

	}

	public void cadastrarArtista() {
		System.out.printf("INFORME A CATEGORIA:\n\t[SOLO]\n\t[DUPLA]\n\t[BANDA]\n");
		String escolhaCategoria = this.sc.nextLine().toLowerCase();
		String nomeArtista;

		Categoria categoria;
		Artista artista;

		switch (escolhaCategoria) {
		case "solo":
			categoria = Categoria.stringFromCategoria(escolhaCategoria);
			System.out.println("INFORME O NOME DO ARTISTA: ");
			nomeArtista = this.sc.nextLine();
			artista = new Artista(nomeArtista, categoria);
			artistaRepository.save(artista);
			break;

		case "dupla":
			categoria = Categoria.stringFromCategoria(escolhaCategoria);
			System.out.println("INFORME O NOME DA DUPLA: ");
			nomeArtista = this.sc.nextLine();
			artista = new Artista(nomeArtista, categoria);
			artistaRepository.save(artista);
			break;

		case "banda":
			categoria = Categoria.stringFromCategoria(escolhaCategoria);
			System.out.println("INFORME O NOME DA BANDA: ");
			nomeArtista = this.sc.nextLine();
			artista = new Artista(nomeArtista, categoria);
			artistaRepository.save(artista);
			break;

		default:
			break;
		}

	}

	public void cadastrarMusica() {
		List<Artista> listaArtistas = artistaRepository.findAll();
		System.out.println("ARTISTAS:");
		listaArtistas.forEach(x -> System.out.println("\t" + x.getNome()));

		System.out.println("INFORME QUAL ARTISTA DESEJA INSERIR MUSICAS:");
		String nomeArtista = sc.nextLine();

		Optional<Artista> artista = artistaRepository.findByNomeContainsIgnoreCase(nomeArtista);

		if (artista.isPresent()) {
			System.out.println("MUSICA QUE DESEJA INSERIR:");
			String inserirMusica = sc.nextLine();

			System.out.println("MUSICA PERTENCE A QUAL ALBUM? (album/nenhum)");
			String inserirAlbum = sc.nextLine();

			Musica musica = new Musica(inserirMusica, inserirAlbum, artista.get());
			musicaRepository.save(musica);

		} else {
			System.out.println("ARTISTA NÃO ENCONTRADO NO BANCO DE DADOS");
		}

	}

	public void listarArtistas() {

		List<Artista> listaArtistas = artistaRepository.findAll();
		System.out.println("ARTISTAS:");
		listaArtistas.forEach(System.out::println);
		// listaArtistas.forEach(x -> System.out.println(x.getNome()));
	}

	public void listarMusicas() {
		List<Musica> listaArtistas = musicaRepository.findAll();
		System.out.println("MUSICAS:");
		listaArtistas.stream().sorted(Comparator.comparing(m -> m.getArtista().getNome())).collect(Collectors.toList())
				.forEach(System.out::println);

	}

	public void buscarMusicasPorArtistas() {
		List<Artista> listaArtistas = artistaRepository.findAll();
		System.out.println("ARTISTAS:");
		listaArtistas.forEach(x -> System.out.println("\t" + x.getNome()));

		System.out.println("INFORME QUAL ARTISTA DESEJA BUSCAR MUSICAS:");
		String nomeArtista = sc.nextLine();

		Optional<Artista> artista = artistaRepository.findByNomeContainsIgnoreCase(nomeArtista);

		if (artista.isPresent()) {
			List<Musica> musicasArtista = musicaRepository.buscaPorArtista(artista.get());

			musicasArtista.forEach(x -> {
				System.out.println("Musica: " + x.getNome() + ", Artista: " + x.getArtista().getNome() + ", Album: "
						+ x.getAlbum() + ", Categoria: " + x.getArtista().getCategoria().name());
			});

		} else {
			System.out.println("ARTISTA NÃO ENCONTRADO...");
		}

	}

	public void pesquisarInformacoesArtista() {
		System.out.println("INFORME QUAL ARTISTA DESEJA BUSCAR INFORMAÇÕES:");
		String nomeArtista = sc.nextLine();

		String res = ConsultaChatGPT2.realizarPesquisa(nomeArtista).get();
		System.out.println(res);
	}

}
