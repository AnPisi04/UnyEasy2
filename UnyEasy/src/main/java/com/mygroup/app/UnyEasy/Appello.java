package com.mygroup.app.UnyEasy;

import java.sql.Timestamp;
import java.util.Date;

public class Appello {

	private String codice;
	private Timestamp data;
	private String aula = new String();
	private String tipo = new String();
	private String codiceMateria = new String();
	
	// GET
	public String getCodice() {
		return codice;
	}

	public Date getData() {
		return data;
	}
	
	public String getAula() {
		return aula;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String getCodiceMateria(){
		return codiceMateria;
	}
	
	
	//SET
	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public void setTipo(String t){
		tipo = t;
	}

	/*public void setCodiceMateria(Materia m) {
		codiceMateria = m.getCodice();
	}*/
	
	public void setCodiceMateria(String c){
		codiceMateria = c;
	}
	
}

