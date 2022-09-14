package com.mygroup.app.UnyEasy;

import java.sql.Timestamp;
import java.util.Date;

public class PrenAppMat {
	
	private String nome_materia;
	private Timestamp data_app;
	private String aula;
	private String tipo;
	private Date data_prenot;
	private String cod_appello;
	private String mat_studente;
	
	public PrenAppMat() {
		
		this.nome_materia = null;
		this.data_app = null;
		this.aula = null;
		this.tipo = null;
		this.data_prenot = null;
		this.cod_appello = null;
		this.mat_studente = null;
		
	}
	
	public void setNomeMateria(String m) {
		this.nome_materia = m;
	}
	
	public String getNomeMateria() {
		return this.nome_materia;
	}
	
	public void setDataApp(Timestamp dApp) {
		this.data_app = dApp;
	}
	
	public Timestamp getDataApp() {
		return this.data_app;
	}
	
	public void setAula(String a) {
		this.aula = a;
	}
	
	public String getAula() {
		return this.aula;
	}
	
	public void setTipo(String t) {
		this.tipo = t;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setDataPren(Date dPren) {
		this.data_prenot = dPren;
	}
	
	public Date getDataPren() {
		return this.data_prenot;
	}
	
	public void setCodAppello(String ap) {
		this.cod_appello = ap;
	}
	
	public String getCodAppello() {
		return this.cod_appello;
	}
	
	public void setMatStudente(String mat) {
		this.mat_studente = mat;
	}
	
	public String getMatStudente() {
		return this.mat_studente;
	}
}
