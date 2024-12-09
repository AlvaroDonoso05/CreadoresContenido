package Models;
import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;
public class ReporteColabs {

	@CsvBindByName(column = "creador_id")
	private int idCreador;
	@CsvBindByName(column = "nombre")
	private String nombre;
	@CsvBindByName(column = "fecha")
	private String fecha;
	@CsvBindByName(column = "colaborador")
	private String colaborador;
	@CsvBindByName(column = "interacciones_totales")
	private double interacciones_totales;
	@CsvBindByName(column = "promedio_vistas_mensuales")
	private double promedio_vistas_mensuales;
	@CsvBindByName(column = "tasa_crecimiento_seguidores")
	private double tasa_crecimiento_seguidores;
	
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getColaborador() {
		return colaborador;
	}
	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}
	public double getInteracciones_totales() {
		return interacciones_totales;
	}
	public void setInteracciones_totales(double interacciones_totales) {
		this.interacciones_totales = interacciones_totales;
	}
	public double getPromedio_vistas_mensuales() {
		return promedio_vistas_mensuales;
	}
	public void setPromedio_vistas_mensuales(double promedio_vistas_mensuales) {
		this.promedio_vistas_mensuales = promedio_vistas_mensuales;
	}
	public double getTasa_crecimiento_seguidores() {
		return tasa_crecimiento_seguidores;
	}
	public void setTasa_crecimiento_seguidores(double tasa_crecimiento_seguidores) {
		this.tasa_crecimiento_seguidores = tasa_crecimiento_seguidores;
	}

	
	

}
