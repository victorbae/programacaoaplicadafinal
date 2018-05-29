package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.ProdutoBuilder;

public class ProdutoBuilderTest {

	@Test
	public void builderTest() throws Exception {
		Categoria cat = new Categoria();
		ProdutoBuilder produto = new ProdutoBuilder();
		produto.setNome(String.valueOf("brahma"));
		produto.setDescricao(String.valueOf("cerveja boa"));
		produto.setPreco(Double.valueOf(55.55));
		produto.setQuantidadeestoque(Integer.valueOf(30));
		produto.setCategoria(cat);
		produto.setCodigo(1);

		assertEquals(produto.getProduto().getNome(), "brahma");
		assertEquals(produto.getProduto().getDescricao(), "cerveja boa");
		assertEquals(produto.getProduto().getPreco(), Double.valueOf(55.55));
		assertEquals(produto.getProduto().getQuantidadeestoque(), Integer.valueOf(30));
		assertEquals(produto.getProduto().getCodigo(), Integer.valueOf(1));
		assertEquals(produto.getProduto().getCategoria(), cat);

	}

}
