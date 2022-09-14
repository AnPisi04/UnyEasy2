package com.mygroup.app.UnyEasy;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Response extends JOptionPane{
	
	private static final long serialVersionUID = 1L;

	public void visualizzaMessaggio(boolean idMess) {
		JFrame frame = new JFrame("MESSAGGIO");
		if(idMess == Costanti.ERRORE_LOGIN){
			JOptionPane.showMessageDialog(frame,"Credenziali NON valide. Riprovare.");
		} else if(idMess == Costanti.OPERAZIONE_OK){
			JOptionPane.showMessageDialog(frame,"Operazione ok.");
		} else if(idMess == Costanti.PRENOTAZIONE_GIA_ESISTENTE){
			JOptionPane.showMessageDialog(frame, "Impossibile Aggiungere, Prenotazione gi� esistente");
		} else if(idMess == Costanti.PRENOTAZIONE_INSERITA){
			JOptionPane.showMessageDialog(frame, "Prenotazione Inserita Correttamente");
		} else if(idMess == Costanti.PRENOTAZIONE_CANCELLATA){
			JOptionPane.showMessageDialog(frame, "Prenotazione Cancellata Correttamente");
		} else if(idMess == Costanti.APPELLO_CANCELLATO){
			JOptionPane.showMessageDialog(frame, "Appello Cancellato Correttamente");
		} else if(idMess == Costanti.APPELLO_NON_CANCELLATO){
			JOptionPane.showMessageDialog(frame, "Errore nell'eliminazione dell'appello!");
		} else if(idMess == Costanti.APPELLO_INSERITO){
			JOptionPane.showMessageDialog(frame, "Appello Inserito Correttamente");
		} else if(idMess == Costanti.APPELLO_NON_INSERITO){
			JOptionPane.showMessageDialog(frame, "Errore nell'Inserimento dell'Appello!");
		} else if(idMess == Costanti.ESAME_GIA_PRESENTE){
			JOptionPane.showMessageDialog(frame, "Impossibile Inserire Esame. Esame gi� registrato per questo studente!");
		} else if(idMess == Costanti.ESAME_INSERITO){
			JOptionPane.showMessageDialog(frame, "Esame Inserito Correttamente");
		} else if(idMess == Costanti.CREDENZIALI_VALIDE){
			JOptionPane.showMessageDialog(frame, "Dati Inseriti Validi");
		} else if(idMess == Costanti.CREDENZIALI_NON_VALIDE){
			JOptionPane.showMessageDialog(frame, "Dati Inseriti NON validi!");
		} else if(idMess == Costanti.DATA_PRENOTAZIONE_NON_VALIDA){
			JOptionPane.showMessageDialog(frame, "Data di Prenotazione NON valida!");
		} else if(idMess == Costanti.DATI_CORRETTI){
			JOptionPane.showMessageDialog(frame, "Dati Inseriti validi!");
		} else if(idMess == Costanti.DATI_NON_CORRETTI){
			JOptionPane.showMessageDialog(frame, "Dati inseriti NON Validi");
		}
		
	}
	
	public void provaGenerazioneMess(String messaggio) {
		
		JFrame frame = new JFrame("MESSAGGIO");
		JOptionPane.showMessageDialog(frame, messaggio);
		
	}

}
