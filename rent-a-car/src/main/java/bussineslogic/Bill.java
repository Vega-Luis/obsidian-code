package bussineslogic;

/**
 * Esta es una clase para la factura que se genera cuando se produce una reserva.
 * 
 * @author Antony Artavia Palma
 * @version 25/03/2019
 */
public class Bill {
  private float totalCost;
  private static int consecutiveNumber;
  private Client client;
  private Vehicle vehicle;

  /**
   * Constructor para crear objetos de tipo Bill.
   * 
   * @param totalCost   Costo total de la factura.
   * @param client   Cliente que realizo la reserva.
   * @param vehicle   Vehiculo que solicito el cliente
   */
  public Bill(float totalCost, Client client, Vehicle vehicle) {
    this.totalCost = totalCost;
    this.client = client;
    this.vehicle = vehicle;
    consecutiveNumber++;
  }
  
  public float getTotalCost() {
    return totalCost;
  }

  public Client getClient() {
    return client;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }
}
