package com.mygroup.app.UnyEasy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;



import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

//import sun.util.calendar.JulianCalendar;

import java.awt.*;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class NuovoAppelloView extends JPanel{
	
	private int h = 20;
	private int w = 10;
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	Date today = Calendar.getInstance().getTime();
	JButton aggiungiAppello = new JButton("Aggiungi");
	
	public void aggiungiNuovoAppello(Docente doc){
		
		final JComboBox<Materia> materieBox = new JComboBox<Materia>();
		Database db = new Database();
		LinkedList<Materia> materie = new LinkedList<Materia>();
		final JTextArea tipo = new JTextArea(3, 30);
		final JTextField aula = new JTextField();
		final JTextField ora = new JTextField("hh:mm");
		final JTextField cod_appello = new JTextField();
		final JTextField dataCh = new JTextField("yyyy-mm-dd");
		
		ora.setEnabled(true);
		materie = db.caricaMaterieDocente(doc);
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel complessivo = new JPanel();
		
		
		
		
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		tipo.setBorder(new LineBorder(Color.BLACK, 1));
		tipo.setLineWrap(true);
		
		for(int i=0; i<materie.size(); ++i){
			materieBox.addItem(materie.get(i));
		} 
		
		left.add(new JLabel("Materia: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Codice appello: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Data: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Ora: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Aula: "));
		left.add(Box.createVerticalStrut(h));
		left.add(new JLabel("Modalità esame: "));
		left.add(Box.createVerticalStrut(h));
		
		right.add(Box.createVerticalStrut(h*4));
		right.add(materieBox);
		right.add(Box.createVerticalStrut(h));
		right.add(cod_appello);
		right.add(Box.createVerticalStrut(h));
		right.add(dataCh);
		right.add(Box.createVerticalStrut(h));
		right.add(ora);
		right.add(Box.createVerticalStrut(h));
		right.add(aula);
		right.add(Box.createVerticalStrut(h));
		right.add(tipo);
		right.add(Box.createVerticalStrut(h));
		right.add(aggiungiAppello);
		right.add(Box.createVerticalStrut(h));

		
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.X_AXIS));
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(left);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(right);
		complessivo.add(Box.createHorizontalStrut(w));
		
		JPanel center = new JPanel();
		center.add(complessivo);
		IntPrincipale.setCenterPanel(center);
		
		aggiungiAppello.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				NuovoAppello newApp = new NuovoAppello();
				boolean retvalue;
				Response rsp = new Response();
				
				String dataEora = dataCh.getText() + " " + ora.getText();
				DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dataEora));
		        Timestamp ts = Timestamp.valueOf(localDateTime);
				
		        String codice_appello = cod_appello.getText();
		        Timestamp data = ts;
		        String aulaAp = aula.getText();
		        String modalita = tipo.getText();
		        Materia materia = (Materia)materieBox.getSelectedItem();
		        
		        retvalue = newApp.creaNuovoAppello(codice_appello, data, aulaAp, modalita, materia.getCodice());
				
				if(retvalue)
					rsp.provaGenerazioneMess("Appello aggiunto correttamente.");
				else
					rsp.provaGenerazioneMess("Non è stato possibile aggiungere l'appello");
				
				AppelliDocenteView visApp = new AppelliDocenteView();
				
				visApp.visualizzaAppelli(doc);
				
			}
			
			
		});
		
	}
	
}

