package Models;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class Metrica {
	@CsvBindByName(column = "creador_id")
	private int idCreador;
	@CsvBindByName(column = "plataforma")
	private String plataforma;
	@CsvBindByName(column = "fecha")
	private String fecha;
	@CsvBindByName(column = "contenido")
	private String contenido;
	@CsvBindByName(column = "tipo")
	private String tipo;
	@CsvBindByName(column = "vistas")
	private int vistas;
	@CsvBindByName(column = "me_gusta")
	private int meGusta;
	@CsvBindByName(column = "comentarios")
	private int comentarios;
	@CsvBindByName(column = "compartidos")
	private int compartidos;

	public int getIdCreador() {
		return idCreador;
	}

	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha.toString();
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVistas() {
		return vistas;
	}

	public void setVistas(int vistas) {
		this.vistas = vistas;
	}

	public int getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}

	public int getComentarios() {
		return comentarios;
	}

	public void setComentarios(int comentarios) {
		this.comentarios = comentarios;
	}

	public int getCompartidos() {
		return compartidos;
	}

	public void setCompartidos(int compartidos) {
		this.compartidos = compartidos;
	}
}
