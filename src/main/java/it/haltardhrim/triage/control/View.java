package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.AccogliScreen;
import it.haltardhrim.triage.view.MainScreen;

public class View {

	Control control;
	MainScreen screen1;
	AccogliScreen screen2;

	public View(Control control) {
		this.control = control;
		screen1 = new MainScreen(control);
	}

	public void accogliPaziente() {
		screen2 = new AccogliScreen(control, screen1);
	}

}
