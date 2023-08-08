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
	
	public ArrayList<Paziente> mostraCodaPazienti() {
		return pazDAO.readPazientiInCoda();
	}
	
	public void visitaPaziente(Paziente paz) {
		paz.setStato(paz.IN_VISITA);
		pazDAO.updatePazienteStato(paz);
	}
	
	public void operaPaziente(Paziente paz) {
		paz.setStato(paz.IN_INTERVENTO);
		pazDAO.updatePazienteStato(paz);
	}
	
	public void osservaPaziente(Paziente paz) {
		paz.setStato(paz.IN_OSSERVAZIONE);
		pazDAO.updatePazienteStato(paz);
	}
	
	public void dimettiPaziente(Paziente paz) {
		paz.setStato(paz.EVASO);
		pazDAO.updatePazienteStato(paz);
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
