package com.mygroup.app.UnyEasy;

import java.util.LinkedList;

public class LibrettoStudente {

	private Corso cdL = new Corso();
	private LinkedList<Materia> materie = new LinkedList<Materia>();
	private LinkedList<Esame> esami = new LinkedList<Esame>();
	
	public void setCorso(String cod, String nome) {
		cdL.setNome(nome);
		cdL.setCodice(cod);
	}
	
	public Corso getCorso() {
		return cdL;
	}
	
	
	public void setMaterie(LinkedList<Materia> listaMat) {
		
		for(int i=0; i<listaMat.size(); ++i){
			materie.add(listaMat.get(i));
		}
		
	}
	
	public LinkedList<Materia> getMaterie(){
		return materie;
	}
	
	public void setEsami(LinkedList<Esame> listaEs) {
		
		for(int i=0; i<listaEs.size(); ++i){
			esami.add(listaEs.get(i));
		}
		
	}
	
	public LinkedList<Esame> getEsami(){
		return esami;
	}
	
}
