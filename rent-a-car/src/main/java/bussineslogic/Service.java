package bussineslogic;

/**
 * This is a class for the services that offer the client service to "Rent a car".
 * 
 * @author Antony Artavia Palma
 * @version 25/03/2019
 */
public class Service {
  private boolean wifi;
  private boolean routeAssistance;
  private boolean gps;
  private boolean childSeat;
  private boolean ensurance;
  
  /**
   * This is the constructor to create objects type Service.
   * 
   * @param wifi
   * @param routeAssitance
   * @param gps
   * @param childSeat
   * @param ensurance
   */
  public Service(boolean wifi, boolean routeAssistance, boolean gps, boolean childSeat, boolean ensurance) {
    this.wifi = wifi;
    this.routeAssistance = routeAssistance;
    this.gps = gps;
    this.childSeat = childSeat;
    this.ensurance = ensurance;
  }

  public boolean getWifi() {
    return wifi;
  }
  
  public boolean getRouteAssistance() {
    return routeAssistance;
  }
  
  public boolean getGps() {
    return gps;
  }
  
  public boolean getChildSeat() {
    return childSeat;
  }
  
  public boolean getEnsurance() {
    return ensurance;
  }
}
