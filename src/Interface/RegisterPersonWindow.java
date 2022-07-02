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
import java.awt.Component;

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

import Logic.Administrative;
import Logic.Executive;
import Logic.Professor;
import Logic.Specialist;
import Logic.Student;
import Logic.Technical;
import Logic.University;
import Utils.Utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SpinnerNumberModel;

public class RegisterPersonWindow extends JFrame {

	private static RegisterPersonWindow frame3;
	private JPanel contentPane;
	private JPanel panelDatosVisitante;
	private JLabel lblTipoVisitante;
	private JComboBox cbTipoVisitatne;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JLabel labelNombre;
	private JTextField textNombre;
	private JLabel labelApellidos;
	private JTextField textApellidos;
	private JLabel labelNI;
	private JTextField textNI;
	private JCheckBox checkIsInfo;
	private JPanel panelDatosTodoVisitante;
	private JPanel panelBotones;
	private JPanel panelSeparador;
	private JPanel panelDatos2;
	private JPanel directivoPane;
	private JLabel panelCargo;
	private JLabel panelArea;
	private JComboBox cbCargo;
	private JComboBox cbArea;
	private ArrayList<JPanel> specialData;
	private JPanel administrativoPane;
	private JLabel lblPlaza;
	private JComboBox cbPlaza;
	private JPanel profesorPane;
	private JLabel labelDepartamento;
	private JComboBox cbDepartamento;
	private JLabel lblTipoContrato;
	private JComboBox cbCatCientifica;
	private JComboBox cbCatDocente;
	private JComboBox cbTipoContrato;
	private JLabel labelCatDocente;
	private JLabel lblCatCientifica;
	private JPanel especialistaPane;
	private JLabel lblProyecto;
	private JTextField textProyecto;
	private JPanel tecnicoPanel;
	private JLabel lblPlazaTec;
	private JComboBox cbPlazaTec;
	private JPanel estudiantePane;
	private JLabel lblAnno;
	private JLabel lblGrupo;
	private JSpinner spinnerAnno;
	private JSpinner spinnerGrupo;
	private JLabel lblDepa;
	private JComboBox cbDepa;
	private JLabel lblEsDeInformtica;
	private JPanel DatosEspPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 = new RegisterPersonWindow();
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
	public RegisterPersonWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setTitle("Registrar persona");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 314);
		specialData = new ArrayList<JPanel>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelDatosVisitante());
		contentPane.add(getPanelBotones());
		contentPane.add(getPanelDatos2());
		
	}
	private JPanel getPanelDatosVisitante() {
		if (panelDatosVisitante == null) {
			panelDatosVisitante = new JPanel();
			panelDatosVisitante.setBounds(12, 52, 682, 174);
			panelDatosVisitante.setLayout(null);
			panelDatosVisitante.add(getPanelDatosTodoVisitante());
			panelDatosVisitante.add(getDatosEspPane());
		}
		return panelDatosVisitante;
	}
	private JLabel getLblTipoVisitante() {
		if (lblTipoVisitante == null) {
			lblTipoVisitante = new JLabel("Tipo de visitante");
			lblTipoVisitante.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblTipoVisitante;
	}
	private JComboBox getCbTipoVisitatne() {
		if (cbTipoVisitatne == null) {
			cbTipoVisitatne = new JComboBox();
			cbTipoVisitatne.setName("Tipo de visitante");
			cbTipoVisitatne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (JPanel panel: specialData) {
						panel.setVisible(false);
					}
					String item= (String) cbTipoVisitatne.getSelectedItem();
					switch (item){
					case "Directivo":
						directivoPane.setVisible(true);
						break;
					case "Administrativo":
						administrativoPane.setVisible(true);
						break;
					case "Profesor":
						profesorPane.setVisible(true);
						break;
					case "Especialista":
						especialistaPane.setVisible(true);
						break;
					case "T�cnico":
						tecnicoPanel.setVisible(true);
						break;
					case "Estudiante":
						estudiantePane.setVisible(true);
						break;

					}
				}
			});
			cbTipoVisitatne.setModel(new DefaultComboBoxModel(Utils.addSeleccioneCB(Lists.getPersonType())));
		}
		return cbTipoVisitatne;
	}
	
	
	
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Checking.checkEmpty(textNombre);
						Checking.checkEmpty(textApellidos);
						Checking.checkEmpty(textNI);
						Checking.checkNotSelected(cbTipoVisitatne);
						Checking.checkCI(textNI.getText());
						for (JPanel panel: specialData) {
							if (panel.isVisible()) {
								for (Component c: panel.getComponents()) {
									if (c instanceof JComboBox) {
										if (c.isVisible()) {
											Checking.checkNotSelected((JComboBox)c);
										}
									}else if (c instanceof JTextField) {
										if (c.isVisible()) {
											Checking.checkEmpty((JTextField)c);
										}
									}
								}
							}
						}
						switch ((String)cbTipoVisitatne.getSelectedItem()) {
						case "Directivo": 
							University.getInstance().getStaff().add(new Executive(textNombre.getText(),textApellidos.getText(),textNI.getText(),checkIsInfo.isSelected(),(String)cbCargo.getSelectedItem(),cbArea.getSelectedItem().equals("Departamento")?(String)cbDepa.getSelectedItem():(String)cbArea.getSelectedItem()));
							break;
						case "Administrativo":
							University.getInstance().getStaff().add(new Administrative(textNombre.getText(),textApellidos.getText(),textNI.getText(),checkIsInfo.isSelected(),(String)cbPlaza.getSelectedItem()));
							break;
						case "Profesor":
							University.getInstance().getStaff().add(new Professor(textNombre.getText(),textApellidos.getText(),textNI.getText(),checkIsInfo.isSelected(),(String)cbDepartamento.getSelectedItem(),(String)cbCatDocente.getSelectedItem(),(String)cbCatCientifica.getSelectedItem(),(String)cbTipoContrato.getSelectedItem()));
							break;
						case "Especialista":
							University.getInstance().getStaff().add(new Specialist(textNombre.getText(),textApellidos.getText(),textNI.getText(),checkIsInfo.isSelected(), textProyecto.getText()));
							break;
						case "T�cnico":
							University.getInstance().getStaff().add(new Technical(textNombre.getText(),textApellidos.getText(),textNI.getText(),checkIsInfo.isSelected(),(String)cbPlazaTec.getSelectedItem()));
							break;
						case "Estudiante":
							University.getInstance().getStaff().add(new Student(textNombre.getText(),textApellidos.getText(),textNI.getText(),checkIsInfo.isSelected(), (int)spinnerAnno.getValue(), (int)spinnerGrupo.getValue()));
							break;
						}
						
						//University.getInstance().getStaff().add(new Person(textNombre.getText(),));
						JOptionPane.showInternalMessageDialog(contentPane,"Persona registrada", "�xito", JOptionPane.INFORMATION_MESSAGE);
					}catch(EmptyTextFormException ex) {
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (NotSelectedException ex) {
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (CIException ex) {
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
	private JLabel getLabelNombre() {
		if (labelNombre == null) {
			labelNombre = new JLabel("Nombre");
			labelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelNombre;
	}
	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setName("Nombre");
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	private JLabel getLabelApellidos() {
		if (labelApellidos == null) {
			labelApellidos = new JLabel("Apellidos");
			labelApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelApellidos;
	}
	private JTextField getTextApellidos() {
		if (textApellidos == null) {
			textApellidos = new JTextField();
			textApellidos.setName("Apellidos");
			textApellidos.setColumns(10);
		}
		return textApellidos;
	}
	private JLabel getLabelNI() {
		if (labelNI == null) {
			labelNI = new JLabel("N\u00FAmero de identidad");
			labelNI.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelNI;
	}
	private JTextField getTextNI() {
		if (textNI == null) {
			textNI = new JTextField();
			textNI.setName("N�mero de identidad");
			textNI.setColumns(10);
		}
		return textNI;
	}
	private JCheckBox getCheckIsInfo() {
		if (checkIsInfo == null) {
			checkIsInfo = new JCheckBox("");
		}
		return checkIsInfo;
	}
	private JPanel getPanelDatosTodoVisitante() {
		if (panelDatosTodoVisitante == null) {
			panelDatosTodoVisitante = new JPanel();
			panelDatosTodoVisitante.setBorder(new TitledBorder(null, "Datos generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatosTodoVisitante.setBounds(23, 21, 260, 126);
			panelDatosTodoVisitante.setLayout(new MigLayout("", "[95px][96px]", "[19px][19px][19px][]"));
			panelDatosTodoVisitante.add(getLabelNI(), "cell 0 2,alignx right,aligny center");
			panelDatosTodoVisitante.add(getLabelApellidos(), "cell 0 1,alignx right,aligny center");
			panelDatosTodoVisitante.add(getTextApellidos(), "cell 1 1,alignx left,aligny top");
			panelDatosTodoVisitante.add(getTextNombre(), "cell 1 0,alignx left,aligny top");
			panelDatosTodoVisitante.add(getLabelNombre(), "cell 0 0,alignx right,aligny center");
			panelDatosTodoVisitante.add(getTextNI(), "cell 1 2,alignx left,aligny top");
			panelDatosTodoVisitante.add(getLblEsDeInformtica(), "cell 0 3,alignx right");
			panelDatosTodoVisitante.add(getCheckIsInfo(), "cell 1 3");
		}
		return panelDatosTodoVisitante;
	}
	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBounds(416, 233, 220, 37);
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
	private JPanel getPanelDatos2() {
		if (panelDatos2 == null) {
			panelDatos2 = new JPanel();
			panelDatos2.setBounds(12, 10, 332, 37);
			panelDatos2.setLayout(new MigLayout("", "[75px][228.00px]", "[21px][21px]"));
			panelDatos2.add(getCbTipoVisitatne(), "cell 1 1,growx,aligny top");
			panelDatos2.add(getLblTipoVisitante(), "cell 0 1,alignx left,growy");
		}
		return panelDatos2;
	}
	private JPanel getPanel_3_1() {
		if (directivoPane == null) {
			directivoPane = new JPanel();
			directivoPane.setBounds(10, 24, 276, 102);
			directivoPane.setLayout(new MigLayout("", "[37.00px][96px,grow]", "[19px][19px][]"));
			directivoPane.add(getPanelCargo(), "cell 0 0,alignx trailing,growy");
			directivoPane.add(getCbCargo(), "cell 1 0,growx");
			directivoPane.add(getPanelArea(), "cell 0 1,alignx trailing,growy");
			directivoPane.add(getCbArea(), "cell 1 1,growx");
			directivoPane.setVisible(false);
			specialData.add(directivoPane);
			directivoPane.add(getLblDepa(), "cell 0 2,alignx trailing");
			directivoPane.add(getCbDepa(), "cell 1 2,growx");
		}
		return directivoPane;
	}
	private JLabel getPanelCargo() {
		if (panelCargo == null) {
			panelCargo = new JLabel("Cargo");
			panelCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return panelCargo;
	}
	private JLabel getPanelArea() {
		if (panelArea == null) {
			panelArea = new JLabel("\u00C1rea");
			panelArea.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return panelArea;
	}
	private JComboBox getCbCargo() {
		if (cbCargo == null) {
			cbCargo = new JComboBox();
			cbCargo.setName("Cargo");
			cbCargo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Decano", "Vicedecanos", "Jefe de departamentos", "Jefe de secretar\u00EDa docente"}));
		}
		return cbCargo;
	}
	private JComboBox getCbArea() {
		if (cbArea == null) {
			cbArea = new JComboBox();
			cbArea.setName("�rea");
			cbArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String item=(String) cbArea.getSelectedItem();
					if (item.equals("Departamento")) {
						cbDepa.setVisible(true);
						lblDepa.setVisible(true);
					}else {
						cbDepa.setVisible(false);
						lblDepa.setVisible(false);
					}
				}
			});
			cbArea.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Decanato", "Vicedecanato", "Secretar\u00EDa","Departamento"}));
		}
		return cbArea;
	}
	
	private JPanel getAdministrativoPane() {
		if (administrativoPane == null) {
			administrativoPane = new JPanel();
			administrativoPane.setBounds(10, 20, 276, 64);
			administrativoPane.setLayout(new MigLayout("", "[34.00px][96px,grow]", "[19px][19px]"));

			administrativoPane.setVisible(false);
			specialData.add(administrativoPane);
			administrativoPane.add(getLblPlaza(), "cell 0 0,alignx trailing");
			administrativoPane.add(getCbPlaza(), "cell 1 0,growx");
		}
		return administrativoPane;
	}
	private JLabel getLblPlaza() {
		if (lblPlaza == null) {
			lblPlaza = new JLabel("Plaza");
			lblPlaza.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblPlaza;
	}
	private JComboBox getCbPlaza() {
		if (cbPlaza == null) {
			cbPlaza = new JComboBox();
			cbPlaza.setName("Plaza");
			cbPlaza.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Asesor", "Secretaria"}));
		}
		return cbPlaza;
	}
	private JPanel getProfesorPane() {
		if (profesorPane == null) {
			profesorPane = new JPanel();
			profesorPane.setBounds(20, 20, 255, 124);
			profesorPane.setLayout(new MigLayout("", "[81.00px][96px,grow]", "[19px][][][19px]"));

			profesorPane.setVisible(false);
			specialData.add(profesorPane);
			profesorPane.add(getLabelDepartamento(), "cell 0 0,alignx trailing");
			profesorPane.add(getCbDepartamento(), "cell 1 0,growx");
			profesorPane.add(getLabelCatDocente(), "cell 0 1,alignx trailing");
			profesorPane.add(getCbCatDocente(), "cell 1 1,growx");
			profesorPane.add(getLblCatCientifica(), "cell 0 2,alignx trailing");
			profesorPane.add(getCbCatCientifica(), "cell 1 2,growx");
			profesorPane.add(getLblTipoContrato(), "cell 0 3,alignx trailing");
			profesorPane.add(getCbTipoContrato(), "cell 1 3,growx");
		}
		return profesorPane;
	}
	private JLabel getLabelDepartamento() {
		if (labelDepartamento == null) {
			labelDepartamento = new JLabel("Departamento");
			labelDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelDepartamento;
	}
	private JComboBox getCbDepartamento() {
		if (cbDepartamento == null) {
			cbDepartamento = new JComboBox();
			cbDepartamento.setName("Departamento");
			cbDepartamento.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Departamento 1", "Departamento 2", "Departamento 3", "Departamento 4", "Departamento 5", "Departamento 6", "Departamento 7", "Departamento 8"}));
		}
		return cbDepartamento;
	}
	private JLabel getLblTipoContrato() {
		if (lblTipoContrato == null) {
			lblTipoContrato = new JLabel("Tipo de Contrato");
			lblTipoContrato.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblTipoContrato;
	}
	private JComboBox getCbCatCientifica() {
		if (cbCatCientifica == null) {
			cbCatCientifica = new JComboBox();
			cbCatCientifica.setName("Categor�a cient�fica");
			cbCatCientifica.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Doctor", "Master"}));
		}
		return cbCatCientifica;
	}
	private JComboBox getCbCatDocente() {
		if (cbCatDocente == null) {
			cbCatDocente = new JComboBox();
			cbCatDocente.setName("Categor�a docente");
			cbCatDocente.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Titular ", "Auxiliar", "Asistente", "Instructor"}));
		}
		return cbCatDocente;
	}
	private JComboBox getCbTipoContrato() {
		if (cbTipoContrato == null) {
			cbTipoContrato = new JComboBox();
			cbTipoContrato.setName("Tipo de contrato");
			cbTipoContrato.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Determinado", "Indeterminado"}));
		}
		return cbTipoContrato;
	}
	private JLabel getLabelCatDocente() {
		if (labelCatDocente == null) {
			labelCatDocente = new JLabel("Categor\u00EDa Docente");
			labelCatDocente.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelCatDocente;
	}
	private JLabel getLblCatCientifica() {
		if (lblCatCientifica == null) {
			lblCatCientifica = new JLabel("Categor\u00EDa Cient\u00EDfica");
			lblCatCientifica.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblCatCientifica;
	}
	private JPanel getEspecialistaPane() {
		if (especialistaPane == null) {
			especialistaPane = new JPanel();
			especialistaPane.setBounds(10, 24, 260, 92);
			especialistaPane.setLayout(new MigLayout("", "[52px][96px,grow]", "[19px][][][19px]"));

			especialistaPane.setVisible(false);
			specialData.add(especialistaPane);
			especialistaPane.add(getLblProyecto(), "cell 0 0,alignx trailing");
			especialistaPane.add(getTextProyecto(), "cell 1 0,growx");
		}
		return especialistaPane;
	}
	private JLabel getLblProyecto() {
		if (lblProyecto == null) {
			lblProyecto = new JLabel("Proyecto en el que trabaja");
			lblProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblProyecto;
	}
	private JTextField getTextProyecto() {
		if (textProyecto == null) {
			textProyecto = new JTextField();
			textProyecto.setName("Proyecto en el que trabaja");
			textProyecto.setColumns(10);
		}
		return textProyecto;
	}
	private JPanel getTecnicoPanel() {
		if (tecnicoPanel == null) {
			tecnicoPanel = new JPanel();
			tecnicoPanel.setBounds(10, 20, 260, 96);
			tecnicoPanel.setLayout(new MigLayout("", "[52px][96px,grow]", "[19px][][][19px]"));

			tecnicoPanel.setVisible(false);
			specialData.add(tecnicoPanel);
			tecnicoPanel.add(getLblPlazaTec(), "cell 0 0,alignx trailing");
			tecnicoPanel.add(getCbPlazaTec(), "cell 1 0,growx");
		}
		return tecnicoPanel;
	}
	private JLabel getLblPlazaTec() {
		if (lblPlazaTec == null) {
			lblPlazaTec = new JLabel("Plaza");
			lblPlazaTec.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblPlazaTec;
	}
	private JComboBox getCbPlazaTec() {
		if (cbPlazaTec == null) {
			cbPlazaTec = new JComboBox();
			cbPlazaTec.setName("Plaza");
			cbPlazaTec.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Plaza 1", "Plaza 2"}));
		}
		return cbPlazaTec;
	}
	private JPanel getEstudiantePane() {
		if (estudiantePane == null) {
			estudiantePane = new JPanel();
			estudiantePane.setBounds(10, 24, 260, 92);
			estudiantePane.setLayout(new MigLayout("", "[52px][96px,grow]", "[19px][][][19px]"));

			estudiantePane.setVisible(false);
			specialData.add(estudiantePane);
			estudiantePane.add(getLblAnno(), "cell 0 0,alignx right");
			estudiantePane.add(getSpinnerAnno(), "cell 1 0,growx");
			estudiantePane.add(getLblGrupo(), "cell 0 1,alignx right");
			estudiantePane.add(getSpinnerGrupo(), "cell 1 1,growx");
		}
		return estudiantePane;
	}
	private JLabel getLblAnno() {
		if (lblAnno == null) {
			lblAnno = new JLabel("A\u00F1o");
			lblAnno.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblAnno;
	}
	private JLabel getLblGrupo() {
		if (lblGrupo == null) {
			lblGrupo = new JLabel("Grupo");
			lblGrupo.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblGrupo;
	}
	private JSpinner getSpinnerAnno() {
		if (spinnerAnno == null) {
			spinnerAnno = new JSpinner();
			spinnerAnno.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		}
		return spinnerAnno;
	}
	private JSpinner getSpinnerGrupo() {
		if (spinnerGrupo == null) {
			spinnerGrupo = new JSpinner();
			spinnerGrupo.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		}
		return spinnerGrupo;
	}
	private JLabel getLblDepa() {
		if (lblDepa == null) {
			lblDepa = new JLabel("Departamento");
			lblDepa.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDepa.setVisible(false);
		}
		return lblDepa;
	}
	private JComboBox getCbDepa() {
		if (cbDepa == null) {
			cbDepa = new JComboBox();
			cbDepa.setName("Departamento");
			cbDepa.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Departamento 1", "Departamento 2", "Departamento 3", "Departamento 4", "Departamento 5", "Departamento 6", "Departamento 7", "Departamento 8"}));
			cbDepa.setVisible(false);
		}
		return cbDepa;
	}
	private JLabel getLblEsDeInformtica() {
		if (lblEsDeInformtica == null) {
			lblEsDeInformtica = new JLabel("Es de Inform\u00E1tica");
			lblEsDeInformtica.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblEsDeInformtica;
	}
	private JPanel getDatosEspPane() {
		if (DatosEspPane == null) {
			DatosEspPane = new JPanel();
			DatosEspPane.setBounds(293, 21, 320, 154);
			DatosEspPane.setBorder(new TitledBorder(null, "Datos espec\u00EDficos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			DatosEspPane.setLayout(null);
			DatosEspPane.add(getPanel_3_1());
			DatosEspPane.add(getProfesorPane());
			DatosEspPane.add(getAdministrativoPane());
			DatosEspPane.add(getEspecialistaPane());
			DatosEspPane.add(getTecnicoPanel());
			DatosEspPane.add(getEstudiantePane());
		}
		return DatosEspPane;
	}
}
