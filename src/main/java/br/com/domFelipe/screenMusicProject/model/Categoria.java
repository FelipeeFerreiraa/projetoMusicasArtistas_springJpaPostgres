package br.com.domFelipe.screenMusicProject.model;

public enum Categoria {

	SOLO(1, "Solo"), DUPLA(2, "Dupla"), BANDA(3, "Banda");

	private int codigo;
	private String desc;

	Categoria(int codigo, String desc) {
		this.codigo = codigo;
		this.desc = desc;
	}

	public static Categoria stringFromCategoria(String str) {
		for (Categoria categoria : Categoria.values()) {
			if (categoria.desc.equalsIgnoreCase(str)) {
				return categoria;
			}
		}

		throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: ");
	}

}
