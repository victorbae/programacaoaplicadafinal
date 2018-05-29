package br.edu.unoesc.banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.models.Filial;

public class FilialBanco implements FilialDAO {

	String tabela = "filiais";

	@Override
	public void inserir(Filial filial) {
		MecheNoBanco.inserir(tabela, (Integer.valueOf(filial.getCodFilial()) + ", '" + filial.getNome() + "', '"
				+ filial.getCidade() + "', '" + filial.getEndereco() + "', " + filial.getTelefone()));
	}

	@Override
	public void excluir(Filial filial) {
		MecheNoBanco.excluir(tabela, filial.getCodFilial());
	}

	@Override
	public void alterar(Filial filial) {
		String query = "cod = " + filial.getCodFilial() + ", nomef = '" + filial.getNome() + "', cidade = '"
				+ filial.getCidade() + "', endereco ='" + filial.getEndereco() + "', telefone = "
				+ filial.getTelefone();
		System.out.println(query);
		MecheNoBanco.alterar(tabela, query, filial.getCodFilial());
	}

	@Override
	public List<Filial> listar() {
		List<Filial> lista = new ArrayList<Filial>();
		ResultSet rs = MecheNoBanco.listar(tabela);
		try {
			while (rs.next()) {
				Filial fill = new Filial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						Long.valueOf(rs.getString(5)));
				lista.add(fill);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}