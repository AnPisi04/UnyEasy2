package com.mygroup.app.UnyEasy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.time.LocalDateTime;

public class AppelliDocenteView {

	private int h = 10; 
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	LinkedList<Appello> appelli = new LinkedList<Appello>();
	
	public void visualizzaAppelli(Docente doc){
		
		
		AppelliDocente appelliList = new AppelliDocente();
		
		JPanel complessivo = new JPanel();
		JPanel appelliPanel = new JPanel();
		JPanel pulsanti = new JPanel();
		
		JButton aggiungiAppello = new JButton("Nuovo Appello");
		pulsanti.add(aggiungiAppello);
		
		appelliPanel.setLayout(new BoxLayout(appelliPanel, BoxLayout.Y_AXIS));
		
		appelliPanel.add(AppelloDocView.getIntestazione());
		
		appelli = appelliList.ottieniListaAppelliDocente(doc);
		
		for(int i=0; i<appelli.size(); ++i){
			AppelloDocView corrente = new AppelloDocView(appelli.get(i), doc);
			appelliPanel.add(corrente);
			appelliPanel.add(Box.createVerticalStrut(h));
			
		}
		
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(new JLabel("APPELLI CONFERMATI"));
		complessivo.add(Box.createVerticalStrut(h));
		complessivo.add(appelliPanel);
		complessivo.add(Box.createVerticalStrut(h));
		complessivo.add(pulsanti);
		
		aggiungiAppello.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				NuovoAppelloView aggApp = new NuovoAppelloView();
				
				aggApp.aggiungiNuovoAppello(doc);
				
			}
		});
		
		IntPrincipale.setCenterPanel(complessivo);
			
	}

	
	
	private static class AppelloDocView extends JPanel {
		
		private int h = 10; ///SPAZIATURA VERTICAL STUT
		private static final int w = 10;
		private final static Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
		private final static Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
		private static final Dimension d1 = new Dimension(150, 25);
		static Dimension d2 = new Dimension(115, 25);
		static Dimension d3 = new Dimension(90, 25);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Materia mat = new Materia();
		
		public AppelloDocView(final Appello ap, Docente doc){
			
			
			Database db = new Database();
			
			
			JLabel tmp = new JLabel();
			JPanel codMateria = new JPanel();
			JPanel nome = new JPanel();
			JPanel data = new JPanel();
			JPanel aula = new JPanel();
			JPanel modalita = new JPanel();
			JPanel nIscritti = new JPanel();
			JPanel operazioni = new JPanel();
		
			JButton visualizza = new JButton("Vedi");
			JButton modifica = new JButton("Modifica");
			JButton cancella = new JButton("Canc");
			
			
			codMateria.setMaximumSize(d3); 			codMateria.setMinimumSize(d3); 			codMateria.setPreferredSize(d3);
			nome.setMaximumSize(d1); 				nome.setMinimumSize(d1)	;	 			nome.setPreferredSize(d1);
			data.setMaximumSize(d1); 				data.setMinimumSize(d1);	 			data.setPreferredSize(d1);
			aula.setMaximumSize(d3); 				aula.setMinimumSize(d3);	 			aula.setPreferredSize(d3);
			modalita.setMaximumSize(d2); 				modalita.setMinimumSize(d2); 				modalita.setPreferredSize(d2);
			nIscritti.setMaximumSize(d2); 			nIscritti.setMinimumSize(d2); 			nIscritti.setPreferredSize(d2);

			mat = db.caricaMateriaDiAppello(ap);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(mat.getCodice());
			codMateria.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(mat.getNome());
			nome.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(dateFormat.format(ap.getData()));
			data.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(ap.getAula());
			aula.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			tmp.setText(ap.getTipo());
			modalita.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontValue);
			int nIsc = db.caricaNumeroIscritti(ap);
			tmp.setText(String.valueOf(nIsc));
			nIscritti.add(tmp);
			
			
			operazioni.add(visualizza);
			operazioni.add(Box.createHorizontalStrut(w));
			operazioni.add(modifica);
			operazioni.add(Box.createHorizontalStrut(w));
			operazioni.add(cancella);
			operazioni.add(Box.createHorizontalStrut(w));
						
			
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
			this.add(Box.createHorizontalStrut(w));
			this.add(codMateria);
			this.add(Box.createHorizontalStrut(w));
			this.add(nome);
			this.add(Box.createHorizontalStrut(w));
			this.add(data);
			this.add(Box.createHorizontalStrut(w));
			this.add(aula);
			this.add(Box.createHorizontalStrut(w));
			this.add(modalita);
			this.add(Box.createHorizontalStrut(w));
			this.add(nIscritti);
			this.add(Box.createHorizontalStrut(w));
			this.add(operazioni);
			this.add(Box.createHorizontalStrut(w));
			this.setBorder(new LineBorder(Color.black, 1));
			
			
			visualizza.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					IscrittiAppelloView visApp = new IscrittiAppelloView();
					
					visApp.visualizzaIscrittiAppello(ap);
					
				}
			});
			
			
			modifica.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ModificaAppelloView mdApp =  new ModificaAppelloView();
					mdApp.modificaApp(ap, mat, doc);
					
				}
			});
			
			
			cancella.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					CancellaAppello canc = new CancellaAppello();
					Response rsp = new Response();
					
					int retval = 0;
					
					retval = canc.cancellaAppello(ap);
					
					//rsp.visualizzaMessaggio(retval);
					
					AppelliDocenteView visApp = new AppelliDocenteView();
					visApp.visualizzaAppelli(doc);
					
				}
			});
			
		}

		
		
		public static JPanel getIntestazione() {
			
			JLabel tmp = new JLabel();
			JPanel insegnamento = new JPanel();
			JPanel codice_materia = new JPanel();
			JPanel data_appello = new JPanel();
			JPanel aula = new JPanel();
			JPanel modalita = new JPanel();
			JPanel nIscritti = new JPanel();
			JPanel opzioni = new JPanel();

			JPanel intest = new JPanel();
			
			codice_materia.setMaximumSize(d3); 				codice_materia.setMinimumSize(d3)	;	 			codice_materia.setPreferredSize(d3);
			insegnamento.setMaximumSize(d1); 			insegnamento.setMinimumSize(d1); 			insegnamento.setPreferredSize(d1);
			data_appello.setMaximumSize(d1); 				data_appello.setMinimumSize(d1); 				data_appello.setPreferredSize(d1);
			aula.setMaximumSize(d3); 				aula.setMinimumSize(d3); 				aula.setPreferredSize(d3);
			modalita.setMaximumSize(d3); 				modalita.setMinimumSize(d3);	 			modalita.setPreferredSize(d3);
			nIscritti.setMaximumSize(d2); 			nIscritti.setMinimumSize(d2); 			nIscritti.setPreferredSize(d2);

			//opzioni.setMaximumSize(d1); 				opzioni.setMinimumSize(d1);	 			opzioni.setPreferredSize(d1);

		
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Codice");
			codice_materia.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Insegnamento");
			insegnamento.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Data");
			data_appello.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Aula");
			aula.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Modalità");
			modalita.add(tmp);
			
			tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("N. Iscritti");
			nIscritti.add(tmp);
			
			/*tmp = new JLabel();
			tmp.setFont(fontIntest);
			tmp.setText("Opzioni");
			opzioni.add(tmp);*/
			
			
			intest.setLayout(new BoxLayout(intest, BoxLayout.X_AXIS));
			
			intest.add(Box.createHorizontalStrut(w));
			intest.add(codice_materia);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(insegnamento);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(data_appello);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(aula);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(modalita);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(nIscritti);
			intest.add(Box.createHorizontalStrut(w));
			intest.add(opzioni);
			
			intest.add(Box.createHorizontalStrut(w));
			
			intest.setBorder(new LineBorder(Color.black, 1));
			
			return intest;
			
		}
		
	}

}

