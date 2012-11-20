package model;

public class Delbehandling {

	public String navn;
	public int maxToerreTid;
	public int idealToerreTid;
	public int minToerreTid;
	
	public Delbehandling(String navn, int minToerreTid, int idealToerreTid, int maxToerretid){
		this.navn=navn;
		this.maxToerreTid=maxToerreTid;
		this.idealToerreTid=idealToerreTid;
		this.minToerreTid=minToerreTid;	
	}
}
