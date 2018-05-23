package br.edu.unoesc.daos;

import java.util.List;

import br.edu.unoesc.models.Produto;

public interface ProdutoDAO {
	void inserir(Produto produto);

	void alterar(Produto produto);

	void excluir(Produto produto);

	List<Produto> listar();
}