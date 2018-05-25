package br.edu.unoesc.controllers;

import java.io.IOException;
import java.util.List;

import br.edu.unoesc.arquivos.ProdutoArquivo;
import br.edu.unoesc.banco.CategoriaBanco;
import br.edu.unoesc.banco.ProdutoBanco;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.daos.ProdutoDAO;
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

public class CadastroProdutoController {
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

	private Produto produto;

	private ProdutoDAO produtodao = new ProdutoArquivo();
	private ProdutoDAO produtobd = new ProdutoBanco(); /// Meche no Banco

	// private CategoriaDAO categoriadao = new CategoriaArquivo();
	private CategoriaDAO categoriabd = new CategoriaBanco();
	private List<Produto> produtos;

	@FXML
	private void initialize() {
		populaCombo();
		cbxCategoria.setPromptText("Escolha uma Categoria");

	}

	@FXML
	void cancelar(ActionEvent event) {
		voltaTelaProduto();
	}

	@FXML
	void salvar(ActionEvent event) {
		populaProduto();
		produtodao.inserir(this.produto);
		produtobd.inserir(this.produto); /// Salva no Banco
		voltaTelaProduto();

	}

	void populaProduto() {
		produto = new ProdutoBuilder().setNome(String.valueOf(tfNome.getText()))
				.setDescricao(String.valueOf(tfDescricao.getText())).setPreco(Double.valueOf(tfPreco.getText()))
				.setQuantidadeestoque(Integer.valueOf(tfQuantidadeEstoque.getText()))
				.setCategoria(cbxCategoria.getValue()).setCodigo(geraCodProduto()).getProduto();
	}

	private void populaCombo() {
		for (Categoria categoria : categoriabd.listar()) {
			cbxCategoria.getItems().add(categoria);
		}
	}

	void voltaTelaProduto() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaProduto.fxml"));

		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	Integer geraCodProduto() {
		int aux = 0;
		produtos = produtobd.listar();
		if (produtos == null) {
			return 1;
		}
		for (Produto funss : produtos) {
			if (funss.getCodigo() > aux) {
				aux = funss.getCodigo();
			}
		}
		return aux + 1;
	}
}
