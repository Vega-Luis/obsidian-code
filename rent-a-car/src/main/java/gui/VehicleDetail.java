package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import bussineslogic.Vehicle;

public class VehicleDetail extends JFrame {

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
  private JTextField txtPlaca;
  private JTextField txtSede;
  private JTextField txtEstilo;
  private JTextField txtEstado;
  private JTextField txtTransmision;

  /**
   * Launch the application.
   */
  /*public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          VehicleDetail frame = new VehicleDetail(man.getBraches().get(0).getVehicles().get(0));
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
  public VehicleDetail(Vehicle vehicle, final DestinyDelivery datos) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 736, 498);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblEditarDatosVehiculos = new JLabel("Datos de Vehiculo");
    lblEditarDatosVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblEditarDatosVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblPlaca = new JLabel("Placa:");
    lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    
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
    
    final JDateChooser dateChooserAno = new JDateChooser();
    dateChooserAno.setDate(vehicle.getFabricationDate());
    dateChooserAno.setEnabled(false);
                                                        //Agregar datos al allar la placa
    txtColor = new JTextField();
    txtColor.setText(vehicle.getColor());
    txtColor.setEditable(false);
    txtColor.setColumns(10);
    
    txtCapacidad = new JTextField();
    txtCapacidad.setText("" + vehicle.getCapacity());
    txtCapacidad.setEditable(false);
    txtCapacidad.setColumns(10);
    
    txtMarca = new JTextField();
    txtMarca.setText(vehicle.getBrand());
    txtMarca.setEditable(false);
    txtMarca.setColumns(10);
    
    txtKilometraje = new JTextField();
    txtKilometraje.setText("" + vehicle.getKilometers());
    txtKilometraje.setEditable(false);
    txtKilometraje.setColumns(10);
    
    txtPuertas = new JTextField();
    txtPuertas.setText("" + vehicle.getDoors());
    txtPuertas.setEditable(false);
    txtPuertas.setColumns(10);
    
    txtNumVin = new JTextField();
    txtNumVin.setText(vehicle.getVinNumber());
    txtNumVin.setEditable(false);
    txtNumVin.setColumns(10);
    
    txtMaletas = new JTextField();
    txtMaletas.setText("" + vehicle.getSuitcaseCapacity());
    txtMaletas.setEditable(false);
    txtMaletas.setColumns(10);
    
    txtPrecio = new JTextField();
    txtPrecio.setText("" + (long)vehicle.getPrice());
    txtPrecio.setEditable(false);
    txtPrecio.setColumns(10);
    
    txtMillasGalon = new JTextField();
    txtMillasGalon.setText("" + vehicle.getMpg());
    txtMillasGalon.setEditable(false);
    txtMillasGalon.setColumns(10);
    
    txtPlaca = new JTextField();
    txtPlaca.setText(vehicle.getVehiclePlate());;
    txtPlaca.setEditable(false);
    txtPlaca.setColumns(10);
    
    txtSede = new JTextField();
    txtSede.setText(datos.getSedeRecogida().getName());
    txtSede.setEditable(false);
    txtSede.setColumns(10);
    
    txtEstilo = new JTextField();
    txtEstilo.setText("" + vehicle.getStyle());
    txtEstilo.setEditable(false);
    txtEstilo.setColumns(10);
    
    txtEstado = new JTextField();
    txtEstado.setText("" + vehicle.getState());
    txtEstado.setEditable(false);
    txtEstado.setColumns(10);
    
    txtTransmision = new JTextField();
    if(vehicle.isTransmission()) {
      txtTransmision.setText("Automatico");
    } else {
      txtTransmision.setText("Manual");
    }
    txtTransmision.setEditable(false);
    txtTransmision.setColumns(10);
    
    JButton btnEditar = new JButton("Aceptar");
    btnEditar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });
    btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    
    
    
    
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
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
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(txtEstado, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtEstilo, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtKilometraje, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtMarca, 155, 155, Short.MAX_VALUE)
                .addComponent(txtCapacidad, 155, 155, Short.MAX_VALUE)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                  .addComponent(dateChooserAno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(txtColor, Alignment.LEADING, 155, 155, Short.MAX_VALUE))
                .addComponent(txtPuertas, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtNumVin, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtMillasGalon, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtPrecio, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtMaletas, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(txtTransmision, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
              .addGap(86)
              .addComponent(lblSede)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addGap(122)
                  .addComponent(btnEditar))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(txtSede, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
              .addGap(86))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
              .addContainerGap())))
        .addComponent(lblEditarDatosVehiculos, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblEditarDatosVehiculos)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPlaca)
            .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblFechaFabricacion)
                .addComponent(dateChooserAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblPrecio, Alignment.TRAILING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                  .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addGap(11))))
            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
              .addComponent(lblSede)
              .addComponent(txtSede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblCapacidadMaletas)
                .addComponent(txtMaletas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblTransmision)
                .addComponent(txtTransmision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblEstilo)
                .addComponent(txtEstilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblEstado)
                .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(btnEditar)
              .addGap(29))))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
