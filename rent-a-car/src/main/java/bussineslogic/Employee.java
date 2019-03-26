package bussineslogic;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import java.util.Random; 

/**
 * Clase para crear objetos tipo empleado
 * @author Marcosmh0199
 * @version 25/03/1999
 */
public class Employee extends Person {

  private String userName;
  private String password;
  
  /**
   * Constructor de la clase
   * @param name nombre del empleado
   * @param id cédula del empleado
   * @param telephone número telefónico del empleado
   * @param mail correo-electrónico del empleado
   */
  public Employee(String name, String id, String telephone, String mail) {
    super(name, id, telephone, mail);
    setPassword();
    setUserName();
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName() {
    userName = mail.substring(0, mail.indexOf("@"));
  }

  public String getPassword() {
    return password;
  }

  public void setPassword() {
    this.password = generatePassoword();
  }

  /**
   * Método para generar una contraseña aleatoria
   * @return password Contraseña del usuario del empleado
   */
  private String generatePassoword() {
    CharacterRule digits = new CharacterRule(EnglishCharacterData.UpperCase.LowerCase.Digit.Special);
    Random rand = new Random(); 
    
    PasswordGenerator passwordGenerator = new PasswordGenerator();
    String password = passwordGenerator.generatePassword(rand.nextInt(5)+8, digits);
    return password;
  }
  
}
