package persistence;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import bussineslogic.Address;
import bussineslogic.Branch;
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
    Calendar calendar = Calendar.getInstance();
    Date date1 = calendar.getTime();
    Image picture = ImageIO.read(new File("C:\\Users\\Marcosmh0199\\Documents\\AS ESPADAS.png"));
    ArrayList<Client> clients;
    
    Client client = new Client("Marcos","117","8511","gmail",address);
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
    
    Vehicle vehicle = new Vehicle("12345", date1, "ROJO", (byte)4, "Nissan", (byte)2, "6789", (float)0, (float)230000.23, (byte)4, false);
    Vehicle vehicle2 = new Vehicle("12345", date1, "VERDE", (byte)4, "Toyota", (byte)2, "6789", (float)0, (float)230000.23, (byte)4, false);
    vehicle.setVehicleImage(picture);
    vehicle2.setVehicleImage(picture);
    
    //persistence.saveVehicle(vehicle);
    //persistence.saveVehicle(vehicle2);
    
    ArrayList<Vehicle> vehicles = persistence.loadVehicles();
    for(int i = 0; i < vehicles.size(); i++) {
      System.out.println(vehicles.get(i).getVehicleImage().toString()+"\n\n");
    }
    
    Branch branch1 = new Branch("Cartago",address);
    Branch branch2 = new Branch("PEREZ",address);
    branch1.setVehicles(vehicles);
    branch2.setVehicles(vehicles);
    
    //persistence.saveBranch(branch1);
    //persistence.saveBranch(branch2);
    ArrayList<Branch> branches = persistence.loadBranches();
    
    for(int i = 0; i < branches.size(); i++) {
      System.out.println(branches.get(i).getVehicles().get(i).getColor());
    }
  }

}
