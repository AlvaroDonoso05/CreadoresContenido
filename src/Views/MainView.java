package Views;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JCalendar;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import Controllers.Controller;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

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
	public JMenuItem reporteCreadoresItem;
	public JMenuItem reporteColaboracionesItem;
	public JMenuItem savetem;

	public JMenu helpMenu;
	public JMenuItem exportarColCSV;
	public JMenu fileMenu;
	public JLabel lblNewLabel_1;
	private JPanel panel_Datos;
	public JPanel panelEncabezado;
	public JPanel panelVistasGrafica;
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
	public JPanel panelLikesGrafica;
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
	public JButton btnExtraerDatos;
	public JTextField textPromLikes;
	public JTextField textPromVistas;
	public JTextField lblInfoHaste;
	private JLabel lblPromedio;
	private JPanel panel_Publicaciones;
	public JTextField textIdComentario;
	public JTextField textNombreComentario;
	public JTextField textEmailComentario;
	public JTextField textIdPublicacion;
	public JTextField textVistas;
	public JTextField textLikes;
	public JTextField textComentarios;
	public JTextField textCompartidos;
	public JList<String> listPublicaciones;
	public JLabel lblMinComentarios;
	public JTextArea textAreaComentario;
	public JLabel lblMaxComentarios;
	public JButton btnSiguiente;
	public JButton btnAnterior;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JPanel panel_NewCol;
	public JLabel lblAnadirColaboracion;
	public JLabel lblTemColNew;
	public JLabel lblTipoColNew;
	public JLabel lblFechaInicioColNew;
	public JTextField textFieldFechIniColNew;
	public JLabel lblFechaFinColNew;
	public JTextField textFieldFechFinColNew;
	public JLabel lblEstadoColNew;
	public JCheckBox chckbxColActivaColNew;
	public JLabel lblColaborador;
	public JButton btnNewButtonAddCol;
	public JButton btnFechaIni;
	public JButton btnConfFchIni;
	public JButton btnFechaFin;
	public JComboBox<String> comboBoxColNew;
	public JComboBox<String> comboBoxColTipo;
	public JComboBox<String> comboBoxColTem;
	public JButton btnConfFchFin;
	public JCalendar calendar;
	public JTextArea textAreaNewCol;
	public JTextArea textAreaLogger;
	public JButton btnExportarConsola;
	public JTextField textFiltro;
	public JComboBox<String> comboBox_Filtros;
	public JMenuItem helpItem;
	public JTextField textTasaCrecimientoRang;
	private JLabel lblTasaCrecimientoenerofebrero;

	public JMenuItem generarResRendJSON;
	public JMenuItem generarRepColCSV;
	public JPanel panel_Contenidos;
	public JPanel plataformasPanelCont;
	public JPanel panelBotonesPlataformaCont;
	public JTextField textVideoLikes;
	public JTextField textImagenLikes;
	public JTextField textStreamLikes;
	public JTextField textVideoVistas;
	public JTextField textImagenVistas;
	public JTextField textStreamVistas;
	public JPanel panelVistasGraficaCont;
	public JPanel panelLikesGraficaCont;
	public JButton btnAgregar;
	public JComboBox<String> comboBoxContenido;

	public MainView() {
		setBackground(new Color(255, 204, 204));
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

		fileMenu = new JMenu("Archivo");
		helpMenu = new JMenu("Informacion");

		// Add JMenus to the JMenuBar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		helpItem = new JMenuItem("Acerca de");
		helpMenu.add(helpItem);

		// Create JMenuItems
		reporteCreadoresItem = new JMenuItem("Generar Reporte Creadores");
		reporteColaboracionesItem = new JMenuItem("Generar Reporte Colaboraciones JSON");
		exportarColCSV = new JMenuItem("Exportar Colaboraciones CSV");
		generarResRendJSON = new JMenuItem("Generar Resumen Rendimiento JSON");
		generarRepColCSV = new JMenuItem("Generar Reporte Colaboraciones CSV");

		exitItem = new JMenuItem("Salir");

		fileMenu.add(reporteCreadoresItem);
		fileMenu.add(reporteColaboracionesItem);
		fileMenu.add(exportarColCSV);
		fileMenu.add(generarResRendJSON);
		fileMenu.add(generarRepColCSV);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 240, 240));
		contentPane.setLayer(tabbedPane, 0);
		tabbedPane.setBounds(0, 138, 1186, 510);
		tabbedPane.setVisible(false);
		contentPane.add(tabbedPane);

		panel_Datos = new JPanel();
		tabbedPane.addTab("Datos", null, panel_Datos, null);
		panel_Datos.setBackground(new Color(255, 204, 204));
		panel_Datos.setForeground(new Color(255, 255, 255));
		panel_Datos.setLayout(null);

		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(65, 94, 108, 24);
		panel_Datos.add(lblId);

		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldId.setBounds(195, 100, 163, 21);
		panel_Datos.add(textFieldId);
		textFieldId.setColumns(10);
		textFieldId.setEditable(false);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(65, 130, 108, 24);
		panel_Datos.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(195, 136, 163, 21);
		panel_Datos.add(textFieldNombre);
		textFieldNombre.setEditable(false);

		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPais.setBounds(65, 166, 108, 24);
		panel_Datos.add(lblPais);

		textFieldPais = new JTextField();
		textFieldPais.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(195, 172, 163, 21);
		panel_Datos.add(textFieldPais);
		textFieldPais.setEditable(false);

		lblTematica = new JLabel("Temática:");
		lblTematica.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTematica.setBounds(65, 200, 108, 24);
		panel_Datos.add(lblTematica);

		textFieldTematica = new JTextField();
		textFieldTematica.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldTematica.setColumns(10);
		textFieldTematica.setBounds(195, 206, 163, 21);
		textFieldTematica.setEditable(false);
		panel_Datos.add(textFieldTematica);

		lblSeguidores = new JLabel("Seguidores:");
		lblSeguidores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeguidores.setBounds(65, 234, 108, 24);
		panel_Datos.add(lblSeguidores);

		textFieldSeguidores = new JTextField();
		textFieldSeguidores.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldSeguidores.setColumns(10);
		textFieldSeguidores.setBounds(195, 240, 163, 21);
		textFieldSeguidores.setEditable(false);
		panel_Datos.add(textFieldSeguidores);

		lblInteracciones = new JLabel("Interacciones:");
		lblInteracciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInteracciones.setBounds(384, 94, 140, 24);
		panel_Datos.add(lblInteracciones);

		textFieldInteracciones = new JTextField();
		textFieldInteracciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldInteracciones.setEditable(false);
		textFieldInteracciones.setColumns(10);
		textFieldInteracciones.setBounds(546, 100, 163, 21);
		panel_Datos.add(textFieldInteracciones);

		lblPromedioVistas = new JLabel("Promedio Vistas:");
		lblPromedioVistas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPromedioVistas.setBounds(384, 130, 140, 24);
		panel_Datos.add(lblPromedioVistas);

		textFieldPromVist = new JTextField();
		textFieldPromVist.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldPromVist.setEditable(false);
		textFieldPromVist.setColumns(10);
		textFieldPromVist.setBounds(546, 136, 163, 21);
		panel_Datos.add(textFieldPromVist);

		lblTasaCrecimiento = new JLabel("Tasa Crecimiento:");
		lblTasaCrecimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTasaCrecimiento.setBounds(384, 166, 140, 24);
		panel_Datos.add(lblTasaCrecimiento);

		textFieldTasaCrec = new JTextField();
		textFieldTasaCrec.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldTasaCrec.setEditable(false);
		textFieldTasaCrec.setColumns(10);
		textFieldTasaCrec.setBounds(546, 172, 163, 21);
		panel_Datos.add(textFieldTasaCrec);

		lblDatos = new JLabel("Datos:");
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatos.setBounds(25, 33, 144, 46);
		panel_Datos.add(lblDatos);

		ImageIcon icono = new ImageIcon("resources/img/avatar.png");
		JLabel lblNewLabel = new JLabel(icono);
		lblNewLabel.setBounds(846, 23, 263, 248);
		panel_Datos.add(lblNewLabel);

		btnExtraerDatos = new JButton("Exportar Datos");
		btnExtraerDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExtraerDatos.setBounds(846, 282, 263, 37);
		btnExtraerDatos.setEnabled(false);
		panel_Datos.add(btnExtraerDatos);

		lblInfoHaste = new JTextField("");
		lblInfoHaste.setEditable(false);
		lblInfoHaste.setVisible(false);
		lblInfoHaste.setForeground(new Color(0, 128, 0));
		lblInfoHaste.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInfoHaste.setBounds(781, 434, 390, 37);
		panel_Datos.add(lblInfoHaste);

		panel_Contenidos = new JPanel();
		tabbedPane.addTab("Contenidos", null, panel_Contenidos, null);

		plataformasPanelCont = new JPanel();
		plataformasPanelCont.setSize(1171, 130);
		plataformasPanelCont.setLocation(1, 1);
		plataformasPanelCont.setLayout(new GridBagLayout());
		panel_Contenidos.add(plataformasPanelCont);

		panelBotonesPlataformaCont = new JPanel();
		panelBotonesPlataformaCont.setBounds(131, 23, 928, 74);;
		panel_Contenidos.add(panelBotonesPlataformaCont);
		panel_Contenidos.setLayout(null);

		JScrollPane scrollPlataformasCont = new JScrollPane(plataformasPanelCont);
		scrollPlataformasCont.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPlataformasCont.setBounds(52, 332, 1124, 132);
		panelBotonesPlataformaCont.add(scrollPlataformasCont);

		JLabel lblVideo = new JLabel("Video");
		lblVideo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideo.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblVideo.setBounds(83, 139, 90, 24);
		panel_Contenidos.add(lblVideo);

		textVideoLikes = new JTextField();
		textVideoLikes.setHorizontalAlignment(SwingConstants.CENTER);
		textVideoLikes.setFont(new Font("Tahoma", Font.BOLD, 21));
		textVideoLikes.setEditable(false);
		textVideoLikes.setColumns(10);
		textVideoLikes.setBounds(83, 174, 90, 32);
		panel_Contenidos.add(textVideoLikes);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblImagen.setBounds(203, 139, 90, 24);
		panel_Contenidos.add(lblImagen);

		textImagenLikes = new JTextField();
		textImagenLikes.setHorizontalAlignment(SwingConstants.CENTER);
		textImagenLikes.setFont(new Font("Tahoma", Font.BOLD, 21));
		textImagenLikes.setEditable(false);
		textImagenLikes.setColumns(10);
		textImagenLikes.setBounds(203, 174, 90, 32);
		panel_Contenidos.add(textImagenLikes);

		JLabel lblStream = new JLabel("Stream");
		lblStream.setHorizontalAlignment(SwingConstants.CENTER);
		lblStream.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblStream.setBounds(319, 139, 90, 24);
		panel_Contenidos.add(lblStream);

		textStreamLikes = new JTextField();
		textStreamLikes.setHorizontalAlignment(SwingConstants.CENTER);
		textStreamLikes.setFont(new Font("Tahoma", Font.BOLD, 21));
		textStreamLikes.setEditable(false);
		textStreamLikes.setColumns(10);
		textStreamLikes.setBounds(319, 174, 90, 32);
		panel_Contenidos.add(textStreamLikes);

		textVideoVistas = new JTextField();
		textVideoVistas.setHorizontalAlignment(SwingConstants.CENTER);
		textVideoVistas.setFont(new Font("Tahoma", Font.BOLD, 21));
		textVideoVistas.setEditable(false);
		textVideoVistas.setColumns(10);
		textVideoVistas.setBounds(83, 223, 90, 32);
		panel_Contenidos.add(textVideoVistas);

		textImagenVistas = new JTextField();
		textImagenVistas.setHorizontalAlignment(SwingConstants.CENTER);
		textImagenVistas.setFont(new Font("Tahoma", Font.BOLD, 21));
		textImagenVistas.setEditable(false);
		textImagenVistas.setColumns(10);
		textImagenVistas.setBounds(203, 223, 90, 32);
		panel_Contenidos.add(textImagenVistas);

		textStreamVistas = new JTextField();
		textStreamVistas.setHorizontalAlignment(SwingConstants.CENTER);
		textStreamVistas.setFont(new Font("Tahoma", Font.BOLD, 21));
		textStreamVistas.setEditable(false);
		textStreamVistas.setColumns(10);
		textStreamVistas.setBounds(319, 223, 90, 32);
		panel_Contenidos.add(textStreamVistas);

		JLabel lblLikes = new JLabel("Likes");
		lblLikes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLikes.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblLikes.setBounds(0, 178, 72, 24);
		panel_Contenidos.add(lblLikes);

		JLabel lblVistas = new JLabel("Vistas");
		lblVistas.setHorizontalAlignment(SwingConstants.LEFT);
		lblVistas.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblVistas.setBounds(8, 227, 64, 24);
		panel_Contenidos.add(lblVistas);

		panelLikesGraficaCont = new JPanel();
		panelLikesGraficaCont.setBounds(811, 139, 360, 298);
		panel_Contenidos.add(panelLikesGraficaCont);

		panelVistasGraficaCont = new JPanel();
		panelVistasGraficaCont.setBounds(441, 139, 360, 298);
		panel_Contenidos.add(panelVistasGraficaCont);

		panel_Plataformas = new JPanel();
		panel_Plataformas.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Plataformas", null, panel_Plataformas, null);
		panel_Plataformas.setLayout(null);

		lblPlataformas = new JLabel("Plataformas:");
		lblPlataformas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlataformas.setBounds(26, 21, 144, 46);
		panel_Plataformas.add(lblPlataformas);


		plataformasPanel = new JPanel();
		plataformasPanel.setSize(1171, 130);
		plataformasPanel.setLocation(0, 0);
		plataformasPanel.setLayout(new GridBagLayout());
		panel_Plataformas.add(plataformasPanel);

		panelBotonesPlataforma = new JPanel();
		panelBotonesPlataforma.setBackground(new Color(255, 204, 204));
		panelBotonesPlataforma.setBounds(156, 11, 928, 74);
		panel_Plataformas.add(panelBotonesPlataforma);

		JScrollPane scrollPlataformas = new JScrollPane(plataformasPanel);
		scrollPlataformas.setOpaque(rootPaneCheckingEnabled);
		scrollPlataformas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPlataformas.setBounds(52, 332, 1124, 132);
		panelBotonesPlataforma.add(scrollPlataformas);

		lblPlataformaSel = new JLabel("Información Plataforma");
		lblPlataformaSel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlataformaSel.setBounds(26, 124, 245, 46);
		panel_Plataformas.add(lblPlataformaSel);


		panelVistasGrafica = new JPanel();
		panelVistasGrafica.setBounds(811, 89, 360, 298);
		panel_Plataformas.add(panelVistasGrafica);

		panelLikesGrafica = new JPanel();
		panelLikesGrafica.setBounds(441, 89, 360, 298);
		panel_Plataformas.add(panelLikesGrafica);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(26, 163, 108, 24);
		panel_Plataformas.add(lblUsuario);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldUsuario.setEditable(false);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(156, 169, 163, 21);
		panel_Plataformas.add(textFieldUsuario);

		lblSeguidoresPlat = new JLabel("Seguidores:");
		lblSeguidoresPlat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeguidoresPlat.setBounds(26, 199, 108, 24);
		panel_Plataformas.add(lblSeguidoresPlat);

		textFieldSegPlat = new JTextField();
		textFieldSegPlat.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldSegPlat.setEditable(false);
		textFieldSegPlat.setColumns(10);
		textFieldSegPlat.setBounds(156, 205, 163, 21);
		panel_Plataformas.add(textFieldSegPlat);

		lblFechCrPl = new JLabel("Fecha Creación:");
		lblFechCrPl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechCrPl.setBounds(26, 235, 108, 24);
		panel_Plataformas.add(lblFechCrPl);

		textFieldFechCr = new JTextField();
		textFieldFechCr.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldFechCr.setEditable(false);
		textFieldFechCr.setColumns(10);
		textFieldFechCr.setBounds(156, 241, 163, 21);
		panel_Plataformas.add(textFieldFechCr);

		lblHistrico = new JLabel("Histórico:");
		lblHistrico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHistrico.setBounds(26, 269, 108, 24);
		panel_Plataformas.add(lblHistrico);

		comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_2.setBounds(154, 272, 165, 24);
		panel_Plataformas.add(comboBox_2);

		lblFechHist = new JLabel("Fecha");
		lblFechHist.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechHist.setBounds(60, 311, 138, 24);
		panel_Plataformas.add(lblFechHist);

		textFieldFechHist = new JTextField();
		textFieldFechHist.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldFechHist.setEditable(false);
		textFieldFechHist.setColumns(10);
		textFieldFechHist.setBounds(208, 314, 163, 21);
		panel_Plataformas.add(textFieldFechHist);

		lblNuevosSeg = new JLabel("Nuevos Seguidores:");
		lblNuevosSeg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNuevosSeg.setBounds(60, 346, 138, 24);
		panel_Plataformas.add(lblNuevosSeg);

		textFieldNuevosSeg = new JTextField();
		textFieldNuevosSeg.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldNuevosSeg.setEditable(false);
		textFieldNuevosSeg.setColumns(10);
		textFieldNuevosSeg.setBounds(208, 350, 163, 21);
		panel_Plataformas.add(textFieldNuevosSeg);

		lblIntHist = new JLabel("Interacciones:");
		lblIntHist.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIntHist.setBounds(60, 381, 138, 24);
		panel_Plataformas.add(lblIntHist);

		textFieldIntHist = new JTextField();
		textFieldIntHist.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldIntHist.setEditable(false);
		textFieldIntHist.setColumns(10);
		textFieldIntHist.setBounds(208, 384, 163, 21);
		panel_Plataformas.add(textFieldIntHist);

		textPromLikes = new JTextField();
		textPromLikes.setHorizontalAlignment(SwingConstants.CENTER);
		textPromLikes.setFont(new Font("Tahoma", Font.BOLD, 18));
		textPromLikes.setEditable(false);
		textPromLikes.setBounds(467, 425, 306, 46);
		panel_Plataformas.add(textPromLikes);
		textPromLikes.setColumns(10);

		textPromVistas = new JTextField();
		textPromVistas.setHorizontalAlignment(SwingConstants.CENTER);
		textPromVistas.setFont(new Font("Tahoma", Font.BOLD, 18));
		textPromVistas.setColumns(10);
		textPromVistas.setBounds(845, 425, 306, 46);
		panel_Plataformas.add(textPromVistas);

		lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPromedio.setBounds(441, 398, 183, 21);
		panel_Plataformas.add(lblPromedio);

		textTasaCrecimientoRang = new JTextField();
		textTasaCrecimientoRang.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTasaCrecimientoRang.setEditable(false);
		textTasaCrecimientoRang.setColumns(10);
		textTasaCrecimientoRang.setBounds(26, 434, 293, 24);
		panel_Plataformas.add(textTasaCrecimientoRang);

		lblTasaCrecimientoenerofebrero = new JLabel("Tasa Crecimiento (Enero-Febrero):");
		lblTasaCrecimientoenerofebrero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTasaCrecimientoenerofebrero.setBounds(26, 408, 227, 24);
		panel_Plataformas.add(lblTasaCrecimientoenerofebrero);


		panel_Colabs = new JPanel();
		panel_Colabs.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Colaboraciones", null, panel_Colabs, null);
		panel_Colabs.setLayout(null);

		lblColaboraciones = new JLabel("Colaboraciones:");
		lblColaboraciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblColaboraciones.setBounds(25, 33, 144, 46);
		panel_Colabs.add(lblColaboraciones);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_1.setBounds(154, 45, 182, 40);
		panel_Colabs.add(comboBox_1);

		lblTemCol = new JLabel("Temática:");
		lblTemCol.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTemCol.setBounds(377, 45, 108, 24);
		panel_Colabs.add(lblTemCol);

		textFieldTemCol = new JTextField();
		textFieldTemCol.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldTemCol.setEditable(false);
		textFieldTemCol.setColumns(10);
		textFieldTemCol.setBounds(491, 47, 163, 21);
		panel_Colabs.add(textFieldTemCol);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(674, 45, 108, 24);
		panel_Colabs.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldTipo.setEditable(false);
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(788, 47, 163, 21);
		panel_Colabs.add(textFieldTipo);

		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaInicio.setBounds(377, 90, 108, 24);
		panel_Colabs.add(lblFechaInicio);

		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldFechaInicio.setEditable(false);
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(491, 92, 163, 21);
		panel_Colabs.add(textFieldFechaInicio);

		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaFin.setBounds(674, 90, 108, 24);
		panel_Colabs.add(lblFechaFin);

		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldFechaFin.setEditable(false);
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setBounds(788, 92, 163, 21);
		panel_Colabs.add(textFieldFechaFin);

		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(377, 131, 108, 24);
		panel_Colabs.add(lblEstado);

		chckbxColActiva = new JCheckBox("");
		chckbxColActiva.setBackground(new Color(255, 204, 204));
		chckbxColActiva.setBounds(491, 134, 93, 21);
		chckbxColActiva.setEnabled(false);

		panel_Colabs.add(chckbxColActiva);

		panel_Publicaciones = new JPanel();
		panel_Publicaciones.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Publicaciones", null, panel_Publicaciones, null);
		panel_Publicaciones.setLayout(null);

		listPublicaciones = new JList<String>();
		listPublicaciones.setBounds(10, 30, 355, 405);
		panel_Publicaciones.add(listPublicaciones);

		JPanel panel_Comentarios = new JPanel();
		panel_Comentarios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Comentarios.setBounds(820, 137, 351, 310);
		panel_Publicaciones.add(panel_Comentarios);
		panel_Comentarios.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ID Comentario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 11, 125, 25);
		panel_Comentarios.add(lblNewLabel_2);

		JLabel lblNombreComentario = new JLabel("Nombre:");
		lblNombreComentario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreComentario.setBounds(10, 47, 72, 25);
		panel_Comentarios.add(lblNombreComentario);

		JLabel lblEmailComentario = new JLabel("Email:");
		lblEmailComentario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailComentario.setBounds(10, 72, 72, 25);
		panel_Comentarios.add(lblEmailComentario);

		JLabel lblContenidoComentario = new JLabel("Contenido:");
		lblContenidoComentario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContenidoComentario.setBounds(10, 108, 125, 25);
		panel_Comentarios.add(lblContenidoComentario);

		textAreaComentario = new JTextArea();
		textAreaComentario.setEditable(false);
		textAreaComentario.setBounds(10, 137, 331, 162);
		panel_Comentarios.add(textAreaComentario);

		textIdComentario = new JTextField();
		textIdComentario.setEditable(false);
		textIdComentario.setBounds(145, 15, 86, 20);
		panel_Comentarios.add(textIdComentario);
		textIdComentario.setColumns(10);

		textNombreComentario = new JTextField();
		textNombreComentario.setEditable(false);
		textNombreComentario.setBounds(92, 51, 249, 20);
		panel_Comentarios.add(textNombreComentario);
		textNombreComentario.setColumns(10);

		textEmailComentario = new JTextField();
		textEmailComentario.setEditable(false);
		textEmailComentario.setColumns(10);
		textEmailComentario.setBounds(92, 76, 249, 20);
		panel_Comentarios.add(textEmailComentario);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(820, 79, 160, 47);
		panel_Publicaciones.add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(1016, 79, 155, 47);
		panel_Publicaciones.add(btnSiguiente);

		lblMinComentarios = new JLabel("0");
		lblMinComentarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinComentarios.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblMinComentarios.setBounds(882, 45, 107, 23);
		panel_Publicaciones.add(lblMinComentarios);

		lblMaxComentarios = new JLabel("0");
		lblMaxComentarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxComentarios.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblMaxComentarios.setBounds(1006, 45, 118, 23);
		panel_Publicaciones.add(lblMaxComentarios);

		JLabel lblSlashCommentarios = new JLabel("/");
		lblSlashCommentarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlashCommentarios.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSlashCommentarios.setBounds(985, 45, 22, 23);
		panel_Publicaciones.add(lblSlashCommentarios);

		JLabel lblIdContenido = new JLabel("ID Publicacion:");
		lblIdContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdContenido.setBounds(390, 45, 125, 25);
		panel_Publicaciones.add(lblIdContenido);

		JLabel lblVistasContenido = new JLabel("Vistas:");
		lblVistasContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVistasContenido.setBounds(390, 85, 125, 25);
		panel_Publicaciones.add(lblVistasContenido);

		JLabel lblLikesContenido = new JLabel("Likes:");
		lblLikesContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLikesContenido.setBounds(390, 121, 125, 25);
		panel_Publicaciones.add(lblLikesContenido);

		JLabel lblComentariosContenido = new JLabel("Comentarios:");
		lblComentariosContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComentariosContenido.setBounds(390, 157, 125, 25);
		panel_Publicaciones.add(lblComentariosContenido);

		JLabel lblCompartidoContenido = new JLabel("Compartidos:");
		lblCompartidoContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCompartidoContenido.setBounds(390, 193, 125, 25);
		panel_Publicaciones.add(lblCompartidoContenido);

		textIdPublicacion = new JTextField();
		textIdPublicacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		textIdPublicacion.setEditable(false);
		textIdPublicacion.setBounds(521, 45, 125, 23);
		panel_Publicaciones.add(textIdPublicacion);
		textIdPublicacion.setColumns(10);

		textVistas = new JTextField();
		textVistas.setFont(new Font("Tahoma", Font.BOLD, 13));
		textVistas.setColumns(10);
		textVistas.setBounds(521, 81, 125, 23);
		panel_Publicaciones.add(textVistas);

		textLikes = new JTextField();
		textLikes.setFont(new Font("Tahoma", Font.BOLD, 13));
		textLikes.setColumns(10);
		textLikes.setBounds(521, 121, 125, 23);
		panel_Publicaciones.add(textLikes);

		textComentarios = new JTextField();
		textComentarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		textComentarios.setColumns(10);
		textComentarios.setBounds(521, 157, 125, 23);
		panel_Publicaciones.add(textComentarios);

		textCompartidos = new JTextField();
		textCompartidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		textCompartidos.setColumns(10);
		textCompartidos.setBounds(521, 193, 125, 23);
		panel_Publicaciones.add(textCompartidos);

		panelEncabezado = new JPanel();
		panelEncabezado.setBackground(new Color(255, 204, 204));
		panelEncabezado.setBounds(0, 0, 1186, 138);
		contentPane.add(panelEncabezado);
		panelEncabezado.setLayout(null);

		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(107, 71, 201, 40);
		panelEncabezado.add(comboBox);

		lblNewLabel_1 = new JLabel("Seleccione al Creador:");
		lblNewLabel_1.setBounds(107, 21, 201, 39);
		panelEncabezado.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		textAreaLogger = new JTextArea();
		textAreaLogger.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textAreaLogger);
		scrollPane.setBounds(535, 21, 593, 106);
		panelEncabezado.add(scrollPane);

		btnExportarConsola = new JButton("Exportar Consola");
		btnExportarConsola.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExportarConsola.setEnabled(false);
		btnExportarConsola.setBounds(395, 87, 128, 40);
		panelEncabezado.add(btnExportarConsola);

		panel_NewCol = new JPanel();
		panel_NewCol.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Nueva Colaboración", null, panel_NewCol, null);
		panel_NewCol.setLayout(null);

		lblAnadirColaboracion = new JLabel("Añadir Colaboración con el Creador Seleccionado:");
		lblAnadirColaboracion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnadirColaboracion.setBounds(25, 33, 460, 46);
		panel_NewCol.add(lblAnadirColaboracion);

		lblTemColNew = new JLabel("Temática:");
		lblTemColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTemColNew.setBounds(68, 241, 108, 24);
		panel_NewCol.add(lblTemColNew);

		lblTipoColNew = new JLabel("Tipo:");
		lblTipoColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoColNew.setBounds(68, 136, 108, 24);
		panel_NewCol.add(lblTipoColNew);

		lblFechaInicioColNew = new JLabel("Fecha Inicio:");
		lblFechaInicioColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaInicioColNew.setBounds(68, 173, 108, 24);
		panel_NewCol.add(lblFechaInicioColNew);

		textFieldFechIniColNew = new JTextField();
		textFieldFechIniColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldFechIniColNew.setEditable(false);
		textFieldFechIniColNew.setColumns(10);
		textFieldFechIniColNew.setBounds(182, 175, 193, 21);
		panel_NewCol.add(textFieldFechIniColNew);

		lblFechaFinColNew = new JLabel("Fecha Fin:");
		lblFechaFinColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaFinColNew.setBounds(68, 207, 108, 24);
		panel_NewCol.add(lblFechaFinColNew);

		textFieldFechFinColNew = new JTextField();
		textFieldFechFinColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldFechFinColNew.setEditable(false);
		textFieldFechFinColNew.setColumns(10);
		textFieldFechFinColNew.setBounds(182, 208, 193, 21);
		panel_NewCol.add(textFieldFechFinColNew);

		lblEstadoColNew = new JLabel("Activa:");
		lblEstadoColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoColNew.setBounds(68, 279, 108, 24);
		panel_NewCol.add(lblEstadoColNew);

		chckbxColActivaColNew = new JCheckBox("");
		chckbxColActivaColNew.setBackground(new Color(255, 204, 204));
		chckbxColActivaColNew.setBounds(182, 282, 93, 21);
		panel_NewCol.add(chckbxColActivaColNew);

		lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColaborador.setBounds(68, 102, 108, 24);
		panel_NewCol.add(lblColaborador);

		btnNewButtonAddCol = new JButton("Añadir");
		btnNewButtonAddCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButtonAddCol.setBounds(222, 368, 123, 34);
		panel_NewCol.add(btnNewButtonAddCol);

		calendar = new JCalendar();
		calendar.setSize(199, 234);
		calendar.setLocation(500, 102);
		calendar.setVisible(false);
		panel_NewCol.add(calendar);


		ImageIcon calendarIcon = new ImageIcon("resources/img/calendar.png");
		btnFechaIni = new JButton(calendarIcon);
		btnFechaIni.setBounds(380, 176, 20, 20);
		btnFechaIni.setIcon(new ImageIcon(calendarIcon.getImage().getScaledInstance(btnFechaIni.getWidth(), btnFechaIni.getHeight(), Image.SCALE_SMOOTH)));
		panel_NewCol.add(btnFechaIni);


		btnConfFchIni = new JButton("Confirmar");
		btnConfFchIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfFchIni.setBounds(560, 345, 90, 45);
		btnConfFchIni.setVisible(false);
		panel_NewCol.add(btnConfFchIni);

		btnFechaFin = new JButton(calendarIcon);
		btnFechaFin.setBounds(380, 208, 20, 20);
		btnFechaFin.setIcon(new ImageIcon(calendarIcon.getImage().getScaledInstance(btnFechaFin.getWidth(), btnFechaFin.getHeight(), Image.SCALE_SMOOTH)));
		panel_NewCol.add(btnFechaFin);

		comboBoxColNew = new JComboBox<>();
		comboBoxColNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxColNew.setBounds(182, 105, 193, 23);
		panel_NewCol.add(comboBoxColNew);

		comboBoxColTipo = new JComboBox<>();
		comboBoxColTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxColTipo.setBounds(182, 139, 193, 23);
		panel_NewCol.add(comboBoxColTipo);

		comboBoxColTem = new JComboBox<>();
		comboBoxColTem.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxColTem.setBounds(182, 244, 193, 23);
		panel_NewCol.add(comboBoxColTem);

		btnConfFchFin = new JButton("Confirmar");
		btnConfFchFin.setBounds(560, 345, 90, 45);
		btnConfFchFin.setVisible(false);
		panel_NewCol.add(btnConfFchFin);

		textAreaNewCol = new JTextArea();
		textAreaNewCol.setFont(new Font("Tahoma", Font.BOLD, 16));
		textAreaNewCol.setBackground(new Color(255, 204, 204));
		textAreaNewCol.setBounds(68, 413, 448, 60);
		panel_NewCol.add(textAreaNewCol);

		// sefs
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(390, 366, 125, 47);
		panel_Publicaciones.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(521, 366, 125, 47);
		panel_Publicaciones.add(btnEliminar);

		textFiltro = new JTextField();
		textFiltro.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFiltro.setColumns(10);
		textFiltro.setBounds(560, 318, 125, 23);
		panel_Publicaciones.add(textFiltro);

		JLabel lblFiltroopcional = new JLabel("Filtro (Opcional):");
		lblFiltroopcional.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFiltroopcional.setBounds(390, 282, 160, 25);
		panel_Publicaciones.add(lblFiltroopcional);

		comboBox_Filtros = new JComboBox<String>();
		comboBox_Filtros.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_Filtros.setBounds(390, 318, 125, 23);
		panel_Publicaciones.add(comboBox_Filtros);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(656, 366, 142, 47);
		panel_Publicaciones.add(btnAgregar);

		JLabel lblPlataformaContenido = new JLabel("Plataforma:");
		lblPlataformaContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlataformaContenido.setBounds(390, 234, 125, 25);
		panel_Publicaciones.add(lblPlataformaContenido);

		comboBoxContenido = new JComboBox<String>();
		comboBoxContenido.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxContenido.setBounds(521, 234, 125, 23);
		panel_Publicaciones.add(comboBoxContenido);

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
					frame.setTitle("Gestion de Creadores");
					frame.setIconImage(new ImageIcon("resources/img/logo.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
