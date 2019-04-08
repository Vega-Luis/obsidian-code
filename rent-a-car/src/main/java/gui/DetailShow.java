package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailShow extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
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
  }

  /**
   * Create the frame.
   */
  public DetailShow() {                                 //Adaptarlo a que reciba un cliente, un vehiculo y un services
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 727, 381);
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
    
    JLabel labelImagenVehiculo = new JLabel("");
    
    
    
    
    JScrollPane scrollPaneVehiculo = new JScrollPane();
    JTextArea textAreaVehiculo = new JTextArea();
    scrollPaneVehiculo.setViewportView(textAreaVehiculo);
    
    JLabel lblServicios = new JLabel("Servicios:");
    lblServicios.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JScrollPane scrollPaneServicios = new JScrollPane();
    JTextArea textAreaServicios = new JTextArea();
    scrollPaneServicios.setViewportView(textAreaServicios);
    
    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {              //Evento del boton
        //Debria utilizar todos los datos y agregar la nueva reserva e imprimirla.
        
      }
    });
    btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblDetallesDeReserva, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblIdentificacionCliente)
          .addContainerGap(505, Short.MAX_VALUE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblNombreCliente)
          .addContainerGap(546, Short.MAX_VALUE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(labelImagenVehiculo, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollPaneVehiculo, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(109)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPaneServicios, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblServicios))
              .addGap(61))
            .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(btnAceptar)
              .addGap(146))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblDetallesDeReserva)
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblIdentificacionCliente)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(lblNombreCliente)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(labelImagenVehiculo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(scrollPaneVehiculo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblServicios)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(scrollPaneServicios, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
              .addGap(36)
              .addComponent(btnAceptar)))
          .addContainerGap(14, Short.MAX_VALUE))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
