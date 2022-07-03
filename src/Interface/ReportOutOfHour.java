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
import Logic.AuxVisitOutHour;
import Logic.Office;
import Logic.Person;
import Logic.Register;
import Logic.University;
import Utils.Utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class ReportOutOfHour extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox cbTipoPersona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportOutOfHour frame = new ReportOutOfHour();
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
	public ReportOutOfHour() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setResizable(false);
		setTitle("Personas que violaron horarios de visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoPersona = new JLabel("Tipo de persona");
		lblTipoPersona.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipoPersona.setBounds(10, 30, 94, 14);
		contentPane.add(lblTipoPersona);
		
		JButton btnNewAceptar = new JButton("Aceptar");
		btnNewAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				try {
					
				Checking.checkNotSelected(cbTipoPersona);
				ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<AuxVisitOutHour>> persons=University.getInstance().visitOutOfTime(Utils.tpSpa2Eng((String)cbTipoPersona.getSelectedItem()));
				for (int i=0; i<persons.size();i++) {
					Office off=University.getInstance().getComputerFac().getOffices().get(i);
					for (AuxVisitOutHour p: persons.get(i)) {
						ArrayList<String> list2=new ArrayList<String>();		
						list2.add(off.getID());
						list2.add(p.getPerson().getIDNumber());	
						list2.add(Utils.formatDate(p.getDateIn()));
						list2.add(Utils.formatDate(p.getDateOut()));
						list2.add(p.getAccess()==null?Utils.formatDate(p.getDateInMust()):p.getAccess());
						list2.add(p.getAccess()==null?Utils.formatDate(p.getDateOutMust()):p.getAccess());
						list.add(list2);
					}
				}
				
				Object obj[][]=new Object[list.size()][6];
				for (int i=0; i<list.size(); i++) {
					list.get(i).toArray(obj[i]);
				}
				table.setModel(new DefaultTableModel(
						obj,
						new String[] {
								"ID Local", "ID Visitante", "Entrada", "Salida", "Entrada permitida", "Salida permitida"
						}
						));
				}catch (NotSelectedException ex) {
					JOptionPane.showInternalMessageDialog(contentPane,ex.getMsg(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewAceptar.setBounds(286, 26, 89, 23);
		contentPane.add(btnNewAceptar);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(20, 58, 676, 157);
		contentPane.add(scrollPaneTable);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Local", "ID Visitante", "Entrada", "Salida", "Entrada permitida", "Salida permitida"
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
		btnSalir.setBounds(607, 226, 89, 23);
		contentPane.add(btnSalir);
		
		cbTipoPersona = new JComboBox();
		cbTipoPersona.setName("Tipo de persona");
		cbTipoPersona.setModel(new DefaultComboBoxModel(Utils.addSeleccioneCB(Lists.getPersonType())));
		cbTipoPersona.setBounds(114, 26, 162, 22);
		contentPane.add(cbTipoPersona);
	}
}
