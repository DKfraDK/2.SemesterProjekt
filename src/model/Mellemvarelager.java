package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvarelager {
	private List<String> placeringer = new ArrayList<String>();
	private ArrayList<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
	private String navn;
	private int dage = 0;

	public Mellemvarelager(String navn) {
		this.navn = navn;

	}
	
	public Mellemvare getNaesteMellemvareTilBehandling(){
		Mellemvare resultMellemvare = null;
		int max = mellemvarer.get(0).getProdukttype().getBehandling().getDelbehandlinger().get(mellemvarer.get(0).getProdukttype().getBehandling().getDelbehandlinger().size()-1).getMaxToerreTid();
		int min = mellemvarer.get(0).getProdukttype().getBehandling().getDelbehandlinger().get(mellemvarer.get(0).getProdukttype().getBehandling().getDelbehandlinger().size()-1).getMinToerreTid();
		int ideal = mellemvarer.get(0).getProdukttype().getBehandling().getDelbehandlinger().get(mellemvarer.get(0).getProdukttype().getBehandling().getDelbehandlinger().size()-1).getIdealToerreTid();
		
		for(Mellemvare m : mellemvarer){
			Delbehandling d = m.getProdukttype().getBehandling().getDelbehandlinger().get(m.getProdukttype().getBehandling().getDelbehandlinger().size()-1);
			int antalDagePaaLager = dage - m.getToerretider().get(m.getToerretider().size()-1).getTid();
			System.out.println(antalDagePaaLager);
			System.out.println(d.getMaxToerreTid());
			if(d.getMaxToerreTid() >= max && d.getMaxToerreTid() >= antalDagePaaLager){
				resultMellemvare = m;
			}
		}
		if(resultMellemvare == null){
			for(Mellemvare m : mellemvarer){
				for(Delbehandling d : m.getProdukttype().getBehandling().getDelbehandlinger()){
					int antalDagePaaLager = dage - m.getToerretider().get(m.getToerretider().size()-1).getTid();
					if(d.getIdealToerreTid() >= ideal && d.getIdealToerreTid() >= antalDagePaaLager){
						resultMellemvare = m;
					}
				}
			}
		}
		if(resultMellemvare == null){
			for(Mellemvare m : mellemvarer){
				for(Delbehandling d : m.getProdukttype().getBehandling().getDelbehandlinger()){
					int antalDagePaaLager = dage - m.getToerretider().get(m.getToerretider().size()-1).getTid();
					if(d.getMinToerreTid() >= min && d.getMinToerreTid() >= antalDagePaaLager){
						resultMellemvare = m;
					}
				}
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
