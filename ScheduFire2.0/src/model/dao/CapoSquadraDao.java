package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConnessioneDB;
import model.bean.CapoSquadraBean;

/**
 * Classe che si occupa della gestione dei dati 
 * persistenti relativi all'entità 'CapoSquadra'
 * @author Eugenio Sottile
 */

public class CapoSquadraDao {
	
	/**
	 * Ottiene un CapoSquadra dalla base di dati
	 * @param chiaveUsername stringa che identifica un CapoSquadraBean tramite l'username
	 * @return un tipo CapoSquadraBean identificato da chiaveUsername, null altrimenti
	 */
	public static CapoSquadraBean ottieni(String chiaveUsername) {

		try(Connection con = ConnessioneDB.getConnection()) {
				
			// Esecuzione query
			PreparedStatement ps = con.prepareStatement("select * from CapoSquadra where username = ?;");
			ps.setString(1, chiaveUsername);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				// Ottenimento dati dall'interrogazione
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				String turno = rs.getString("turno");
				String username = rs.getString("username");
				
				//Instanziazione oggetto CapoSquadraBean
				CapoSquadraBean ct = new CapoSquadraBean();
				ct.setNome(nome);
				ct.setCognome(cognome);
				ct.setEmail(email);
				ct.setTurno(turno);
				ct.setUsername(username);
				
				return ct;
				
			} else {
				return null;
			}
				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
