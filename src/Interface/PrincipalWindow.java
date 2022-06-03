package Interface;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalWindow extends JFrame {

	private static PrincipalWindow frame2;
	private JPanel contentPane;
	private JLabel text_CAFII;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new PrincipalWindow();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalWindow() {
		setTitle("CAFII");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				Image img=Toolkit.getDefaultToolkit().getImage(PrincipalWindow.class.getResource("/com/images/background4.jpeg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
		;
		
			
		
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getText_CAFII());
		contentPane.add(getMenuBar_1());
		
	}
	private JLabel getText_CAFII() {
		if (text_CAFII == null) {
			text_CAFII = new JLabel("<html><center>Control de Acceso a la Facultadad  <br>de Ingenier\u00EDa Inform\u00E1tica</center></html>");
			text_CAFII.setHorizontalAlignment(SwingConstants.CENTER);
			text_CAFII.setFont(new Font("Tahoma", Font.BOLD, 28));
			text_CAFII.setBounds(41, 44, 617, 142);
		}
		return text_CAFII;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 706, 34);
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Consultar\r\n");
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Base de datos");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QueryWindow p_window = new QueryWindow();
					p_window.setVisible(true);
					p_window.setLocationRelativeTo(null);
					dispose();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Gesti\u00F3n\r\n");
			mnNewMenu_1.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Cerrar Sesi\u00F3n");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login l_window = new Login();
					l_window.setVisible(true);
					l_window.setLocationRelativeTo(null);
					dispose();
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("Registrar");
			mnNewMenu_2.add(getMntmNewMenuItem_2());
			mnNewMenu_2.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("Nueva persona");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisterPersonWindow r_window = new RegisterPersonWindow();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("Nueva visita");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisterWindow r_window = new RegisterWindow();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
		}
		return mntmNewMenuItem_3;
	}
}
