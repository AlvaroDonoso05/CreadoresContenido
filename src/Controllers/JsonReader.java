package Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.Creador;

public class JsonReader {
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private JsonNode creadoresNode;
	List<Creador> listaCreadores;
	private String url;
	
	public JsonReader(String url) {
		this.url = url;
		abrirJson();
	}
	
	public void abrirJson() {
		try {
			listaCreadores = new ArrayList<Creador>();
			creadoresNode = mapper.readTree(new File(this.url));
			
			for(JsonNode creadorNode: creadoresNode) {
				Creador creador = new Creador();
				creador.setId(creadorNode.get("id").asInt());
				creador.setNombre(creadorNode.get("nombre").asText());
				creador.setPais(creadorNode.get("pais").asText());
				creador.setTematica(creadorNode.get("tematica").asText());
				creador.setSegidoresTotales(creadorNode.get("seguidores_totales").asInt());
				
				HashMap<String, Double> estadisticas = new HashMap<String, Double>();
				JsonNode estadisticasNode = creadorNode.get("estadisticas");
				
				if(estadisticasNode.get("interacciones_totales") != null) {
					estadisticas.put("interacciones_totales", estadisticasNode.get("interacciones_totales").asDouble());
				}
				if(estadisticasNode.get("promedio_vistas_mensuales") != null) {
					estadisticas.put("promedio_vistas_mensuales", estadisticasNode.get("promedio_vistas_mensuales").asDouble());
				}
				if(estadisticasNode.get("tasa_crecimiento_seguidores") != null) {
					estadisticas.put("tasa_crecimiento_seguidores", estadisticasNode.get("tasa_crecimiento_seguidores").asDouble());
				}
				
				creador.setEstadisticas(estadisticas);
				creador.setPlataformas(creadorNode.get("plataformas"));
				creador.setColaboraciones(creadorNode.get("colaboraciones"));
				
				listaCreadores.add(creador);				
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public HashMap<Integer, String> getCreadoresIdNombre() {
		HashMap<Integer, String> creadores = new HashMap<Integer, String>();
		
		for(JsonNode creador: this.creadoresNode) {
			int id = creador.get("id").asInt();
			String nombre = creador.get("nombre").asText();
			
			creadores.put(id, nombre);
			
		}
		
		return creadores;
	}

	public List<Creador> getListaCreadores() {
		return listaCreadores;
	}

	public void setListaCreadores(List<Creador> listaCreadores) {
		this.listaCreadores = listaCreadores;
	}
}
