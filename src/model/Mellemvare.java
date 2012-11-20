package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvare {

	private String id;
	private Produkttype produkttype =null;
	private List<Toerretid> toerretider = new ArrayList<Toerretid>();
	public Mellemvare(String id, Produkttype produkttype){
		this.produkttype=produkttype;
		this.setId(id);
	}
	public Produkttype getProdukttype(){
		return produkttype;
	}
	//setProdukttype(Produkttype produkttype) er irrelevant
	public void setProdukttype(Produkttype produkttype){
		if(this.produkttype!=produkttype){
			this.produkttype=produkttype;
		}
	}
	public ArrayList<Toerretid> getToerretider(){
		return new ArrayList<Toerretid>(toerretider);
	}
	public Toerretid createToerretid(String tid) throws RuntimeException{
		Delbehandling delbehandling = getNaesteDelbehandling();
		if (delbehandling == null) throw new RuntimeException("ikke flere delbehandlinger");
		Toerretid toerretid = new Toerretid(tid, delbehandling);
		toerretider.add(toerretid);
		return toerretid;
	}
	public void deleteToerretid(Toerretid toerretid){
		if(toerretider.contains(toerretid)){
			toerretider.remove(toerretid);
		}
	}
	public Delbehandling getNaesteDelbehandling(){
		int antalDelbehandlinger = getProdukttype().getBehandling().getDelbehandlinger().size();
		int antalToerretider = toerretider.size();
		Delbehandling delbehandling = null;
		if( antalDelbehandlinger >= antalToerretider + 1){
			delbehandling = getProdukttype().getBehandling().getDelbehandlinger().get(antalToerretider);
		}
		return delbehandling;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
