package service;

import java.util.ArrayList;
import model.Behandling;
import model.Delbehandling;
import model.Mellemvare;
import model.Produkttype;

public class Service {
	public static void nyDag() {
	}

	public static void createSomeObjects() {
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