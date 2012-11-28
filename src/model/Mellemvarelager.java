package model;

import java.util.ArrayList;
import java.util.List;

import service.Service;

public class Mellemvarelager {
	private static Mellemvarelager uniqueInstance;
	private List<String> placeringer = new ArrayList<String>();
	private ArrayList<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
	private ArrayList<Mellemvare> faerdigeMellemvarer = new ArrayList<Mellemvare>();
	private String navn;
	private int dage = 0;

	private Mellemvarelager(String navn) {
		this.navn = navn;
	}

	public static Mellemvarelager getInstance(String newnavn) {
		if (uniqueInstance == null) {
			uniqueInstance = new Mellemvarelager(newnavn);
		}
		return uniqueInstance;
	}

	public ArrayList<Mellemvare> getOversigtOverKritiskeMellemvarer() {
		ArrayList<Mellemvare> mellemvarerTilToerring = new ArrayList<Mellemvare>();
		for (Mellemvare m : mellemvarer) {
			if (m.getStatus().equals(Status.TILTOERRING)) {
				if (m.getNaesteDelbehandling().getIdealToerreTid() <= getDageSidenForrigeDelbehandling(m)
						&& m.getNaesteDelbehandling().getMaxToerreTid() >= getDageSidenForrigeDelbehandling(m)) {
					mellemvarerTilToerring.add(m);
				}
			}
		}

		return mellemvarerTilToerring;
	}

	public ArrayList<Mellemvare> getFaerdigeMellemvarer() {
		return new ArrayList<Mellemvare>(faerdigeMellemvarer);
	}

	public int getDageSidenForrigeDelbehandling(Mellemvare m) {
		return dage
				- m.getToerretider().get(m.getToerretider().size() - 1)
						.getTid();
	}

	/**
	 * Finder næste mellemvare til videre behandling fortager en vægtet
	 * udvælgese på baggrund af mellemvarens "alder" dvs. at en vare der er
	 * tættere på dens max tid for prioritet, for at minimere tab
	 * 
	 * @return Mellemvare note, hvis der ikke er flere behandlinger for
	 *         mellemvare bliver den automatisk tilføjet til færdigvare listen
	 * 
	 * */

	public Mellemvare getNaesteMellemvareTilBehandling() {
		Mellemvare resultMellemvare = null;
		int max = mellemvarer.get(0).getSidsteDelbehandling().getMaxToerreTid();
		int min = mellemvarer.get(0).getSidsteDelbehandling().getMinToerreTid();
		int ideal = mellemvarer.get(0).getSidsteDelbehandling()
				.getIdealToerreTid();
		boolean isFaerdig = false;
		for (Mellemvare m : mellemvarer) {
			Delbehandling d = m.getNaesteDelbehandling();
			if (d != null) {
				int antalDagePaaLager = getDageSidenForrigeDelbehandling(m);
				if (d.getMaxToerreTid() >= max
						&& d.getMaxToerreTid() <= antalDagePaaLager) {
					resultMellemvare = m;
					max = d.getMaxToerreTid();
				} else if (d.getIdealToerreTid() >= ideal
						&& d.getIdealToerreTid() <= antalDagePaaLager) {
					resultMellemvare = m;
					ideal = d.getIdealToerreTid();
				} else if (d.getMinToerreTid() >= min
						&& d.getMinToerreTid() <= antalDagePaaLager) {
					resultMellemvare = m;
					min = d.getMinToerreTid();
				}
			} else {
				isFaerdig = true;
				resultMellemvare = m;
			}
		}
		if (resultMellemvare != null && isFaerdig) {
			flytTilFaerdigvare(resultMellemvare);
		}

		else if (resultMellemvare != null) {
			resultMellemvare.createToerretid(dage);
		}
		return resultMellemvare;
	}

	/**
	 * støtte metode til at flytte en mellemvare til færdigvare
	 * 
	 * @param m
	 *            den mellemvarse man ønsker at flytte
	 */
	private void flytTilFaerdigvare(Mellemvare m) {
		mellemvarer.remove(m);
		faerdigeMellemvarer.add(m);
	}

	public ArrayList<Mellemvare> getMellemvarer() {
		return new ArrayList<Mellemvare>(mellemvarer);
	}

	public void addMellemvare(Mellemvare mellemvare) {
		if (!mellemvarer.contains(mellemvare)) {
			mellemvarer.add(mellemvare);
		}
	}

	public void removeMellemvare(Mellemvare mellemvare) {
		if (mellemvarer.contains(mellemvare)) {
			mellemvarer.remove(mellemvare);
		}
	}

	public int getPlacering(Mellemvare m) {
		return placeringer.indexOf(m);

	}

	public int getDage() {
		return dage;
	}

	public void setDage(int dage) {
		this.dage = dage;
	}

	public void updateLagerBeholdning() {
		mellemvarer = Service.getMellemvarer();
	}

	public ArrayList<Mellemvare> getForGamleMellemvarer() {
		ArrayList<Mellemvare> resultList = new ArrayList<Mellemvare>();
		for(Mellemvare m : mellemvarer){
			if(m.getSidsteDelbehandling().getMaxToerreTid() < getDageSidenForrigeDelbehandling(m)){
				resultList.add(m);
			}
		}
		return resultList;
	}
	
	public void clearLager(){
		mellemvarer.clear();
	}

}
