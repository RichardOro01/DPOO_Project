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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel labelNombre_1;
	private JComboBox cbTipoVisitatne_1;
	private JLabel lblTipoVisitante_1;
	private JComboBox cbTipoVisitatne_2;
	private JComboBox cbTipoVisitatne_3;
	private JComboBox cbTipoVisitatne_4;
	private JLabel labelNombre_1_1;
	private JLabel lblCategoriaCientifica;
	private JPanel especialistaPane;
	private JLabel lblResponsable_1;
	private JTextField textField;
	private JPanel tecnicoPanel;
	private JLabel lblPlaza_1;
	private JComboBox cbTipoVisitatne_5;
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
		setTitle("Registrar persona");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			cbTipoVisitatne.setModel(new DefaultComboBoxModel(addSeleccioneCB(Lists.getPersonType())));
		}
		return cbTipoVisitatne;
	}
	
	public String[] addSeleccioneCB(String[] arr) {
		int tf=arr.length;
		String[] list= new String[tf+1];
		list[0]="<Seleccione>";
		for (int i=1;i<tf;i++) {
			list[i]=arr[i-1];
		}
		return list;
	}
	
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
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
			cbCargo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Decano", "Vicedecanos", "Jefe de departamentos", "Jefe de secretar\u00EDa docente"}));
		}
		return cbCargo;
	}
	private JComboBox getCbArea() {
		if (cbArea == null) {
			cbArea = new JComboBox();
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
			profesorPane.add(getLabelNombre_1(), "cell 0 0,alignx trailing");
			profesorPane.add(getCbTipoVisitatne_1(), "cell 1 0,growx");
			profesorPane.add(getLabelNombre_1_1(), "cell 0 1,alignx trailing");
			profesorPane.add(getCbTipoVisitatne_3(), "cell 1 1,growx");
			profesorPane.add(getLblCategoriaCientifica(), "cell 0 2,alignx trailing");
			profesorPane.add(getCbTipoVisitatne_2(), "cell 1 2,growx");
			profesorPane.add(getLblTipoVisitante_1(), "cell 0 3,alignx trailing");
			profesorPane.add(getCbTipoVisitatne_4(), "cell 1 3,growx");
		}
		return profesorPane;
	}
	private JLabel getLabelNombre_1() {
		if (labelNombre_1 == null) {
			labelNombre_1 = new JLabel("Departamento");
			labelNombre_1.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelNombre_1;
	}
	private JComboBox getCbTipoVisitatne_1() {
		if (cbTipoVisitatne_1 == null) {
			cbTipoVisitatne_1 = new JComboBox();
			cbTipoVisitatne_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Departamento 1", "Departamento 2", "Departamento 3", "Departamento 4", "Departamento 5", "Departamento 6", "Departamento 7", "Departamento 8"}));
		}
		return cbTipoVisitatne_1;
	}
	private JLabel getLblTipoVisitante_1() {
		if (lblTipoVisitante_1 == null) {
			lblTipoVisitante_1 = new JLabel("Tipo de Contrato");
			lblTipoVisitante_1.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblTipoVisitante_1;
	}
	private JComboBox getCbTipoVisitatne_2() {
		if (cbTipoVisitatne_2 == null) {
			cbTipoVisitatne_2 = new JComboBox();
			cbTipoVisitatne_2.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Doctor", "Master"}));
		}
		return cbTipoVisitatne_2;
	}
	private JComboBox getCbTipoVisitatne_3() {
		if (cbTipoVisitatne_3 == null) {
			cbTipoVisitatne_3 = new JComboBox();
			cbTipoVisitatne_3.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Titular ", "Auxiliar", "Asistente", "Instructor"}));
		}
		return cbTipoVisitatne_3;
	}
	private JComboBox getCbTipoVisitatne_4() {
		if (cbTipoVisitatne_4 == null) {
			cbTipoVisitatne_4 = new JComboBox();
			cbTipoVisitatne_4.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Determinado", "Indeterminado"}));
		}
		return cbTipoVisitatne_4;
	}
	private JLabel getLabelNombre_1_1() {
		if (labelNombre_1_1 == null) {
			labelNombre_1_1 = new JLabel("Categor\u00EDa Docente");
			labelNombre_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelNombre_1_1;
	}
	private JLabel getLblCategoriaCientifica() {
		if (lblCategoriaCientifica == null) {
			lblCategoriaCientifica = new JLabel("Categor\u00EDa Cient\u00EDfica");
			lblCategoriaCientifica.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblCategoriaCientifica;
	}
	private JPanel getEspecialistaPane() {
		if (especialistaPane == null) {
			especialistaPane = new JPanel();
			especialistaPane.setBounds(10, 24, 260, 92);
			especialistaPane.setLayout(new MigLayout("", "[52px][96px,grow]", "[19px][][][19px]"));

			especialistaPane.setVisible(false);
			specialData.add(especialistaPane);
			especialistaPane.add(getLblResponsable_1(), "cell 0 0,alignx trailing");
			especialistaPane.add(getTextField(), "cell 1 0,growx");
		}
		return especialistaPane;
	}
	private JLabel getLblResponsable_1() {
		if (lblResponsable_1 == null) {
			lblResponsable_1 = new JLabel("Proyecto en el que trabaja");
			lblResponsable_1.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblResponsable_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getTecnicoPanel() {
		if (tecnicoPanel == null) {
			tecnicoPanel = new JPanel();
			tecnicoPanel.setBounds(10, 20, 260, 96);
			tecnicoPanel.setLayout(new MigLayout("", "[52px][96px,grow]", "[19px][][][19px]"));

			tecnicoPanel.setVisible(false);
			specialData.add(tecnicoPanel);
			tecnicoPanel.add(getLblPlaza_1(), "cell 0 0,alignx trailing");
			tecnicoPanel.add(getCbTipoVisitatne_5(), "cell 1 0,growx");
		}
		return tecnicoPanel;
	}
	private JLabel getLblPlaza_1() {
		if (lblPlaza_1 == null) {
			lblPlaza_1 = new JLabel("Plaza");
			lblPlaza_1.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblPlaza_1;
	}
	private JComboBox getCbTipoVisitatne_5() {
		if (cbTipoVisitatne_5 == null) {
			cbTipoVisitatne_5 = new JComboBox();
			cbTipoVisitatne_5.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Plaza 1", "Plaza 2"}));
		}
		return cbTipoVisitatne_5;
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
		}
		return spinnerAnno;
	}
	private JSpinner getSpinnerGrupo() {
		if (spinnerGrupo == null) {
			spinnerGrupo = new JSpinner();
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
