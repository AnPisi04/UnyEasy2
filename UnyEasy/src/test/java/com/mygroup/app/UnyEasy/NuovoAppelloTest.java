package com.mygroup.app.UnyEasy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class NuovoAppelloTest {

	@Disabled
	@Test
	public void creaNuovoAppelloTest() {
		
		//NuovoAppello newApp = mock(NuovoAppello.class);
		NuovoAppello newApp = new NuovoAppello();
		
		String dataEora = "2022-06-11 10:00";
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dataEora));
        Timestamp ts = Timestamp.valueOf(localDateTime);
		
		String codice_appello = "00000001";
        Timestamp data = ts;
        String aulaAp = "B2";
        String modalita = "Orale";
        String cod_materia = "03232106";
        
        assertTrue(newApp.creaNuovoAppello(codice_appello, data, aulaAp, modalita, cod_materia));
	}

}
