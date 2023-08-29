package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.AccogliScreen;
import it.haltardhrim.triage.view.MainScreen;

public class View {

	Control control;
	MainScreen mainScreen;
	AccogliScreen accogliScreen;

	public View(Control control) {
		this.control = control;
		mainScreen = new MainScreen(control);
	}

	public void accogliPaziente() {
		accogliScreen = new AccogliScreen(control, mainScreen);
	}

}
