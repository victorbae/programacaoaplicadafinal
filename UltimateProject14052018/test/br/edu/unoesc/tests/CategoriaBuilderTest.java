package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.CategoriaBuilder;

public class CategoriaBuilderTest {

	@Test
	public void deveTestarSetCodigo() throws Exception {
		Categoria categoria = new CategoriaBuilder().setCodigo(Integer.valueOf(String.valueOf("6")))
				.setNome(String.valueOf("Cervejas")).getCategoria();

		assertEquals(categoria.getCodigo(), Integer.valueOf(String.valueOf("6")));
		assertEquals(categoria.getNome(), String.valueOf("Cervejas"));
	}
}