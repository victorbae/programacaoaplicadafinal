package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.models.Categoria;

public class CategoriaTest {

	@Test
	public void deveSetEGetCodigo() throws Exception {
		Categoria categoria = new Categoria();
		categoria.setCodigo(1);

		assertEquals(Integer.valueOf(1), categoria.getCodigo());
	}

	@Test
	public void deveSetEGetNome() throws Exception {
		Categoria categoria = new Categoria();
		categoria.setNome("Cervejas");

		assertEquals("Cervejas", categoria.getNome());
	}

	@Test
	public void deveTestarConstrutorFielsEToString() throws Exception {
		Categoria categoria = new Categoria(2, "Vinhos");

		assertEquals(categoria.getNome(), categoria.toString());
	}

}