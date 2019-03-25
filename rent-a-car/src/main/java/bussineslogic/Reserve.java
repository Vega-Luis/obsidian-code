package bussineslogic;

import java.util.Date;

/**
 * This is a class for the reserves of of the client service of "ren a car".
 * 
 * @author Antony Artavia Palma
 * @version 25/03/2019
 */
public class Reserve {
  private Date startDate;
  private Date endDate;
  private Date requestDate;
  private Service service;
  private Client client;
  private Employee employee;
  private Vehicle vehicle;
  private Branch collectionBranc;
  private Branch deliveryBranch;
  
  /**
   * @param collectionBranch 
   * @param deliveryBranch 
   * @param service 
   * @param client Client 
   * @param employee 
   * @param vehicle 
   * @param starDate 
   * @param endDate 
   * @param requesDate
   */
  public void Reserve(Branch collectionBranch, Branch deliveryBranch, Service service, Client client, Employee employee, Vehicle vehicle, Date starDate, Date endDate, Date requesDate) {
    this.startDate = starDate;
    this.endDate = endDate;
    this.requestDate = requesDate;
    this.service = service;
	this.client = client;
	this.employee = employee;
	this.vehicle = vehicle;
	this.collectionBranc = collectionBranch;
	this.deliveryBranch = deliveryBranch;
  }
}
