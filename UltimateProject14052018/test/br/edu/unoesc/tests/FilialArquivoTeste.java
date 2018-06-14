package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.edu.unoesc.arquivos.FilialArquivo;
import br.edu.unoesc.daos.FilialDAO;
import br.edu.unoesc.models.Filial;

public class FilialArquivoTeste extends AbstractLimpaArquivo {

	@Override
	String getNomeArquivo() {
		// TODO Auto-generated method stub
		return "filialteste.ser";
	}

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {
		FilialDAO ff = new FilialArquivo("filialteste.ser");
		Filial fil3 = new Filial();

		ff.inserir(fil3);

		assertTrue(ff.listar().contains(fil3));
		ff.excluir(fil3);

		@SuppressWarnings("unused")
		FilialDAO ff3 = new FilialArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {
		FilialDAO ff = new FilialArquivo("filialteste.ser");
		Filial fil = new Filial();

		ff.inserir(fil);

		ff.excluir(fil);

		assertFalse(ff.listar().contains(fil));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {
		FilialDAO ff = new FilialArquivo("filialteste.ser");
		Filial fil1 = new Filial();

		fil1.setNome("filial");
		ff.inserir(fil1);

		fil1.setNome("filial2");
		ff.alterar(fil1);

		List<Filial> lista = ff.listar();

		for (Filial filial : lista) {
			assertEquals(filial.getNome(), "filial2");
		}
		ff.listar().clear();
	}

}
