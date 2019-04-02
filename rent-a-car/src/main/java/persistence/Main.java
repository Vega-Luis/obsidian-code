package persistence;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import bussineslogic.Address;
import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Vehicle;

/**
 * Clase main pruebas persistenia, se va a remover en un futuro
 * @author Marcosmh0199
 *
 */
public class Main {

  public static void main(String[] args) throws Exception {
    Address address = new Address("Chepe","PZ","Platanares","Cerca escuela molle");
    Client client = new Client("Marcos","117","8511","gmail",address);
    Calendar calendar = Calendar.getInstance();
    Date date1 = calendar.getTime();
    Image picture = ImageIO.read(new File("C:\\Users\\Marcosmh0199\\Documents\\AS ESPADAS.png"));
    ArrayList<Client> clients;
    client.addLicense(date1,date1, picture);
    client.addLicense(date1,date1, picture);
    
    Client client2 = new Client("Pepe","117","8511","gmail",address);
    client2.addLicense(date1,date1, picture);
    client2.addLicense(date1,date1, picture);
    Persistence persistence = new Persistence();
    
    //persistence.saveClient(client);
    //persistence.saveClient(client2);
    
    clients= persistence.loadClients();
    for(int i = 0; i < clients.size(); i++) {
      System.out.println(clients.get(i)+"\n\n");
    }
    
    Employee employee = new Employee("Marcos","117","8511","marcos@gmail");
    Employee employee2 = new Employee("Luis","117","8511","luis@gmail");
    
    //persistence.saveEmployee(employee);
    //persistence.saveEmployee(employee2);
    
    ArrayList<Employee> employees = persistence.loadEmployees();
    for(int i = 0; i < employees.size(); i++) {
      System.out.println(employees.get(i)+"\n\n");
    }
    
    Color color = new Color(89);
    Vehicle vehicle = new Vehicle("12345", date1, color, (byte)4, "Nissan", (byte)2, "6789", (float)0, (float)230000.23, (byte)4, false);
    Vehicle vehicle2 = new Vehicle("12345", date1, color, (byte)4, "Toyota", (byte)2, "6789", (float)0, (float)230000.23, (byte)4, false);
    vehicle.setVehicleImage(picture);
    vehicle2.setVehicleImage(picture);
    
    //persistence.saveVehicle(vehicle);
    //persistence.saveVehicle(vehicle2);
    
    ArrayList<Vehicle> vehicles = persistence.loadVehicles();
    for(int i = 0; i < vehicles.size(); i++) {
      System.out.println(vehicles.get(i).getVehicleImage().toString()+"\n\n");
    }
    
  }

}
