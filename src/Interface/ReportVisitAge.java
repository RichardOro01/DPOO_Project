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

public class ReportVisitAge extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportVisitAge frame = new ReportVisitAge();
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
	public ReportVisitAge() {
		setResizable(false);
		setTitle("Visitas por rango de edad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEdad = new JLabel("Rango de edad");
		lblEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEdad.setBounds(10, 30, 89, 14);
		contentPane.add(lblEdad);
		
		JSpinner spinnerMinAge = new JSpinner();
		spinnerMinAge.setBounds(109, 27, 47, 20);
		contentPane.add(spinnerMinAge);
		
		JButton btnNewAceptar = new JButton("Aceptar");
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
		btnNewAceptar.setBounds(237, 26, 89, 23);
		contentPane.add(btnNewAceptar);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(20, 58, 530, 157);
		contentPane.add(scrollPaneTable);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID Local", "Clasificacion", "ID Visitante"
			}
		));
		scrollPaneTable.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(461, 226, 89, 23);
		contentPane.add(btnSalir);
		
		JSpinner spinnerMaxAge = new JSpinner();
		spinnerMaxAge.setBounds(166, 27, 47, 20);
		contentPane.add(spinnerMaxAge);
	}
}
