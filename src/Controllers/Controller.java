package Controllers;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.fasterxml.jackson.databind.JsonNode;

import Models.Creador;
import Views.MainView;

public class Controller implements ActionListener{

	private final MainView view;
	private JsonReader jsonR = new JsonReader("resources/creadores.json");
	private Creador creadorSeleccionado;

	public Controller(MainView frame) {

		this.view = frame;
		this.view.comboBox.addActionListener(this);
		this.view.comboBox_1.addActionListener(this);
		this.view.exitItem.addActionListener(this);
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
			creadorSeleccionado = jsonR.getCreador(Integer.parseInt(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf("."))));
			obtenerDatosCreador(creadorSeleccionado);
			generarBotonesPlataforma(creadorSeleccionado);
			obtenerColaboraciones(creadorSeleccionado);
			
			JsonNode colaboracion = creadorSeleccionado.getColaboraciones().get(Integer.parseInt(view.comboBox_1.getSelectedItem().toString().substring(0, view.comboBox_1.getSelectedItem().toString().indexOf("."))) - 1);
			obtenerDatosColaboracion(colaboracion);

		} else
		
		if(e.getSource() == this.view.exitItem) {
			System.exit(0);
		} else
		
		if(e.getSource() == this.view.comboBox_1) {
			JsonNode colaboracion = creadorSeleccionado.getColaboraciones().get(Integer.parseInt(view.comboBox_1.getSelectedItem().toString().substring(0, view.comboBox_1.getSelectedItem().toString().indexOf("."))) - 1);
			obtenerDatosColaboracion(colaboracion);
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
}
