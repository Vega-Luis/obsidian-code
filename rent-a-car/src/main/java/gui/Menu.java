package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bussineslogic.Employee;
import controller.Management;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase del menu del servicio del "rent a car".
 * 
 * @author Antony Artavia
 * @version 03/04/2019
 */
public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Creacion del frame.
	 */
	public Menu(final Management manager, final Employee empleado) {
	  setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnAgregarVehiculo = new JButton("Agregar vehiculo a flotilla");
		btnAgregarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {             //Evento del boton agregar vehiculo a flotilla.
			  //Deberia abrir una ventana para agregar vehiculos.
			  RegisterVehicle registroVehiculo = new RegisterVehicle(manager);
			  registroVehiculo.setVisible(true);
			  
			}
		});
		btnAgregarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRegistrarEmpresaNueva = new JButton("Registrar empresa nueva de servicio");
		btnRegistrarEmpresaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {             //Evento del boton de agregar una nueva empresa de servicios.
			  //Deberia abrir una ventana para agregar nuevas empresas de servicio.
			  RegisterCompany registroEmpresa = new RegisterCompany(manager);
	          registroEmpresa.setVisible(true);
			}
		});
		btnRegistrarEmpresaNueva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNuevoMantenimiento = new JButton("Nuevo Mantenimiento");
		btnNuevoMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {             //Evento del boton de agregar nuevo mantenimiento.
			  //Se deberia abrir una ventana para registrar un nuevo mantenimiento.
			  
			  MaintenanceRegister registroMantenimiento = new MaintenanceRegister(manager);
			  registroMantenimiento.setVisible(true);
			}
		});
		btnNuevoMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnEditarVehiculo = new JButton("Editar informacion de vehiculo");
		btnEditarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {             //Evento del boton editar vehiculo.
			  //Se deberia agregar una ventana para editar la info de un vehiculo.
			  EditVehicle editor = new EditVehicle(manager);
			  editor.setVisible(true);
			}
		});
		btnEditarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRealizarReserva = new JButton("Realizar reserva");
		btnRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {             //Evento del boton de reserva.
			  //Se deberia abrir una ventana para realizar el proceso de reserva
			  SelectClient inicioreserva = new SelectClient(manager, empleado);
			  inicioreserva.setVisible(true);
			}
		});
		btnRealizarReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnDetalleDeReserva = new JButton("Detalle de reservas");
		btnDetalleDeReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  //Se deberia abrir una ventana para consultar la informacion de una reserva
			  ReserveDetail detalleReserva = new ReserveDetail(manager);
			  detalleReserva.setVisible(true);
			}
		});
		btnDetalleDeReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRegistrarCliente = new JButton("Registrar nuevo cliente");
		btnRegistrarCliente.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {                //Evento del boton de registro de cliente
		    ClientRegister registroCliente = new ClientRegister(manager);
		    registroCliente.setVisible(true);
		  }
		});
		
		btnRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRegistrarEmpleado = new JButton("Registrar empleado");
		btnRegistrarEmpleado.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    EmployeetRegister registroEmpleado = new EmployeetRegister(manager, empleado);
		    registroEmpleado.setVisible(true);
		  }
		});
		btnRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton mostrarRecorrido = new JButton("Mostrar recorrido");
		mostrarRecorrido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mostrarRecorrido.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {                 //Evento de save manager
		    Map map = new Map();
		    map.setVisible(true);
		  }
		});
		
		JButton btnSalir = new JButton("Guardar y Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    manager.saveAll();
		    System.exit(0);
		  }
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addGap(40)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		            .addComponent(btnAgregarVehiculo)
		            .addComponent(btnNuevoMantenimiento)
		            .addComponent(btnRealizarReserva)
		            .addComponent(btnRegistrarCliente)
		            .addComponent(mostrarRecorrido))
		          .addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
		          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		            .addComponent(btnSalir)
		            .addComponent(btnRegistrarEmpleado)
		            .addComponent(btnDetalleDeReserva)
		            .addComponent(btnEditarVehiculo)
		            .addComponent(btnRegistrarEmpresaNueva)))
		        .addGroup(gl_contentPane.createSequentialGroup()
		          .addGap(265)
		          .addComponent(lblMenu)))
		      .addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addComponent(lblMenu)
		      .addGap(62)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnRegistrarEmpresaNueva)
		        .addComponent(btnAgregarVehiculo))
		      .addGap(41)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnNuevoMantenimiento)
		        .addComponent(btnEditarVehiculo))
		      .addGap(40)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnRealizarReserva)
		        .addComponent(btnDetalleDeReserva))
		      .addGap(42)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnRegistrarCliente)
		        .addComponent(btnRegistrarEmpleado))
		      .addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		        .addComponent(mostrarRecorrido)
		        .addComponent(btnSalir))
		      .addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
