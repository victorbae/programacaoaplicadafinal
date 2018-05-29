package br.edu.unoesc.arquivos;

import java.util.List;

import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.models.Funcionario;

public class FuncionarioArquivo implements FuncionarioDAO {

	private CuidaDosArquivos<Funcionario> arqui = new CuidaDosArquivos<>("funcionario.ser");

	public void inserir(Funcionario funcionario) {
		List<Funcionario> funcionarios = arqui.recuperar();
		funcionarios.add(funcionario);
		arqui.gravar(funcionarios);
	}

	public void alterar(Funcionario funcionario) {
		List<Funcionario> funcionarios = arqui.recuperar();
		for (Funcionario funcionarioArquivo : funcionarios) {
			if (funcionarioArquivo.equals(funcionario)) {
				funcionarios.remove(funcionarioArquivo);
				funcionarios.add(funcionario);
				break;
			}
		}
		arqui.gravar(funcionarios);
	}

	public void excluir(Funcionario funcionario) {
		List<Funcionario> funcionarios = arqui.recuperar();
		funcionarios.remove(funcionario);
		arqui.gravar(funcionarios);
	}

	public List<Funcionario> listar() {
		return arqui.recuperar();
	}
}