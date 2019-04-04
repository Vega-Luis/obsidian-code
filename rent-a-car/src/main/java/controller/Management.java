package controller;

import bussineslogic.Address;
import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Vehicle;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import persistence.Persistence;

/**
 * Esta clase esta encargada de controlar la interaccon entre la logica de negocios
 * y la interfaz grafica.
 * @author Luis
 * @version v1.0
 */
public class Management {
  private ArrayList<Vehicle> vehicles;
  private ArrayList<Client> clients;
  private ArrayList<Employee> employees;
  private Persistence persistence;
  private final int NOT_ADDED = 0;
  
  public Management() {
    this.persistence = new Persistence();
  }
  
  private void setVehicles() {
    try {
      this.vehicles = this.persistence.loadVehicles();
    } catch (Exception e) {
      this.vehicles = new ArrayList<Vehicle>();
      e.printStackTrace();
    }
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

  /**
   * Busca un cliente y retorna la posicion donde se encuentra.
   * Sin no existe retona un -1.
   * @param id Identificador del cliente.
   * @return Posicion  que se encuentra el cliente dentro del clients
   */
  private int searchClient(String id) {
    for (int client = 0; client < vehicles.size(); client++) {
      if (clients.get(client).getId().equals(id)) {
        return client;
      }
    }
    return NOT_ADDED;
  }
  
  /**
   * Busca un vehiculo y retorna la posiscion donde se encuentra dentro del Array de vehiculos.
   * Si el vehiculo no existe retorna -1.
   * @param plate Placa del vehiculo.
   * @return Posicion del arreglo de vehiculos donde se encuentra el vehiculo.
   */
  private int searchVehicle(String plate) {
    for (int vehicle = 0; vehicle < vehicles.size(); vehicle++) {
      if (vehicles.get(vehicle).getVehiclePlate().equals(plate)) {
        return vehicle;
      }
    }
    return NOT_ADDED;
  }
  
  /**
   * Crea una nueva direccion.
   * @param province Provincia relacionada a la direccion.
   * @param canton Canton de la direccion.
   * @param district Distrito de la direccion.
   * @param sings Senas que indetifican la direccion.
   */
  public Address addAddress(String province, String canton, String district, String sings) {
    return new Address(province, canton, district, sings);
  }
  
  /**
   * Agrega un nuevo cliente a la lista de clientes.
   * @param name nombre del cliente
   * @param id id del cliente
   * @param telephone número telefónico del cliente
   * @param mail correo-electrónico del cliente
   * @param clientAddress dirreción del cliente
   */
  public void addClient(String name, String id, String telephone, String mail, Address clientAddress) {
    if (searchClient(id) == NOT_ADDED) {
      clients.add(new Client(name, id, telephone, mail, clientAddress));
    }
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
   * Agrega un vehiculo a la flotilla de vehiculos.
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
   */
  public void addVehicle(String vehiclePlate, Date fabricationDate, Color color, byte capacity,
      String brand, byte doors, String vinNumber, float mpg, float price, byte suitcaseCapacity,
          boolean transmission) {
    if (searchVehicle(vehiclePlate) == NOT_ADDED) {
      vehicles.add(new Vehicle(vehiclePlate,fabricationDate, color, capacity, brand, doors,
          vinNumber, mpg, price, suitcaseCapacity, transmission));
    }
  }
  
  /**
   * Modifica la imagen del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param vehicleImage Imagen del vehiculo.
   */
  public void modifyImage(String vehiclePlate, Image vehicleImage) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
      vehicles.get(searchVehicle(vehiclePlate)).setVehicleImage(vehicleImage);
    }
  }
  
  /**
   * Modifica la fecha de fabricacion del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param fabricationDate Fecha de fabricacion del vehiculo.
   */
  public void modifyFabricationDate(String vehiclePlate, Date fabricationDate) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setFabricationDate(fabricationDate);
    }
  }
  
  /**
   * Modifica el color de vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param color Color del vehiculo.
   */
  public void modifyColor(String vehiclePlate, Color color) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setColor(color);;
    }
  }
  
  /**
   * Modifica la capacidad del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param capacity Capacidad del vehiculo.
   */
  public void modifyCapacity(String vehiclePlate, byte capacity) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setCapacity(capacity);;
    }
  }
  
  /**
   * Modifica la marca del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param brand Marca del vehiculo.
   */
  public void modifyBrand(String vehiclePlate,String brand ) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setBrand(brand);
    }
  }
  
  /**
   * Modifica la cantidad de puertas del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param doors Cantidad de puertas del vehiculo.
   */
  public void modifyDoors(String vehiclePlate,byte doors) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setDoors(doors);
    }
  }
  
  /**
   * Modifica el numero de vin del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param vinNumber Numero de vin del vehiculo.
   */
  public void modifyVinNumber(String vehiclePlate,String vinNumber) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setVinNumber(vinNumber);
    }
  }
  
  /**
   * Modifica las millas por galon que soporta el vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param mpg Cantidad de millas por galon.
   */
  public void modifyMpg(String vehiclePlate,float mpg ) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setMpg(mpg);
    }
  }
  
  /**
   * Modifica el precion del vehiculo.
   * @param vehiclePlate Placa del vehiculo.
   * @param price Precio del vehiculo.
   */
  public void modifyPrice(String vehiclePlate,float price ) {
    if (searchVehicle(vehiclePlate) != NOT_ADDED) {
    vehicles.get(searchVehicle(vehiclePlate)).setPrice(price);
    }
  }
  
  
}
