package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.banco.CategoriaBanco;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaCategorias;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AlterarCategoriaController {

	@FXML
	private Label lblTitulo;

	@FXML
	private TextField tfNome;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	private Categoria categoriaalt = new Categoria();
	private CategoriaDAO categoriadao = new CategoriaArquivo();
	private CategoriaDAO categoriabd = new CategoriaBanco();

	@FXML
	private void initialize() {
		categoriaalt = montaCategoriaDeEstatico();
		montarTela();
	}

	@FXML
	void Cancelar(ActionEvent event) {
		voltaTelaCategoria();
	}

	@FXML
	void Salvar(ActionEvent event) {
		montaCategoriaParaAdd();
		categoriadao.alterar(categoriaalt);
		categoriabd.alterar(categoriaalt);
		voltaTelaCategoria();
	}

	Categoria montaCategoriaDeEstatico() {
		return EstaticosParaCategorias.categoriastatic;
	}

	void montaCategoriaParaAdd() {
		categoriaalt.setNome(String.valueOf(tfNome.getText()));
	}

	void montarTela() {
		tfNome.setText(categoriaalt.getNome());
	}

	void voltaTelaCategoria() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaCategoria.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}