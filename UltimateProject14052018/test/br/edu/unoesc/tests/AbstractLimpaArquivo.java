package br.edu.unoesc.tests;

import java.io.File;

import org.junit.Before;

public abstract class AbstractLimpaArquivo {

	@Before
	public void limparAntesDeCadaTeste() {
		try {
			new File(getNomeArquivo()).delete();
			System.out.println("Deletado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao deletar arquivo");
		}
	}

	abstract String getNomeArquivo();

}
