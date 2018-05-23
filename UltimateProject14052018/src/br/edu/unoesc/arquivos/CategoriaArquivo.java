package br.edu.unoesc.arquivos;

import java.util.List;

import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.models.Categoria;

public class CategoriaArquivo implements CategoriaDAO {
	private CuidaDosArquivos<Categoria> arqui = new CuidaDosArquivos<>("categoria.ser");

	@Override
	public void inserir(Categoria categoria) {
		List<Categoria> categorias = arqui.recuperar();
		categorias.add(categoria);
		arqui.gravar(categorias);
	}

	@Override
	public void alterar(Categoria categoria) {
		List<Categoria> categorias = arqui.recuperar();
		for (Categoria categoriaArquivo : categorias) {
			if (categoriaArquivo.equals(categoria)) {
				categorias.remove(categoriaArquivo);
				categorias.add(categoria);
				break;
			}
		}
		arqui.gravar(categorias);
	}

	@Override
	public void excluir(Categoria categoria) {
		List<Categoria> categorias = arqui.recuperar();
		categorias.remove(categoria);
		arqui.gravar(categorias);
	}

	@Override
	public List<Categoria> listar() {
		return arqui.recuperar();
	}
}