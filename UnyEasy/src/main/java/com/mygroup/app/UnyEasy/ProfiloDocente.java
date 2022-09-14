package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfiloDocente extends Profilo {
	
	private static final long serialVersionUID = 1L;
	int h = 15;
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	public ProfiloDocente(Docente docente){
		
		//Docente docC = docente.getDocenteCorrente();
		JPanel complessivo = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		left.add(Box.createVerticalStrut(h));
		JLabel id = new JLabel("ID Utente: ");			id.setFont(fontIntest);
		JLabel nome = new JLabel("Nome: ");				nome.setFont(fontIntest);
		JLabel cognome = new JLabel("Cognome: ");		cognome.setFont(fontIntest);
		JLabel email = new JLabel("E-mail: ");			email.setFont(fontIntest);
		JLabel telefono = new JLabel("Telefono: ");		telefono.setFont(fontIntest);
		left.add(id);								
		left.add(Box.createVerticalStrut(h));
		left.add(nome);
		left.add(Box.createVerticalStrut(h));
		left.add(cognome);
		left.add(Box.createVerticalStrut(h));
		left.add(email);
		left.add(Box.createVerticalStrut(h));
		left.add(telefono);
		left.add(Box.createVerticalStrut(h));
		
		JLabel usernameV = new JLabel("    " + docente.getUsername());
		
		JLabel nomeV = new JLabel("    " + docente.getNome());
		JLabel cognomeV = new JLabel("    " + docente.getCognome());
		JLabel emailV = new JLabel("    " + docente.getEmail());
		JLabel telefonoV = new JLabel("    "+ docente.getTelefono());
		usernameV.setFont(fontValue);
		nomeV.setFont(fontValue);
		cognomeV.setFont(fontValue);
		emailV.setFont(fontValue);
		telefonoV.setFont(fontValue);
		
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
		
		complessivo.add(left);
		complessivo.add(right);
		
	}

	
	public void visualizzaProfilo(final Docente docC) {

		//Docente docC = doc.getDocenteCorrente();
		JPanel datiDoc = new JPanel();		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pulsanti = new JPanel();
		JPanel complessivo = new JPanel();

		JButton modifica = new JButton("Modifica Dati");
		
		datiDoc.setLayout(new BoxLayout(datiDoc, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		left.add(Box.createVerticalStrut(h));
		JLabel id = new JLabel("ID Utente: ");			id.setFont(fontIntest);
		JLabel nome = new JLabel("Nome: ");				nome.setFont(fontIntest);
		JLabel cognome = new JLabel("Cognome: ");		cognome.setFont(fontIntest);
		JLabel email = new JLabel("E-mail: ");			email.setFont(fontIntest);
		JLabel telefono = new JLabel("Telefono: ");		telefono.setFont(fontIntest);
		left.add(id);								
		left.add(Box.createVerticalStrut(h));
		left.add(nome);
		left.add(Box.createVerticalStrut(h));
		left.add(cognome);
		left.add(Box.createVerticalStrut(h));
		left.add(email);
		left.add(Box.createVerticalStrut(h));
		left.add(telefono);
		left.add(Box.createVerticalStrut(h));
		
		JLabel matricolaV = new JLabel("    " + docC.getUsername());
		JLabel nomeV = new JLabel("    " + docC.getNome());
		JLabel cognomeV = new JLabel("    " + docC.getCognome());
		JLabel emailV = new JLabel("    " + docC.getEmail());
		JLabel telefonoV = new JLabel("    "+ docC.getTelefono());
		
		matricolaV.setFont(fontValue);
		nomeV.setFont(fontValue);
		cognomeV.setFont(fontValue);
		emailV.setFont(fontValue);
		telefonoV.setFont(fontValue);
		
		right.add(Box.createVerticalStrut(h));
		right.add(matricolaV);
		right.add(Box.createVerticalStrut(h));
		right.add(nomeV);
		right.add(Box.createVerticalStrut(h));
		right.add(cognomeV);
		right.add(Box.createVerticalStrut(h));
		right.add(emailV);
		right.add(Box.createVerticalStrut(h));
		right.add(telefonoV);
		right.add(Box.createVerticalStrut(h));
		
		datiDoc.add(left);
		datiDoc.add(right);
		
		pulsanti.add(modifica);
		
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
    	complessivo.add(new JLabel("Profilo"));
		complessivo.add(Box.createVerticalStrut(2*h));
		complessivo.add(datiDoc);
		complessivo.add(Box.createVerticalStrut(5*h));
		complessivo.add(pulsanti);
		complessivo.add(Box.createVerticalGlue());
		
		IntPrincipale.setCenterPanel(complessivo);
		
		modifica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ModDocenteView mod = new ModDocenteView();

				mod.modificaDati(docC);
			}
			
		});
		
	}
	
}

