package com.mygroup.app.UnyEasy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JPanel{

	private static final long serialVersionUID = 1L;
	private int h = 15;
	
	public LoginView(){
		
		this.setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JButton btnLogin = new JButton("Login");
		
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		/////LEFT
		left.add(Box.createVerticalGlue());
		left.add(new JLabel("Tipo Utente: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Username: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Password: "));
		left.add(Box.createVerticalStrut(h));
		left.add(Box.createVerticalGlue());
		
		/////RIGHT
		final JTextField username = new JTextField(16);
		final JPasswordField password = new JPasswordField(16);
		final JComboBox<String> tipoUt = new JComboBox<String>();
		
		tipoUt.addItem(new String("Docente"));
		tipoUt.addItem(new String("Studente"));
		tipoUt.setMaximumSize(new Dimension(300,20));
		tipoUt.setPreferredSize(new Dimension(300,20));
		username.setMaximumSize(new Dimension(300,20));
		username.setPreferredSize(new Dimension(300,20));
		password.setMaximumSize(new Dimension(300,20));
		password.setPreferredSize(new Dimension(300,20));
		
		right.add(Box.createVerticalGlue());
		
		right.add(Box.createVerticalStrut(h*2));
		right.add(tipoUt);
		right.add(Box.createVerticalStrut(h));
		right.add(username);
		right.add(Box.createVerticalStrut(h));
		right.add(password);
		right.add(Box.createVerticalStrut(h));
		right.add(btnLogin);
		right.add(Box.createVerticalGlue());
		
		/////AGGIUNGO RIGHT E LEFT AL CENTER
		center.add(left);
		center.add(Box.createHorizontalStrut(2*h));
		center.add(right);

		btnLogin.addActionListener(new ActionListener() {
			
			JComboBox<String> cb = tipoUt;
			
			public void actionPerformed(ActionEvent e) {
				
				String tipoUt = (String)cb.getSelectedItem();
				Login logCtr = new Login();
				
				boolean retval;
				
				if(tipoUt.equalsIgnoreCase("Docente")){
					
					Docente doc = new Docente();
					Docente docCaricato = new Docente();
					doc.setUsername(username.getText());
					char[] pass = password.getPassword();
					String passString = new String(pass);
					doc.setPassword(passString);
					
					retval = logCtr.verificaDatiDocente(doc, Login.DOCENTE); 
					
					if(retval){
						
						////APRI IL MENU
						docCaricato = logCtr.caricaDatiDocente(doc);
						MenuDocente menu = new MenuDocente(docCaricato);
						
					} else {
						
						logCtr.creaMessaggio(Login.ERRORE_LOGIN);
						
					}

					
				} else if(tipoUt.equalsIgnoreCase("Studente")){
					
					Studente stud = new Studente();
					Studente studCaricato = new Studente();
					stud.setUsername(username.getText());
					char[] pass = password.getPassword();
					String passString = new String(pass);
					stud.setPassword(passString);
					
					retval = logCtr.verificaDatiStudente(stud, Login.STUDENTE);
					
					if(retval){
						
						////APRI IL MENU
						studCaricato = logCtr.caricaDatiStudente(stud);
						MenuStudente menu = new MenuStudente(studCaricato);
						
					} else {
						
						logCtr.creaMessaggio(Login.ERRORE_LOGIN);
						
					}
				}
			}
		});

		
		/////AGGIUNGO IL CENTER NEL PANEL 
		this.add(center, BorderLayout.CENTER);
	
	}
	
}
