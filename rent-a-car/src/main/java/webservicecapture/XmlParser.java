package webservicecapture;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Parsea el xml de respueste del BCCR WS
 * @author Luis
 * @version v1.0
 *
 */
public final class XmlParser implements IWebConstants {

  /**
   * Parsea el xml que envia el WS con respuesta.
   * @param pXml
   * @return Valor del tipo de cambio.
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   */
  public static String parseXml(String pXml) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new InputSource(new StringReader(replaceChars(pXml))));
    Element rootElement = document.getDocumentElement();

    try {
      NodeList list = rootElement.getElementsByTagName(TAG);
      if (list != null && list.getLength() > 0) {
        NodeList subList = list.item(0).getChildNodes();

        if (subList != null && subList.getLength() > 0) {
          return subList.item(0).getNodeValue();
        }
      }

    } catch (Exception e) {
      return "0";
    }
    return "0";
  }

  /**
   * Reemplaza los caracteres inecesarios del xml.
   * @param string
   * @return Xml sin limpio.
   */
  private static String replaceChars(String string){
    string = string.replace("&lt;", "<");
    string = string.replace("&gt;", ">");
    return string;
  }

}
