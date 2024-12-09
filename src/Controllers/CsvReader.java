package Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Models.Metrica;
import Models.ReporteColabs;

public class CsvReader {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private List<Metrica> archivoCsv;
	private final String url;
	private Logger logger;

	public CsvReader(String url) {
		logger = Logger.getInstance();
		this.url = url;
		this.archivoCsv = abrirCSV();
	}

	public void generarCsv() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		File archivo = null;
		try {
			archivo = new File(url);

			fw = new FileWriter(archivo);
			bw = new BufferedWriter(fw);

			bw.write("creador_id,plataforma,fecha,contenido,tipo,vistas,me_gusta,comentarios,compartidos");
			bw.newLine();

			for(Metrica metrica: archivoCsv) {
				bw.write(metrica.getIdCreador() + ","
						+ metrica.getPlataforma() + ","
						+ metrica.getFecha() + ","
						+ metrica.getContenido() + ","
						+ metrica.getTipo() + ","
						+ metrica.getMeGusta() + ","
						+ metrica.getComentarios() + ","
						+ metrica.getCompartidos());
				bw.newLine();
			}
			logger.success("Archivo actualizado correctamente.");
		} catch(Exception e) {
			logger.error(e);
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}
	
	public void generarCsvColaboraciones(String direccionCSV, List<ReporteColabs> reporteColabs) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		File archivo = null;
		try {
			archivo = new File(direccionCSV);

			fw = new FileWriter(archivo);
			bw = new BufferedWriter(fw);

			bw.write("creador_id, nombre, fecha, colaborador, interacciones_totales, promedio_vistas_mensuales, tasa_crecimiento_seguidores");
			bw.newLine();

			for(ReporteColabs colab: reporteColabs) {
				bw.write(colab.getIdCreador() + ","
						+ colab.getNombre() + ","
						+ colab.getFecha() + ","
						+ colab.getColaborador() + ","
						+ colab.getInteracciones_totales() + ","
						+ colab.getPromedio_vistas_mensuales() + ","
						+ colab.getTasa_crecimiento_seguidores());
				bw.newLine();
			}
			logger.success("Reporte CSV generado correctamente.");
		} catch(Exception e) {
			logger.error(e);
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}
	
	public void generarCsvRepCol(String direccionCSV, List<ReporteColabs> reporteColabs) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		File archivo = null;
		try {
			archivo = new File(direccionCSV);

			fw = new FileWriter(archivo);
			bw = new BufferedWriter(fw);

			bw.write("creador_id, nombre, fecha_inicio, colaborador");
			bw.newLine();

			for(ReporteColabs colab: reporteColabs) {
				bw.write(colab.getIdCreador() + ","
						+ colab.getNombre() + ","
						+ colab.getFecha() + ","
						+ colab.getColaborador());
				bw.newLine();
			}
			logger.success("Reporte CSV generado correctamente.");
		} catch(Exception e) {
			logger.error(e);
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}


	public List<Metrica> abrirCSV() {
		List<Metrica> metricas = null;
		try {
			FileReader reader = new FileReader(this.url);

			CsvToBeanBuilder<Metrica> csvBuilder = new CsvToBeanBuilder<>(reader);
			CsvToBean<Metrica> csv = csvBuilder.withType(Metrica.class).withIgnoreLeadingWhiteSpace(true).build();

			metricas = csv.parse();

		} catch (Exception e) {
			logger.error(e);
		}

		return metricas;
	}

	public synchronized List<Metrica> obtenerPorId(int id) {
		List<Metrica> metricaCreador = new ArrayList<>();

		for (Metrica metrica : this.archivoCsv) {
			if (metrica.getIdCreador() == id) {
				metricaCreador.add(metrica);
			}
		}

		return metricaCreador;
	}

	public List<Metrica> obtenerPorRedSocial(int id, String redSocial) {
		List<Metrica> metricaCreador = new ArrayList<>();

		for (Metrica metrica : this.archivoCsv) {
			if (metrica.getIdCreador() == id && metrica.getPlataforma().equalsIgnoreCase(redSocial)) {
				metricaCreador.add(metrica);
			}
		}

		return metricaCreador;
	}

	public ObjectNode obtenerContenidosPlataforma(int id, String plataforma) {
		ObjectNode rootNode = objectMapper.createObjectNode();

		for (Metrica metrica : archivoCsv) {
			if (metrica.getIdCreador() == id && metrica.getPlataforma().equalsIgnoreCase(plataforma)) {
				ObjectNode contenido = objectMapper.createObjectNode();
				contenido.put("vistas", metrica.getVistas());
				contenido.put("me_gusta", metrica.getMeGusta());

				rootNode.set(metrica.getContenido(), contenido);
			}
		}

		return rootNode;

	}
	
	public ObjectNode obtenerContenidosPlataformaCont(String plataforma) {
		ObjectNode rootNode = objectMapper.createObjectNode();

		for (Metrica metrica : archivoCsv) {
			if (metrica.getPlataforma().equalsIgnoreCase(plataforma)) {
				ObjectNode contenido = objectMapper.createObjectNode();
				contenido.put("tipo", metrica.getTipo());
				contenido.put("vistas", metrica.getVistas());
				contenido.put("me_gusta", metrica.getMeGusta());

				rootNode.set(metrica.getContenido(), contenido);
			}
		}

		return rootNode;
	}

	public List<Metrica> getArchivoCsv() {
		return archivoCsv;
	}

	public void setArchivoCsv(List<Metrica> archivoCsv) {
		this.archivoCsv = archivoCsv;
	}
}
