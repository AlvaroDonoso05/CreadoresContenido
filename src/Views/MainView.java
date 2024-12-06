package Views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import Controllers.Controller;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;


public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JLayeredPane contentPane;
	public Controller controller;
	
	
	public JMenuBar menuBar;
	public JComboBox<String> comboBox;
	public JLabel lblId;
	public JTextField textFieldId;
	public JLabel lblNombre;
	public JTextField textFieldNombre;
	public JLabel lblPais;
	public JTextField textFieldPais;
	public JLabel lblTematica;
	public JTextField textFieldTematica;
	public JLabel lblSeguidores;
	public JTextField textFieldSeguidores;
	public JLabel lblInteracciones;
	public JTextField textFieldInteracciones;
	public JLabel lblPromedioVistas;
	public JTextField textFieldPromVist;
	public JLabel lblTasaCrecimiento;
	public JTextField textFieldTasaCrec;
	public JMenuItem exitItem;
	public JMenuItem newItem;
	public JMenuItem openItem;
	public JMenuItem savetem;
	
	public JMenu helpMenu;
	public JMenuItem saveItem;
	public JMenu fileMenu;
	public JMenu editMenu;
	public JLabel lblNewLabel;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JLabel lblColaboraciones;
	public JLabel lblNewLabel_1;
	public JComboBox<String> comboBox_1;
	public JLabel lblTemCol;
	public JTextField textFieldTemCol;
	public JLabel lblTipo;
	public JTextField textFieldTipo;
	public JLabel lblFechaInicio;
	public JTextField textFieldFechaInicio;
	public JLabel lblFechaFin;
	public JTextField textFieldFechaFin;
	public JLabel lblEstado;
	public JCheckBox chckbxColActiva;
	

	

	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 709);
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("ayuda");
		setJMenuBar(menuBar);
		contentPane = new JLayeredPane();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");

		// Add JMenus to the JMenuBar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		// Create JMenuItems
		newItem = new JMenuItem("New");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");

		fileMenu.add(newItem); 
		fileMenu.add(openItem); 
		fileMenu.add(saveItem); 
		fileMenu.addSeparator(); 
		fileMenu.add(exitItem);

	        

		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(52, 127, 182, 40);
		contentPane.add(comboBox);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(379, 121, 108, 24);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldId.setBounds(509, 127, 163, 21);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		textFieldId.setEditable(false);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(379, 157, 108, 24);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(509, 163, 163, 21);
		contentPane.add(textFieldNombre);
		textFieldNombre.setEditable(false);
		
		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(379, 193, 108, 24);
		contentPane.add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(509, 199, 163, 21);
		contentPane.add(textFieldPais);
		textFieldPais.setEditable(false);
		
		lblTematica = new JLabel("Temática:");
		lblTematica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTematica.setBounds(379, 227, 108, 24);
		contentPane.add(lblTematica);
		
		textFieldTematica = new JTextField();
		textFieldTematica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTematica.setColumns(10);
		textFieldTematica.setBounds(509, 233, 163, 21);
		textFieldTematica.setEditable(false);
		contentPane.add(textFieldTematica);
		
		lblSeguidores = new JLabel("Seguidores:");
		lblSeguidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeguidores.setBounds(379, 261, 108, 24);
		contentPane.add(lblSeguidores);
		
		textFieldSeguidores = new JTextField();
		textFieldSeguidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldSeguidores.setColumns(10);
		textFieldSeguidores.setBounds(509, 267, 163, 21);
		textFieldSeguidores.setEditable(false);
		contentPane.add(textFieldSeguidores);
		
		lblInteracciones = new JLabel("Interacciones:");
		lblInteracciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInteracciones.setBounds(706, 121, 108, 24);
		contentPane.add(lblInteracciones);
		
		textFieldInteracciones = new JTextField();
		textFieldInteracciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldInteracciones.setEditable(false);
		textFieldInteracciones.setColumns(10);
		textFieldInteracciones.setBounds(836, 127, 163, 21);
		contentPane.add(textFieldInteracciones);
		
		lblPromedioVistas = new JLabel("Promedio Vistas:");
		lblPromedioVistas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPromedioVistas.setBounds(706, 157, 108, 24);
		contentPane.add(lblPromedioVistas);
		
		textFieldPromVist = new JTextField();
		textFieldPromVist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPromVist.setEditable(false);
		textFieldPromVist.setColumns(10);
		textFieldPromVist.setBounds(836, 163, 163, 21);
		contentPane.add(textFieldPromVist);
		
		lblTasaCrecimiento = new JLabel("Tasa Crecimiento:");
		lblTasaCrecimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTasaCrecimiento.setBounds(706, 193, 108, 24);
		contentPane.add(lblTasaCrecimiento);
		
		textFieldTasaCrec = new JTextField();
		textFieldTasaCrec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTasaCrec.setEditable(false);
		textFieldTasaCrec.setColumns(10);
		textFieldTasaCrec.setBounds(836, 199, 163, 21);
		contentPane.add(textFieldTasaCrec);
		
		lblNewLabel = new JLabel("Plataformas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 332, 144, 46);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(276, 332, 128, 79);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(476, 332, 128, 79);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(686, 332, 128, 79);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(871, 332, 128, 79);
		contentPane.add(btnNewButton_3);
		
		lblColaboraciones = new JLabel("Colaboraciones:");
		lblColaboraciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColaboraciones.setBounds(52, 483, 144, 46);
		contentPane.add(lblColaboraciones);
		
		lblNewLabel_1 = new JLabel("Seleccione al Creador:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 78, 182, 39);
		contentPane.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(186, 498, 182, 40);
		contentPane.add(comboBox_1);
		
		lblTemCol = new JLabel("Temática:");
		lblTemCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemCol.setBounds(409, 498, 108, 24);
		contentPane.add(lblTemCol);
		
		textFieldTemCol = new JTextField();
		textFieldTemCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTemCol.setEditable(false);
		textFieldTemCol.setColumns(10);
		textFieldTemCol.setBounds(523, 500, 163, 21);
		contentPane.add(textFieldTemCol);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBounds(706, 498, 108, 24);
		contentPane.add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTipo.setEditable(false);
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(820, 500, 163, 21);
		contentPane.add(textFieldTipo);
		
		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaInicio.setBounds(409, 543, 108, 24);
		contentPane.add(lblFechaInicio);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechaInicio.setEditable(false);
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(523, 545, 163, 21);
		contentPane.add(textFieldFechaInicio);
		
		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaFin.setBounds(706, 543, 108, 24);
		contentPane.add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechaFin.setEditable(false);
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setBounds(820, 545, 163, 21);
		contentPane.add(textFieldFechaFin);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(409, 584, 108, 24);
		contentPane.add(lblEstado);
		
		chckbxColActiva = new JCheckBox("");
		chckbxColActiva.setBounds(523, 587, 93, 21);
		contentPane.add(chckbxColActiva);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.controller = new Controller(frame);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
