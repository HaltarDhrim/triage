package it.haltardhrim.triage.model;

import java.sql.*;
import java.util.*;

/**
 * Questa classe fa parte del pattern DAO.
 * Risponde alla domanda: come gestisco un Paziente nel DB?
 * Contiene i metodi CRUD necessari per manipolare i Pazienti nel DB.
 */
public class PazienteDAO {

	private Connection conn = null;
	private PreparedStatement query = null;

	private final String CREATE_PAZIENTE =
		"INSERT INTO pazienti (id,codfisc,prioritaIniz,priorita,stato,userInsert,timeInsert,userUpdate,timeUpdate)" +
		"VALUES (default,?,?,?,?,?,?,?,?)";
	private final String READ_PAZIENTI_IN_CODA =
		"SELECT * FROM pazienti WHERE stato <> 5 ORDER BY priorita,timeInsert";
	private final String UPDATE_PAZIENTE_STATO =
		"UPDATE pazienti SET stato = ?, userUpdate = ?, timeUpdate = ? WHERE id = ?";
	private final String UPDATE_PAZIENTE_PRIORITA =
		"UPDATE pazienti SET priorita = ?, userUpdate = ?, timeUpdate = ? WHERE id = ?";
	private final String DELETE_PAZIENTE =
			"DELETE FROM pazienti WHERE id = ?";
	private final String DELETE_ALL_PAZIENTI =
			"DELETE FROM pazienti";

	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/triage", "postgres", "postgres");
		} catch (Exception e) {
			System.err.println("Errore in fase di connessione al DB");
			e.printStackTrace();
		}

		return conn;
	}

	public void createPaziente(Paziente paz) {
		try {
			conn = this.getConnection();
			query = conn.prepareStatement(CREATE_PAZIENTE);
			query.setString    (1, paz.getCodfisc());
			query.setInt       (2, paz.getPrioritaIniz());
			query.setInt       (3, paz.getPrioritaIniz());
			query.setInt       (4, paz.DA_VISITARE);
			query.setString    (5, "PazDAO");
			query.setTimestamp (6, new Timestamp(System.currentTimeMillis()));
			query.setString    (7, "");
			query.setTimestamp (8, new Timestamp(0));
			query.executeUpdate();
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione INSERT createPaziente");
			e.printStackTrace();
		}
	}

	public ArrayList<Paziente> readPazientiInCoda() {
		ArrayList<Paziente> list = new ArrayList<Paziente>();

		try {
			conn = this.getConnection();
			query = conn.prepareStatement(READ_PAZIENTI_IN_CODA);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				Paziente paz      = new Paziente();
				paz.setId           (result.getInt("id"));
				paz.setCodfisc      (result.getString("codfisc"));
				paz.setPrioritaIniz (result.getInt("prioritainiz"));
				paz.setPriorita     (result.getInt("priorita"));
				paz.setStato        (result.getInt("stato"));
				paz.setUserInsert   (result.getString("userinsert"));
				paz.setTimeInsert   (result.getTimestamp("timeinsert"));
				paz.setUserUpdate   (result.getString("userupdate"));
				paz.setTimeUpdate   (result.getTimestamp("timeupdate"));
				list.add(paz);
			}
			
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione SELECT readPazientiInCoda");
			e.printStackTrace();
		}

		return list;
	}

	public void updatePazienteStato(Paziente paz) {
		try {
			conn = this.getConnection();
			query = conn.prepareStatement(UPDATE_PAZIENTE_STATO);
			query.setInt       (1, paz.getStato());
			query.setString    (2, "PazDAO");
			query.setTimestamp (3, new Timestamp(System.currentTimeMillis()));
			query.setInt       (4, paz.getId());
			query.executeUpdate();
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione UPDATE updatePazienteStato");
			e.printStackTrace();
		}
	}

	public void updatePazientePriorita(Paziente paz) {
		try {
			conn = this.getConnection();
			query = conn.prepareStatement(UPDATE_PAZIENTE_PRIORITA);
			query.setInt       (1, paz.getPriorita());
			query.setString    (2, "PazDAO");
			query.setTimestamp (3, new Timestamp(System.currentTimeMillis()));
			query.setInt       (4, paz.getId());
			query.executeUpdate();
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione UPDATE updatePazientePriorita");
			e.printStackTrace();
		}
	}

	public void deletePaziente(Paziente paz) {
		try {
			conn = this.getConnection();
			query = conn.prepareStatement(DELETE_PAZIENTE);
			query.setInt       (1, paz.getId());
			query.executeUpdate();
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione DELETE deletePaziente");
			e.printStackTrace();
		}
	}

	public void deleteAllPazienti() {
		try {
			conn = this.getConnection();
			query = conn.prepareStatement(DELETE_ALL_PAZIENTI);
			query.executeUpdate();
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione DELETE deleteAllPazienti");
			e.printStackTrace();
		}
	}
}
