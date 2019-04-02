package util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Clase para realizar cifrado de datos especificamente String.
 * 
 * @author Antony Artavia Palma
 * @version 01/04/2019
 */
public class Chyperer {
  private static final String ALGO = "AES";
  private byte[] keyValue;
  
  /**
   * Constructor de objetos de tipo Chyperer.
   * 
   * @param key  Llave con base en la cual se hara el encriptado y desencryptado de datos.
   */
  public Chyperer(String key) {
    keyValue = key.getBytes();
  }
  
  /**
   * Metodo para encriptar un dato.
   * 
   * @param data  Dato a encriptar.
   * @return  Un String con la encriptacion del dato recibido.
   * @throws Exception
   */
  public String encrypt(String data) throws Exception {
    Key key = generateKey();
    Cipher cipherer = Cipher.getInstance(ALGO);
    cipherer.init(Cipher.ENCRYPT_MODE, key);
    byte[] encVal = cipherer.doFinal(data.getBytes());
    String encriptedValue = new BASE64Encoder().encode(encVal);
    return encriptedValue;
  }
  
  /**
   * Este metodo toma un dato encriptado y lo desencripta.
   * 
   * @param encryptedData  Dato encriptado a desencriptar.
   * @return Un String desencriptado de un dato encriptado.
   * @throws Exception
   */
  public String decrypt(String encryptedData) throws Exception {
    Key key = generateKey();
    Cipher cipherer = Cipher.getInstance(ALGO);
    cipherer.init(Cipher.DECRYPT_MODE, key);
    byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
    byte[] decValue = cipherer.doFinal(decordedValue);
    String decryptedValue = new String(decValue);
    return decryptedValue;
  }
  
  /**
   * Metodo que instancia un objeto Key con base en los dos atributos de la clase.
   * 
   * @return  Un objeto de tipo key.
   * @throws Exception
   */
  public Key generateKey() throws Exception {
    Key key = new SecretKeySpec(keyValue, ALGO);
    return key;
  }
}
