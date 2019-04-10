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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import bussineslogic.Vehicle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bussineslogic.VehicleState;
import bussineslogic.VehicleStyle;

public class EditVehicle extends JFrame {

  private JPanel contentPane;
  private JTextField txtColor;
  private JTextField txtCapacidad;
  private JTextField txtMarca;
  private JTextField txtKilometraje;
  private JTextField txtPuertas;
  private JTextField txtNumVin;
  private JTextField txtMaletas;
  private JTextField txtPrecio;
  private JTextField txtMillasGalon;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          EditVehicle frame = new EditVehicle();
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
  public EditVehicle() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 649, 489);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblEditarDatosVehiculos = new JLabel("Editar Datos de Vehiculos");
    lblEditarDatosVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblEditarDatosVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblPlaca = new JLabel("Placa:");
    lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JComboBox comboBoxPlacas = new JComboBox();
    DefaultComboBoxModel<Vehicle> modelPlacas = new DefaultComboBoxModel<Vehicle>();   //Poner los vehiculos con el toString con placas.
    comboBoxPlacas.setModel(modelPlacas);
    
    JLabel lblFechaFabricacion = new JLabel("Fecha de fabricacion:");
    lblFechaFabricacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblColor = new JLabel("Color:");
    lblColor.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCapacidad = new JLabel("Capacidad:");
    lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblMarca = new JLabel("Marca:");
    lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblKilometraje = new JLabel("Kilometraje:");
    lblKilometraje.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblNumeroPuertas = new JLabel("Numero de puertas:");
    lblNumeroPuertas.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblNumeroVin = new JLabel("Numero de vin:");
    lblNumeroVin.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblMillasGalon = new JLabel("Millas por galon:");
    lblMillasGalon.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblPrecio = new JLabel("Precio:");
    lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCapacidadMaletas = new JLabel("Capacidad de maletas:");
    lblCapacidadMaletas.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblTransmision = new JLabel("Transmision:");
    lblTransmision.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblEstilo = new JLabel("Estilo:");
    lblEstilo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblEstado = new JLabel("Estado:");
    lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblSede = new JLabel("Sede:");
    lblSede.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    Vehicle miVehiculo = (Vehicle)comboBoxPlacas.getSelectedItem();
    
    JDateChooser dateChooserAno = new JDateChooser();
                                                        //Agregar datos al allar la placa
    txtColor = new JTextField();
    txtColor.setColumns(10);
    
    txtCapacidad = new JTextField();
    txtCapacidad.setColumns(10);
    
    txtMarca = new JTextField();
    txtMarca.setColumns(10);
    
    txtKilometraje = new JTextField();
    txtKilometraje.setColumns(10);
    
    txtPuertas = new JTextField();
    txtPuertas.setColumns(10);
    
    txtNumVin = new JTextField();
    txtNumVin.setColumns(10);
    
    txtMaletas = new JTextField();
    txtMaletas.setColumns(10);
    
    txtPrecio = new JTextField();
    txtPrecio.setColumns(10);
    
    txtMillasGalon = new JTextField();
    txtMillasGalon.setColumns(10);
    
    JComboBox comboBoxTransmission = new JComboBox();
    comboBoxTransmission.setModel(new DefaultComboBoxModel(new String[] {"Automatica", "Manual"}));
    
    JComboBox comboBoxEstilo = new JComboBox();
    DefaultComboBoxModel<VehicleStyle> modelEstilos = new DefaultComboBoxModel<VehicleStyle>();
    for(VehicleStyle estilo: VehicleStyle.values()) {
      modelEstilos.addElement(estilo);
    }
    comboBoxEstilo.setModel(modelEstilos);
    
    JComboBox comboBoxEstado = new JComboBox();
    DefaultComboBoxModel<VehicleState> modelEstados = new DefaultComboBoxModel<VehicleState>();
    for(VehicleState estado : VehicleState.values()) {
      modelEstados.addElement(estado);
    }
    comboBoxEstado.setModel(modelEstados);
    
    JComboBox comboBoxSede = new JComboBox();
    
    
    JButton btnEditar = new JButton("Editar");
    btnEditar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {                   //Evento de boton editar
        
        
      }
    });
    btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JButton btnActualizar = new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {                  //Evento del boton actualizar
        
        
      }
    });
    
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblEditarDatosVehiculos, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addContainerGap()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblCapacidadMaletas)
                .addComponent(lblPrecio)
                .addComponent(lblMillasGalon)
                .addComponent(lblNumeroVin)
                .addComponent(lblNumeroPuertas)
                .addComponent(lblFechaFabricacion)
                .addComponent(lblPlaca)
                .addComponent(lblColor)
                .addComponent(lblCapacidad)
                .addComponent(lblMarca)
                .addComponent(lblKilometraje)
                .addComponent(lblTransmision)
                .addComponent(lblEstilo)
                .addComponent(lblEstado))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(txtPuertas, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addComponent(txtNumVin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMillasGalon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMaletas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addComponent(comboBoxEstado, 0, 155, Short.MAX_VALUE)
                    .addComponent(comboBoxEstilo, Alignment.TRAILING, 0, 155, Short.MAX_VALUE))
                  .addGap(122)
                  .addComponent(btnEditar)
                  .addGap(15))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addComponent(txtKilometraje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_contentPane.createSequentialGroup()
                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(txtMarca, 155, 155, 155)
                        .addComponent(txtCapacidad, 155, 155, 155)
                        .addComponent(txtColor, 155, 155, 155)
                        .addComponent(comboBoxPlacas, Alignment.TRAILING, 0, 155, Short.MAX_VALUE)
                        .addComponent(dateChooserAno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(comboBoxTransmission, 0, 155, Short.MAX_VALUE))
                      .addGap(24)
                      .addComponent(lblSede)))
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_contentPane.createSequentialGroup()
                      .addGap(43)
                      .addComponent(btnActualizar))
                    .addGroup(gl_contentPane.createSequentialGroup()
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(comboBoxSede, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))))))
          .addGap(71))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblEditarDatosVehiculos)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBoxPlacas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPlaca)
            .addComponent(btnActualizar))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblFechaFabricacion)
                .addComponent(lblSede)
                .addComponent(comboBoxSede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblColor)
                .addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblCapacidad)
                .addComponent(txtCapacidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblMarca)
                .addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addComponent(dateChooserAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblKilometraje)
            .addComponent(txtKilometraje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNumeroPuertas)
            .addComponent(txtPuertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNumeroVin)
            .addComponent(txtNumVin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblMillasGalon)
            .addComponent(txtMillasGalon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPrecio)
            .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblCapacidadMaletas)
                .addComponent(txtMaletas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblTransmision)
                .addComponent(comboBoxTransmission, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblEstilo)
                .addComponent(comboBoxEstilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblEstado)
                .addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(btnEditar)
              .addGap(29))))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
