package Models;

import java.util.HashMap;

public class CreadorMetrica {
	
	private int id, vistas, pInteracciones;
	private String nombre;
	private HashMap<String, Double> plataformas;
	
	public CreadorMetrica (int id) {
		this.id = id;
	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVistas() {
		return vistas;
	}
	public void setVistas(int vistas) {
		this.vistas = vistas;
	}
	public int getpInteracciones() {
		return pInteracciones;
	}
	public void setpInteracciones(int pInteracciones) {
		this.pInteracciones = pInteracciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public HashMap<String, Double> getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(HashMap<String, Double> plataformas) {
		this.plataformas = plataformas;
	}
	
	
	
	

}
