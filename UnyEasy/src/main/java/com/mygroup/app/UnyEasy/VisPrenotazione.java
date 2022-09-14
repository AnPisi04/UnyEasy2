package com.mygroup.app.UnyEasy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VisPrenotazione extends JPanel {
	
	private static final long serialVersionUID = 1L;
	static Dimension d1 = new Dimension(240, 20);
	static Dimension d2 = new Dimension(170, 35);
	static Dimension d3 = new Dimension(80, 20);
	static Dimension d4 = new Dimension(600, 40);
	static private int w = 15;
	static int h = 15;
	static Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	static Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	DateFormat dateFormatPrenotaz = new SimpleDateFormat("dd/MM/yyyy");
	
	public VisPrenotazione(final PrenAppMat p, final Studente s){
		
		JLabel tmp = new JLabel();
				
		JPanel nome_materia = new JPanel();
		JPanel data_app = new JPanel();
		JPanel aula = new JPanel();
		JPanel tipo = new JPanel();
		JPanel data_prenot = new JPanel();
		JPanel operazioni = new JPanel();
		
		JButton cancella = new JButton("Cancella");
		operazioni.add(cancella);
		
		nome_materia.setMaximumSize(d3);		nome_materia.setMinimumSize(d3);		nome_materia.setPreferredSize(d3);
		data_app.setMaximumSize(d1);		data_app.setMinimumSize(d1);		data_app.setPreferredSize(d1);
		aula.setMaximumSize(d2); 			aula.setMinimumSize(d2);			aula.setPreferredSize(d2);
		tipo.setMaximumSize(d2); 			tipo.setMinimumSize(d2);			tipo.setPreferredSize(d2);
		data_prenot.setMaximumSize(d3);				data_prenot.setMinimumSize(d3);				data_prenot.setPreferredSize(d3);
		operazioni.setMaximumSize(d2); 	operazioni.setMinimumSize(d2);  	operazioni.setPreferredSize(d2);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(p.getNomeMateria());
		nome_materia.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(dateFormat.format(p.getDataApp()));
		data_app.add(tmp);
		data_app.add(new JLabel());
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(p.getAula());
		aula.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(p.getTipo());
		tipo.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(dateFormatPrenotaz.format(p.getDataPren()));
		data_prenot.add(tmp);
		data_prenot.add(new JLabel());
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS ));
		this.add(Box.createHorizontalStrut(w));
		this.add(nome_materia);
		this.add(Box.createHorizontalStrut(w));
		this.add(data_app);
		this.add(Box.createHorizontalStrut(w));
		this.add(aula);
		this.add(Box.createHorizontalStrut(w));
		this.add(tipo);
		this.add(Box.createHorizontalStrut(w));
		this.add(data_prenot);
		this.add(Box.createHorizontalStrut(w));
		this.add(operazioni);
		
		this.setBorder(new LineBorder(Color.BLACK, 1));

		cancella.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				CancPrenotazioneStud canc = new CancPrenotazioneStud();
				int retval = 0;
				Response rsp = new Response();
				
				retval = canc.cancellaPrenotazione(p);
				rsp.visualizzaMessaggio(retval);
				
				PrenotazioneEffettuata pr = new PrenotazioneEffettuata();
				pr.visualizzaPrenotazioni(s);
			}
		});
		
	}
	public static JPanel getIntestazione(){
		JPanel intest = new JPanel();
		
		JPanel nomeMateria = new JPanel();
		JPanel dataAppello = new JPanel();
		JPanel aula = new JPanel();
		JPanel tipo = new JPanel();
		//JPanel docente = new JPanel();
		JPanel dataPrenot = new JPanel();
		JPanel operazioni = new JPanel();
		JPanel complessivo = new JPanel();
		JLabel tmp = new JLabel();
		
		nomeMateria.setMaximumSize(d3);		nomeMateria.setMinimumSize(d3);		nomeMateria.setPreferredSize(d3);
		dataAppello.setMaximumSize(d1);		dataAppello.setMinimumSize(d1);		dataAppello.setPreferredSize(d1);
		aula.setMaximumSize(d2); 			aula.setMinimumSize(d2);			aula.setPreferredSize(d2);
		tipo.setMaximumSize(d2); 		tipo.setMinimumSize(d2);  	tipo.setPreferredSize(d2);
		//docente.setMaximumSize(d3);				docente.setMinimumSize(d3);				docente.setPreferredSize(d3);
		dataPrenot.setMaximumSize(d3);				dataPrenot.setMinimumSize(d3);				dataPrenot.setPreferredSize(d3);
		operazioni.setMaximumSize(d2);				operazioni.setMinimumSize(d2);				operazioni.setPreferredSize(d2);
	
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Materia");
		nomeMateria.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Data");
		dataAppello.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Aula");
		aula.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Modalit�");
		tipo.add(tmp);
		
		/*tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Docente");
		docente.add(tmp);*/
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Data Prenot.");
		dataPrenot.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontIntest);
		tmp.setText("Operazioni");
		operazioni.add(tmp);
		
		intest.setLayout(new BoxLayout(intest, BoxLayout.X_AXIS));
		intest.add(Box.createHorizontalStrut(w));
		intest.add(nomeMateria);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(dataAppello);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(aula);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(tipo);
		//intest.add(Box.createHorizontalStrut(w));
		//intest.add(docente);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(dataPrenot);
		intest.add(Box.createHorizontalStrut(w));
		intest.add(operazioni);
		
		return intest;
	}
}

