package it.haltardhrim.triage;

import java.util.*;

public class App {

	public static void main(String[] args) {
		// Inizializza servizio
		PazienteService pazServ = new PazienteService();

		// Test 1: Crea un nuovo Paziente e inseriscilo in tabella
		// Paziente paz = new Paziente();
		// paz.setCodfisc("Pippo");
		// paz.setPrioritaIniz(paz.BIANCO);
		// pazServ.accogliPaziente(paz);
		// System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");
        // 
		// paz.setCodfisc("Paperino");
		// paz.setPrioritaIniz(paz.GIALLO);
		// pazServ.accogliPaziente(paz);
		// System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");
        // 
		// paz.setCodfisc("Pluto");
		// paz.setPrioritaIniz(paz.BIANCO);
		// pazServ.accogliPaziente(paz);
		// System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");

		// Test 2: Mostra lista Pazienti in coda
		ArrayList<Paziente> pazList = pazServ.mostraCodaPazienti();
		System.out.println("Lista Coda Pazienti");
		System.out.println("ID   Priorita   Cod.Fisc.");
		System.out.println("-------------------------");
		for (Paziente paz: pazList) {
			System.out.println(paz.getId() + "   " + paz.getPriorita() + "   " + paz.getCodfisc());
		}

		// Test 3: Aggiorna Stato Paziente
		for (Paziente paz: pazList) {
			if (paz.getCodfisc().trim().equals("Paperino")) {
				pazServ.operaPaziente(paz);
				System.out.println("Il paziente " + paz.getCodfisc() + " è ora in stato " + paz.getStato());
			}
		}

		// Test 4: Aggiorna Priorita Paziente
		for (Paziente paz: pazList) {
			if (paz.getCodfisc().trim().equals("Pippo")) {
				paz.setPriorita(paz.VERDE);
				pazServ.aggravaPaziente(paz);
				System.out.println("Il paziente " + paz.getCodfisc() + " ha ora priorità " + paz.getPriorita());
			}
		}

		// Test 5: Elimina Paziente (che è diverso da segnarlo come Evaso! Viene cancellato del tutto)
		for (Paziente paz: pazList) {
			if (paz.getCodfisc().trim().equals("Pluto")) {
				pazServ.eliminaPaziente(paz);
				System.out.println("Il paziente " + paz.getCodfisc() + " è stato cancellato, dato che è un cane");
			}
		}

	}
}
