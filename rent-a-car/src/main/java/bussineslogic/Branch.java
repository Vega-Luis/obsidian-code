package bussineslogic;

import java.util.ArrayList;

/**
 * Modela sedes a la compania de servicios.
 * @author Luis
 * @version v1.0
 */
public class Branch {
  private ArrayList<Vehicle> vehicles;
  private String name;
  private Address address;

  /**
   * Constructor de objetos de clase Branch.
   * @param name Nombre de sede de la compania que brinda el servicio.
   */
  public Branch(String name, Address address) {
    this.vehicles = new ArrayList<Vehicle>();
    this.name = name;
    this.address = address;
  }
  
  /**
   * Consulta todos los vehiculos de la sede.
   * @return Arreglo de vehiculos.
   */
  public ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }
  
  public void setVehicles(ArrayList<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }
  /**
   * Consulta por placa un vehiculo a la sede.
   * @param vehiclePlate Placa del vehiculo.
   * @return El vehiculo consultado si existe. Si no existe, retornara un null.
   */
  public Vehicle getVehicle(String vehiclePlate) {
    for(Vehicle vehicle :vehicles) {
      if (vehicle.getVehiclePlate().equals(vehiclePlate)) {
        return vehicle;
      }
    }
      return null;
  }
  
  /**
   * Obtiene el nombre de la empresa.
   * @return nombre de la empresa.
   */
  public String getName() {
    return name;
  }
  
  /**
   * Asigna nombre a la empresa.
   * @param name Nombre de la empresa.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Agrega vehiculo a la sede.
   * @param vehicle Vehiculo que sera agregado a la sede.
   */
  public void add(Vehicle vehicle) {
    this.vehicles.add(vehicle); 
  }
  
  /**
   * Elimina un vehiculo a la sede.
   * @param vehiclePlate Placa de vehiculo  a eleminar.
   * @return Booleano que indica si la remocion fue exitosa.
   */
  public boolean remove(String vehiclePlate) {
    for(Vehicle vehicle :vehicles) {
      if (vehicle.getVehiclePlate().equals(vehiclePlate)) {
        vehicles.remove(vehicle);
      }
    }
    return false;
  }  
}
