package Interface;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5844502819907636212L;
	private static PrincipalWindow frame2;
	private JLabel text_CAFII;
	private JMenuBar menuBar;
	private JMenu mnConsultar;
	private JMenuItem mntmBD;
	private JMenu mnGestion;
	private JMenuItem mntmCerrarSesion;
	private JMenu mnRegistrar;
	private JMenuItem mntmNuevaPersona;
	private JMenuItem mntmNuevaVisita;
	private JMenuItem mntmNuevoLocal;
	private JPanel contentPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/killer-whale.png")));
		setTitle("CAFII");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 3480668523176519627L;

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
			menuBar.add(getMnConsultar());
			menuBar.add(getMnRegistrar());
			
			JMenu mnNewMenu = new JMenu("Reportes");
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("Locales con m\u00E1s visitas en un mes");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReportGreatVisitByMonth r_window = new ReportGreatVisitByMonth();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
			mnNewMenu.add(mntmNewMenuItem_3);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Locales con visitantes en un rango de edad");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReportVisitAge r_window = new ReportVisitAge();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
			mnNewMenu.add(mntmNewMenuItem_2);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Locales con personas que violaron el horario establecido");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReportOutOfHour r_window = new ReportOutOfHour();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
			mnNewMenu.add(mntmNewMenuItem_1);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Promedio de visitas en un rango de meses\r\n");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReportAverageVisit r_window = new ReportAverageVisit();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
			mnNewMenu.add(mntmNewMenuItem);
			menuBar.add(getMnGestion());
		}
		return menuBar;
	}
	private JMenu getMnConsultar() {
		if (mnConsultar == null) {
			mnConsultar = new JMenu("Consultar\r\n");
			mnConsultar.add(getMntmBD());
		}
		return mnConsultar;
	}
	private JMenuItem getMntmBD() {
		if (mntmBD == null) {
			mntmBD = new JMenuItem("Base de datos");
			mntmBD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QueryWindow p_window = new QueryWindow();
					p_window.setVisible(true);
					p_window.setLocationRelativeTo(null);
					dispose();
				}
			});
		}
		return mntmBD;
	}
	private JMenu getMnGestion() {
		if (mnGestion == null) {
			mnGestion = new JMenu("Salir");
			mnGestion.add(getMntmCerrarSesion());
		}
		return mnGestion;
	}
	private JMenuItem getMntmCerrarSesion() {
		if (mntmCerrarSesion == null) {
			mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
			mntmCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login.main(null);
					dispose();
				}
			});
		}
		return mntmCerrarSesion;
	}
	private JMenu getMnRegistrar() {
		if (mnRegistrar == null) {
			mnRegistrar = new JMenu("Registrar");
			mnRegistrar.add(getMntmNuevaPersona());
			mnRegistrar.add(getMntmNuevaVisita());
			mnRegistrar.add(getMntmNuevoLocal());
		}
		return mnRegistrar;
	}
	private JMenuItem getMntmNuevaPersona() {
		if (mntmNuevaPersona == null) {
			mntmNuevaPersona = new JMenuItem("Nueva persona");
			mntmNuevaPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisterPersonWindow r_window = new RegisterPersonWindow();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
		}
		return mntmNuevaPersona;
	}
	private JMenuItem getMntmNuevaVisita() {
		if (mntmNuevaVisita == null) {
			mntmNuevaVisita = new JMenuItem("Nueva visita");
			mntmNuevaVisita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisterWindow r_window = new RegisterWindow();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
		}
		return mntmNuevaVisita;
	}
	private JMenuItem getMntmNuevoLocal() {
		if (mntmNuevoLocal == null) {
			mntmNuevoLocal = new JMenuItem("Nuevo local");
			mntmNuevoLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisterLocal r_window = new RegisterLocal();
					r_window.setVisible(true);
					r_window.setLocationRelativeTo(null);
				}
			});
		}
		return mntmNuevoLocal;
	}
}
