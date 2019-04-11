package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bussineslogic.Employee;
import controller.Management;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Clase para registrar un nuevo empleado.
 * 
 * @author Antony Artavia
 * @version 03/04/2019
 */
public class EmployeetRegister extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreCompleto;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtContrasena;

	/**
	 * Para que se ejecute la ventana.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeetRegister frame = new EmployeetRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Creacion del frame.
	 */
	public EmployeetRegister(final Management manager, final Employee empleado) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRegistro = new JLabel("Registro de empleado");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblInfromacionGeneral = new JLabel("Infromación general");
		lblInfromacionGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label = new JLabel("");
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(Color.RED);
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
        
        txtContrasena = new JTextField();
        txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtContrasena.setText("Su contraseña y usuario le sera enviada por correo");
        txtContrasena.setEditable(false);
        txtContrasena.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {       // Evento del boton de registro
			  if(manager.addEmployee(txtNombreCompleto.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText())) {
			    JOptionPane.showMessageDialog(null, "Se registro el nuevo empleado", "Successfull", JOptionPane.INFORMATION_MESSAGE);
			    Employee miNewEmployee = manager.searchEmployee(txtNombreCompleto.getText());
			    String body = "Usuario: " + miNewEmployee.getUserName() + '\n' + "Contrasena: " + miNewEmployee.getPassword();
			    manager.sendMail(empleado.getMail(), miNewEmployee.getPassword(), miNewEmployee.getMail(), "Contrasena y Correo", body);
			    setVisible(false);
			  } else {
			    JOptionPane.showMessageDialog(null, "Ese emplado ya esta registrado", "Error", JOptionPane.WARNING_MESSAGE);
			  }
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addContainerGap()
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		          .addGroup(gl_contentPane.createSequentialGroup()
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		              .addComponent(label)
		              .addComponent(lblInfromacionGeneral)
		              .addGroup(gl_contentPane.createSequentialGroup()
		                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                  .addComponent(lblNombreCompleto)
		                  .addComponent(lblCedula)
		                  .addComponent(lblTelefono)
		                  .addComponent(lblCorreo))
		                .addPreferredGap(ComponentPlacement.RELATED)
		                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		                  .addComponent(txtCorreo)
		                  .addComponent(txtTelefono)
		                  .addComponent(txtCedula)
		                  .addComponent(txtNombreCompleto, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
		              .addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE))
		            .addContainerGap(188, Short.MAX_VALUE))
		          .addGroup(gl_contentPane.createSequentialGroup()
		            .addComponent(lblContrasena)
		            .addPreferredGap(ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
		            .addComponent(btnRegistrarse)
		            .addGap(90)))
		        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		          .addComponent(lblRegistro)
		          .addGap(197))))
		);
		gl_contentPane.setVerticalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addContainerGap()
		      .addComponent(lblRegistro)
		      .addGap(27)
		      .addComponent(lblInfromacionGeneral)
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblNombreCompleto)
		        .addComponent(txtNombreCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblCedula)
		        .addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblTelefono)
		        .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblCorreo)
		        .addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(51)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addComponent(lblContrasena)
		        .addComponent(btnRegistrarse))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      .addGap(28)
		      .addComponent(label))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
