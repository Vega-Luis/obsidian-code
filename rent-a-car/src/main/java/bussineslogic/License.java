package bussineslogic;

import java.awt.Image;
import java.util.Date;

/**
 * Clase para crear objetos tipo licencia
 * @author Marcosmh0199
 * @version 25/03/2019
 */
public class License {
  private String id;
  private Date releaseDate;
  private Date expireDate;
  private Image image;
  
  /**
   * Constructor de la clase
   * @param id cedula del cliente dueño de la cédula
   * @param releaseDate fecha en la que fue emitida la cédula
   * @param expireDate fecha en la que expira la cédula
   */
  public License(String id, Date releaseDate, Date expireDate, Image image) {
    setId(id);
    setReleaseDate(releaseDate);
    setExpireDate(expireDate);
    setImage(image);
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public Date getReleaseDate() {
    return releaseDate;
  }
  
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }
  
  public Date getExpireDate() {
    return expireDate;
  }
  
  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }
  
  public Image getImage() {
    return image;
  }
  
  public void setImage(Image image) {
    this.image = image;
  }
}
