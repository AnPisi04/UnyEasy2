package com.mygroup.app.UnyEasy;

import java.util.LinkedList;

public class VisPianoStudi {

	public Corso caricaCorso(Studente stud) {
		
		Corso corso = new Corso();
		Database db = new Database();
		
		corso = db.caricaCorso(stud);
		
		return corso;
		
	}
	
	public LinkedList<MateriaPianoStudi> caricaMaterie(Corso corso){
		
		LinkedList<MateriaPianoStudi> materie = new LinkedList<MateriaPianoStudi>();
		Database db = new Database();
		
		return materie;
		
	}

}
