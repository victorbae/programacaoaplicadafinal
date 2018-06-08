package br.edu.unoesc.tests;

import static org.junit.Assert.*;

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

	@Test
	public void deveTestarEqualsEHashCode() throws Exception {
		Categoria categoria1 = new Categoria(1, "teste1");
		Categoria categoria2 = new Categoria(1, "teste1");
		Categoria categoria3 = new Categoria(2, "teste2");
		Categoria categoria4 = new Categoria();

		assertEquals(categoria1.hashCode(), categoria2.hashCode());
		assertTrue(categoria1.equals(categoria2));
		assertFalse(categoria1.hashCode() == categoria3.hashCode());
		assertFalse(categoria1.equals(categoria3));
		assertFalse(categoria1.equals(categoria4));
	}
}