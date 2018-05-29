package br.edu.unoesc.models;

public class ProdutoBuilder {

	private Produto produto = new Produto();

	public Produto getProduto() {
		return this.produto;
	}

	public ProdutoBuilder setCodigo(Integer codigo) {
		produto.setCodigo(codigo);
		return this;
	}

	public ProdutoBuilder setNome(String nome) {
		produto.setNome(nome);
		return this;
	}

	public ProdutoBuilder setCategoria(Categoria categoria) {
		produto.setCategoria(categoria);
		return this;
	}

	public ProdutoBuilder setPreco(Double preco) {
		produto.setPreco(preco);
		return this;
	}

	public ProdutoBuilder setQuantidadeestoque(Integer quantidadeestoque) {
		produto.setQuantidadeestoque(quantidadeestoque);
		return this;
	}

	public ProdutoBuilder setDescricao(String descricao) {
		produto.setDescricao(descricao);
		return this;
	}

}
