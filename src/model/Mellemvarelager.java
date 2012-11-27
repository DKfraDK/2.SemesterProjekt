package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvarelager {
	private List<String> placeringer = new ArrayList<String>();
	private ArrayList<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
	private ArrayList<Mellemvare> faerdigeMellemvarer = new ArrayList<Mellemvare>();
	private String navn;
	private int dage = 0;

	
	
	public Mellemvarelager(String navn) {
		this.navn = navn;

	}
	
	public ArrayList<Mellemvare> getOversigt(){
		ArrayList<Mellemvare> mellemvarerTilToerring = new ArrayList<Mellemvare>();
		int i=0;
		for(Mellemvare m: mellemvarer){
			if(m.getStatus().equals(Status.TILTOERRING)){
				mellemvarerTilToerring.add(m);
			}
			
		}
		return mellemvarerTilToerring;
	}
	
	public ArrayList<Mellemvare> getFaerdigeMellemvarer(){
		return new ArrayList<Mellemvare>(faerdigeMellemvarer);
	}
	
	public Mellemvare getNaesteMellemvareTilBehandling(){
		Mellemvare resultMellemvare = null;
		int max = mellemvarer.get(0).getSidsteDelbehandling().getMaxToerreTid();
		int min = mellemvarer.get(0).getSidsteDelbehandling().getMinToerreTid();
		int ideal = mellemvarer.get(0).getSidsteDelbehandling().getIdealToerreTid();
		boolean isFaerdig = false;
		for(Mellemvare m : mellemvarer){
			Delbehandling d = m.getNaesteDelbehandling();
			if(d != null){
				int antalDagePaaLager = dage - m.getToerretider().get(m.getToerretider().size()-1).getTid();
				if(d.getMaxToerreTid() >= max && d.getMaxToerreTid() <= antalDagePaaLager){
					resultMellemvare = m;
					max = d.getMaxToerreTid();
				}else if(d.getIdealToerreTid() >= ideal && d.getIdealToerreTid() <= antalDagePaaLager){
					resultMellemvare = m;
					ideal = d.getIdealToerreTid();
				}else if(d.getMinToerreTid() >= min && d.getMinToerreTid() <= antalDagePaaLager){
					resultMellemvare = m;
					min = d.getMinToerreTid();
				}
			}else{
				isFaerdig = true;
			}
		}
		if(resultMellemvare != null && isFaerdig){
			flytTilFaerdigvare(resultMellemvare);
		}
		
		if(resultMellemvare != null){
			resultMellemvare.createToerretid(dage);
		}
		return resultMellemvare;
	}	

	
	private void flytTilFaerdigvare(Mellemvare m){
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

	public void sendTilFaerdiglager(Mellemvare v) {

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

}
