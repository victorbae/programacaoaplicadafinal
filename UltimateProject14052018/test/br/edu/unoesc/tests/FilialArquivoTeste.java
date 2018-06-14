package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
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

	FilialDAO ff;
	Filial fil3;

	@Before
	public void intanciaObjeto() {
		ff = new FilialArquivo("filialteste.ser");
		fil3 = new Filial();
	}

	@Test
	public void devetestarInsercaoNoArquivo() throws Exception {

		ff.inserir(fil3);

		assertTrue(ff.listar().contains(fil3));
		ff.excluir(fil3);

		@SuppressWarnings("unused")
		FilialDAO ff3 = new FilialArquivo();
	}

	@Test
	public void devetestarExclusaoNoArquivo() throws Exception {

		ff.inserir(fil3);

		ff.excluir(fil3);

		assertFalse(ff.listar().contains(fil3));
	}

	@Test
	public void devetestarAlterarNoArquivo() throws Exception {

		fil3.setNome("filial");
		ff.inserir(fil3);

		fil3.setNome("filial2");
		ff.alterar(fil3);

		List<Filial> lista = ff.listar();

		for (Filial filial : lista) {
			assertEquals(filial.getNome(), "filial2");
		}
		ff.listar().clear();
	}

}
