package com.mygroup.app.UnyEasy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class StudenteIscritto extends JPanel {

	static Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	static Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	static int w = 10, y = 30;
	static Dimension d1 = new Dimension(150, y);
	static Dimension d2 = new Dimension(60, y);
	static Dimension d3 = new Dimension(50, y);
	
	public StudenteIscritto(final Studente stud, final Materia mat, final Appello ap){
		
		JLabel tmp = new JLabel();
		JPanel matricola = new JPanel();	
		JPanel nome = new JPanel();
		JPanel cognome = new JPanel();
		JPanel email = new JPanel();
		JPanel telefono = new JPanel();
		
		JButton registra = new JButton("Registra");
		
		matricola.setMaximumSize(d2);		matricola.setPreferredSize(d2); 	matricola.setMinimumSize(d2);
		nome.setMaximumSize(d1);			nome.setPreferredSize(d1); 			nome.setMinimumSize(d1);
		cognome.setMaximumSize(d1);			cognome.setPreferredSize(d1); 		cognome.setMinimumSize(d1);
		email.setMaximumSize(d1);			email.setPreferredSize(d1); 		email.setMinimumSize(d1);
		telefono.setMaximumSize(d1);		telefono.setPreferredSize(d1); 		telefono.setMinimumSize(d1);

		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(stud.getUsername());
		matricola.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(stud.getCognome());
		cognome.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(stud.getNome());
		nome.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(stud.getEmail());
		email.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(stud.getTelefono());
		telefono.add(tmp);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(Box.createHorizontalStrut(w));
		this.add(matricola);
		this.add(Box.createHorizontalStrut(w));
		this.add(cognome);
		this.add(Box.createHorizontalStrut(w));
		this.add(nome);
		this.add(Box.createHorizontalStrut(w));
		this.add(email);
		this.add(Box.createHorizontalStrut(w));
		this.add(telefono);
		this.add(Box.createHorizontalStrut(w));
		this.add(registra);
		this.add(Box.createHorizontalStrut(w));

		this.setBorder(new LineBorder(Color.black, 1));
		
		registra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrazioneEsameView registr = new RegistrazioneEsameView();
				
				registr.registra(stud, ap, mat);
				
			}
		});
		
	}
	
	public static JPanel getIntestazione(){
		
		JLabel tmp = new JLabel();
		JPanel matricola = new JPanel();	
		JPanel nome = new JPanel();
		JPanel cognome = new JPanel();
		JPanel email = new JPanel();
		JPanel telefono = new JPanel();
		JPanel intest = new JPanel();
		
		matricola.setMaximumSize(d2);		matricola.setPreferredSize(d2); 	matricola.setMinimumSize(d2);
		nome.setMaximumSize(d1);			nome.setPreferredSize(d1); 			nome.setMinimumSize(d1);
		cognome.setMaximumSize(d1);			cognome.setPreferredSize(d1); 		cognome.setMinimumSize(d1);
		email.setMaximumSize(d1);			email.setPreferredSize(d1); 		email.setMinimumSize(d1);
		telefono.setMaximumSize(d1);		telefono.setPreferredSize(d1); 		telefono.setMinimumSize(d1);

		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Matricola");
		matricola.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Cognome");
		cognome.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Nome");
		nome.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Email");
		email.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Telefono");
		telefono.add(tmp);
		
		intest.setLayout(new BoxLayout(intest, BoxLayout.X_AXIS));
		
		intest.add(Box.createHorizontalStrut(w));
		intest.add(matricola);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(cognome);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(nome);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(email);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(telefono);
		intest.add(Box.createHorizontalStrut(w));
		
		
		return intest;
		
	}
	
}

