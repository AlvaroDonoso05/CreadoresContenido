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
	/*
	 * "interacciones_totales" : 1279203,
     * "promedio_vistas_mensuales" : 9684,
     * "tasa_crecimiento_seguidores" : 8.03250201023239 
	 */
	
	private JsonNode plataformas;
	/*
	 * {
     *	"nombre" : "YouTube",
     *	"usuario" : "User1_YouTube",
     *	"seguidores" : 81338,
     *	"fecha_creacion" : "2018-07-15",
     *	"historico" : [ 
     *	  {
     * 	  	"fecha" : "2023-01-10",
     * 	  	"nuevos_seguidores" : 3606,
     * 	  	"interacciones" : 3073
     *	  },
     *	  {
     * 		"fecha" : "2023-02-10",
     * 		"nuevos_seguidores" : 4822,
     * 		"interacciones" : 4046
     *	  } 
     *	]
  	 * }
	 */
	
	private JsonNode colaboraciones;
	/*
	 * {
     *	 "colaborador" : "Pedro Gonzalez",
     *	 "tematica" : "Tecnologia",
     *	 "fecha_inicio" : "2023-07-01",
     *	 "fecha_fin" : "2023-03-30",
     *	 "tipo" : "Patrocinado",
     *	 "estado" : "Activa"
  	 * }
	 */
	
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
