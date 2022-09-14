package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ModDocenteView{

	private int h = 10;
	private int hL = (8/7)*h;
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	public void modificaDati(final Docente doc) {
		
		JPanel datiDoc = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pulsanti = new JPanel();
		JPanel complessivo = new JPanel();
		
		JButton conferma = new JButton("Conferma");
		JButton annulla = new JButton("Annulla");
		
		datiDoc.setLayout(new BoxLayout(datiDoc, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		left.add(Box.createVerticalStrut(h));
		JLabel username = new JLabel("Username: ");	username.setFont(fontIntest);
		JLabel nome = new JLabel("Nome: ");				nome.setFont(fontIntest);
		JLabel cognome = new JLabel("Cognome: ");		cognome.setFont(fontIntest);
		JLabel email = new JLabel("E-mail: ");			email.setFont(fontIntest);
		JLabel telefono = new JLabel("Telefono: ");		telefono.setFont(fontIntest);
		JLabel password = new JLabel("Password: ");		password.setFont(fontIntest); 
		left.add(username);								
		left.add(Box.createVerticalStrut(hL));
		left.add(nome);
		left.add(Box.createVerticalStrut(hL));
		left.add(cognome);
		left.add(Box.createVerticalStrut(hL));
		left.add(email);
		left.add(Box.createVerticalStrut(hL));
		left.add(telefono);
		left.add(Box.createVerticalStrut(hL));
		left.add(password);
		
		left.add(Box.createVerticalStrut(hL));
		
		
		JTextField usernameV = new JTextField(doc.getUsername());
		JTextField nomeV = new JTextField(doc.getNome());		
		JTextField cognomeV = new JTextField(doc.getCognome());
		final JTextField emailV = new JTextField(doc.getEmail());
		final JTextField telefonoV = new JTextField(doc.getTelefono());		
		final JTextField passwordV = new JTextField(doc.getPassword());
		
		usernameV.setEnabled(false);
		nomeV.setEnabled(false);
		cognomeV.setEnabled(false);
		emailV.setEnabled(true);
		telefonoV.setEnabled(true);
		passwordV.setEnabled(true);
		
		right.add(Box.createVerticalStrut(h));
		right.add(usernameV);
		right.add(Box.createVerticalStrut(h));
		right.add(nomeV);
		right.add(Box.createVerticalStrut(h));
		right.add(cognomeV);
		right.add(Box.createVerticalStrut(h));
		right.add(emailV);
		right.add(Box.createVerticalStrut(h));
		right.add(telefonoV);
		right.add(Box.createVerticalStrut(h));
		right.add(passwordV);
		right.add(Box.createVerticalStrut(h));
		
		datiDoc.add(left);
		datiDoc.add(right);
		
		pulsanti.add(annulla);
		pulsanti.add(conferma);
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(new JLabel("MODIFICA DEL PROFILO"));
		complessivo.add(Box.createVerticalStrut(2*h));
		complessivo.add(datiDoc);
		complessivo.add(Box.createVerticalStrut(5*h));
		complessivo.add(pulsanti);
		complessivo.add(Box.createVerticalGlue());
		
		IntPrincipale.setCenterPanel(complessivo);
		
		
		conferma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ModDocente modDoc = new ModDocente();
				String email = new String();
				String telefono = new String();
				String password = new String();
				Docente docAgg = new Docente();
				
				email = emailV.getText();
				telefono = telefonoV.getText();
				password = passwordV.getText();
				
				docAgg = modDoc.aggiornamentoDati(doc, email, telefono, password);
				
				
				ProfiloDocente vis = new ProfiloDocente(doc);
				vis.visualizzaProfilo(docAgg);
			}
		});
		
		
		annulla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ProfiloDocente vis = new ProfiloDocente(doc);
				vis.visualizzaProfilo(doc);
			}
		});
	}
}
