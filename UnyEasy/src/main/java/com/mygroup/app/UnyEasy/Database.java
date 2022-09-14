package com.mygroup.app.UnyEasy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;

public class Database {
	
	private static final boolean PRENOTAZIONE_GIA_ESISTENTE = Costanti.PRENOTAZIONE_GIA_ESISTENTE;
	private static final boolean PRENOTAZIONE_INSERITA = Costanti.PRENOTAZIONE_INSERITA;
	private static final boolean PRENOTAZIONE_CANCELLATA = Costanti.PRENOTAZIONE_CANCELLATA;
	private static final boolean APPELLO_CANCELLATO = Costanti.APPELLO_CANCELLATO;
	private static final boolean APPELLO_NON_CANCELLATO = Costanti.APPELLO_NON_CANCELLATO;
	private static final boolean APPELLO_INSERITO = Costanti.APPELLO_INSERITO;
	private static final boolean APPELLO_NON_INSERITO = Costanti.APPELLO_NON_INSERITO;
	private static final boolean ESAME_GIA_PRESENTE = Costanti.ESAME_GIA_PRESENTE;
	private static final boolean ESAME_INSERITO = Costanti.ESAME_INSERITO;
	private static final boolean CREDENZIALI_VALIDE = Costanti.CREDENZIALI_VALIDE;
	private static final boolean CREDENZIALI_NON_VALIDE = Costanti.CREDENZIALI_NON_VALIDE;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	String url = "jdbc:postgresql://localhost/gestioneesami";
    String user = "postgres";
    String password = "postgresql";
    
    Statement st;
	Connection con;
	
	
	public void connetti() {
		
		con = null;
		
		try {
			
			con = DriverManager.getConnection(url, user, password);
		    st = con.createStatement();

		}catch(Exception e) {
			System.out.println(e);
		}

	}
	
	
	private void disconnetti(){
		
		try{
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
	
	
	public boolean verificaDatiDocente(Docente docente) {
		
		String usernameInserito = docente.getUsername();
		String passwordInserita = docente.getPassword();
		
		connetti();
		
		String query = "SELECT username, password FROM docente WHERE username = " + " '"+ usernameInserito + "' " + " AND password= " + " '" + passwordInserita + "' ";

		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			if(res.next()) {
				return CREDENZIALI_VALIDE;
			} else {
				disconnetti();
				return CREDENZIALI_NON_VALIDE;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();

		return CREDENZIALI_NON_VALIDE;
	}
	
	
	public Docente caricaDatiDocente(Docente docente) {
		
		String usernameInserito = docente.getUsername();
		String passwordInserita = docente.getPassword();
		Docente newDoc = new Docente();
		
		connetti();
		
		String query = "SELECT * FROM docente WHERE username = " + " '"+ usernameInserito +"' " + " AND Password= " + " '" + passwordInserita + "' ";
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			if(res.next()){
				newDoc.setCognome(res.getString("Cognome"));
				newDoc.setEmail(res.getString("Email"));
				newDoc.setNome(res.getString("Nome"));
				newDoc.setTelefono(res.getString("Telefono"));
				newDoc.setUsername(res.getString("Username"));
				newDoc.setPassword(res.getString("Password"));
				return newDoc;
			} else {
				disconnetti();
				return newDoc;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		
		return newDoc;
		
	}

	
	//public boolean aggiornaDatiDocente(Docente docente) {
	public boolean aggiornaDatiDocente(Docente docenteVecchio, Docente docenteNuovo) {
		
		/*String nwPss = docente.getPassword();
		String nwEma = docente.getEmail();
		String nwTel = docente.getTelefono();
		String user = docente.getUsername();
		
		connetti();
		
		String query = "UPDATE docente SET telefono='" + nwTel + "', email='" + nwEma +"', password='" + nwPss + "' WHERE username='" + user +"';";

		try{
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		
		return true;*/
		
		String nwPss = docenteNuovo.getPassword();
		String nwEma = docenteNuovo.getEmail();
		String nwTel = docenteNuovo.getTelefono();
		String user = docenteVecchio.getUsername();
		
		connetti();
		
		if(!nwPss.equals(docenteVecchio.getPassword())) {
			
			String queryPass = "UPDATE docente SET password='" + nwPss + "' WHERE username='" + user +"';";
			
			try{
				st.executeUpdate(queryPass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		if(!nwEma.equals(docenteVecchio.getEmail())) {
			
			String queryEmail = "UPDATE docente SET email='" + nwEma + "' WHERE username='" + user +"';";
			
			try{
				st.executeUpdate(queryEmail);
			} catch (SQLException e) {
				e.printStackTrace();
			}


		}
		
		if(!nwTel.equals(docenteVecchio.getTelefono())) {
			
			String queryTel = "UPDATE docente SET telefono='" + nwTel + "' WHERE username='" + user +"';";
			
			try{
				st.executeUpdate(queryTel);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		disconnetti();
		
		return true;
		
	}
	
	
	

	
	//public LinkedList caricaAppelliDocente() {
	public LinkedList<Appello> caricaAppelliDocente(Docente doc) {	
		
		//String us_doc = Docente.getDocenteCorrente().getUsername();
		String us_doc = doc.getUsername();
		LinkedList<Appello> appelli = new LinkedList<Appello>();
		
		connetti();
		
		String query = "SELECT codice_app,data,aula,tipo,cod_materia FROM appello INNER JOIN materia ON appello.cod_materia = materia.codice_mat AND materia.user_docente='" + us_doc + "';";

		try{
			
			ResultSet res = st.executeQuery(query);
			
			while(res.next()){
				
				Appello corrente = new Appello();
				corrente.setCodice(res.getString("codice_app"));
				Timestamp dataDate = res.getTimestamp("data");
				
				corrente.setData(dataDate);
				corrente.setAula(res.getString("aula"));
				corrente.setTipo(res.getString("tipo"));
				corrente.setCodiceMateria(res.getString("cod_materia"));
				appelli.add(corrente);
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		disconnetti();
		
		return appelli;
		
	}
	
	
	public Materia caricaMateriaDiAppello(Appello ap){
		
		Materia mat = new Materia();
		String codAppello = ap.getCodice();
		connetti();
		
		String query = "SELECT codice_mat,nome,cfu,user_docente FROM appello JOIN materia ON appello.cod_materia = materia.codice_mat AND appello.codice_app = '" + codAppello + "'";
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			if(res.next()){
				mat.setCodice(res.getString("codice_mat"));
				mat.setNome(res.getString("nome"));
				mat.setCfu(res.getString("cfu"));
				mat.setUserDocente(res.getString("user_docente"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		
		return mat;
		
	}
	
	
	public int caricaNumeroIscritti(Appello ap) {
		
			String codAp = ap.getCodice();
			int numeroIscritti = 0;
			
			connetti();
			
			String query = "SELECT * FROM prenotazione WHERE cod_appello = '" + codAp + "';";
			
			try{
				
				ResultSet res = st.executeQuery(query);
				
				while(res.next()){
					numeroIscritti++;
				}	
				
			}catch(Exception e){
				e.printStackTrace();
			}

			
			disconnetti();
			
			return numeroIscritti;
			
	}
	
	
	public LinkedList<Studente> caricaStudentiAppello(Appello ap) {
		
				String codAp = ap.getCodice();
				LinkedList<Studente> studenti = new LinkedList<Studente>();
				
				connetti();
				
				String query = "SELECT matricola,password,nome,cognome,data_nascita,email,telefono FROM studente JOIN prenotazione ON prenotazione.cod_appello = '" + codAp + "' AND studente.matricola = prenotazione.mat_studente;";

				try{
					
					ResultSet res = st.executeQuery(query);
					
					while(res.next()){
						
						Studente corrente = new Studente();
					
						corrente.setUsername(res.getString("matricola"));
						corrente.setPassword(res.getString("password"));
						corrente.setNome(res.getString("nome"));
						corrente.setCognome(res.getString("cognome"));
						corrente.setNascita(res.getDate("data_nascita"));
						corrente.setEmail(res.getString("email"));
						corrente.setTelefono(res.getString("telefono"));
						
						studenti.add(corrente);
						
					}		
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				disconnetti();
				
				return studenti;
	}
	
	
	public boolean inserisciEsame(Esame es, Studente stud, Appello ap) {
		
		String matr = es.getMatStudente();
		String codMat = es.getCodMateria();
		String voto = es.getVoto();
		java.util.Date oggi = new java.util.Date(System.currentTimeMillis());
		java.sql.Date oggiSq = new java.sql.Date(oggi.getTime());
		
		connetti();
		
		String queryVerificaEsistenza = new String();
		
		queryVerificaEsistenza = "SELECT * FROM esame WHERE mat_studente= '" + matr +"' AND cod_materia = '" + codMat + "' ;";
		
		try{
			
			ResultSet res = st.executeQuery(queryVerificaEsistenza);
			
			if(res.next()){
				
				return ESAME_GIA_PRESENTE;
				
			} else {
				
				if(!voto.equals("-")) {
				
				String query1 = "INSERT INTO esame (cod_materia, mat_studente, data, voto) VALUES ('"+ codMat + "','" + stud.getUsername() + "','" + oggiSq + "','" + voto + "');";
				String query2 = "DELETE FROM prenotazione WHERE mat_studente='" + stud.getUsername() + "' AND cod_appello='" + ap.getCodice() + "';";
				
				st.executeUpdate(query1);
				st.executeUpdate(query2);
				
				disconnetti();

				return ESAME_INSERITO;
				
				} else {
					String query2 = "DELETE FROM prenotazione WHERE mat_studente='" + stud.getUsername() + "' AND cod_appello='" + ap.getCodice() + "';";
					
					
					st.executeUpdate(query2);
					
					disconnetti();
					return ESAME_INSERITO;

				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		disconnetti();
		
			return false;
			
	}
	
	
	public boolean aggiornaDatiAppello(Appello appll) {
		
		connetti();
	
		String query = "UPDATE appello SET data='" + appll.getData() + "', aula='" + appll.getAula()
						+ "', tipo='" + appll.getTipo() + "', cod_materia='" + appll.getCodiceMateria()
						+"' WHERE codice_app='" 
						+ appll.getCodice() +"';";
		
		try{
			
			st.executeUpdate(query);
			
			disconnetti();
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			
			
			
		}
		
		disconnetti();
			return false;
	}
	
	
	//public LinkedList<Materia> caricaMaterieDocente() {
	public LinkedList<Materia> caricaMaterieDocente(Docente doc) {	
		
		//String us = Docente.getDocenteCorrente().getUsername();
		String us = doc.getUsername();
		LinkedList<Materia> materie = new LinkedList<Materia>();
		
		connetti();
		
		String query = "SELECT * FROM materia WHERE user_docente = '" + us + "' ;";
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			while(res.next()){
				
				Materia corrente = new Materia();
			
				corrente.setCodice(res.getString("codice_mat"));
				corrente.setNome(res.getString("nome"));
				corrente.setCfu(res.getString("cfu"));
				corrente.setUserDocente(res.getString("user_docente"));
				
				materie.add(corrente);
				
			}		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		disconnetti();
		
		return materie;
		
	}
	
	
	public boolean aggiungiAppello(Appello ap) {
		
		connetti();
		
		try{
			
			String query = "INSERT INTO appello (codice_app, data, aula, tipo, cod_materia) VALUES ('"+ ap.getCodice() + "', '" + ap.getData() + "', '" + ap.getAula() + "', '" + ap.getTipo() + "', '" + ap.getCodiceMateria() + "');";
			st.executeUpdate(query);
			
			
			return APPELLO_INSERITO;
	
		}catch(Exception e){
			e.printStackTrace();
			
		
		}
		
		disconnetti();
		return APPELLO_NON_INSERITO;
	}
	
	
	public int cancellaAppello(Appello p) {
		
		String codApp = p.getCodice();
		
		connetti();
		
		String query = "DELETE FROM appello WHERE codice_app =  '" + codApp + "' ;";
		
		try{
			
			st.executeUpdate(query);	
			
		}catch(Exception e){
			e.printStackTrace();
			disconnetti();
			return APPELLO_NON_CANCELLATO;
		}
		disconnetti();
		return APPELLO_CANCELLATO;
		
	}
	
	
	public boolean verificaDatiStudente(Studente stud) {
		
		String matricolaInserita = stud.getUsername();
		String passwordInserita = stud.getPassword();
		
		connetti();
		
		String query = "SELECT matricola, password FROM studente WHERE matricola = " + " '"+matricolaInserita+"' " + " AND password= " + " '" + passwordInserita + "' ";
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			if(res.next()) {
				return CREDENZIALI_VALIDE;
			} else {
				disconnetti();
				return CREDENZIALI_NON_VALIDE;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		return CREDENZIALI_NON_VALIDE;
		
	}
	
	
	public Studente caricaDatiStudente(Studente stud) {
		
		String matricolaInserita = stud.getUsername();
		String passwordInserita = stud.getPassword();
		Studente newStud = new Studente();
		
		connetti();
		
		String query = "SELECT * FROM studente WHERE matricola = " + " '"+matricolaInserita+"' " + " AND password= " + " '" + passwordInserita + "' ";
		
		try{
			
			ResultSet res = st.executeQuery(query);

			if(res.next()){
				
				newStud.setUsername(res.getString("matricola"));
				newStud.setPassword(res.getString("password"));
				newStud.setNome(res.getString("nome"));
				newStud.setCognome(res.getString("cognome"));
				newStud.setNascita(res.getDate("data_nascita"));
				newStud.setEmail(res.getString("email"));
				newStud.setTelefono(res.getString("telefono"));
				newStud.setCodCorso(res.getString("cod_corso"));
				
				return newStud;
				
			} else {
				disconnetti();
				return newStud;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		return newStud;
		
	}
	
	
	//public boolean aggiornaDatiStudente(Studente studente) {
	public boolean aggiornaDatiStudente(Studente studenteVecchio, Studente studenteNuovo) {	
		
		/*String nwPss = studente.getPassword();
		String nwEma = studente.getEmail();
		String nwTel = studente.getTelefono();
		String user = studente.getUsername();
		
		connetti();
		
		String query = "UPDATE studente SET telefono='" + nwTel + "', email='" + nwEma +"', password='" + nwPss + "' WHERE matricola='" + user +"';";

		try{
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		
		return true;*/
		
		String nwPss = studenteNuovo.getPassword();
		String nwEma = studenteNuovo.getEmail();
		String nwTel = studenteNuovo.getTelefono();
		String matr = studenteVecchio.getUsername();
		
		connetti();
		
		if(!nwPss.equals(studenteVecchio.getPassword())) {
			
			String queryPass = "UPDATE studente SET password='" + nwPss + "' WHERE Matricola='" + matr +"';";
			
			try{
				st.executeUpdate(queryPass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		if(!nwEma.equals(studenteVecchio.getEmail())) {
			
			String queryEmail = "UPDATE studente SET email='" + nwEma + "' WHERE Matricola='" + matr +"';";
			
			try{
				st.executeUpdate(queryEmail);
			} catch (SQLException e) {
				e.printStackTrace();
			}


		}
		
		if(!nwTel.equals(studenteVecchio.getTelefono())) {
			
			String queryTel = "UPDATE studente SET telefono='" + nwTel + "' WHERE Matricola='" + matr +"';";
			
			try{
				st.executeUpdate(queryTel);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		disconnetti();
		
		return true;
		
	}
	
	
	public Corso caricaCorso(Studente stud) {
		
		Corso corso = new Corso();
		
		connetti();
		
		String corsoStudente = stud.getCodCorso();
		
		String query = "SELECT * FROM corso WHERE corso.codice =  '" + corsoStudente + "';";

		try{
			
			ResultSet res = st.executeQuery(query);
			
			if(res.next()){
				corso.setCodice(res.getString("codice"));
				corso.setNome(res.getString("nome"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		return corso;
		
	}
	
	
	public LibrettoStudente caricaLibretto(Studente stud, Corso c) {
		
		LibrettoStudente ps = new LibrettoStudente();
		LinkedList<Materia> linkMaterie = new LinkedList<Materia>();
		LinkedList<Esame> linkEsami = new LinkedList<Esame>();
		
		connetti();
		
		ps.setCorso(c.getCodice(), c.getNome());
		
		String queryMat = "SELECT * FROM materia  WHERE materia.cod_corso = '" + stud.getCodCorso() + "';";

		try{
			
			ResultSet resMat = st.executeQuery(queryMat);

			while(resMat.next()){
				
				Materia matC = new Materia();
				
				matC.setCodice(resMat.getString("codice_mat"));
				matC.setNome(resMat.getString("nome"));
				matC.setCfu(resMat.getString("cfu"));
				matC.setUserDocente(resMat.getString("user_docente"));
				matC.setCodiceCorso(resMat.getString("cod_corso"));
				linkMaterie.add(matC);
				
			}
			
			
			String queryEs = "SELECT * FROM esame INNER JOIN materia ON materia.codice_mat = esame.cod_materia AND materia.cod_corso='" + stud.getCodCorso() + "' AND esame.mat_studente='" + stud.getUsername() + "';";
		
			ResultSet resEs = st.executeQuery(queryEs);

			while(resEs.next()){
				
				Esame esC = new Esame();
				
				esC.setCodMateria(resEs.getString("cod_materia"));
				esC.setMatStudente(resEs.getString("mat_studente"));
				esC.setData(resEs.getDate("data"));
				esC.setVoto(resEs.getString("voto"));
				
				linkEsami.add(esC);
			
			}
			
			ps.setMaterie(linkMaterie);
			ps.setEsami(linkEsami);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnetti();
		return ps;
		
	}
	
	
	public Esame caricaEsame(Studente studente, Materia mat){
		
		Esame es = new Esame();
		
		connetti();

		String query = "SELECT * FROM esame WHERE cod_materia = '" + mat.getCodice() + "' AND mat_studente = '" + studente.getUsername() + "';"; 
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			while(res.next()){
				
				es.setCodMateria(res.getString("cod_materia"));
				es.setMatStudente(res.getString("mat_studente"));
				es.setData(res.getDate("data"));
				es.setVoto(res.getString("voto"));
				
				return es;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		disconnetti();
		return es;	
		
	}
	
	
	public LinkedList<Appello> caricaAppelliMateria(Materia mat){
		
		LinkedList<Appello> appelli = new LinkedList<Appello>();
		String codiceMateria = mat.getCodice();
		
		connetti();
		
		String query = "SELECT * FROM appello WHERE cod_materia =  '" + codiceMateria + "'";
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			while(res.next()){
				
				Appello corrente = new Appello();
				
				corrente.setCodice(res.getString("codice_app"));
				
				String dataprova = res.getString("data");
				Timestamp timestampData = Timestamp.valueOf(dataprova);
				corrente.setData(timestampData);
				
				corrente.setAula(res.getString("aula"));
				corrente.setTipo(res.getString("tipo"));
				corrente.setCodiceMateria("cod_materia");
				
				appelli.add(corrente);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		disconnetti();
		return appelli;
		
	}
	
	
	public int inserisciPrenotazione(Studente stud, Appello ap){
		
		Studente stud1 = Studente.getStudenteCorrente();
		
		String codAp = ap.getCodice();
		java.sql.Date oggi = new java.sql.Date(System.currentTimeMillis());
		
		String matr = stud1.getUsername();
		
		connetti();
		
		String queryVerificaEsistenza = new String();
		
		queryVerificaEsistenza = "SELECT * FROM prenotazione WHERE mat_studente = '" + matr +"' AND cod_appello = '" + codAp + "' ;";
		
		try{
			
			ResultSet res = st.executeQuery(queryVerificaEsistenza);
			
			if(res.next()){
				disconnetti();
				return this.PRENOTAZIONE_GIA_ESISTENTE;
				
			} else {
				
				String query = "INSERT INTO prenotazione (cod_appello, mat_studente, data) VALUES ('"+ codAp + "','" + matr + "','" + oggi + "');";
				st.executeUpdate(query);
				disconnetti();
				return PRENOTAZIONE_INSERITA;
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

		disconnetti();
		return 0; 
	}
	
	
	public LinkedList<PrenAppMat> caricaPrenotazioneAppello(Studente stud){
		
		LinkedList<PrenAppMat> listaPrenApp = new LinkedList<PrenAppMat>();
		
		connetti();
		
		String query = "SELECT materia.nome, appello.data, appello.aula, appello.tipo, prenotazione.data, prenotazione.cod_appello, prenotazione.mat_studente "
				+ "FROM materia "
				+ "INNER JOIN appello "
				+ "ON appello.cod_materia = materia.codice_mat "
				+ "INNER JOIN prenotazione "
				+ "ON prenotazione.cod_appello = appello.codice_app AND prenotazione.mat_studente='" + stud.getUsername() + "';";
		
		try{
			
			ResultSet res = st.executeQuery(query);
			
			while(res.next()){
				
				PrenAppMat effettuataP = new PrenAppMat();
				
				effettuataP.setNomeMateria(res.getString("nome"));
				effettuataP.setDataApp(res.getTimestamp("data"));
				effettuataP.setAula(res.getString("aula"));
				effettuataP.setTipo(res.getString("tipo"));
				effettuataP.setDataPren(res.getDate("data"));
				effettuataP.setCodAppello(res.getString("cod_appello"));
				effettuataP.setMatStudente(res.getString("mat_studente"));
				
				listaPrenApp.add(effettuataP);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		disconnetti();
		return listaPrenApp;
		
	}
	
	public int cancellaPrenotazione(PrenAppMat prenApp) {
		
		String codApp = prenApp.getCodAppello();
		String matrStud = prenApp.getMatStudente();
		
		connetti();
		
		String query = "DELETE FROM prenotazione WHERE cod_appello =  '" + codApp + "' AND mat_studente = '" + matrStud + "';";		
		
		try{
			st.executeUpdate(query);
			disconnetti();
			return PRENOTAZIONE_CANCELLATA;
		}catch(Exception e){
			e.printStackTrace();
			disconnetti();
			return 0;
		}

	}
	

}
