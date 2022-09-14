package com.mygroup.app.UnyEasy;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ModStudenteTest {

	@Test
	public void aggiornamentoDatiTest() {
		
		Studente stud = mock(Studente.class);
		String email = "emailmodifica11@euniversity.it";
		String tel = "3201111111";
		String password = "pass0000";
		ModStudente mod = new ModStudente();
		
		
		assertEquals(email, mod.aggiornamentoDati(stud, email, tel, password).getEmail());
		assertEquals(tel, mod.aggiornamentoDati(stud, email, tel, password).getTelefono());
		assertEquals(password, mod.aggiornamentoDati(stud, email, tel, password).getPassword());
		
	}
	
	@Test
	public void whenEmailNonValida_expectEmailNonAggiornata() {
		
		Studente stud = mock(Studente.class);
		String email = "nonValida_euniversity.it";
		String tel = "3201122821";
		String password = "pass4567";
		ModStudente mod = new ModStudente();
		
		when(stud.getEmail()).thenReturn("tizianap@euniversity.it");
		
		assertEquals(stud.getEmail(), mod.aggiornamentoDati(stud, email, tel, password).getEmail());
		
	}
	
	@Test
	public void whenTelefonoNonValido_expectTelefonoNonAggiornato() {
		
		Studente stud = mock(Studente.class);
		String email = "tizianap@euniversity.it";
		String tel = "11111111111111111111111111111";
		String password = "pass1234";
		ModStudente mod = new ModStudente();
		
		when(stud.getTelefono()).thenReturn("3202033222");
		
		assertEquals(stud.getTelefono(), mod.aggiornamentoDati(stud, email, tel, password).getTelefono());
		
	}
	
	
	@Test
	public void whenPasswordNonValida_expectPasswordNonAggiornata() {
		
		Studente stud = mock(Studente.class);
		String email = "tizianap@euniversity.it";
		String tel = "3201122821";
		String password = "p";
		ModStudente mod = new ModStudente();
		
		when(stud.getPassword()).thenReturn("pass1234");
		
		assertEquals(stud.getPassword(), mod.aggiornamentoDati(stud, email, tel, password).getPassword());
		
	}
}
