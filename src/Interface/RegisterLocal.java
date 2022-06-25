package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Logic.Office;
import Logic.Person;
import Logic.University;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class RegisterLocal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JPanel panelBotones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterLocal frame = new RegisterLocal();
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
		setTitle("Registrar local");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTextField());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
		contentPane.add(getPanelBotones());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setBounds(58, 45, 64, 13);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Responsable");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setBounds(43, 75, 79, 13);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Clasificaci\u00F3n");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2.setBounds(30, 107, 92, 13);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setName("ID");
			textField.setBounds(134, 42, 204, 19);
			textField.setColumns(10);
		}
		return textField;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "asd"}));
			comboBox.setName("Responsable");
			comboBox.setBounds(134, 71, 204, 21);
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setName("Clasificación");
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Local del decano", "Local de vicedecano", "Local de jefe de departamento", "Local de servidores", "Local de \u00E1rea administrativa", "Local de profesores", "Local de especialistas", "Local de estudiantes", "Aula", "Laboratorio"}));
			comboBox_1.setBounds(134, 103, 204, 21);
		}
		return comboBox_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Registrar");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Checking.checkEmpty(textField);
						Checking.checkNotSelected(comboBox);
						Checking.checkNotSelected(comboBox_1);
						//Office o= new Office(textField.getText(),(String)comboBox.getSelectedItem(),(Person)comboBox_1.getSelectedItem());
						//University.getInstance().getComputerFac().getOffices().add(o);
					}catch (EmptyTextFormException ex){
						JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch (NotSelectedException ex) {
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
}
