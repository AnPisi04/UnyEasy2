package com.mygroup.app.UnyEasy;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AppelliDocenteTest {
	
	@Test
	public void ottieniListaAppelliDocente() {
		
		AppelliDocente apDoc = new AppelliDocente();
		Docente doc = mock(Docente.class);
		
		when(doc.getUsername()).thenReturn("MarioR");
		assertNotNull(apDoc.ottieniListaAppelliDocente(doc));
		
	}
	
	
/*	@Test
	public void ottieniMateriaAppelloTest() {
		
		AppelliDocente apDoc = new AppelliDocente();
		Appello ap = mock(Appello.class);
		
		assertNotNull(apDoc.ottieniMateriaAppello(ap));
		
	}
	
	
	@Test
	public void ottieniNumeroIscrittiTest() {
		
		AppelliDocente apDoc = new AppelliDocente();
		Appello ap = mock(Appello.class);
		
		assertNotNull(apDoc.ottieniNumeroIscritti(ap));
		
	}*/

}
