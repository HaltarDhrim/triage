package it.haltardhrim.triage.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.*;

import it.haltardhrim.triage.model.Paziente;
import it.haltardhrim.triage.model.PazienteService;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AppTest {

	static PazienteService pazServ;
	static ArrayList<Paziente> pazList;
	static Paziente paz;

	@BeforeAll
	// Inizializza servizio
	static void beforeAll() {
		pazServ = new PazienteService();
		paz = new Paziente();
		pazServ.resetPazienti();

		//Verifica: la tabella è vuota
		pazList = pazServ.getCodaPazienti();
		assertEquals(0,pazList.size(),"BeforeAll: tabella Pazienti non vuota");
	}

	@Test
	// Test 1: Crea un nuovo Paziente e inseriscilo in tabella
	void test1InsertPaziente() {
    	paz.setCodfisc("Pippo");
		paz.setPrioritaIniz(paz.BIANCO);
		pazServ.accogliPaziente(paz);
         
		paz.setCodfisc("Paperino");
		paz.setPrioritaIniz(paz.GIALLO);
		pazServ.accogliPaziente(paz);
         
		paz.setCodfisc("Pluto");
		paz.setPrioritaIniz(paz.ROSSO);
		pazServ.accogliPaziente(paz);

		//Verifica: la tabella contiene i record inseriti
		pazList = pazServ.getCodaPazienti();

		for (Paziente p: pazList) {
			switch (p.getCodfisc().trim()) {
				case "Pippo":
					assertAll("Verifica Pippo",
							() -> assertEquals("Pippo",p.getCodfisc().trim(),"Test 1: Pippo.codfisc errato"),
							() -> assertEquals(p.BIANCO,p.getPrioritaIniz(),"Test 1: Pippo.prioritaIniz errata"));
					break;
				case "Paperino":
					assertAll("Verifica Paperino",
							() -> assertEquals("Paperino",p.getCodfisc().trim(),"Test 1: Paperino.codfisc errato"),
							() -> assertEquals(p.GIALLO,p.getPrioritaIniz(),"Test 1: Paperino.prioritaIniz errata"));
					break;
				case "Pluto":
					assertAll("Verifica Pluto",
							() -> assertEquals("Pluto",p.getCodfisc().trim(),"Test 1: Pluto.codfisc errato"),
							() -> assertEquals(p.ROSSO,p.getPrioritaIniz(),"Test 1: Pluto.prioritaIniz errata"));
					break;
				default:
					fail("Test 1: Paziente errato: " + p.getCodfisc());
					break;
			}
		}
	}

	@Test
	// Test 2: Aggiorna Stato Paziente
	void test2UpdatePazienteStato() {
		pazList = pazServ.getCodaPazienti();
		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Paperino")) {
				pazServ.operaPaziente(p);
			}
		}

		// Verifica: lo stato di Paperino è cambiato
		pazList = pazServ.getCodaPazienti();

		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Paperino")) {
				assertEquals(p.IN_INTERVENTO,p.getStato(),"Test 2: Paperino.stato errato");
			}
		}
	}

	@Test
	// Test 3: Aggiorna Priorita Paziente
	void test3UpdatePazientePriorita() {
		pazList = pazServ.getCodaPazienti();
		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Pippo")) {
				p.setPriorita(p.VERDE);
				pazServ.aggravaPaziente(p);
			}
		}

		// Verifica: la priorità di Pippo è cambiata
		pazList = pazServ.getCodaPazienti();

		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Pippo")) {
				assertEquals(p.VERDE,p.getPriorita(),"Test 3: Pippo.priorita errata");
			}
		}
	}

	@Test
    // Test 4: Elimina Paziente (che è diverso da segnarlo come Evaso! Viene cancellato del tutto)
	void test4DeletePaziente() {
		pazList = pazServ.getCodaPazienti();
		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Pluto")) {
				pazServ.eliminaPaziente(p);
			}
		}

		//Verifica: la tabella non contiene piu' Pluto
		pazList = pazServ.getCodaPazienti();

		for (Paziente p: pazList) {
			if (p.getCodfisc().trim().equals("Pluto")) {
				fail("Test 4: Pluto non cancellato");
			}
		}
	}

	@AfterAll
	// Mostra il risultato finale
	static void afterAll() {
		pazList = pazServ.getCodaPazienti();
		System.out.println("Lista Coda Pazienti");
		System.out.println("ID   Priorita   Cod.Fisc.");
		System.out.println("-------------------------");
		for (Paziente p: pazList) {
			System.out.println(p.getId() + "   " + p.getPriorita() + "   " + p.getCodfisc());
		}
	}

}
