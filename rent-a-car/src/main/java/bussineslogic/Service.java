package bussineslogic;

/**
 * Esta es una clase para los servicios que ofrecen el servicio al cliente para "rent a car".
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
   * Constructor para objetos de tipo servicio.
   * 
   * @param wifi   Si es verdadero el servico de wifi esta incluido.
   * @param routeAssitance   Si es verdadero el servico de asistente de ruta esta incluido.
   * @param gps   Si es verdadero el servico de GPS esta incluido.
   * @param childSeat   Si es verdadero el servico de asiento para niños esta incluido.
   * @param ensurance   Si es verdadero el servico de garantia esta incluido.
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
