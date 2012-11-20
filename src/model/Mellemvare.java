package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvare {

	private String id;
	private Produkttype produkttype =null;
	private List<T�rretid> t�rretider = new ArrayList<T�rretid>();
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
	public ArrayList<T�rretid> getT�rretider(){
		return new ArrayList<T�rretid>(t�rretider);
	}
	public T�rretid createT�rretid(String tid) throws RuntimeException{
		Delbehandling delbehandling = getN�steDelbehandling();
		if (delbehandling == null) throw new RuntimeException("ikke flere delbehandlinger");
		T�rretid t�rretid = new T�rretid(tid, delbehandling);
		t�rretider.add(t�rretid);
		return t�rretid;
	}
	public void deleteT�rretid(T�rretid t�rretid){
		if(t�rretider.contains(t�rretid)){
			t�rretider.remove(t�rretid);
		}
	}
	public Delbehandling getN�steDelbehandling(){
		int antalDelbehandlinger = getProdukttype().getBehandling().getDelbehandlinger().size();
		int antalT�rretider = t�rretider.size();
		Delbehandling delbehandling = null;
		if( antalDelbehandlinger >= antalT�rretider + 1){
			delbehandling = getProdukttype().getBehandling().getDelbehandlinger().get(antalT�rretider);
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
