package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.models.Filial;

public class FilialTest {
	@Test
	public void deveSetEGetCodigo() throws Exception {
		Filial filial = new Filial();
		filial.setCodFilial(1);

		assertEquals(Integer.valueOf(1), filial.getCodFilial());
	}

	@Test
	public void deveSetEGetNome() throws Exception {
		Filial filial = new Filial();
		filial.setNome("Filial");

		assertEquals("Filial", filial.getNome());
	}

	@Test
	public void deveSetEGetCidade() throws Exception {
		Filial filial = new Filial();
		filial.setCidade("Xanxere");

		assertEquals("Xanxere", filial.getCidade());
	}

	@Test
	public void deveSetEGetEndereco() throws Exception {
		Filial filial = new Filial();
		filial.setEndereco("Xanxere");

		assertEquals("Xanxere", filial.getEndereco());
	}

	@Test
	public void deveSetEGetConstrutorParametrosToString() throws Exception {
		Filial filial = new Filial(1, "Max Bebidas", "Cidade", "Endereco", Long.valueOf(132456));

		assertEquals(filial.toString(), filial.getNome());
	}

	@Test
	public void deveSetEGetTelefone() throws Exception {
		Filial filial = new Filial();
		filial.setTelefone(Long.valueOf(12345679));

		assertEquals(Long.valueOf(12345679), filial.getTelefone());
	}
}