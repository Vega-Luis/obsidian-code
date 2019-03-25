package bussineslogic;

import java.util.Date;

/**
 * This is a class for the maintenances that are applicable to Vehicle.
 * 
 * @author Antony Artavia Palma
 * @version 25/03/2019
 */
public class Maintenance {
  private boolean type;  //if true, the type of the maintenance is preventive
  private String id;
  private static int amount;
  private Date startDate;
  private Date endDate;
  private float price;
  private String detail;
  private Company company;
  
  /**
   * This is the constructor to create objects type Maintenance.
   * 
   * @param type  is the type of the Maintenance if its true the maintenance is preventive
   * @param id
   * @param startDate 
   * @param endDate 
   * @param price 
   * @param detail
   */
  public void Maintenance(boolean type, String id, Date startDate, Date endDate, Float price, String detail) {
    this.type = type;
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
    this.detail = detail;
  }
}
