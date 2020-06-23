package it.polito.tdp.flight.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import it.polito.tdp.flight.db.FlightDAO;

public class Model {
	
	private FlightDAO db;
	private SimpleWeightedGraph<Airport, DefaultWeightedEdge> graph;
	private Map<Integer, Airport> airportIdMap;
	
	public Model() {
		this.db = new FlightDAO();
		this.airportIdMap = new HashMap<>();
	}
	
	public List<Airport> getAllAirports() {
		return this.db.getAllAirports();
	}
	
	public void creaGrafo(int chilometriDistanza) {
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		for (Airport a : this.getAllAirports()) {
			this.graph.addVertex(a);
			this.airportIdMap.put(a.getAirportId(), a);
		}
		System.out.println("Grafo creato correttamente con "+this.graph.vertexSet().size()+" vertici\n");
		
		for (Adiacenza a: this.db.getAllAdiacenze(airportIdMap, chilometriDistanza)) {
		//	System.out.println(a.toString()+"\n");
			DefaultWeightedEdge eTemp = this.graph.getEdge(a.a1, a.a2);
			if (eTemp == null)
				Graphs.addEdge(graph, a.a1, a.a2, a.getPeso());
		//	System.out.println(eTemp+"\n");
		}
		System.out.println("Al grafo sono stati aggiunti "+this.graph.edgeSet().size()+" archi!\n");
	}
	
	public boolean isPossibile() {
		HashSet<Airport> connessi = new HashSet<>();
		Airport connesso = null;
		for (Airport a : this.graph.vertexSet()) {
			if (this.graph.degreeOf(a)!=0) {
				connessi.add(a);
			if (connesso == null)
				connesso = a;
			}
		}
		Integer numeroConnessi = connessi.size();
		List<Airport> visita = new ArrayList<>();
		GraphIterator<Airport, DefaultWeightedEdge> bfv = new BreadthFirstIterator<>(graph, connesso);
			while(bfv.hasNext()) {
				visita.add( bfv.next() ) ;
			}
		
		if (numeroConnessi == visita.size())
			return true;
		else 
			return false;
	}
	
	public Airport piuLontano() {
		String partenza = "Fiumicino";
		Airport fiumicino = null;
		for (Airport a : this.airportIdMap.values())
			if (a.getName().compareTo(partenza)==0) {
				fiumicino = a;
				break;
		}
		DijkstraShortestPath<Airport, DefaultWeightedEdge> dij = new DijkstraShortestPath<>(graph) ;
		List<Airport> visita = new ArrayList<>();
		GraphIterator<Airport, DefaultWeightedEdge> bfv = new BreadthFirstIterator<>(graph, fiumicino);
			while(bfv.hasNext()) {
				visita.add( bfv.next() ) ;
		}
		Double pesoMinimo = Double.MIN_VALUE;
		Airport piuLontano = null;
		for (Airport a : visita)
			if(dij.getPathWeight(fiumicino, a) > pesoMinimo) {
				piuLontano = a;
				pesoMinimo = dij.getPathWeight(fiumicino, a);
			}
		return piuLontano;
	}

}
