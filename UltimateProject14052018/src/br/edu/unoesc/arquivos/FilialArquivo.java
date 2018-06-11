package br.edu.unoesc.arquivos;

import java.util.List;

import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.models.Filial;

public class FilialArquivo implements FilialDAO {

	private static final String FILIAL_SER = "filial.ser";

	private CuidaDosArquivos<Filial> arqui;

	public FilialArquivo() {
		arqui = new CuidaDosArquivos<>(FILIAL_SER);
	}

	public FilialArquivo(String arquivo) {
		arqui = new CuidaDosArquivos<>(arquivo);
	}

	public void inserir(Filial filial) {
		List<Filial> filials = arqui.recuperar();
		filials.add(filial);
		arqui.gravar(filials);
	}

	public void alterar(Filial filial) {
		List<Filial> filials = arqui.recuperar();
		for (Filial filialArquivo : filials) {
			if (filialArquivo.getCodFilial() == filial.getCodFilial()) {
				filials.remove(filialArquivo);
				filials.add(filial);
				break;
			}
		}
		arqui.gravar(filials);
	}

	public void excluir(Filial filial) {
		List<Filial> filials = arqui.recuperar();
		filials.remove(filial);
		arqui.gravar(filials);
	}

	public List<Filial> listar() {
		return arqui.recuperar();
	}
}