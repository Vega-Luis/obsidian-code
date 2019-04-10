package gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Vehicle;
import controller.Management;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class InfoVehicle extends JPanel {
  private JTextField txtPrecio;

  /**
   * Create the panel.
   */
  public InfoVehicle(final Vehicle vehicle, final Management manager, final Client cliente, final DestinyDelivery datos, final Employee empleado) {
    setBorder(new LineBorder(new Color(0, 0, 0)));
    
    JLabel lblImage = new JLabel("");
    lblImage.setIcon(new ImageIcon(vehicle.getVehicleImage()));
    lblImage.setHorizontalAlignment(SwingConstants.CENTER);
    
    JTextArea textAreaDatos = new JTextArea();
    textAreaDatos.setText(vehicle.DataSelection());
    
    txtPrecio = new JTextField();
    txtPrecio.setEditable(false);
    txtPrecio.setText("" + (long)vehicle.getPrice());
    txtPrecio.setColumns(10);
    
    JButton btnSeleccionar = new JButton("Seleccionar");
    btnSeleccionar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        ServiceSelection servicios = new ServiceSelection(manager, cliente, datos, vehicle, empleado);
        servicios.setVisible(true);
      }
    });
    
    JLabel lblPrecio = new JLabel("Precio");
    lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(2)
          .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(textAreaDatos, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(52)
              .addComponent(btnSeleccionar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addComponent(lblPrecio))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addComponent(txtPrecio, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
              .addContainerGap())))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(22)
              .addComponent(lblPrecio)
              .addGap(5)
              .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
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
