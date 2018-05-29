package br.edu.unoesc.models;

public class FilialBuilder {

	private Filial filial = new Filial();

	public Filial getFilial() {
		return filial;
	}

	public FilialBuilder setNome(String nome) {
		filial.setNome(nome);
		return this;
	}

	public FilialBuilder setTelefone(Long telefone) {
		filial.setTelefone(telefone);
		return this;
	}

	public FilialBuilder setCidade(String cidade) {
		filial.setCidade(cidade);
		return this;
	}

	public FilialBuilder setEndereco(String endereco) {
		filial.setEndereco(endereco);
		return this;
	}

	public FilialBuilder setCodigo(Integer codigo) {
		filial.setCodFilial(codigo);
		return this;
	}
}
