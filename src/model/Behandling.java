package model;

import java.util.ArrayList;
import java.util.List;

public class Behandling {

	private String navn;
	private List<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();

	public Behandling(String navn) {
		this.navn = navn;

	}

	public Delbehandling createDelbehandling(String navn, int Tørretid,
			int idealTørreTid, int minTørretid) {
		Delbehandling delbehandling = new Delbehandling(navn, Tørretid,
				idealTørreTid, minTørretid);
		delbehandlinger.add(delbehandling);
		return delbehandling;
	}

	public void addDelbehandling(Delbehandling delbehandling) {
		if (!delbehandlinger.contains(delbehandling)) {
			delbehandlinger.add(delbehandling);
		}

	}

	public void deleteDelbehandling(Delbehandling delbehandling) {
		if (delbehandlinger.contains(delbehandling)) {
			delbehandlinger.remove(delbehandling);
		}
	}
	
	public ArrayList<Delbehandling> getDelbehandlinger(){
		return new ArrayList<Delbehandling>(delbehandlinger);
	}

}
