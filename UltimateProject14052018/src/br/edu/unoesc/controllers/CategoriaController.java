package br.edu.unoesc.controllers;

import java.io.IOException;
import java.util.List;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.banco.CategoriaBanco;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaCategorias;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.principal.MainMain;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CategoriaController {

	@FXML
	private TableView<Categoria> tvCategoria;

	@FXML
	private TableColumn<Categoria, Integer> tcId;

	@FXML
	private TableColumn<Categoria, String> tcNome;

	@FXML
	private Button btnNovaCategoria;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnAlterarCategoria;
	private Categoria categoria = new Categoria();
	private CategoriaDAO categoriadao = new CategoriaArquivo();
	private CategoriaDAO categoriabd = new CategoriaBanco(); /// Meche no Banco

	@FXML
	private void initialize() {
		tcId.setCellValueFactory(new PropertyValueFactory<Categoria, Integer>("codigo"));
		tcNome.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nome"));
		List<Categoria> categorias = categoriabd.listar();
		tvCategoria.setItems(FXCollections.observableArrayList(categorias));
	}

	@FXML
	void AlterarCategoria(ActionEvent event) {
		montaCategoria();
		EstaticosParaCategorias.categoriastatic = this.categoria;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaAlterarCategoria.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void selecionaCategoria(MouseEvent event) {
		if (tvCategoria.getSelectionModel().getSelectedItem() != null) {
			categoria = tvCategoria.getSelectionModel().getSelectedItem();
		}
	}

	void montaCategoria() {
		this.categoria = tvCategoria.getSelectionModel().getSelectedItem();
	}

	@FXML
	void Excluir(ActionEvent event) {
		montaCategoria();
		categoriabd.excluir(categoria);
		categoriadao.excluir(this.categoria);
		tvCategoria.getItems().remove(categoria);
		tvCategoria.refresh();
	}

	@FXML
	void AdicionarCategoria(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaCadastroCategoria.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}