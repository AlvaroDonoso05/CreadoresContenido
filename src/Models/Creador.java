package Models;

import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

public class Creador {
	private int id;
	private String nombre;
	private String pais;
	private String tematica;
	private int segidoresTotales;
	private HashMap<String, Double> estadisticas;
	private JsonNode plataformas;
	private JsonNode colaboraciones;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public int getSegidoresTotales() {
		return segidoresTotales;
	}
	public void setSegidoresTotales(int segidoresTotales) {
		this.segidoresTotales = segidoresTotales;
	}
	public HashMap<String, Double> getEstadisticas() {
		return estadisticas;
	}
	public void setEstadisticas(HashMap<String, Double> estadisticas) {
		this.estadisticas = estadisticas;
	}
	public JsonNode getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(JsonNode plataformas) {
		this.plataformas = plataformas;
	}
	public JsonNode getColaboraciones() {
		return colaboraciones;
	}
	public void setColaboraciones(JsonNode colaboraciones) {
		this.colaboraciones = colaboraciones;
	}
	
}
