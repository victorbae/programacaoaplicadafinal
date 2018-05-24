package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.Funcionario;

public class FuncionarioTest {
	@Test
	public void deveSetEGetCodigo() throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(1);

		assertEquals(Integer.valueOf(1), funcionario.getCodigo());
	}

	@Test
	public void deveSetEGetCodigoFilial() throws Exception {
		Funcionario funcionario = new Funcionario();
		Filial f = new Filial();
		funcionario.setFilial(f);

		assertEquals(f, funcionario.getFilial());
	}

	@Test
	public void deveSetEGetNome() throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Cervejas");

		assertEquals("Cervejas", funcionario.getNome());
	}

	@Test
	public void deveSetEGetCargo() throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo("Chefe");

		assertEquals("Chefe", funcionario.getCargo());
	}

	@Test
	public void deveSetEGetCidade() throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setCidade("Xanxere");

		assertEquals("Xanxere", funcionario.getCidade());
	}

	@Test
	public void deveSetEGetTelefone() throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setTelefone(Long.parseLong("21564987"));

		assertEquals("21564987", String.valueOf(funcionario.getTelefone()));
	}

	@Test
	public void deveSetEGetData() throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setDatanascimento(LocalDate.of(2010, 3, 7));

		assertEquals(LocalDate.of(2010, 3, 7), funcionario.getDatanascimento());
	}

	@Test
	public void deveTestarContrutorFielsEToString() throws Exception {
		Filial f = new Filial();
		Funcionario funcionario = new Funcionario(1, "Joao", "XXe", "Bebefor", LocalDate.of(2010, 3, 7),
				Long.parseLong("12398764"), f);
		Funcionario funcionario2 = new Funcionario(1, "Joao", "XXe", "Bebefor", LocalDate.parse("2010-03-07"), 12398764,
				1);
		assertEquals(funcionario.toString(), funcionario.getNome());
		assertEquals(funcionario2.toString(), funcionario2.getNome());
	}

	@Test
	public void deveTestarHashCodeEEquals() throws Exception {
		Filial f = new Filial();
		Funcionario funcionario = new Funcionario(1, "Joao", "XXe", "Bebefor", LocalDate.of(2010, 3, 7),
				Long.parseLong("12398764"), f);

		assertTrue(funcionario.hashCode() != 0);
		assertTrue(funcionario.getFilial().hashCode() != 0);
		assertTrue(funcionario.equals(funcionario));
		assertFalse(funcionario.equals(funcionario.getFilial()));
	}
}