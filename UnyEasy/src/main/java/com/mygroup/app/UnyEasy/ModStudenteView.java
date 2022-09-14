package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ModStudenteView{

	private int h = 10;
	private int hL = (8/7)*h;
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	public void modificaDati(final Studente stud) {
		
		JPanel datiStud = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pulsanti = new JPanel();
		JPanel complessivo = new JPanel();
		
		JButton conferma = new JButton("Conferma");
		JButton annulla = new JButton("Annulla");
		
		datiStud.setLayout(new BoxLayout(datiStud, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		left.add(Box.createVerticalStrut(h));
		JLabel matricola = new JLabel("Matricola: ");	matricola.setFont(fontIntest);
		JLabel nome = new JLabel("Nome: ");				nome.setFont(fontIntest);
		JLabel cognome = new JLabel("Cognome: ");		cognome.setFont(fontIntest);
		//JLabel data_nascita = new JLabel("Data di nascita: ");		data_nascita.setFont(fontIntest);
		JLabel email = new JLabel("E-mail: ");			email.setFont(fontIntest);
		JLabel telefono = new JLabel("Telefono: ");		telefono.setFont(fontIntest);
		JLabel password = new JLabel("Password: ");		password.setFont(fontIntest);
		left.add(matricola);								
		left.add(Box.createVerticalStrut(hL));
		left.add(nome);
		left.add(Box.createVerticalStrut(hL));
		left.add(cognome);
		left.add(Box.createVerticalStrut(hL));
		//left.add(data_nascita);
		//left.add(Box.createVerticalStrut(hL));
		left.add(email);
		left.add(Box.createVerticalStrut(hL));
		left.add(telefono);
		left.add(Box.createVerticalStrut(hL));
		left.add(password);
		left.add(Box.createVerticalStrut(hL));
		
		
		JTextField matricolaV = new JTextField(stud.getUsername());
		JTextField nomeV = new JTextField(stud.getNome());		
		JTextField cognomeV = new JTextField(stud.getCognome());

		//Date date = stud.getNascita();  
	    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    //JTextField nascitaV = new JTextField(formatter.format(date));  
	    
		final JTextField emailV = new JTextField(stud.getEmail());
		final JTextField telefonoV = new JTextField(stud.getTelefono());		
		final JTextField passwordV = new JTextField(stud.getPassword());
		
		matricolaV.setEnabled(false);
		nomeV.setEnabled(false);
		cognomeV.setEnabled(false);
		//nascitaV.setEnabled(false);
		emailV.setEnabled(true);
		telefonoV.setEnabled(true);
		passwordV.setEnabled(true);
		
		right.add(Box.createVerticalStrut(h));
		right.add(matricolaV);
		right.add(Box.createVerticalStrut(h));
		right.add(nomeV);
		right.add(Box.createVerticalStrut(h));
		right.add(cognomeV);
		right.add(Box.createVerticalStrut(h));
		//right.add(nascitaV);
		//right.add(Box.createVerticalStrut(h));
		right.add(emailV);
		right.add(Box.createVerticalStrut(h));
		right.add(telefonoV);
		right.add(Box.createVerticalStrut(h));
		right.add(passwordV);
		right.add(Box.createVerticalStrut(h));
		
		datiStud.add(left);
		datiStud.add(right);
		
		pulsanti.add(annulla);
		pulsanti.add(conferma);
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(new JLabel("MODIFICA DEL PROFILO"));
		complessivo.add(Box.createVerticalStrut(2*h));
		complessivo.add(datiStud);
		complessivo.add(Box.createVerticalStrut(5*h));
		complessivo.add(pulsanti);
		complessivo.add(Box.createVerticalGlue());
		
		IntPrincipale.setCenterPanel(complessivo);
		
		
		conferma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				ModStudente modStud = new ModStudente();
				String email = new String();
				String telefono = new String();
				String password = new String();
				Studente studAgg = new Studente();
				
				email = emailV.getText();
				telefono = telefonoV.getText();
				password = passwordV.getText();
				
				studAgg = modStud.aggiornamentoDati(stud, email, telefono, password);
				
				
				ProfiloStudente vis = new ProfiloStudente(stud);
				vis.visualizzaProfilo(studAgg);
				
			}
		});
		
		
		annulla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ProfiloStudente vis = new ProfiloStudente(stud);
				vis.visualizzaProfilo(stud);
			}
		});
		
	}

}
