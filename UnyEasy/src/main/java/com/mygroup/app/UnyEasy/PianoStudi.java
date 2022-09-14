package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.util.LinkedList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PianoStudi extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private int h = 10; 
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	
	public void view(Corso c, LinkedList<Materia> materie, LinkedList<Esame> esami, Studente s){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		CorsoInfo corsoInfo = new CorsoInfo(c);
		
		
		JPanel materiePanel = new JPanel();
		materiePanel.setLayout(new BoxLayout(materiePanel, BoxLayout.Y_AXIS));
		materiePanel.add(MateriaPs.getIntestazione());
		materiePanel.add(Box.createVerticalStrut(h));
		
		for(int i=0; i<materie.size(); ++i){
			
			Materia mat_i = materie.get(i);
			Esame es_i = new Esame();
			
			for(int j=0;j<esami.size();j++) {
			
				if(esami.get(j)!= null && esami.get(j).getCodMateria().equals(mat_i.getCodice())) {
					es_i = esami.get(j);
				} else {
					es_i.setCodMateria(mat_i.getCodice());
					es_i.setMatStudente(s.getUsername());
					es_i.setVoto("-");
				}
			}
			
			MateriaPs corrente = new MateriaPs(mat_i, es_i);
			
			materiePanel.add(corrente);
			materiePanel.add(Box.createVerticalGlue());
			materiePanel.add(Box.createVerticalStrut(h));
		}
		
		/////ADESSO INSERISCO I DUE PENEL IN UN PANEL UNICO
		JPanel complessivo = new JPanel();
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(corsoInfo);
		complessivo.add(Box.createVerticalStrut(h*3));
		complessivo.add(materiePanel);
		complessivo.add(Box.createVerticalGlue());
		
		IntPrincipale.setCenterPanel(complessivo);

	}
	
}

