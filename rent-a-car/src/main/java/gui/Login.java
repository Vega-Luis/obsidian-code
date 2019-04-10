package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import controller.Management;
import controller.RefactorThisNameC;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

/**
 * Clase para iniciar secion con GUI
 * 
 * @author Antony Artavia
 * @version 03/04/2019
 *
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasena;
	private Management manager = new Management();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creacion del Frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Inicio de sesión"); // Label del inicio de secion
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:"); // Label del nombre usuario
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblContrasena = new JLabel("Contraseña:"); // Label de la contrasena
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));

		txtNombreUsuario = new JTextField(); // Espacio de texto de la
		txtNombreUsuario.setColumns(10);

		txtContrasena = new JPasswordField(); // Espacio de texto de la contrasena

		JButton btnIniciarSecin = new JButton("Iniciar sesión"); // Boton de inicio de sesion
		btnIniciarSecin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Evento de inicio de sesion
				String NombreUsuario = txtNombreUsuario.getText();
				String contrasena = txtContrasena.getText();

				if(manager.login(contrasena, NombreUsuario)) {
				  Menu miMenu = new Menu(manager);
				  miMenu.setVisible(true);
				  setVisible(false);
				} else {
				  JOptionPane.showMessageDialog(null, "El usuario o contraseña especificado no existe.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnIniciarSecin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		  gl_contentPane.createParallelGroup(Alignment.TRAILING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addGap(105)
		          .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addGap(74)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		            .addComponent(lblNombreDeUsuario)
		            .addComponent(lblContrasena))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		            .addComponent(txtContrasena)
		            .addComponent(txtNombreUsuario, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
		      .addContainerGap(120, Short.MAX_VALUE))
		    .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
		      .addGap(206)
		      .addComponent(btnIniciarSecin, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		      .addGap(217))
		);
		gl_contentPane.setVerticalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addGap(78)
		      .addComponent(lblNewLabel)
		      .addGap(48)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblNombreDeUsuario)
		        .addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(29)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addComponent(lblContrasena)
		        .addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(51)
		      .addComponent(btnIniciarSecin, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
		      .addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
