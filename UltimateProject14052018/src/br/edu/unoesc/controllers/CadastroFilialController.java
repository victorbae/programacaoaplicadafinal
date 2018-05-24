package br.edu.unoesc.controllers;

import java.io.IOException;
import java.util.List;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.banco.FilialBanco;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.FilialBuilder;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastroFilialController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCidade;

	@FXML
	private TextField tfEndereco;

	@FXML
	private TextField tfTelefone;

	@FXML
	private Button btAddFilial;

	@FXML
	private Button btCancelar;

	private Filial filial = new Filial();
	private FilialDAO filialdao = new FilialArquivo();
	private FilialDAO filialbd = new FilialBanco();
	private List<Filial> filiais;

	@FXML
	void addFilial(ActionEvent event) {
		montarFilialParaAdd();
		filialdao.inserir(filial);
		filialbd.inserir(filial);
		voltaTelaFilial();
	}

	@FXML
	void cancelar(ActionEvent event) {
		voltaTelaFilial();
	}

	void montarFilialParaAdd() {
		this.filial = new FilialBuilder().setCidade(String.valueOf(tfCidade.getText()))
				.setCodigo(Integer.valueOf(geraCodFilial())).setEndereco(String.valueOf(tfEndereco.getText()))
				.setNome(String.valueOf(tfNome.getText())).setTelefone(Long.valueOf(tfTelefone.getText())).getFilial();
	}

	void voltaTelaFilial() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaFilial.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	Integer geraCodFilial() {
		int aux = 0;
		filiais = filialbd.listar();
		for (Filial filialss : filiais) {
			if (filialss.getCodFilial() == null) {
				return 1;
			}
		}
		for (Filial filialss : filiais) {
			if (filialss.getCodFilial() > aux) {
				aux = filialss.getCodFilial();
			}
		}
		return aux + 1;
	}
}