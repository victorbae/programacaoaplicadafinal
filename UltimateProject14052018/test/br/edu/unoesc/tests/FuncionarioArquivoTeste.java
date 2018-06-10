package br.edu.unoesc.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.unoesc.arquivos.FuncionarioArquivo;
import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.models.Funcionario;

public class FuncionarioArquivoTeste {

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {
		FuncionarioDAO ff = new FuncionarioArquivo("funcionarioteste.ser");
		Funcionario fun = new Funcionario();

		ff.inserir(fun);

		assertTrue(ff.listar().contains(fun));
		ff.excluir(fun);

		@SuppressWarnings("unused")
		FuncionarioDAO ff3 = new FuncionarioArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {
		FuncionarioDAO ff = new FuncionarioArquivo("funcionarioteste.ser");
		Funcionario fun = new Funcionario();

		ff.inserir(fun);

		ff.excluir(fun);

		assertFalse(ff.listar().contains(fun));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {
		FuncionarioDAO ff = new FuncionarioArquivo("funcionarioteste.ser");
		Funcionario fun = new Funcionario();

		fun.setNome("funcionario");
		ff.inserir(fun);

		fun.setNome("funcionario2");
		ff.alterar(fun);

		assertTrue(ff.listar().contains(fun));
	}
}
