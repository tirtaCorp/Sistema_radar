package cdu1.CrearExpediente.src.Presentación;

import java.awt.BorderLayout;
import cdu1.CrearExpediente.src.Dominio.*;

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

public class InterfazRadar extends JFrame {

	private JPanel contentPane;
	private final JLabel lblImagen = new JLabel("");
	private final JButton btnActivarRadar = new JButton("Activar radar");
	private final JLabel lblDetectado = new JLabel("Infracción detectada");
	private final JTextPane tpExpediente = new JTextPane();
	private boolean activado=false;
	private final int[] limites = {30,40,50,60,70,80,90,100,110,120};
	
	private gestorExpedientes gestorExpedientes=new gestorExpedientes();
	private int id=0;
	private final JButton btnDesactivarRadar = new JButton("Desactivar radar");

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
		
		
		setBounds(100, 100, 604, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 143, 111, 0, 0, 171, 0};
		gbl_contentPane.rowHeights = new int[]{0, 30, 44, 27, 34, 82, 31, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			GridBagConstraints gbc_lblImagen = new GridBagConstraints();
			gbc_lblImagen.gridwidth = 2;
			gbc_lblImagen.gridheight = 5;
			gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
			gbc_lblImagen.gridx = 1;
			gbc_lblImagen.gridy = 1;
			lblImagen.setIcon(new ImageIcon(InterfazRadar.class.getResource("/cdu1/CrearExpediente/src/Presentación/radar1.jpg")));
			contentPane.add(lblImagen, gbc_lblImagen);
		}
		{
			GridBagConstraints gbc_lblDetectado = new GridBagConstraints();
			gbc_lblDetectado.fill = GridBagConstraints.BOTH;
			gbc_lblDetectado.insets = new Insets(0, 0, 5, 0);
			gbc_lblDetectado.gridx = 5;
			gbc_lblDetectado.gridy = 1;
			lblDetectado.setVisible(false);
			lblDetectado.setHorizontalAlignment(SwingConstants.CENTER);
			lblDetectado.setOpaque(true);
			lblDetectado.setBackground(Color.RED);
			lblDetectado.setForeground(Color.WHITE);
			contentPane.add(lblDetectado, gbc_lblDetectado);
		}
		{
			GridBagConstraints gbc_tpExpediente = new GridBagConstraints();
			gbc_tpExpediente.gridheight = 5;
			gbc_tpExpediente.fill = GridBagConstraints.BOTH;
			gbc_tpExpediente.gridx = 5;
			gbc_tpExpediente.gridy = 2;
			tpExpediente.setEditable(false);
			tpExpediente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuevo expediente", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.infoText));
			tpExpediente.setBackground(SystemColor.menu);
			contentPane.add(tpExpediente, gbc_tpExpediente);
		}
		{
			GridBagConstraints gbc_btnActivarRadar = new GridBagConstraints();
			gbc_btnActivarRadar.insets = new Insets(0, 0, 0, 5);
			gbc_btnActivarRadar.gridx = 1;
			gbc_btnActivarRadar.gridy = 6;
			btnActivarRadar.addActionListener(new BtnActivarRadarActionListener());
			contentPane.add(btnActivarRadar, gbc_btnActivarRadar);
		}
		{
			GridBagConstraints gbc_btnDesactivarRadar = new GridBagConstraints();
			gbc_btnDesactivarRadar.insets = new Insets(0, 0, 0, 5);
			gbc_btnDesactivarRadar.gridx = 2;
			gbc_btnDesactivarRadar.gridy = 6;
			btnDesactivarRadar.setEnabled(false);
			contentPane.add(btnDesactivarRadar, gbc_btnDesactivarRadar);
		}
	}

	private class BtnActivarRadarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}
}
