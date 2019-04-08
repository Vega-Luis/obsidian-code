package controller;

import bussineslogic.Address;
import bussineslogic.Branch;
import bussineslogic.Client;
import bussineslogic.Company;
import bussineslogic.Employee;
import bussineslogic.Maintenance;
import bussineslogic.Vehicle;
import bussineslogic.VehicleStyle;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import persistence.Persistence;

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
  private Persistence persistence;
  private final int NOT_ADDED = 0;

  public Management() {
    this.persistence = new Persistence();
    this.setClients();
    this.setEmployees();
    this.setBranches();
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
      this.persistence.loadBranches();
    } catch (Exception e) {
      this.branches = new ArrayList<Branch>();
      e.printStackTrace();
    }
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
   * Crea un nuevo mantenimiento.
   * @param type  Es el tipo de mantenimiento si es true preventivo.
   * @param idVehiculo   Es el id del vehiculo del mantenimiento.
   * @param startDate   Es la fecha en la que se inicio el mantenimiento. 
   * @param endDate    Es la fecha en que finalizo el mantenimiento.
   * @param price    Es los que costo el mantenimiento.
   * @param detail   Son los detalles acerca del mantenimiento.
   * @return Un nuevo mantenimiento para un vehiculo.
   */
  public Maintenance addMaintenance(boolean type, String idVehiculo, Date startDate, Date endDate,
      Float price, String detail, Company company) {
    return new Maintenance(type,idVehiculo,startDate,endDate, price, detail, company);
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
          float mpg, float price, byte suitcaseCapacity, boolean transmission, Image vehicleImage,VehicleStyle style) {
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
    return true;
  }
  
}
