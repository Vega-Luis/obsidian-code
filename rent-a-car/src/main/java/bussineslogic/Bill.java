package bussineslogic;

/**
 * This is a class for the bill that its generated when occur a reservation.
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
   * This is the constructor to create objects type Bill.
   * 
   * @param totalCost
   * @param client
   * @param vehicle
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
