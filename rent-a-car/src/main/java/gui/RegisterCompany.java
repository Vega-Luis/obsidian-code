package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterCompany extends JFrame {

  private JPanel contentPane;
  private JTextField txtNombre;
  private JTextField txtCedulaJuridica;
  private JTextField txtTelefono;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RegisterCompany frame = new RegisterCompany();
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
  public RegisterCompany() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 493, 278);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblTitulo = new JLabel("Registro de nueva empresa de servicios");
    lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblNombreEmpresa = new JLabel("Nombre de la empresa:");
    lblNombreEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblCedulaJuridica = new JLabel("Cédula juridica:");
    lblCedulaJuridica.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    txtNombre = new JTextField();
    txtNombre.setColumns(10);
    
    txtCedulaJuridica = new JTextField();
    txtCedulaJuridica.setColumns(10);
    
    txtTelefono = new JTextField();
    txtTelefono.setColumns(10);
    
    JButton btnRegistrarEmpresa = new JButton("Registrar empresa");
    btnRegistrarEmpresa.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {           //Evento del boton
        //deberia agregar una nueva empresa en controller
      }
    });
    btnRegistrarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblNombreEmpresa)
            .addComponent(lblCedulaJuridica)
            .addComponent(lblTelefono))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
            .addComponent(txtTelefono)
            .addComponent(txtCedulaJuridica)
            .addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
          .addContainerGap(45, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
          .addContainerGap(285, Short.MAX_VALUE)
          .addComponent(btnRegistrarEmpresa)
          .addGap(61))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblTitulo)
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNombreEmpresa)
            .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCedulaJuridica)
            .addComponent(txtCedulaJuridica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblTelefono)
            .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
          .addComponent(btnRegistrarEmpresa)
          .addGap(19))
    );
    contentPane.setLayout(gl_contentPane);
  }

}
