package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Logic.AuxVisitMonth;
import Logic.Office;
import Logic.Register;
import Logic.University;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportAverageVisit extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

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
		lblMeses.setBounds(10, 30, 89, 14);
		contentPane.add(lblMeses);
		
		JSpinner spinnerMinAge = new JSpinner();
		spinnerMinAge.setBounds(109, 27, 47, 20);
		contentPane.add(spinnerMinAge);
		
		JButton btnNewAceptar = new JButton("Calcular");
		btnNewAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int month=(int)spinnerMinAge.getValue();
				ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
				AuxVisitMonth aux=University.getInstance().officesWithMoreVisitByMonth(month); 
				for (Office off: aux.getOffices()) {
					ArrayList<String> list2=new ArrayList<String>();		
					list2.add(off.getID());
					list2.add(off.getClassification());
					list2.add(off.getSupervisor().getName()+" "+off.getSupervisor().getLastName());				
					list.add(list2);
				}
				lblVisitN.setText(""+aux.getVisits());
				Object obj[][]=new Object[list.size()][3];
				for (int i=0; i<list.size(); i++) {
					list.get(i).toArray(obj[i]);
				}
				table.setModel(new DefaultTableModel(
						obj,
						new String[] {
								"ID", "Clasificacion", "Responsable"
						}
						));
				
			}
		});
		btnNewAceptar.setBounds(120, 79, 89, 23);
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
		
		JSpinner spinnerMaxAge = new JSpinner();
		spinnerMaxAge.setBounds(166, 27, 47, 20);
		contentPane.add(spinnerMaxAge);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPromedio.setBounds(-18, 83, 89, 14);
		contentPane.add(lblPromedio);
		
		JLabel lblMeses_1_1 = new JLabel("0");
		lblMeses_1_1.setBounds(74, 83, 89, 14);
		contentPane.add(lblMeses_1_1);
		
		JLabel lblTipoDeVisitante = new JLabel("Tipo de visitante\r\n");
		lblTipoDeVisitante.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipoDeVisitante.setBounds(223, 30, 108, 14);
		contentPane.add(lblTipoDeVisitante);
		contentPane.add(getComboBox());
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			comboBox.setBounds(352, 26, 161, 22);
		}
		return comboBox;
	}
}
