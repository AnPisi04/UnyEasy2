package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IscrittiAppelloView extends JPanel {
	
	private int h = 15;
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	Materia mat = new Materia();
	
	
	public void visualizzaIscrittiAppello(Appello ap){
		
		LinkedList<Studente> studenti = new LinkedList<Studente>();
		
		IscrittiAppello iscritti = new IscrittiAppello();
		
		studenti = iscritti.ottieniIscrittiAdAppello(ap);
		
		JPanel studentiPanel = new JPanel();
		JPanel infoAppello = this.getInfoAppello(ap);
		
		studentiPanel.setLayout(new BoxLayout(studentiPanel, BoxLayout.Y_AXIS));
		studentiPanel.add(StudenteIscritto.getIntestazione());
		studentiPanel.add(Box.createVerticalStrut(h));
		
		for(int i=0; i<studenti.size(); ++i){
			
			StudenteIscritto corrente = new StudenteIscritto(studenti.get(i), mat, ap);
			
			studentiPanel.add(corrente);
			studentiPanel.add(Box.createVerticalStrut(h));
			
		}
		
		
		JPanel complessivo = new JPanel();
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(Box.createVerticalStrut(3*h));
		complessivo.add(infoAppello);
		complessivo.add(Box.createVerticalStrut(h*3));
		complessivo.add(studentiPanel);
		
		IntPrincipale.setCenterPanel(complessivo);
		
	}

	public JPanel getInfoAppello(Appello ap){
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel complessivo = new JPanel();
		JLabel tmp = new JLabel();
		
		IscrittiAppello iscritti = new IscrittiAppello();
		
		mat = iscritti.ottieniMateriaAppello(ap);
		
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("CodiceAppello: " );
		left.add(tmp);
		left.add(Box.createVerticalStrut(h));
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Codice Materia: " );
		left.add(tmp);
		left.add(Box.createVerticalStrut(h));
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Materia: " );
		left.add(tmp);
		left.add(Box.createVerticalStrut(h));
		
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(ap.getCodice());
		right.add(tmp);
		right.add(Box.createVerticalStrut(h));
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(ap.getCodiceMateria());
		right.add(tmp);
		right.add(Box.createVerticalStrut(h));
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(mat.getNome());
		right.add(tmp);
		right.add(Box.createVerticalStrut(h));
		
		complessivo.add(left);
		complessivo.add(Box.createHorizontalStrut(3*h));
		complessivo.add(right);
		complessivo.add(Box.createHorizontalStrut(h*3));
		
		return complessivo;
		
	}
	
}
