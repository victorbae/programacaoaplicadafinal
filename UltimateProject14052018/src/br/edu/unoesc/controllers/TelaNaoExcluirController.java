package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TelaNaoExcluirController {

	@FXML
	private Button btVoltar;

	@FXML
	void voltar(ActionEvent event) {
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