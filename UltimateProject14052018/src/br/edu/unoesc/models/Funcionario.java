package br.edu.unoesc.models;

import java.io.Serializable;
import java.time.LocalDate;

import br.edu.unoesc.estaticosparatelasv.EstaticosParaFiliais;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = -8330736281192986059L;
	private String nome;
	private String cidade;
	private String cargo;
	private LocalDate datanascimento;
	private Long telefone;
	private Filial filial;
	private Integer codigo;

	public Funcionario() {
		super();
	}

	public Funcionario(Integer i, String string1, String string2, String string3, LocalDate date, long l, Integer j) {
		this.codigo = i;
		this.nome = string1;
		this.cidade = string2;
		this.cargo = string3;
		this.datanascimento = LocalDate.parse(String.valueOf(date));
		this.telefone = l;
		this.setFilial(EstaticosParaFiliais.achaFilial(j, this.filial));
	}

	public Funcionario(Integer codigo, String nome, String cidade, String cargo, LocalDate datanascimento,
			Long telefone, Filial filial) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.cargo = cargo;
		this.datanascimento = datanascimento;
		this.telefone = telefone;
		this.setFilial(filial);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
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
		Funcionario other = (Funcionario) obj;
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