package service;

import model.Behandling;
import model.Delbehandling;
import model.Mellemvare;
import model.Mellemvarelager;
import model.Produkttype;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Delbehandling del1 = new Delbehandling("Chokoladeovertræk", 1,2,3);
		Delbehandling del2 = new Delbehandling("Chokoladeovertræk2", 1,2,5);
		
		Behandling b1 = new Behandling("Skumbananbehandling");
		b1.addDelbehandling(del1);
		b1.addDelbehandling(del2);
		Produkttype p1 = new Produkttype("Skumbanan", b1);
		
		Mellemvare m1 = new Mellemvare("007",p1);
		Mellemvarelager ml1 = new Mellemvarelager("Lager of d00m");
		ml1.setDage(3);
		
		m1.createToerretid(0);
		m1.createToerretid(0);
		
		
		ml1.addMellemvare(m1);
		
		System.out.println("N¾ste mellemvare til behandling: " + ml1.getNaesteMellemvareTilBehandling());
		
		System.out.println(m1.getId());
		System.out.println(m1.getToerretider().size());
		System.out.println(m1.getProdukttype().getBehandling().getDelbehandlinger().size());
		System.out.println(m1.getToerretider().toString());
		
	//	m1.createToerretid("ifremtiden");
		


	}

}
