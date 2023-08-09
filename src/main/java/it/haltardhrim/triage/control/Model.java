package it.haltardhrim.triage.control;

import it.haltardhrim.triage.model.PazienteService;

public class Model {

	Control control;
	PazienteService pazServ;

	public Model(Control control) {
		this.control = control;
		pazServ = new PazienteService();
	}

	public PazienteService getPazienteService() {
		return pazServ;
	}
}