package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;



import Logic.Office;
import Logic.Person;
import Logic.Register;
import Logic.University;
import Utils.Utils;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryWindow extends JFrame {

	private static QueryWindow frame4;
	private JPanel contentPane;
	private JTable table;
	private JTable tableVisitas;
	private JTextField txtBuscarPorNombre;
	private JLabel lblNewLabel;
	private JButton btnBuscar;
	private JPanel toolPanel;
	private JPanel btnBack;
	private JLabel icoBack;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_1_1;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable tablePersonas;
	private JTable tableLocales;
	private ArrayList<ArrayList<Integer>> posVisitas;
	private ArrayList<Person> personas;
	private String nameToFind;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4 = new QueryWindow();
					frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QueryWindow() {
		posVisitas=new ArrayList<ArrayList<Integer>>(); 
		personas=new ArrayList<Person>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setTitle("CAFII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtBuscarPorNombre.getText().equals("")) {
					txtBuscarPorNombre.setText("Buscar por nombre");
					txtBuscarPorNombre.setForeground(Color.gray);
				}
				contentPane.requestFocusInWindow();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnBuscar());
		contentPane.add(getTable());
		contentPane.add(getTabbedPane());
		contentPane.add(getTxtBuscarPorNombre());
		contentPane.add(getLblNewLabel());
		contentPane.add(getToolPanel());
		contentPane.add(getBtnEliminar());
		contentPane.add(getBtnModificar());
		EventQueue.invokeLater( () -> contentPane.requestFocusInWindow() );
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Persona"
					}
					));
			table.setBorder(new CompoundBorder());
			table.setBounds(188, 358, 241, -68);
		}
		return table;
	}

	public void actualizarTabla(JTable tabla) {
		switch (tabla.getName()) {
		//////////////////////////////////
		case "Visitas":
			posVisitas.clear();
			ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
			for (Office off: University.getInstance().getComputerFac().getOffices()) {
				
				for (Register r: off.getRegister()) {
					String fullName=r.getPerson().getName()+" "+r.getPerson().getLastName();
					if (nameToFind==null || fullName.toLowerCase().contains(nameToFind.toLowerCase())) {
						ArrayList<String> list2=new ArrayList<String>();
						ArrayList<Integer> list3=new ArrayList<Integer>(); 
						list2.add(fullName);
						list2.add(off.getID());
						list2.add(Utils.formatDate(r.getCheckInDate()));
						list2.add(Utils.formatDate(r.getCheckOutDate()));
						list3.add(University.getInstance().getComputerFac().getOffices().indexOf(off));
						list3.add(University.getInstance().getComputerFac().getOffices().get(list3.get(0)).getRegister().indexOf(r));
						list.add(list2);
						posVisitas.add(list3);
					}
				}

			}
			Object obj[][]=new Object[list.size()][4];
			for (int i=0; i<list.size(); i++) {
				list.get(i).toArray(obj[i]);
			}


			tableVisitas.setModel(new DefaultTableModel(
					obj,
					new String[] {
							"Visitante", "Local Visitado", "Fecha entrada", "Fecha salida"
					}
					) {
				boolean[] columnEditables = new boolean[] {
						false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			break;
			//////////////////////////////////
		case "Locales":
			ArrayList<ArrayList<String>> list1=new ArrayList<ArrayList<String>>();
			for (Office off: University.getInstance().getComputerFac().getOffices() ) {
				ArrayList<String> list2=new ArrayList<String>();
				list2.add(off.getID());
				list2.add(off.getClassification());
				list2.add(off.getSupervisor().getIDNumber());
				list1.add(list2);
			}
			Object obj1[][]=new Object[list1.size()][3];
			for (int i=0; i<list1.size(); i++) {
				list1.get(i).toArray(obj1[i]);
			}


			tableLocales.setModel(new DefaultTableModel(
					obj1,
					new String[] {
							"ID", "Clasificación", "CI Supervisor"
					}
					) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
						false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});

			break;
			//////////////////////////////////
		case "Personas":
			personas.clear();
			ArrayList<ArrayList<String>> list11=new ArrayList<ArrayList<String>>();
			for (Person p: University.getInstance().getStaff() ) {
				String fullName=p.getName()+" "+p.getLastName();
				if (nameToFind==null || fullName.toLowerCase().contains(nameToFind.toLowerCase())) {
					ArrayList<String> list2=new ArrayList<String>();
					list2.add(fullName);
					list2.add(p.getIDNumber());
					list2.add(p.getClass().getSimpleName());
					list11.add(list2);
					personas.add(p);
				}
			}
			Object obj11[][]=new Object[list11.size()][3];
			for (int i=0; i<list11.size(); i++) {
				list11.get(i).toArray(obj11[i]);
			}


			tablePersonas.setModel(new DefaultTableModel(
					obj11,
					new String[] {
							"Nombre", "CI", "Tipo"
					}
					) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
						false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			break;
		}
	}
	private JTable getTableVisitas() {
		if (tableVisitas == null) {
			tableVisitas = new JTable();
			tableVisitas.setName("Visitas");
			tableVisitas.setGridColor(Color.LIGHT_GRAY);
			tableVisitas.setBackground(Color.WHITE);
			tableVisitas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtBuscarPorNombre.getText().equals("")) {
						txtBuscarPorNombre.setText("Buscar por nombre");
						txtBuscarPorNombre.setForeground(Color.gray);
					}
				}
			});
			tableVisitas.setBorder(new LineBorder(Color.LIGHT_GRAY));
			actualizarTabla(tableVisitas);

		}
		return tableVisitas;
	}
	private JTextField getTxtBuscarPorNombre() {
		if (txtBuscarPorNombre == null) {
			txtBuscarPorNombre = new JTextField();
			txtBuscarPorNombre.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			txtBuscarPorNombre.setBackground(Color.WHITE);
			txtBuscarPorNombre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtBuscarPorNombre.getText().equals("Buscar por nombre")) {
						txtBuscarPorNombre.setText("");
						txtBuscarPorNombre.setForeground(Color.black);
					}
				}
			});
			txtBuscarPorNombre.setForeground(Color.GRAY);
			txtBuscarPorNombre.setText("Buscar por nombre");
			txtBuscarPorNombre.setBounds(73, 74, 448, 19);
			txtBuscarPorNombre.setColumns(10);
			txtBuscarPorNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					Utils.onlyLetters(e,txtBuscarPorNombre,49);					
				}				
			});
		}
		return txtBuscarPorNombre;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tabla de Registro");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(255, 23, 174, 29);
		}
		return lblNewLabel;
	}
	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nameToFind=txtBuscarPorNombre.getText().equals("Buscar por nombre")?null:txtBuscarPorNombre.getText();
					actualizarTabla(tableVisitas);
					actualizarTabla(tablePersonas);
				}
			});
			btnBuscar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btnBuscar.isEnabled()) {
						btnBuscar.setBackground(Color.LIGHT_GRAY);
					}

				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnBuscar.setBackground(new Color(240,240,240));

				}
			});
			btnBuscar.setBorder(new LineBorder(new Color(240,240,240)));
			btnBuscar.setBackground(new Color(240,240,240));
			btnBuscar.setBounds(526, 73, 85, 21);
		}
		return btnBuscar;
	}
	private JPanel getToolPanel() {
		if (toolPanel == null) {
			toolPanel = new JPanel();
			toolPanel.setLayout(null);
			toolPanel.setBackground(Color.WHITE);
			toolPanel.setBounds(0, 0, 706, 44);
			toolPanel.add(getBtnBack());
		}
		return toolPanel;
	}
	private JPanel getBtnBack() {
		if (btnBack == null) {
			btnBack = new JPanel();
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnBack.setBackground(Color.RED);
					ImageIcon ico=new ImageIcon(getClass().getResource("/com/images/arrow-back-regular-240_white.png"));
					ImageIcon img=new ImageIcon(ico.getImage().getScaledInstance(icoBack.getWidth(), icoBack.getHeight(), Image.SCALE_SMOOTH));
					icoBack.setIcon(img);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnBack.setBackground(Color.WHITE);
					ImageIcon ico=new ImageIcon(getClass().getResource("/com/images/arrow-back-regular-240.png"));
					ImageIcon img=new ImageIcon(ico.getImage().getScaledInstance(icoBack.getWidth(), icoBack.getHeight(), Image.SCALE_SMOOTH));
					icoBack.setIcon(img);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					PrincipalWindow p_window = new PrincipalWindow();
					p_window.setVisible(true);
					p_window.setLocationRelativeTo(null);
					dispose();
				}
			});
			btnBack.setLayout(null);
			btnBack.setBackground(Color.WHITE);
			btnBack.setBounds(0, 0, 42, 44);
			btnBack.add(getIcoBack());
		}
		return btnBack;
	}
	private JLabel getIcoBack() {
		if (icoBack == null) {
			icoBack = new JLabel("");
			icoBack.setBackground(Color.WHITE);
			icoBack.setBounds(0, 0, 45, 44);
			ImageIcon ico=new ImageIcon(getClass().getResource("/com/images/arrow-back-regular-240.png"));
			ImageIcon img=new ImageIcon(ico.getImage().getScaledInstance(icoBack.getWidth(), icoBack.getHeight(), Image.SCALE_SMOOTH));
			icoBack.setIcon(img);
		}
		return icoBack;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setViewportView(getTableVisitas());
		}
		return scrollPane;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (tabbedPane.getSelectedIndex()==2) {
						btnBuscar.setEnabled(false);
					}else{
						btnBuscar.setEnabled(true);
					}
				}
			});
			tabbedPane.setBounds(73, 112, 538, 264);
			tabbedPane.addTab("Visitas", null, getScrollPane(), null);
			tabbedPane.addTab("Personas", null, getScrollPane_1(), null);
			tabbedPane.addTab("Locales", null, getScrollPane_1_1(), null);

		}
		return tabbedPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBackground(Color.WHITE);
			scrollPane_1.setViewportView(getTablePersonas());
		}
		return scrollPane_1;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1_1 == null) {
			scrollPane_1_1 = new JScrollPane();
			scrollPane_1_1.setBackground(Color.WHITE);
			scrollPane_1_1.setViewportView(getTableLocales());
		}
		return scrollPane_1_1;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					switch (tabbedPane.getSelectedIndex()) {
					case 0:
						int row=tableVisitas.getSelectedRow();
						if (row!=-1) {
							if (JOptionPane.showConfirmDialog(contentPane, "¿Desea eliminar la visita seleccionada?","Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
								ArrayList<Integer> lPosVisita=posVisitas.get(row);
								Office off=University.getInstance().getComputerFac().getOffices().get((int)lPosVisita.get(0));
								off.getRegister().remove((int)lPosVisita.get(1));
								actualizarTabla(tableVisitas);
							}
						}
						break;
					case 1:
						int row1=tablePersonas.getSelectedRow();
						if (row1!=-1) {
							if (JOptionPane.showConfirmDialog(contentPane, "¿Desea eliminar la persona seleccionada?","Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
								University.getInstance().getStaff().remove(personas.get(row1));
								actualizarTabla(tablePersonas);
							}
						}
						break;
					case 2:
						int row11=tableLocales.getSelectedRow();
						if (row11!=-1) {
							if (JOptionPane.showConfirmDialog(contentPane, "¿Desea eliminar el local seleccionado con todo su registro?","Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
								University.getInstance().getComputerFac().getOffices().remove(row11);
								actualizarTabla(tableLocales);
								actualizarTabla(tableVisitas);
							}
						}
						break;
					}
				}
			});
			btnEliminar.setBorder(new LineBorder(new Color(240,240,240)));
			btnEliminar.setBackground(SystemColor.menu);
			btnEliminar.setBounds(436, 392, 85, 21);
		}
		return btnEliminar;
	}
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar\r\n");
			btnModificar.setBorder(new LineBorder(new Color(240,240,240)));
			btnModificar.setBackground(SystemColor.menu);
			btnModificar.setBounds(526, 392, 85, 21);
		}
		return btnModificar;
	}
	private JTable getTablePersonas() {
		if (tablePersonas == null) {
			tablePersonas = new JTable();
			tablePersonas.setName("Personas");
			actualizarTabla(tablePersonas);
		}
		return tablePersonas;
	}
	private JTable getTableLocales() {
		if (tableLocales == null) {
			tableLocales = new JTable();
			tableLocales.setName("Locales");
			actualizarTabla(tableLocales);
		}
		return tableLocales;
	}
}