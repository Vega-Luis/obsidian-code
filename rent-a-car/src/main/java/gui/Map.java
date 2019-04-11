package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import util.Path;
import util.Place;
import util.PlacesLocations;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Map extends JFrame implements PlacesLocations{

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Map frame = new Map();
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
  public Map() {
    setTitle("Comprobador Ruta");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 344, 235);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblOrigen = new JLabel("Origen");
    lblOrigen.setBounds(10, 32, 46, 14);
    contentPane.add(lblOrigen);
    
    JLabel lblDestino = new JLabel("Destino");
    lblDestino.setBounds(192, 32, 46, 14);
    contentPane.add(lblDestino);
    DefaultComboBoxModel<Place> destinyModel = new DefaultComboBoxModel<Place>();
    destinyModel.addElement(TEC);
    destinyModel.addElement(BASILICA);
    destinyModel.addElement(FRESHMARKET);
    destinyModel.addElement(MOLLEJONES);
    destinyModel.addElement(PARRILLITADEPEPE);
    destinyModel.addElement(PEQUENOMUNDO);
    destinyModel.addElement(PITALALAJUELA);
    destinyModel.addElement(TURRIALBA);
    destinyModel.addElement(UCR);
    destinyModel.addElement(WALMART);
    
    DefaultComboBoxModel<Place> originModel = new DefaultComboBoxModel<Place>();
    originModel.addElement(TEC);
    originModel.addElement(BASILICA);
    originModel.addElement(FRESHMARKET);
    originModel.addElement(MOLLEJONES);
    originModel.addElement(PARRILLITADEPEPE);
    originModel.addElement(PEQUENOMUNDO);
    originModel.addElement(PITALALAJUELA);
    originModel.addElement(TURRIALBA);
    originModel.addElement(UCR);
    originModel.addElement(WALMART);
    final JComboBox<Place> origin = new JComboBox<Place>();
    origin.setModel(originModel);
    origin.setBounds(10, 46, 137, 20);
    contentPane.add(origin);
    final JComboBox<Place> destiny = new JComboBox<Place>();
    destiny.setModel(destinyModel);
    destiny.setBounds(192, 46, 137, 20);
    contentPane.add(destiny);
    
    JButton btnComprobarRuta = new JButton("Comprobar Ruta");
    btnComprobarRuta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Path.map(((Place)origin.getSelectedItem()).getLatitude(),((Place)origin.getSelectedItem()).getLongitude(),
            ((Place)destiny.getSelectedItem()).getLatitude(), ((Place)destiny.getSelectedItem()).getLongitude());
      }
    });
    btnComprobarRuta.setBounds(10, 115, 137, 23);
    contentPane.add(btnComprobarRuta);
  }
}
