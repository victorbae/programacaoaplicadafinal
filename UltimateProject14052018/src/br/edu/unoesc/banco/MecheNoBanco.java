package br.edu.unoesc.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MecheNoBanco {

	private static String server = "localhost";
	private static String port = "3306";
	private static String database = "progaplicada";
	private static String user = "root";
	private static String passwd = "root";
	private static String url = "jdbc:mysql://" + server + ":" + port + "/" + database
			+ "?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static Connection con;
	private static Statement stmt;

	public static void abreconexao() throws SQLException {
		MecheNoBanco.con = DriverManager.getConnection(url, user, passwd);
		MecheNoBanco.stmt = con.createStatement();
	}

	public static void fechaconexao() throws SQLException {
		MecheNoBanco.stmt.close();
		MecheNoBanco.con.close();
	}

	public static void inserir(String tabela, String values) {
		try {
			stmt.executeUpdate("INSERT INTO " + tabela + " VALUES(" + values + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void excluir(String tabela, int codigo) {
		try {
			stmt.executeUpdate("DELETE FROM `" + tabela + "` WHERE `cod` = " + codigo + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alterar(String tabela, String values, Integer cod) {
		try {
			stmt.executeUpdate("UPDATE " + tabela + " set " + values + " where cod = " + cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet listar(String tabela) {
		ResultSet rsaux = null;
		try {
			ResultSet rs = stmt.executeQuery("SELECT * from " + tabela + "");
			rsaux = rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsaux;
	}
}