package com.mygroup.app.UnyEasy;

import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.LayoutManager;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrenotazioneEffettuata {

	private int h = 15;
	
	public void visualizzaPrenotazioni(Studente stud) {
		
		Database db = new Database();
		LinkedList<PrenAppMat> prenotazioni = new LinkedList<PrenAppMat>();

		prenotazioni = db.caricaPrenotazioneAppello(stud);
		
		JPanel complessivo = new JPanel();
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		
		JPanel prenotazioniPanel = new JPanel();
		prenotazioniPanel.setLayout(new BoxLayout(prenotazioniPanel, BoxLayout.Y_AXIS));
		
		
		prenotazioniPanel.add(VisPrenotazione.getIntestazione());
		prenotazioniPanel.add(Box.createVerticalStrut(h));
		
		if(prenotazioni.size() > 0){
			
			for(int i=0; i<prenotazioni.size(); ++i){
				
				VisPrenotazione corrente = new VisPrenotazione(prenotazioni.get(i), stud);
				prenotazioniPanel.add(corrente);
				prenotazioniPanel.add(Box.createVerticalStrut(h));
				
			}
			
		} else {
			prenotazioniPanel.add(new JLabel("Nessuna prenotazione effettuata"));
		}
		
		prenotazioniPanel.add(Box.createVerticalStrut(h));
		
		complessivo.add(prenotazioniPanel, BorderLayout.CENTER);
		IntPrincipale.setCenterPanel(complessivo);
		
	}

}

