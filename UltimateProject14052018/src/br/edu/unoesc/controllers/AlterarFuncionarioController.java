package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.arquivos.FuncionarioArquivo;
import br.edu.unoesc.banco.FuncionarioBanco;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.daos.FuncionarioDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaFuncionarios;
import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.Funcionario;
import br.edu.unoesc.models.FuncionarioBuilder;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AlterarFuncionarioController {

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

	private FilialDAO filialdao = new FilialArquivo();
	private Funcionario funcionarioalt = new Funcionario();
	private FuncionarioDAO funcionariodao = new FuncionarioArquivo();
	private FuncionarioBanco funcionariobd = new FuncionarioBanco();

	@FXML
	private void initialize() {
		funcionarioalt = montaFuncionarioDeEstatico();
		populaCombo();
		montarTela();
	}

	@FXML
	void salvar(ActionEvent event) {
		montarFuncionarioParaAdd();
		funcionariodao.alterar(funcionarioalt);
		funcionariobd.alterar(funcionarioalt);
		voltarTela();
	}

	@FXML
	void cancelar(ActionEvent event) {
		voltarTela();
	}

	void montarFuncionarioParaAdd() {
		this.funcionarioalt = new FuncionarioBuilder().setCodigo(funcionarioalt.getCodigo())
				.setNome(String.valueOf(tfNome.getText())).setCidade(String.valueOf(tfCidade.getText()))
				.setCargo(String.valueOf(tfCargo.getText())).setDatanascimento(dtNascimento.getValue())
				.setTelefone(Long.valueOf(tfTelefone.getText())).setFilial(cbxFilial.getValue()).getFuncionario();
	}

	Funcionario montaFuncionarioDeEstatico() {
		return EstaticosParaFuncionarios.funcionariostatic;
	}

	private void populaCombo() {
		for (Filial filial : filialdao.listar()) {
			cbxFilial.getItems().add(filial);
		}
	}

	void montarTela() {
		tfNome.setText(funcionarioalt.getNome());
		tfCidade.setText(funcionarioalt.getCidade());
		tfCargo.setText(funcionarioalt.getCargo());
		dtNascimento.setValue(funcionarioalt.getDatanascimento());
		tfTelefone.setText(String.valueOf(funcionarioalt.getTelefone()));
		cbxFilial.setValue(funcionarioalt.getFilial());
	}

	public void voltarTela() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaFuncionario.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}