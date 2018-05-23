package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.Produto;

public class ProdutoTest {

	@Test
	public void deveSetEGetCodigo() throws Exception {
		Produto produto = new Produto();
		produto.setCodigo(1);

		assertEquals(Integer.valueOf(1), produto.getCodigo());
	}

	@Test
	public void deveSetEGetNome() throws Exception {
		Produto produto = new Produto();
		produto.setNome("Cerveja");

		assertEquals("Cerveja", produto.getNome());
	}

	@Test
	public void deveSetEGetPreco() throws Exception {
		Produto produto = new Produto();
		produto.setPreco(Double.valueOf(2.2));

		assertEquals(Double.valueOf(2.2), produto.getPreco());
	}

	@Test
	public void deveSetEGetQntEstoque() throws Exception {
		Produto produto = new Produto();
		produto.setQuantidadeestoque(1);

		assertEquals(Integer.valueOf(1), produto.getQuantidadeestoque());
	}

	@Test
	public void deveSetEGetDescricao() throws Exception {
		Produto produto = new Produto();
		produto.setDescricao("Cerveja");

		assertEquals("Cerveja", produto.getDescricao());
	}

	@Test
	public void deveSetEGetCategoria() throws Exception {
		Produto produto = new Produto();
		Categoria categoria = new Categoria();
		produto.setCategoria(categoria);

		assertEquals(categoria, produto.getCategoria());
	}

	@Test
	public void deveTestarToString() throws Exception {
		Categoria categoria = new Categoria();
		Produto produto = new Produto(1, "p1", categoria, 2.2, 50, "Descricao");

		assertEquals(produto.toString(), produto.getNome());
	}
}