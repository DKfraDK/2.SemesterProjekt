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
		Delbehandling del1 = new Delbehandling("Chokoladeovertræk", 3,2,1);
		Delbehandling del2 = new Delbehandling("Chokoladeovertræk2", 3,2,1);
		
		Behandling b1 = new Behandling("Skumbananbehandling");
		b1.addDelbehandling(del1);
		b1.addDelbehandling(del2);
		Produkttype p1 = new Produkttype("Skumbanan", b1);
		
		Mellemvare m1 = new Mellemvare("007",p1);
		Mellemvarelager ml1 = new Mellemvarelager("Lager of d00m");
		
		m1.createTørretid("Idag");
		m1.createTørretid("iMorgen");
		
		
		ml1.addMellemvare(m1);
		
		System.out.println(m1.getId());
		System.out.println(m1.getTørretider().size());
		System.out.println(m1.getProdukttype().getBehandling().getDelbehandlinger().size());
		System.out.println(m1.getTørretider().toString());
		
	//	m1.createTørretid("ifremtiden");
		


	}

}
