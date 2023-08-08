package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.Screen1;

public class View {

	Model model;
	Screen1 screen1;

	public View(Model model) {
		this.model = model;
		screen1 = new Screen1(model.pazServ);
	}

}
