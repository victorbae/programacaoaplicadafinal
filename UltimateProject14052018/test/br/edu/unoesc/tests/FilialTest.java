package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.unoesc.models.Categoria;
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

	@Test
	public void deveTestarEqualsEHashCode() throws Exception {
		Filial filial1 = new Filial(1, "teste1", "teste1", "teste1", Long.valueOf(123456789));
		Filial filial2 = new Filial(1, "teste1", "teste1", "teste1", Long.valueOf(123456789));
		Filial filial3 = new Filial(2, "teste2", "teste2", "teste2", Long.valueOf(123456789));
		Filial filial4 = new Filial();

		assertEquals(filial1.hashCode(), filial2.hashCode());
		assertTrue(filial1.equals(filial2));
		assertFalse(filial1.hashCode() == filial3.hashCode());
		assertFalse(filial1.equals(filial3));
		assertFalse(filial1.equals(filial4));
	}
}