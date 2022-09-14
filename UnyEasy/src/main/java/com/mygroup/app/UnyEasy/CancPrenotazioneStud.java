package com.mygroup.app.UnyEasy;

public class CancPrenotazioneStud {

	public int cancellaPrenotazione(PrenAppMat p){
	
		Database db = new Database();
		int retval = 0;
	
		retval = db.cancellaPrenotazione(p);
		return retval;
	}
	
}
