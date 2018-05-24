package br.edu.unoesc.controllers;

import java.io.IOException;
import java.util.List;

import br.edu.unoesc.arquivos.CategoriaArquivo;
import br.edu.unoesc.arquivos.ProdutoArquivo;
import br.edu.unoesc.banco.ProdutoBanco;
import br.edu.unoesc.daos.CategoriaDAO;
import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.Produto;
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
	// private FilialDAO filialbd = new FilialBanco(); desnecessario ate o presente
	// momento
	private CategoriaDAO categoriadao = new CategoriaArquivo();
	private List<Produto> produtos;

	@FXML
	private void initialize() {
		populaCombo();
		cbxCategoria.setPromptText("Categoria");

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
		produto = new Produto();
		produto.setNome(String.valueOf(tfNome.getText()));
		produto.setDescricao(String.valueOf(tfDescricao.getText()));
		produto.setPreco(Double.valueOf(tfPreco.getText()));
		produto.setQuantidadeestoque(Integer.valueOf(tfQuantidadeEstoque.getText()));
		produto.setCategoria(cbxCategoria.getValue());
		produto.setCodigo(geraCodProduto());
	}

	private void populaCombo() {
		for (Categoria categoria : categoriadao.listar()) {
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
