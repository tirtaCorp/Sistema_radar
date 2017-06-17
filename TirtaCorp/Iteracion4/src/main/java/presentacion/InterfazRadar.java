package presentacion;

import dominio.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class InterfazRadar extends JFrame {

	private JPanel contentPane;
	private final JLabel lblImagen = new JLabel("");
	private final JButton btnActivar = new JButton("Activar radar");
	private final JLabel lblDetectado = new JLabel("Infracción detectada");
	private final JTextPane tpInfraccion = new JTextPane();
	private boolean activado=false;
	private final int[] limites = {30,40,50,60,70,80,90,100,110,120};

	private GestorExpedientes gestorExpedientes=new GestorExpedientes();
	private GestorSanciones gestorSanciones=new GestorSanciones();
	private GestorConductores gestorConductores = new GestorConductores();
	private int id=0;
	private Expediente expActual=null;
	private Sancion sanActual=null;
	private Conductor conActual=null;
	private final JButton btnDesactivarRadar = new JButton("Desactivar radar");
	private final JTabbedPane tabGeneral = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelGeneral = new JPanel();
	private final JPanel panelExpedientes = new JPanel();
	private final JList<Expediente> listExpedientes = new JList<Expediente>();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblExpediente = new JLabel("Expediente nº ");
	private final JTextPane tpExpediente = new JTextPane();
	private final JButton btnSancionar = new JButton("Sancionar");
	private final JLabel lblInfracciones = new JLabel("Infracciones detectadas: 0");
	private final JPanel panelSanciones = new JPanel();
	private final JList<Sancion> listSanciones = new JList<Sancion>();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JLabel lblSancion = new JLabel("Sanción nº ");
	private final JTextPane tpSancion = new JTextPane();
	private final JButton btnPagar = new JButton("Pagar");
	private final JPanel panelVehiculos = new JPanel();
	private final JList<Conductor> listVehiculos = new JList<Conductor>();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JLabel lblVehiculo = new JLabel("Vehículo: ");
	private final JTextPane tpVehiculo = new JTextPane();
	private final JLabel lblNuevoPropietario = new JLabel("Nuevo propietario: ");
	private final JTextField tfNuevoPropietario = new JTextField();
	private final JButton btnCambiar = new JButton("Cambiar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRadar frame = new InterfazRadar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazRadar() {
		tfNuevoPropietario.setColumns(10);
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setBounds(100, 100, 553, 344);
		contentPane = new JPanel();
		contentPane.setToolTipText("General");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 143, 111, 0, 0, 171, 0};
		gbl_contentPane.rowHeights = new int[]{0, 30, 44, 27, 34, 82, 31, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			GridBagConstraints gbc_tabGeneral = new GridBagConstraints();
			gbc_tabGeneral.insets = new Insets(0, 0, 5, 0);
			gbc_tabGeneral.gridwidth = 6;
			gbc_tabGeneral.gridheight = 7;
			gbc_tabGeneral.fill = GridBagConstraints.BOTH;
			gbc_tabGeneral.gridx = 0;
			gbc_tabGeneral.gridy = 0;
			tabGeneral.addChangeListener(new TabGeneralChangeListener());
			tabGeneral.setName("General");
			contentPane.add(tabGeneral, gbc_tabGeneral);
		}
		{
			tabGeneral.addTab("General", null, panelGeneral, null);
			GridBagLayout gbl_panelGeneral = new GridBagLayout();
			gbl_panelGeneral.columnWidths = new int[]{38, 74, 34, 113, 42, 150, 18, 0};
			gbl_panelGeneral.rowHeights = new int[]{40, 184, 0, 0};
			gbl_panelGeneral.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelGeneral.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelGeneral.setLayout(gbl_panelGeneral);
		}
		{
			GridBagConstraints gbc_lblDetectado = new GridBagConstraints();
			gbc_lblDetectado.fill = GridBagConstraints.BOTH;
			gbc_lblDetectado.insets = new Insets(0, 0, 5, 5);
			gbc_lblDetectado.gridx = 5;
			gbc_lblDetectado.gridy = 0;
			panelGeneral.add(lblDetectado, gbc_lblDetectado);
			lblDetectado.setVisible(false);
			lblDetectado.setHorizontalAlignment(SwingConstants.CENTER);
			lblDetectado.setOpaque(true);
			lblDetectado.setBackground(Color.RED);
			lblDetectado.setForeground(Color.WHITE);
		}
		{
			GridBagConstraints gbc_lblImagen = new GridBagConstraints();
			gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
			gbc_lblImagen.anchor = GridBagConstraints.NORTH;
			gbc_lblImagen.gridwidth = 5;
			gbc_lblImagen.gridx = 0;
			gbc_lblImagen.gridy = 1;
			panelGeneral.add(lblImagen, gbc_lblImagen);
			lblImagen.setIcon(new ImageIcon(InterfazRadar.class.getResource("/cdu1/CrearExpediente/src/Presentación/radar1.jpg")));
		}
		{
			GridBagConstraints gbc_tpInfraccion = new GridBagConstraints();
			gbc_tpInfraccion.fill = GridBagConstraints.BOTH;
			gbc_tpInfraccion.insets = new Insets(0, 0, 5, 5);
			gbc_tpInfraccion.gridx = 5;
			gbc_tpInfraccion.gridy = 1;
			panelGeneral.add(tpInfraccion, gbc_tpInfraccion);
			tpInfraccion.setEditable(false);
			tpInfraccion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuevo expediente", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.infoText));
			tpInfraccion.setBackground(SystemColor.menu);
		}
		GridBagConstraints gbc_btnActivar = new GridBagConstraints();
		gbc_btnActivar.anchor = GridBagConstraints.WEST;
		gbc_btnActivar.insets = new Insets(0, 0, 0, 5);
		gbc_btnActivar.gridx = 1;
		gbc_btnActivar.gridy = 2;
		panelGeneral.add(btnActivar, gbc_btnActivar);
		btnActivar.addActionListener(new BtnActivarRadarActionListener());
		GridBagConstraints gbc_btnDesactivarRadar = new GridBagConstraints();
		gbc_btnDesactivarRadar.anchor = GridBagConstraints.WEST;
		gbc_btnDesactivarRadar.insets = new Insets(0, 0, 0, 5);
		gbc_btnDesactivarRadar.gridx = 3;
		gbc_btnDesactivarRadar.gridy = 2;
		panelGeneral.add(btnDesactivarRadar, gbc_btnDesactivarRadar);
		btnDesactivarRadar.setEnabled(false);
		{
			GridBagConstraints gbc_lblInfracciones = new GridBagConstraints();
			gbc_lblInfracciones.anchor = GridBagConstraints.EAST;
			gbc_lblInfracciones.insets = new Insets(0, 0, 0, 5);
			gbc_lblInfracciones.gridx = 5;
			gbc_lblInfracciones.gridy = 2;
			panelGeneral.add(lblInfracciones, gbc_lblInfracciones);
		}
		tabGeneral.addTab("Expedientes", null, panelExpedientes, null);
		GridBagLayout gbl_panelExpedientes = new GridBagLayout();
		gbl_panelExpedientes.columnWidths = new int[]{112, 0, 271, 0, 0};
		gbl_panelExpedientes.rowHeights = new int[]{36, 78, 0, 46, 39, 16, 0};
		gbl_panelExpedientes.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelExpedientes.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelExpedientes.setLayout(gbl_panelExpedientes);
		{
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.anchor = GridBagConstraints.WEST;
			gbc_scrollPane.gridheight = 6;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelExpedientes.add(scrollPane, gbc_scrollPane);
		}
		listExpedientes.addListSelectionListener(new ListExpedientesListSelectionListener());
		scrollPane.setViewportView(listExpedientes);
		{
			GridBagConstraints gbc_lblExpediente = new GridBagConstraints();
			gbc_lblExpediente.anchor = GridBagConstraints.WEST;
			gbc_lblExpediente.insets = new Insets(0, 0, 5, 5);
			gbc_lblExpediente.gridx = 2;
			gbc_lblExpediente.gridy = 0;
			panelExpedientes.add(lblExpediente, gbc_lblExpediente);
		}
		{
			GridBagConstraints gbc_tpExpediente = new GridBagConstraints();
			gbc_tpExpediente.gridwidth = 2;
			gbc_tpExpediente.gridheight = 3;
			gbc_tpExpediente.insets = new Insets(0, 0, 5, 0);
			gbc_tpExpediente.fill = GridBagConstraints.BOTH;
			gbc_tpExpediente.gridx = 2;
			gbc_tpExpediente.gridy = 1;
			tpExpediente.setEditable(false);
			tpExpediente.setBackground(SystemColor.menu);
			panelExpedientes.add(tpExpediente, gbc_tpExpediente);
		}
		{
			GridBagConstraints gbc_btnSancionar = new GridBagConstraints();
			gbc_btnSancionar.insets = new Insets(0, 0, 5, 0);
			gbc_btnSancionar.gridwidth = 2;
			gbc_btnSancionar.gridx = 2;
			gbc_btnSancionar.gridy = 4;
			btnSancionar.addActionListener(new BtnSancionarActionListener());
			panelExpedientes.add(btnSancionar, gbc_btnSancionar);
		}
		tabGeneral.addTab("Pagar sanciones", null, panelSanciones, null);
		GridBagLayout gbl_panelSanciones = new GridBagLayout();
		gbl_panelSanciones.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelSanciones.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelSanciones.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelSanciones.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelSanciones.setLayout(gbl_panelSanciones);
		{
			GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
			gbc_scrollPane_1.gridheight = 4;
			gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_1.gridx = 0;
			gbc_scrollPane_1.gridy = 0;
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelSanciones.add(scrollPane_1, gbc_scrollPane_1);
		}
		listSanciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSanciones.addListSelectionListener(new ListSancionesListSelectionListener());
		scrollPane_1.setViewportView(listSanciones);
		{
			GridBagConstraints gbc_lblSancion = new GridBagConstraints();
			gbc_lblSancion.anchor = GridBagConstraints.WEST;
			gbc_lblSancion.insets = new Insets(0, 0, 5, 5);
			gbc_lblSancion.gridx = 2;
			gbc_lblSancion.gridy = 0;
			panelSanciones.add(lblSancion, gbc_lblSancion);
		}
		{
			GridBagConstraints gbc_tpSancion = new GridBagConstraints();
			gbc_tpSancion.anchor = GridBagConstraints.NORTH;
			gbc_tpSancion.insets = new Insets(0, 0, 5, 5);
			gbc_tpSancion.fill = GridBagConstraints.HORIZONTAL;
			gbc_tpSancion.gridx = 2;
			gbc_tpSancion.gridy = 1;
			tpSancion.setBackground(SystemColor.menu);
			panelSanciones.add(tpSancion, gbc_tpSancion);
		}
		{
			GridBagConstraints gbc_btnPagar = new GridBagConstraints();
			gbc_btnPagar.anchor = GridBagConstraints.NORTH;
			gbc_btnPagar.insets = new Insets(0, 0, 5, 5);
			gbc_btnPagar.gridx = 2;
			gbc_btnPagar.gridy = 2;
			btnPagar.addActionListener(new BtnPagarActionListener());
			panelSanciones.add(btnPagar, gbc_btnPagar);
		}
		{
			tabGeneral.addTab("Vehículos", null, panelVehiculos, null);
		}
		GridBagLayout gbl_panelVehiculos = new GridBagLayout();
		gbl_panelVehiculos.columnWidths = new int[]{179, 145, 145, 0};
		gbl_panelVehiculos.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelVehiculos.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelVehiculos.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelVehiculos.setLayout(gbl_panelVehiculos);
		{
			GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
			gbc_scrollPane_2.gridheight = 5;
			gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_2.gridx = 0;
			gbc_scrollPane_2.gridy = 0;
			scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelVehiculos.add(scrollPane_2, gbc_scrollPane_2);
		}
		listVehiculos.addListSelectionListener(new ListVehiculosListSelectionListener());
		scrollPane_2.setViewportView(listVehiculos);
		{
			GridBagConstraints gbc_lblVehiculo = new GridBagConstraints();
			gbc_lblVehiculo.anchor = GridBagConstraints.WEST;
			gbc_lblVehiculo.gridwidth = 2;
			gbc_lblVehiculo.insets = new Insets(0, 0, 5, 0);
			gbc_lblVehiculo.gridx = 1;
			gbc_lblVehiculo.gridy = 0;
			panelVehiculos.add(lblVehiculo, gbc_lblVehiculo);
		}
		{
			GridBagConstraints gbc_tpVehiculo = new GridBagConstraints();
			gbc_tpVehiculo.anchor = GridBagConstraints.WEST;
			gbc_tpVehiculo.gridwidth = 2;
			gbc_tpVehiculo.gridheight = 2;
			gbc_tpVehiculo.insets = new Insets(0, 0, 5, 0);
			gbc_tpVehiculo.fill = GridBagConstraints.VERTICAL;
			gbc_tpVehiculo.gridx = 1;
			gbc_tpVehiculo.gridy = 1;
			tpVehiculo.setEditable(false);
			tpVehiculo.setBackground(SystemColor.menu);
			panelVehiculos.add(tpVehiculo, gbc_tpVehiculo);
		}
		{
			GridBagConstraints gbc_lblNuevoPropietario = new GridBagConstraints();
			gbc_lblNuevoPropietario.anchor = GridBagConstraints.EAST;
			gbc_lblNuevoPropietario.insets = new Insets(0, 0, 5, 5);
			gbc_lblNuevoPropietario.gridx = 1;
			gbc_lblNuevoPropietario.gridy = 3;
			panelVehiculos.add(lblNuevoPropietario, gbc_lblNuevoPropietario);
		}
		{
			GridBagConstraints gbc_tfNuevoPropietario = new GridBagConstraints();
			gbc_tfNuevoPropietario.insets = new Insets(0, 0, 5, 0);
			gbc_tfNuevoPropietario.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNuevoPropietario.gridx = 2;
			gbc_tfNuevoPropietario.gridy = 3;
			panelVehiculos.add(tfNuevoPropietario, gbc_tfNuevoPropietario);
		}
		{
			GridBagConstraints gbc_btnCambiar = new GridBagConstraints();
			gbc_btnCambiar.anchor = GridBagConstraints.EAST;
			gbc_btnCambiar.gridx = 2;
			gbc_btnCambiar.gridy = 4;
			btnCambiar.addActionListener(new BtnCambiarActionListener());
			panelVehiculos.add(btnCambiar, gbc_btnCambiar);
		}

	}
	
	private void cambiarPropietario(){
		
	}

	private void rellenarListaExpedientes(){
		
	}

	private void rellenarListaSanciones(){
	}
	
	private void rellenarListaVehiculos(){
	}

	private void rellenarPanelExpedientes(Expediente expActual){
	}
	
	private void rellenarPanelSanciones(Sancion sanActual){
		
	}
	
	private void rellenarPanelVehiculos(Vehiculo cocheActual){
	}

	private class BtnActivarRadarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	private class BtnSancionarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.print(expActual.equals(null));
			
			gestorSanciones.crearSancion(expActual);
			expActual.sancionar();
			System.out.println(gestorSanciones.getSanciones().length+" "+expActual.isSancionado());
			
			btnSancionar.setText("Sancionada");
			btnSancionar.setBackground(Color.GREEN);
			
			
			rellenarListaSanciones();
		}
	}
	private class BtnPagarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			sanActual.pagar();
			
			btnPagar.setText("Pagada");
			btnPagar.setBackground(Color.GREEN);
			
		}
	}
	private class TabGeneralChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			rellenarListaExpedientes();
			rellenarListaSanciones();
			rellenarListaVehiculos();
		}
	}
	private class ListExpedientesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			expActual=listExpedientes.getSelectedValue();
			rellenarPanelExpedientes(expActual);
			
		}
	}
	private class ListSancionesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			sanActual=listSanciones.getSelectedValue();
			rellenarPanelSanciones(sanActual);
		}
	}
	private class ListVehiculosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			conActual=listVehiculos.getSelectedValue();
			rellenarPanelVehiculos(conActual);
		}
	}
	private class BtnCambiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(!tfNuevoPropietario.equals("")){
				String nuevoPropietario=tfNuevoPropietario.getText();
				tfNuevoPropietario.setText("");
				
				conActual.setDni(nuevoPropietario);
				rellenarPanelVehiculos(conActual);
			}
		}
	}
}
