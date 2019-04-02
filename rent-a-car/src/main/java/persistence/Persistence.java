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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Clase para la persistencia de datos
 * @author Marcosmh0199
 * @version 30/03/2019
 */
public class Persistence {
  /**
   * Método para convertir una imagen a un string codificado en base64
   * @param image imagen que será convertida
   * @return imageToBase64 string formado a partir de la imagen
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
  /**
   * Método para guardar un cliente en un archivo .json
   * @param client cliente que será guardado
   * @throws Exception
   */
  public void saveClient(Client client) throws Exception {  
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
    try {
      JSONParser parser = new JSONParser();
      JSONArray clients = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
          + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
          + "rent-a-car\\clients.json"));
      clients.add(clientData);
      Files.write(Paths.get("clients.json"), clients.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray clients = new JSONArray();
      clients.add(clientData);
      Files.write(Paths.get("clients.json"), clients.toJSONString().getBytes());
      }
  } 
  
  /**
   * Método para cargar los clientes previamente registrados
   * @return clients ArrayList que contiene todos los clientes registrados
   * @throws Exception
   */
  public ArrayList<Client> loadClients() throws Exception {  
    JSONParser parser = new JSONParser();
    JSONArray clientsArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Doc"
        + "uments\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code"
        + "\\rent-a-car\\clients.json"));
    ArrayList<String> clientData= new ArrayList<String>();
    ArrayList<Client> clients = new ArrayList<Client>();
    for(int i = 0; i < clientsArray.size(); i++) {
      clientData = (ArrayList<String>) clientsArray.get(i);
      final String NAME = clientData.get(0);
      final String ID = clientData.get(1);
      final String TELEPHONE = clientData.get(2);
      final String MAIL = clientData.get(3);
      final String PROVINCE = clientData.get(4);
      final String CANTON = clientData.get(5);
      final String DISTRICT = clientData.get(6);
      final String SINGS = clientData.get(7);
      Address address = new Address(PROVINCE,CANTON,DISTRICT,SINGS);
      Client client = new Client(NAME,ID,TELEPHONE,MAIL,address);
      for(int j = 8; j < (clientData.size()-2); j = j+4) {
        final Date RELEASEDATE = new SimpleDateFormat("dd/MM/yyyy").parse(clientData.get(j+1));
        final Date EXPIREDATE = new SimpleDateFormat("dd/MM/yyyy").parse(clientData.get(j+2));
        final Image IMAGE = convertStringToImage(clientData.get(j+3));
        client.addLicense(RELEASEDATE, EXPIREDATE, IMAGE);
      }
      clients.add(client);
    }
    return clients;
  }
  
  /**
   * Método para guardar datos de un empleado en un archivo .json
   * @param employee Empleado el cual sus datos serán guardados
   * @throws IOException
   */
  public void saveEmployee(Employee employee) throws IOException {
    ArrayList<String> employeeData = new ArrayList<String>();
    employeeData.add(employee.getId());
    employeeData.add(employee.getName());
    employeeData.add(employee.getTelephone());
    employeeData.add(employee.getMail());
    employeeData.add(employee.getPassword());
    employeeData.add(employee.getUserName());
    try {
      JSONParser parser = new JSONParser();
      JSONArray employees = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
          + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
          + "rent-a-car\\employees.json"));
      employees.add(employeeData);
      Files.write(Paths.get("employees.json"), employees.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray employees = new JSONArray();
      employees.add(employeeData);
      Files.write(Paths.get("employees.json"), employees.toJSONString().getBytes());
      }
  }
  
  /**
   * Método para cargar los datos de los empleados registrados en el sistema
   * @throws ParseException 
   * @throws IOException 
   * @throws FileNotFoundException 
   */
  public ArrayList<Employee> loadEmployees() throws FileNotFoundException, IOException, ParseException {
    JSONParser parser = new JSONParser();
    JSONArray employeesArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Doc"
        + "uments\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code"
        + "\\rent-a-car\\employees.json"));
    ArrayList<String> employeeData= new ArrayList<String>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    for(int i = 0; i < employeesArray.size(); i++) {
      employeeData = (ArrayList<String>) employeesArray.get(i);
      final String ID = employeeData.get(0);
      final String NAME = employeeData.get(1);
      final String TELEPHONE = employeeData.get(2);
      final String MAIL = employeeData.get(3);
      final String PASSWORD = employeeData.get(4);
      final String USERNAME = employeeData.get(5);
      Employee employee = new Employee(NAME,ID,TELEPHONE,MAIL, USERNAME, PASSWORD);
      employees.add(employee);
    }
    return employees;
  }
  /**
   * Método para guardar un vehículo en un archivo .json
   * @param vehicle objeto tipo Vehiculo que será guardado luego de haber sido registrado
   * @throws IOException 
   */
  public void saveVehicle(Vehicle vehicle) throws IOException {
    ArrayList<String> vehicleData = new ArrayList<String>();
    ArrayList<String> maintenanceData = new ArrayList<String>();
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
    vehicleData.add(vehicle.getVehiclePlate());
    vehicleData.add(formatDate.format(vehicle.getFabricationDate()));
    final String RED = String.valueOf(vehicle.getColor().getRed());
    final String GREEN = String.valueOf(vehicle.getColor().getGreen());
    final String BLUE = String.valueOf(vehicle.getColor().getBlue());
    vehicleData.add(RED);
    vehicleData.add(GREEN);
    vehicleData.add(BLUE);
    vehicleData.add(Byte.toString(vehicle.getCapacity()));
    vehicleData.add(vehicle.getBrand());
    vehicleData.add(Byte.toString(vehicle.getDoors()));
    vehicleData.add(vehicle.getVinNumber());
    vehicleData.add(Float.toString(vehicle.getMpg()));
    vehicleData.add(Float.toString(vehicle.getPrice()));
    vehicleData.add(Byte.toString(vehicle.getSuitcaseCapacity()));
    vehicleData.add(Boolean.toString(vehicle.isTransmission()));
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
    try {
      JSONParser parser = new JSONParser();
      JSONArray vehicles = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
          + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
          + "rent-a-car\\vehicles.json"));
      vehicles.add(vehicleData);
      Files.write(Paths.get("vehicles.json"), vehicles.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray clients = new JSONArray();
      clients.add(vehicleData);
      Files.write(Paths.get("vehicles.json"), clients.toJSONString().getBytes());
      }
  }
  
  /**
   * Método para cargar los vehículos previamente añadidos
   * @return ArrayList con todos los vehículos registrados hasta la fecha
   * @throws IOException
   * @throws ParseException
   * @throws java.text.ParseException
   * @throws IllegalArgumentException
   * @throws IllegalAccessException
   * @throws NoSuchFieldException
   * @throws SecurityException
   * @throws ClassNotFoundException
   */
  public ArrayList<Vehicle> loadVehicles() throws IOException, ParseException, 
  java.text.ParseException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
  SecurityException, ClassNotFoundException {
    JSONParser parser = new JSONParser();
    JSONArray vehiclesArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
        + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
        + "rent-a-car\\Vehicles.json"));
    ArrayList<String> vehicleData= new ArrayList<String>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    for(int i = 0; i < vehiclesArray.size(); i++) {
      vehicleData = (ArrayList<String>) vehiclesArray.get(i);
      
      String colorData = vehicleData.get(2);
      final String VEHICLEPLATE = vehicleData.get(0);
      final Date FABRICATIONDATE = new SimpleDateFormat("dd/MM/yyyy").parse(vehicleData.get(1));
      final int RED = Integer.parseInt(vehicleData.get(2));
      final int GREEN = Integer.parseInt(vehicleData.get(3));
      final int BLUE = Integer.parseInt(vehicleData.get(4));
      final Color COLOR = new Color(RED, GREEN, BLUE);
      final byte CAPACITY = Byte.parseByte(vehicleData.get(5));
      final String BRAND = vehicleData.get(6);
      final byte DOORS = Byte.parseByte(vehicleData.get(7));
      final String VINNUMBER = vehicleData.get(8);
      final float MPG = Float.parseFloat(vehicleData.get(9));
      final float PRICE = Float.parseFloat(vehicleData.get(10));
      final byte SUITCAPACITY = Byte.parseByte(vehicleData.get(11));
      final boolean TRANSMISION = Boolean.parseBoolean(vehicleData.get(12));
      Vehicle vehicle = new Vehicle(VEHICLEPLATE, FABRICATIONDATE, COLOR, CAPACITY, BRAND, DOORS, 
          VINNUMBER, MPG, PRICE, SUITCAPACITY, TRANSMISION);
      for(int j = 13; j < vehicleData.size(); j = j+6) {
        final boolean TYPE = Boolean.parseBoolean(vehicleData.get(j));
        final String ID = vehicleData.get(j+1);
        final Date STARTDATE = new SimpleDateFormat("dd/MM/yyyy").parse(vehicleData.get(j+2));
        final Date ENDDATE = new SimpleDateFormat("dd/MM/yyyy").parse(vehicleData.get(j+3));
        final float MAITENANCEPRICE = Float.parseFloat(vehicleData.get(j+4));
        final String DETAIL = vehicleData.get(j+5);
        vehicle.getMaintenances().add(new Maintenance(TYPE, ID, STARTDATE, ENDDATE, MAITENANCEPRICE,
            DETAIL));
      }
      vehicles.add(vehicle);
    }
    return vehicles;
  }
}