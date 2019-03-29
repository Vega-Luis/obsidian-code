package persistence;

import bussineslogic.Client;
import bussineslogic.Address;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Persistence {
  public static void saveClients(String filename, Client client) throws Exception {  
    ArrayList<String> clientData= new ArrayList<String>();
    clientData.add(client.getName());
    clientData.add(client.getId());
    clientData.add(client.getTelephone());
    clientData.add(client.getMail());
    clientData.add(client.getClientAddress().getProvince());
    clientData.add(client.getClientAddress().getCanton());
    clientData.add(client.getClientAddress().getDistrict());
    clientData.add(client.getClientAddress().getSings());
    try {
      JSONParser parser = new JSONParser();
      JSONArray clients = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
          + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
          + "rent-a-car\\archivo.json"));
      clients.add(clientData);
      Files.write(Paths.get(filename), clients.toJSONString().getBytes());
    }catch(Exception d) {
      JSONArray clients = new JSONArray();
      clients.add(clientData);
      Files.write(Paths.get(filename), clients.toJSONString().getBytes());
      }
  } 
  
  public static ArrayList<Client> loadClients(String filename) throws Exception {  
    JSONParser parser = new JSONParser();
    JSONArray clientsArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Marcosmh0199\\Docume"
        + "nts\\TEC\\2019\\PrimerSemestre\\POO\\Proyectos\\Proyecto1-Rent a Car\\obsidian-code\\"
        + "rent-a-car\\archivo.json"));
    ArrayList<String> clientData= new ArrayList<String>();
    ArrayList<Client> clients = new ArrayList<Client>();
    for(int i = 0; i < clientsArray.size(); i++) {
      clientData = (ArrayList<String>) clientsArray.get(i);
      Address address = new Address(clientData.get(4),clientData.get(5),clientData.get(6),clientData.get(7));
      Client client = new Client(clientData.get(0),clientData.get(1),clientData.get(2),clientData.get(
          3), address);
      clients.add(client);
    }
    return clients;
  }
  public static void main(String[] args) throws Exception {
    Address address = new Address("San Jose", "Perez Zeledon", "Platanares","800mts noroeste escue"
        + "la Mollejones");
    Client cliente = new Client("Licho", "117410580", "85116570","marcosmh0199@gmail.com", address);
    saveClients("archivo.json", cliente);
    ArrayList<Client> clients = loadClients("archivo.json");
    for(int i = 0; i < clients.size(); i++) {
      System.out.print(clients.get(i));
    }
  }
}