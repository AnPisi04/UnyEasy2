package com.mygroup.app.UnyEasy;

import java.util.LinkedList;

public class AppelliDocente {
	
	LinkedList<Appello> appelli = new LinkedList<Appello>();
	
	public LinkedList<Appello> ottieniListaAppelliDocente(Docente docente){
		
		Database db = new Database();
		
		
		appelli = db.caricaAppelliDocente(docente);
		
		return appelli;
	}

}
