package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Service;
import bussineslogic.Vehicle;
import controller.Management;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Date;

public class DetailShow extends JFrame {

  private JPanel contentPane;
  private JTextField txtIdCliente;
  private JTextField txtNombreCliente;
  private JTextField txtTipoCambio;
  private JTextField txtSedeRecogida;
  private JTextField txtSedeEntrega;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DetailShow frame = new DetailShow();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }*/

  /**
   * Create the frame.
   * @throws Exception 
   * @throws IOException 
   * @throws SAXException 
   * @throws ParserConfigurationException 
   * @throws NumberFormatException 
   */
  public DetailShow(final Management manager, final Client cliente, final DestinyDelivery datos, final Vehicle vehicle, final Service servicio, final Employee empleado) 
                      throws NumberFormatException, ParserConfigurationException, SAXException, IOException, Exception {
    //Adaptarlo a que reciba un cliente, un vehiculo y un services
    
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 810, 381);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblDetallesDeReserva = new JLabel("Detalles de reserva");
    lblDetallesDeReserva.setHorizontalAlignment(SwingConstants.CENTER);
    lblDetallesDeReserva.setFont(new Font("Tahoma", Font.PLAIN, 19));
    
    JLabel lblIdentificacionCliente = new JLabel("Identificacion del cliente:");
    lblIdentificacionCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblNombreCliente = new JLabel("Nombre del cliente:");
    lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel labelImagenVehiculo = new JLabel("");                                    //Label de la imagen
    labelImagenVehiculo.setIcon(new ImageIcon(vehicle.getVehicleImage()));
    
    JRadioButton rdbtnWifi = new JRadioButton("Wifi");
    rdbtnWifi.setEnabled(false);
    rdbtnWifi.setSelected(servicio.getWifi());
    rdbtnWifi.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JRadioButton rdbtnGps = new JRadioButton("GPS");
    rdbtnGps.setEnabled(false);
    rdbtnGps.setSelected(servicio.getGps());
    rdbtnGps.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JRadioButton rdbtnAsistenciaEnCarretera = new JRadioButton("Asistencia en carretera");
    rdbtnAsistenciaEnCarretera.setEnabled(false);
    rdbtnAsistenciaEnCarretera.setSelected(servicio.getRouteAssistance());
    rdbtnAsistenciaEnCarretera.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JRadioButton rdbtnAsientoParaNios = new JRadioButton("Asiento para niños");
    rdbtnAsientoParaNios.setEnabled(false);
    rdbtnAsientoParaNios.setSelected(servicio.getChildSeat());
    rdbtnAsientoParaNios.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JRadioButton rdbtnCoberturaPorDaos = new JRadioButton("Cobertura por daños de terceros");
    rdbtnCoberturaPorDaos.setEnabled(false);
    rdbtnCoberturaPorDaos.setSelected(servicio.getEnsurance());
    rdbtnCoberturaPorDaos.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    txtIdCliente = new JTextField();
    txtIdCliente.setEditable(false);
    txtIdCliente.setText(cliente.getId());
    txtIdCliente.setColumns(10);
    
    txtNombreCliente = new JTextField();
    txtNombreCliente.setEditable(false);
    txtNombreCliente.setText(cliente.getName());
    txtNombreCliente.setColumns(10);
    
    
    JScrollPane scrollPaneVehiculo = new JScrollPane();
    JTextArea textAreaVehiculo = new JTextArea();
    textAreaVehiculo.setEditable(false);
    textAreaVehiculo.setText(vehicle.DataSelection());
    scrollPaneVehiculo.setViewportView(textAreaVehiculo);
    
    JLabel lblServicios = new JLabel("Servicios:");
    lblServicios.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblTipoDeCambio = new JLabel("Tipo de cambio vigente a dolares:");
    lblTipoDeCambio.setFont(new Font("Tahoma", Font.PLAIN, 16));
    
    txtTipoCambio = new JTextField();
    txtTipoCambio.setEditable(false);
    txtTipoCambio.setText("" + manager.getBuy());
    txtTipoCambio.setColumns(10);
    
    JLabel lblSedeRecogida = new JLabel("Sede de recogida:");
    lblSedeRecogida.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    txtSedeRecogida = new JTextField();
    txtSedeRecogida.setEditable(false);
    txtSedeRecogida.setText(datos.getSedeRecogida().getName());
    txtSedeRecogida.setColumns(10);
    
    JLabel lblSedeEntrega = new JLabel("Sede de entrega:");
    lblSedeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    txtSedeEntrega = new JTextField();
    txtSedeEntrega.setEditable(false);
    txtSedeEntrega.setText(datos.getSedeEntrega().getName());
    txtSedeEntrega.setColumns(10);
    
    
    
    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {              //Evento del boton
        //Debria utilizar todos los datos y agregar la nueva reserva e imprimirla.
        Date fechaActual = setFechaActual();
        manager.reserve(datos.getSedeRecogida(), datos.getSedeEntrega(), servicio, cliente, empleado, vehicle, datos.getFechaRecogida(),
            datos.getFechaEntrega(), fechaActual);
        
        setVisible(false);
      }
    });
    btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblDetallesDeReserva, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(labelImagenVehiculo, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollPaneVehiculo, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblIdentificacionCliente)
                .addComponent(lblNombreCliente))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addComponent(txtNombreCliente)
                .addComponent(txtIdCliente, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(btnAceptar)
                  .addContainerGap())
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(rdbtnCoberturaPorDaos)
                  .addContainerGap())
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(rdbtnAsientoParaNios)
                  .addContainerGap())
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(rdbtnAsistenciaEnCarretera)
                  .addContainerGap())
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(rdbtnGps)
                  .addContainerGap())
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addComponent(lblServicios)
                    .addComponent(rdbtnWifi))
                  .addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    .addComponent(lblTipoDeCambio)
                    .addComponent(txtTipoCambio, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                  .addGap(20))))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(136)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblSedeRecogida)
                .addComponent(lblSedeEntrega))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addComponent(txtSedeEntrega)
                .addComponent(txtSedeRecogida, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
              .addGap(48))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblDetallesDeReserva)
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblIdentificacionCliente)
                .addComponent(lblServicios)
                .addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblNombreCliente)
                .addComponent(rdbtnWifi)
                .addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblTipoDeCambio)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(txtTipoCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(labelImagenVehiculo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(scrollPaneVehiculo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(rdbtnGps)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(rdbtnAsistenciaEnCarretera)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(rdbtnAsientoParaNios)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(rdbtnCoberturaPorDaos)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblSedeRecogida)
                .addComponent(txtSedeRecogida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblSedeEntrega)
                .addComponent(txtSedeEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
              .addComponent(btnAceptar)
              .addGap(23))))
    );
    contentPane.setLayout(gl_contentPane);
  }
  
  public Date setFechaActual(){
    Calendar calendario;
    calendario = Calendar.getInstance();
    return calendario.getTime();
  }
}
