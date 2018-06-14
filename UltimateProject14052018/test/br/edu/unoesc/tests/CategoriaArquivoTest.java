package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.models.Categoria;

public class CategoriaArquivoTest extends AbstractLimpaArquivo {

	@Override
	String getNomeArquivo() {
		// TODO Auto-generated method stub
		return "categoriateste.ser";
	}

	CategoriaDAO ct;
	Categoria cat;

	@Before
	public void intanciaObjeto() {
		ct = new CategoriaArquivo("categoriateste.ser");
		cat = new Categoria();
	}

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {

		ct.inserir(cat);

		assertTrue(ct.listar().contains(cat));
		ct.excluir(cat);

		@SuppressWarnings("unused")
		CategoriaDAO ct3 = new CategoriaArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {

		ct.inserir(cat);

		ct.excluir(cat);

		assertFalse(ct.listar().contains(cat));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {

		cat.setNome("categoria");
		ct.inserir(cat);

		cat.setNome("categoria2");
		ct.alterar(cat);

		List<Categoria> lista = ct.listar();

		for (Categoria categoria : lista) {
			assertEquals(categoria.getNome(), "categoria2");
		}

		ct.listar().clear();

	}
}
