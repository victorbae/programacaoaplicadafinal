package br.edu.unoesc.controllers;

import java.io.IOException;

import br.edu.unoesc.arquivos.ProdutoArquivo;
import br.edu.unoesc.banco.ProdutoBanco;
import br.edu.unoesc.daos.ProdutoDAO;
import br.edu.unoesc.estaticosparatelasv.EstaticosParaProdutos;
import br.edu.unoesc.models.Categoria;
import br.edu.unoesc.models.Produto;
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

public class ProdutoController {

	@FXML
	private TableView<Produto> tvproduto;

	@FXML
	private TableColumn<Produto, Integer> tbcCodigo;

	@FXML
	private TableColumn<Produto, String> tbcNome;

	@FXML
	private TableColumn<Produto, Categoria> tbcCategoria;

	@FXML
	private TableColumn<Produto, Double> tbcPreco;

	@FXML
	private TableColumn<Produto, Integer> tbcQuantidadeEstoque;

	@FXML
	private TableColumn<Produto, String> tbcDescricao;

	@FXML
	private Button btnNovoProduto;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnAlterarProduto;

	private Produto produto;
	private ProdutoDAO produtodao = new ProdutoArquivo();
	private ProdutoBanco produtobd = new ProdutoBanco();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		tbcCategoria.setCellValueFactory(new PropertyValueFactory<Produto, Categoria>("categoria"));
		tbcPreco.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
		tbcQuantidadeEstoque.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidadeestoque"));
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("codigo"));
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
		tvproduto.setItems(FXCollections.observableArrayList(produtobd.listar()));
	}

	@FXML
	void AlterarProduto(ActionEvent event) {
		montaProduto();
		EstaticosParaProdutos.produtostatic = this.produto;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaAlterarProduto.fxml"));

		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void Excluir(ActionEvent event) {
		montaProduto();
		produtodao.excluir(produto);
		produtobd.excluir(produto); /// Exclui no Banco
		tvproduto.refresh();
		initialize();

	}

	@FXML
	void NovoProduto(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/edu/unoesc/fxmls/TelaCadastroProduto.fxml"));

		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			MainMain.root.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	void montaProduto() {
		this.produto = tvproduto.getSelectionModel().getSelectedItem();

	}

	@FXML
	void produtoSelecionado(MouseEvent event) {
		this.produto = tvproduto.getSelectionModel().getSelectedItem();
	}

	void montarTela(Produto produto) {
		tbcNome.setText(String.valueOf(produto.getNome()));
		tbcCategoria.setText(String.valueOf(produto.getCategoria()));
		tbcPreco.setText(String.valueOf(produto.getPreco()));
		tbcQuantidadeEstoque.setText(String.valueOf(produto.getQuantidadeestoque()));
		tbcCodigo.setText(String.valueOf(produto.getCodigo()));
		tbcDescricao.setText(String.valueOf(produto.getDescricao()));
	}

}
