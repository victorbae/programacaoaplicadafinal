package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.banco.FilialBanco;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaFiliais;
import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.FilialBuilder;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AlterarFilialController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCidade;

	@FXML
	private TextField tfEndereco;

	@FXML
	private TextField tfTelefone;

	@FXML
	private Button btSalvarFilial;

	@FXML
	private Button btCancelar;

	private Filial filialalt = new Filial();
	private FilialDAO filialdao = new FilialArquivo();
	private FilialBanco filialbd = new FilialBanco();

	@FXML
	private void initialize() {
		filialalt = montaFilialDeEstatico();
		montarTela();
	}

	@FXML
	void cancelar(ActionEvent event) {
		voltarTela();
	}

	void montarFilialParaAdd() {
		this.filialalt = new FilialBuilder().setCidade(String.valueOf(tfCidade.getText()))
				.setEndereco(String.valueOf(tfEndereco.getText())).setNome(String.valueOf(tfNome.getText()))
				.setTelefone(Long.valueOf(tfTelefone.getText())).getFilial();
	}

	Filial montaFilialDeEstatico() {
		return EstaticosParaFiliais.filialEstatica;
	}

	void montarTela() {
		tfCidade.setText(filialalt.getCidade());
		tfEndereco.setText(filialalt.getEndereco());
		tfNome.setText(filialalt.getNome());
		tfTelefone.setText(String.valueOf(filialalt.getTelefone()));
	}

	@FXML
	void salvarFilial(ActionEvent event) {
		montarFilialParaAdd();
		filialbd.alterar(filialalt);
		filialdao.alterar(filialalt);
		voltarTela();
	}

	public void voltarTela() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaFilial.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}