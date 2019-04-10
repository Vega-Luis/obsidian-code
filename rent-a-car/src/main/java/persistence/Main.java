package persistence;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import bussineslogic.Address;
import bussineslogic.Branch;
import bussineslogic.Client;
import bussineslogic.Company;
import bussineslogic.Employee;
import bussineslogic.Maintenance;
import bussineslogic.Reserve;
import bussineslogic.Service;
import bussineslogic.Vehicle;
import util.Chyperer;

/**
 * Clase main pruebas persistenia, se va a remover en un futuro
 * @author Marcosmh0199
 * 
 */
public class Main {

  public static void main(String[] args) throws Exception {
    
    Chyperer encrypt = new Chyperer("123456789ABCDEFG");
    Address address = new Address("Chepe","PZ","Platanares","Cerca escuela molle");
    Calendar calendar = Calendar.getInstance();
    Date date1 = calendar.getTime();
    Image picture = ImageIO.read(new File("C:\\Users\\Marcosmh0199\\Documents\\AS ESPADAS.png"));
    ArrayList<Client> clients;
    
    Client client = new Client("Marcos","117","8511","gmail",address);
    client.addLicense(client.getId(),date1,date1, picture);
    client.addLicense(client.getId(),date1,date1, picture);
    
    Client client2 = new Client("Pepe","117","8511","gmail",address);
    client2.addLicense(client.getId(),date1,date1, picture);
    client2.addLicense(client.getId(),date1,date1, picture);
    Persistence persistence = new Persistence();
    
    //persistence.saveClient(client);
    //persistence.saveClient(client2);
    
    clients= persistence.loadClients();
    for(int i = 0; i < clients.size(); i++) {
      //System.out.println(clients.get(i)+"\n\n");
    }
    
    Employee employee = new Employee("Marcos","117","8511","marcos@gmail");
    Employee employee2 = new Employee("Luis","117","8511","luis@gmail");
    
    //persistence.saveEmployee(employee);
    //persistence.saveEmployee(employee2);
    
    ArrayList<Employee> employees = persistence.loadEmployees();
    for(int i = 0; i < employees.size(); i++) {
      //System.out.println(employees.get(i)+"\n\n");
    }
    Branch branch1 = new Branch("Cartago",address);
    Branch branch2 = new Branch("PEREZ",address);
    Company company = new Company("HOLA", "COMO","ESTA");
    Vehicle vehicle = new Vehicle("12345", date1, "ROJO", (byte)4, "Nissan", (byte)2, "6789", (float)0, (float)230000.23, (byte)4, false);
    Vehicle vehicle2 = new Vehicle("12345", date1, "VERDE", (byte)4, "Toyota", (byte)2, "6789", (float)0, (float)230000.23, (byte)4, false);
    vehicle.setVehicleImage(picture);
    vehicle2.setVehicleImage(picture);
    vehicle.getMaintenances().add(new Maintenance(true,vehicle.getVehiclePlate(),date1,date1, (float)5000, "Test", company));
    vehicle2.getMaintenances().add(new Maintenance(true,vehicle.getVehiclePlate(),date1,date1, (float)5000, "Test", company));
    
    branch1.add(vehicle);
    branch1.add(vehicle2);
    branch2.add(vehicle2);
    branch2.add(vehicle);
    
    ArrayList<Branch> branches = new ArrayList<Branch>();
    branches.add(branch1);
    branches.add(branch2);
    
    persistence.updateBranchVehicles(branches);
    
    //persistence.saveBranch(branch1);
    //persistence.saveBranch(branch2);
    //ArrayList<Branch> branches = persistence.loadBranches();
    //persistence.updateBranchVehicles(branches);
    

    //branches = persistence.loadBranches();
    //System.out.println(branches.get(1).getVehicles().size());
    //System.out.println(branches.get(1).getVehicles().get(0).getMaintenances().get(0).getCompany().getBussinesName());
    
    //persistence.saveCompany(company);
    //persistence.saveCompany(company);
    //persistence.saveCompany(company);
    
    ArrayList<Company> companies = persistence.loadCompanies();
    for(int i = 0; i < companies.size(); i++) {
      //System.out.println(companies.get(i).getBussinesName());
    }
    Service service = new Service(true, true, false, true, false);
    //persistence.saveReserve(branch1, branch2, service, client2, employee2, vehicle2, date1, date1, date1);
    //System.out.println(encrypt.decrypt("sxI4PHSamfwGCAZo0P9ieHKfCq02T7D1DWAZkLxis3c="));
    ArrayList<Reserve> reserves = persistence.loadReserves();
  }

}
