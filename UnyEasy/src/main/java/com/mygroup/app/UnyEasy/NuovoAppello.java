package com.mygroup.app.UnyEasy;

import java.sql.Timestamp;
import java.util.Date;

public class NuovoAppello {
	
	public boolean creaNuovoAppello(String cod_appello, Timestamp data, String aula, String modalita, String cod_materia) {
		
		Appello ap = new Appello();
		Database db = new Database();
		boolean retval = true;
		
		
		ap.setCodice(cod_appello);
		ap.setData(data);
        ap.setAula(aula);
        ap.setTipo(modalita);
		ap.setCodiceMateria(cod_materia);
		
		retval = db.aggiungiAppello(ap);
		
		//rsp.visualizzaMessaggio(retval);
		
		return retval;
		
	}

}
