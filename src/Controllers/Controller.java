package Controllers;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Models.Creador;
import Models.Metrica;
import Views.MainView;

public class Controller implements ActionListener {

	private final MainView view;
	private JsonReader jsonR = new JsonReader("resources/creadores.json");
	private CsvReader csvR = new CsvReader("resources/metricas_contenido.csv");
	private HasteBinController hasteServer = new HasteBinController();
	
	private Creador creadorSeleccionado;
	private String botonSeleccionado;

	public Controller(MainView frame) {

		this.view = frame;
		this.view.comboBox.addActionListener(this);
		this.view.comboBox_1.addActionListener(this);
		this.view.comboBox_2.addActionListener(this);
		this.view.exitItem.addActionListener(this);
		this.view.btnExtraerDatos.addActionListener(this);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		
		List<Creador> creadores = jsonR.getListaCreadores();
		for(int i=0;i<creadores.size();i++) {
			model.addElement((i+1) + ". " + creadores.get(i).getNombre());
		}
		view.comboBox.setModel(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.view.comboBox) {
			resetearValores();
			creadorSeleccionado = jsonR.getCreador(Integer.parseInt(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf("."))));
			obtenerDatosCreador(creadorSeleccionado);
			generarBotonesPlataforma(creadorSeleccionado);
			obtenerColaboraciones(creadorSeleccionado);
			
			JsonNode colaboracion = creadorSeleccionado.getColaboraciones().get(Integer.parseInt(view.comboBox_1.getSelectedItem().toString().substring(0, view.comboBox_1.getSelectedItem().toString().indexOf("."))) - 1);
			obtenerDatosColaboracion(colaboracion);
			this.view.lblInfoHaste.setVisible(false);
			this.view.btnExtraerDatos.setEnabled(true);

		} else
		
		if(e.getSource() == this.view.exitItem) {
			System.exit(0);
		} else 
			
		if(e.getSource() == this.view.btnExtraerDatos) {
			for(JsonNode creadorNode: jsonR.getCreadoresNode()) {
				if(creadorNode.get("id").asInt() == creadorSeleccionado.getId()) {
					this.view.lblInfoHaste.setVisible(true);
					this.view.lblInfoHaste.setText(hasteServer.uploadTextToHastebin(creadorNode));
				}
			}
		} else 
		
		if(e.getSource() == this.view.comboBox_1) {
			JsonNode colaboracion = creadorSeleccionado.getColaboraciones().get(Integer.parseInt(view.comboBox_1.getSelectedItem().toString().substring(0, view.comboBox_1.getSelectedItem().toString().indexOf("."))) - 1);
			obtenerDatosColaboracion(colaboracion);
		} else if(e.getSource() == this.view.comboBox_2) {
			JsonNode plataformas = creadorSeleccionado.getPlataformas();
			for(JsonNode plataforma: plataformas) {
				if(plataforma.get("nombre").asText().equalsIgnoreCase(botonSeleccionado)) {
					cargarHistorico(plataforma.get("historico").get(Integer.parseInt(view.comboBox_2.getSelectedItem().toString().substring(0, view.comboBox_2.getSelectedItem().toString().indexOf("."))) - 1));
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
		
		System.out.println(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf(".")));
	}
	
	private void generarBotonesPlataforma(Creador creador) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		this.view.plataformasPanel.removeAll();
		
		JsonNode plataformas = creador.getPlataformas();
		
		int i = 0;
		for(JsonNode plataforma: plataformas) {
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
				public void actionPerformed(ActionEvent e) {
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
	
	private void obtenerColaboraciones(Creador creador) {
		this.view.comboBox_1.removeAll();
		
		JsonNode colaboraciones = creador.getColaboraciones();
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		
		int i = 1;
		for(JsonNode colaboracion: colaboraciones) {
			model.addElement(i + ". " + colaboracion.get("colaborador").asText());
			i++;
		}
		
		this.view.comboBox_1.setModel(model);
		
		this.view.comboBox_1.revalidate();
		this.view.comboBox_1.repaint();
	}
	
	private void obtenerDatosColaboracion(JsonNode colaboracion) {
		this.view.textFieldTemCol.setText(colaboracion.get("tematica").asText());
		this.view.textFieldFechaInicio.setText(colaboracion.get("fecha_inicio").asText());
		this.view.textFieldFechaFin.setText(colaboracion.get("fecha_fin").asText());
		this.view.textFieldTipo.setText(colaboracion.get("tipo").asText());
		
		String estado = colaboracion.get("estado").asText();
		
		if(estado.equalsIgnoreCase("Activa")) {
			this.view.chckbxColActiva.setSelected(true);
		} else {
			this.view.chckbxColActiva.setSelected(false);
		}
	}
	
	private void cargarGraficaYDatos(String text) {
		
		// Cargar Datos de Gráficas
		this.view.panelLikesGrafica.removeAll();
		this.view.panelVistasGrafica.removeAll();
		
		DefaultPieDataset<String> datasetVistas = new DefaultPieDataset<String>();
		DefaultPieDataset<String> datasetLikes = new DefaultPieDataset<String>();
		
		ObjectNode contenidosPlataforma = csvR.obtenerContenidosPlataforma(creadorSeleccionado.getId(), text);
		Iterator<Entry<String, JsonNode>> fieldsIterator = contenidosPlataforma.fields();
		
		Double contadorVistas = 0.0;
		Double contadorLikes = 0.0;
		Double numContenido = 0.0;
		
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
        
        for(JsonNode plataforma: creadorSeleccionado.getPlataformas()) {
        	if(plataforma.get("nombre").asText().equalsIgnoreCase(text)) {
        		this.view.textFieldUsuario.setText(plataforma.get("usuario").asText());
        		this.view.textFieldSegPlat.setText(plataforma.get("seguidores").asText());
        		this.view.textFieldFechCr.setText(plataforma.get("fecha_creacion").asText());
        		
        		view.comboBox_2.removeAll();
        		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        		
        		int i = 1;
        		for(JsonNode historico: plataforma.get("historico")) {
        				model.addElement(i + ". " + historico.get("fecha").asText());
        				i++;
        		}     		
        		view.comboBox_2.setModel(model);
        	}
        }
	}
	
	private void cargarHistorico(JsonNode historico) {
		this.view.textFieldFechHist.setText(historico.get("fecha").asText());
		this.view.textFieldNuevosSeg.setText(historico.get("nuevos_seguidores").asText());
		this.view.textFieldIntHist.setText(historico.get("interacciones").asText());
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
		
		this.view.panelVistasGrafica.removeAll();
        this.view.panelLikesGrafica.removeAll();
		creadorSeleccionado = null;
		botonSeleccionado = null;
		
		this.view.panelVistasGrafica.revalidate();
        this.view.panelVistasGrafica.repaint();
        this.view.panelLikesGrafica.revalidate();
        this.view.panelLikesGrafica.repaint();
	}
}
