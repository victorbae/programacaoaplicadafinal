package br.edu.unoesc.models;

public class CategoriaBuilder {

	private Categoria categoria = new Categoria();

	public CategoriaBuilder setCodigo(Integer codigo) {
		categoria.setCodigo(codigo);
		return this;
	}

	public CategoriaBuilder setNome(String nome) {
		categoria.setNome(nome);

		return this;
	}

	public Categoria getCategoria() {
		return categoria;
	}
}