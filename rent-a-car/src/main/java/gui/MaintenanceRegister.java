package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import bussineslogic.Vehicle;
import controller.Management;
import bussineslogic.Branch;
import bussineslogic.Company;

public class MaintenanceRegister extends JFrame {

  private JPanel contentPane;
  private JTextField txtCosto;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          MaintenanceRegister frame = new MaintenanceRegister(man);
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
  public MaintenanceRegister(final Management manager) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    
    final JDateChooser dateChooserInicio = new JDateChooser();
    
    final JDateChooser dateChooserFin = new JDateChooser();
    
    txtCosto = new JTextField();
    txtCosto.setColumns(10);
    
    JScrollPane scrollPane = new JScrollPane();
    
    final JComboBox comboBoxCompanys = new JComboBox();
    DefaultComboBoxModel<Company> modelCompany = new DefaultComboBoxModel<Company>();    ///CREAR EL MODEL DE COMPANYS
    for(Company compania: manager.getCompanies()) {
      modelCompany.addElement(compania);
    }
    comboBoxCompanys.setModel(modelCompany);
    
    
    final JTextArea textAreaDetalle = new JTextArea();
    scrollPane.setViewportView(textAreaDetalle);
    
    final JComboBox comboBoxTipo = new JComboBox();
    comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Preventivo", "Correctivo"}));
    
    final JComboBox comboBoxPlacas = new JComboBox();
    
    JLabel lblSede = new JLabel("Sede:");
    lblSede.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    final JComboBox comboBoxSedes = new JComboBox();
    DefaultComboBoxModel<Branch> modelSedes = new DefaultComboBoxModel<Branch>();
    for(Branch rama: manager.getBraches()) {
      modelSedes.addElement(rama);
    }
    comboBoxSedes.setModel(modelSedes);
    
    JButton btnRegistrarMantenimiento = new JButton("Registrar mantenimiento");
    btnRegistrarMantenimiento.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {               //Evento del boton  AGREGAR A UN VEHICULO Y ASIGANR COMPANYS
        
        if(comboBoxTipo.getSelectedItem() == "Preventivo") {
          if(manager.addMaintenance((Branch)comboBoxSedes.getSelectedItem(), true, ((Vehicle)comboBoxPlacas.getSelectedItem()).getVehiclePlate(),
              dateChooserInicio.getDate(), dateChooserFin.getDate(), Float.parseFloat(txtCosto.getText()), textAreaDetalle.getText(),
              (Company)comboBoxCompanys.getSelectedItem())) {
            
            JOptionPane.showMessageDialog(null, "Se registro el nuevo mantenimiento", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
          } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese vehiculo", "Error", JOptionPane.WARNING_MESSAGE);
          }
        }
        else {
          if(manager.addMaintenance((Branch)comboBoxSedes.getSelectedItem(), false, ((Vehicle)comboBoxPlacas.getSelectedItem()).getVehiclePlate(),
              dateChooserInicio.getDate(), dateChooserFin.getDate(), Float.parseFloat(txtCosto.getText()), textAreaDetalle.getText(),
              (Company)comboBoxCompanys.getSelectedItem())) {
            
            JOptionPane.showMessageDialog(null, "Se registro el nuevo mantenimiento", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
          } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese vehiculo", "Error", JOptionPane.WARNING_MESSAGE);
          }
        }
      }
    });
    btnRegistrarMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    
    
    JButton btnActualizar = new JButton("Actualizar placas");
    btnActualizar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        Branch miRama = (Branch)comboBoxSedes.getSelectedItem();
        DefaultComboBoxModel<Vehicle> modelPlacas = new DefaultComboBoxModel<Vehicle>();
        for(Vehicle carro: miRama.getVehicles()) {
          modelPlacas.addElement(carro);
        }
        comboBoxPlacas.setModel(modelPlacas);
      }
    });
    btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblRegistroMantenimiento, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
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
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblCompania)
              .addContainerGap(481, Short.MAX_VALUE))
            .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
              .addComponent(comboBoxCompanys, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addComponent(lblSede)
                .addComponent(btnRegistrarMantenimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxSedes, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, Alignment.TRAILING))
              .addGap(40))))
        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblIdVehiculo)
            .addComponent(lblTipo))
          .addGap(4)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(comboBoxPlacas, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(303, Short.MAX_VALUE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(10)
          .addComponent(lblFechaInicio)
          .addGap(74)
          .addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblRegistroMantenimiento)
          .addGap(11)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblTipo)
            .addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSede))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(11)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblIdVehiculo)
                .addComponent(comboBoxPlacas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
              .addComponent(lblCompania))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(comboBoxSedes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(btnActualizar)))
          .addGap(6)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBoxCompanys, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnRegistrarMantenimiento)))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
