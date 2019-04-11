package util;

/**
 * Clase para crear objetos tipo Place que sirven para hacer rastreos por ubicación
 * @author Marcosmh0199
 * @version v10.4.19
 */
public class Place {
  String name;
  String latitude;
  String longitude;
  
  public Place(String name, String latitude, String longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLatitude() {
    return latitude;
  }
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
  public String getLongitude() {
    return longitude;
  }
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
  
  public String toString() {
    return this.name;
  }
  
}
