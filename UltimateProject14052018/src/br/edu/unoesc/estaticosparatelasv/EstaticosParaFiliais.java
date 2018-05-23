package br.edu.unoesc.estaticosparatelasv;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.models.Filial;

public class EstaticosParaFiliais {
	public static Filial filialEstatica;

	public static Filial achaFilial(Integer codigoFilial, Filial filial) {
		FilialDAO filialdao = new FilialArquivo();
		for (Filial f : filialdao.listar()) {
			if (f.getCodFilial().equals(codigoFilial)) {
				filial = f;
			}
		}
		return filial;
	}
}