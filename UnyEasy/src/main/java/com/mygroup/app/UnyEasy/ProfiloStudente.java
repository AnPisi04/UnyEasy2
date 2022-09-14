package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfiloStudente extends Profilo {

	int h = 15;
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	public ProfiloStudente(Studente studende){
		
		//Studente studC = Studente.getStudenteCorrente();
		JPanel datiStud = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pulsanti = new JPanel();
		JPanel complessivo = new JPanel();
		
		JButton modifica = new JButton("Modifica Dati");
		
		datiStud.setLayout(new BoxLayout(datiStud, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		left.add(Box.createVerticalStrut(h));
		JLabel matricola = new JLabel("Matricola: ");	matricola.setFont(fontIntest);
		JLabel nome = new JLabel("Nome: ");				nome.setFont(fontIntest);
		JLabel cognome = new JLabel("Cognome: ");		cognome.setFont(fontIntest);
		JLabel email = new JLabel("E-mail: ");			email.setFont(fontIntest);
		JLabel telefono = new JLabel("Telefono: ");		telefono.setFont(fontIntest);
		left.add(matricola);								
		left.add(Box.createVerticalStrut(h));
		left.add(nome);
		left.add(Box.createVerticalStrut(h));
		left.add(cognome);
		left.add(Box.createVerticalStrut(h));
		left.add(email);
		left.add(Box.createVerticalStrut(h));
		left.add(telefono);
		left.add(Box.createVerticalStrut(h));
		
		JLabel matricolaV = new JLabel("    " + studende.getUsername());
		
		JLabel nomeV = new JLabel("    " + studende.getNome());
		JLabel cognomeV = new JLabel("    " + studende.getCognome());
		JLabel emailV = new JLabel("    " + studende.getEmail());
		JLabel telefonoV = new JLabel("    "+ studende.getTelefono());
		
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
		
		datiStud.add(left);
		datiStud.add(right);
		
		pulsanti.add(modifica);
		
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(new JLabel("VISUALIZZAZIONE DEL PROFILO"));
		complessivo.add(Box.createVerticalStrut(2*h));
		complessivo.add(datiStud);
		complessivo.add(Box.createVerticalStrut(5*h));
		complessivo.add(pulsanti);
		complessivo.add(Box.createVerticalGlue());
		
	}
	
	public void visualizzaProfilo(final Studente studC){
		
		JPanel datiStud = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pulsanti = new JPanel();
		JPanel complessivo = new JPanel();
		
		JButton modifica = new JButton("Modifica Dati");
		
		datiStud.setLayout(new BoxLayout(datiStud, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		left.add(Box.createVerticalStrut(h));
		JLabel matricola = new JLabel("Matricola: ");	matricola.setFont(fontIntest);
		JLabel nome = new JLabel("Nome: ");				nome.setFont(fontIntest);
		JLabel cognome = new JLabel("Cognome: ");		cognome.setFont(fontIntest);
		JLabel email = new JLabel("E-mail: ");			email.setFont(fontIntest);
		JLabel telefono = new JLabel("Telefono: ");		telefono.setFont(fontIntest);
		left.add(matricola);								
		left.add(Box.createVerticalStrut(h));
		left.add(nome);
		left.add(Box.createVerticalStrut(h));
		left.add(cognome);
		left.add(Box.createVerticalStrut(h));
		left.add(email);
		left.add(Box.createVerticalStrut(h));
		left.add(telefono);
		left.add(Box.createVerticalStrut(h));
		
		JLabel matricolaV = new JLabel("    " + studC.getUsername());
		JLabel nomeV = new JLabel("    " + studC.getNome());
		JLabel cognomeV = new JLabel("    " + studC.getCognome());
		JLabel emailV = new JLabel("    " + studC.getEmail());
		JLabel telefonoV = new JLabel("    "+ studC.getTelefono());
		
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
		
		datiStud.add(left);
		datiStud.add(right);
		
		pulsanti.add(modifica);
		
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(new JLabel("VISUALIZZAZIONE DEL PROFILO"));
		complessivo.add(Box.createVerticalStrut(2*h));
		complessivo.add(datiStud);
		complessivo.add(Box.createVerticalStrut(5*h));
		complessivo.add(pulsanti);
		complessivo.add(Box.createVerticalGlue());
		
		IntPrincipale.setCenterPanel(complessivo);
		
		
		modifica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ModStudenteView mod = new ModStudenteView();
				
				mod.modificaDati(studC);
			}
			
		});
		
	}
	
}

