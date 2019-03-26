package bussineslogic;

/**
 * Superclase de la cual Client y Employee heredan características
 * @author Marcosmh0199
 * @version 25/03/2019
 */
public class Person {
  protected String name;
  protected String id;
  protected String telephone;
  protected String mail;
  
  /**
   * Constructor de la clase
   * @param name nombre de la persona
   * @param id id de la persona
   * @param telephone número telefónico de la persona
   * @param mail correo-electrónico de la persona
   */
  public Person(String name, String id, String telephone, String mail) {
    setName(name);
    setId(id);
    setTelephone(telephone);
    setMail(mail);
  }
  /**
   * Método para obtener el nombre
   * @return name nombre de la persona
   */
  public String getName() {
    return name;
  }
  
  /**
   * Método para fijar el valor del nombre
   * @param name nombre de la persona
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Método para obtener el id de una persona
   * @return
   */
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getTelephone() {
    return telephone;
  }
  
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  
  public String getMail() {
    return mail;
  }
  
  public void setMail(String mail) {
    this.mail = mail;
  }
  
  /**
   * Método para imprimir el objeto de manera legible
   * @return msg datos del objeto que seran imprimidos
   */
  public String toString() {
    String msg= "Nombre: "+getName();
    return msg;
  }
}
