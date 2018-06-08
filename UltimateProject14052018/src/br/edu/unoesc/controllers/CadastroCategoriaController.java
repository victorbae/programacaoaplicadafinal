package br.edu.unoesc.controllers;

import java.io.IOException;
import java.util.List;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.CategoriaBuilder;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastroCategoriaController {

	@FXML
	private TextField tfNome;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;
	private Categoria categoria;
	private CategoriaDAO categoriadao = new CategoriaArquivo();
	private List<Categoria> categorias;

	@FXML
	void Salvar(ActionEvent event) {
		populaCategoria();
		categoriadao.inserir(this.categoria);
		voltaTelaCategoria();
	}

	@FXML
	void Cancelar(ActionEvent event) {
		voltaTelaCategoria();
	}

	void populaCategoria() {
		this.categoria = new CategoriaBuilder().setCodigo(geraCodCategoria()).setNome(String.valueOf(tfNome.getText()))
				.getCategoria();
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

	Integer geraCodCategoria() {
		int aux = 0;
		categorias = categoriadao.listar();
		if (categorias == null) {
			return 1;
		}
		for (Categoria categoriass : categorias) {
			if (categoriass.getCodigo() > aux) {
				aux = categoriass.getCodigo();
			}
		}
		return aux + 1;
	}
}