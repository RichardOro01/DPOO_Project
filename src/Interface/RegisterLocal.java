package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Logic.Office;
import Logic.Person;
import Logic.Student;
import Logic.Technical;
import Logic.University;
import Utils.Observable;
import Utils.Observador;
import Utils.Utils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.Checking;
import Exceptions.EmptyTextFormException;
import Exceptions.LocalException;
import Exceptions.NotSelectedException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterLocal extends JFrame implements Observable{

	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblResponsable;
	private JLabel lblClasificacion;
	private JTextField textField;
	private JComboBox cbResponsable;
	private JComboBox cbClasificacion;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JPanel panelBotones;
	private ArrayList<Observador> observardores;
	private Office local;
	private String oldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterLocal frame = new RegisterLocal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterLocal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setTitle("Registrar local");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 250);
		observardores=new ArrayList<Observador>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblId());
		contentPane.add(getLblResponsable());
		contentPane.add(getLblClasificacion());
		contentPane.add(getTextField());
		contentPane.add(getCbResponsable());
		contentPane.add(getCbClasificacion());
		contentPane.add(getPanelBotones());
	}
	public RegisterLocal(Office off) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setTitle("Modificar local");
		local=off;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 250);
		observardores=new ArrayList<Observador>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblId());
		contentPane.add(getLblResponsable());
		contentPane.add(getLblClasificacion());
		contentPane.add(getTextField());
		contentPane.add(getCbResponsable());
		contentPane.add(getCbClasificacion());
		contentPane.add(getPanelBotones());
		oldId=off.getID();
		getCbResponsable().setSelectedItem(off.getSupervisor().getName()+" "+off.getSupervisor().getLastName());
		getCbClasificacion().setSelectedItem(off.getClassification());
		getTextField().setText(off.getID());
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setHorizontalAlignment(SwingConstants.TRAILING);
			lblId.setBounds(58, 45, 64, 13);
		}
		return lblId;
	}
	private JLabel getLblResponsable() {
		if (lblResponsable == null) {
			lblResponsable = new JLabel("Responsable");
			lblResponsable.setHorizontalAlignment(SwingConstants.TRAILING);
			lblResponsable.setBounds(43, 75, 79, 13);
		}
		return lblResponsable;
	}
	private JLabel getLblClasificacion() {
		if (lblClasificacion == null) {
			lblClasificacion = new JLabel("Clasificaci\u00F3n");
			lblClasificacion.setHorizontalAlignment(SwingConstants.TRAILING);
			lblClasificacion.setBounds(30, 107, 92, 13);
		}
		return lblClasificacion;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					Utils.characterLimit(e, textField, 9);
				}
			});
			textField.setName("ID");
			textField.setBounds(134, 42, 204, 19);
			textField.setColumns(10);
		}
		return textField;
	}
	private JComboBox getCbResponsable() {
		if (cbResponsable == null) {
			cbResponsable = new JComboBox();
			ArrayList<String> personas=new ArrayList<String>();
			personas.add("<Seleccione>");
			for (Person p: University.getInstance().getStaff()) {
				if (!(p instanceof Student) && !(p instanceof Technical) && (p.isInfo())) {
					personas.add(p.getFullName());
				}
			}
			String arrP[]=new String[personas.size()];
			personas.toArray(arrP);
			cbResponsable.setModel(new DefaultComboBoxModel(arrP));
			cbResponsable.setName("Responsable");
			cbResponsable.setBounds(134, 71, 204, 21);
		}
		return cbResponsable;
	}
	private JComboBox getCbClasificacion() {
		if (cbClasificacion == null) {
			cbClasificacion = new JComboBox();
			cbClasificacion.setName("Clasificación");
			cbClasificacion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Local del decano", "Local de vicedecano", "Local de jefe de departamento", "Local de servidores", "Local de \u00E1rea administrativa", "Local de profesores", "Local de especialistas", "Local de estudiantes", "Aula", "Laboratorio"}));
			cbClasificacion.setBounds(134, 103, 204, 21);
		}
		return cbClasificacion;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton(local==null?"Registrar":"Modificar");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Checking.checkEmpty(textField);
						Checking.checkNotSelected(cbResponsable);
						Checking.checkNotSelected(cbClasificacion);
						if (local==null) {
							Checking.checkExistingLocalID(textField.getText());
							Office o= new Office(textField.getText(),(String)cbClasificacion.getSelectedItem(),University.getInstance().getPersonByFullName((String)cbResponsable.getSelectedItem()));
							University.getInstance().getComputerFac().getOffices().add(o);
							JOptionPane.showInternalMessageDialog(contentPane,"Local registrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						}else {
							if (!oldId.equals(textField.getText())) {
								Checking.checkExistingLocalID(textField.getText());
							}
							local.setClassification((String)cbClasificacion.getSelectedItem());
							local.setID(textField.getText());
							local.setSupervisor(University.getInstance().getPersonByFullName((String)cbResponsable.getSelectedItem()));
							JOptionPane.showInternalMessageDialog(contentPane,"Local modificado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						}
						notificar();
						University.getInstance().getComputerFac().sortOfficeAlphabetically();
						dispose();
					}catch (EmptyTextFormException ex){
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (NotSelectedException ex) {
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (LocalException ex) {
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnNewButton;
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
			panelBotones.setBounds(136, 166, 220, 37);
			panelBotones.setLayout(new MigLayout("", "[][][7.00][][]", "[]"));
			panelBotones.add(getBtnCancelar(), "cell 0 0");
			panelBotones.add(getBtnNewButton(), "cell 4 0");
		}
		return panelBotones;
	}
	public void enlazarObservador(Observador o) {
		observardores.add(o);
	}
	
	@Override
	public void notificar() {
		for (Observador o: observardores) {
			o.actualizar();
		}
		
	}
}