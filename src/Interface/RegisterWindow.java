package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.Date;
import Utils.Utils;

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

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

import Logic.Office;
import Logic.Person;
import Logic.Register;
import Logic.Student;
import Logic.Technical;
import Logic.University;
import Logic.VisitorRegister;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JLabel lblClasificacion2;
	private JPanel panelVisitante;
	private JLabel lblMotivo;
	private JTextField textMotivo;
	private JLabel lblAutorizador;
	private JLabel lblrea;
	private JComboBox cbAutorizador;
	private JComboBox cbAreaVisit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setTitle("Agregar nueva visita");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 463);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelFechaEntrada());
		contentPane.add(getPanelFechaSalida());
		contentPane.add(getPanelBotones());
		contentPane.add(getPaneDatos1());
		contentPane.add(getPanelDatos2());
		contentPane.add(getPanelVisitante());

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
			cbPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str=new String();
					str=(String)cbPersona.getSelectedItem();
					if (str.equals("<Seleccione>") || University.getInstance().getPersonByFullName(str).isInfo()) {
						panelVisitante.setVisible(false);
					}else {
						panelVisitante.setVisible(true);
					}
				}
			});
			cbPersona.setName("Persona");
			ArrayList<String> personas=new ArrayList<String>();
			personas.add("<Seleccione>");
			for (Person p: University.getInstance().getStaff()) {	
				personas.add(p.getName()+" "+p.getLastName());
			}
			String arrP[]=new String[personas.size()];
			personas.toArray(arrP);
			cbPersona.setModel(new DefaultComboBoxModel(arrP));
		}
		return cbPersona;
	}
	private JPanel getPanelFechaEntrada() {
		if (panelFechaEntrada == null) {
			panelFechaEntrada = new JPanel();
			panelFechaEntrada.setBounds(12, 124, 319, 59);
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
			panelFechaSalida.setBounds(12, 187, 319, 59);
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
						
						Date entrada=new Date();
						Date salida=new Date();
						entrada=dateChooserEntrada.getDate();
						entrada.setHours(Integer.parseInt(textHoraEntrada.getText()));
						entrada.setMinutes(Integer.parseInt(textMinutosEntrada.getText()));
						entrada.setSeconds(0);	
						salida=dateChooserSalida.getDate();
						salida.setHours(Integer.parseInt(textHoraSalida.getText()));
						salida.setMinutes(Integer.parseInt(textMinutosSalida.getText()));
						salida.setSeconds(0);
						
						Person person=University.getInstance().getPersonByFullName((String)cbPersona.getSelectedItem());
						if (person.isInfo()){
							University.getInstance().getOfficeById((String)cbLocal.getSelectedItem()).getRegister().add(new Register(entrada,salida,person));
						}else {
							Checking.checkEmpty(textMotivo);
							Checking.checkNotSelected(cbAutorizador);
							Checking.checkNotSelected(cbAreaVisit);
							University.getInstance().getOfficeById((String)cbLocal.getSelectedItem()).getRegister().add(new VisitorRegister(entrada,salida,person,(String)cbAreaVisit.getSelectedItem(),textMotivo.getText(),person.getIDNumber()));
						}
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
			panelBotones.setBounds(118, 379, 220, 37);
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
			paneDatos1.add(getLblClasificacion2(), "cell 1 1");
		}
		return paneDatos1;
	}
	private JPanel getPanelDatos2() {
		if (panelDatos2 == null) {
			panelDatos2 = new JPanel();
			panelDatos2.setBounds(12, 77, 319, 37);
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
			cbLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s=(String)cbLocal.getSelectedItem();
					if (!s.equals("<Seleccione>"))
						lblClasificacion2.setText(University.getInstance().getOfficeById(s).getClassification());
					else
						lblClasificacion2.setText("");
				}
			});
			cbLocal.setName("Local");
			ArrayList<String> locales=new ArrayList<String>();
			locales.add("<Seleccione>");
			for (Office o: University.getInstance().getComputerFac().getOffices()) {
				if (!(o.getClassification().equals("Aula")) && !(o.getClassification().equals("Laboratorio"))) {
					locales.add(o.getID());
				}
			}
			String arrP[]=new String[locales.size()];
			locales.toArray(arrP);
			cbLocal.setModel(new DefaultComboBoxModel(arrP));
		}
		return cbLocal;
	}
	private JLabel getLblClasificacion2() {
		if (lblClasificacion2 == null) {
			lblClasificacion2 = new JLabel("");
		}
		return lblClasificacion2;
	}
	private JPanel getPanelVisitante() {
		if (panelVisitante == null) {
			panelVisitante = new JPanel();
			panelVisitante.setBorder(new TitledBorder(null, "Visitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelVisitante.setBounds(12, 256, 319, 113);
			panelVisitante.setLayout(new MigLayout("", "[53px][228px]", "[19px][21px][21px]"));
			panelVisitante.add(getLblMotivo(), "cell 0 0,growx,aligny center");
			panelVisitante.add(getTextMotivo(), "cell 1 0,growx,aligny top");
			panelVisitante.add(getLblAutorizador(), "cell 0 1,alignx left,aligny center");
			panelVisitante.add(getLblrea(), "cell 0 2,growx,aligny center");
			panelVisitante.add(getCbAutorizador(), "cell 1 1,growx,aligny top");
			panelVisitante.add(getCbAreaVisit(), "cell 1 2,growx,aligny top");
			panelVisitante.setVisible(false);
		}
		return panelVisitante;
	}
	private JLabel getLblMotivo() {
		if (lblMotivo == null) {
			lblMotivo = new JLabel("Motivo");
			lblMotivo.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblMotivo;
	}
	private JTextField getTextMotivo() {
		if (textMotivo == null) {
			textMotivo = new JTextField();
			textMotivo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					Utils.characterLimit(e, textMotivo, 49);
				}
			});
			textMotivo.setName("Motivo");
			textMotivo.setColumns(10);
		}
		return textMotivo;
	}
	private JLabel getLblAutorizador() {
		if (lblAutorizador == null) {
			lblAutorizador = new JLabel("Autorizador");
			lblAutorizador.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblAutorizador;
	}
	private JLabel getLblrea() {
		if (lblrea == null) {
			lblrea = new JLabel("\u00C1rea");
			lblrea.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblrea;
	}
	private JComboBox getCbAutorizador() {
		if (cbAutorizador == null) {
			cbAutorizador = new JComboBox();
			cbAutorizador.setName("Autorizador");
		}
		return cbAutorizador;
	}
	private JComboBox getCbAreaVisit() {
		if (cbAreaVisit == null) {
			cbAreaVisit = new JComboBox();
			cbAreaVisit.setName("Área");
		}
		return cbAreaVisit;
	}
}
