package br.edu.unoesc.banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.models.Categoria;

public class CategoriaBanco implements CategoriaDAO {

	private String tabela = "categoria";

	@Override
	public void inserir(Categoria categoria) {
		MecheNoBanco.inserir(tabela, "" + categoria.getCodigo() + ", '" + categoria.getNome() + "'");
	}

	@Override
	public void excluir(Categoria categoria) {
		MecheNoBanco.excluir(tabela, categoria.getCodigo());
	}

	@Override
	public void alterar(Categoria categoria) {
		String query = "cod = " + categoria.getCodigo() + ", nome = '" + categoria.getNome() + "'";
		System.out.println(query);
		MecheNoBanco.alterar(tabela, query, categoria.getCodigo());
	}

	@Override
	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = MecheNoBanco.listar(tabela);
		try {
			while (rs.next()) {
				Categoria catt = new Categoria(rs.getInt(1), rs.getString(2));
				lista.add(catt);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}