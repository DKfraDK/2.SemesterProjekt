package model;

public class Produkttype {
	private String navn;
	private Behandling behandling= null;
	
	
	public Produkttype(String navn, Behandling behandling){
		this.behandling = behandling;
		this.navn=navn;
		
	}
	public void setNavn(String navn){
		this.navn=navn;
	}
	public Behandling getBehandling(){
		return behandling;
	}
	//SetBehandling er irrelevant 
	public void setBehandling(Behandling behandling){
		if(this.behandling!=behandling){
			this.behandling=behandling;
		}
	}
	
	
	public String toString(){
		return navn;
	}
}
