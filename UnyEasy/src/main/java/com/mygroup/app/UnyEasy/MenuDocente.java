package com.mygroup.app.UnyEasy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuDocente extends Menu {
	
	private static final long serialVersionUID = 1L;
	private int h = 20; ///SPAZIATURA FRA PULSANTI
	
	public MenuDocente(final Docente doc){
		
		this.setLayout(new BorderLayout());
		
		JPanel west = new JPanel();
		JButton profilo = new JButton("Profilo");
		JButton appelli = new JButton("Appelli");
		JButton logout = new JButton("Logout");
		
		/////PANNELLO WEST, DEI PULSANTI
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(Box.createVerticalStrut(h));
		west.add(profilo);
		west.add(Box.createVerticalStrut(h));
		west.add(appelli);
		west.add(Box.createVerticalStrut(h));
		west.add(logout);
		west.add(Box.createVerticalStrut(h));
		
		IntPrincipale.resetPanel();
		IntPrincipale.setWestPanel(west);
		
		ProfiloDocente vp = new ProfiloDocente(doc);
		vp.visualizzaProfilo(doc);
		
		logout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Login logCtr = new Login();
				
				logCtr.logout(doc);
				
			}
		});
		
		
		profilo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ProfiloDocente vp = new ProfiloDocente(doc);
				vp.visualizzaProfilo(doc);
				
			}
			
		});
		
		
		appelli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AppelliDocenteView visAp = new AppelliDocenteView();
				
				visAp.visualizzaAppelli(doc);
				
			}
			
		});
		
	}
	
}
