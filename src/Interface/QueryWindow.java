package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class QueryWindow extends JFrame {

	private static QueryWindow frame4;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtBuscarPorNombre;
	private JLabel lblNewLabel;
	private JButton btnBuscar;
	private JPanel toolPanel;
	private JPanel btnBack;
	private JLabel icoBack;
	private JScrollPane scrollPane;

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
		contentPane.add(getTable());
		contentPane.add(getScrollPane());
		contentPane.add(getTxtBuscarPorNombre());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnBuscar());
		contentPane.add(getToolPanel());
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
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setGridColor(Color.LIGHT_GRAY);
			table_1.setBackground(Color.WHITE);
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtBuscarPorNombre.getText().equals("")) {
						txtBuscarPorNombre.setText("Buscar por nombre");
						txtBuscarPorNombre.setForeground(Color.gray);
					}
				}
			});
			table_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{"", "", "", "", ""},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"Viasitante", "Local Visitado", "Fecha entrada", "Fecha salida", "Responsable"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table_1.getColumnModel().getColumn(0).setResizable(false);
			table_1.getColumnModel().getColumn(1).setResizable(false);
			table_1.getColumnModel().getColumn(2).setResizable(false);
			table_1.getColumnModel().getColumn(3).setResizable(false);
			table_1.getColumnModel().getColumn(4).setResizable(false);
		}
		return table_1;
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
			btnBuscar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnBuscar.setBackground(Color.LIGHT_GRAY);
					
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
			scrollPane.setBounds(73, 112, 538, 289);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
}
