package br.edu.unoesc.models;

import java.time.LocalDate;

public class FuncionarioBuilder {

	private Funcionario funcionario = new Funcionario();

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public FuncionarioBuilder setNome(String nome) {
		funcionario.setNome(nome);
		return this;
	}

	public FuncionarioBuilder setCodigo(Integer codigo) {
		funcionario.setCodigo(codigo);
		return this;
	}

	public FuncionarioBuilder setCidade(String cidade) {
		funcionario.setCidade(cidade);
		return this;
	}

	public FuncionarioBuilder setCargo(String cargo) {
		funcionario.setCargo(cargo);
		return this;
	}

	public FuncionarioBuilder setFilial(Filial filial) {
		funcionario.setFilial(filial);
		return this;
	}

	public FuncionarioBuilder setDatanascimento(LocalDate datanascimento) {
		funcionario.setDatanascimento(datanascimento);
		return this;
	}

	public FuncionarioBuilder setTelefone(Long telefone) {
		funcionario.setTelefone(telefone);
		return this;
	}
}
