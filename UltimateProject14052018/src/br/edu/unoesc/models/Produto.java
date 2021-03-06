package br.edu.unoesc.models;

import java.io.Serializable;

import br.edu.unoesc.estaticosparatelasv.EstaticosParaProdutos;

public class Produto implements Serializable {

	private static final long serialVersionUID = -7016083357666340769L;
	private Integer codigo;
	private String nome;
	private Categoria categoria;
	private Double preco;
	private Integer quantidadeestoque;
	private String descricao;

	public Produto(Integer codigo, String nome, Categoria categoria, Double preco, Integer quantidadeestoque,
			String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.quantidadeestoque = quantidadeestoque;
		this.descricao = descricao;
	}

	public Produto(Integer codigo, String nome, Integer codcategoria, Double preco, Integer quantidadeestoque,
			String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeestoque = quantidadeestoque;
		this.descricao = descricao;
		this.setCategoria(EstaticosParaProdutos.achaCategoria(codcategoria, this.categoria));
	}

	public Produto() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeestoque() {
		return quantidadeestoque;
	}

	public void setQuantidadeestoque(Integer quantidadeestoque) {
		this.quantidadeestoque = quantidadeestoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}