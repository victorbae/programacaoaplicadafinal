package br.edu.unoesc.banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.models.Funcionario;

public class FuncionarioBanco implements FuncionarioDAO {

	private String tabela = "funcionarios";

	@Override
	public void inserir(Funcionario funcionario) {
		MecheNoBanco.inserir(tabela,
				"" + funcionario.getCodigo() + ", '" + funcionario.getNome() + "', '" + funcionario.getCidade() + "', '"
						+ funcionario.getCargo() + "', '" + String.valueOf(funcionario.getDatanascimento()) + "', '"
						+ String.valueOf(funcionario.getTelefone()) + "', " + funcionario.getFilial().getCodFilial()
						+ "");
	}

	@Override
	public void excluir(Funcionario funcionario) {
		MecheNoBanco.excluir(tabela, funcionario.getCodigo());
	}

	@Override
	public void alterar(Funcionario funcionario) {
		MecheNoBanco.alterar(tabela,
				"cod = " + funcionario.getCodigo() + ", nome = '" + funcionario.getNome() + "', cidade = '"
						+ funcionario.getCidade() + "', cargo ='" + funcionario.getCargo() + "', dataNascimento='"
						+ String.valueOf(funcionario.getDatanascimento()) + "', telefone = "
						+ Long.valueOf(funcionario.getTelefone()) + ", codFilial = "
						+ funcionario.getFilial().getCodFilial() + "",
				funcionario.getCodigo());
	}

	public List<Funcionario> listar() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		ResultSet rs = MecheNoBanco.listar(tabela);
		try {
			while (rs.next()) {
				Funcionario funn = new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDate.parse(rs.getString(5)), Long.valueOf(rs.getString(6)), rs.getInt(7));
				lista.add(funn);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}