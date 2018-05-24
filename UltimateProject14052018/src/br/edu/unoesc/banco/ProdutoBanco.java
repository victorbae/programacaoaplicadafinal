package br.edu.unoesc.banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.models.Produto;

public class ProdutoBanco implements ProdutoDAO {
	private String tabela = "produtos";

	@Override
	public void inserir(Produto produto) {
		MecheNoBanco.inserir("produtos",
				"" + produto.getCodigo() + ", '" + produto.getNome() + "', '" + produto.getCategoria().getCodigo()
						+ "', '" + produto.getPreco() + "', '" + produto.getQuantidadeestoque() + "', '"
						+ produto.getDescricao() + "'");

	}

	@Override
	public void excluir(Produto produto) {
		MecheNoBanco.excluir("produtos", produto.getCodigo());

	}

	@Override
	public void alterar(Produto produto) {
		MecheNoBanco.alterar(tabela,
				"cod = " + produto.getCodigo() + ", nome = '" + produto.getNome() + "', categoria = '"
						+ produto.getCategoria().getCodigo() + "', preco= '" + produto.getPreco() + "', qntestoque='"
						+ produto.getQuantidadeestoque() + "', descricao='" + produto.getDescricao() + "'",
				produto.getCodigo());

	}

	@Override
	public List<Produto> listar() {
		List<Produto> lista = new ArrayList<Produto>();
		ResultSet rs = MecheNoBanco.listar(tabela);
		try {
			while (rs.next()) {
				Produto prod = new Produto(rs.getInt(1), rs.getString(2), Integer.valueOf(rs.getInt(3)),
						Double.valueOf(rs.getString(4)), Integer.valueOf(rs.getString(5)), rs.getString(6));
				lista.add(prod);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}