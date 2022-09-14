package com.mygroup.app.UnyEasy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModStudente{

	public Studente aggiornamentoDati(Studente stud, String email, String tel, String pass){
		
		
		Database db = new Database();
		boolean result = true;
		Studente actualStud = new Studente();
		
		String espressioneEmail = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*\\.[a-z]{2,4}$";
		Pattern pEmail = Pattern.compile(espressioneEmail);	
		Matcher mEmail = pEmail.matcher(email);
		boolean matchEmailFound = mEmail.matches();
		
		String espressionePass = "((?=.*[0-9])(?=.*[a-zA-Z]).{8,20})";
		Pattern pPass = Pattern.compile(espressionePass);	
		Matcher mPass = pPass.matcher(pass);
		boolean matchPassFound = mPass.matches();
		
		actualStud.setNome(stud.getNome());
		actualStud.setCognome(stud.getCognome());
		actualStud.setEmail(stud.getEmail());
		actualStud.setTelefono(stud.getTelefono());
		actualStud.setUsername(stud.getUsername());
		actualStud.setPassword(stud.getPassword());
		
		
		if (matchEmailFound) 
			actualStud.setEmail(email);	
		
		
		if(tel.length()==10) 
			actualStud.setTelefono(tel);
		
		if (matchPassFound) 
			actualStud.setPassword(pass);
	
			
		//result = db.aggiornaDatiStudente(actualStud);
		result = db.aggiornaDatiStudente(stud, actualStud);
		
		if(result)
			return actualStud;
		else
			return stud;
		
		
	}
		
}