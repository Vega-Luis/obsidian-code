package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import bussineslogic.VehicleStyle;
import controller.Management;
import bussineslogic.VehicleState;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import bussineslogic.Vehicle;
import bussineslogic.Branch;
import javax.swing.JFileChooser;

public class RegisterVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField txtColor;
	private JTextField txtMarca;
	private JTextField txtKilometraje;
	private JTextField txtPuertas;
	private JTextField txtCapacidad;
	private JTextField txtNumeroVin;
	private JTextField txtMillasPorGalon;
	private JTextField txtPrecio;
	private JTextField txtMaletas;
	private JTextField txtPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				  Management man = new Management();
				  RegisterVehicle frame = new RegisterVehicle(man);
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
	public RegisterVehicle(final Management manager) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 921, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRegistroDeVehiculo = new JLabel("Registro de vehiculo");
		lblRegistroDeVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRegistroDeVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblFechaDeFabricacion = new JLabel("Fecha de fabricación:");
		lblFechaDeFabricacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblKilometraje = new JLabel("Kilometraje:");
		lblKilometraje.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNumeroDePuertas = new JLabel("Número de puertas:");
		lblNumeroDePuertas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNumeroVin = new JLabel("Número vin:");
		lblNumeroVin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblMillasPorGalon = new JLabel("Millas por galon:");
		lblMillasPorGalon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCapacidadDeMaletas = new JLabel("Capacidad de maletas:");
		lblCapacidadDeMaletas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblTransmision = new JLabel("Transmision:");
		lblTransmision.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboBoxTrasmision = new JComboBox();
		comboBoxTrasmision.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automatico"}));
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		
		JLabel lblEstilo = new JLabel("Estilo:");
		lblEstilo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboBoxEstilo = new JComboBox();
		DefaultComboBoxModel<VehicleStyle> moldelEstilo = new DefaultComboBoxModel<VehicleStyle>();
		for(VehicleStyle estilo: VehicleStyle.values()) {
		  moldelEstilo.addElement(estilo);
		  
		}
		comboBoxEstilo.setModel(moldelEstilo);
		DefaultComboBoxModel<VehicleState> modelEstado = new DefaultComboBoxModel<VehicleState>();
		for(VehicleState estado: VehicleState.values()) {
		  modelEstado.addElement(estado);
		}
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		
		txtKilometraje = new JTextField();
		txtKilometraje.setColumns(10);
		
		txtPuertas = new JTextField();
		txtPuertas.setColumns(10);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(10);
		
		txtNumeroVin = new JTextField();
		txtNumeroVin.setColumns(10);
		
		txtMillasPorGalon = new JTextField();
		txtMillasPorGalon.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		
		txtMaletas = new JTextField();
		txtMaletas.setColumns(10);
		
		JLabel lblSede = new JLabel("Sede:");
		lblSede.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		final JComboBox comboBoxSede = new JComboBox();
		DefaultComboBoxModel<Branch> modelSede = new DefaultComboBoxModel<Branch>();    //Agregar las sedes a la jugada
		for(Branch rama: manager.getBraches()) {
		  modelSede.addElement(rama);
		}
		comboBoxSede.setModel(modelSede);
		
		txtPlaca = new JTextField();
        txtPlaca.setColumns(10);
        
        final JFileChooser fileChooserImagen = new JFileChooser();
        
        JLabel lblImagen = new JLabel("Imagen:");
        lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		JButton btnRegistrarVehiculo = new JButton("Registrar vehiculo");
		btnRegistrarVehiculo.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {             //Evento boton  FALTA EL ESTILO Y EL ESTADO Y LA SEDE
		    BufferedImage imagen;
	        try {
	          imagen = ImageIO.read(new File(fileChooserImagen.getSelectedFile().getPath()));   //Lee la imagen del fileChooser.
	          if(comboBoxTrasmision.getSelectedItem() == "Manual") {
	            if(manager.addVehicle((Branch)comboBoxSede.getSelectedItem(), txtPlaca.getText(), dateChooser.getDate(), txtColor.getText(),
	                Byte.parseByte(txtCapacidad.getText()), txtMarca.getText(), Byte.parseByte(txtPuertas.getText()), txtNumeroVin.getText(),
	                Float.parseFloat(txtMillasPorGalon.getText()), Float.parseFloat(txtPrecio.getText()), Byte.parseByte(txtMaletas.getText()),
	                false, imagen, (VehicleStyle) comboBoxEstilo.getSelectedItem())) {
	              
	              JOptionPane.showMessageDialog(null, "Se registro el nuevo vehiculo", "Successfull", JOptionPane.INFORMATION_MESSAGE);
	              setVisible(false);
	              
	              } else {
	                JOptionPane.showMessageDialog(null, "Ya existe ese vehiculo", "Error", JOptionPane.WARNING_MESSAGE);
	              }
	           
	          } else {
	            if(manager.addVehicle((Branch)comboBoxSede.getSelectedItem(), txtPlaca.getText(), dateChooser.getDate(), txtColor.getText(),
                    Byte.parseByte(txtCapacidad.getText()), txtMarca.getText(), Byte.parseByte(txtPuertas.getText()), txtNumeroVin.getText(),
                    Float.parseFloat(txtMillasPorGalon.getText()), Float.parseFloat(txtPrecio.getText()), Byte.parseByte(txtMaletas.getText()),
                    true, imagen, (VehicleStyle) comboBoxEstilo.getSelectedItem())) {
                  
                  JOptionPane.showMessageDialog(null, "Se registro el nuevo vehiculo", "Successfull", JOptionPane.INFORMATION_MESSAGE);
                  setVisible(false);
                  
                  } else {
                    JOptionPane.showMessageDialog(null, "Ya existe ese vehiculo", "Error", JOptionPane.WARNING_MESSAGE);
                  }
	          }
	          
	        } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
		  }
		});
		btnRegistrarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		  gl_contentPane.createParallelGroup(Alignment.TRAILING)
		    .addComponent(lblRegistroDeVehiculo, GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addContainerGap()
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addComponent(lblPlaca)
		        .addComponent(lblMarca)
		        .addComponent(lblKilometraje)
		        .addComponent(lblNumeroDePuertas)
		        .addComponent(lblNumeroVin)
		        .addComponent(lblMillasPorGalon)
		        .addComponent(lblPrecio)
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addComponent(lblCapacidadDeMaletas)
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addComponent(txtMaletas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		          .addGroup(gl_contentPane.createSequentialGroup()
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		              .addComponent(lblFechaDeFabricacion)
		              .addComponent(lblColor)
		              .addComponent(lblCapacidad))
		            .addGap(18)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		              .addComponent(txtCapacidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		                .addComponent(txtColor)
		                .addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		                .addComponent(txtMarca)
		                .addComponent(txtPlaca)
		                .addComponent(txtNumeroVin)
		                .addComponent(txtKilometraje)
		                .addComponent(txtPuertas)
		                .addComponent(txtMillasPorGalon)
		                .addComponent(txtPrecio))))
		          .addGroup(gl_contentPane.createSequentialGroup()
		            .addComponent(lblTransmision)
		            .addGap(79)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		              .addComponent(comboBoxTrasmision, 0, 178, Short.MAX_VALUE)
		              .addComponent(comboBoxEstilo, Alignment.LEADING, 0, 178, Short.MAX_VALUE))))
		        .addComponent(lblEstilo))
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addGap(87)
		          .addComponent(btnRegistrarVehiculo))
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addGap(77)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		            .addComponent(fileChooserImagen, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblSede)
		            .addComponent(comboBoxSede, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblImagen))))
		      .addGap(111))
		);
		gl_contentPane.setVerticalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addComponent(lblRegistroDeVehiculo)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		            .addGroup(gl_contentPane.createSequentialGroup()
		              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                .addComponent(lblPlaca)
		                .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		              .addPreferredGap(ComponentPlacement.RELATED)
		              .addComponent(lblFechaDeFabricacion))
		            .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblColor)
		            .addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblImagen)))
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addComponent(lblSede)
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addComponent(comboBoxSede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
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
		            .addComponent(lblNumeroDePuertas)
		            .addComponent(txtPuertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblNumeroVin)
		            .addComponent(txtNumeroVin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblMillasPorGalon)
		            .addComponent(txtMillasPorGalon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblPrecio)
		            .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblCapacidadDeMaletas)
		            .addComponent(txtMaletas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblTransmision)
		            .addComponent(comboBoxTrasmision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblEstilo)
		            .addComponent(comboBoxEstilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addComponent(fileChooserImagen, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
		          .addPreferredGap(ComponentPlacement.UNRELATED)
		          .addComponent(btnRegistrarVehiculo)))
		      .addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
