package br.edu.unoesc.daos;

import java.util.List;

import br.edu.unoesc.models.Funcionario;

public interface FuncionarioDAO {

	void inserir(Funcionario funcionario);

	void alterar(Funcionario funcionario);

	void excluir(Funcionario funcionario);

	List<Funcionario> listar();
}