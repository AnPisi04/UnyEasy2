package com.mygroup.app.UnyEasy;

import java.sql.Date;

public class Studente extends Utente{
	
	private Studente studenteCorrente;
	
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Date data_di_nascita;
	private String email;
	private String telefono;
	private String cod_corso;
	
	public void setStudenteCorrente(Studente st){
		studenteCorrente = st;
	}
	
	public Studente getStudenteCorrente(){
		return studenteCorrente;
	}

	public Studente(){
		
		username = new String();
		password = new String();
		nome = new String();
		cognome = new String();
		email = new String();
		telefono = new String();
		cod_corso = new String();
		
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public Date getNascita() {
		return data_di_nascita;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getTelefono(){
		return telefono;
	}
	
	public String getCodCorso(){
		return cod_corso;
	}
	
	public void setUsername(String user){
		username = user;
	}
	
	public void setPassword(String p){
		password = p;
	}
	
	public void setNome(String n){
		nome = n;
	}
	
	public void setCognome(String c){
		cognome = c;
	}
	
	public void setNascita(Date d) {
		data_di_nascita = d;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	public void setTelefono(String t){
		telefono = t;
	}
	
	public void setCodCorso(String c){
		cod_corso = c;
	}
	
}
