package it.haltardhrim.triage.control;

public class Control {

	Model model;
	View view;

	public Control() {
		model = new Model();
		view = new View(model);
	}

}
