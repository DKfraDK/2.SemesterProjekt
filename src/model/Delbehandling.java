package model;

public class Delbehandling {

	public String navn;
	public int maxTørreTid;
	public int idealTørreTid;
	public int minTørreTid;
	
	public Delbehandling(String navn, int minTørreTid, int idealTørreTid, int maxTørretid){
		this.navn=navn;
		this.maxTørreTid=maxTørreTid;
		this.idealTørreTid=idealTørreTid;
		this.minTørreTid=minTørreTid;	
	}
}
