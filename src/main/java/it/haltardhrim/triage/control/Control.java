package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.MainScreen;
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
		tableModel.reset(model.getCodaPazienti());
	}

	@Override
	public void accogliClicked() {
		view.accogliPaziente();
	}

	@Override
	public void accogliOkClicked(String codfisc, int priorita, MainScreen mainScreen) {
		model.accogliPaziente(codfisc, priorita);
		mainScreen.fireAggiorna();
	}
}
