package service;

import java.util.ArrayList;

import model.Behandling;
import model.Delbehandling;
import model.Mellemvare;
import model.Mellemvarelager;
import model.Produkttype;
import model.Toerretid;

public class Dao {
	private static ArrayList<Mellemvarelager> mellemvarelagere = new ArrayList<Mellemvarelager>();
	private static ArrayList<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
	private static ArrayList<Behandling> behandlinger = new ArrayList<Behandling>();
	private static ArrayList<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();
	private static ArrayList<Toerretid> toerretider = new ArrayList<Toerretid>();
	private static ArrayList<Produkttype> produkttyper = new ArrayList<Produkttype>();

	public static ArrayList<Mellemvarelager> getMellemvarelagere() {
		return mellemvarelagere;
	}

	public static ArrayList<Mellemvare> getMellemvarer() {
		return new ArrayList<Mellemvare>(mellemvarer);
	}

	public static ArrayList<Behandling> getBehandlinger() {
		return new ArrayList<Behandling>(behandlinger);
	}

	public static ArrayList<Delbehandling> getDelbehandling() {
		return new ArrayList<Delbehandling>(delbehandlinger);
	}

	public static ArrayList<Toerretid> getToerretider() {
		return new ArrayList<Toerretid>(toerretider);
	}

	public static ArrayList<Produkttype> getProdukttyper() {
		return new ArrayList<Produkttype>(produkttyper);
	}

	public static void addMellemvare(Mellemvare mellemvare) {
		if (!mellemvarer.contains(mellemvare)) {
			mellemvarer.add(mellemvare);
		}
	}
	public static void addBehandling(Behandling behandling){
		if(!behandlinger.contains(behandling)){
			behandlinger.add(behandling);
		}
	}
	public static void addToerretid(Toerretid toerretid){
		if(!toerretider.contains(toerretid)){
			toerretider.add(toerretid);
		}
	}
	public static void addProdukttype(Produkttype produkttype){
		if(!produkttyper.contains(produkttype)){
			produkttyper.add(produkttype);
		}
	}
	public static void addDelbehandling(Delbehandling delbehandling){
		if(!delbehandlinger.contains(delbehandling)){
			delbehandlinger.add(delbehandling);
		}
	}
	public static void removeMellemvare(Mellemvare mellemvare){
		if(mellemvarer.contains(mellemvare)){
			mellemvarer.remove(mellemvare);
		}
	}
	public static void removeBehandling(Behandling behandling){
		if(behandlinger.contains(behandling)){
			behandlinger.remove(behandling);
		}
	}
	public static void removeToerretid(Toerretid toerretid){
		if(toerretider.contains(toerretid)){
			toerretider.remove(toerretid);
		}
	}
	public static void removeProdukttype(Produkttype produkttype){
		if(produkttyper.contains(produkttype)){
			produkttyper.remove(produkttype);
		}
	}
	public static void removeDelbehandling(Delbehandling delbehandling){
		if(delbehandlinger.contains(delbehandling)){
			delbehandlinger.remove(delbehandling);
		}
	}
}
