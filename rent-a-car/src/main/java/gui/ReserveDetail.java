package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import bussineslogic.Reserve;
import controller.Management;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ReserveDetail extends JFrame {

  private JPanel contentPane;
  private JTextField txtFechaRegistro;
  private JTextField txtFechaFinal;
  private JTextField txtFechaInicio;
  private JTextField txtNombreCliente;
  private JTextField txtIdCliente;
  private JTextField txtSedeRecogida;
  private JTextField txtSedeEntrega;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Management man = new Management();
          ReserveDetail frame = new ReserveDetail(man);
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
  public ReserveDetail(Management manager) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 633, 610);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblDetalleDeReserva = new JLabel("Detalle de reserva");
    lblDetalleDeReserva.setFont(new Font("Tahoma", Font.PLAIN, 19));
    lblDetalleDeReserva.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel lblReserva = new JLabel("Reserva:");
    lblReserva.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblFechaInicio = new JLabel("Fecha de inicio:");
    lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblFechaFinal = new JLabel("Fecha final:");
    lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblFechaRegistro = new JLabel("Fecha de registro:");
    lblFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblServicios = new JLabel("Servicios");
    lblServicios.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblCliente = new JLabel("Cliente:");
    lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblIdentificacion = new JLabel("Identificacion:");
    lblIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblVehiculo = new JLabel("Vehiculo:");
    lblVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    final JTextArea textAreaVehiculo = new JTextArea();
    
    final JLabel lblImagenVehiculo = new JLabel("");
    
    final JRadioButton rdbtnWifi = new JRadioButton("Wifi");
    rdbtnWifi.setEnabled(false);
    rdbtnWifi.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnGps = new JRadioButton("GPS");
    rdbtnGps.setEnabled(false);
    rdbtnGps.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnAsistenciaEnCarretera = new JRadioButton("Asistencia en carretera");
    rdbtnAsistenciaEnCarretera.setEnabled(false);
    rdbtnAsistenciaEnCarretera.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnAsientoParaNios = new JRadioButton("Asiento para niños");
    rdbtnAsientoParaNios.setEnabled(false);
    rdbtnAsientoParaNios.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    final JRadioButton rdbtnCoberturaPorDao = new JRadioButton("Cobertura por daño de terceros");
    rdbtnCoberturaPorDao.setEnabled(false);
    rdbtnCoberturaPorDao.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblSedeRecogida = new JLabel("Sede de recogida:");
    lblSedeRecogida.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblSedeEntrega = new JLabel("Sede de entrega:");
    lblSedeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    txtFechaRegistro = new JTextField();
    txtFechaRegistro.setColumns(10);
    
    txtFechaFinal = new JTextField();
    txtFechaFinal.setColumns(10);
    
    txtFechaInicio = new JTextField();
    txtFechaInicio.setColumns(10);
    
    final JComboBox comboBoxReservas = new JComboBox();
    DefaultComboBoxModel<Reserve> modelReservas = new DefaultComboBoxModel<Reserve>();
    for(Reserve reserva : manager.getReserves()) {
      modelReservas.addElement(reserva);
    }
    comboBoxReservas.setModel(modelReservas);
    
    txtNombreCliente = new JTextField();
    txtNombreCliente.setColumns(10);
    
    txtIdCliente = new JTextField();
    txtIdCliente.setColumns(10);
    
    txtSedeRecogida = new JTextField();
    txtSedeRecogida.setColumns(10);
    
    txtSedeEntrega = new JTextField();
    txtSedeEntrega.setColumns(10);
    
    JButton btnActualizarDatosDe = new JButton("Actualizar datos de reserva");
    btnActualizarDatosDe.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Reserve miReserve = (Reserve) comboBoxReservas.getSelectedItem();
        txtFechaInicio.setText(getFechaFormat(miReserve.getStartDate()));
        txtFechaFinal.setText(getFechaFormat(miReserve.getEndDate()));
        txtFechaRegistro.setText(getFechaFormat(miReserve.getRequestDate()));
        txtNombreCliente.setText(miReserve.getClient().getName());
        txtIdCliente.setText(miReserve.getClient().getId());
        textAreaVehiculo.setText(miReserve.getVehicle().DataSelection());
        lblImagenVehiculo.setIcon(new ImageIcon(miReserve.getVehicle().getVehicleImage()));
        rdbtnWifi.setSelected(miReserve.getService().getWifi());
        rdbtnGps.setSelected(miReserve.getService().getGps());
        rdbtnAsistenciaEnCarretera.setSelected(miReserve.getService().getRouteAssistance());
        rdbtnAsientoParaNios.setSelected(miReserve.getService().getChildSeat());
        rdbtnCoberturaPorDao.setSelected(miReserve.getService().getEnsurance());
        txtSedeRecogida.setText(miReserve.getCollectionBranc().getName());
        txtSedeEntrega.setText(miReserve.getDeliveryBranch().getName());
      }
    });
    btnActualizarDatosDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
    
    
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(lblDetalleDeReserva, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblIdentificacion)
          .addContainerGap(508, Short.MAX_VALUE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lblCliente)
            .addComponent(lblVehiculo)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblFechaRegistro)
                .addComponent(lblFechaFinal)
                .addComponent(lblFechaInicio)
                .addComponent(lblReserva)
                .addComponent(lblNombre))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addComponent(txtNombreCliente)
                .addComponent(comboBoxReservas, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFechaInicio)
                .addComponent(txtFechaFinal)
                .addComponent(txtFechaRegistro, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addComponent(txtIdCliente)))
            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
              .addComponent(lblImagenVehiculo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(textAreaVehiculo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(63)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblSedeEntrega)
                .addComponent(lblSedeRecogida)
                .addComponent(rdbtnAsientoParaNios)
                .addComponent(rdbtnAsistenciaEnCarretera)
                .addComponent(rdbtnGps)
                .addComponent(rdbtnWifi)
                .addComponent(lblServicios)
                .addComponent(rdbtnCoberturaPorDao)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                  .addComponent(txtSedeEntrega, Alignment.LEADING)
                  .addComponent(txtSedeRecogida, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
              .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(btnActualizarDatosDe)
              .addGap(53))))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lblDetalleDeReserva)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblReserva)
            .addComponent(lblServicios)
            .addComponent(comboBoxReservas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblFechaInicio)
            .addComponent(rdbtnWifi)
            .addComponent(txtFechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblFechaFinal)
            .addComponent(rdbtnGps)
            .addComponent(txtFechaFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblFechaRegistro)
            .addComponent(rdbtnAsistenciaEnCarretera)
            .addComponent(txtFechaRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(18)
              .addComponent(lblCliente)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblIdentificacion)
                .addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addGap(18)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblVehiculo)
                .addComponent(lblSedeRecogida)))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(2)
              .addComponent(rdbtnAsientoParaNios)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(rdbtnCoberturaPorDao)))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(textAreaVehiculo, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblImagenVehiculo, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
              .addContainerGap())
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(txtSedeRecogida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addGap(9)
              .addComponent(lblSedeEntrega)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(txtSedeEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
              .addComponent(btnActualizarDatosDe)
              .addGap(80))))
    );
    contentPane.setLayout(gl_contentPane);
  }
  
  public String getFechaFormat(Date fecha){
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fecha);
  }
}
