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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Logic.AuxVisitMonth;
import Logic.Office;
import Logic.Person;
import Logic.Register;
import Logic.University;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.SpinnerNumberModel;

public class ReportVisitAge extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JSpinner spinnerMaxAge;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
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
		spinnerMinAge.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		spinnerMinAge.setBounds(109, 27, 47, 20);
		contentPane.add(spinnerMinAge);

		JButton btnNewAceptar = new JButton("Aceptar");
		btnNewAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int minAge=(int)spinnerMinAge.getValue();
					int maxAge=(int)spinnerMaxAge.getValue();
					Checking.ageGreaterAge(minAge, maxAge);
					ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
					ArrayList<ArrayList<Person>> persons=University.getInstance().getVisitByAgeRange(minAge, maxAge);
					for (int i=0; i<persons.size();i++) {
						Office off=University.getInstance().getComputerFac().sortOfficeAlphabetically().get(i);
						for (Person p: persons.get(i)) {
							ArrayList<String> list2=new ArrayList<String>();		
							list2.add(off.getID());
							list2.add(off.getClassification());
							list2.add(p.getIDNumber());				
							list.add(list2);
						}
					}

					Object obj[][]=new Object[list.size()][3];
					for (int i=0; i<list.size(); i++) {
						list.get(i).toArray(obj[i]);
					}
					table.setModel(new DefaultTableModel(
							obj,
							new String[] {
									"ID Local", "Clasificaci\u00F3n", "ID Visitante"
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
				}catch (DateChooserException ex) {
					JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
				}
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
				},
				new String[] {
						"ID Local", "Clasificaci\u00F3n", "ID Visitante"
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

		spinnerMaxAge = new JSpinner();
		spinnerMaxAge.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		spinnerMaxAge.setBounds(166, 27, 47, 20);
		contentPane.add(spinnerMaxAge);
	}
}
