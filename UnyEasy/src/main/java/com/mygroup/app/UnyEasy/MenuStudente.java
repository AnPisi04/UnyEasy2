package com.mygroup.app.UnyEasy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;



public class MenuStudente extends Menu {
	
	private int h = 20; ///SPAZIATURA FRA PULSANTI
	
	public MenuStudente(final Studente stud){
		
		this.setLayout(new BorderLayout());
	
		JPanel west = new JPanel();
		JButton profilo = new JButton("Profilo");
		JButton pianoStudi = new JButton("Piano di Studi");
		JButton prenotazioni = new JButton("Prenotazioni");
		JButton logout = new JButton("Logout");
		
		/////PANNELLO WEST, DEI PULSANTI
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(Box.createVerticalStrut(h));
		west.add(profilo);
		west.add(Box.createVerticalStrut(h));
		west.add(pianoStudi);
		west.add(Box.createVerticalStrut(h));
		west.add(prenotazioni);
		west.add(Box.createVerticalStrut(h));
		west.add(logout);
		west.add(Box.createVerticalStrut(h));

		IntPrincipale.resetPanel();
		IntPrincipale.setWestPanel(west);
		
		ProfiloStudente vp = new ProfiloStudente(stud);
		vp.visualizzaProfilo(stud);
		
		
		logout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Login logCtr = new Login();
				logCtr.logout(stud);
				
				}
	
			}
		
		);
		
		
		pianoStudi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				LibrettoStudente pianoS = new LibrettoStudente();
				Database db = new Database();
				PianoStudi pianoStud = new PianoStudi();
				VisPianoStudi VispianoStud = new VisPianoStudi();
				Corso corso = new Corso();
				
				corso = VispianoStud.caricaCorso(stud);
				pianoS.setCorso(corso.getCodice(), corso.getNome());
				pianoS = db.caricaLibretto(stud, corso);
				pianoStud.view(pianoS.getCorso(), pianoS.getMaterie(), pianoS.getEsami(), stud);

			}
		});
		
		
		profilo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ProfiloStudente visProf = new ProfiloStudente(stud);
				visProf.visualizzaProfilo(stud);
				
			}
			
		});
		
		
		prenotazioni.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				VisPrenotazioniStud vis = new VisPrenotazioniStud();
				vis.visualizzaPrenotazioniEffettuate(stud);
				
			}
			
		});
		
	}
	
}

