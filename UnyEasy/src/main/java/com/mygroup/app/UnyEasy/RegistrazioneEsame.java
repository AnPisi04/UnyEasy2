package com.mygroup.app.UnyEasy;

public class RegistrazioneEsame {
	
	public boolean confermaEsitoEsame(Esame esame, Studente stud, Appello ap) {
		
		Database db = new Database();
		boolean resp;
		
		resp = db.inserisciEsame(esame, stud, ap);
		
		return resp;
		
	}

}
