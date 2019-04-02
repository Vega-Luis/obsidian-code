package webservicecapture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Esta clase permite la coneccion con el WS del BCCR.
 * @author Luis
 * @version V1.0
 */
public final class SOAP {
  /**
   * Crea una comunicacion con el web service del BCCR y obtiene un una respuesta en formato XML
   * @param pUrl Url del WS con los parametros que requiere.
   * @return Respuesta del WS en formato XML.
   * @throws Exception
   */
  public static String response(String pUrl) throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL(pUrl);
    HttpURLConnection conection = (HttpURLConnection) url.openConnection();
    conection.setRequestMethod("GET");
    BufferedReader reader = new BufferedReader(new InputStreamReader(conection.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
       result.append(line);
    }
    reader.close();
    return result.toString();
  }

}
