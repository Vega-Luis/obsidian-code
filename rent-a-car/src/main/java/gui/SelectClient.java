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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class SelectClient extends JFrame {

  private JPanel contentPane;
  private JTextField txtIdentificacion;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          SelectClient frame = new SelectClient(man);
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
  public SelectClient(final Management manager, final Employee empleado) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 452, 157);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblIngresarClienteDe = new JLabel("Ingresar cliente de la reserva");
    lblIngresarClienteDe.setHorizontalAlignment(SwingConstants.CENTER);
    lblIngresarClienteDe.setFont(new Font("Tahoma", Font.PLAIN, 19));
    
    JLabel lblIdentificacion = new JLabel("Identificacion:");
    lblIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    txtIdentificacion = new JTextField();
    txtIdentificacion.setColumns(10);
    
    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {           //Evento del boton   hay que verificarp el cliente
        if(manager.checkClient(txtIdentificacion.getText()) != null) {
          
          ShowClient verCliente = new ShowClient(manager, manager.checkClient(txtIdentificacion.getText()), empleado);
          verCliente.setVisible(true);
          setVisible(false);
        }
        
        else {
          JOptionPane.showMessageDialog(null, "El cliente especificado no exite", "Error", JOptionPane.WARNING_MESSAGE);
        }
      }
    });
    btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblIngresarClienteDe, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblIdentificacion)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(txtIdentificacion, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
          .addGap(155))
        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
          .addContainerGap(306, Short.MAX_VALUE)
          .addComponent(btnAceptar)
          .addGap(31))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblIngresarClienteDe)
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblIdentificacion)
            .addComponent(txtIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnAceptar)
          .addContainerGap(15, Short.MAX_VALUE))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
