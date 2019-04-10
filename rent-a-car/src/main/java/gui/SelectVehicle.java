package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bussineslogic.Branch;
import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Vehicle;
import bussineslogic.VehicleState;
import controller.Management;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SelectVehicle extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          SelectVehicle frame = new SelectVehicle(man, man.getClient(0));
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
  public SelectVehicle(Management manager, Client cliente, DestinyDelivery datosEntregaRecibo, Employee empleado) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 640, 233);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JScrollPane scrollPane = new JScrollPane();
    
    JPanel panel = new JPanel();
    scrollPane.setViewportView(panel);
    
    //JPanel miPanel = new InfoVehicle(datosEntregaRecibo.getSedeRecogida().getVehicles().get(0));
    //miPanel.setBounds(0, 0, 657, 176);
    
    //JPanel miPanel1 = new InfoVehicle();
   // miPanel1.setBounds(0, 0, 657, 176);
    
    for(Vehicle carro: datosEntregaRecibo.getSedeRecogida().getVehicles()){
      if(carro.getState() != VehicleState.MANTENANCE || carro.getState() != VehicleState.INACTIVE) {
      JPanel newPanel = new InfoVehicle(carro, manager, cliente, datosEntregaRecibo, empleado);
      newPanel.setBounds(0, 0, 657, 176);
      panel.add(newPanel);
      }
    }
    
    //panel.add(miPanel);
    //panel.add(miPanel1);
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(5)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(6)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
    );
    contentPane.setLayout(gl_contentPane);
    
  }
}
