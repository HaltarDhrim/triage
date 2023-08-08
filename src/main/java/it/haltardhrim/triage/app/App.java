package it.haltardhrim.triage.app;

import javax.swing.SwingUtilities;

import it.haltardhrim.triage.control.Control;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				runApp();
			}
		});
	}

	public static void runApp() {
		Control control = new Control();
	}
}
