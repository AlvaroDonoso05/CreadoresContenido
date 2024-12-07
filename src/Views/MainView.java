package Views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import Controllers.Controller;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

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
	public JButton btnNewButton_1;
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
	public JPanel plataformasPanel;
	private JPanel mainPanel;
	private JButton btnNewButton;

	public MainView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 709);

		// Set FlatLaf Look and Feel
		try {
			javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

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

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 204, 204));
		mainPanel.setForeground(new Color(255, 255, 255));
		mainPanel.setBounds(0, 0, 1186, 648);
		mainPanel.setLayout(null);
		contentPane.add(mainPanel);

		comboBox = new JComboBox<>();
		comboBox.setBounds(52, 80, 182, 40);
		mainPanel.add(comboBox);

		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(379, 80, 108, 24);
		mainPanel.add(lblId);

		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldId.setBounds(509, 86, 163, 21);
		mainPanel.add(textFieldId);
		textFieldId.setColumns(10);
		textFieldId.setEditable(false);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(379, 116, 108, 24);
		mainPanel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(509, 122, 163, 21);
		mainPanel.add(textFieldNombre);
		textFieldNombre.setEditable(false);

		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(379, 152, 108, 24);
		mainPanel.add(lblPais);

		textFieldPais = new JTextField();
		textFieldPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(509, 158, 163, 21);
		mainPanel.add(textFieldPais);
		textFieldPais.setEditable(false);

		lblTematica = new JLabel("Temática:");
		lblTematica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTematica.setBounds(379, 186, 108, 24);
		mainPanel.add(lblTematica);

		textFieldTematica = new JTextField();
		textFieldTematica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTematica.setColumns(10);
		textFieldTematica.setBounds(509, 192, 163, 21);
		textFieldTematica.setEditable(false);
		mainPanel.add(textFieldTematica);

		lblSeguidores = new JLabel("Seguidores:");
		lblSeguidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeguidores.setBounds(379, 220, 108, 24);
		mainPanel.add(lblSeguidores);

		textFieldSeguidores = new JTextField();
		textFieldSeguidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldSeguidores.setColumns(10);
		textFieldSeguidores.setBounds(509, 226, 163, 21);
		textFieldSeguidores.setEditable(false);
		mainPanel.add(textFieldSeguidores);

		lblInteracciones = new JLabel("Interacciones:");
		lblInteracciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInteracciones.setBounds(706, 80, 108, 24);
		mainPanel.add(lblInteracciones);

		textFieldInteracciones = new JTextField();
		textFieldInteracciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldInteracciones.setEditable(false);
		textFieldInteracciones.setColumns(10);
		textFieldInteracciones.setBounds(836, 86, 163, 21);
		mainPanel.add(textFieldInteracciones);

		lblPromedioVistas = new JLabel("Promedio Vistas:");
		lblPromedioVistas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPromedioVistas.setBounds(706, 116, 108, 24);
		mainPanel.add(lblPromedioVistas);

		textFieldPromVist = new JTextField();
		textFieldPromVist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPromVist.setEditable(false);
		textFieldPromVist.setColumns(10);
		textFieldPromVist.setBounds(836, 122, 163, 21);
		mainPanel.add(textFieldPromVist);

		lblTasaCrecimiento = new JLabel("Tasa Crecimiento:");
		lblTasaCrecimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTasaCrecimiento.setBounds(706, 152, 108, 24);
		mainPanel.add(lblTasaCrecimiento);

		textFieldTasaCrec = new JTextField();
		textFieldTasaCrec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTasaCrec.setEditable(false);
		textFieldTasaCrec.setColumns(10);
		textFieldTasaCrec.setBounds(836, 158, 163, 21);
		mainPanel.add(textFieldTasaCrec);

		lblNewLabel = new JLabel("Plataformas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 289, 144, 46);
		mainPanel.add(lblNewLabel);

		lblColaboraciones = new JLabel("Colaboraciones:");
		lblColaboraciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColaboraciones.setBounds(52, 483, 144, 46);
		mainPanel.add(lblColaboraciones);

		lblNewLabel_1 = new JLabel("Seleccione al Creador:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 30, 182, 39);
		mainPanel.add(lblNewLabel_1);

		comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(186, 498, 182, 40);
		mainPanel.add(comboBox_1);

		lblTemCol = new JLabel("Temática:");
		lblTemCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemCol.setBounds(409, 498, 108, 24);
		mainPanel.add(lblTemCol);

		textFieldTemCol = new JTextField();
		textFieldTemCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTemCol.setEditable(false);
		textFieldTemCol.setColumns(10);
		textFieldTemCol.setBounds(523, 500, 163, 21);
		mainPanel.add(textFieldTemCol);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBounds(706, 498, 108, 24);
		mainPanel.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTipo.setEditable(false);
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(820, 500, 163, 21);
		mainPanel.add(textFieldTipo);

		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaInicio.setBounds(409, 543, 108, 24);
		mainPanel.add(lblFechaInicio);

		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechaInicio.setEditable(false);
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(523, 545, 163, 21);
		mainPanel.add(textFieldFechaInicio);

		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaFin.setBounds(706, 543, 108, 24);
		mainPanel.add(lblFechaFin);

		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechaFin.setEditable(false);
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setBounds(820, 545, 163, 21);
		mainPanel.add(textFieldFechaFin);

		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(409, 584, 108, 24);
		mainPanel.add(lblEstado);

		chckbxColActiva = new JCheckBox("");
		chckbxColActiva.setBounds(523, 587, 93, 21);
		mainPanel.add(chckbxColActiva);

		plataformasPanel = new JPanel();
		plataformasPanel.setLocation(10, 174);
		plataformasPanel.setLayout(new GridBagLayout());
		
		mainPanel.add(plataformasPanel);

		JScrollPane scrollPlataformas = new JScrollPane(plataformasPanel);

		scrollPlataformas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPlataformas.setBounds(52, 332, 1124, 132);
		mainPanel.add(scrollPlataformas);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
