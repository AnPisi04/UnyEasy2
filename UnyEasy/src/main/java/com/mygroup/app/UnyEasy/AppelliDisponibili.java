package com.mygroup.app.UnyEasy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AppelliDisponibili extends JFrame{

	
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private int h = 15;
	
	
	public AppelliDisponibili(LinkedList<Appello> appelli, Materia mat) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		this.setVisible(true);
		

		JPanel complessivo = new JPanel();
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		
		
		
		MateriaInfo infoMat = new MateriaInfo(mat);
		
		JPanel appelliPanel = new JPanel();
		appelliPanel.setLayout(new BoxLayout(appelliPanel, BoxLayout.Y_AXIS));
		
		appelliPanel.add(AppelloDisponibileBnd.getIntestazione());
		appelliPanel.add(Box.createVerticalStrut(h));
		
		if(appelli.size() > 0){
			
			for(int i=0; i<appelli.size(); ++i){
				
				AppelloDisponibileBnd corrente = new AppelloDisponibileBnd(appelli.get(i));
				appelliPanel.add(corrente);
				appelliPanel.add(Box.createVerticalStrut(h));
			}
			
		} else {
			appelliPanel.add(new JLabel(" NESSUN APPELLO DISPONIBILE "));
		}
		
		complessivo.add(Box.createVerticalStrut(h));
		complessivo.add(infoMat, BorderLayout.NORTH);
		complessivo.add(Box.createVerticalStrut(h));
		complessivo.add(appelliPanel, BorderLayout.CENTER);
		contentPane.add(Box.createVerticalStrut(h));
		contentPane.add(Box.createVerticalGlue());
		JPanel center = new JPanel();
		center.add(complessivo);
		contentPane.add(center, BorderLayout.CENTER);
		
		
	}

	private static class AppelloDisponibileBnd extends JPanel {
		
		private static final long serialVersionUID = 1L;
		static Dimension d1 = new Dimension(240, 20);
		static Dimension d2 = new Dimension(170, 20);
		static Dimension d3 = new Dimension(80, 20);
		static Dimension d4 = new Dimension(600, 40);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		static Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
		static Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
		static int w = 10;
		
		public AppelloDisponibileBnd(final Appello ap){
			
			Database db = new Database();
			JLabel tmp = new JLabel();
			int nIscrInt = 0;
			JPanel data = new JPanel();
			JPanel nIscr = new JPanel();
			JPanel tipo = new JPanel();
			JPanel aula = new JPanel();
			JPanel pulsante = new JPanel();
			JButton prenota = new JButton("Prenota");
			
			data.setMaximumSize(d2); 		data.setPreferredSize(d2); 		data.setMinimumSize(d2);
			nIscr.setMaximumSize(d3); 		nIscr.setPreferredSize(d3); 	nIscr.setMinimumSize(d3);
			tipo.setMaximumSize(d2); 		tipo.setPreferredSize(d1); 		tipo.setMinimumSize(d1);
			aula.setMaximumSize(d2); 		aula.setPreferredSize(d2); 		aula.setMinimumSize(d2);

			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(dateFormat.format(ap.getData()));
			data.add(tmp);
			
			nIscrInt = db.caricaNumeroIscritti(ap);
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(String.valueOf(nIscrInt));
			nIscr.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(ap.getTipo());
			tipo.add(tmp);
			
			pulsante.add(prenota);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(ap.getAula());
			tipo.add(tmp);
			aula.add(tmp);
			
			
			this.add(Box.createHorizontalStrut(w));
			this.add(data);
			this.add(Box.createHorizontalStrut(w));
			this.add(aula);
			this.add(Box.createHorizontalStrut(w));
			this.add(nIscr);
			this.add(Box.createHorizontalStrut(w));
			this.add(tipo);
			this.add(Box.createHorizontalStrut(w));
			this.add(pulsante);
			
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

			this.setBorder(new LineBorder(Color.BLACK, 1));

			
			
			prenota.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					PrenotazioneStudente prenAppCtr = new PrenotazioneStudente();

					prenAppCtr.inserisciPrenotazione(ap);
					
				}
			});
		}
		
		
		public static JPanel getIntestazione(){
			
			JLabel tmp = new JLabel();
			JPanel data = new JPanel();
			JPanel aula = new JPanel();
			JPanel nIscr = new JPanel();
			JPanel tipo = new JPanel();
			JPanel pulsante = new JPanel();
			JPanel intest = new JPanel();
			
			data.setMaximumSize(d2); 		data.setPreferredSize(d2); 		data.setMinimumSize(d2);
			nIscr.setMaximumSize(d3); 		nIscr.setPreferredSize(d3); 	nIscr.setMinimumSize(d3);
			tipo.setMaximumSize(d2); 		tipo.setPreferredSize(d1); 		tipo.setMinimumSize(d1);
			aula.setMaximumSize(d2); 		aula.setPreferredSize(d2); 		aula.setMinimumSize(d2);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Data Esame");
			data.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Iscritti");
			nIscr.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Modalità");
			tipo.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Aula");
			aula.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Operazioni");
			pulsante.add(tmp);
			
			intest.add(Box.createHorizontalStrut(w));
			intest.add(data);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(Box.createHorizontalStrut(w));
			intest.add(aula);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(nIscr);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(tipo);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(pulsante);
			
			intest.setLayout(new BoxLayout(intest, BoxLayout.X_AXIS));
			
			return intest;
			
		}
		
	}

}

