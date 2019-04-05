package persistence;

import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Maintenance;
import bussineslogic.Vehicle;
import bussineslogic.Address;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import javax.imageio.ImageIO;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import util.Chyperer;

/**
 * Clase para la persistencia de datos, implementa una interfaz con constantes para mejorar la
 * comprensión de la misma
 * @author Marcosmh0199
 * @version 30/03/2019
 */
public class Persistence implements Constants{
  
  Chyperer encrypt = new Chyperer("123456789ABCDEFG");
  
  public void updateData(ArrayList<Vehicle> vehicles) throws Exception {
    JSONArray jsonVehicles = new JSONArray();
    for(int i = 0; i < vehicles.size(); i++) {
      ArrayList<String> vehicleData = getVehicleData(vehicles.get(i));
      jsonVehicles.add(vehicleData);
    }
    Files.write(Paths.get("vehicles.json"), jsonVehicles.toJSONString().getBytes());
  }
  
  /**
   * Método para convertir una imagen a un string codificado en base64
   * @param image imagen que será convertida
   * @return imageToBase64 string formado a partir de la imagen
   * @throws Exception 
   * @throws IOException
   */

  private String convertImgToString(Image image) throws IOException {
    byte[] imageBytes;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ImageIO.write((RenderedImage)image, "png", output);
    imageBytes = output.toByteArray();
    String imageToBase64 = Base64.getEncoder().encodeToString(imageBytes);
    return imageToBase64;
  }
  /**
   * Método para convertir un string codificado en base64 a una imagen
   * @param imageString string que será convertido a imagen
   * @return image Imagen formada a partir del string
   * @throws IOException
   */
  private Image convertStringToImage(String imageString) throws IOException {
    String base64Image = imageString;
    byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
    Image image = ImageIO.read(new ByteArrayInputStream(imageBytes));
    return image;
  }
  public ArrayList<String> getClientData(Client client) throws Exception{
    ArrayList<String> clientData= new ArrayList<String>();
    ArrayList<String> clientLicenses = new ArrayList<String>();
    clientData.add(client.getName());
    clientData.add(client.getId());
    clientData.add(client.getTelephone());
    clientData.add(client.getMail());
    clientData.add(client.getClientAddress().getProvince());
    clientData.add(client.getClientAddress().getCanton());
    clientData.add(client.getClientAddress().getDistrict());
    clientData.add(client.getClientAddress().getSings());
    for(int i = 0; i < client.getLicenses().size(); i++) {
      SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
      clientLicenses.add(client.getLicenses().get(i).getId());
      clientLicenses.add(formatDate.format(client.getLicenses().get(i).getReleaseDate()));
      clientLicenses.add(formatDate.format(client.getLicenses().get(i).getExpireDate()));
      clientLicenses.add(convertImgToString(client.getLicenses().get(i).getImage()));
    }
    for(int i = 0; i < clientLicenses.size(); i++) {
      clientData.add(clientLicenses.get(i));
    }
    for(int i = 0; i < clientData.size(); i++) {
      clientData.set(i, encrypt.encrypt(clientData.get(i)));
    }

    return clientData;
  }
  /**
   * Método para guardar un cliente en un archivo .json
   * @param client cliente que será guardado
   * @throws Exception
   */
  public void saveClient(Client client) throws Exception {  
    ArrayList<String> clientData = getClientData(client); 
    try {
      JSONParser parser = new JSONParser();
      JSONArray clients = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\clients.json"));
      clients.add(clientData);
      Files.write(Paths.get("C:\\JSONFiles\\clients.json"), clients.toJSONString().getBytes());
    }catch(Exception d) {
      File dir = new File("C:\\JSONFiles");
      dir.mkdir();
      JSONArray clients = new JSONArray();
      clients.add(clientData);
      Files.write(Paths.get("C:\\JSONFiles\\clients.json"), clients.toJSONString().getBytes());
      }
  } 
  
  /**
   * Método para cargar los clientes previamente registrados
   * @return clients ArrayList que contiene todos los clientes registrados
   * @throws Exception
   */
  public ArrayList<Client> loadClients() throws Exception {  
    JSONParser parser = new JSONParser();
    JSONArray clientsArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\clients.json"));
    ArrayList<String> clientData= new ArrayList<String>();
    ArrayList<Client> clients = new ArrayList<Client>();
    for(int i = 0; i < clientsArray.size(); i++) {
      clientData = (ArrayList<String>) clientsArray.get(i);
      String name = encrypt.decrypt(clientData.get(CLIENTNAME));
      String id = encrypt.decrypt(clientData.get(CLIENTID));
      String telephone = encrypt.decrypt(clientData.get(CLIENTTELEPHONE));
      String mail = encrypt.decrypt(clientData.get(CLIENTMAIL));
      String province = encrypt.decrypt(clientData.get(PROVINCE));
      String canton = encrypt.decrypt(clientData.get(CANTON));
      String district = encrypt.decrypt(clientData.get(DISTRICT));
      String sings = encrypt.decrypt(clientData.get(SINGS));
      Address address = new Address(province,canton,district,sings);
      Client client = new Client(name,id,telephone,mail,address);
      for(int j = 8; j < (clientData.size()-2); j = j+4) {
        String releaseDateString = encrypt.decrypt(clientData.get(j+1));
        String expireDateString = encrypt.decrypt(clientData.get(j+2));
        Date releaseDate = new SimpleDateFormat("dd/MM/yyyy").parse(releaseDateString);
        Date expireDate = new SimpleDateFormat("dd/MM/yyyy").parse(expireDateString);
        final Image IMAGE = convertStringToImage(encrypt.decrypt(clientData.get(j+3)));
        client.addLicense(releaseDate, expireDate, IMAGE);
      }
      clients.add(client);
    }
    return clients;
  }
  /**
   * Método para extraer datos de un empleado
   * @param employee
   * @return ArrayList que contiene los datos del empleado en strings
   * @throws Exception
   */
  public ArrayList<String> getEmployeeData(Employee employee) throws Exception{
    ArrayList<String> employeeData = new ArrayList<String>();
    employeeData.add(employee.getId());
    employeeData.add(employee.getName());
    employeeData.add(employee.getTelephone());
    employeeData.add(employee.getMail());
    employeeData.add(employee.getPassword());
    employeeData.add(employee.getUserName());
    for(int i = 0; i < employeeData.size(); i++) {
      employeeData.set(i, encrypt.encrypt(employeeData.get(i)));
    }
    return employeeData;
  }
  /**
   * Método para guardar datos de un empleado en un archivo .json
   * @param employee Empleado el cual sus datos serán guardados
   * @throws Exception 
   */
  public void saveEmployee(Employee employee) throws Exception {
    ArrayList<String> employeeData = getEmployeeData(employee);
    try {
      JSONParser parser = new JSONParser();
      JSONArray employees = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\employees.json"));
      employees.add(employeeData);
      Files.write(Paths.get("C:\\JSONFiles\\employees.json"), employees.toJSONString().getBytes());
    }catch(Exception d) {
      File dir = new File("C:\\JSONFiles");
      dir.mkdir();
      JSONArray employees = new JSONArray();
      employees.add(employeeData);
      Files.write(Paths.get("C:\\JSONFiles\\employees.json"), employees.toJSONString().getBytes());
      }
  }
  
  /**
   * Método para cargar los datos de los empleados registrados en el sistema
   * @throws Exception 
   */
  public ArrayList<Employee> loadEmployees() throws Exception {
    JSONParser parser = new JSONParser();
    JSONArray employeesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\employees.json"));
    ArrayList<String> employeeData= new ArrayList<String>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    for(int i = 0; i < employeesArray.size(); i++) {
      employeeData = (ArrayList<String>) employeesArray.get(i);
      final String id = encrypt.decrypt(employeeData.get(EMPLOYEEID));
      final String name = encrypt.decrypt(employeeData.get(EMPLOYEENAME));
      final String telephone = encrypt.decrypt(employeeData.get(EMPLOYEETELEPHONE));
      final String mail = encrypt.decrypt(employeeData.get(EMPLOYEEMAIL));
      final String password = encrypt.decrypt(employeeData.get(PASSWORD));
      final String username = encrypt.decrypt(employeeData.get(USERNAME));
      Employee employee = new Employee(name,id,telephone,mail, username, password);
      employees.add(employee);
    }
    return employees;
  }
  
  /**
   * Método para extraer los datos de un vehiculo y adaptarlos para ser guardados en un .json
   * @param vehicle vehiculo del cual se extraeran los datos
   * @return Array que contiene los datos del vehiculo en strings
   * @throws Exception
   */
  private ArrayList<String> getVehicleData(Vehicle vehicle) throws Exception{
    ArrayList<String> vehicleData = new ArrayList<String>();
    ArrayList<String> maintenanceData = new ArrayList<String>();
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
    vehicleData.add(vehicle.getVehiclePlate());
    vehicleData.add(formatDate.format(vehicle.getFabricationDate()));
    vehicleData.add(vehicle.getColor());
    vehicleData.add(Byte.toString(vehicle.getCapacity()));
    vehicleData.add(vehicle.getBrand());
    vehicleData.add(Byte.toString(vehicle.getDoors()));
    vehicleData.add(vehicle.getVinNumber());
    vehicleData.add(Float.toString(vehicle.getMpg()));
    vehicleData.add(Float.toString(vehicle.getPrice()));
    vehicleData.add(Byte.toString(vehicle.getSuitcaseCapacity()));
    vehicleData.add(Boolean.toString(vehicle.isTransmission()));
    vehicleData.add(convertImgToString(vehicle.getVehicleImage()));
    for(int i = 0; i < vehicle.getMaintenances().size(); i++) {
      maintenanceData.add(Boolean.toString(vehicle.getMaintenances().get(i).getType()));
      maintenanceData.add(vehicle.getMaintenances().get(i).getId());
      maintenanceData.add(formatDate.format(vehicle.getMaintenances().get(i).getStartDate()));
      maintenanceData.add(formatDate.format(vehicle.getMaintenances().get(i).getEndDate()));
      maintenanceData.add(Float.toString(vehicle.getMaintenances().get(i).getPrice()));
      maintenanceData.add(vehicle.getMaintenances().get(i).getDetail());
    }
    for(int i = 0; i < maintenanceData.size(); i++) {
      vehicleData.add(maintenanceData.get(i));
    }
    for(int i = 0; i < vehicleData.size(); i++) {
      vehicleData.set(i, encrypt.encrypt(vehicleData.get(i)));
    }
    for(int i = 0; i < maintenanceData.size(); i++) {
      vehicleData.set(i, encrypt.encrypt(maintenanceData.get(i)));
    }
    return vehicleData;
  }
  
  /**
   * Método para guardar un vehículo en un archivo .json
   * @param vehicle objeto tipo Vehiculo que será guardado luego de haber sido registrado
   * @throws Exception 
   */
  public void saveVehicle(Vehicle vehicle) throws Exception {
    ArrayList<String> vehicleData = getVehicleData(vehicle);
    try {
      JSONParser parser = new JSONParser();
      JSONArray vehicles = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\vehicles.json"));
      vehicles.add(vehicleData);
      Files.write(Paths.get("C:\\JSONFiles\\vehicles.json"), vehicles.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray vehicles = new JSONArray();
      vehicles.add(vehicleData);
      Files.write(Paths.get("C:\\JSONFiles\\vehicles.json"), vehicles.toJSONString().getBytes());
      }
  }
  
  /**
   * Método para cargar los vehículos previamente añadidos
   * @return ArrayList con todos los vehículos registrados hasta la fecha
   * @throws java.text.ParseException
   * @throws Exception 
   */
  public ArrayList<Vehicle> loadVehicles() throws Exception {
    JSONParser parser = new JSONParser();
    JSONArray vehiclesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Vehicles.json"));
    ArrayList<String> vehicleData= new ArrayList<String>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    for(int i = 0; i < vehiclesArray.size(); i++) {
      vehicleData = (ArrayList<String>) vehiclesArray.get(i);
      final String vehiclePlate = encrypt.decrypt(vehicleData.get(VEHICLEPLATE));
      final Date fabricationDate = new SimpleDateFormat("dd/MM/yyyy").parse(encrypt.decrypt(
          vehicleData.get(FABRICATIONDATE)));
      String color = encrypt.decrypt(vehicleData.get(COLOR));
      byte capacity = Byte.parseByte(encrypt.decrypt(vehicleData.get(CAPACITY)));
      String brand = encrypt.decrypt(vehicleData.get(BRAND));
      byte doors = Byte.parseByte(encrypt.decrypt(vehicleData.get(DOORS)));
      String vinNumber = encrypt.decrypt(vehicleData.get(VINNUMBER));
      float mpg = Float.parseFloat(encrypt.decrypt(vehicleData.get(MPG)));
      float price = Float.parseFloat(encrypt.decrypt(vehicleData.get(PRICE)));
      byte suitCapacity = Byte.parseByte(encrypt.decrypt(vehicleData.get(SUITCAPACITY)));
      boolean transmision = Boolean.parseBoolean(encrypt.decrypt(vehicleData.get(TRANSMISION)));
      Vehicle vehicle = new Vehicle(vehiclePlate, fabricationDate, color, capacity, brand, doors, 
          vinNumber, mpg, price, suitCapacity, transmision);
      vehicle.setVehicleImage(convertStringToImage(encrypt.decrypt(vehicleData.get(11))));
      for(int j = 12; j < vehicleData.size(); j = j+6) {
        boolean type = Boolean.parseBoolean(encrypt.decrypt(vehicleData.get(j)));
        String id = encrypt.decrypt(vehicleData.get(j+1));
        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(encrypt.decrypt(
            vehicleData.get(j+2)));
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(encrypt.decrypt(
            vehicleData.get(j+3)));
        float maintenancePrice = Float.parseFloat(encrypt.decrypt(vehicleData.get(j+4)));
        String detail = encrypt.decrypt(vehicleData.get(j+5));
        vehicle.getMaintenances().add(new Maintenance(type, id, startDate, endDate, maintenancePrice,
            detail));
      }
      vehicles.add(vehicle);
    }
    return vehicles;
  }
}