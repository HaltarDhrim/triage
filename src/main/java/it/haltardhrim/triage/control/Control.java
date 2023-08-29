package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.MainScreen;
import it.haltardhrim.triage.view.PazientiTableModel;

public class Control implements ControlListener {

	Model model;
	View view;

	public Control() {
		model = new Model(this);
		view = new View(this);
	}

	@Override
	public void aggiornaClicked(PazientiTableModel tableModel) {
		tableModel.reset(model.getCodaPazienti());
	}

	@Override
	public void accogliClicked(String codfisc, int priorita, MainScreen mainScreen) {
		model.accogliPaziente(codfisc, priorita);
		mainScreen.fireAggiorna();
	}

	@Override
	public void dimettiClicked(int id) {
		model.dimettiPaziente(id);
	}
}
