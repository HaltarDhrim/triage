package it.haltardhrim.triage.control;

import java.util.ArrayList;

import it.haltardhrim.triage.model.Paziente;
import it.haltardhrim.triage.model.PazienteService;

public class Model {

	Control control;
	PazienteService pazServ;

	public Model(Control control) {
		this.control = control;
		pazServ = new PazienteService();
	}

	public ArrayList<Paziente> getCodaPazienti() {
		return pazServ.getCodaPazienti();
	}

	public void accogliPaziente(String codfisc, int priorita) {
		pazServ.accogliPaziente(new Paziente(codfisc, priorita));
	}

	public void dimettiPaziente(int id) {
		pazServ.dimettiPaziente(id);
	}
}