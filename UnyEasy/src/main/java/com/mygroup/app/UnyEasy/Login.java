package com.mygroup.app.UnyEasy;

public class Login {
	
	final static int DOCENTE = 1;
	final static int STUDENTE = 2;
	final static boolean ERRORE_LOGIN = false;
	final static int OPERAZIONE_OK = 1;
	
	public boolean verificaDatiDocente(Docente utente, int tipoUtente) {
		
		Database db = new Database();
		boolean verifica = ERRORE_LOGIN;
		
		verifica = db.verificaDatiDocente(utente);
			
		return verifica;
		
	}
	
	public boolean verificaDatiStudente(Studente utente, int tipoUtente) {
		
		Database db = new Database();
		boolean verifica = ERRORE_LOGIN;
		
		verifica = db.verificaDatiStudente(utente);
		
		return verifica;
		
	}
	
	public void creaMessaggio(boolean idMess){
		
		Response resp = new Response();
		
		resp.visualizzaMessaggio(idMess);
	}
	
	public Studente caricaDatiStudente(Studente stud){
		
		Database db = new Database();
		Studente newStud = new Studente();
		
		newStud = db.caricaDatiStudente(stud);
		
		return newStud;
		
	}
	
	public Docente caricaDatiDocente(Docente docente){
		
		Database db = new Database();
		Docente newDoc = new Docente();
		
		newDoc = db.caricaDatiDocente(docente);
		
		return newDoc;
		
	}
	
	public void logout(Utente utente){
		
		LoginView lb = new LoginView();
		
		IntPrincipale.resetPanel();
		IntPrincipale.add(lb);
		
	}

}
