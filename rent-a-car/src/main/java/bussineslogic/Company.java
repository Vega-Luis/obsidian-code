package bussineslogic;

/**
 * Modela la empresa de servicios de mantenimiento.
 * @author Luis
 * @version v1.0
 */
public class Company {
  private String bussinesName;
  private String legalNumber;
  private String telephone;
  
  /**
   * Constructor de objetos de clase Company.
   * @param bussinesName Nombre de la compania.
   * @param legalNumber Cedula juridica de la compania.
   * @param telephone Telefono de la compania.
   */
  public Company(String bussinesName, String legalNumber, String telephone) {
    this.bussinesName = bussinesName;
    this.legalNumber = legalNumber;
    this.telephone = telephone;
  }

  public String getBussinesName() {
    return bussinesName;
  }

  public void setBussinesName(String bussinesName) {
    this.bussinesName = bussinesName;
  }

  public String getLegalNumber() {
    return legalNumber;
  }

  public void setLegalNumber(String legalNumber) {
    this.legalNumber = legalNumber;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  
  public String toString() {
    String msg = getBussinesName();
    return msg;
  }
}
