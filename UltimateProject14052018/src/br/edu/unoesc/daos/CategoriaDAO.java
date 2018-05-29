package br.edu.unoesc.daos;

import java.util.List;

import br.edu.unoesc.models.Categoria;

public interface CategoriaDAO {

	void inserir(Categoria categoria);

	void excluir(Categoria categoria);

	void alterar(Categoria categoria);

	List<Categoria> listar();
}