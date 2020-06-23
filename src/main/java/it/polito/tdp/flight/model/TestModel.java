package it.polito.tdp.flight.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model m = new Model();
		m.creaGrafo(808);
		System.out.println(m.isPossibile()+"\n");
		System.out.println(m.piuLontano());
	}

}
