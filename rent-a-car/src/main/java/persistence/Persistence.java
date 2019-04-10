package persistence;

import bussineslogic.Client;
import bussineslogic.Company;
import bussineslogic.Employee;
import bussineslogic.Maintenance;
import bussineslogic.Reserve;
import bussineslogic.Service;
import bussineslogic.Vehicle;
import bussineslogic.VehicleState;
import bussineslogic.VehicleStyle;
import bussineslogic.Address;
import bussineslogic.Branch;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
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
import org.json.simple.parser.ParseException;
import util.Chyperer;

/**
 * Clase para la persistencia de datos, implementa una interfaz con constantes para mejorar la
 * comprensión de la misma
 * @author Marcosmh0199
 * @version v19.4.10
 */
public class Persistence implements Constants{
  
  private Chyperer encrypt = new Chyperer("123456789ABCDEFG");
  
  /**
   * Constructor de la clase
   */
  public Persistence() {
    createDirectory();
  }
  
  /**
   * Método para crear el directorio donde se van a guardar los archivos
   */
  private void createDirectory() {
    if(Files.exists(Paths.get("C:\\JSONFiles"))){
      File dir = new File("C:\\JSONFiles");
      dir.mkdir();
    }
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
  
  /**
   * Método para obtener la información de un cliente
   * @param client cliente del cual se obtendrá la informacion
   * @return ArrayList con la información
   * @throws Exception
   */
  private ArrayList<String> getClientData(Client client) throws Exception{
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
    JSONArray clientsArray = new JSONArray();
    if(Files.exists(Paths.get("C:\\JSONFiles\\clients.json"))) {
      clientsArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\clients.json"));
    }
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
        client.addLicense(id,releaseDate, expireDate, IMAGE);
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
  private ArrayList<String> getEmployeeData(Employee employee) throws Exception{
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
    JSONArray employeesArray = new JSONArray();
    if(Files.exists(Paths.get("C:\\JSONFiles\\employees.json"))) {
      employeesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\employees.json"));
    }
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
   * Metodo para actualizar los vehiculos de las sedes luego de hacer modificaciones
   * @param branches sedes registradas 
   * @throws Exception
   */
  public void updateBranchVehicles(ArrayList<Branch> branches) throws Exception {
    JSONArray branchesVehicles = new JSONArray();
    for(int i = 0; i < branches.size(); i++) {
      ArrayList<ArrayList<String>> vehicles= getBranchVehicles(branches.get(i).getVehicles());
      branchesVehicles.add(vehicles);
    }
    Files.write(Paths.get("C:\\JSONFiles\\branchesVehicles.json"), branchesVehicles.toJSONString().getBytes());
  }
  
  /**
   * Metodo para obtener los datos de los vehiculos de las sedes 
   * @param vehicles vehiculos de una sede
   * @return ArrayList que guarda Arrays con datos de vehiculos en cadenas
   * @throws Exception
   */
  private ArrayList<ArrayList<String>> getBranchVehicles(ArrayList<Vehicle> vehicles) throws Exception {
    ArrayList<String> vehicleData = new ArrayList<String>();
    ArrayList<ArrayList<String>> branchVehicles = new ArrayList<ArrayList<String>>();
    for(int i = 0; i < vehicles.size(); i++) {
      vehicleData = getVehicleData(vehicles.get(i));
      branchVehicles.add(vehicleData);
    }
    return branchVehicles;
  }
  
  /**
   * Metodo para obtener los datos de una sede y darle persistencia a sus vehiculos
   * @param branch sede
   * @return ArrayList conformado por cadenas de los datos de la sede
   * @throws Exception
   */
  private ArrayList<String> getBranchData(Branch branch) throws Exception{
    ArrayList<String> branchData = new ArrayList<String>();
    ArrayList<ArrayList<String>> branchVehicles = getBranchVehicles(branch.getVehicles());
    try {
      JSONParser parser = new JSONParser();
      JSONArray branchesVehicles = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\branchesVehicles.json"));
      branchesVehicles.add(branchVehicles);
      Files.write(Paths.get("C:\\JSONFiles\\branchesVehicles.json"), branchesVehicles.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray branchesVehicles = new JSONArray();
      branchesVehicles.add(branchVehicles);
      Files.write(Paths.get("C:\\JSONFiles\\branchesVehicles.json"), branchesVehicles.toJSONString().getBytes());
      }
    branchData.add(branch.getName());
    branchData.add(branch.getAddress().getProvince());
    branchData.add(branch.getAddress().getCanton());
    branchData.add(branch.getAddress().getDistrict());
    branchData.add(branch.getAddress().getSings());
    for(int i = 0; i < branchData.size(); i++) {
      branchData.set(i, encrypt.encrypt((branchData.get(i))));
    }
    return branchData;
  }
  
  /**
   * Metodo para darle persistencia a una sede
   * @param branch sede
   * @throws Exception
   */
  public void saveBranch(Branch branch) throws Exception {
    ArrayList<String> branchData = getBranchData(branch);
    try {
      JSONParser parser = new JSONParser();
      JSONArray branches = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Branches.json"));
      branches.add(branchData);
      Files.write(Paths.get("C:\\JSONFiles\\Branches.json"), branches.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray branches = new JSONArray();
      branches.add(branchData);
      Files.write(Paths.get("C:\\JSONFiles\\Branches.json"), branches.toJSONString().getBytes());
      }
  }
  
  /**
   * Metodo para cargar todas las sedes que se haya guardado
   * @return ArrayList que contiene todas las sedes registradas
   * @throws Exception
   */
  public ArrayList<Branch> loadBranches() throws Exception{
    JSONParser parser = new JSONParser();
    JSONArray branchesArray = new JSONArray();
    JSONArray vehiclesArray = new JSONArray();
    if(Files.exists(Paths.get("C:\\JSONFiles\\clients.json"))) {
      branchesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Branches.json"));
    }
    if(Files.exists(Paths.get("C:\\JSONFiles\\clients.json"))) {
      vehiclesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\branchesVehicles.json"));
    }
    ArrayList<Branch> branches = new ArrayList<Branch>();
    ArrayList<String> branchData = new ArrayList<String>();
    ArrayList<String> vehicleData = new ArrayList<String>();
    Vehicle vehicle = null;
    ArrayList<ArrayList<String>> vehiclesData = new ArrayList<ArrayList<String>> ();
    for(int i = 0; i < branchesArray.size(); i++) {
      branchData = (ArrayList<String>) branchesArray.get(i);
      String branchName = encrypt.decrypt(branchData.get(BRANCHNAME));
      String province = encrypt.decrypt(branchData.get(BRANCHPROVINCE));
      String canton = encrypt.decrypt(branchData.get(BRANCHCANTON));
      String district = encrypt.decrypt(branchData.get(BRANCHDISTRICT));
      String sings = encrypt.decrypt(branchData.get(BRANCHSINGS));
      branches.add(new Branch(branchName,new Address(province,canton,district,sings)));
    }
    for(int i = 0; i < vehiclesArray.size(); i++) {
      vehiclesData = (ArrayList<ArrayList<String>>) vehiclesArray.get(i);
      for(int j = 0; j < vehiclesData.size(); j++) {
        vehicleData = vehiclesData.get(j);
        vehicle = loadVehicle(vehicleData);
        }
        branches.get(i).add(vehicle);
      }
    return branches;
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
    vehicleData.add(vehicle.getState().name());
    vehicleData.add(vehicle.getStyle().name());
    for(int i = 0; i < vehicle.getMaintenances().size(); i++) {
      maintenanceData.add(Boolean.toString(vehicle.getMaintenances().get(i).getType()));
      maintenanceData.add(vehicle.getMaintenances().get(i).getId());
      maintenanceData.add(formatDate.format(vehicle.getMaintenances().get(i).getStartDate()));
      maintenanceData.add(formatDate.format(vehicle.getMaintenances().get(i).getEndDate()));
      maintenanceData.add(Float.toString(vehicle.getMaintenances().get(i).getPrice()));
      maintenanceData.add(vehicle.getMaintenances().get(i).getDetail());
      maintenanceData.add(vehicle.getMaintenances().get(i).getCompany().getBussinesName());
      maintenanceData.add(vehicle.getMaintenances().get(i).getCompany().getLegalNumber());
      maintenanceData.add(vehicle.getMaintenances().get(i).getCompany().getTelephone());      
    }
    for(int i = 0; i < maintenanceData.size(); i++) {
      vehicleData.add(maintenanceData.get(i));
    }
    for(int i = 0; i < vehicleData.size(); i++) {
      vehicleData.set(i, encrypt.encrypt(vehicleData.get(i)));
    }
    return vehicleData;
  }
  
  /**
   * Metodo para parsear los datos en String de un vehiculo y a partir de estos formar un 
   * objeto tipo Vehiculo
   * @param vehicleData informacion con la que se formara un vehiculo
   * @return objeto vehiculo
   * @throws Exception
   */
  private Vehicle loadVehicle(ArrayList<String> vehicleData) throws Exception {
    String vehiclePlate = encrypt.decrypt(vehicleData.get(VEHICLEPLATE));
    Date fabricationDate = new SimpleDateFormat("dd/MM/yyyy").parse(encrypt.decrypt(
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
    vehicle.setVehicleImage(convertStringToImage(encrypt.decrypt(vehicleData.get(IMAGE))));
    vehicle.setState(VehicleState.valueOf(encrypt.decrypt(vehicleData.get(STATE))));
    vehicle.setStyle(VehicleStyle.valueOf(encrypt.decrypt(vehicleData.get(STYLE))));
    for(int k = 14; k < vehicleData.size(); k = k+9) {
      boolean type = Boolean.parseBoolean(encrypt.decrypt(vehicleData.get(k)));
      String id = encrypt.decrypt(vehicleData.get(k+1));
      Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(encrypt.decrypt(
          vehicleData.get(k+2)));
      Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(encrypt.decrypt(
          vehicleData.get(k+3)));
      float maintenancePrice = Float.parseFloat(encrypt.decrypt(vehicleData.get(k+4)));
      String detail = encrypt.decrypt(vehicleData.get(k+5));
      String businessName = encrypt.decrypt(vehicleData.get(k+6));
      String legalNumber = encrypt.decrypt(vehicleData.get(k+7));
      String telephone = encrypt.decrypt(vehicleData.get(k+8));
      Company company = new Company(businessName, legalNumber, telephone);
      vehicle.getMaintenances().add(new Maintenance(type, id, startDate, endDate, maintenancePrice,
          detail,company));
      
    }
    return vehicle;
  }
  
  /**
   * Metodo darle persistencia a una compania
   * @param company compania
   * @throws Exception
   */
  public void saveCompany(Company company) throws Exception {
    ArrayList<String> companyData = new ArrayList<String>();
    companyData.add(company.getBussinesName());
    companyData.add(company.getLegalNumber());
    companyData.add(company.getTelephone());
    try {
      JSONParser parser = new JSONParser();
      JSONArray companies = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Companies.json"));
      companies.add(companyData);
      Files.write(Paths.get("C:\\JSONFiles\\Companies.json"), companies.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray companies = new JSONArray();
      companies.add(companyData);
      Files.write(Paths.get("C:\\JSONFiles\\Companies.json"), companies.toJSONString().getBytes());
      }
  }
  
  /**
   * Metodo para cargar las companias registradas
   * @return ArrayList que contiene las companias guardadas
   * @throws FileNotFoundException
   * @throws IOException
   * @throws ParseException
   */
  public ArrayList<Company> loadCompanies() throws FileNotFoundException, IOException, ParseException {
    ArrayList<Company> companies = new ArrayList<Company>();
    ArrayList<String> companyData = new ArrayList<String>();
    JSONParser parser = new JSONParser();
    JSONArray companiesArray = new JSONArray();
    if(Files.exists(Paths.get("C:\\JSONFiles\\clients.json"))) {
      companiesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Companies.json"));
    }
    for(int i = 0; i < companiesArray.size(); i++) {
      companyData = (ArrayList<String>) companiesArray.get(i);
      String businessName = companyData.get(BUSINESSNAME);
      String legalNumber = companyData.get(LEGALNUMBER);
      String telephone = companyData.get(TELEPHONE);
      Company company = new Company(businessName, legalNumber, telephone);
      companies.add(company);
    }
    return companies;
  }
  
  /**
   * Metodo para registrar una reserva en un .json
   * @param collectionBranch Sede origen del vehiculo de la reserva
   * @param deliveryBranch Sede adonde se solicito el vehiculo
   * @param service Servicios extras 
   * @param client Cliente que solicito la reserva
   * @param employee Empleado que registro la reserva
   * @param vehicle Vehiculo reservado
   * @param starDate Fecha de comienzo de la reserva
   * @param endDate Fecha de fin de la reserva
   * @param requesDate Fecha de solicitud de la reserva
   * @throws Exception
   */
  public void saveReserve(Branch collectionBranch, Branch deliveryBranch, Service service,
      Client client, Employee employee, Vehicle vehicle, Date starDate, Date endDate, 
      Date requesDate) throws Exception {
    ArrayList<String> reserveData = new ArrayList<String>();
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
    reserveData.add(collectionBranch.getName());
    reserveData.add(collectionBranch.getAddress().getProvince());
    reserveData.add(collectionBranch.getAddress().getCanton());
    reserveData.add(collectionBranch.getAddress().getDistrict());
    reserveData.add(collectionBranch.getAddress().getSings());
    reserveData.add(deliveryBranch.getName());
    reserveData.add(deliveryBranch.getAddress().getProvince());
    reserveData.add(deliveryBranch.getAddress().getCanton());
    reserveData.add(deliveryBranch.getAddress().getDistrict());
    reserveData.add(deliveryBranch.getAddress().getSings());
    for(int i = 0; i < 8; i++) {
      reserveData.add(getClientData(client).get(i));
    }
    for(int i = 0; i < 4; i++) {
      reserveData.add(getEmployeeData(employee).get(i));
    }
    reserveData.add(Boolean.toString(service.getChildSeat()));
    reserveData.add(Boolean.toString(service.getEnsurance()));
    reserveData.add(Boolean.toString(service.getGps()));
    reserveData.add(Boolean.toString(service.getRouteAssistance()));
    reserveData.add(Boolean.toString(service.getWifi()));
    for(int i = 0; i < getVehicleData(vehicle).size(); i++) {
      reserveData.add(getVehicleData(vehicle).get(i));
    }
    reserveData.add(formatDate.format(starDate));
    reserveData.add(formatDate.format(endDate));
    reserveData.add(formatDate.format(requesDate));
    try {
      JSONParser parser = new JSONParser();
      JSONArray reserves = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Reserves.json"));
      reserves.add(reserveData);
      Files.write(Paths.get("C:\\JSONFiles\\Reserves.json"), reserves.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray reserves = new JSONArray();
      reserves.add(reserveData);
      Files.write(Paths.get("C:\\JSONFiles\\Reserves.json"), reserves.toJSONString().getBytes());
      }
  }
  
  /**
   * Metodo para cargar las reservas registradas
   * @return ArrayList con las reservas registradas
   * @throws Exception
   */
  public ArrayList<Reserve> loadReserves() throws Exception {
    ArrayList<Reserve> reserves = new ArrayList<Reserve>();
    ArrayList<String> reserveData = new ArrayList<String>();
    JSONParser parser = new JSONParser();
    JSONArray reservesArray = new JSONArray();
    if(Files.exists(Paths.get("C:\\JSONFiles\\clients.json"))) {
      reservesArray = (JSONArray) parser.parse(new FileReader("C:\\JSONFiles\\Reserves.json"));
    }
    for(int i = 0; i < reservesArray.size(); i++) {
      ArrayList<String> vehicleData = new ArrayList<String>();
      reserveData = (ArrayList<String>) reservesArray.get(i);
      Branch collectionBranch = new Branch(reserveData.get(0), new Address(reserveData.get(1),
          reserveData.get(2),reserveData.get(3),reserveData.get(4)));
      Branch deliveryBranch = new Branch(reserveData.get(5), new Address(reserveData.get(6),
          reserveData.get(7),reserveData.get(8),reserveData.get(9)));
      Client client = new Client(encrypt.decrypt(reserveData.get(10)),encrypt.decrypt(reserveData.get(11)),
          encrypt.decrypt(reserveData.get(12)),encrypt.decrypt(reserveData.get(13)),new Address(
              encrypt.decrypt(reserveData.get(14)),encrypt.decrypt(reserveData.get(15)),
              encrypt.decrypt(reserveData.get(16)),encrypt.decrypt(reserveData.get(17))));
      
      Employee employee = new Employee(reserveData.get(19),reserveData.get(18),
          reserveData.get(20),reserveData.get(21),"","");
      Service service = new Service(Boolean.parseBoolean(reserveData.get(22)),Boolean.parseBoolean
          (reserveData.get(23)),Boolean.parseBoolean(reserveData.get(24)),Boolean.parseBoolean
          (reserveData.get(25)),Boolean.parseBoolean(reserveData.get(26)));
      for(int j = 27; j < reserveData.size()-3; j++) {
        vehicleData.add(reserveData.get(j));
      }
      
      Vehicle vehicle = loadVehicle(vehicleData);
      Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(reserveData.get(50));
      Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(reserveData.get(51));
      Date requestDate = new SimpleDateFormat("dd/MM/yyyy").parse(reserveData.get(52));
      reserves.add(new Reserve(deliveryBranch, deliveryBranch, service, client, employee, vehicle, 
          requestDate, requestDate, requestDate));
    }
    return reserves;
  }
}