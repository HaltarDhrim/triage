package it.haltardhrim.triage.control;

import java.util.ArrayList;

import it.haltardhrim.triage.model.Paziente;
import it.haltardhrim.triage.view.PazientiTable;

public class Control implements ControlListener {

	Model model;
	View view;

	public Control() {
		model = new Model(this);
		view = new View(this);
	}

	@Override
	public void aggiornaClicked(PazientiTable tableModel) {
		ArrayList<Paziente> t = model.getPazienteService().mostraCodaPazienti();
		tableModel.reset(t);
	}
}
