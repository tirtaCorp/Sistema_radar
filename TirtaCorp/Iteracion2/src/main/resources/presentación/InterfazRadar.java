package cdu2.src.presentaci√≥n;

import java.awt.BorderLayout;
import cdu2.src.dominio.*;

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

public class InterfazRadar extends JFrame {

	private JPanel contentPane;
	private final JLabel lblImagen = new JLabel("");
	private final JButton btnActivar = new JButton("Activar radar");
	private final JLabel lblDetectado = new JLabel("Infraccion detectada");
	private final JTextPane tpInfraccion = new JTextPane();
	//private boolean activado=false;
	private final int[] limites = {30,40,50,60,70,80,90,100,110,120};
	
	private GestorExpedientes gestorExpedientes=new GestorExpedientes();
	private GestorSanciones gestorSanciones=new GestorSanciones();
	
	private final JButton btnDesactivarRadar = new JButton("Desactivar radar");
	private final JTabbedPane tabGeneral = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelGeneral = new JPanel();
	private final JPanel panelExpedientes = new JPanel();
	private final JList<Expediente> listExpedientes = new JList<Expediente>();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblExpediente = new JLabel("Expediente n∫ ");
	private final JTextPane tpExpediente = new JTextPane();
	private final JButton btnSancionar = new JButton("Sancionar");
	private final JLabel lblInfracciones = new JLabel("Infracciones detectadas: 0");

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
			lblImagen.setIcon(new ImageIcon(InterfazRadar.class.getResource("/cdu1/CrearExpediente/src/Presentaci√≥n/radar1.jpg")));
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
		
	}
	
	private void rellenarListaExpedientes(){
		listExpedientes.setListData(gestorExpedientes.getExpedientes());
		listExpedientes.setSelectedIndex(0);

		expActual = listExpedientes.getSelectedValue();
	}
	
	private void rellenarPanelExpedientes(Expediente expActual){
		
		if(gestorExpedientes.getExpedientes().length != 0){
			
			//sanActual = gestorSanciones.buscarSancion(expActual.getID());
			lblExpediente.setText("Expediente n∫ "+expActual.getID());
			tpExpediente.setText("Matricula: "+expActual.getMatricula()+"\nVelocidad: "+expActual.getVelocidad()+"\nLimite de velocidad: "
					+expActual.getLimiteVelocidad()+"\nLugar: "+expActual.getLugar()+"\nPropietario: "+expActual.getPropietario());

			if(expActual.isSancionado()){
				btnSancionar.setText("Sancionada");
				btnSancionar.setBackground(Color.GREEN);
			}
			else{
				btnSancionar.setText("Sancionar");
				btnSancionar.setBackground(Color.LIGHT_GRAY);
			}
		}
		
	}
	
	private void crearSancion(String matricula, int IDExpediente){
		
	}

	private class BtnActivarRadarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnActivar.setEnabled(true);
		}
	}
	private class BtnSancionarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			btnSancionar.setText("Sancionada");
			btnSancionar.setBackground(Color.GREEN);
		}
	}
	private class TabGeneralChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			rellenarListaExpedientes();
		}
	}
	private class ListExpedientesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			expActual=listExpedientes.getSelectedValue();
			rellenarPanelExpedientes(expActual);
			
		}
	}
}
