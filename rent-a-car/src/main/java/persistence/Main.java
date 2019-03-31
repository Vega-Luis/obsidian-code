package persistence;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import bussineslogic.Address;
import bussineslogic.Client;
import bussineslogic.License;

public class Main {

  public static void main(String[] args) throws Exception {
    Address address = new Address("Chepe","PZ","Platanares","Cerca escuela molle");
    Client client = new Client("Marcos","117","8511","gmail",address);
    Calendar calendar = Calendar.getInstance();
    Date date1 = calendar.getTime();
    Image picture = ImageIO.read(new File("C:\\Users\\Marcosmh0199\\Documents\\AS ESPADAS.png"));
    ArrayList<Client> clients;
    client.addLicense(date1,date1, picture);
    client.addLicense(date1,date1, picture);
    client.addLicense(date1,date1, picture);
    
    Client client2 = new Client("Pepe","117","8511","gmail",address);
    client2.addLicense(date1,date1, picture);
    client2.addLicense(date1,date1, picture);
    client2.addLicense(date1,date1, picture);
    Persistence persistence = new Persistence();
    //System.out.println(client);
    persistence.saveClient(client2);
    
    clients= persistence.loadClients();
    for(int i = 0; i < clients.size(); i++) {
      System.out.println(clients.get(i)+"\n\n");
    }
    
  }

}
