package Controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import Models.Creador;
import Views.MainView;

public class Controller implements ActionListener{

	private final MainView view;
	private JsonReader jsonR = new JsonReader("resources/creadores.json");

	public Controller(MainView frame) {

		this.view = frame;
		this.view.comboBox.addActionListener(this);
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

			System.out.println(view.comboBox.getSelectedItem().toString().substring(0, view.comboBox.getSelectedItem().toString().indexOf(".")));

		}else if(e.getSource() == this.view.exitItem) {
			System.exit(0);
		}

	}

}
