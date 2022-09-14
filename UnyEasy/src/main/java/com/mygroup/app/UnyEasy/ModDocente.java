package com.mygroup.app.UnyEasy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModDocente{
	
	
	public Docente aggiornamentoDati(Docente doc, String email, String tel, String pass){
		
		
		Database db = new Database();
		boolean result = true;
		Docente actualDoc = new Docente();
		
		String espressioneEmail = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*\\.[a-z]{2,4}$";
		Pattern pEmail = Pattern.compile(espressioneEmail);	
		Matcher mEmail = pEmail.matcher(email);
		boolean matchEmailFound = mEmail.matches();
		
		String espressionePass = "((?=.*[0-9])(?=.*[a-zA-Z]).{8,20})";
		Pattern pPass = Pattern.compile(espressionePass);	
		Matcher mPass = pPass.matcher(pass);
		boolean matchPassFound = mPass.matches();
		
		actualDoc.setNome(doc.getNome());
		actualDoc.setCognome(doc.getCognome());
		actualDoc.setEmail(doc.getEmail());
		actualDoc.setTelefono(doc.getTelefono());
		actualDoc.setUsername(doc.getUsername());
		actualDoc.setPassword(doc.getPassword());
		
		
		if (matchEmailFound) 
			actualDoc.setEmail(email);	
		
		
		if(tel.length()==10) 
			actualDoc.setTelefono(tel);
		
		if (matchPassFound) 
			actualDoc.setPassword(pass);
	
			
		//result = db.aggiornaDatiDocente(actualDoc);
		result = db.aggiornaDatiDocente(doc, actualDoc);
		
		if(result)
			return actualDoc;
		else
			return doc;
		
		
	}
	
}

