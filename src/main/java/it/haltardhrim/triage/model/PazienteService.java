package it.haltardhrim.triage.model;

import java.util.*;

/**
 * Questa classe fa parte del pattern DAO.
 * Risponde alla domanda: come lancio i comandi del DAO come utente?
 * L'utente manda dei comandi, che qui vengono gestiti richiamando i metodi DAO.
 */
public class PazienteService {

	private PazienteDAO pazDAO;
	
	public PazienteService() {
		pazDAO = new PazienteDAO();
	}
	
	public void accogliPaziente(Paziente paz) {
		pazDAO.createPaziente(paz);
	}
	
	public ArrayList<Paziente> getCodaPazienti() {
		return pazDAO.readPazientiInCoda();
	}
	
	public void visitaPaziente(int id) {
		pazDAO.updatePazienteStato(Paziente.IN_VISITA, id);
	}
	
	public void operaPaziente(int id) {
		pazDAO.updatePazienteStato(Paziente.IN_INTERVENTO, id);
	}
	
	public void osservaPaziente(int id) {
		pazDAO.updatePazienteStato(Paziente.IN_OSSERVAZIONE, id);
	}
	
	public void dimettiPaziente(int id) {
		pazDAO.updatePazienteStato(Paziente.EVASO, id);
	}
	
	public void aggravaPaziente(Paziente paz) {
		pazDAO.updatePazientePriorita(paz);
	}
	
	public void eliminaPaziente(Paziente paz) {
		pazDAO.deletePaziente(paz);
	}

	public void resetPazienti() {
		pazDAO.deleteAllPazienti();
	}
}
