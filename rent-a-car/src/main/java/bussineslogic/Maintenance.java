package bussineslogic;

import java.util.Date;

/**
 * Esta es una clase para mantenimientos que son aplicables a los vehiculos.
 * 
 * @author Antony Artavia Palma
 * @version 01/04/2019
 */
public class Maintenance {
  private boolean type;  //if true, the type of the maintenance is preventive
  private String id;
  private static int amount = 0;
  private Date startDate;
  private Date endDate;
  private float price;
  private String detail;
  private Company company;
  
  /**
   * Este es el constructor para crear objetos de tipo mantenimiento.
   * 
   * @param type  Es el tipo de mantenimiento si es true preventivo.
   * @param idVehiculo   Es el id del vehiculo del mantenimiento.
   * @param startDate   Es la fecha en la que se inicio el mantenimiento. 
   * @param endDate    Es la fecha en que finalizo el mantenimiento.
   * @param price    Es los que costo el mantenimiento.
   * @param detail   Son los detalles acerca del mantenimiento
   */
  public Maintenance(boolean type, String idVehiculo, Date startDate, Date endDate, Float price, String detail) {
    this.type = type;
    amount++;
    this.id = "MANT-"+ id + amount;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
    this.detail = detail;
  }
  
  public Date getStartDate() {
    return startDate;
  }
  
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  public Date getEndDate() {
    return endDate;
  }
  
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getId() {
    return id;
  }
  
  public static int getAmount() {
    return amount;
  }
  
  public float getPrice() {
    return price;
  }
  
  public String getDetail() {
    return detail;
  }
  
  public Company getCompany() {
    return company;
  }

  public boolean getType() {
    return type;
  }

  public void setType(boolean type) {
    this.type = type;
  }
}
