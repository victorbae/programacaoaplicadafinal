package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.models.Categoria;

public class CategoriaArquivoTest {

	@Test
	public void insere() throws Exception {
		CategoriaArquivo a = new CategoriaArquivo();

		Categoria c = new Categoria(5, "categoria teste");

		a.inserir(c);

		assertEquals(Integer.valueOf(5), Integer.valueOf(a.listar().size()));

	}

}
