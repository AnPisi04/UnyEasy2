package com.mygroup.app.UnyEasy;

import java.time.LocalDate;

public class MateriaPianoStudi {

	private String codice = new String();
	private String nome = new String();
	private String cfu;
	private String user_docente = new String();
	private String codice_corso = new String();
	private String cod_materia;
	private String mat_studente;
	private LocalDate data;
	private String voto;
	
	public String getCodice(){
		return codice;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCfu(){
		return cfu;
	}
	
	public void setCodice(String c){
		codice = c;
	}
	
	public void setNome(String n){
		nome = n;
	}
	
	public void setCfu(String c){
		cfu = c;
	}
	
	public String toString(){
		return (codice + "  " + nome);
	}
	
	public String getUserDocente(){
		return user_docente;
	}
	
	public void setUserDocente(String ud){
		user_docente = ud;
	}
	
	public String getCodiceCorso(){
		return codice_corso;
	}
	
	public void setCodiceCorso(String ud){
		codice_corso = ud;
	}
	
	public void setCodMateria(String s){
		cod_materia = s;
	}
	
	public void setMatStudente(String m) {
		mat_studente = m;
	}
	
	public void setVoto(String v){
		voto = v;
	}
	
	public String getCodMateria(){
		return cod_materia;
	}
	
	public String getMatStudente(){
		return mat_studente;
	}
	
	public String getVoto(){
		return voto;
	}
	
	public void setData() {
		
		data = LocalDate.now();;
	}
	
	public LocalDate getData(){
		return data;
	}
	
}
