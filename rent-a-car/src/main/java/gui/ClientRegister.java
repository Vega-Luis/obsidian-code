package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Management;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
  private JTextField txtLicenceId;
  private JTextArea txtAreaSenas;
  private JDateChooser dateChooserEmision;
  private JDateChooser dateChooserExpiracion;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          ClientRegister frame = new ClientRegister(man);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }*/

  /**
   * Creacion de una nueva ventana.
   */
  public ClientRegister(final Management manager) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 914, 538);
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
    this.txtAreaSenas = new JTextArea();
    scrollPaneSenas.setViewportView(txtAreaSenas);
    
    JLabel lblLicencia = new JLabel("Licencia:");
    lblLicencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
    
    JLabel lblIdentificacion = new JLabel("Identificacion:");
    lblIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblEmision = new JLabel("Emisión:");
    lblEmision.setHorizontalAlignment(SwingConstants.TRAILING);
    lblEmision.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblExpiracion = new JLabel("Expiración:");
    lblExpiracion.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblImagen = new JLabel("Imagen:");
    lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    txtLicenceId = new JTextField();
    txtLicenceId.setColumns(10);
    
    this.dateChooserEmision = new JDateChooser();
    
    this.dateChooserExpiracion = new JDateChooser();
    
    final JFileChooser fileChooserImagen = new JFileChooser();
    fileChooserImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
    
    JButton btnRegistrar = new JButton("Registrar Cliente");
    btnRegistrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {    //Evento del boton de registrar cliente
        //Deberia usar la info de los campos de texto para crear un nuevo cliente y meterlo en controller
        
        BufferedImage imagen;
        try {
          imagen = ImageIO.read(new File(fileChooserImagen.getSelectedFile().getPath()));   //Lee la imagen del fileChooser.
          
          if(manager.addClient(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText(),
              txtProvincia.getText(), txtCanton.getText(), txtDistrito.getText(), txtAreaSenas.getText(), txtLicenceId.getText(),
              dateChooserEmision.getDate(), dateChooserExpiracion.getDate(), (Image)imagen)) {
            JOptionPane.showMessageDialog(null, "Se registro el nuevo cliente", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
          } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese cliente", "Error", JOptionPane.WARNING_MESSAGE);
          }
          
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
      }
    });
    btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
              .addComponent(lblRegistroDeClientes, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
              .addGroup(gl_contentPane.createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addComponent(lblInformacionGeneral)
                  .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                      .addComponent(lblNombreCompleto)
                      .addComponent(lblCedula)
                      .addComponent(lblTelefono)
                      .addComponent(lblCorreo)
                      .addComponent(lblDireccion)
                      .addComponent(lblProvinicia)
                      .addComponent(lblCanton)
                      .addComponent(lblDistrito)
                      .addComponent(lblSenas))
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
                      .addComponent(scrollPaneSenas, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))))
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(57)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                      .addComponent(lblLicencia)
                      .addComponent(lblImagen)
                      .addGroup(gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                          .addComponent(lblIdentificacion)
                          .addComponent(lblEmision)
                          .addComponent(lblExpiracion))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                          .addComponent(dateChooserExpiracion, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                          .addComponent(dateChooserEmision, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                          .addComponent(txtLicenceId, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                    .addGap(104))
                  .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(18)
                    .addComponent(fileChooserImagen, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))))
            .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
              .addComponent(btnRegistrar)
              .addGap(71))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblRegistroDeClientes)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblInformacionGeneral)
            .addComponent(lblLicencia))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblIdentificacion)
            .addComponent(txtLicenceId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
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
              .addGap(6)
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
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addComponent(dateChooserEmision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblEmision))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addComponent(lblExpiracion)
                .addComponent(dateChooserExpiracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblImagen)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(fileChooserImagen, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
          .addGap(27)
          .addComponent(btnRegistrar)
          .addGap(172))
    );
    
    
    contentPane.setLayout(gl_contentPane);
  }
}
