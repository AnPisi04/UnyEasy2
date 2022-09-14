package com.mygroup.app.UnyEasy;

public class Docente extends Utente {
	

	//private static Docente docenteCorrente;
	private  Docente docenteCorrente;
	
	//public static void setDocenteCorrente(Docente doc){
	public void setDocenteCorrente(Docente doc){
		docenteCorrente = doc;
	}
	
	//public static Docente getDocenteCorrente(){
	public Docente getDocenteCorrente(){	
		return docenteCorrente;
	}
	
}
