package br.edu.unoesc.controllers;

import java.io.IOException;
import java.time.LocalDate;

import br.edu.unoesc.arquivos.FuncionarioArquivo;
import br.edu.unoesc.banco.FuncionarioBanco;
import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaFuncionarios;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FuncionarioController {

	@FXML
	private TableView<Funcionario> tvfuncionario;

	@FXML
	private TableColumn<Funcionario, String> tbcNome;

	@FXML
	private TableColumn<Funcionario, String> tbcCidade;

	@FXML
	private TableColumn<Funcionario, String> tbcCargo;

	@FXML
	private TableColumn<Funcionario, LocalDate> tbcDataNascimento;

	@FXML
	private TableColumn<Funcionario, Long> tbcTelefone;

	@FXML
	private TableColumn<Funcionario, Filial> tbcFiilial;

	@FXML
	private TableColumn<Funcionario, Integer> tcCodigo;

	@FXML
	private Button btnNovoFuncionario;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnAlterarFuncionario;

	private Funcionario funcionario;
	private FuncionarioDAO funcionariodao = new FuncionarioArquivo();
	private FuncionarioBanco funcionariobd = new FuncionarioBanco();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		tbcCidade.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cidade"));
		tbcCargo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
		tbcDataNascimento.setCellValueFactory(new PropertyValueFactory<Funcionario, LocalDate>("datanascimento"));
		tbcTelefone.setCellValueFactory(new PropertyValueFactory<Funcionario, Long>("telefone"));
		tbcFiilial.setCellValueFactory(new PropertyValueFactory<Funcionario, Filial>("filial"));
		tcCodigo.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("codigo"));
		tvfuncionario.setItems(FXCollections.observableArrayList(funcionariobd.listar()));
	}

	@FXML
	void Excluir(ActionEvent event) {
		montaFuncionario();
		funcionariodao.excluir(funcionario);
		funcionariobd.excluir(funcionario);
		tvfuncionario.refresh();
		initialize();
	}

	@FXML
	void AlterarFuncionario(ActionEvent event) {
		montaFuncionario();
		EstaticosParaFuncionarios.funcionariostatic = this.funcionario;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaAlterarFuncionario.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void NovoFuncionario(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaCadastroFuncionario.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	void montaFuncionario() {
		this.funcionario = tvfuncionario.getSelectionModel().getSelectedItem();
	}

	@FXML
	void funcionarioSelecionado(MouseEvent event) {
		this.funcionario = tvfuncionario.getSelectionModel().getSelectedItem();
	}

	void montarTela(Funcionario funcionario) {
		tbcNome.setText(String.valueOf(funcionario.getNome()));
		tbcCidade.setText(String.valueOf(funcionario.getCidade()));
		tbcCargo.setText(String.valueOf(funcionario.getCargo()));
		tbcDataNascimento.setText(String.valueOf(funcionario.getDatanascimento()));
		tbcTelefone.setText(String.valueOf(funcionario.getTelefone()));
		tbcFiilial.setText(String.valueOf(funcionario.getFilial()));
		tcCodigo.setText(String.valueOf(funcionario.getCodigo()));
	}
}