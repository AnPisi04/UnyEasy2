package com.mygroup.app.UnyEasy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ModificaAppelloView{

	private int h = 10;
	private int hL = (8/7)*h;
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	public void modificaApp(final Appello app, final Materia mat, Docente doc) {
		
		JPanel datiDoc = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pulsanti = new JPanel();
		JPanel complessivo = new JPanel();
		
		JButton conferma = new JButton("Conferma");
		JButton annulla = new JButton("Annulla");
		
		datiDoc.setLayout(new BoxLayout(datiDoc, BoxLayout.X_AXIS));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		left.add(Box.createVerticalStrut(h));
		JLabel codice = new JLabel("Codice: ");	codice.setFont(fontIntest);
		JLabel insegnamento = new JLabel("Insegnamento: ");				insegnamento.setFont(fontIntest);
		JLabel data = new JLabel("Data: ");	data.setFont(fontIntest);
		JLabel ora = new JLabel("Ora: ");				ora.setFont(fontIntest);
		JLabel aula = new JLabel("Aula: ");		aula.setFont(fontIntest);
		JLabel modalita = new JLabel("Modalit�: ");			modalita.setFont(fontIntest);
		
		left.add(codice);								
		left.add(Box.createVerticalStrut(hL));
		left.add(insegnamento);								
		left.add(Box.createVerticalStrut(hL));
		left.add(data);								
		left.add(Box.createVerticalStrut(hL));
		left.add(ora);
		left.add(Box.createVerticalStrut(hL));
		left.add(aula);
		left.add(Box.createVerticalStrut(hL));
		left.add(modalita);
		left.add(Box.createVerticalStrut(hL));
		
		
		JTextField codiceJ = new JTextField(app.getCodice());
		JTextField insegnamentoJ = new JTextField(mat.getNome());		
		
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat oraFormat = new SimpleDateFormat("HH:mm");
		
		final JTextField dataJ = new JTextField(dataFormat.format(app.getData()));
		final JTextField oraJ = new JTextField(oraFormat.format(app.getData()));
		final JTextField aulaJ = new JTextField(app.getAula());
		final JTextField modalitaJ = new JTextField(app.getTipo());
		
		codiceJ.setEnabled(false);
		insegnamentoJ.setEnabled(false);
		dataJ.setBounds(35, 63, 36, 20);
		oraJ.setEnabled(true);
		modalitaJ.setEnabled(true);
		
		right.add(Box.createVerticalStrut(h));
		right.add(codiceJ);
		right.add(Box.createVerticalStrut(h));
		right.add(insegnamentoJ);
		right.add(Box.createVerticalStrut(h));
		right.add(dataJ);
		right.add(Box.createVerticalStrut(h));
		right.add(oraJ);
		right.add(Box.createVerticalStrut(h));
		right.add(aulaJ);
		right.add(Box.createVerticalStrut(h));
		right.add(modalitaJ);
		
		
		right.add(Box.createVerticalStrut(h));
		
		datiDoc.add(left);
		datiDoc.add(right);
		
		pulsanti.add(annulla);
		pulsanti.add(conferma);
		complessivo.setLayout(new BoxLayout(complessivo, BoxLayout.Y_AXIS));
		complessivo.add(new JLabel("MODIFICA DELL'APPELLO"));
		complessivo.add(Box.createVerticalStrut(2*h));
		complessivo.add(datiDoc);
		complessivo.add(Box.createVerticalStrut(5*h));
		complessivo.add(pulsanti);
		complessivo.add(Box.createVerticalGlue());
		
		IntPrincipale.setCenterPanel(complessivo);
		
		
		conferma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ModificaAppello modificaAp = new ModificaAppello();
				Appello apMod = new Appello();
				boolean retvalue = true;
				Response resp = new Response();
				
				apMod.setCodice(app.getCodice());
				apMod.setCodiceMateria(mat.getCodice());
				
				String dataEora = dataJ.getText() + " " + oraJ.getText();
				DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dataEora));
		        Timestamp ts = Timestamp.valueOf(localDateTime);

		        apMod.setData(ts);
		        apMod.setAula(aulaJ.getText());
				apMod.setTipo(modalitaJ.getText());
				
				retvalue = modificaAp.modificaInformazioniAppello(apMod);
				
				if(retvalue){
					resp.provaGenerazioneMess("Appello aggiornato!");
				}else{
					resp.provaGenerazioneMess("Appello non aggiornato!");
				}
				
				AppelliDocenteView listaApp = new AppelliDocenteView();
				listaApp.visualizzaAppelli(doc);
				
			}
		});
		
		
		annulla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AppelliDocenteView listaApp = new AppelliDocenteView();
				listaApp.visualizzaAppelli(doc);
				
			}
		});
		
	}
	
}
