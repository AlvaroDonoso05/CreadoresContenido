package Controllers;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import Models.Metrica;

public class CsvReader {
	private List<Metrica> archivoCsv;
	private String url;
	
	public CsvReader(String url) {
		this.url = url;
		this.archivoCsv = abrirCSV();
	}
	
	public List<Metrica> abrirCSV(){
		List<Metrica> metricas = null;
		try  {
			FileReader reader = new FileReader(this.url);
			
			CsvToBeanBuilder<Metrica> csvBuilder = new CsvToBeanBuilder<Metrica>(reader);
			CsvToBean<Metrica> csv = csvBuilder.withType(Metrica.class).withIgnoreLeadingWhiteSpace(true).build();

			metricas = csv.parse();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return metricas;
	}
	
	public List<Metrica> obtenerPorId(int id) {
		List<Metrica> metricaCreador = new ArrayList<Metrica>();
		
		for(Metrica metrica : this.archivoCsv) {
			if(metrica.getIdCreador() == id) {
				metricaCreador.add(metrica);
			}
		}
		
		return metricaCreador;
	}
	
	public List<Metrica> obtenerPorRedSocial(int id, String redSocial) {
		List<Metrica> metricaCreador = new ArrayList<Metrica>();
		
		for(Metrica metrica : this.archivoCsv) {
			if(metrica.getIdCreador() == id && metrica.getPlataforma().equalsIgnoreCase(redSocial)) {
				metricaCreador.add(metrica);
			}
		}
		
		return metricaCreador;
	}
}
