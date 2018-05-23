package br.edu.unoesc.banco;

import java.util.List;

import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.models.Produto;

public class ProdutoBanco implements ProdutoDAO {

	@Override
	public void inserir(Produto produto) {
		MecheNoBanco.inserir("produtos", "" + produto.getCodigo() + ", '" + produto.getNome() + "'");

	}

	@Override
	public void excluir(Produto produto) {
		MecheNoBanco.excluir("produtos", produto.getCodigo());

	}

	@Override
	public void alterar(Produto produto) {
		excluir(produto);
		inserir(produto);

	}

	@Override
	public List<Produto> listar() {
		return null;
	}
}