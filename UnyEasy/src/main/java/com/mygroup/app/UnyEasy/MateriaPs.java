package com.mygroup.app.UnyEasy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class MateriaPs extends JPanel {
	
	private static final long serialVersionUID = 1L;
	static Dimension d1 = new Dimension(180, 20);
	static Dimension d2 = new Dimension(60, 20);
	static Dimension d3 = new Dimension(50, 20);
	static Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	static Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	static int w = 10;
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	
	MateriaPs( final Materia mat,  Esame es){
		
		Database db = new Database();
		String votoStr;
		
		
		JLabel tmp = new JLabel();
		JPanel codice = new JPanel();	
		JPanel nome = new JPanel();
		JPanel cfu = new JPanel();
		JPanel stato = new JPanel();
		JPanel voto = new JPanel();
		JPanel data = new JPanel();
		JPanel pulsante = new JPanel();
		JButton visualizzaAppelli = new JButton("Visualizza Appelli");
		
		codice.setMaximumSize(d2);	codice.setPreferredSize(d2); 	codice.setMinimumSize(d2);
		nome.setMaximumSize(d1);	nome.setPreferredSize(d1); 		nome.setMinimumSize(d1);
		cfu.setMaximumSize(d2);		cfu.setPreferredSize(d2); 		cfu.setMinimumSize(d2);
		stato.setMaximumSize(d1);	stato.setPreferredSize(d1); 	stato.setMinimumSize(d1);
		voto.setMaximumSize(d2);	voto.setPreferredSize(d2); 		voto.setMinimumSize(d2);
		data.setMaximumSize(d1);	data.setPreferredSize(d1); 		data.setMinimumSize(d1);
		
		es = db.caricaEsame(Studente.getStudenteCorrente(), mat);
		votoStr = es.getVoto();
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(mat.getCodice());
		codice.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(mat.getNome());
		nome.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		tmp.setText(String.valueOf(mat.getCfu()));
		cfu.add(tmp);
		
		tmp = new JLabel();
		tmp.setFont(fontValue);
		
		if(es.getData() != null){
			
			Format formatter = new SimpleDateFormat("dd/MM/yyyy");
			String s = formatter.format(es.getData());
			tmp.setText(s);
			
		} else {
			tmp.setText("");
		}
		
		data.add(tmp);
		
		pulsante.add(visualizzaAppelli);
		
		if(!votoStr.equals("-")){
			stato.add(new JLabel("Sostenuto"));
			voto.add(new JLabel(String.valueOf(votoStr)));
			visualizzaAppelli.setEnabled(false);
		} else {
			stato.add(new JLabel("/"));
			voto.add(new JLabel("/"));
			visualizzaAppelli.setEnabled(true);
		}
		
	
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(Box.createHorizontalStrut(w));
		this.add(codice);
		this.add(Box.createHorizontalStrut(w));
		this.add(nome);
		this.add(Box.createHorizontalStrut(w));
		this.add(cfu);
		this.add(Box.createHorizontalStrut(w));
		this.add(stato);
		this.add(Box.createHorizontalStrut(w));
		this.add(voto);
		this.add(Box.createHorizontalStrut(w));
		this.add(data);
		this.add(Box.createHorizontalStrut(w));
		this.add(pulsante);
		this.add(Box.createHorizontalStrut(w));
		
		this.setBorder(new LineBorder(Color.black, 1));
		
		
		visualizzaAppelli.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				PrenotazioneStudente prenotazioneApp = new PrenotazioneStudente();
				
				prenotazioneApp.visualizzaAppelli(mat);
				
			}
			
		});
		
	}

	
	public static JPanel getIntestazione(){
		
		JPanel codice = new JPanel();	
		JPanel nome = new JPanel();
		JPanel cfu = new JPanel();
		JPanel stato = new JPanel();
		JPanel voto = new JPanel();
		JPanel data = new JPanel();
		
		JPanel op = new JPanel();
		
		codice.setMaximumSize(d2);		codice.setPreferredSize(d2); 	codice.setMinimumSize(d2);
		nome.setMaximumSize(d1);		nome.setPreferredSize(d1); 		nome.setMinimumSize(d1);
		cfu.setMaximumSize(d2);			cfu.setPreferredSize(d2); 		cfu.setMinimumSize(d2);
		stato.setMaximumSize(d1);		stato.setPreferredSize(d1); 	stato.setMinimumSize(d1);
		voto.setMaximumSize(d2);		voto.setPreferredSize(d2); 		voto.setMinimumSize(d2);
		op.setMaximumSize(d1);			op.setPreferredSize(d1); 		op.setMinimumSize(d1);
		data.setMaximumSize(d1);		data.setPreferredSize(d1); 		data.setMinimumSize(d1);

		codice.add(new JLabel("ID"));
		nome.add(new JLabel("Nome Materia"));
		cfu.add(new JLabel("CFU"));
		stato.add(new JLabel("Stato"));
		voto.add(new JLabel("Voto"));
		data.add(new JLabel("Data"));
		op.add(new JLabel("Operazione"));
		
		JPanel complessivo = new JPanel();
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.X_AXIS));
		
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(codice);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(nome);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(cfu);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(stato);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(voto);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(data);
		complessivo.add(Box.createHorizontalStrut(w));
		complessivo.add(op);
		complessivo.add(Box.createHorizontalStrut(w));
		
		return complessivo;
		
	}
	
}

