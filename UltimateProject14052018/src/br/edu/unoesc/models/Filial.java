package br.edu.unoesc.models;

import java.io.Serializable;

public class Filial implements Serializable {

	private static final long serialVersionUID = 1546836263113840580L;
	private Integer codFilial;
	private String nomefilial;
	private String cidade;
	private String endereco;
	private Long telefone;

	public Filial() {
	}

	public Filial(Integer codFilial, String nome, String cidade, String endereco, Long telefone) {
		super();
		this.codFilial = codFilial;
		this.nomefilial = nome;
		this.cidade = cidade;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(Integer codFilial) {
		this.codFilial = codFilial;
	}

	public String getNome() {
		return nomefilial;
	}

	public void setNome(String nome) {
		this.nomefilial = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFilial == null) ? 0 : codFilial.hashCode());
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
		Filial other = (Filial) obj;
		if (codFilial == null) {
			if (other.codFilial != null)
				return false;
		} else if (!codFilial.equals(other.codFilial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nomefilial;
	}
}