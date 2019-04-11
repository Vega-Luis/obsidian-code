package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bussineslogic.Client;
import bussineslogic.Employee;
import controller.Management;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowClient extends JFrame {

  private JPanel contentPane;
  private JTextField txtNombre;
  private JTextField txtTelefono;
  private JTextField txtCedula;
  private JTextField txtCorreo;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          ShowClient frame = new ShowClient(man, man.getClient(0));
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }*/

  /**
   * Create the frame.
   */
  public ShowClient(final Management manager, final Client cliente, final Employee empleado) {                                 //Adaptarlo a que reciba un cliente
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 447, 361);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblClienteIndicado = new JLabel("Cliente indicado");
    lblClienteIndicado.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblClienteIndicado.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCedula = new JLabel("Cédula:");
    lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblTelefono = new JLabel("Telefono:");
    lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCorreo = new JLabel("Correo:");
    lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblLicencia = new JLabel("Licencia:");
    lblLicencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
    
    
    
    txtNombre = new JTextField();
    txtNombre.setText(cliente.getName());
    txtNombre.setEditable(false);
    txtNombre.setColumns(10);
    
    txtTelefono = new JTextField();
    txtTelefono.setText(cliente.getTelephone());
    txtTelefono.setEditable(false);
    txtTelefono.setColumns(10);
    
    txtCedula = new JTextField();
    txtCedula.setText(cliente.getId());
    txtCedula.setEditable(false);
    txtCedula.setColumns(10);
    
    txtCorreo = new JTextField();
    txtCorreo.setText(cliente.getMail());
    txtCorreo.setEditable(false);
    txtCorreo.setColumns(10);
    
    JLabel lblImagen = new JLabel("");
    lblImagen.setIcon(new ImageIcon(cliente.getLicenses().get(0).getImage()));
    lblImagen.setHorizontalTextPosition(SwingConstants.LEADING);
    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
    
        
    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SelecDestinyBegin initfin = new SelecDestinyBegin(manager, cliente, empleado);
        initfin.setVisible(true);
        setVisible(false);
      }
    });
    btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.TRAILING)
        .addComponent(lblClienteIndicado, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblLicencia)
          .addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
          .addComponent(btnAceptar)
          .addGap(25))
        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
              .addContainerGap())
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                  .addComponent(lblCorreo)
                  .addGap(18)
                  .addComponent(txtCorreo, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                  .addComponent(lblCedula)
                  .addGap(18)
                  .addComponent(txtCedula, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                  .addComponent(lblTelefono)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(txtTelefono, 184, 184, 184))
                .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                  .addComponent(lblNombre)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
              .addContainerGap(324, GroupLayout.PREFERRED_SIZE))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblClienteIndicado)
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNombre)
            .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblCedula)
            .addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblTelefono)
            .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCorreo)
            .addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblLicencia)
            .addComponent(btnAceptar))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
          .addContainerGap())
    );
    contentPane.setLayout(gl_contentPane);
  }

}
