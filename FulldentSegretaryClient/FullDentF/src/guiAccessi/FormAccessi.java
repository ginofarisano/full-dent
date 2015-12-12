package guiAccessi;

import gestioneAccessi.Account;
import gestioneAccessi.DBAccount;
import guiAmministratore.FormAmministratore;
import guiSegretaria.FormCalendario;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

// TODO: Auto-generated Javadoc
/**
 * Interfaccia grafica che si occupa dello scambio di informazioni tra utente 
 * e sistema per effettuare l'accesso al programma.
 * @author 
 *
 */
public class FormAccessi extends javax.swing.JFrame {

	/** The auth frame. */
	protected final JFrame authFrame;
	
	/** The password_box. */
	private JPanel password_box;
	
	/** The userid_field. */
	private JTextField userid_field;
	
	/** The username_box. */
	private JPanel username_box;
	
	/** The quit_button. */
	private JButton quit_button;
	
	/** The login_button. */
	private JButton login_button;
	
	/** The button panel. */
	private JPanel buttonPanel;
	
	/** The password_label. */
	private JLabel password_label;
	
	/** The user i d_label. */
	private JLabel userID_label;
	
	/** The password_field. */
	private JPasswordField password_field;


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormAccessi inst = new FormAccessi();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	/**
	 * Crea un nuovo Frame.
	 */
	public FormAccessi() {
		super();
		authFrame=this;
		initGUI();
	}
	
	/**
	 * classe interna che gestisce l'azione di login.
	 * @author Maria D'Arco
	 *
	 */
	class LoginButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			
			String username=userid_field.getText();
			String password= new String();
			char pass_c[]=password_field.getPassword();
			for(char a : pass_c)
				password=password+a;
	
			try {
				DBAccount db=new DBAccount();
				db.OpenConnection();
				Account x = db.getAccount(username, password);
				db.closeConnection();
				if(x == null){ 
					JOptionPane.showMessageDialog(null, "account non presente");
				}
				else{
						String tipoAccount = x.getTipo();
						authFrame.setVisible(false);
						if(tipoAccount.equalsIgnoreCase("amministratore")){
							FormAmministratore y =new FormAmministratore();
							y.setVisible(true);
						}
						if(tipoAccount.equalsIgnoreCase("segretaria")){
							FormCalendario z = new FormCalendario();
							z.setVisible(true);
						}
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Errore d'esecuzione!");
			}
			
		}
	}
	
	
	/**
	 * Classe interna che gestisce la fase di chiusura del programma.
	 * @author Maria D'Arco
	 *
	 */
	class ExitButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	/**
	 * Meodo di supporto che inizializza le componenti del Frame.
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			thisLayout.setHgap(10);
			thisLayout.setVgap(5);
			this.setLocation(500, 300);
			this.setTitle("FullDent - Login");
			this.setMaximumSize(new java.awt.Dimension(350, 130));
			this.setPreferredSize(new java.awt.Dimension(350, 130));
			getContentPane().setLayout(thisLayout);
			username_box = new JPanel();
			getContentPane().add(username_box, BorderLayout.NORTH);
			BorderLayout jPanel1Layout = new BorderLayout();
			username_box.setLayout(jPanel1Layout);
			username_box.setSize(350, 30);		
			userID_label = new JLabel();
			username_box.add(userID_label, BorderLayout.WEST);
			userID_label.setText("userID:  ");
			userID_label.setPreferredSize(new java.awt.Dimension(58, 30));
			userid_field = new JTextField();
			username_box.add(userid_field, BorderLayout.CENTER);
			userid_field.setPreferredSize(new java.awt.Dimension(246, 28));
			password_box = new JPanel();
			getContentPane().add(password_box, BorderLayout.CENTER);
			BorderLayout rootPanelLayout = new BorderLayout();
			password_box.setLayout(rootPanelLayout);
			password_box.setPreferredSize(new java.awt.Dimension(300, 130));
			password_box.setSize(350, 130);
			password_label = new JLabel();
			password_box.add(password_label, BorderLayout.WEST);
			password_label.setText("password:");
			password_label.setPreferredSize(new java.awt.Dimension(73, 28));
			password_field = new JPasswordField();
			password_box.add(password_field, BorderLayout.EAST);
			password_field.setPreferredSize(new java.awt.Dimension(267, 28));
			password_field.setSize(196, 28);
			buttonPanel = new JPanel();
			BorderLayout buttonPanelLayout = new BorderLayout();
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			buttonPanel.setLayout(buttonPanelLayout);
			buttonPanel.setPreferredSize(new java.awt.Dimension(350, 27));
			quit_button = new JButton();
			buttonPanel.add(quit_button, BorderLayout.WEST);
			quit_button.setText("esci");
			quit_button.addActionListener(new ExitButtonListener());
			quit_button.setPreferredSize(new java.awt.Dimension(60, 27));
			login_button = new JButton();		
			buttonPanel.add(login_button, BorderLayout.EAST);
			login_button.addActionListener(new LoginButtonListener());
			login_button.setText("login");
			login_button.setPreferredSize(new java.awt.Dimension(79, 35));
			pack();
		
			this.setResizable(false);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
	

