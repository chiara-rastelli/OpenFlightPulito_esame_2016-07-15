package it.polito.tdp.flight.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {
	
	public enum EventType{
		INIZIO_VOLO,
		ARRIVO
	}
	
	EventType type;
	Airport partenza;
	Airport destinazione;
	LocalDateTime oraPartenza;
	LocalDateTime oraArrivo;
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public Airport getPartenza() {
		return partenza;
	}
	public void setPartenza(Airport partenza) {
		this.partenza = partenza;
	}
	public Airport getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(Airport destinazione) {
		this.destinazione = destinazione;
	}
	public LocalDateTime getOraPartenza() {
		return oraPartenza;
	}
	public void setOraPartenza(LocalDateTime oraPartenza) {
		this.oraPartenza = oraPartenza;
	}
	public LocalDateTime getOraArrivo() {
		return oraArrivo;
	}
	public void setOraArrivo(LocalDateTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	@Override
	public String toString() {
		return "Event [type=" + type + ", partenza=" + partenza + ", destinazione=" + destinazione + ", oraPartenza="
				+ oraPartenza + ", oraArrivo=" + oraArrivo + "]";
	}
	public Event(EventType type, Airport partenza, Airport destinazione, LocalDateTime oraPartenza, LocalDateTime oraArrivo) {
		super();
		this.type = type;
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
	}
	
}
