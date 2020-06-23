package it.polito.tdp.flight.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Simulator {
	
	LocalDateTime inizio = LocalDateTime.of(2020, 06, 23, 06, 0, 0);
	LocalDateTime fine = inizio.plusDays(2);
	List<Airport> disponibili;
	Map<Airport, Integer> mappaViaggiatoriAeroporti;
	
	public Simulator (int k, List<Airport> disponibili) {
		this.disponibili = new ArrayList<>(disponibili);
		this.mappaViaggiatoriAeroporti = new HashMap<>();
		for (Airport a : this.disponibili)
			this.mappaViaggiatoriAeroporti.put(a, 0);
		int posizionati = 0;
		Random rand = new Random();
		for (posizionati = 0; posizionati < k; posizionati ++) {
			Airport a = disponibili.get(rand.nextInt(disponibili.size()));
			int viaggiatori = this.mappaViaggiatoriAeroporti.get(a);
			this.mappaViaggiatoriAeroporti.put(a, viaggiatori+1);
		}
			
	}
	
}
