package model;

import java.util.ArrayList;
import java.util.List;

public class Mellemvare {
	private Status status = null;
	private String id;
	private Produkttype produkttype =null;
	private List<Toerretid> toerretider = new ArrayList<Toerretid>();
	
	public Mellemvare(String id, Produkttype produkttype, int tid){
		this.produkttype=produkttype;
		this.setId(id);
		createToerretid(tid);
		setStatus(Status.TILTOERRING);
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
	public Toerretid createToerretid(int tid) throws RuntimeException{
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
	
	public Delbehandling getSidsteDelbehandling(){
		 return getProdukttype().getBehandling().getDelbehandlinger().get(getProdukttype().getBehandling().getDelbehandlinger().size()-1);
	}
	
	public String toString(){
		return "id: " + id + ", " + getProdukttype();
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
