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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bussineslogic.Maintenance;
import bussineslogic.Company;

public class MaintenanceRegister extends JFrame {

  private JPanel contentPane;
  private JTextField txtIDVehiculo;
  private JTextField txtCosto;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MaintenanceRegister frame = new MaintenanceRegister();
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
  public MaintenanceRegister() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 596, 406);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblRegistroMantenimiento = new JLabel("Registro de mantenimiento");
    lblRegistroMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
    lblRegistroMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 19));
    
    JLabel lblTipo = new JLabel("Tipo:");
    lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblIdVehiculo = new JLabel("ID del vehiculo:");
    lblIdVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblFechaInicio = new JLabel("Inicio:");
    lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblFechaFinalizacion = new JLabel("Finalizacion:");
    lblFechaFinalizacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCosto = new JLabel("Costo:");
    lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblDetalle = new JLabel("Detalle:");
    lblDetalle.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCompania = new JLabel("Compañia:");
    lblCompania.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    txtIDVehiculo = new JTextField();
    txtIDVehiculo.setColumns(10);
    
    final JDateChooser dateChooserInicio = new JDateChooser();
    
    final JDateChooser dateChooserFin = new JDateChooser();
    
    txtCosto = new JTextField();
    txtCosto.setColumns(10);
    
    JScrollPane scrollPane = new JScrollPane();
    
    JComboBox comboBoxCompanys = new JComboBox();
    DefaultComboBoxModel<String> modelCompanys = new DefaultComboBoxModel<String>();    ///CREAR EL MODEL DE COMPANYS
    
    final JTextArea textAreaDetalle = new JTextArea();
    scrollPane.setViewportView(textAreaDetalle);
    
    final JComboBox comboBoxTipo = new JComboBox();
    comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Preventivo", "Correctivo"}));
    
    JButton btnRegistrarMantenimiento = new JButton("Registrar mantenimiento");
    btnRegistrarMantenimiento.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {               //Evento del boton  AGREGAR A UN VEHICULO Y ASIGANR COMPANY
        
        if(comboBoxTipo.getSelectedItem() == "Preventivo") {
          Maintenance mantenimiento = new Maintenance(true, txtIDVehiculo.getText(), dateChooserInicio.getDate(), dateChooserFin.getDate(),
              Float.parseFloat(txtCosto.getText()), textAreaDetalle.getText());
          
        }
        else {
          Maintenance mantenimiento = new Maintenance(true, txtIDVehiculo.getText(), dateChooserInicio.getDate(), dateChooserFin.getDate(),
              Float.parseFloat(txtCosto.getText()), textAreaDetalle.getText());
          
          
        }
      }
    });
    btnRegistrarMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblRegistroMantenimiento, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addComponent(lblFechaInicio)
          .addGap(74)
          .addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addComponent(lblFechaFinalizacion)
          .addGap(28)
          .addComponent(dateChooserFin, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addComponent(lblCosto)
          .addGap(72)
          .addComponent(txtCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addComponent(lblDetalle)
          .addGap(61)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblIdVehiculo)
            .addComponent(lblTipo))
          .addGap(4)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
            .addComponent(comboBoxTipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtIDVehiculo, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
          .addGap(287))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(comboBoxCompanys, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
              .addComponent(btnRegistrarMantenimiento)
              .addGap(40))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblCompania)
              .addContainerGap(481, Short.MAX_VALUE))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblRegistroMantenimiento)
          .addGap(11)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblTipo)
            .addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(11)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblIdVehiculo)
            .addComponent(txtIDVehiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(10)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(1)
              .addComponent(lblFechaInicio))
            .addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(11)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblFechaFinalizacion)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(1)
              .addComponent(dateChooserFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addGap(11)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblCosto)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(3)
              .addComponent(txtCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addGap(11)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblDetalle)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
          .addGap(4)
          .addComponent(lblCompania)
          .addGap(6)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBoxCompanys, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnRegistrarMantenimiento)))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
