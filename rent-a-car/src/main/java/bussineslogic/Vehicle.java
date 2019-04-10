package bussineslogic;

import java.util.Date;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Modela vehiculos.
 * 
 * @author Luis
 * @version v1.0
 */
public class Vehicle {
  private String vehiclePlate;
  private Date fabricationDate;
  private String color;
  private byte capacity;
  private String brand;
  private float kilometers;
  private byte doors;
  private String vinNumber;
  private float mpg;
  private float price;
  private byte suitcaseCapacity;
  private boolean transmission;
  private ArrayList<Maintenance> maintenances;
  private VehicleStyle style;
  private VehicleState state;
  private Image vehicleImage;

  /**
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
  public Vehicle(String vehiclePlate, Date fabricationDate, String color, byte capacity,
      String brand, byte doors, String vinNumber, float mpg, float price, byte suitcaseCapacity,
          boolean transmission) {
    this.vehiclePlate = vehiclePlate;
    this.fabricationDate = fabricationDate;
    this.color = color;
    this.capacity = capacity;
    this.brand = brand;
    this.doors = doors;
    this.vinNumber = vinNumber;
    this.mpg = mpg;
    this.price = price;
    this.suitcaseCapacity = suitcaseCapacity;
    this.transmission = transmission;
    this.maintenances = new ArrayList<Maintenance>();
  }

  public String getVehiclePlate() {
    return vehiclePlate;
  }

  public void setVehiclePlate(String vehiclePlate) {
    this.vehiclePlate = vehiclePlate;
  }

  public Date getFabricationDate() {
    return fabricationDate;
  }

  public void setFabricationDate(Date fabricationDate) {
    this.fabricationDate = fabricationDate;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public byte getCapacity() {
    return capacity;
  }

  public void setCapacity(byte capacity) {
    this.capacity = capacity;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public float getKilometers() {
    return kilometers;
  }

  public void setKilometers(float kilometers) {
    this.kilometers = kilometers;
  }

  public byte getDoors() {
    return doors;
  }

  public void setDoors(byte doors) {
    this.doors = doors;
  }

  public String getVinNumber() {
    return vinNumber;
  }

  public void setVinNumber(String vinNumber) {
    this.vinNumber = vinNumber;
  }

  public float getMpg() {
    return mpg;
  }

  public void setMpg(float mpg) {
    this.mpg = mpg;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public byte getSuitcaseCapacity() {
    return suitcaseCapacity;
  }

  public void setSuitcaseCapacity(byte suitcaseCapacity) {
    this.suitcaseCapacity = suitcaseCapacity;
  }

  public boolean isTransmission() {
    return transmission;
  }

  public void setTransmission(boolean transmission) {
    this.transmission = transmission;
  }

  public ArrayList<Maintenance> getMaintenances() {
    return maintenances;
  }

  public void setMaintenances(ArrayList<Maintenance> maintenances) {
    this.maintenances = maintenances;
  }

  public VehicleStyle getStyle() {
    return style;
  }

  public void setStyle(VehicleStyle style) {
    this.style = style;
  }

  public VehicleState getState() {
    return state;
  }

  public void setState(VehicleState state) {
    this.state = state;
  }
  
    public Image getVehicleImage() {
    return vehicleImage;
  }

  public void setVehicleImage(Image vehicleImage) {
    this.vehicleImage = vehicleImage;
  }
  
  public String DataSelection() {
    String msg = "";
    if(getStyle() != null) {
      msg += getStyle().name() + '\n';
    } else {
      msg += "Se desconoce el estilo\n";
    }
    
    msg += getBrand() + '\n';
    
    if(transmission == true) {
      msg += "Transmision automatica\n";
    }
    else {
      msg += "Transmision manual\n";
    }
    
    return msg;
  }
  
  public String toString() {
    return vehiclePlate;
  }

}
