package com.mygroup.app.UnyEasy;

import java.util.Date;

public class Prenotazione {
	
	private String cod_appello;
	private String mat_studente;
	private Date data;
	
	
	public String getCodAppello() {
		return cod_appello;
	}
	
	public void setCodAppello(String codAp) {
		this.cod_appello = codAp;
	}
	
	public String getMatStudente() {
		return mat_studente;
	}
	
	public void setMatStudente(String mStud) {
		this.mat_studente = mStud;
	}
	
	public void setData(Date d){
		data = d;
	}
	
	public Date getData(){
		return data;
	}
	
}
