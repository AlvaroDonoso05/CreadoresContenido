package Views;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;


import javax.swing.BorderFactory;
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
    public JPanel panel;
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
    private JPanel reportes;
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
    public JTextField textFiltro;
    public JComboBox<String> comboBox_Filtros;
    public JTextArea textAreaLogger;
    public JButton btnExportarConsola;

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

        ImageIcon icono = new ImageIcon("resources/img/avatar.png");
        JLabel lblNewLabel = new JLabel(icono);
        lblNewLabel.setBounds(846, 23, 263, 248);
        mainPanel.add(lblNewLabel);

        btnExtraerDatos = new JButton("Exportar Datos");
        btnExtraerDatos.setBounds(846, 282, 263, 37);
        btnExtraerDatos.setEnabled(false);
        mainPanel.add(btnExtraerDatos);

        lblInfoHaste = new JTextField("");
        lblInfoHaste.setEditable(false);
        lblInfoHaste.setVisible(false);
        lblInfoHaste.setForeground(new Color(0, 128, 0));
        lblInfoHaste.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblInfoHaste.setBounds(781, 434, 390, 37);
        mainPanel.add(lblInfoHaste);

        panel_Plataformas = new JPanel();
        panel_Plataformas.setBackground(new Color(255, 204, 204));
        tabbedPane.addTab("Plataformas", null, panel_Plataformas, null);
        panel_Plataformas.setLayout(null);

        lblPlataformas = new JLabel("Plataformas:");
        lblPlataformas.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPlataformas.setBounds(26, 21, 144, 46);
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

        panelBotonesPlataforma.setBounds(156, 11, 928, 74);
        panel_Plataformas.add(panelBotonesPlataforma);

        scrollPlataformas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPlataformas.setBounds(52, 332, 1124, 132);
        panelBotonesPlataforma.add(scrollPlataformas);

        lblPlataformaSel = new JLabel("Información Plataforma");
        lblPlataformaSel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPlataformaSel.setBounds(26, 124, 245, 46);
        panel_Plataformas.add(lblPlataformaSel);


        panelVistasGrafica = new JPanel();
        panelVistasGrafica.setBounds(811, 89, 360, 298);
        panel_Plataformas.add(panelVistasGrafica);

        panelLikesGrafica = new JPanel();
        panelLikesGrafica.setBounds(441, 89, 360, 298);
        panel_Plataformas.add(panelLikesGrafica);

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
        lblFechHist.setBounds(90, 329, 108, 24);
        panel_Plataformas.add(lblFechHist);

        textFieldFechHist = new JTextField();
        textFieldFechHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textFieldFechHist.setEditable(false);
        textFieldFechHist.setColumns(10);
        textFieldFechHist.setBounds(208, 331, 163, 21);
        panel_Plataformas.add(textFieldFechHist);

        lblNuevosSeg = new JLabel("Nuevos Seguidores:");
        lblNuevosSeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNuevosSeg.setBounds(90, 364, 108, 24);
        panel_Plataformas.add(lblNuevosSeg);

        textFieldNuevosSeg = new JTextField();
        textFieldNuevosSeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textFieldNuevosSeg.setEditable(false);
        textFieldNuevosSeg.setColumns(10);
        textFieldNuevosSeg.setBounds(208, 367, 163, 21);
        panel_Plataformas.add(textFieldNuevosSeg);

        lblIntHist = new JLabel("Interacciones:");
        lblIntHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblIntHist.setBounds(90, 399, 108, 24);
        panel_Plataformas.add(lblIntHist);

        textFieldIntHist = new JTextField();
        textFieldIntHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textFieldIntHist.setEditable(false);
        textFieldIntHist.setColumns(10);
        textFieldIntHist.setBounds(208, 401, 163, 21);
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
        
        reportes = new JPanel();
        tabbedPane.addTab("Reportes", null, reportes, null);

        panel = new JPanel();
        panel.setBackground(new Color(255, 204, 204));
        panel.setBounds(0, 0, 1186, 138);
        contentPane.add(panel);
        panel.setLayout(null);

        comboBox = new JComboBox<>();
        comboBox.setBounds(107, 71, 182, 40);
        panel.add(comboBox);

        lblNewLabel_1 = new JLabel("Seleccione al Creador:");
        lblNewLabel_1.setBounds(107, 21, 182, 39);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        textAreaLogger = new JTextArea();
        textAreaLogger.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(textAreaLogger);
        scrollPane.setBounds(535, 21, 593, 106);
        panel.add(scrollPane);
        
        btnExportarConsola = new JButton("Exportar Consola");
        btnExportarConsola.setEnabled(false);
        btnExportarConsola.setBounds(395, 87, 128, 40);
        panel.add(btnExportarConsola);
      
        panel_NewCol = new JPanel();
		panel_NewCol.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("Nueva Colaboración", null, panel_NewCol, null);
		panel_NewCol.setLayout(null);
		
		lblAnadirColaboracion = new JLabel("Añadir Colaboración con el Creador Seleccionado:");
		lblAnadirColaboracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnadirColaboracion.setBounds(25, 33, 379, 46);
		panel_NewCol.add(lblAnadirColaboracion);
		
		lblTemColNew = new JLabel("Temática:");
		lblTemColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemColNew.setBounds(68, 241, 108, 24);
		panel_NewCol.add(lblTemColNew);
		
		lblTipoColNew = new JLabel("Tipo:");
		lblTipoColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoColNew.setBounds(68, 136, 108, 24);
		panel_NewCol.add(lblTipoColNew);
		
		lblFechaInicioColNew = new JLabel("Fecha Inicio:");
		lblFechaInicioColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaInicioColNew.setBounds(68, 173, 108, 24);
		panel_NewCol.add(lblFechaInicioColNew);
		
		textFieldFechIniColNew = new JTextField();
		textFieldFechIniColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechIniColNew.setEditable(false);
		textFieldFechIniColNew.setColumns(10);
		textFieldFechIniColNew.setBounds(182, 175, 163, 21);
		panel_NewCol.add(textFieldFechIniColNew);
		
		lblFechaFinColNew = new JLabel("Fecha Fin:");
		lblFechaFinColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaFinColNew.setBounds(68, 207, 108, 24);
		panel_NewCol.add(lblFechaFinColNew);
		
		textFieldFechFinColNew = new JTextField();
		textFieldFechFinColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFechFinColNew.setEditable(false);
		textFieldFechFinColNew.setColumns(10);
		textFieldFechFinColNew.setBounds(182, 209, 163, 21);
		panel_NewCol.add(textFieldFechFinColNew);
		
		lblEstadoColNew = new JLabel("Activa:");
		lblEstadoColNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoColNew.setBounds(68, 279, 108, 24);
		panel_NewCol.add(lblEstadoColNew);
		
		chckbxColActivaColNew = new JCheckBox("");
		chckbxColActivaColNew.setBackground(new Color(255, 204, 204));
		chckbxColActivaColNew.setBounds(182, 282, 93, 21);
		panel_NewCol.add(chckbxColActivaColNew);
		
		lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColaborador.setBounds(68, 102, 108, 24);
		panel_NewCol.add(lblColaborador);
		
		btnNewButtonAddCol = new JButton("Añadir");
		btnNewButtonAddCol.setBounds(222, 368, 123, 34);
		panel_NewCol.add(btnNewButtonAddCol);
		
		calendar = new JCalendar();
		calendar.setSize(199, 234);
		calendar.setLocation(500, 102);
		calendar.setVisible(false);
		panel_NewCol.add(calendar);
		
	
		btnFechaIni = new JButton("");
		btnFechaIni.setBounds(355, 176, 33, 21);
		panel_NewCol.add(btnFechaIni);
		
		
		btnConfFchIni = new JButton("Confirmar");
		btnConfFchIni.setBounds(560, 345, 85, 21);
		btnConfFchIni.setVisible(false);
		panel_NewCol.add(btnConfFchIni);
		
		btnFechaFin = new JButton("");
		btnFechaFin.setBounds(355, 208, 33, 21);
		panel_NewCol.add(btnFechaFin);
		
		comboBoxColNew = new JComboBox<>();
		comboBoxColNew.setBounds(182, 105, 163, 23);
		panel_NewCol.add(comboBoxColNew);
		
		comboBoxColTipo = new JComboBox<>();
		comboBoxColTipo.setBounds(182, 139, 163, 23);
		panel_NewCol.add(comboBoxColTipo);
		
		comboBoxColTem = new JComboBox<>();
		comboBoxColTem.setBounds(182, 244, 163, 23);
		panel_NewCol.add(comboBoxColTem);
		
		btnConfFchFin = new JButton("Confirmar");
		btnConfFchFin.setBounds(560, 345, 85, 21);
		btnConfFchFin.setVisible(false);
		panel_NewCol.add(btnConfFchFin);
		
		panel_Publicaciones = new JPanel();
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
		lblIdContenido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdContenido.setBounds(390, 79, 125, 25);
		panel_Publicaciones.add(lblIdContenido);
		
		JLabel lblVistasContenido = new JLabel("Vistas:");
		lblVistasContenido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVistasContenido.setBounds(390, 119, 125, 25);
		panel_Publicaciones.add(lblVistasContenido);
		
		JLabel lblLikesContenido = new JLabel("Likes:");
		lblLikesContenido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLikesContenido.setBounds(390, 155, 125, 25);
		panel_Publicaciones.add(lblLikesContenido);
		
		JLabel lblComentariosContenido = new JLabel("Comentarios:");
		lblComentariosContenido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComentariosContenido.setBounds(390, 191, 125, 25);
		panel_Publicaciones.add(lblComentariosContenido);
		
		JLabel lblCompartidoContenido = new JLabel("Compartidos:");
		lblCompartidoContenido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompartidoContenido.setBounds(390, 227, 125, 25);
		panel_Publicaciones.add(lblCompartidoContenido);
		
		textIdPublicacion = new JTextField();
		textIdPublicacion.setEditable(false);
		textIdPublicacion.setBounds(521, 79, 125, 23);
		panel_Publicaciones.add(textIdPublicacion);
		textIdPublicacion.setColumns(10);
		
		textVistas = new JTextField();
		textVistas.setColumns(10);
		textVistas.setBounds(521, 115, 125, 23);
		panel_Publicaciones.add(textVistas);
		
		textLikes = new JTextField();
		textLikes.setColumns(10);
		textLikes.setBounds(521, 155, 125, 23);
		panel_Publicaciones.add(textLikes);
		
		textComentarios = new JTextField();
		textComentarios.setColumns(10);
		textComentarios.setBounds(521, 191, 125, 23);
		panel_Publicaciones.add(textComentarios);
		
		textCompartidos = new JTextField();
		textCompartidos.setColumns(10);
		textCompartidos.setBounds(521, 227, 125, 23);
		panel_Publicaciones.add(textCompartidos);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(390, 366, 160, 47);
		panel_Publicaciones.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(583, 366, 160, 47);
		panel_Publicaciones.add(btnEliminar);
		
		textFiltro = new JTextField();
		textFiltro.setColumns(10);
		textFiltro.setBounds(560, 332, 125, 23);
		panel_Publicaciones.add(textFiltro);
		
		JLabel lblFiltroopcional = new JLabel("Filtro (Opcional):");
		lblFiltroopcional.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFiltroopcional.setBounds(390, 296, 160, 25);
		panel_Publicaciones.add(lblFiltroopcional);
		
		comboBox_Filtros = new JComboBox<String>();
		comboBox_Filtros.setBounds(390, 332, 125, 23);
		panel_Publicaciones.add(comboBox_Filtros);
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
