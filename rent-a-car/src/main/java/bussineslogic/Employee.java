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
    this.password = generatePassword();
  }

  /**
   * Método para generar una contraseña aleatoria
   * @return password Contraseña del usuario del empleado
   */
  private String generatePassword() {
    EnglishCharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
    CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
    EnglishCharacterData upperCaseChars = EnglishCharacterData.UpperCase;
    CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
    EnglishCharacterData digitChars = EnglishCharacterData.Digit;
    CharacterRule digitCharsRule = new CharacterRule(digitChars);
    EnglishCharacterData specialChars = EnglishCharacterData.Special;
    CharacterRule specialCharsRule = new CharacterRule(specialChars);
    Random rand = new Random(); 
    PasswordGenerator passwordGenerator = new PasswordGenerator();
    String simbols= "!#$?@^~";
    String password = passwordGenerator.generatePassword(1,lowerCaseRule);
    password += simbols.charAt((rand.nextInt(8)));
    password += passwordGenerator.generatePassword(1,upperCaseRule);
    password += passwordGenerator.generatePassword(1,digitCharsRule);
    password += passwordGenerator.generatePassword(rand.nextInt(5)+4, lowerCaseRule,
        upperCaseRule, digitCharsRule, specialCharsRule);
    return password;
  }
}
