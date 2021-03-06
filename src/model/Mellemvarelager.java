package model;

import java.util.ArrayList;
import java.util.List;

import service.Service;

public class Mellemvarelager {
	private static Mellemvarelager uniqueInstance;
	private List<String> placeringer = new ArrayList<String>();
	private ArrayList<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
	private ArrayList<Mellemvare> faerdigeMellemvarer = new ArrayList<Mellemvare>();
	private ArrayList<Mellemvare> forGamleMellemvare = new ArrayList<Mellemvare>();
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
		ArrayList<Mellemvare> kritiskeMellemvarer = new ArrayList<Mellemvare>();
		for (Mellemvare m : mellemvarer) {
			if (m.getStatus().equals(Status.TILTOERRING)) {
				if (m.getNaesteDelbehandling().getIdealToerreTid() <= getDageTilToerreSidenSidsteDelbehandling(m)
						&& m.getNaesteDelbehandling().getMaxToerreTid() >= getDageTilToerreSidenSidsteDelbehandling(m)) {
					kritiskeMellemvarer.add(m);
				}
			}
		}

		return kritiskeMellemvarer;
	}

	public ArrayList<Mellemvare> getFaerdigeMellemvarer() {
		return new ArrayList<Mellemvare>(faerdigeMellemvarer);
	}

	public int getDageTilToerreSidenSidsteDelbehandling(Mellemvare m) {
		return dage - m.getToerretider().get(m.getToerretider().size() - 1).getTid();
	}

	
	/**
	 * Finder n�ste mellemvare til videre behandling fortager en v�gtet
	 * udv�lgese p� baggrund af mellemvarens "alder" dvs. at en vare der er
	 * t�ttere p� dens max tid for prioritet, for at minimere tab
	 * 
	 * @return Mellemvare note, hvis der ikke er flere behandlinger for
	 *         mellemvare bliver den automatisk tilf�jet til f�rdigvare listen
	 * 
	 * */

//	public Mellemvare getNaesteMellemvareTilBehandling() {
//		Mellemvare resultMellemvare = null;
//		//int max = mellemvarer.get(0).getSidsteDelbehandling().getMaxToerreTid();
//		//int min = mellemvarer.get(0).getSidsteDelbehandling().getMinToerreTid();
//		//int ideal = mellemvarer.get(0).getSidsteDelbehandling().getIdealToerreTid();
//
//		int min = getStoersteMinToerretid();
//		int ideal = getStoersteIdealToerretid();
//		int max = getStoersteMaxToerretid();
//		boolean isFaerdig = false;
//		for (Mellemvare m : mellemvarer) {
//			Delbehandling d = m.getNaesteDelbehandling();
//			if (d != null) {
//				int antalDagePaaLager = getDageSidenForrigeDelbehandling(m);
//				if (d.getMaxToerreTid() >= max
//						&& d.getMaxToerreTid() <= antalDagePaaLager) {
//					resultMellemvare = m;
//					max = d.getMaxToerreTid();
//				} else if (d.getIdealToerreTid() >= ideal
//						&& d.getIdealToerreTid() <= antalDagePaaLager) {
//					resultMellemvare = m;
//					ideal = d.getIdealToerreTid();
//				} else if (d.getMinToerreTid() >= min
//						&& d.getMinToerreTid() <= antalDagePaaLager) {
//					resultMellemvare = m;
//					min = d.getMinToerreTid();
//				}
//			} else {
//				isFaerdig = true;
//				resultMellemvare = m;
//			}
//		}
//		if (resultMellemvare != null && isFaerdig) {
//			flytTilFaerdigvare(resultMellemvare);
//		}
//
//		else if (resultMellemvare != null) {
//			resultMellemvare.createToerretid(dage);
//		}
//		return resultMellemvare;
//	}
	
	/**
	 * @return N�ste mellemvare klar til behandling prioriteret efter mellemvarens delbehandlingers min, ideal og max t�rretider.
	 * @return Null hvis der ikke findes en mellemvare der er klar til en ny behandling.
	 * @return i tilf�lde af lighed retuners f�rste forkomst
	 */
	public Mellemvare getNaesteMellemvareTilBehandling(){
		Mellemvare resultMellemvare = null;
		int max = 0;
		for(Mellemvare m : getMellemvarerMedMaxToerretid()){
			if(m.getSidsteDelbehandling().getMaxToerreTid() > max){
				max = m.getSidsteDelbehandling().getMaxToerreTid();
				resultMellemvare = m;
			}
		}
		int ideal = 0;
		if(resultMellemvare == null){ //Hvis der ikke er nogen mellemvarer med max t�rretid
			for(Mellemvare m : getMellemvarerMedIdealToerretid()){
				if(m.getSidsteDelbehandling().getIdealToerreTid() > ideal){
					ideal = m.getSidsteDelbehandling().getIdealToerreTid();
					resultMellemvare = m;
				}
			}
		}
		int min = 0;
		if(resultMellemvare == null){ //Hvis der ikke er nogen mellemvarer med ideal t�rretid
			for(Mellemvare m : getMellemvarerMedMinToerretid()){
				if(m.getSidsteDelbehandling().getMinToerreTid() > min){
					min = m.getSidsteDelbehandling().getMinToerreTid();
					resultMellemvare = m;
				}
			}
		}
		if(resultMellemvare != null && resultMellemvare.getNaesteDelbehandling() == null){ //Mellemvaren har v�ret igennem alle delbehandlinger
			flytTilFaerdigvare(resultMellemvare);
		}else if(resultMellemvare != null){ //Mellemvaren har flere delbehandlinger og den er nu igang med at t�rre igen
			resultMellemvare.createToerretid(dage);
		}
		return resultMellemvare;
	}
	
	private ArrayList<Mellemvare> getMellemvarerMedMaxToerretid(){
		ArrayList<Mellemvare> resultList = new ArrayList<Mellemvare>();
		for(Mellemvare m : mellemvarer){
			if(m.getSidsteDelbehandling().getMaxToerreTid() == getDageTilToerreSidenSidsteDelbehandling(m)){
				resultList.add(m);
			}
		}
		return resultList;
	}
	
	private ArrayList<Mellemvare> getMellemvarerMedIdealToerretid(){
		ArrayList<Mellemvare> resultList = new ArrayList<Mellemvare>();
		for(Mellemvare m : mellemvarer){
			if(m.getSidsteDelbehandling().getIdealToerreTid() <= getDageTilToerreSidenSidsteDelbehandling(m)
					&& m.getSidsteDelbehandling().getMaxToerreTid() > getDageTilToerreSidenSidsteDelbehandling(m)){
				resultList.add(m);
			}
		}
		return resultList;
	}
	
	private ArrayList<Mellemvare> getMellemvarerMedMinToerretid(){
		ArrayList<Mellemvare> resultList = new ArrayList<Mellemvare>();
		for(Mellemvare m : mellemvarer){
			if(m.getSidsteDelbehandling().getMinToerreTid() <= getDageTilToerreSidenSidsteDelbehandling(m)
					&& m.getSidsteDelbehandling().getIdealToerreTid() > getDageTilToerreSidenSidsteDelbehandling(m)){
				resultList.add(m);
			}
		}
		return resultList;
	}

	/**
	 * st�tte metode til at flytte en mellemvare til f�rdigvare
	 * 
	 * @param m
	 *            den mellemvarse man �nsker at flytte
	 */
	private void flytTilFaerdigvare(Mellemvare m) {
		mellemvarer.remove(m);
		faerdigeMellemvarer.add(m);
		m.setStatus(Status.FAERDIG);
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
			if(m.getSidsteDelbehandling().getMaxToerreTid() < getDageTilToerreSidenSidsteDelbehandling(m)){
				resultList.add(m);
			}
		}
		return resultList;
	}
	
	public void clearLager(){
		mellemvarer.clear();
	}

	public ArrayList<Mellemvare> getForGamleMellemvareList() {
		return new ArrayList<Mellemvare>(forGamleMellemvare);
	}
	
	public void setForGamleMellemvareList(ArrayList<Mellemvare> nyList){
		forGamleMellemvare = nyList;
	}

	public int getStatistikOverForGamleMellemvarer(){
		return forGamleMellemvare.size();
	}

}
