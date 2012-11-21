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
		Delbehandling del2 = new Delbehandling("Chokoladeovertræk2", 1,1,5);
		Delbehandling del3 = new Delbehandling("Tilføj silikone i patterne",1,1,3);
		Delbehandling del4 = new Delbehandling("Hiv i patterne",1,3,3);
		
		Behandling b1 = new Behandling("Skumbananbehandling");
		Behandling b2 = new Behandling("P-Tærte behandling");
		Behandling b3 = new Behandling("Silikone patter behandlingen");
		b3.addDelbehandling(del3);
		b3.addDelbehandling(del4);
		b2.addDelbehandling(del1);
		b2.addDelbehandling(del2);
		b1.addDelbehandling(del1);
		b1.addDelbehandling(del2);
		Produkttype p1 = new Produkttype("Skumbanan", b1);
		Produkttype p2 = new Produkttype("P-Tærter", b2);
		Produkttype p3 = new Produkttype("Silikonepatter",b3);
		
		Mellemvare m1 = new Mellemvare("007",p1);
		Mellemvare m2 = new Mellemvare("008",p2);
		Mellemvare m3 = new Mellemvare("009",p3);
		Mellemvarelager ml1 = new Mellemvarelager("Lager of d00m");
		ml1.setDage(2);
		
		m3.createToerretid(0);
		m3.createToerretid(1);
		m2.createToerretid(0);
		m2.createToerretid(1);
		m1.createToerretid(0);
		m1.createToerretid(1);
		
		ml1.addMellemvare(m2);		
		ml1.addMellemvare(m1);
		ml1.addMellemvare(m3);
		
		System.out.println(ml1.getMellemvarer());
		System.out.println("N¾ste mellemvare til behandling: " + ml1.getNaesteMellemvareTilBehandling());
		System.out.println(ml1.getMellemvarer());
		
		System.out.println(m1.getId());
		System.out.println(m1.getToerretider().size());
		System.out.println(m1.getProdukttype().getBehandling().getDelbehandlinger().size());
		System.out.println(m1.getToerretider().toString());
		
	//	m1.createToerretid("ifremtiden");
		


	}

}
