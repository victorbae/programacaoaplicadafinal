package br.edu.unoesc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.unoesc.models.FilialBuilder;

public class FilialBuilderTest {
	
	@Test
	public void builderTest() throws Exception {
		
		FilialBuilder b = new FilialBuilder();
		
		assertNotNull(b.getFilial());
		
		b.setCidade("xanxere");
		assertEquals("xanxere", b.getFilial().getCidade());
		
		
		b.setNome("Alfa bom jesus");
		assertEquals("Alfa bom jesus", b.getFilial().getNome());
		
		b.setTelefone(999L);
		assertEquals(Long.valueOf(999), b.getFilial().getTelefone());
	}

}
