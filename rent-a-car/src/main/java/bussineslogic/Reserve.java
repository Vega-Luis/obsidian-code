package bussineslogic;

import java.util.Date;

/**
 * Esta es una clase para reservas del servicio al cliente del "rent a car".
 * 
 * @author Antony Artavia Palma
 * @version 01/04/2019
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
   * Constructor para crear objetos de tipo reserve.
   * 
   * @param collectionBranch  Es la sede de la que se reservara el vehiculo.
   * @param deliveryBranch   Es la sede en la que se entregara el vehiculo.
   * @param service     Es una objeto de servicio que incluye cuales servicios rigen en la reserva.
   * @param client Client  Es el cliente que solicita la reserva.
   * @param employee    Es el empleado que realiza la reserva.
   * @param vehicle   Es el vehiculo que se solicito.
   * @param starDate  Es la fecha en la que se le entrega el vehiculo al cliente.
   * @param endDate   Es la fecha en la que concluye la reserva.
   * @param requesDate   Es la fecha en la que se solicito la reserva.
   */
  public Reserve(Branch collectionBranch, Branch deliveryBranch, Service service, Client client,
      Employee employee, Vehicle vehicle, Date starDate, Date endDate, Date requesDate) {
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

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public Date getRequestDate() {
    return requestDate;
  }

  public Service getService() {
    return service;
  }

  public Client getClient() {
    return client;
  }

  public Employee getEmployee() {
    return employee;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Branch getCollectionBranc() {
    return collectionBranc;
  }

  public Branch getDeliveryBranch() {
    return deliveryBranch;
  }
}
