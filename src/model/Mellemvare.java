package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvare {

	private String id;
	private Produkttype produkttype =null;
	private List<Tørretid> tørretider = new ArrayList<Tørretid>();
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
	public ArrayList<Tørretid> getTørretider(){
		return new ArrayList<Tørretid>(tørretider);
	}
	public Tørretid createTørretid(String tid) throws RuntimeException{
		Delbehandling delbehandling = getNæsteDelbehandling();
		if (delbehandling == null) throw new RuntimeException("ikke flere delbehandlinger");
		Tørretid tørretid = new Tørretid(tid, delbehandling);
		tørretider.add(tørretid);
		return tørretid;
	}
	public void deleteTørretid(Tørretid tørretid){
		if(tørretider.contains(tørretid)){
			tørretider.remove(tørretid);
		}
	}
	public Delbehandling getNæsteDelbehandling(){
		int antalDelbehandlinger = getProdukttype().getBehandling().getDelbehandlinger().size();
		int antalTørretider = tørretider.size();
		Delbehandling delbehandling = null;
		if( antalDelbehandlinger >= antalTørretider + 1){
			delbehandling = getProdukttype().getBehandling().getDelbehandlinger().get(antalTørretider);
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
