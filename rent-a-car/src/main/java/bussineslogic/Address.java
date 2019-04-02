package bussineslogic;

/**
 * Modela direcciones.
 * @author Luis
 * @version v1.0
 */
public class Address {
  private String province;
  private String canton;
  private String district;
  private String sings;
  
  /**
   * Constructor de objetos de clase Address.
   * @param province Provincia relacionada a la direccion.
   * @param canton Canton de la direccion.
   * @param district Distrito de la direccion.
   * @param sings Senas que indetifican la direccion.
   */
  public Address(String province, String canton, String district, String sings) {
    this.province = province;
    this.canton = canton;
    this.district = district;
    this.sings = sings;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCanton() {
    return canton;
  }

  public void setCanton(String canton) {
    this.canton = canton;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getSings() {
    return sings;
  }

  public void setSings(String sings) {
    this.sings = sings;
  }
}
