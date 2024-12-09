package Models;

import java.util.HashMap;

public class CreadorMetrica {
	
	private int idCreador;
	private String nombre;
	private HashMap<String, Double> plataformaStats;
	
	
	public int getIdCreador() {
		return idCreador;
	}
	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public HashMap<String, Double> getPlataformaStats() {
		return plataformaStats;
	}
	public void setPlataformaStats(HashMap<String, Double> plataformaStats) {
		this.plataformaStats = plataformaStats;
	}
	
	

}
