package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvarelager {
private List<String> placeringer = new ArrayList<String>();
private ArrayList<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
private String navn;
public Mellemvarelager(String navn){
	this.navn=navn;
	

}
public ArrayList<Mellemvare> getMellemvarer(){
	return new ArrayList<Mellemvare>(mellemvarer);
}
public void addMellemvare(Mellemvare mellemvare){
	if(!mellemvarer.contains(mellemvare)){
		mellemvarer.add(mellemvare);
	}
}
public void removeMellemvare(Mellemvare mellemvare){
	if(mellemvarer.contains(mellemvare)){
		mellemvarer.remove(mellemvare);
	}
}

public Mellemvare getNaesteMellemvareTilBehandling(){
	return mellemvarer.get(1337);
}
public void sendTilFaerdiglager(Mellemvare v){
	
}
public int getPlacering(Mellemvare m){
		return placeringer.indexOf(m);
		
	}
}




