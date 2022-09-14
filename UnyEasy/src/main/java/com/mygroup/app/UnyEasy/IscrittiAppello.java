package com.mygroup.app.UnyEasy;

import java.util.LinkedList;

public class IscrittiAppello {

	public LinkedList<Studente> ottieniIscrittiAdAppello(Appello ap){
		
		LinkedList<Studente> studenti = new LinkedList<Studente>();
		Database db = new Database();
		
		studenti = db.caricaStudentiAppello(ap);
		
		return studenti;
		
	}
	
	public Materia ottieniMateriaAppello(Appello ap) {
		
		Database db = new Database();
		Materia mat = new Materia();
		
		mat = db.caricaMateriaDiAppello(ap);
		
		return mat;
		
	}
	
}
