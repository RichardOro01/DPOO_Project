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
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Logic.AuxVisitMonth;
import Logic.Office;
import Logic.Register;
import Logic.University;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;

public class ReportGreatVisitByMonth extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblVisitN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportGreatVisitByMonth frame = new ReportGreatVisitByMonth();
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
	public ReportGreatVisitByMonth() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setResizable(false);
		setTitle("Locales con m\u00E1s visitas en un mes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMes.setBounds(10, 30, 37, 14);
		contentPane.add(lblMes);
		
		JSpinner spinnerMes = new JSpinner();
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel();
	    spinnerModel.setMaximum(12);
	    spinnerModel.setMinimum(1);
	    spinnerModel.setValue(1);
		spinnerMes.setBounds(57, 27, 47, 20);
		spinnerMes.setModel(spinnerModel);
		contentPane.add(spinnerMes);
		
		
		JButton btnNewAceptar = new JButton("Aceptar");
		btnNewAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int month=(int)spinnerMes.getValue()+1;
				ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
				AuxVisitMonth aux=University.getInstance().officesWithMoreVisitByMonth(month); 
				for (Office off: aux.getOffices()) {
					ArrayList<String> list2=new ArrayList<String>();		
					list2.add(off.getID());
					list2.add(off.getClassification());
					list2.add(off.getSupervisor().getIDNumber());				
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
								"ID Local", "Clasificaci\u00F3n", "ID Responsable"
						}
						) {
					boolean[] columnEditables = new boolean[] {
							false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				
			}
		});
		btnNewAceptar.setBounds(114, 26, 89, 23);
		contentPane.add(btnNewAceptar);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(20, 58, 530, 157);
		contentPane.add(scrollPaneTable);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Local", "Clasificaci\u00F3n", "ID Responsable"
			}
		));
		scrollPaneTable.setViewportView(table);
		
		JLabel lblVisitas = new JLabel("Visitas:");
		lblVisitas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVisitas.setBounds(21, 226, 47, 14);
		contentPane.add(lblVisitas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(461, 226, 89, 23);
		contentPane.add(btnSalir);
		
		lblVisitN = new JLabel("0");
		lblVisitN.setBounds(73, 226, 47, 14);
		contentPane.add(lblVisitN);
	}
}
