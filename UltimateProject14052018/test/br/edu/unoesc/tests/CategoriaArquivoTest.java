package br.edu.unoesc.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.models.Categoria;

public class CategoriaArquivoTest {

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {
		CategoriaDAO ct = new CategoriaArquivo("categoriateste.ser");
		Categoria cat = new Categoria();

		ct.inserir(cat);

		assertTrue(ct.listar().contains(cat));
		ct.excluir(cat);

		@SuppressWarnings("unused")
		CategoriaDAO ct3 = new CategoriaArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {
		CategoriaDAO ct = new CategoriaArquivo("categoriateste.ser");
		Categoria cat = new Categoria();

		ct.inserir(cat);

		ct.excluir(cat);

		assertFalse(ct.listar().contains(cat));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {
		CategoriaDAO ct = new CategoriaArquivo("categoriateste.ser");
		Categoria cat = new Categoria();

		cat.setNome("categoria");
		ct.inserir(cat);

		cat.setNome("categoria2");
		ct.alterar(cat);

		assertTrue(ct.listar().contains(cat));
	}
}
