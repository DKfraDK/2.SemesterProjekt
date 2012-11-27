package service;

import java.util.ArrayList;

import model.Behandling;
import model.Delbehandling;
import model.Mellemvare;
import model.Mellemvarelager;
import model.Produkttype;

public class Service {

	public static void nyDag(Mellemvarelager lager) {
		int nyDag = lager.getDage() + 1;
		lager.setDage(nyDag);
	}

	public static void createSomeObjects() {

		Mellemvarelager lager = new Mellemvarelager(
				"lager 1 (fem dage gammelt)");
		lager.setDage(5);

		Delbehandling dSkum = createDelbehandling("Skum", 1, 2, 5);
		Delbehandling dChoko = createDelbehandling("ChokoladeOvertraek", 2, 3,
				4);
		Delbehandling dDragee = createDelbehandling("Drageering", 3, 4, 12);
		Delbehandling dChokoYderst = createDelbehandling(
				"ChokoladeOvertraek yderst", 2, 3, 5);
		Delbehandling dHvile = createDelbehandling("Hvile periode", 1, 2, 8);
		Behandling bChokoSkum = createBehandling("Chokolade Skum");
		addDelbehandlingTilBehandling(bChokoSkum, dSkum);
		addDelbehandlingTilBehandling(bChokoSkum, dChoko);
		addDelbehandlingTilBehandling(bChokoSkum, dHvile);
		addDelbehandlingTilBehandling(bChokoSkum, dChokoYderst);
		Behandling bLakrids = createBehandling("Lakrids knas");
		addDelbehandlingTilBehandling(bLakrids, dHvile);
		addDelbehandlingTilBehandling(bLakrids, dDragee);
		addDelbehandlingTilBehandling(bLakrids, dDragee);
		Behandling bChokoLakrids = createBehandling("Chokalde Lakrids");
		addDelbehandlingTilBehandling(bChokoLakrids, dChoko);
		addDelbehandlingTilBehandling(bChokoLakrids, dDragee);
		addDelbehandlingTilBehandling(bChokoSkum, dChoko);
		addDelbehandlingTilBehandling(bChokoLakrids, dHvile);
		addDelbehandlingTilBehandling(bChokoLakrids, dChokoYderst);
		Produkttype pSkumBanan = createProdukttype("SkumBanan", bChokoSkum);
		Produkttype pPTaerter = createProdukttype("PTaerter", bChokoSkum);
		Produkttype pLakridsPinde = createProdukttype("LakridsPinde", bLakrids);
		Produkttype pChokoladeLakrids = createProdukttype(
				"ChokoladeOvertrukketLakrids", bChokoLakrids);
		Mellemvare m1 = createMellemvare("Vare1", pSkumBanan, 1);
		Mellemvare m2 = createMellemvare("Vare2", pSkumBanan, 1);
		Mellemvare m3 = createMellemvare("Vare3", pSkumBanan, 2);

		Mellemvare m4 = createMellemvare("Vare4", pPTaerter, 1);
		Mellemvare m5 = createMellemvare("vare5", pPTaerter, 2);

		Mellemvare m6 = createMellemvare("vare6", pLakridsPinde, 4);

		Mellemvare m7 = createMellemvare("vare7", pChokoladeLakrids, 3);

	}

	public static Mellemvare createMellemvare(String id,
			Produkttype produkttype, int tid) {
		Mellemvare mellemvare = new Mellemvare(id, produkttype, tid);
		if (!Dao.getMellemvarer().contains(mellemvare)) {
			Dao.addMellemvare(mellemvare);
		}
		return mellemvare;
	}

	public static void updateMellemvare(Mellemvare mellemvare, String id,
			Produkttype produkttype) {
		mellemvare.setId(id);
		mellemvare.setProdukttype(produkttype);
	}

	public static void deleteMellemvare(Mellemvare mellemvare) {
		Dao.removeMellemvare(mellemvare);
	}

	public static Produkttype createProdukttype(String navn,
			Behandling behandling) {
		Produkttype produkttype = new Produkttype(navn, behandling);
		if (!Dao.getProdukttyper().contains(produkttype)) {
			Dao.addProdukttype(produkttype);
		}
		return produkttype;
	}

	public static void updateProdukttype(Produkttype produkttype, String navn,
			Behandling behandling) {
		produkttype.setBehandling(behandling);
		produkttype.setNavn(navn);
	}

	public static void deleteProdukttype(Produkttype produkttype) {
		Dao.removeProdukttype(produkttype);
	}

	public static Behandling createBehandling(String navn) {
		Behandling behandling = new Behandling(navn);
		if (!Dao.getBehandlinger().contains(behandling)) {
			Dao.addBehandling(behandling);
		}
		return behandling;
	}

	public static void updateBehandling(Behandling behandling, String navn) {
		behandling.setNavn(navn);
	}

	public static void addDelbehandlingTilBehandling(Behandling behandling,
			Delbehandling delbehandling) {
		behandling.addDelbehandling(delbehandling);
	}

	public static void deleteBehandling(Behandling behandling) {
		Dao.removeBehandling(behandling);
	}

	public static Delbehandling createDelbehandling(String navn, int min,
			int ideal, int max) {
		Delbehandling delbehandling = new Delbehandling(navn, min, ideal, max);
		if (!Dao.getDelbehandling().contains(delbehandling)) {
			Dao.addDelbehandling(delbehandling);
		}
		return delbehandling;
	}

	public static void updateDelbehandling(Delbehandling delbehandling,
			String navn, int min, int ideal, int max) {
		delbehandling.setNavn(navn);
		delbehandling.setMinToerreTid(min);
		delbehandling.setIdealToerreTid(ideal);
		delbehandling.setMaxToerreTid(max);
	}

	public static void deleteDelBehandling(Delbehandling delbehandling) {
		Dao.removeDelbehandling(delbehandling);
	}

	public static ArrayList<Mellemvare> getMellemvarer() {
		return new ArrayList<Mellemvare>(Dao.getMellemvarer());
	}

	public static ArrayList<Produkttype> getProdukttyper() {
		return new ArrayList<Produkttype>(Dao.getProdukttyper());
	}

	public static ArrayList<Behandling> getBehandling() {
		return new ArrayList<Behandling>(Dao.getBehandlinger());
	}

	public static ArrayList<Delbehandling> getDelbehandlinger() {
		return new ArrayList<Delbehandling>(Dao.getDelbehandling());
	}
}