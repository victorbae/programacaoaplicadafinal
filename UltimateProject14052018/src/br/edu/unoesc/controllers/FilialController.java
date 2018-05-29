package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.banco.FilialBanco;
import br.edu.unoesc.banco.FuncionarioBanco;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaFiliais;
import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.Funcionario;
import br.edu.unoesc.principal.MainMain;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FilialController {

	@FXML
	private TableColumn<Filial, Integer> tblCodigo;

	@FXML
	private TableColumn<Filial, String> tblNome;

	@FXML
	private TableColumn<Filial, String> tblCidade;

	@FXML
	private TableColumn<Filial, String> tblEndereco;

	@FXML
	private TableColumn<Filial, Long> tblTelefone;

	@FXML
	private TableView<Filial> tblFiliais;

	@FXML
	private Button btNovaFilial;

	@FXML
	private Button btExcluirFilial;

	@FXML
	private Button btAlterarFilial;

	private FilialDAO filialdao = new FilialArquivo();
	private Filial filial = new Filial();
	// private FuncionarioDAO funcionariodao = new FuncionarioArquivo();
	private FuncionarioDAO funcionariobd = new FuncionarioBanco();
	private FilialDAO filialbd = new FilialBanco(); /// Meche no Banco

	@FXML
	private void initialize() {
		tblCodigo.setCellValueFactory(new PropertyValueFactory<Filial, Integer>("codFilial"));
		tblNome.setCellValueFactory(new PropertyValueFactory<Filial, String>("nome"));
		tblCidade.setCellValueFactory(new PropertyValueFactory<Filial, String>("cidade"));
		tblEndereco.setCellValueFactory(new PropertyValueFactory<Filial, String>("endereco"));
		tblTelefone.setCellValueFactory(new PropertyValueFactory<Filial, Long>("telefone"));
		tblFiliais.setItems(FXCollections.observableArrayList(filialbd.listar()));
	}

	@FXML
	void alterar(ActionEvent event) {
		montaFilial();
		EstaticosParaFiliais.filialEstatica = filial;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaAlteraFilial.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		montaFilial();
		if (verificaSePodeExcluir()) {
			filialdao.excluir(filial);
			filialbd.excluir(filial); /// Exclui no Banco
			tblFiliais.refresh();
			initialize();
		} else {
			telaNaoPodeExcluir();
		}
	}

	@FXML
	void novaFilial(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaCadastroFilial.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	Filial montaFilial() {
		return filial = tblFiliais.getSelectionModel().getSelectedItem();
	}

	boolean verificaSePodeExcluir() {
		for (Funcionario funcionario : funcionariobd.listar()) {
			if (funcionario.getFilial().getCodFilial().equals(filial.getCodFilial())) {
				return false;
			}
		}
		return true;
	}

	void telaNaoPodeExcluir() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaNaoPodeExcluir.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}