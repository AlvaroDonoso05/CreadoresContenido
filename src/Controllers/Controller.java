package Controllers;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Models.Creador;
import Models.CreadorMetrica;
import Models.Metrica;
import Models.ReporteColabs;
import Views.MainView;

public class Controller implements ActionListener, ListSelectionListener {


	private ObjectMapper om = new ObjectMapper();
	private final MainView view;
	private JsonReader jsonR;
	private final CsvReader csvR;
	private final HasteBinController hasteServer;
	private final ComentariosController comentariosController;

	private Creador creadorSeleccionado;
	private String botonSeleccionado;
	private JsonNode listaComentarios;
	private Logger logger;

	public Controller(MainView frame) {

		// Listeners
		this.view = frame;
		this.view.comboBox.addActionListener(this);
		this.view.comboBox_1.addActionListener(this);
		this.view.comboBox_2.addActionListener(this);
		this.view.comboBoxColNew.addActionListener(this);
		this.view.comboBoxColTem.addActionListener(this);
		this.view.comboBoxColTipo.addActionListener(this);
		this.view.reporteCreadoresItem.addActionListener(this);
		this.view.reporteColaboracionesItem.addActionListener(this);
		this.view.exportarColCSV.addActionListener(this);
		this.view.exitItem.addActionListener(this);
		this.view.helpItem.addActionListener(this);
		this.view.listPublicaciones.addListSelectionListener(this);
		this.view.btnExtraerDatos.addActionListener(this);
		this.view.btnAnterior.addActionListener(this);
		this.view.btnSiguiente.addActionListener(this);
		this.view.btnModificar.addActionListener(this);
		this.view.btnEliminar.addActionListener(this);
		this.view.btnConfFchIni.addActionListener(this);
		this.view.btnConfFchFin.addActionListener(this);
		this.view.btnFechaIni.addActionListener(this);
		this.view.btnFechaFin.addActionListener(this);
		this.view.btnNewButtonAddCol.addActionListener(this);
		this.view.btnExportarConsola.addActionListener(this);
		this.view.btnAgregar.addActionListener(this);
		this.view.generarResRendJSON.addActionListener(this);
		this.view.generarRepColCSV.addActionListener(this);

		jsonR = new JsonReader("resources/creadores.json");
		csvR = new CsvReader("resources/metricas_contenido.csv");
		hasteServer = new HasteBinController();
		comentariosController = new ComentariosController();
		this.logger = Logger.getInstance();
		this.logger.setView(this.view);

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> modelCol = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> modelTem = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> modelTipo = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> modelFiltros = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> modelContenido = new DefaultComboBoxModel<>();

		modelContenido.addElement("TikTok");
		modelContenido.addElement("Twitch");
		modelContenido.addElement("YouTube");
		modelContenido.addElement("Instagram");
		this.view.comboBoxContenido.setModel(modelContenido);

		modelFiltros.addElement("Vistas");
		modelFiltros.addElement("Likes");
		modelFiltros.addElement("Comentarios");
		modelFiltros.addElement("Compartidos");
		this.view.comboBox_Filtros.setModel(modelFiltros);

		modelTem.addElement("Tecnologia");
		modelTem.addElement("Moda");
		modelTem.addElement("Fitness");
		modelTem.addElement("Cocina");
		modelTem.addElement("Videojuegos");
		this.view.comboBoxColTem.setModel(modelTem);

		modelTipo.addElement("Patrocinado");
		modelTipo.addElement("Colaboración Natural");
		this.view.comboBoxColTipo.setModel(modelTipo);

		List<Creador> creadores = jsonR.getListaCreadores();
		model.addElement("Elige un creador");
		for(int i=0;i<creadores.size();i++) {
			model.addElement((i+1) + ". " + creadores.get(i).getNombre());
		}
		view.comboBox.setModel(model);
		generarCreadoresCol(modelCol);
		generarBotonesPlataformaCont();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.view.comboBox) {
			view.tabbedPane.setVisible(true);
			resetearValores();
			DefaultComboBoxModel<String> modelCol = (DefaultComboBoxModel<String>) this.view.comboBoxColNew.getModel();
			modelCol.removeAllElements();
			generarCreadoresCol(modelCol);
			if(view.comboBox.getSelectedItem().toString().indexOf(".")!= -1) {
				modelCol.removeElementAt(Integer.parseInt(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf("."))));
				actualizarValores();
			}else {
				view.tabbedPane.setVisible(false);
			}

		} else if (e.getSource() == this.view.exitItem) {
			System.exit(0);
		} else if(e.getSource() == this.view.helpItem) {
			try {
				URI url = new URI("https://creador.donoso.mooo.com");
				Desktop.getDesktop().browse(url);

			} catch (Exception e1) {
				logger.error(e1);
			}
		} else if (e.getSource() == this.view.btnExtraerDatos) {
			for (JsonNode creadorNode : jsonR.getCreadoresNode()) {
				if (creadorNode.get("id").asInt() == creadorSeleccionado.getId()) {
					this.view.lblInfoHaste.setVisible(true);
					this.view.lblInfoHaste.setText(hasteServer.uploadTextToHastebin(creadorNode, null));
				}
			}
		} else if(e.getSource() == this.view.btnExportarConsola) {
			String outputLog = this.view.textAreaLogger.getText();
			this.logger.success(hasteServer.uploadTextToHastebin(null, outputLog));
		} else if (e.getSource() == this.view.comboBox_1) {
			JsonNode colaboracion = creadorSeleccionado.getColaboraciones().get(Integer.parseInt(view.comboBox_1.getSelectedItem().toString().substring(0, view.comboBox_1.getSelectedItem().toString().indexOf("."))) - 1);
			obtenerDatosColaboracion(colaboracion);
		} else if (e.getSource() == this.view.comboBox_2) {
			JsonNode plataformas = creadorSeleccionado.getPlataformas();
			for (JsonNode plataforma : plataformas) {
				if (plataforma.get("nombre").asText().equalsIgnoreCase(botonSeleccionado)) {
					cargarHistorico(plataforma.get("historico").get(Integer.parseInt(view.comboBox_2.getSelectedItem().toString().substring(0, view.comboBox_2.getSelectedItem().toString().indexOf("."))) - 1));
				}
			}
		} else if(e.getSource() == this.view.btnAnterior) {
			if(Integer.parseInt(this.view.lblMinComentarios.getText()) > 1) {
				this.view.lblMinComentarios.setText(String.valueOf(Integer.parseInt(this.view.lblMinComentarios.getText()) - 1));
				cargarComentario(Integer.parseInt(this.view.lblMinComentarios.getText()));
			}
		} else if(e.getSource() == this.view.btnSiguiente) {
			if(Integer.parseInt(this.view.lblMinComentarios.getText()) < Integer.parseInt(this.view.lblMaxComentarios.getText())) {
				cargarComentario(Integer.parseInt(this.view.lblMinComentarios.getText()) + 1);
				this.view.lblMinComentarios.setText(String.valueOf(Integer.parseInt(this.view.lblMinComentarios.getText()) + 1));
			}
		} else if(e.getSource() == this.view.btnModificar) {
			if(this.view.listPublicaciones.getSelectedValue() != null) {
				List<Metrica> listaPublicaciones = csvR.obtenerPorId(creadorSeleccionado.getId());

				for(Metrica publicacion: listaPublicaciones) {
					int posicion = this.view.listPublicaciones.getSelectedValue().toString().indexOf(" -");
					if(publicacion.getContenido().equalsIgnoreCase(this.view.listPublicaciones.getSelectedValue().toString().substring(0, posicion))) {
						publicacion.setVistas(Integer.parseInt(this.view.textVistas.getText()));
						publicacion.setMeGusta(Integer.parseInt(this.view.textLikes.getText()));
						publicacion.setComentarios(Integer.parseInt(this.view.textComentarios.getText()));
						publicacion.setCompartidos(Integer.parseInt(this.view.textCompartidos.getText()));
						this.view.lblMinComentarios.setText(String.valueOf(0));
						this.view.lblMaxComentarios.setText(String.valueOf(publicacion.getComentarios()));
						cargarComentario(Integer.parseInt(this.view.lblMinComentarios.getText() + 1));
					}
				}
			}

			actualizarValores();

		} else if(e.getSource() == this.view.btnEliminar) {
			if(!this.view.textFiltro.getText().equalsIgnoreCase("")) {
				List<Metrica> listaPublicaciones = csvR.getArchivoCsv();

				Iterator<Metrica> iterator = listaPublicaciones.iterator();
				while (iterator.hasNext()) {
					Metrica publicacion = iterator.next();
					if(publicacion.getIdCreador() == creadorSeleccionado.getId()) {
						switch(this.view.comboBox_Filtros.getSelectedItem().toString()) {
						case "Vistas":
							if (publicacion.getVistas() < Integer.parseInt(this.view.textFiltro.getText())) {
								iterator.remove();
								logger.success(publicacion.getContenido() + " eliminado correctamente.");
							}
							break;
						case "Likes":
							if (publicacion.getMeGusta() < Integer.parseInt(this.view.textFiltro.getText())) {
								iterator.remove();
								logger.success(publicacion.getContenido() + " eliminado correctamente.");
							}
							break;
						case "Comentarios":
							if (publicacion.getComentarios() < Integer.parseInt(this.view.textFiltro.getText())) {
								iterator.remove();
								logger.success(publicacion.getContenido() + " eliminado correctamente.");
							}
							break;
						case "Compartidos":
							if (publicacion.getCompartidos() < Integer.parseInt(this.view.textFiltro.getText())) {
								iterator.remove();
								logger.success(publicacion.getContenido() + " eliminado correctamente.");
							}
							break;
						}
					}
				}
				csvR.setArchivoCsv(listaPublicaciones);
			} else {
				if(this.view.listPublicaciones.getSelectedValue() != null) {
					List<Metrica> listaPublicaciones = csvR.getArchivoCsv();

					Iterator<Metrica> iterator = listaPublicaciones.iterator();
					while (iterator.hasNext()) {
						Metrica publicacion = iterator.next();
						int posicion = this.view.listPublicaciones.getSelectedValue().toString().indexOf(" -");
						if (publicacion.getContenido().equalsIgnoreCase(this.view.listPublicaciones.getSelectedValue().toString().substring(0, posicion))) {
							iterator.remove();
							logger.success(publicacion.getContenido() + " eliminado correctamente.");
						}
					}
				}
			}
			obtenerPublicaciones(creadorSeleccionado.getId());
		}else if (e.getSource() == this.view.btnConfFchIni) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String selectedDate = sdf.format(this.view.calendar.getDate());
			this.view.textFieldFechIniColNew.setText(selectedDate);
			this.view.calendar.setVisible(false);
			this.view.btnConfFchIni.setVisible(false);

		}else if (e.getSource() == this.view.btnConfFchFin) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String selectedDate = sdf.format(this.view.calendar.getDate());
			this.view.textFieldFechFinColNew.setText(selectedDate);
			this.view.calendar.setVisible(false);
			this.view.btnConfFchFin.setVisible(false);

		}else if (e.getSource() == this.view.btnFechaIni) {
			this.view.btnConfFchFin.setVisible(false);
			this.view.btnConfFchIni.setVisible(true);
			this.view.calendar.setVisible(true);

		}else if (e.getSource() == this.view.btnFechaFin) {
			this.view.btnConfFchIni.setVisible(false);
			this.view.btnConfFchFin.setVisible(true);
			this.view.calendar.setVisible(true);

		}else if (e.getSource() == this.view.btnNewButtonAddCol) {

			if(!this.view.textFieldFechIniColNew.getText().equalsIgnoreCase("") && !this.view.textFieldFechFinColNew.getText().equalsIgnoreCase("")) {
				int creador = -1;
				String colaborador, tipo, tematica, fchIni, fchFin, activaString;
				Boolean activa, fechaCorrecta = false;

				if(view.comboBox.getSelectedItem().toString().indexOf(".")!= -1) {
					creador = Integer.parseInt(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf("."))) - 1;
				}

				colaborador = this.view.comboBoxColNew.getSelectedItem().toString();
				colaborador = colaborador.substring(colaborador.indexOf(".") + 2);
				tipo = this.view.comboBoxColTipo.getSelectedItem().toString();
				tematica = this.view.comboBoxColTem.getSelectedItem().toString();
				fchIni = this.view.textFieldFechIniColNew.getText();
				fchFin = this.view.textFieldFechFinColNew.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				Date sdfIni = null;
				Date sdfFin = null;
				try {
					sdfIni = sdf.parse(fchIni);
					sdfFin = sdf.parse(fchFin);
				} catch (ParseException e1) {
					logger.error(e1);
				} 			

				if(!sdfFin.before(sdfIni)) {
					fechaCorrecta = true;
				}

				activa = this.view.chckbxColActivaColNew.isSelected();
				if(activa) {
					activaString = "Activa";
				}else {
					activaString = "Finalizada";
				}

				if(creador != -1 &&
						!colaborador.equals("lige un colaborador") &&
						!fchIni.equals("") &&
						!fchFin.equals("") &&
						creador != -1 &&
						fechaCorrecta) {

					ObjectNode colaboracion = om.createObjectNode();
					colaboracion.put("colaborador", colaborador);
					colaboracion.put("tematica", tematica);
					colaboracion.put("fecha_inicio", fchIni);
					colaboracion.put("fecha_fin", fchFin);
					colaboracion.put("tipo", tipo);
					colaboracion.put("estado", activaString);

					JsonNode creadores = jsonR.getCreadoresNode();
					ArrayNode colaboraciones = (ArrayNode) creadores.get(creador).get("colaboraciones");
					colaboraciones.add(colaboracion);
					try {
						jsonR.actualizarCreadores();
						this.view.textAreaNewCol.setText("COLABORACIÓN AÑADIDA CORRECTAMENTE");
						this.view.textFieldFechIniColNew.setText("");
						this.view.textFieldFechFinColNew.setText("");
						this.view.chckbxColActivaColNew.setSelected(false);
						logger.success("Colaboracion añadida correctamente");
						actualizarValores();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}else {
					if(fechaCorrecta) {
						this.view.textAreaNewCol.setText("DEBE RELLENAR TODOS LOS CAMPOS!!");
					}else {
						this.view.textAreaNewCol.setText("LA FECHA DE INICIO DEBE SER MENOR A LA FINAL");
					}

				}
			} else {
				logger.warning("Rellena todos los campos");
				this.view.textAreaNewCol.setText("DEBE RELLENAR TODOS LOS CAMPOS!!");
			}
			
		}else if(e.getSource() == this.view.reporteCreadoresItem) {
			List<Creador> creadores = jsonR.getListaCreadores();
			ObjectNode rootNode = om.createObjectNode();
			ArrayNode creadoresArray = om.createArrayNode();

			for (Creador creador : creadores) {
				int seguidores = creador.getSegidoresTotales();
				JsonNode plataformas = creador.getPlataformas();

				String plataforma = "";
				double mediaAlta = 0;

				for (JsonNode plataformaNode : plataformas) {
					double acumulador = 0;
					int contador = 0;

					ArrayNode historicos = (ArrayNode) plataformaNode.get("historico");
					for (JsonNode historico : historicos) {
						acumulador += historico.get("interacciones").asInt();
						contador++;
					}

					double mediaInteracciones = acumulador / contador;
					if (mediaInteracciones > mediaAlta) {
						mediaAlta = mediaInteracciones;
						plataforma = plataformaNode.get("nombre").asText();
					}
				}

				ObjectNode creadorNode = om.createObjectNode();
				creadorNode.put("id", creador.getId());
				creadorNode.put("nombre", creador.getNombre());
				creadorNode.put("total_seguidores", seguidores);
				creadorNode.put("plataforma_interacciones", plataforma);
				creadorNode.put("promedio_interacciones", mediaAlta);

				creadoresArray.add(creadorNode);
			}

			rootNode.set("creadores", creadoresArray);
			jsonR.crearJson("resources/reporte_creadores.json", rootNode);


		}else if(e.getSource() == this.view.reporteColaboracionesItem) {
			//Ejercicio 12
			List<Creador> creadores = jsonR.getListaCreadores();
			ObjectNode rootNode = om.createObjectNode();
			ArrayNode creadoresArray = om.createArrayNode();

			for (Creador creador : creadores) {	
				JsonNode colaboraciones = creador.getColaboraciones();
				for(JsonNode colaboracion: colaboraciones) {
					ObjectNode creadorNode = om.createObjectNode();
					creadorNode.put("id", creador.getId());
					creadorNode.put("creador", creador.getNombre());
					creadorNode.put("colaborador", colaboracion.get("colaborador").asText());
					creadorNode.put("tematica", colaboracion.get("tematica").asText());
					creadorNode.put("fecha_inicio", colaboracion.get("fecha_inicio").asText());
					creadorNode.put("fecha_fin", colaboracion.get("fecha_fin").asText());
					creadorNode.put("tipo", colaboracion.get("tipo").asText());
					creadorNode.put("estado", colaboracion.get("estado").asText());

					creadoresArray.add(creadorNode);
				}

			}

			rootNode.set("colaboraciones", creadoresArray);
			jsonR.crearJson("resources/colaboraciones.json", rootNode);


		}else if(e.getSource() == this.view.exportarColCSV) {
			//4
			JsonNode creadores = jsonR.getCreadoresNode();
			List<ReporteColabs> reporteColabs = new ArrayList<ReporteColabs>();

			for(JsonNode creador: creadores) {

				ArrayNode colaboraciones = (ArrayNode) creador.get("colaboraciones");
				for(JsonNode colaboracion: colaboraciones) {
					ReporteColabs nReporte = new ReporteColabs();
					nReporte.setIdCreador(creador.get("id").asInt());
					nReporte.setNombre(creador.get("nombre").asText());

					JsonNode estadisticas = creador.get("estadisticas");				
					nReporte.setInteracciones_totales(estadisticas.get("interacciones_totales").asDouble());
					nReporte.setPromedio_vistas_mensuales(estadisticas.get("promedio_vistas_mensuales").asDouble());
					nReporte.setTasa_crecimiento_seguidores(estadisticas.get("tasa_crecimiento_seguidores").asDouble());
					nReporte.setColaborador(colaboracion.get("colaborador").asText());
					nReporte.setFecha(colaboracion.get("fecha_inicio").asText());
					reporteColabs.add(nReporte);					
				}

			}
			csvR.generarCsvColaboraciones("resources/colaboraciones.csv", reporteColabs);

		} else if(e.getSource() == this.view.btnAgregar) {

			// Obtener el contenido Mayor
			List<Metrica> listaContenidos = csvR.getArchivoCsv();

			int contenidoMayor = 0;
			for(Metrica metrica: listaContenidos) {
				int metricaId = Integer.parseInt(metrica.getContenido().substring(metrica.getContenido().lastIndexOf(" ") + 1));;
				if(contenidoMayor < metricaId) {
					contenidoMayor = metricaId;
				}
			}

			// Creacion del objeto Metrica
			Metrica metrica = new Metrica();

			metrica.setFecha(LocalDate.now().toString());
			metrica.setIdCreador(creadorSeleccionado.getId());
			metrica.setContenido("Contenido " + (contenidoMayor + 1));

			if(this.view.textVistas.getText().equalsIgnoreCase("")) {
				metrica.setVistas(0);
			} else {
				metrica.setVistas(Integer.parseInt(this.view.textVistas.getText()));
			}

			if(this.view.textLikes.getText().equalsIgnoreCase("")) {
				metrica.setMeGusta(0);
			} else {
				metrica.setMeGusta(Integer.parseInt(this.view.textLikes.getText()));
			}

			if(this.view.textComentarios.getText().equalsIgnoreCase("")) {
				metrica.setComentarios(0);
			} else {
				metrica.setComentarios(Integer.parseInt(this.view.textComentarios.getText()));
			}

			if(this.view.textCompartidos.getText().equalsIgnoreCase("")) {
				metrica.setCompartidos(0);
			} else {
				metrica.setCompartidos(Integer.parseInt(this.view.textCompartidos.getText()));
			}

			metrica.setPlataforma(this.view.comboBoxContenido.getSelectedItem().toString());

			listaContenidos.add(metrica);
			csvR.setArchivoCsv(listaContenidos);
			logger.success(metrica.getContenido() + " agregado correctamente.");
			obtenerPublicaciones(creadorSeleccionado.getId());
			actualizarValores();
			contenidoMayor = 0;

		}else if(e.getSource() == this.view.generarResRendJSON) {
			generarResumenRendimientoJSON();

		}else if (e.getSource() == this.view.generarRepColCSV) {
			//Ej 8
			JsonNode creadores = jsonR.getCreadoresNode();
			List<ReporteColabs> reporteColabs = new ArrayList<ReporteColabs>();

			for(JsonNode creador: creadores) {



				ArrayNode colaboraciones = (ArrayNode) creador.get("colaboraciones");
				for(JsonNode colaboracion: colaboraciones) {
					ReporteColabs nReporte = new ReporteColabs();
					nReporte.setIdCreador(creador.get("id").asInt());
					nReporte.setNombre(creador.get("nombre").asText());
					nReporte.setColaborador(colaboracion.get("colaborador").asText());
					nReporte.setFecha(colaboracion.get("fecha_inicio").asText());	
					reporteColabs.add(nReporte);
				}

			}

			csvR.generarCsvRepCol("resources/reporte_colaboraciones.csv", reporteColabs);
		}
	}

	private void actualizarValores() {
		creadorSeleccionado = jsonR.getCreador(Integer.parseInt(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf("."))));
		obtenerDatosCreador(creadorSeleccionado);
		generarBotonesPlataforma(creadorSeleccionado);
		obtenerColaboraciones(creadorSeleccionado);
		obtenerPublicaciones(creadorSeleccionado.getId());

		JsonNode colaboracion = creadorSeleccionado.getColaboraciones().get(Integer.parseInt(view.comboBox_1.getSelectedItem().toString().substring(0, view.comboBox_1.getSelectedItem().toString().indexOf("."))) - 1);
		obtenerDatosColaboracion(colaboracion);
		this.view.lblInfoHaste.setVisible(false);
		this.view.btnExtraerDatos.setEnabled(true);
		this.view.btnExportarConsola.setEnabled(true);
	}

	private void generarResumenRendimientoJSON() {
		// Obtener las métricas de todas las publicaciones
		List<Metrica> metricas = csvR.abrirCSV();
		ArrayNode rootNode = om.createArrayNode(); // Nodo raíz del JSON
		List<CreadorMetrica> lCreadoresMetricas = new ArrayList<CreadorMetrica>();
		List<Integer> ids = new ArrayList<Integer>();

		for(Metrica metrica : metricas) {
			if(!ids.contains(metrica.getIdCreador())) {
				ids.add(metrica.getIdCreador());
				lCreadoresMetricas.add(new CreadorMetrica(metrica.getIdCreador()));
			}
		}
		for(int i = 0; i<lCreadoresMetricas.size();i++) {
			String plataformaMasInteracciones = "", plataformaMasVistas = "";
			int vTwitch = 0, vInsta = 0, vTiktok = 0, vYoutube = 0;
			int sTwitch = 0, sInsta = 0, sTiktok = 0, sYoutube = 0;
			for(int j = 0; j<metricas.size(); j++) {
				if(metricas.get(j).getIdCreador() == lCreadoresMetricas.get(i).getId()) {

					String plataforma = metricas.get(j).getPlataforma();

					switch (plataforma) {
					case "Instagram":
						vInsta += metricas.get(j).getVistas();
						sInsta += metricas.get(j).getMeGusta() + metricas.get(j).getComentarios() + metricas.get(j).getCompartidos();
						break;
					case "TikTok":
						vTiktok += metricas.get(j).getVistas();
						sTiktok += metricas.get(j).getMeGusta() + metricas.get(j).getComentarios() + metricas.get(j).getCompartidos();
						break;
					case "YouTube":
						vYoutube += metricas.get(j).getVistas();
						sYoutube += metricas.get(j).getMeGusta() + metricas.get(j).getComentarios() + metricas.get(j).getCompartidos();
						break;
					case "Twitch":
						vTwitch += metricas.get(j).getVistas();
						sTwitch += metricas.get(j).getMeGusta() + metricas.get(j).getComentarios() + metricas.get(j).getCompartidos();
						break;
					}


				}
			}//fin bucle j

			sTwitch /= 3;
			sInsta /= 3;
			sTiktok /= 3;
			sYoutube /= 3;
			// Determinar cuál plataforma tiene más vistas
			plataformaMasVistas = obtenerPlataformaConMasVistas(vInsta, vTiktok, vYoutube, vTwitch);

			// Determinar cuál plataforma tiene más interacciones promedio
			plataformaMasInteracciones = obtenerPlataformaConMasInteracciones(sInsta, sTiktok, sYoutube, sTwitch);

			ObjectNode creadorNode = om.createObjectNode();
			creadorNode.put("id", lCreadoresMetricas.get(i).getId());
			creadorNode.put("plataformaMasVistas", plataformaMasVistas);
			creadorNode.put("plataformaMasInteracciones", plataformaMasInteracciones);
			rootNode.add(creadorNode);
		}//fin bucle i



		// Guardar el archivo JSON
		try {
			jsonR.crearJson("resources/resumen_rendimiento.json", rootNode);
			logger.success("Resumen de rendimiento generado correctamente.");
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private String obtenerPlataformaConMasVistas(int vInsta, int vTiktok, int vYoutube, int vTwitch) {
		if (vInsta > vTiktok && vInsta > vTwitch && vInsta > vYoutube) {
			return "Instagram";
		} else if (vTiktok > vInsta && vTiktok > vTwitch && vTiktok > vYoutube) {
			return "TikTok";
		} else if (vYoutube > vInsta && vYoutube > vTwitch && vYoutube > vTiktok) {
			return "YouTube";
		} else if (vTwitch > vInsta && vTwitch > vTiktok && vTwitch > vYoutube) {
			return "Twitch";
		} else {
			return "Hay empate";
		}
	}

	private String obtenerPlataformaConMasInteracciones(int sInsta, int sTiktok, int sYoutube, int sTwitch) {
		if (sInsta > sTiktok && sInsta > sTwitch && sInsta > sYoutube) {
			return "Instagram";
		} else if (sTiktok > sInsta && sTiktok > sTwitch && sTiktok > sYoutube) {
			return "TikTok";
		} else if (sYoutube > sInsta && sYoutube > sTwitch && sYoutube > sTiktok) {
			return "YouTube";
		} else if (sTwitch > sInsta && sTwitch > sTiktok && sTwitch > sYoutube) {
			return "Twitch";
		} else {
			return "Hay empate";
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.view.listPublicaciones) {
			if(this.view.listPublicaciones.getSelectedValue() != null) {
				List<Metrica> listaPublicaciones = csvR.obtenerPorId(creadorSeleccionado.getId());
				for(Metrica publicacion: listaPublicaciones) {
					int posicion = this.view.listPublicaciones.getSelectedValue().toString().indexOf(" -");
					if(publicacion.getContenido().equalsIgnoreCase(this.view.listPublicaciones.getSelectedValue().toString().substring(0, posicion))) {
						this.view.textIdPublicacion.setText(publicacion.getContenido());
						this.view.textVistas.setText(String.valueOf(publicacion.getVistas()));
						this.view.textLikes.setText(String.valueOf(publicacion.getMeGusta()));
						this.view.textComentarios.setText(String.valueOf(publicacion.getComentarios()));
						this.view.textCompartidos.setText(String.valueOf(publicacion.getCompartidos()));
						this.view.lblMaxComentarios.setText(String.valueOf(publicacion.getComentarios()));
						if(publicacion.getComentarios() != 0) {
							cargarComentario(1);
							this.view.lblMinComentarios.setText("1");
						} else {
							this.view.lblMinComentarios.setText("0");
						}
					}
				}
			}
		}
	}

	private void obtenerDatosCreador(Creador creador) {

		view.textFieldId.setText(String.valueOf(creador.getId()));
		view.textFieldNombre.setText(String.valueOf(creador.getNombre()));
		view.textFieldPais.setText(String.valueOf(creador.getPais()));
		view.textFieldTematica.setText(String.valueOf(creador.getTematica()));
		view.textFieldSeguidores.setText(String.valueOf(creador.getSegidoresTotales()));
		view.textFieldInteracciones.setText(String.valueOf((int) Math.round(creador.getEstadisticas().get("interacciones_totales"))));
		view.textFieldPromVist.setText(String.valueOf((int) Math.round(creador.getEstadisticas().get("promedio_vistas_mensuales"))));
		view.textFieldTasaCrec.setText(String.valueOf(creador.getEstadisticas().get("tasa_crecimiento_seguidores")));

		logger.log("Creador de contenido seleccionado " + view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf(".")));
	}

	private void generarBotonesPlataforma(Creador creador) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		this.view.plataformasPanel.removeAll();

		JsonNode plataformas = creador.getPlataformas();

		int i = 0;
		for (JsonNode plataforma : plataformas) {
			JButton botonPlataforma = new JButton(plataforma.get("nombre").asText());

			// Configuración de estilo
			botonPlataforma.setFont(new Font("Arial", Font.BOLD, 16));
			botonPlataforma.setBackground(new Color(51, 204, 255));
			botonPlataforma.setPreferredSize(new Dimension(200, 50));
			botonPlataforma.setForeground(Color.WHITE);
			botonPlataforma.setFocusPainted(false);
			botonPlataforma.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			botonPlataforma.setPreferredSize(new Dimension(200, 50));
			botonPlataforma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			gbc.gridx = i % 4;
			gbc.gridy = i / 4;
			gbc.insets = new java.awt.Insets(10, 10, 10, 10);

			botonPlataforma.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					eliminarHistoricosValores();
					cargarGraficaYDatos(botonPlataforma.getText());
					botonSeleccionado = botonPlataforma.getText();
				}
			});
			this.view.plataformasPanel.add(botonPlataforma, gbc);
			i++;
		}

		this.view.plataformasPanel.revalidate();
		this.view.plataformasPanel.repaint();
	}

	private void generarBotonesPlataformaCont() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		this.view.plataformasPanelCont.removeAll();

		ArrayList<String> plataformas = new ArrayList<String>();
		plataformas.add("TikTok");
		plataformas.add("YouTube");
		plataformas.add("Twitch");
		plataformas.add("Instagram");

		int i = 0;
		for (String plataforma : plataformas) {
			JButton botonPlataforma = new JButton(plataforma);

			// Configuración de estilo
			botonPlataforma.setFont(new Font("Arial", Font.BOLD, 16));
			botonPlataforma.setBackground(new Color(51, 204, 255));
			botonPlataforma.setPreferredSize(new Dimension(200, 50));
			botonPlataforma.setForeground(Color.WHITE);
			botonPlataforma.setFocusPainted(false);
			botonPlataforma.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			botonPlataforma.setPreferredSize(new Dimension(200, 50));
			botonPlataforma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			gbc.gridx = i % 4;
			gbc.gridy = i / 4;
			gbc.insets = new java.awt.Insets(10, 10, 10, 10);

			botonPlataforma.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					calcularRendimientoContenido(botonPlataforma.getText());
					logger.log("Mostrando Datos promedio de " + botonPlataforma.getText());
				}
			});
			this.view.plataformasPanelCont.add(botonPlataforma, gbc);
			i++;
		}

		this.view.plataformasPanelCont.revalidate();
		this.view.plataformasPanelCont.repaint();
	}

	private void calcularRendimientoContenido(String text) {
		ObjectNode contenidosPlataforma = csvR.obtenerContenidosPlataformaCont(text);
		// Mapas para almacenar datos
		Map<String, Integer> totalVistasPorTipo = new HashMap<>();
		Map<String, Integer> totalLikesPorTipo = new HashMap<>();
		Map<String, Integer> conteoPorTipo = new HashMap<>();

		// Procesar los datos del ObjectNode
		for (JsonNode contenido : contenidosPlataforma) {
			String tipo = contenido.get("tipo").asText().toLowerCase();
			int vistas = contenido.get("vistas").asInt();
			int meGusta = contenido.get("me_gusta").asInt();

			totalVistasPorTipo.put(tipo, totalVistasPorTipo.getOrDefault(tipo, 0) + vistas);
			totalLikesPorTipo.put(tipo, totalLikesPorTipo.getOrDefault(tipo, 0) + meGusta);
			conteoPorTipo.put(tipo, conteoPorTipo.getOrDefault(tipo, 0) + 1);
		}

		// Calcular promedios
		int promedioVideoLikes = conteoPorTipo.getOrDefault("video", 0) == 0 ? 0
				: totalLikesPorTipo.get("video") / conteoPorTipo.get("video");
		int promedioImagenLikes = conteoPorTipo.getOrDefault("imagen", 0) == 0 ? 0
				: totalLikesPorTipo.get("imagen") / conteoPorTipo.get("imagen");
		int promedioStreamLikes = conteoPorTipo.getOrDefault("stream", 0) == 0 ? 0
				: totalLikesPorTipo.get("stream") / conteoPorTipo.get("stream");

		int promedioVideoVistas = conteoPorTipo.getOrDefault("video", 0) == 0 ? 0
				: totalVistasPorTipo.get("video") / conteoPorTipo.get("video");
		int promedioImagenVistas = conteoPorTipo.getOrDefault("imagen", 0) == 0 ? 0
				: totalVistasPorTipo.get("imagen") / conteoPorTipo.get("imagen");
		int promedioStreamVistas = conteoPorTipo.getOrDefault("stream", 0) == 0 ? 0
				: totalVistasPorTipo.get("stream") / conteoPorTipo.get("stream");

		this.view.textVideoLikes.setText(String.valueOf(promedioVideoLikes));
		this.view.textImagenLikes.setText(String.valueOf(promedioImagenLikes));
		this.view.textStreamLikes.setText(String.valueOf(promedioStreamLikes));
		this.view.textVideoVistas.setText(String.valueOf(promedioVideoVistas));
		this.view.textImagenVistas.setText(String.valueOf(promedioImagenVistas));
		this.view.textStreamVistas.setText(String.valueOf(promedioStreamVistas));

		// Cargar Gráficas de Likes y Vistas
		this.view.panelLikesGraficaCont.removeAll();
		this.view.panelVistasGraficaCont.removeAll();

		DefaultPieDataset<String> datasetLikes = new DefaultPieDataset<>();
		DefaultPieDataset<String> datasetVistas = new DefaultPieDataset<>();

		datasetLikes.setValue("Video", promedioVideoLikes);
		datasetLikes.setValue("Imagen", promedioImagenLikes);
		datasetLikes.setValue("Stream", promedioStreamLikes);

		datasetVistas.setValue("Video", promedioVideoVistas);
		datasetVistas.setValue("Imagen", promedioImagenVistas);
		datasetVistas.setValue("Stream", promedioStreamVistas);

		// Crear las gráficas
		JFreeChart chartLikes = ChartFactory.createPieChart(
				"Promedio de Likes por tipo de contenido (" + text + ")",
				datasetLikes,
				true,
				true,
				false
				);

		JFreeChart chartVistas = ChartFactory.createPieChart(
				"Promedio de Vistas por tipo de contenido (" + text + ")",
				datasetVistas,
				true,
				true,
				false
				);

		// Crear los paneles de las gráficas
		ChartPanel likesChartPanel = new ChartPanel(chartLikes);
		likesChartPanel.setPreferredSize(this.view.panelLikesGrafica.getSize());
		likesChartPanel.setMouseWheelEnabled(true);

		ChartPanel vistasChartPanel = new ChartPanel(chartVistas);
		vistasChartPanel.setPreferredSize(this.view.panelVistasGrafica.getSize());
		vistasChartPanel.setMouseWheelEnabled(true);

		// Agregar los paneles a los paneles de la vista
		this.view.panelLikesGraficaCont.add(likesChartPanel);
		this.view.panelVistasGraficaCont.add(vistasChartPanel);

		this.view.panelLikesGrafica.revalidate();
		this.view.panelLikesGrafica.repaint();
		this.view.panelVistasGrafica.revalidate();
		this.view.panelVistasGrafica.repaint();
	}



	private void eliminarHistoricosValores() {
		this.view.textFieldFechHist.setText("");
		this.view.textFieldNuevosSeg.setText("");
		this.view.textFieldIntHist.setText("");
	}

	private void obtenerColaboraciones(Creador creador) {
		this.view.comboBox_1.removeAll();

		JsonNode colaboraciones = creador.getColaboraciones();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

		int i = 1;
		for (JsonNode colaboracion : colaboraciones) {
			model.addElement(i + ". " + colaboracion.get("colaborador").asText());
			i++;
		}

		this.view.comboBox_1.setModel(model);

		this.view.comboBox_1.revalidate();
		this.view.comboBox_1.repaint();
	}

	private void obtenerPublicaciones(int id) {
		DefaultListModel<String> modeloPublicacion = new DefaultListModel<>();
		List<Metrica> listaPublicaciones = csvR.obtenerPorId(id);

		for(Metrica publicacion: listaPublicaciones) {
			modeloPublicacion.addElement(publicacion.getContenido() + " - " + publicacion.getFecha().toString());
		}

		this.view.listPublicaciones.setModel(modeloPublicacion);

		// Obtener comentarios aleatorios
		listaComentarios = comentariosController.obtenerComentarios();

		this.view.listPublicaciones.revalidate();
		this.view.listPublicaciones.repaint();
	}

	private void obtenerDatosColaboracion(JsonNode colaboracion) {
		this.view.textFieldTemCol.setText(colaboracion.get("tematica").asText());
		this.view.textFieldFechaInicio.setText(colaboracion.get("fecha_inicio").asText());
		this.view.textFieldFechaFin.setText(colaboracion.get("fecha_fin").asText());
		this.view.textFieldTipo.setText(colaboracion.get("tipo").asText());

		String estado = colaboracion.get("estado").asText();

		if (estado.equalsIgnoreCase("Activa")) {
			this.view.chckbxColActiva.setSelected(true);
		} else {
			this.view.chckbxColActiva.setSelected(false);
		}
	}

	private void cargarGraficaYDatos(String text) {

		// Cargar Datos de Gráficas
		this.view.panelLikesGrafica.removeAll();
		this.view.panelVistasGrafica.removeAll();

		DefaultPieDataset<String> datasetVistas = new DefaultPieDataset<>();
		DefaultPieDataset<String> datasetLikes = new DefaultPieDataset<>();

		ObjectNode contenidosPlataforma = csvR.obtenerContenidosPlataforma(creadorSeleccionado.getId(), text);
		Iterator<Entry<String, JsonNode>> fieldsIterator = contenidosPlataforma.fields();

		double contadorVistas = 0.0;
		double contadorLikes = 0.0;
		double numContenido = 0.0;

		while (fieldsIterator.hasNext()) {

			Entry<String, JsonNode> entry = fieldsIterator.next();
			String contenido = entry.getKey();
			JsonNode datos = entry.getValue();

			int vistas = datos.get("vistas").asInt();
			contadorVistas += vistas;
			int likes = datos.get("me_gusta").asInt();
			contadorLikes += likes;

			datasetVistas.setValue(contenido, vistas);
			datasetLikes.setValue(contenido, likes);
			numContenido++;
		}

		// Realizar promedio de Vistas y Likes

		this.view.textPromLikes.setText(String.valueOf(contadorLikes / numContenido));
		this.view.textPromVistas.setText(String.valueOf(contadorVistas / numContenido));


		JFreeChart chartVistas = ChartFactory.createPieChart(
				"Vistas " + text,
				datasetVistas,
				true,
				true,
				false
				);

		JFreeChart chartLikes = ChartFactory.createPieChart(
				"Likes " + text,
				datasetLikes,
				true,
				true,
				false
				);

		ChartPanel vistasChart = new ChartPanel(chartVistas);
		vistasChart.setPreferredSize(this.view.panelVistasGrafica.getSize());
		vistasChart.setMouseWheelEnabled(true);

		ChartPanel likesChart = new ChartPanel(chartLikes);
		likesChart.setPreferredSize(this.view.panelVistasGrafica.getSize());
		likesChart.setMouseWheelEnabled(true);

		this.view.panelVistasGrafica.add(vistasChart);
		this.view.panelLikesGrafica.add(likesChart);

		this.view.panelVistasGrafica.revalidate();
		this.view.panelVistasGrafica.repaint();
		this.view.panelLikesGrafica.revalidate();
		this.view.panelLikesGrafica.repaint();

		// Cargar Datos de TextViews

		for (JsonNode plataforma : creadorSeleccionado.getPlataformas()) {
			if (plataforma.get("nombre").asText().equalsIgnoreCase(text)) {
				this.view.textFieldUsuario.setText(plataforma.get("usuario").asText());
				this.view.textFieldSegPlat.setText(plataforma.get("seguidores").asText());
				this.view.textFieldFechCr.setText(plataforma.get("fecha_creacion").asText());

				view.comboBox_2.removeAll();
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

				int i = 1;
				for (JsonNode historico : plataforma.get("historico")) {
					model.addElement(i + ". " + historico.get("fecha").asText());
					i++;
				}
				view.comboBox_2.setModel(model);

				Double tasaCrecimiento = calcularTasaCrecimiento(plataforma.get("historico").get(0).get("nuevos_seguidores").asInt(), plataforma.get("historico").get(1).get("nuevos_seguidores").asInt());
				this.view.textTasaCrecimientoRang.setText(String.valueOf(tasaCrecimiento) + "%");
			}
		}

	}

	private void cargarHistorico(JsonNode historico) {
		this.view.textFieldFechHist.setText(historico.get("fecha").asText());
		this.view.textFieldNuevosSeg.setText(historico.get("nuevos_seguidores").asText());
		this.view.textFieldIntHist.setText(historico.get("interacciones").asText());
	}

	private void cargarComentario(int comentario) {
		if(comentario <= 0) {
			comentario = 1;
		}

		if(comentario > 500) {
			comentario = comentario -= 500;
		}

		JsonNode comentarioSeleccionado = listaComentarios.get(comentario);

		this.view.textIdComentario.setText(comentarioSeleccionado.get("id").asText());
		this.view.textNombreComentario.setText(comentarioSeleccionado.get("name").asText());
		this.view.textEmailComentario.setText(comentarioSeleccionado.get("email").asText());
		this.view.textAreaComentario.setText(comentarioSeleccionado.get("body").asText());
	}

	private void resetearValores() {
		this.view.textFieldUsuario.setText("");
		this.view.textFieldSegPlat.setText("");
		this.view.textFieldFechCr.setText("");
		this.view.textFieldFechHist.setText("");
		this.view.textFieldNuevosSeg.setText("");
		this.view.textFieldIntHist.setText("");
		this.view.textFieldTemCol.setText("");
		this.view.textFieldFechaInicio.setText("");
		this.view.textFieldFechaFin.setText("");
		this.view.textFieldTipo.setText("");
		this.view.textIdPublicacion.setText("");
		this.view.textVistas.setText("");
		this.view.textLikes.setText("");
		this.view.textComentarios.setText("");
		this.view.textCompartidos.setText("");
		this.view.listPublicaciones.setSelectedValue(null, false);

		this.view.panelVistasGrafica.removeAll();
		this.view.panelLikesGrafica.removeAll();
		creadorSeleccionado = null;
		botonSeleccionado = null;

		this.view.panelVistasGrafica.revalidate();
		this.view.panelVistasGrafica.repaint();
		this.view.panelLikesGrafica.revalidate();
		this.view.panelLikesGrafica.repaint();
	}

	private void generarCreadoresCol (DefaultComboBoxModel<String> modelCol) {
		List<Creador> creadores = jsonR.getListaCreadores();
		modelCol.addElement("Elige un colaborador");
		for(int i=0;i<creadores.size();i++) {

			modelCol.addElement((i+1) + ". " + creadores.get(i).getNombre());
		}
		view.comboBoxColNew.setModel(modelCol);
	}

	public double calcularTasaCrecimiento(int seguidoresInicial, int seguidoresFinal) {

		if (seguidoresInicial == 0) {
			return 0;
		}
		return Math.round(((seguidoresFinal - seguidoresInicial) / (double) seguidoresInicial) * 100);
	}


}