package com.mygroup.app.UnyEasy;

public class ModificaAppello {
	
	public boolean modificaInformazioniAppello(Appello ap) {
		
		Database db = new Database();
		boolean resp = true;
		
		resp = db.aggiornaDatiAppello(ap);
		
		return resp;
		
	}

}
