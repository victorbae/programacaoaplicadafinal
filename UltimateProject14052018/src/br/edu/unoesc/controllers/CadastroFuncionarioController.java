package br.edu.unoesc.controllers;

import java.io.IOException;
import java.util.List;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.arquivos.FuncionarioArquivo;
import br.edu.unoesc.banco.FuncionarioBanco;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.Funcionario;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastroFuncionarioController {
	@FXML
	private TextField tfCidade;

	@FXML
	private TextField tfTelefone;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCargo;

	@FXML
	private DatePicker dtNascimento;

	@FXML
	private ComboBox<Filial> cbxFilial;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;
	private Funcionario funcionario;
	private FuncionarioDAO funcionariodao = new FuncionarioArquivo();
	private FuncionarioDAO funcionariobd = new FuncionarioBanco();
	private FilialDAO filialdao = new FilialArquivo();
	private List<Funcionario> funcionarios;

	@FXML
	private void initialize() {
		populaCombo();
		cbxFilial.setPromptText("Escolha uma Filial");
	}

	@FXML
	void cancelar(ActionEvent event) {
		voltaTelaFuncionario();
	}

	@FXML
	void salvar(ActionEvent event) {
		populaFuncionario();
		funcionariodao.inserir(this.funcionario);
		funcionariobd.inserir(this.funcionario); /// Salva no Banco
		voltaTelaFuncionario();
	}

	void populaFuncionario() {
		funcionario = new Funcionario();
		funcionario.setNome(String.valueOf(tfNome.getText()));
		funcionario.setCidade(String.valueOf(tfCidade.getText()));
		funcionario.setCargo(String.valueOf(tfCargo.getText()));
		funcionario.setDatanascimento(dtNascimento.getValue());
		funcionario.setTelefone(Long.valueOf(tfTelefone.getText()));
		funcionario.setFilial(cbxFilial.getValue());
		funcionario.setCodigo(geraCodFuncionario());
	}

	private void populaCombo() {
		for (Filial filial : filialdao.listar()) {
			cbxFilial.getItems().add(filial);
		}
	}

	void voltaTelaFuncionario() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaFuncionario.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	Integer geraCodFuncionario() {
		int aux = 0;
		funcionarios = funcionariobd.listar();
		if (funcionarios == null) {
			return 1;
		}
		for (Funcionario funss : funcionarios) {
			if (funss.getCodigo() > aux) {
				aux = funss.getCodigo();
			}
		}
		return aux + 1;
	}
}