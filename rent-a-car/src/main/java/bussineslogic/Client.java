package bussineslogic;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para crear objetos tipo cliente
 * @author Marcosmh0199
 * @version 25/03/2019
 */
public class Client extends Person {

  Address clientAddress;
  ArrayList<License> licenses;
  /**
   * Constructor de la clase
   * @param name nombre del cliente
   * @param id id del cliente
   * @param telephone número telefónico del cliente
   * @param mail correo-electrónico del cliente
   * @param clientAddress dirreción del cliente
   */
  public Client(String name, String id, String telephone, String mail, Address clientAddress) {
    super(name, id, telephone, mail);
    setClientAddress(clientAddress);
    setLicenses();
  }

  public Address getClientAddress() {
    return clientAddress;
  }
  
  public void setClientAddress(Address clientAddress) {
    this.clientAddress = clientAddress;
  }
  
  public ArrayList<License> getLicenses(){
    return licenses;
  }
  
  public void setLicenses() {
    licenses = new ArrayList<License>();
  }
  
  public void addLicense(Date releaseDate, Date expireDate, Image image) {
    licenses.add(new License(getId(),releaseDate, expireDate, image));
  }
  @Override
  public String toString() {
    String msg = "Nombre:"+getName()+"\n";
    for(int i = 0; i < getLicenses().size(); i++) {
      msg+= "Foto:"+getLicenses().get(i).getImage().toString()+"\n";
    }
    return msg;
  }
}
