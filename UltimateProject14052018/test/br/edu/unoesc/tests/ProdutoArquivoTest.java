package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.edu.unoesc.arquivos.ProdutoArquivo;
import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.models.Produto;

public class ProdutoArquivoTest extends AbstractLimpaArquivo {

	@Override
	String getNomeArquivo() {
		// TODO Auto-generated method stub
		return "produtoteste.ser";
	}

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {
		ProdutoDAO pd = new ProdutoArquivo("produtoteste.ser");
		Produto prod = new Produto();

		pd.inserir(prod);

		assertTrue(pd.listar().contains(prod));
		pd.excluir(prod);

		@SuppressWarnings("unused")
		ProdutoDAO pd3 = new ProdutoArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {
		ProdutoDAO pd = new ProdutoArquivo("produtoteste.ser");
		Produto prod = new Produto();

		pd.inserir(prod);

		pd.excluir(prod);

		assertFalse(pd.listar().contains(prod));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {
		ProdutoDAO pd = new ProdutoArquivo("produtoteste.ser");
		Produto prod = new Produto();

		prod.setNome("produto");
		pd.inserir(prod);

		prod.setNome("produto2");
		pd.alterar(prod);

		List<Produto> lista = pd.listar();

		for (Produto produ : lista) {
			assertEquals(produ.getNome(), "produto2");
		}

		pd.listar().clear();
	}

}
