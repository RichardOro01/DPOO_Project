package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

import Logic.Office;
import Logic.University;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterWindow extends JFrame {

	private static RegisterWindow frame3;
	private JPanel contentPane;
	private JLabel lblIdLocal;
	private JLabel lblClasificacion;
	private JLabel lblTipoVisitante;
	private JComboBox cbPersona;
	private JPanel panelFechaEntrada;
	private JTextField textHoraEntrada;
	private JLabel lblNewLabel_3_1_1;
	private JTextField textMinutosEntrada;
	private JPanel panelFechaSalida;
	private JTextField textHoraSalida;
	private JLabel lblNewLabel_3_1_1_1;
	private JTextField textMinutosSalida;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JPanel panelBotones;
	private JPanel panelSeparador;
	private JPanel paneDatos1;
	private JPanel panelDatos2;

	private JDateChooser dateChooserEntrada;
	private JDateChooser dateChooserSalida;
	private JComboBox cbLocal;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 = new RegisterWindow();
					frame3.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterWindow() {
		setTitle("Agregar nueva visita");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 417);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelFechaEntrada());
		contentPane.add(getPanelFechaSalida());
		contentPane.add(getPanelBotones());
		contentPane.add(getPaneDatos1());
		contentPane.add(getPanelDatos2());
		
	}
	private JLabel getLblIdLocal() {
		if (lblIdLocal == null) {
			lblIdLocal = new JLabel("Local");
			lblIdLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblIdLocal;
	}
	private JLabel getLblClasificacion() {
		if (lblClasificacion == null) {
			lblClasificacion = new JLabel("Clasificaci\u00F3n");
			lblClasificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblClasificacion;
	}
	private JLabel getLblTipoVisitante() {
		if (lblTipoVisitante == null) {
			lblTipoVisitante = new JLabel("Persona\r\n");
			lblTipoVisitante.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblTipoVisitante;
	}
	private JComboBox getCbPersona() {
		if (cbPersona == null) {
			cbPersona = new JComboBox();
			cbPersona.setName("Persona");
			cbPersona.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Persona 1", "Persona 2", "Persona 3", "Persona 4", "Persona 5"}));
		}
		return cbPersona;
	}
	private JPanel getPanelFechaEntrada() {
		if (panelFechaEntrada == null) {
			panelFechaEntrada = new JPanel();
			panelFechaEntrada.setBounds(12, 153, 319, 59);
			panelFechaEntrada.setBorder(new TitledBorder(null, "Fecha de entrada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFechaEntrada.setLayout(null);
			panelFechaEntrada.add(getTextHoraEntrada());
			panelFechaEntrada.add(getLblNewLabel_3_1_1());
			panelFechaEntrada.add(getTextMinutosEntrada());
			panelFechaEntrada.add(getDateChooserEntrada());
		}
		return panelFechaEntrada;
	}
	private JTextField getTextHoraEntrada() {
		if (textHoraEntrada == null) {
			textHoraEntrada = new JTextField();
			textHoraEntrada.setName("Hora de entrada");
			textHoraEntrada.setColumns(10);
			textHoraEntrada.setBounds(233, 24, 26, 19);
		}
		return textHoraEntrada;
	}
	private JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel(":");
			lblNewLabel_3_1_1.setBounds(262, 27, 15, 13);
		}
		return lblNewLabel_3_1_1;
	}
	private JTextField getTextMinutosEntrada() {
		if (textMinutosEntrada == null) {
			textMinutosEntrada = new JTextField();
			textMinutosEntrada.setName("Minutos de entrada");
			textMinutosEntrada.setColumns(10);
			textMinutosEntrada.setBounds(271, 24, 26, 19);
		}
		return textMinutosEntrada;
	}
	private JPanel getPanelFechaSalida() {
		if (panelFechaSalida == null) {
			panelFechaSalida = new JPanel();
			panelFechaSalida.setBounds(12, 222, 319, 59);
			panelFechaSalida.setLayout(null);
			panelFechaSalida.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fecha de salida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelFechaSalida.add(getTextHoraSalida());
			panelFechaSalida.add(getLblNewLabel_3_1_1_1());
			panelFechaSalida.add(getTextMinutosSalida());
			panelFechaSalida.add(getDateChooserSalida());
		}
		return panelFechaSalida;
	}
	private JTextField getTextHoraSalida() {
		if (textHoraSalida == null) {
			textHoraSalida = new JTextField();
			textHoraSalida.setName("Hora de salida");
			textHoraSalida.setColumns(10);
			textHoraSalida.setBounds(235, 24, 26, 19);
		}
		return textHoraSalida;
	}
	private JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel(":");
			lblNewLabel_3_1_1_1.setBounds(263, 27, 15, 13);
		}
		return lblNewLabel_3_1_1_1;
	}
	private JTextField getTextMinutosSalida() {
		if (textMinutosSalida == null) {
			textMinutosSalida = new JTextField();
			textMinutosSalida.setName("Minutos de salida");
			textMinutosSalida.setColumns(10);
			textMinutosSalida.setBounds(271, 24, 26, 19);
		}
		return textMinutosSalida;
	}
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						
						Checking.checkNotSelected(cbLocal);
						Checking.checkNotSelected(cbPersona);
						Checking.checkDate(dateChooserEntrada);
						Checking.checkDate(dateChooserSalida);
						Checking.checkEmpty(textHoraEntrada);
						Checking.checkEmpty(textMinutosEntrada);
						Checking.checkEmpty(textHoraSalida);
						Checking.checkEmpty(textMinutosSalida);
						
						JOptionPane.showInternalMessageDialog(contentPane,"Visita registrada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					}catch (EmptyTextFormException ex){
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (NotSelectedException ex) {
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (DateChooserException ex) {
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnRegistrar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}
	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBounds(121, 326, 220, 37);
			panelBotones.setLayout(new MigLayout("", "[75px][grow][79px]", "[32px,grow]"));
			panelBotones.add(getBtnCancelar(), "cell 0 0,grow");
			panelBotones.add(getPanelSeparador(), "cell 1 0,grow");
			panelBotones.add(getBtnRegistrar(), "cell 2 0,alignx left,growy");
		}
		return panelBotones;
	}
	private JPanel getPanelSeparador() {
		if (panelSeparador == null) {
			panelSeparador = new JPanel();
		}
		return panelSeparador;
	}
	private JPanel getPaneDatos1() {
		if (paneDatos1 == null) {
			paneDatos1 = new JPanel();
			paneDatos1.setBounds(12, 10, 319, 66);
			paneDatos1.setLayout(new MigLayout("", "[67.00px][228.00px,grow]", "[19px][21px]"));
			paneDatos1.add(getCbLocal(), "cell 1 0,growx");
			paneDatos1.add(getLblClasificacion(), "cell 0 1,alignx right,aligny center");
			paneDatos1.add(getLblIdLocal(), "cell 0 0,alignx trailing,aligny center");
			paneDatos1.add(getLblNewLabel(), "cell 1 1");
		}
		return paneDatos1;
	}
	private JPanel getPanelDatos2() {
		if (panelDatos2 == null) {
			panelDatos2 = new JPanel();
			panelDatos2.setBounds(12, 77, 319, 66);
			panelDatos2.setLayout(new MigLayout("", "[75px][228.00px]", "[21px][21px]"));
			panelDatos2.add(getLblTipoVisitante(), "cell 0 0,alignx right,growy");
			panelDatos2.add(getCbPersona(), "cell 1 0,growx,aligny top");
		}
		return panelDatos2;
	}
	private JDateChooser getDateChooserEntrada() {
		if (dateChooserEntrada == null) {
			dateChooserEntrada = new JDateChooser();
			dateChooserEntrada.setName("Fecha de entrada");
			dateChooserEntrada.setBounds(10, 24, 213, 19);
		}
		return dateChooserEntrada;
	}
	private JDateChooser getDateChooserSalida() {
		if (dateChooserSalida == null) {
			dateChooserSalida = new JDateChooser();
			dateChooserSalida.setName("Fecha de salida");
			dateChooserSalida.setBounds(11, 24, 214, 19);
		}
		return dateChooserSalida;
	}
	private JComboBox getCbLocal() {
		if (cbLocal == null) {
			cbLocal = new JComboBox();
			cbLocal.setName("Local");
			cbLocal.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Local 1", "Local 2", "Local 3", "Local 4", "Local 5", "Local 6", "Local 7", "Local 8"}));
		}
		return cbLocal;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Con la l\u00F3gica se clasificar\u00E1 autoamtico");
		}
		return lblNewLabel;
	}
}
