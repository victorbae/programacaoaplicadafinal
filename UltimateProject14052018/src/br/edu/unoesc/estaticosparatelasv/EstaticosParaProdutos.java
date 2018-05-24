package br.edu.unoesc.estaticosparatelasv;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.Produto;

public class EstaticosParaProdutos {

	public static Produto produtostatic;

	public static Categoria achaCategoria(Integer codigoCategoria, Categoria categoria) {
		CategoriaDAO categoriadao = new CategoriaArquivo();
		for (Categoria f : categoriadao.listar()) {
			if (f.getCodigo().equals(codigoCategoria)) {
				categoria = f;
			}
		}
		return categoria;
	}
}
