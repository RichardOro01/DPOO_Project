package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Exceptions.Checking;
import Exceptions.DateChooserException;
import Exceptions.NotSelectedException;
import Logic.AuxVisitMonth;
import Logic.Office;
import Logic.Register;
import Logic.University;
import Utils.Lists;
import Utils.Utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ReportAverageVisit extends JFrame {

	private JPanel contentPane;
	private JComboBox cbTipoPersona;
	private JSpinner spinnerMonth2;
	private JLabel lblPromedioN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportAverageVisit frame = new ReportAverageVisit();
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
	public ReportAverageVisit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setResizable(false);
		setTitle("Promedio de visitas por rango de meses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMeses = new JLabel("Rango de meses");
		lblMeses.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMeses.setBounds(10, 30, 115, 14);
		contentPane.add(lblMeses);
		
		JSpinner spinnerMonth1 = new JSpinner();
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel();
	    spinnerModel.setMaximum(12);
	    spinnerModel.setMinimum(1);
	    spinnerModel.setValue(1);
		spinnerMonth1.setBounds(135, 28, 47, 20);
		spinnerMonth1.setModel(spinnerModel);
		contentPane.add(spinnerMonth1);
		
		JButton btnNewAceptar = new JButton("Calcular");
		btnNewAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Checking.checkNotSelected(cbTipoPersona);
					int month1=(int)spinnerMonth1.getValue();
					int month2=(int)spinnerMonth2.getValue();
					Checking.monthGreaterMonth(month1, month2);
					String typePerson=Utils.tpSpa2Eng((String)cbTipoPersona.getSelectedItem());
					double average=University.getInstance().averageVisitsInMonthPerVisitor(month1, month2, typePerson);
					lblPromedioN.setText(""+Math.round(average*100.0)/100.0);
				}catch (NotSelectedException ex) {
					JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (DateChooserException ex) {
					JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewAceptar.setBounds(150, 79, 89, 23);
		contentPane.add(btnNewAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(422, 120, 89, 23);
		contentPane.add(btnSalir);
		
		spinnerMonth2 = new JSpinner();
		SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel();
	    spinnerModel2.setMaximum(12);
	    spinnerModel2.setMinimum(1);
	    spinnerModel2.setValue(1);
		spinnerMonth2.setBounds(192, 28, 47, 20);
		spinnerMonth2.setModel(spinnerModel2);
		contentPane.add(spinnerMonth2);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPromedio.setBounds(10, 83, 89, 14);
		contentPane.add(lblPromedio);
		
		lblPromedioN = new JLabel("0");
		lblPromedioN.setBounds(109, 83, 89, 14);
		contentPane.add(lblPromedioN);
		
		JLabel lblTipoDeVisitante = new JLabel("Tipo de visitante\r\n");
		lblTipoDeVisitante.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipoDeVisitante.setBounds(234, 30, 108, 14);
		contentPane.add(lblTipoDeVisitante);
		contentPane.add(getCbTipoPersona());
	}
	private JComboBox getCbTipoPersona() {
		if (cbTipoPersona == null) {
			cbTipoPersona = new JComboBox();
			cbTipoPersona.setName("Tipo de visitante");
			cbTipoPersona.setModel(new DefaultComboBoxModel(Utils.addSeleccioneCB(Lists.getPersonType())));
			cbTipoPersona.setBounds(352, 26, 161, 22);
		}
		return cbTipoPersona;
	}
}
