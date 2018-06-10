package br.edu.unoesc.arquivos;

import java.util.List;

import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.models.Produto;

public class ProdutoArquivo implements ProdutoDAO {

	private static final String PRODUTO_SER = "produto.ser";

	private CuidaDosArquivos<Produto> arqui;

	public ProdutoArquivo() {
		arqui = new CuidaDosArquivos<>(PRODUTO_SER);
	}

	public ProdutoArquivo(String arquivo) {
		arqui = new CuidaDosArquivos<>(arquivo);
	}

	public void inserir(Produto produto) {
		List<Produto> produtos = arqui.recuperar();
		produtos.add(produto);
		arqui.gravar(produtos);
	}

	public void alterar(Produto produto) {
		List<Produto> produtos = arqui.recuperar();
		for (Produto produtoArquivo : produtos) {
			if (produtoArquivo.equals(produto)) {
				produtos.remove(produtoArquivo);
				produtos.add(produto);
				break;
			}
		}
		arqui.gravar(produtos);
	}

	public void excluir(Produto produto) {
		List<Produto> produtos = arqui.recuperar();
		produtos.remove(produto);
		arqui.gravar(produtos);
	}

	public List<Produto> listar() {
		return arqui.recuperar();
	}
}