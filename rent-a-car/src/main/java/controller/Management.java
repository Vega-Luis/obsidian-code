package controller;

import bussineslogic.Address;
import bussineslogic.Branch;
import bussineslogic.Client;
import bussineslogic.Company;
import bussineslogic.Employee;
import bussineslogic.Maintenance;
import bussineslogic.Reserve;
import bussineslogic.Service;
import bussineslogic.Vehicle;
import bussineslogic.VehicleState;
import bussineslogic.VehicleStyle;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
import persistence.Persistence;
import util.Mail;
import webservicecapture.ExchangeRate;

/**
 * Esta clase esta encargada de controlar la interaccon entre la logica de negocios
 * y la interfaz grafica.
 * @author Luis
 * @version v19.4.8
 */
public class Management {
  private ArrayList<Client> clients;
  private ArrayList<Employee> employees;
  private ArrayList<Branch> branches;
  private ArrayList<Company> companies;
  private ArrayList<Reserve> reserves;
  private Persistence persistence;
  private final int NOT_ADDED = 0;

  public Management() {
    this.persistence = new Persistence();
    this.setClients();
    this.setEmployees();
    this.setBranches();
    this.setCompanies();
    this.setReserves();
  }
  
  private void setClients() {
    try {
      this.clients = this.persistence.loadClients();
    } catch (Exception e) {
      this.clients = new ArrayList<Client>();
      e.printStackTrace();
    }
  }

  private void setEmployees() {
    try {
      this.employees = this.persistence.loadEmployees();
    } catch (Exception e) {
      this.employees = new ArrayList<Employee>();
      e.printStackTrace();
    }
  }
  
  private void setBranches() {
    try {
      this.branches = this.persistence.loadBranches();
    } catch (Exception e) {
      this.branches = new ArrayList<Branch>();
      e.printStackTrace();
    }
  }
  
  public ArrayList<Branch> getBraches(){
    return branches;
  }
  
  private void setCompanies() {
    try {
      this.companies = this.persistence.loadCompanies();
    } catch (FileNotFoundException e) {
      this.companies = new ArrayList<Company>();
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  
  private void setReserves() {
    try {
      this.reserves = persistence.loadReserves();
    } catch (Exception e) {
      this.reserves = new ArrayList<Reserve>();
      e.printStackTrace();
    }
  }
  
  public ArrayList<Reserve> getReserves(){
    return reserves;
  }
  
  public ArrayList<Company> getCompanies(){
    return companies;
  }
  
  /**
   * Permite que un empleado inicie seccion.
   * @param pasword Contrasenia del empleado.
   * @param userName Nombre del usuario.
   * @return booleano que indica el resultado de la operacion.
   */
  public boolean login(String pasword, String userName) {
    for (int employee = 0; employee < employees.size(); employee++) {
      if (employees.get(employee).getUserName().equals(userName) 
          && employees.get(employee).getPassword().equals(pasword)) {
      return true;
      }
    }
    return false;
  }
  
  /**
   * Busca empleado por empleado.
   * @param userName Nombre del empleado.
   * @return empleado.
   */
  public Employee searchEmployee(String userName) {
    for (int employee = 0; employee < employees.size(); employee++) {
      if (employees.get(employee).getUserName().equals(userName)) {
      return employees.get(employee);
      }
    }
    return null;
  }
  
  /**
   * Busca empleado por empleado.
   * @param userName Nombre del empleado.
   * @return empleado.
   */
  public Employee searchEmployee(String pasword, String userName) {
    for (int employee = 0; employee < employees.size(); employee++) {
      if (employees.get(employee).getUserName().equals(userName)
          && employees.get(employee).getPassword().equals(pasword)) {
      return employees.get(employee);
      }
    }
    return null;
  }
  
  /**
   * Busca un cliente y retorna la posicion donde se encuentra.
   * Sin no existe retona un -1.
   * @param id Identificador del cliente.
   * @return Posicion  que se encuentra el cliente dentro del clients
   */
  private int searchClient(String id) {
    for (int client = 0; client < clients.size(); client++) {
      if (clients.get(client).getId().equals(id)) {
        return client;
      }
    }
    return NOT_ADDED;
  }
  
  public Client checkClient(String idCliente) {
    for (int puntero = 0; puntero < clients.size(); puntero++) {
      if (clients.get(puntero).getId().equals(idCliente)) {
        return clients.get(puntero);
      }
    }
    return null;
  }
  
  /**
   * Permite registrar un  nuevo cliente.
   * @param name Nombre del cliente.
   * @param id Cedula del cliente.
   * @param telephone Telefono del cliente.
   * @param mail Correo del cliente.
   * @param province Provincia relacionada a la direccion.
   * @param canton Canton de la direccion.
   * @param district Distrito de la direccion.
   * @param sings Senas que indetifican la direccion.
   * @param licenceId Identificador de la licencia.
   * @param releaseDate Fecha de emision.
   * @param expireDate Fecha de expiracion.
   * @param image Imagen de la licencia.
   * @return Booleano que indica si la operacion ha sido exitosa.
   */
  public boolean addClient(String name, String id, String telephone, String mail, 
      String province, String canton, String district, String sings, 
          String licenceId, Date releaseDate, Date expireDate, Image image ) {
    
    if (searchClient(id) == NOT_ADDED) {
      Client newClient = new Client(name, id, telephone, mail, new Address(province, canton, district, sings));
      newClient.addLicense(licenceId, releaseDate, expireDate, image);
      clients.add(newClient);
      try {
        persistence.saveClient(newClient);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return true;
    }
    return false;
  }
  
  /**
   * Agrega un nuevo empleado al rent a car.
   * @param name nombre del empleado
   * @param id cédula del empleado
   * @param telephone número telefónico del empleado
   * @param mail correo-electrónico del empleado
   * @return Booleano que indica el resultado de la operacion.
   */
  public boolean addEmployee(String name, String id, String telephone, String mail) {
    for (int employee = 0; employee < employees.size(); employee++) {
      if (employees.get(employee).getId().equals(id)) {
        return false;
      }
    }
    Employee newEmployee = new Employee(name, id, telephone, mail);
    employees.add(newEmployee);
    try {
      this.persistence.saveEmployee(newEmployee);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  
  /**
   * Agrega una licencia al cliente.
   * @param clientId Cedula del cliente dueño de la cédula.
   * @param licenceId Identificador de la licencia.
   * @param releaseDate fecha en la que fue emitida la cédula.
   * @param expireDate fecha en la que expira la cédula.
   * @param image
   */
  public void addLicence(String clientId, String licenceId, Date releaseDate, Date expireDate, Image image) {
    if (searchClient(clientId) == NOT_ADDED) {
      clients.get(searchClient(clientId)).addLicense(licenceId, releaseDate, expireDate, image);
    }
  }
  
  /**
   * Retorna el cliente que se encuentra en una posicion del array de clientes.
   * @param client Posicion en que se encuentra el cliente.
   * @return Cliente consultado.
   */
  public Client getClient(int client) {
    return clients.get(client);
  }

  /**
   * Permite agregar un vehiculo a una sede.
   * @param vehiclePlate Placa del vehiculo.
   * @param fabricationDate Fecha en que fue fabricado el vehiculo.
   * @param color Color del vehiculo.
   * @param capacity Capacidad de pasajeros del vehiculo.
   * @param brand Marca del vehiculo.
   * @param doors Cantidad de puertas del vehiculo.
   * @param vinNumber Numero de vin asociado al vehiculo.
   * @param mpg Cantidad de millas que es capaz de recorrer con un galon de combustible.
   * @param price Costo por alquiler.
   * @param suitcaseCapacity Cantidad de maletas que soporta el vehiculo.
   * @param transmission Tipo de transmicion.
   * @param vehicleImage Image del vehiculo.
   * @param style Estylo del vehiculo.
   * @return booleano que indica el resultado de la operacion.
   */
  public boolean addVehicle(Branch branch, String vehiclePlate, Date fabricationDate,
      String color, byte capacity, String brand, byte doors, String vinNumber,
          float mpg, float price, byte suitcaseCapacity, boolean transmission, Image vehicleImage, VehicleStyle style) {
    
    for (int vehicle = 0; vehicle < branch.getVehicles().size(); vehicle++) {
      if (branch.getVehicles().get(vehicle).getVehiclePlate().equals(vehiclePlate)) {
        return false;
      }
    }
    Vehicle newVehicle = new Vehicle(vehiclePlate,fabricationDate, color, capacity, brand, doors,
        vinNumber, mpg, price, suitcaseCapacity, transmission);
    newVehicle.setVehicleImage(vehicleImage);
    newVehicle.setStyle(style);
    branch.add(newVehicle);
    try {
      persistence.updateBranchVehicles(branches);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
  
  /**
   * Permite agregar una nueva empresa de mantenimiento.
   * @param bussinesName Nombre de la empresa.
   * @param legalNumber Razon social.
   * @param telephone Telefono.
   * @return Booleano que indica el resultado de la operacion.
   */
  public boolean addCompany(String bussinesName, String legalNumber, String telephone) {
    for (int company = 0; company < this.companies.size(); company++) {
      if (this.companies.get(company).getBussinesName().equals(bussinesName)) {
        return false;
      }
    }
    this.companies.add(new Company(bussinesName, legalNumber, telephone));
    return true;
  }
  
  /**
   * Agrega un nuevo mantenimiento a la empresa de servicios.
   * @param branch Sede a la que pertence le vehiculo.
   * @param type tipo de mantenimeinto.
   * @param vehiclePlate Placa del vehiculo. 
   * @param startDate Fecha en que inicia el mantenimiento.
   * @param endDate Fecha en que termina el mantenimiento.
   * @param price Costo del mantenimeinto.
   * @param detail Detalle del mantenimiento.
   * @param company Empresa que lo realiza.
   * @return
   */
  public boolean addMaintenance(Branch branch, boolean type, String vehiclePlate, Date startDate,
      Date endDate, Float price, String detail, Company company) {

    if (branch.getVehicle(vehiclePlate) != null) {
      Maintenance newMaintenance = new Maintenance(type, detail, endDate, endDate, price, detail, company);
      branch.getVehicle(vehiclePlate).getMaintenances().add(newMaintenance);
      return true;
    }
    return false;
  }
  
  /**
   * Modifica la imagen del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param vehicleImage Imagen del vehiculo.
   */
  public void modifyImage(Branch branch, String vehiclePlate, Image vehicleImage) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setVehicleImage(vehicleImage);
    }
  }
  
  /**
   * Modifica la fecha de fabricacion del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param fabricationDate Fecha de fabricacion del vehiculo.
   */
  public void modifyFabricationDate(Branch branch, String vehiclePlate, Date fabricationDate) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setFabricationDate(fabricationDate);
    }
  }
  
  /**
   * Modifica el color de vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param color Color del vehiculo.
   */
  public void modifyColor(Branch branch, String vehiclePlate, String color) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setColor(color);
    }
  }
  
  /**
   * Modifica la capacidad del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param capacity Capacidad del vehiculo.
   */
  public void modifyCapacity(Branch branch, String vehiclePlate, byte capacity) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setCapacity(capacity);
    }
  }
  
  /**
   * Modifica la marca del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param brand Marca del vehiculo.
   */
  public void modifyBrand(Branch branch, String vehiclePlate,String brand ) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setBrand(brand);
    }
  }
  
  /**
   * Modifica la cantidad de puertas del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param doors Cantidad de puertas del vehiculo.
   */
  public void modifyDoors(Branch branch, String vehiclePlate,byte doors) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setDoors(doors);
    }
  }
  
  /**
   * Modifica el numero de vin del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param vinNumber Numero de vin del vehiculo.
   */
  public void modifyVinNumber(Branch branch, String vehiclePlate,String vinNumber) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setVinNumber(vinNumber);
    }
  }
  
  /**
   * Modifica las millas por galon que soporta el vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param mpg Cantidad de millas por galon.
   */
  public void modifyMpg(Branch branch, String vehiclePlate,float mpg) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setMpg(mpg);
    }
  }
  
  /**
   * Modifica el precion del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param price Precio del vehiculo.
   */
  public void modifyPrice(Branch branch, String vehiclePlate,float price) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setPrice(price);
    }
  }
  
  /**
   * Modifica la capacidad de maletas que soporta el vehiculo.
   * @param vehiclePlate Placa del vechiculo.
   * @param suitcaseCapacity Cantidad de maletas que soporta el vehiculo.
   */
  public void modifySuitcaseCapacity(Branch branch, String vehiclePlate,byte suitcaseCapacity) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setSuitcaseCapacity(suitcaseCapacity);
    }
  }
  
  /**
   * Modifica el tipo de transmision del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param transmission Tipo de transmission.
   */
  public void modifyTransmission(Branch branch, String vehiclePlate, boolean transmission) {
    if (branch.getVehicle(vehiclePlate) != null) {
      branch.getVehicle(vehiclePlate).setTransmission(transmission);
    }
  } 
  
  /**
   * Guarda en la persistencia todos los cambios hechos en le management.
   */
  public void saveAll() {
    try {
      persistence.updateBranchVehicles(branches);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public boolean reserve(Branch collectionBranch, Branch deliveryBranch, Service service, Client client,
      Employee employee, Vehicle vehicle, Date starDate, Date endDate, Date requesDate) {
    
    Reserve newReserve = new Reserve(collectionBranch, deliveryBranch, service, client, employee,
        vehicle,starDate, endDate, requesDate);
    this.reserves.add(newReserve);
    collectionBranch.getVehicle(vehicle.getVehiclePlate()).setState(VehicleState.INACTIVE);
    return true;
  }
  
  /**
   * Filtra los vehiculos por el estilo.
   * @param vehicleStyle Estilo del vehiculo.
   * @return Lista con los vehiculos que tiene el mismo estilo.
   */
  public ArrayList<Vehicle> vehicleStyleFilter(Branch branch, VehicleStyle vehicleStyle) {
    ArrayList<Vehicle> filterVehicles = new ArrayList<Vehicle>();
    for (int vehicle = 0; vehicle < branch.getVehicles().size(); vehicle++) {
      if (branch.getVehicles().get(vehicle).getStyle().equals(vehicleStyle)) {
        filterVehicles.add(branch.getVehicles().get(vehicle));
      }
    }
    return filterVehicles;
  }
  
  /**
   * Filtra los vehiculos por capacidad
   * @param capacity Cantidad de personas que soporta.
   * @return Todos lo vehiculos que cumplen con el parametro del filtro.
   */
  public ArrayList<Vehicle> vehicleCapacityFilter(Branch branch, byte capacity) {
    ArrayList<Vehicle> filterVehicles = new ArrayList<Vehicle>();
    for (int vehicle = 0; vehicle < branch.getVehicles().size(); vehicle++) {
      if (branch.getVehicles().get(vehicle).getCapacity() == capacity) {
        filterVehicles.add(branch.getVehicles().get(vehicle));
      }
    }
    return filterVehicles;
  }

  /**
   * Filtra los vehiculos por precio.
   * @param max Precion maximo solicitado.
   * @param min Precion minimo solicitado.
   * @return Todos los vehiculos que se encuentran dentro del rango.
   */
  public ArrayList<Vehicle> vehiclePriceFilter(Branch branch, float max, float min) {
    ArrayList<Vehicle> filterVehicles = new ArrayList<Vehicle>();
    for (int vehicle = 0; vehicle < branch.getVehicles().size(); vehicle++) {
      if (min <= branch.getVehicles().get(vehicle).getPrice() || branch.getVehicles().get(vehicle).getPrice( ) <= max) {
        filterVehicles.add(branch.getVehicles().get(vehicle));
      }
    }
    //Requires revision
    Collections.sort(filterVehicles, new Comparator<Vehicle>() {
      public int compare(Vehicle o1, Vehicle o2) {
      return Float.compare(o1.getPrice(), o2.getPrice());
      }
    });
    return filterVehicles;
}
  
  /**
   * Retorna el tipo de cambio para la veta.
   * @return Tipo de cambio para la venta.
   * @throws NumberFormatException
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   * @throws Exception
   */
  public double getSell() throws NumberFormatException,
      ParserConfigurationException, SAXException, IOException, Exception {
    
    return ExchangeRate.getSell();
  }
  
  /**
   * Retorna el tipo de cambio para la compra.
   * @return El valor de la compra.
   * @throws NumberFormatException
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   * @throws Exception
   */
  public double getBuy() throws NumberFormatException, ParserConfigurationException, SAXException, IOException, Exception {
    return ExchangeRate.getBuy();
  }
  
  /**
   * Envia correos a los empleados.
   * @param from correo del emisor.
   * @param password contraseña del correo del emisor.
   * @param userMail correo destinatario.
   * @param subject tema del correo.
   * @param body cuerpo del correo.
   */
  public void sendMail(String from, String password, String userMail, String subject, String body) {
    try {
      Mail newMail = new Mail(from, password, userMail, subject, body);
      newMail.sendMail();
    } catch (AddressException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
  
}
