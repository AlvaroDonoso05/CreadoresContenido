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
import javax.swing.JTabbedPane;

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
	public JButton btnNewButton_1;
	public JLabel lblNewLabel_1;
	private JPanel mainPanel;
	private JButton btnNewButton;
	public JPanel panel;
	public JTabbedPane tabbedPane;
	public JPanel panel_Plataformas;
	public JLabel lblPlataformas;
	public JPanel panel_Colabs;
	public JLabel lblColaboraciones;
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
	public JLabel lblDatos;
	public JPanel plataformasPanel;
	public JPanel panelBotonesPlataforma;
	public JLabel lblPlataformaSel;
	public JLabel lblUsuario;
	public JTextField textFieldUsuario;
	public JLabel lblSeguidoresPlat;
	public JTextField textFieldSegPlat;
	public JLabel lblFechCrPl;
	public JTextField textFieldFechCr;
	public JLabel lblHistrico;
	public JComboBox<String> comboBox_2;
	public JLabel lblFechHist;
	public JTextField textFieldFechHist;
	public JLabel lblNuevosSeg;
	public JTextField textFieldNuevosSeg;
	public JLabel lblIntHist;
	public JTextField textFieldIntHist;

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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 240, 240));
		contentPane.setLayer(tabbedPane, 0);
		tabbedPane.setBounds(0, 138, 1186, 510);
		contentPane.add(tabbedPane);

		mainPanel = new JPanel();
		tabbedPane.addTab("Datos", null, mainPanel, null);
		mainPanel.setBackground(new Color(255, 204, 204));
		mainPanel.setForeground(new Color(255, 255, 255));
		mainPanel.setLayout(null);

		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(65, 94, 108, 24);
		mainPanel.add(lblId);

		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldId.setBounds(195, 100, 163, 21);
		mainPanel.add(textFieldId);
		textFieldId.setColumns(10);
		textFieldId.setEditable(false);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(65, 130, 108, 24);
		mainPanel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(195, 136, 163, 21);
		mainPanel.add(textFieldNombre);
		textFieldNombre.setEditable(false);

		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(65, 166, 108, 24);
		mainPanel.add(lblPais);

		textFieldPais = new JTextField();
		textFieldPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(195, 172, 163, 21);
		mainPanel.add(textFieldPais);
		textFieldPais.setEditable(false);

		lblTematica = new JLabel("Temática:");
		lblTematica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTematica.setBounds(65, 200, 108, 24);
		mainPanel.add(lblTematica);

		textFieldTematica = new JTextField();
		textFieldTematica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTematica.setColumns(10);
		textFieldTematica.setBounds(195, 206, 163, 21);
		textFieldTematica.setEditable(false);
		mainPanel.add(textFieldTematica);

		lblSeguidores = new JLabel("Seguidores:");
		lblSeguidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeguidores.setBounds(65, 234, 108, 24);
		mainPanel.add(lblSeguidores);

		textFieldSeguidores = new JTextField();
		textFieldSeguidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldSeguidores.setColumns(10);
		textFieldSeguidores.setBounds(195, 240, 163, 21);
		textFieldSeguidores.setEditable(false);
		mainPanel.add(textFieldSeguidores);

		lblInteracciones = new JLabel("Interacciones:");
		lblInteracciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInteracciones.setBounds(392, 94, 108, 24);
		mainPanel.add(lblInteracciones);

		textFieldInteracciones = new JTextField();
		textFieldInteracciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldInteracciones.setEditable(false);
		textFieldInteracciones.setColumns(10);
		textFieldInteracciones.setBounds(522, 100, 163, 21);
		mainPanel.add(textFieldInteracciones);

		lblPromedioVistas = new JLabel("Promedio Vistas:");
		lblPromedioVistas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPromedioVistas.setBounds(392, 130, 108, 24);
		mainPanel.add(lblPromedioVistas);

		textFieldPromVist = new JTextField();
		textFieldPromVist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPromVist.setEditable(false);
		textFieldPromVist.setColumns(10);
		textFieldPromVist.setBounds(522, 136, 163, 21);
		mainPanel.add(textFieldPromVist);

		lblTasaCrecimiento = new JLabel("Tasa Crecimiento:");
		lblTasaCrecimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTasaCrecimiento.setBounds(392, 166, 108, 24);
		mainPanel.add(lblTasaCrecimiento);

		textFieldTasaCrec = new JTextField();
		textFieldTasaCrec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTasaCrec.setEditable(false);
		textFieldTasaCrec.setColumns(10);
		textFieldTasaCrec.setBounds(522, 172, 163, 21);
		mainPanel.add(textFieldTasaCrec);
		
		lblDatos = new JLabel("Datos:");
		lblDatos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatos.setBounds(25, 33, 144, 46);
		mainPanel.add(lblDatos);
		
		panel_Plataformas = new JPanel();
		panel_Plataformas.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Plataformas", null, panel_Plataformas, null);
		panel_Plataformas.setLayout(null);
		
		lblPlataformas = new JLabel("Plataformas:");
		lblPlataformas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlataformas.setBounds(25, 33, 144, 46);
		panel_Plataformas.add(lblPlataformas);
		
		
		plataformasPanel = new JPanel();
		plataformasPanel.setSize(1171, 130);
		plataformasPanel.setLocation(0, 0);
		plataformasPanel.setLayout(new GridBagLayout());
		plataformasPanel.setOpaque(rootPaneCheckingEnabled);
		panel_Plataformas.add(plataformasPanel);

		JScrollPane scrollPlataformas = new JScrollPane(plataformasPanel);
		scrollPlataformas.setOpaque(rootPaneCheckingEnabled);
	
		panelBotonesPlataforma = new JPanel();
		panelBotonesPlataforma.setBackground(new Color(255, 204, 204));
		panelBotonesPlataforma.setBounds(153, 22, 928, 113);
		panel_Plataformas.add(panelBotonesPlataforma);

		scrollPlataformas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPlataformas.setBounds(52, 332, 1124, 132);
		panelBotonesPlataforma.add(scrollPlataformas);
		
		lblPlataformaSel = new JLabel("PlatSelec");
		lblPlataformaSel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlataformaSel.setBounds(26, 124, 144, 46);
		panel_Plataformas.add(lblPlataformaSel);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(26, 180, 108, 24);
		panel_Plataformas.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldUsuario.setEditable(false);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(156, 186, 163, 21);
		panel_Plataformas.add(textFieldUsuario);
		
		lblSeguidoresPlat = new JLabel("Seguidores:");
		lblSeguidoresPlat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeguidoresPlat.setBounds(26, 216, 108, 24);
		panel_Plataformas.add(lblSeguidoresPlat);
		
		textFieldSegPlat = new JTextField();
		textFieldSegPlat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldSegPlat.setEditable(false);
		textFieldSegPlat.setColumns(10);
		textFieldSegPlat.setBounds(156, 222, 163, 21);
		panel_Plataformas.add(textFieldSegPlat);
		
		lblFechCrPl = new JLabel("Fecha Creación:");
		lblFechCrPl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechCrPl.setBounds(26, 252, 108, 24);
		panel_Plataformas.add(lblFechCrPl);
		
		textFieldFechCr = new JTextField();
		textFieldFechCr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechCr.setEditable(false);
		textFieldFechCr.setColumns(10);
		textFieldFechCr.setBounds(156, 258, 163, 21);
		panel_Plataformas.add(textFieldFechCr);
		
		lblHistrico = new JLabel("Histórico:");
		lblHistrico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHistrico.setBounds(26, 286, 108, 24);
		panel_Plataformas.add(lblHistrico);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(154, 289, 165, 24);
		panel_Plataformas.add(comboBox_2);
		
		lblFechHist = new JLabel("Fecha");
		lblFechHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechHist.setBounds(153, 325, 108, 24);
		panel_Plataformas.add(lblFechHist);
		
		textFieldFechHist = new JTextField();
		textFieldFechHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechHist.setEditable(false);
		textFieldFechHist.setColumns(10);
		textFieldFechHist.setBounds(283, 331, 163, 21);
		panel_Plataformas.add(textFieldFechHist);
		
		lblNuevosSeg = new JLabel("Nuevos Seguidores:");
		lblNuevosSeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNuevosSeg.setBounds(153, 361, 108, 24);
		panel_Plataformas.add(lblNuevosSeg);
		
		textFieldNuevosSeg = new JTextField();
		textFieldNuevosSeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNuevosSeg.setEditable(false);
		textFieldNuevosSeg.setColumns(10);
		textFieldNuevosSeg.setBounds(283, 367, 163, 21);
		panel_Plataformas.add(textFieldNuevosSeg);
		
		lblIntHist = new JLabel("Interacciones:");
		lblIntHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIntHist.setBounds(153, 397, 108, 24);
		panel_Plataformas.add(lblIntHist);
		
		textFieldIntHist = new JTextField();
		textFieldIntHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldIntHist.setEditable(false);
		textFieldIntHist.setColumns(10);
		textFieldIntHist.setBounds(283, 403, 163, 21);
		panel_Plataformas.add(textFieldIntHist);
		
		panel_Colabs = new JPanel();
		panel_Colabs.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Colaboraciones", null, panel_Colabs, null);
		panel_Colabs.setLayout(null);
		
		lblColaboraciones = new JLabel("Colaboraciones:");
		lblColaboraciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColaboraciones.setBounds(25, 33, 144, 46);
		panel_Colabs.add(lblColaboraciones);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(154, 45, 182, 40);
		panel_Colabs.add(comboBox_1);
		
		lblTemCol = new JLabel("Temática:");
		lblTemCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemCol.setBounds(377, 45, 108, 24);
		panel_Colabs.add(lblTemCol);
		
		textFieldTemCol = new JTextField();
		textFieldTemCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTemCol.setEditable(false);
		textFieldTemCol.setColumns(10);
		textFieldTemCol.setBounds(491, 47, 163, 21);
		panel_Colabs.add(textFieldTemCol);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBounds(674, 45, 108, 24);
		panel_Colabs.add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTipo.setEditable(false);
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(788, 47, 163, 21);
		panel_Colabs.add(textFieldTipo);
		
		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaInicio.setBounds(377, 90, 108, 24);
		panel_Colabs.add(lblFechaInicio);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechaInicio.setEditable(false);
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(491, 92, 163, 21);
		panel_Colabs.add(textFieldFechaInicio);
		
		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaFin.setBounds(674, 90, 108, 24);
		panel_Colabs.add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechaFin.setEditable(false);
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setBounds(788, 92, 163, 21);
		panel_Colabs.add(textFieldFechaFin);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(377, 131, 108, 24);
		panel_Colabs.add(lblEstado);
		
		chckbxColActiva = new JCheckBox("");
		chckbxColActiva.setBackground(new Color(255, 204, 204));
		chckbxColActiva.setBounds(491, 134, 93, 21);
		chckbxColActiva.setEnabled(false);
		
		panel_Colabs.add(chckbxColActiva);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(0, 0, 1186, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
				comboBox = new JComboBox<>();
				comboBox.setBounds(49, 71, 182, 40);
				panel.add(comboBox);
				
						lblNewLabel_1 = new JLabel("Seleccione al Creador:");
						lblNewLabel_1.setBounds(49, 21, 182, 39);
						panel.add(lblNewLabel_1);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
