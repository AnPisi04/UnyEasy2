package com.mygroup.app.UnyEasy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class DBConnectionTest {
	
	
	/* Statement st;
	 Connection con;

	@Test
	public void connettiTest() {
		
		DBConnection db = new DBConnection();
		Statement state = null;
		
		
		state = db.connetti();
		
		
		assertFalse(state.equals(null));
		
	}

	
	// test comportamento quando i dati inseriti per il docente non sono presenti nel database
	@Test
	public void whenDatiDocenteNotFound_expectReturnFalse() {
	
		Docente doc = mock(Docente.class);
		DBConnection db = new DBConnection();
		
		
		when(doc.getUsername()).thenReturn("Mario");
		when(doc.getPassword()).thenReturn("pass4567");
		
		boolean resp = db.verificaDatiDocente(doc);
		
		
		assertFalse(resp);
		
	}
	
	
	// test comportamento quando i dati inseriti per lo studente non sono presenti nel database
	@Test
	public void whenDatiStudenteNotFound_expectReturnFalse() {
		
		Studente stud = mock(Studente.class);
		DBConnection db = new DBConnection();
		
		when(stud.getUsername()).thenReturn("111111");
		when(stud.getPassword()).thenReturn("pass");
		
		boolean resp = db.verificaDatiStudente(stud);
		
		
		assertFalse(resp);
		
	}
	
	
	@Test
	public void whenCaricamentoDocenteNoCorrect_expectReturnNoDocente() {
		
		Docente doc = mock(Docente.class);
		Docente docOttenuto = mock(Docente.class);
		DBConnection db = new DBConnection();
		
		when(doc.getUsername()).thenReturn("Mario");
		when(doc.getPassword()).thenReturn("pass4567");
		
		docOttenuto = db.caricaDatiDocente(doc);
		
		assertNotEquals(doc.getUsername(),docOttenuto.getUsername());
		assertNotEquals(doc.getPassword(), docOttenuto.getPassword());
		
	}
	
	
		
	
	@Test
	public void aggiornaDatiDocenteTest() {
		
		Docente docAttuale = mock(Docente.class);
		DBConnection db = new DBConnection();
		
		
		when(docAttuale.getUsername()).thenReturn("MarioR");
		when(docAttuale.getPassword()).thenReturn("pass4567");
		when(docAttuale.getNome()).thenReturn("Mario");
		when(docAttuale.getCognome()).thenReturn("Rossi");
		when(docAttuale.getEmail()).thenReturn("mariorossi22@euniversity.it");
		when(docAttuale.getTelefono()).thenReturn("3201122821");

		assertEquals(docAttuale, db.aggiornaDatiDocente(docAttuale));
		
	}
	
	
	@Test
	public void caricaMateriaDiAppelloTest() {
		
		DBConnection db = new DBConnection();
		Appello ap = mock(Appello.class);
		Materia mat = mock(Materia.class);
		
		when(ap.getCodice()).thenReturn("78945612");
		when(mat.getCodice()).thenReturn("03232106");
		
		assertEquals(mat.getCodice(), db.caricaMateriaDiAppello(ap).getCodice());
		
		
	}
	
	

	@Test
	public void caricaNumeroIscrittiTest() {
		
		DBConnection db = new DBConnection();
		Appello ap = mock(Appello.class);
		
		when(ap.getCodice()).thenReturn("78945612");
		
		assertNotNull(db.caricaNumeroIscritti(ap));
		
	}

	
	*/
	

}
