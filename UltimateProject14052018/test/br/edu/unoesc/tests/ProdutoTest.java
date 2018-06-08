package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.Funcionario;
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

	@Test
	public void deveTestarEqualsEHashCode() throws Exception {

		Produto produto1 = new Produto(1, "teste1", 1, Double.valueOf("123456789"), 1, "teste1");
		Produto produto2 = new Produto(1, "teste1", 1, Double.valueOf("123456789"), 1, "teste1");
		Produto produto3 = new Produto(2, "teste2", 2, Double.valueOf("123456789"), 2, "teste2");
		Produto produto4 = new Produto();

		assertEquals(produto1.hashCode(), produto2.hashCode());
		assertTrue(produto1.equals(produto2));
		assertFalse(produto1.hashCode() == produto3.hashCode());
		assertFalse(produto1.equals(produto3));
		assertFalse(produto1.equals(produto4));
	}

}