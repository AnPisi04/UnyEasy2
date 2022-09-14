package com.mygroup.app.UnyEasy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ModDocenteTest {

	@Test
	public void aggiornamentoDatiTest() {
		
		Docente doc = mock(Docente.class);
		String email = "emailmodifica11@euniversity.it";
		String tel = "3201122822";
		String password = "pass1111";
		ModDocente mod = new ModDocente();
		
		
		assertEquals(email, mod.aggiornamentoDati(doc, email, tel, password).getEmail());
		assertEquals(tel, mod.aggiornamentoDati(doc, email, tel, password).getTelefono());
		assertEquals(password, mod.aggiornamentoDati(doc, email, tel, password).getPassword());
		
	}
	
	@Test
	public void whenEmailNonValida_expectEmailNonAggiornata() {
		
		Docente doc = mock(Docente.class);
		String email = "nonValida_euniversity.it";
		String tel = "3201122821";
		String password = "pass4567";
		ModDocente mod = new ModDocente();
		
		when(doc.getEmail()).thenReturn("mariorossi22@euniversity.it");
		
		assertEquals(doc.getEmail(), mod.aggiornamentoDati(doc, email, tel, password).getEmail());
		
	}
	
	@Test
	public void whenTelefonoNonValido_expectTelefonoNonAggiornato() {
		
		Docente doc = mock(Docente.class);
		String email = "mariorossi22@euniversity.it";
		String tel = "11111111111111111111111111111";
		String password = "pass4567";
		ModDocente mod = new ModDocente();
		
		when(doc.getTelefono()).thenReturn("3201122821");
		
		assertEquals(doc.getTelefono(), mod.aggiornamentoDati(doc, email, tel, password).getTelefono());
		
	}
	
	
	@Test
	public void whenPasswordNonValida_expectPasswordNonAggiornata() {
		
		Docente doc = mock(Docente.class);
		String email = "mariorossi22@euniversity.it";
		String tel = "3201122821";
		String password = "p";
		ModDocente mod = new ModDocente();
		
		when(doc.getPassword()).thenReturn("pass4567");
		
		assertEquals(doc.getPassword(), mod.aggiornamentoDati(doc, email, tel, password).getPassword());
		
	}

}
