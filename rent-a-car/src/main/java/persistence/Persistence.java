package persistence;

import bussineslogic.Client;
import bussineslogic.Address;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import javax.imageio.ImageIO;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * Clase para la persistencia de datos
 * @author Marcosmh0199
 * @version 30/03/2019
 */
public class Persistence {
  /**
   * Método para convertir una imagen a un string codificado en base64
   * @param image imagen que será convertida
   * @return imageToBase64 string formado a partir de la imagen
   * @throws IOException
   */
  private String convertImgToString(Image image) throws IOException {
    byte[] imageBytes;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ImageIO.write((RenderedImage)image, "png", output);
    imageBytes = output.toByteArray();
    String imageToBase64 = Base64.getEncoder().encodeToString(imageBytes);
    return imageToBase64;
  }
  /**
   * Método para convertir un string codificado en base64 a una imagen
   * @param imageString string que será convertido a imagen
   * @return image Imagen formada a partir del string
   * @throws IOException
   */
  private Image convertStringToImage(String imageString) throws IOException {
    String base64Image = imageString;
    byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
    Image image = ImageIO.read(new ByteArrayInputStream(imageBytes));
    return image;
  }
  /**
   * Método para guardar un cliente en un archivo .json
   * @param client cliente que será guardado
   * @throws Exception
   */
  public void saveClient(Client client) throws Exception {  
    ArrayList<String> clientData= new ArrayList<String>();
    ArrayList<String> clientLicenses = new ArrayList<String>();
    clientData.add(client.getName());
    clientData.add(client.getId());
    clientData.add(client.getTelephone());
    clientData.add(client.getMail());
    clientData.add(client.getClientAddress().getProvince());
    clientData.add(client.getClientAddress().getCanton());
    clientData.add(client.getClientAddress().getDistrict());
    clientData.add(client.getClientAddress().getSings());
    for(int i = 0; i < client.getLicenses().size(); i++) {
      SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
      clientLicenses.add(client.getLicenses().get(i).getId());
      clientLicenses.add(formatDate.format(client.getLicenses().get(i).getReleaseDate()));
      clientLicenses.add(formatDate.format(client.getLicenses().get(i).getExpireDate()));
      clientLicenses.add(convertImgToString(client.getLicenses().get(i).getImage()));
    }
    for(int i = 0; i < clientLicenses.size(); i++) {
      clientData.add(clientLicenses.get(i));
    }
    try {
      JSONParser parser = new JSONParser();
      JSONArray clients = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
          + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
          + "rent-a-car\\clients.json"));
      clients.add(clientData);
      Files.write(Paths.get("clients.json"), clients.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray clients = new JSONArray();
      clients.add(clientData);
      Files.write(Paths.get("clients.json"), clients.toJSONString().getBytes());
      }
  } 
  
  /**
   * Método para cargar los clientes previamente registrados
   * @return clients ArrayList que contiene todos los clientes registrados
   * @throws Exception
   */
  public ArrayList<Client> loadClients() throws Exception {  
    JSONParser parser = new JSONParser();
    JSONArray clientsArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
        + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
        + "rent-a-car\\clients.json"));
    ArrayList<String> clientData= new ArrayList<String>();
    ArrayList<Client> clients = new ArrayList<Client>();
    for(int i = 0; i < clientsArray.size(); i++) {
      clientData = (ArrayList<String>) clientsArray.get(i);
      final String NAME = clientData.get(0);
      final String ID = clientData.get(1);
      final String TELEPHONE = clientData.get(2);
      final String MAIL = clientData.get(3);
      final String PROVINCE = clientData.get(4);
      final String CANTON = clientData.get(5);
      final String DISTRICT = clientData.get(6);
      final String SINGS = clientData.get(7);
      clientData = (ArrayList<String>) clientsArray.get(i);
      Address address = new Address(PROVINCE,CANTON,DISTRICT,SINGS);
      Client client = new Client(NAME,ID,TELEPHONE,MAIL,address);
      for(int j = 8; j < (clientData.size()-2); j = j+4) {
        final Date RELEASEDATE = new SimpleDateFormat("dd/MM/yyyy").parse(clientData.get(j+1));
        final Date EXPIREDATE = new SimpleDateFormat("dd/MM/yyyy").parse(clientData.get(j+2));
        final Image IMAGE = convertStringToImage(clientData.get(j+3));
        client.addLicense(RELEASEDATE, EXPIREDATE, IMAGE);
      }
      clients.add(client);
    }
    return clients;
  }
}