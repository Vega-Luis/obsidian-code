package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import bussineslogic.Branch;
import bussineslogic.Client;
import controller.Management;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SelecDestinyBegin extends JFrame {
  
  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          SelecDestinyBegin frame = new SelecDestinyBegin(man, man.getClient(0));
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
  public SelecDestinyBegin(final Management manager, final Client cliente) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 550, 258);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblTitulo = new JLabel("Recogida y recepcion de vehiculo");
    lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblSedeRecogida = new JLabel("Sede de recogida:");
    lblSedeRecogida.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblSedeEntrega = new JLabel("Sede de entrega:");
    lblSedeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    final JComboBox comboBoxSedeRecogida = new JComboBox();
    DefaultComboBoxModel<Branch> modelSedeRecogida = new DefaultComboBoxModel<Branch>();
    for(Branch rama: manager.getBraches()) {
      modelSedeRecogida.addElement(rama);
    }
    comboBoxSedeRecogida.setModel(modelSedeRecogida);
    
    final JComboBox comboBoxSedeEntrega = new JComboBox();
    DefaultComboBoxModel<Branch> modelSedeEntrega = new DefaultComboBoxModel<Branch>();
    for(Branch rama : manager.getBraches()) {
      modelSedeEntrega.addElement(rama);
    }
    comboBoxSedeEntrega.setModel(modelSedeEntrega);
    
    JLabel lblFechaRecogida = new JLabel("Fecha de recogida:");
    lblFechaRecogida.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblFechaEntrega = new JLabel("Fecha de entrega:");
    lblFechaEntrega.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    final JDateChooser dateChooserRecogida = new JDateChooser();
    
    final JDateChooser dateChooserEntrega = new JDateChooser();
    
    JButton btnConfirmar = new JButton("Confirmar");
    btnConfirmar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        DestinyDelivery datos = new DestinyDelivery((Branch)comboBoxSedeRecogida.getSelectedItem(), (Branch)comboBoxSedeEntrega.getSelectedItem(),
            dateChooserEntrega.getDate(), dateChooserRecogida.getDate());
        
        SelectVehicle menuSelccionVehiculo = new SelectVehicle(manager, cliente, datos);
        menuSelccionVehiculo.setVisible(true);
        setVisible(false);
      }
    });
    
    btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
              .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxSedeEntrega, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxSedeRecogida, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                .addGap(10)
                .addComponent(lblSedeRecogida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addContainerGap()
              .addComponent(lblSedeEntrega)))
          .addGap(65)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
            .addComponent(dateChooserEntrega, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFechaEntrega)
            .addComponent(lblFechaRecogida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dateChooserRecogida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
          .addComponent(btnConfirmar)
          .addGap(27))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblTitulo)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(18)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblSedeRecogida)
                .addComponent(lblFechaRecogida))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(comboBoxSedeRecogida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(dateChooserRecogida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addGap(36)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblSedeEntrega)
                .addComponent(lblFechaEntrega))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(comboBoxSedeEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(dateChooserEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(78)
              .addComponent(btnConfirmar)))
          .addContainerGap(38, Short.MAX_VALUE))
    );
    contentPane.setLayout(gl_contentPane);
  }
  
}
