package br.edu.unoesc.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import br.edu.unoesc.models.Filial;
import br.edu.unoesc.models.FuncionarioBuilder;

public class FuncionarioBuilderTest {

	@Test
	public void builderTest() throws Exception {
		Filial f = new Filial();
		FuncionarioBuilder fun = new FuncionarioBuilder();
		fun.setNome(String.valueOf("Joao"));
		fun.setCidade(String.valueOf("Xanxere"));
		fun.setCargo(String.valueOf("Comprador"));
		fun.setDatanascimento(LocalDate.parse("2018-05-05"));
		fun.setTelefone(Long.valueOf(999999));
		fun.setFilial(f);
		fun.setCodigo(1);

		assertEquals(fun.getFuncionario().getNome(), "Joao");
		assertEquals(fun.getFuncionario().getCidade(), "Xanxere");
		assertEquals(fun.getFuncionario().getCargo(), "Comprador");
		assertEquals(fun.getFuncionario().getDatanascimento(), LocalDate.parse("2018-05-05"));
		assertEquals(fun.getFuncionario().getTelefone(), Long.valueOf(999999));
		assertEquals(fun.getFuncionario().getCodigo(), Integer.valueOf("1"));
		assertEquals(fun.getFuncionario().getFilial(), f);

	}

}
