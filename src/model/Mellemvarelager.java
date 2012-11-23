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
	
	public Mellemvare getNaesteMellemvareTilBehandling(){
		Mellemvare resultMellemvare = null;
		//Den maximum tørretid for den sidste delbehandling af den første mellemvare
		int max = mellemvarer.get(0).getSidsteDelbehandling().getMaxToerreTid();
		int min = mellemvarer.get(0).getSidsteDelbehandling().getMinToerreTid();
		int ideal = mellemvarer.get(0).getSidsteDelbehandling().getIdealToerreTid();
		
		for(Mellemvare m : mellemvarer){
			Delbehandling d = m.getNaesteDelbehandling();
			//Udregner hvor mange dage den givne mellemvare har vaeret på lageret i DEN delbehandling
			int antalDagePaaLager = dage - m.getToerretider().get(m.getToerretider().size()-1).getTid();
			System.out.println(antalDagePaaLager);
			System.out.println(d.getMaxToerreTid());
			//Hvis denne delbehandlings max tørretid er større end max tørretid.
			if(d.getMaxToerreTid() >= max && d.getMaxToerreTid() <= antalDagePaaLager){
				resultMellemvare = m;
				
			}else if(d.getIdealToerreTid() >= ideal && d.getIdealToerreTid() <= antalDagePaaLager){
				resultMellemvare = m;
				
			}else if(d.getMinToerreTid() >= min && d.getMinToerreTid() <= antalDagePaaLager){
				resultMellemvare = m;
			}
		}
		
		return resultMellemvare;
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
