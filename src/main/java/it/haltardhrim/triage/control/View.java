package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.AccogliPane;
import it.haltardhrim.triage.view.MainScreen;

public class View {

	Control control;
	MainScreen mainScreen;
	AccogliPane accogliScreen;

	public View(Control control) {
		this.control = control;
		mainScreen = new MainScreen(control);
	}
}
