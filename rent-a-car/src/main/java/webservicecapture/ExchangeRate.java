package webservicecapture;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Obtiene el tipo de cambio.
 * @author Luis
 * @version v1.0
 */
public final class ExchangeRate implements IWebConstants{
  /**
   * Crea la url de consulta, al agregar al host los parametros 
   * que se requiere el WS
   * @param pType Tipo de consulta que puede ser compra o venta.
   * @return Url con los parametros que requiere para la consulta.
   */
  public static String setUrl(short pType) {
    return HOST + TC_INDICATOR + pType +BEGIN_DATE + setSystemDate() + FINISH_DATE + setSystemDate() + TC_NAME + TC_SUBLEVELS;
  }
  
  /**
   * Toma la fecha del sistema para consultar el tipo de cambio.
   */
  public static String setSystemDate() {
    Date date = new Date();
    SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
    return formattedDate.format(date);
  }
  
  /**
   * Obtiene el valor de la compra.
   * @return Valor de la compra.
   * @throws NumberFormatException
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   * @throws Exception
   */
  public static double getBuy() throws NumberFormatException, ParserConfigurationException, SAXException, IOException, Exception {
    return Double.parseDouble(XmlParser.parseXml(SOAP.response((setUrl(BUY)))));
    
  }
  
  /**
   * Obtiene el valor de la venta.
   * @return Valor de la venta.
   * @throws NumberFormatException
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   * @throws Exception
   */
  public static double getSell() throws NumberFormatException, ParserConfigurationException, SAXException, IOException, Exception {
    return Double.parseDouble(XmlParser.parseXml(SOAP.response((setUrl(SELL)))));
  }
  
}
