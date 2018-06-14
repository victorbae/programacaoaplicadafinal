package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unoesc.arquivos.FuncionarioArquivo;
import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.models.Funcionario;

public class FuncionarioArquivoTeste extends AbstractLimpaArquivo {

	@Override
	String getNomeArquivo() {
		// TODO Auto-generated method stub
		return "funcionarioteste.ser";
	}

	FuncionarioDAO ff;
	Funcionario fun;

	@Before
	public void intanciaObjeto() {
		ff = new FuncionarioArquivo("funcionarioteste.ser");
		fun = new Funcionario();
	}

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {

		ff.inserir(fun);

		assertTrue(ff.listar().contains(fun));
		ff.excluir(fun);

		@SuppressWarnings("unused")
		FuncionarioDAO ff3 = new FuncionarioArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {

		ff.inserir(fun);

		ff.excluir(fun);

		assertFalse(ff.listar().contains(fun));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {

		fun.setNome("funcionario");
		ff.inserir(fun);

		fun.setNome("funcionario2");
		ff.alterar(fun);

		List<Funcionario> lista = ff.listar();

		for (Funcionario func : lista) {
			assertEquals(func.getNome(), "funcionario2");
		}
		ff.listar().clear();
	}
}
