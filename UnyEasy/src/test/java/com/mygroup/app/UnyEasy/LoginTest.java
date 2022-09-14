package com.mygroup.app.UnyEasy;


import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class LoginTest {
	
	@Test
	public void verificaDatiDocenteTest(){
		
		Login login = new Login();
		Docente doc = mock(Docente.class);
		
		when(doc.getUsername()).thenReturn("MarioR");
		when(doc.getPassword()).thenReturn("pass4567");
		
		assertTrue(login.verificaDatiDocente(doc, Login.DOCENTE));
		
	}
	
	
	@Test
	public void verificaDatiStudenteTest() {
		
		Login login = new Login();
		Studente stud = mock(Studente.class);

		when(stud.getUsername()).thenReturn("147283");
		when(stud.getPassword()).thenReturn("pass1234");
		
		assertTrue(login.verificaDatiStudente(stud, Login.STUDENTE));

			
	}

	
	@Test
	public void caricaDatiDocenteTest() {
		
		
		Docente doc = mock(Docente.class);
		Docente docReturn = mock(Docente.class);
		Login log = new Login();
		
		when(doc.getUsername()).thenReturn("MarioR");
		when(doc.getPassword()).thenReturn("pass4567");
		
		docReturn = log.caricaDatiDocente(doc);

		assertEquals(doc.getUsername(), docReturn.getUsername());
		assertEquals(doc.getPassword(), docReturn.getPassword());
	}
	
	@Test
	public void caricaDatiStudenteTest() {
		
		
		Studente stud = mock(Studente.class);
		Studente studReturn = mock(Studente.class);
		Login log = new Login();
		
		when(stud.getUsername()).thenReturn("147283");
		when(stud.getPassword()).thenReturn("pass1234");
		
		studReturn = log.caricaDatiStudente(stud);

		assertEquals(stud.getUsername(), studReturn.getUsername());
		assertEquals(stud.getPassword(), studReturn.getPassword());
	}
	

}

