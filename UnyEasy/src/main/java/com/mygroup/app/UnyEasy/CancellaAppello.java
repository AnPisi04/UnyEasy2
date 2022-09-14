package com.mygroup.app.UnyEasy;

public class CancellaAppello {

	public int cancellaAppello(Appello appll) {
		
		Database db = new Database();
		int retval = 0;
		
		retval = db.cancellaAppello(appll);
		return retval;
		
	}
	
}
