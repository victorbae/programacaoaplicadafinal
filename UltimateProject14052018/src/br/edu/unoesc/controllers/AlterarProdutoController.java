package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.arquivos.ProdutoArquivo;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaProdutos;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.Produto;
import br.edu.unoesc.models.ProdutoBuilder;
import br.edu.unoesc.principal.MainMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AlterarProdutoController {

	@FXML
	private TextField tfQuantidadeEstoque;

	@FXML
	private TextField tfDescricao;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfPreco;

	@FXML
	private ComboBox<Categoria> cbxCategoria;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	private CategoriaDAO categoriadao = new CategoriaArquivo();

	private Produto produtoalt = new Produto();
	private ProdutoDAO produtodao = new ProdutoArquivo();

	@FXML
	private void initialize() {
		produtoalt = montaProdutoDeEstatico();
		populaCombo();
		montarTela();

	}

	@FXML
	void salvar(ActionEvent event) {
		montarProdutoParaAdd();
		produtodao.alterar(produtoalt);
		voltarTela();

	}

	@FXML
	void cancelar(ActionEvent event) {
		voltarTela();

	}

	public void voltarTela() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaProduto.fxml"));

		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	void montarProdutoParaAdd() {
		produtoalt = new ProdutoBuilder().setNome(String.valueOf(tfNome.getText()))
				.setDescricao(String.valueOf(tfDescricao.getText())).setPreco(Double.valueOf(tfPreco.getText()))
				.setQuantidadeestoque(Integer.valueOf(tfQuantidadeEstoque.getText()))
				.setCategoria(cbxCategoria.getValue()).setCodigo(produtoalt.getCodigo()).getProduto();
	}

	Produto montaProdutoDeEstatico() {
		return EstaticosParaProdutos.produtostatic;
	}

	private void populaCombo() {
		for (Categoria categoria : categoriadao.listar()) {
			cbxCategoria.getItems().add(categoria);
		}
	}

	void montarTela() {
		tfNome.setText(produtoalt.getNome());
		tfDescricao.setText(produtoalt.getDescricao());
		tfQuantidadeEstoque.setText(String.valueOf(produtoalt.getQuantidadeestoque()));
		tfPreco.setText(String.valueOf(produtoalt.getPreco()));
		cbxCategoria.setValue(produtoalt.getCategoria());
	}

}
