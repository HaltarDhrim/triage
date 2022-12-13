package it.haltardhrim.triage;

import java.util.ArrayList;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AppTest {

	static PazienteService pazServ;
	ArrayList<Paziente> pazList;
	static Paziente paz;

	@BeforeAll
	// Inizializza servizio
	static void beforeAll() {
		System.out.println("---\n" + "Test 0: DeleteAllPazienti");

		pazServ = new PazienteService();
		paz = new Paziente();

		pazServ.resetPazienti();
		System.out.println("Tabella Pazienti ripulita.");
	}

	@Test
	// Test 1: Crea un nuovo Paziente e inseriscilo in tabella
	void test1InsertPaziente() {
    	System.out.println("---\n" + "Test 1: testInsertPaziente");

    	paz.setCodfisc("Pippo");
		paz.setPrioritaIniz(paz.BIANCO);
		pazServ.accogliPaziente(paz);
		System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");
         
		paz.setCodfisc("Paperino");
		paz.setPrioritaIniz(paz.GIALLO);
		pazServ.accogliPaziente(paz);
		System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");
         
		paz.setCodfisc("Pluto");
		paz.setPrioritaIniz(paz.BIANCO);
		pazServ.accogliPaziente(paz);
		System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");
	}

	@Test
	// Test 2: Mostra lista Pazienti in coda
	void test2SelectPaziente() {
    	System.out.println("---\n" + "Test 2: testSelectPaziente");

		pazList = pazServ.mostraCodaPazienti();
	}

	@Test
	// Test 3: Aggiorna Stato Paziente
	void test3UpdatePazienteStato() {
    	System.out.println("---\n" + "Test 3: testUpdatePazienteStato");

		pazList = pazServ.mostraCodaPazienti();
		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Paperino")) {
				pazServ.operaPaziente(p);
				System.out.println("Il paziente " + p.getCodfisc() + " è ora in stato " + p.getStato());
			}
		}
	}

	@Test
	// Test 4: Aggiorna Priorita Paziente
	void test4UpdatePazientePriorita() {
    	System.out.println("---\n" + "Test 4: testUpdatePazientePriorita");

		pazList = pazServ.mostraCodaPazienti();
		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Pippo")) {
				p.setPriorita(p.VERDE);
				pazServ.aggravaPaziente(p);
				System.out.println("Il paziente " + p.getCodfisc() + " ha ora priorità " + p.getPriorita());
			}
		}
	}

	@Test
    // Test 5: Elimina Paziente (che è diverso da segnarlo come Evaso! Viene cancellato del tutto)
	void test5DeletePaziente() {
    	System.out.println("---\n" + "Test 5: testDeletePaziente");

		pazList = pazServ.mostraCodaPazienti();
		for (Paziente paz: pazList) {
			if (paz.getCodfisc().trim().equals("Pluto")) {
				pazServ.eliminaPaziente(paz);
				System.out.println("Il paziente " + paz.getCodfisc() + " è stato cancellato, dato che è un cane");
			}
		}
	}

	@AfterEach
	// Mostra il risultato
	void afterEach() {
		pazList = pazServ.mostraCodaPazienti();
		System.out.println("Lista Coda Pazienti");
		System.out.println("ID   Priorita   Cod.Fisc.");
		System.out.println("-------------------------");
		for (Paziente p: pazList) {
			System.out.println(p.getId() + "   " + p.getPriorita() + "   " + p.getCodfisc());
		}
	}

}
