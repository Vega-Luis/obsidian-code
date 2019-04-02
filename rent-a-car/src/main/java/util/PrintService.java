package util;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.Sides;

/**
 * Recibe y procesa solicitudes de impresion.
 * @author Luis
 * @version v1.0
 */
public class PrintService {
  private String psStream;
  private  DocFlavor psInFormat;
  private PrintRequestAttributeSet  attributeSet;
  private Doc document;
  private javax.print.PrintService[] services;
  
  /**
   * Constructor de servicios de impresion.
   * @param psStream String con los datos a imprimir.
   */
  public PrintService(String psStream) {
    this.psStream = psStream;
    setPsInFormat();
    setDocument();
    setAttributeSet();
    setServices();
    
  }
  
  /**
   * Asigna el formato de entrada del objeto que se desea imprimir.
   * En este caso es un String.
   */
  private void setPsInFormat() {
    this.psInFormat = DocFlavor.STRING.TEXT_PLAIN;
  }
  
  /**
   * Asigna atributos al documento a imprimir.
   */
  private void setAttributeSet() {
    this.attributeSet = new HashPrintRequestAttributeSet();
    attributeSet.add(new Copies(1));
    attributeSet.add(MediaSize.ISO.A4);
    attributeSet.add(Sides.DUPLEX);
  }
  
  /**
   * Crea un documento preparado para la impresion. El documento se crea con los atributos
   * y el archivo de entrada.
   */
  private void setDocument() {
    this.document = new SimpleDoc(psStream, psInFormat, null);  
  }
  
  /**
   * Crea un lista con los servicios pendientes de impresion.
   */
  private void setServices() { 
    this.services = PrintServiceLookup.lookupPrintServices(psInFormat, attributeSet);
  }

  /**
   * Manda a imprimir el archivo.
   */
  public void print() {
    if (services.length > 0) {
      DocPrintJob job = services[0].createPrintJob();
      try {
           job.print(document, attributeSet);
      } catch (PrintException pe) {}
   }
  }
}
