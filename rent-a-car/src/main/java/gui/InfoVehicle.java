package gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import bussineslogic.Vehicle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InfoVehicle extends JPanel {

  /**
   * Create the panel.
   */
  public InfoVehicle(Vehicle vehicle) {
    setBorder(new LineBorder(new Color(0, 0, 0)));
    
    JLabel lblImage = new JLabel("");
    lblImage.setIcon(new ImageIcon(vehicle.getVehicleImage()));
    lblImage.setHorizontalAlignment(SwingConstants.CENTER);
    
    JTextArea textAreaDatos = new JTextArea();
    textAreaDatos.setText(vehicle.DataSelection());
    
    JButton btnSeleccionar = new JButton("Seleccionar");
    btnSeleccionar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        
      }
    });
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(2)
          .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(textAreaDatos, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
          .addGap(52)
          .addComponent(btnSeleccionar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(77)
              .addComponent(btnSeleccionar))
            .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(40)
              .addComponent(textAreaDatos, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(5, Short.MAX_VALUE))
    );
    setLayout(groupLayout);

  }
}
