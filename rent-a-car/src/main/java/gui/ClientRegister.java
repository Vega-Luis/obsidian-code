package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase para realizar el registro de un nuevo cliente
 * 
 * @author Antony Artavia
 * @version 04/04/2019
 */
public class ClientRegister extends JFrame {

  private JPanel contentPane;
  private JTextField txtNombre;
  private JTextField txtCedula;
  private JTextField txtTelefono;
  private JTextField txtCorreo;
  private JTextField txtProvincia;
  private JTextField txtCanton;
  private JTextField txtDistrito;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ClientRegister frame = new ClientRegister();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Creacion de una nueva ventana.
   */
  public ClientRegister() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 646, 492);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblRegistroDeClientes = new JLabel("Registro de Clientes");
    lblRegistroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblRegistroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblInformacionGeneral = new JLabel("Información general:");
    lblInformacionGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
    
    JLabel lblNombreCompleto = new JLabel("Nombre completo:");
    lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCedula = new JLabel("Cédula:");
    lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCorreo = new JLabel("Correo:");
    lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblDireccion = new JLabel("Dirección");
    lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
    
    JLabel lblProvinicia = new JLabel("Provinicia:");
    lblProvinicia.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCanton = new JLabel("Cantón:");
    lblCanton.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblDistrito = new JLabel("Distrito:");
    lblDistrito.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblSenas = new JLabel("Señas");
    lblSenas.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    txtNombre = new JTextField();
    txtNombre.setColumns(10);
    
    txtCedula = new JTextField();
    txtCedula.setColumns(10);
    
    txtTelefono = new JTextField();
    txtTelefono.setColumns(10);
    
    txtCorreo = new JTextField();
    txtCorreo.setColumns(10);
    
    txtProvincia = new JTextField();
    txtProvincia.setColumns(10);
    
    txtCanton = new JTextField();
    txtCanton.setColumns(10);
    
    txtDistrito = new JTextField();
    txtDistrito.setColumns(10);
    
    JScrollPane scrollPaneSenas = new JScrollPane();
    
    JButton btnRegistrar = new JButton("Registrar Cliente");
    btnRegistrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {    //Evento del boton de registrar cliente
        //Deberia usar la info de los campos de texto para crear un nuevo cliente y meterlo en controller
      }
    });
    btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblRegistroDeClientes, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addComponent(lblInformacionGeneral)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNombreCompleto)
                .addComponent(lblCedula)
                .addComponent(lblTelefono)
                .addComponent(lblCorreo)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblDireccion)
                  .addPreferredGap(ComponentPlacement.RELATED, 5, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblProvinicia)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblCanton)
                  .addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblDistrito)
                  .addPreferredGap(ComponentPlacement.RELATED, 15, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblSenas)
                  .addPreferredGap(ComponentPlacement.RELATED, 32, GroupLayout.PREFERRED_SIZE)))
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                      .addComponent(txtDistrito)
                      .addComponent(txtCanton)
                      .addComponent(txtCorreo)
                      .addComponent(txtTelefono)
                      .addComponent(txtCedula)
                      .addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                      .addComponent(txtProvincia))
                    .addComponent(scrollPaneSenas, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                  .addContainerGap(232, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(btnRegistrar)
                  .addGap(83))))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblRegistroDeClientes)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblInformacionGeneral)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblNombreCompleto)
                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
              .addGap(56)
              .addComponent(lblDireccion)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblProvinicia)
                .addComponent(txtProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblCanton)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(lblDistrito)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(lblSenas))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(txtCanton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(txtDistrito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(scrollPaneSenas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(185)
              .addComponent(btnRegistrar)))
          .addContainerGap(45, Short.MAX_VALUE))
    );
    
    JTextArea txtAreaSenas = new JTextArea();
    scrollPaneSenas.setViewportView(txtAreaSenas);
    contentPane.setLayout(gl_contentPane);
  }
}
