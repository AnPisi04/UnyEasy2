package com.mygroup.app.UnyEasy;

import java.util.LinkedList;

public class PrenotazioneStudente {

	public static final int PRENOTAZIONE_GIA_ESISTENTE = Costanti.PRENOTAZIONE_GIA_ESISTENTE;
	public static final int PRENOTAZIONE_INSERITA = Costanti.PRENOTAZIONE_INSERITA;
	

	public int aggiungiPrenotazione(Prenotazione prenotaz) {
		return 0;
	}
	
	public void visualizzaAppelli(Materia mat){
		
		Database db = new Database();
		LinkedList<Appello> appelli = new LinkedList<Appello>();
		
		appelli = db.caricaAppelliMateria(mat);
		
		AppelliDisponibili appDisp = new AppelliDisponibili(appelli, mat);
		
	}
	
	
	public int inserisciPrenotazione(Appello ap){
		
		Database db = new Database();
		Response rsp = new Response();
		int retval;
		
		retval = db.inserisciPrenotazione(Studente.getStudenteCorrente(), ap);
		
		rsp.visualizzaMessaggio(retval);
		
		return retval;
		
	}

}

