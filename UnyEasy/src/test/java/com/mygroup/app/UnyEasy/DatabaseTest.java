package com.mygroup.app.UnyEasy;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.beans.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DatabaseTest {
	
	@Test
	public void verificaDatiDocenteTest() {
		
		Database db = new Database();
		Docente doc = mock(Docente.class);
		
		when(doc.getUsername()).thenReturn("/");
		when(doc.getPassword()).thenReturn("/");
		
		assertFalse(db.verificaDatiDocente(doc));
		
	}
	
	 /*@Test
	 public void testAssertThrows() {
		 
		 Database db = new Database();
		 
		 db.connetti();
		 
	        assertThrows(Exception.class,
	                () -> db.connetti(), "Errore connessione al database.");
	 }*/
	
	@Test
	public void verificaDatiStudenteTest() {
		
		Database db = new Database();
		Studente stud = mock(Studente.class);
		
		when(stud.getUsername()).thenReturn("/");
		when(stud.getPassword()).thenReturn("/");
		
		assertFalse(db.verificaDatiStudente(stud));
		
	}
	
	/*@Test
	public void aggiornaDatiDocenteTest() {
		
		Docente doc = mock(Docente.class);
		Database db = new Database();
		
		assertTrue(db.aggiornaDatiDocente(doc));
		
		
	}
	
	@Test
	public void aggiornaDatiStudenteTest() {
		
		Studente stud = mock(Studente.class);
		Database db = new Database();
		
		assertTrue(db.aggiornaDatiStudente(stud));
		
		
	}*/
	
	@Test
	public void aggiungiAppelloTest() {
		
		Appello ap = mock(Appello.class);
		Database db = new Database();
		
		String dataEora = "2022-06-11 11:00";
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dataEora));
        Timestamp ts = Timestamp.valueOf(localDateTime);
        
        when(ap.getCodice()).thenReturn("00000022");
        when(ap.getData()).thenReturn(ts);
        when(ap.getAula()).thenReturn("B2");
		when(ap.getTipo()).thenReturn("Orale");
		when(ap.getCodiceMateria()).thenReturn("03232106");
        
       
		assertTrue(db.aggiungiAppello(ap));
		
	}

}
