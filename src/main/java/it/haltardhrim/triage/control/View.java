package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.MainScreen;

public class View {

	Control control;
	MainScreen screen1;

	public View(Control control) {
		this.control = control;
		screen1 = new MainScreen(control);
	}

}
