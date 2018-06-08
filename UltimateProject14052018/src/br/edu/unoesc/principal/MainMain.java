package br.edu.unoesc.principal;

import java.sql.SQLException;

import br.edu.unoesc.estaticosparatelasv.EstaticosParaFiliais;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMain extends Application {

	public static BorderPane root;
	EstaticosParaFiliais filiais = new EstaticosParaFiliais();

	public void start(Stage primaryStage) throws Exception {
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("/br/edu/unoesc/fxmls/PrimeiraTela.fxml"));
			Scene scene = new Scene(root, 925, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Rain Bebidas");
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("file:img/beer.png"));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaWelCome.fxml"));
			AnchorPane agenciaView = (AnchorPane) loader.load();
			root.setCenter(agenciaView);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		launch(args);
	}

	public static BorderPane getRoot() {
		return root;
	}
}