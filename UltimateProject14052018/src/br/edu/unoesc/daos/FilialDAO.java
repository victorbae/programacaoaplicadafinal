package br.edu.unoesc.daos;

import java.util.List;

import br.edu.unoesc.models.Filial;

public interface FilialDAO {

	void inserir(Filial filial);

	void alterar(Filial filial);

	void excluir(Filial filial);

	List<Filial> listar();
}