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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ServiceSelection extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ServiceSelection frame = new ServiceSelection();
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
  public ServiceSelection(final Management manager, final Client cliente, final DestinyDelivery datos, final Vehicle vahicle, final Employee empleado) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 403, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblServicios = new JLabel("Servicios");
    lblServicios.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblServicios.setHorizontalAlignment(SwingConstants.CENTER);
    
    final JRadioButton rdbtnWifi = new JRadioButton("Wifi");
    rdbtnWifi.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnAsistenteRuta = new JRadioButton("Asistencia en carretera");
    rdbtnAsistenteRuta.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnGps = new JRadioButton("GPS");
    rdbtnGps.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnAsientoParaNio = new JRadioButton("Asiento para niño");
    rdbtnAsientoParaNio.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnCoberturaPorDao = new JRadioButton("Cobertura por daño de terceros");
    rdbtnCoberturaPorDao.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Service servicio = new Service(rdbtnWifi.isSelected(), rdbtnAsistenteRuta.isSelected(), rdbtnGps.isSelected(),
            rdbtnAsientoParaNio.isSelected(), rdbtnCoberturaPorDao.isSelected());
        
        DetailShow detalles = null;
        
        try {
          detalles = new DetailShow(manager, cliente, datos, vahicle, servicio, empleado);
        } catch (NumberFormatException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        } catch (ParserConfigurationException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        } catch (SAXException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        detalles.setVisible(true);
        setVisible(false);
      }
    });
    btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblServicios, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(rdbtnWifi)
            .addComponent(rdbtnAsistenteRuta)
            .addComponent(rdbtnGps)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(rdbtnAsientoParaNio)
              .addGap(107)
              .addComponent(btnAceptar))
            .addComponent(rdbtnCoberturaPorDao))
          .addContainerGap())
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblServicios)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(rdbtnWifi)
              .addGap(18)
              .addComponent(rdbtnAsistenteRuta)
              .addGap(18)
              .addComponent(rdbtnGps)
              .addGap(18)
              .addComponent(rdbtnAsientoParaNio)
              .addGap(18)
              .addComponent(rdbtnCoberturaPorDao)
              .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(btnAceptar)
              .addGap(85))))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
