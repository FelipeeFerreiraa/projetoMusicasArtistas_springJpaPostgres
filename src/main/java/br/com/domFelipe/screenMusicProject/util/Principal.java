package br.com.domFelipe.screenMusicProject.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	private Scanner sc = new Scanner(System.in);
	private int escolha = -1;

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
				System.out.println(sb);
				escolha = sc.nextInt();
				sc.nextLine();

				switch (escolha) {

				case 0:
					break;

				case 1:
					System.out.println("11111111111");
					cadastrarArtista();
					break;

				case 2:
					System.out.println("2222222222222");
					cadastrarMusica();
					break;

				case 3:
					System.out.println("33333333333333333");
					listarArtistas();
					break;

				case 4:
					System.out.println("4444444444444444");
					listarMusicas();
					break;

				case 5:
					System.out.println("5555555555555");
					buscarMusicasPorArtistas();
					break;

				case 6:
					System.out.println("666666666");
					pesquisarInformacoesArtista();
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

	public void cadastrarArtista() {

	}

	public void cadastrarMusica() {

	}

	public void listarArtistas() {

	}

	public void listarMusicas() {

	}

	public void buscarMusicasPorArtistas() {

	}

	public void pesquisarInformacoesArtista() {

	}

}
