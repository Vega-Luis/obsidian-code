package controller;

import bussineslogic.Client;
import bussineslogic.Employee;
import bussineslogic.Vehicle;
import java.util.ArrayList;
import persistence.Persistence;

/**
 * Esta clase esta encargada de controlar la interaccon entre la logica de negocios
 * y la interfaz grafica.
 * @author Luis
 * @version v1.0
 */
public class Management {
  private ArrayList<Vehicle> vehicles;
  private ArrayList<Client> clients;
  private ArrayList<Employee> employees;
  private Persistence persistence;
  private final int NOT_ADDED = 0;
  
  public Management() {
    this.persistence = new Persistence();
  }
  
  private void setVehicles() {
    try {
      this.vehicles = this.persistence.loadVehicles();
    } catch (Exception e) {
      this.vehicles = new ArrayList<Vehicle>();
      e.printStackTrace();
    }
  }
  
  private void setClients() {
    try {
      this.clients = this.persistence.loadClients();
    } catch (Exception e) {
      this.clients = new ArrayList<Client>();
      e.printStackTrace();
    }
  }

  private void setEmployees() {
    try {
      this.employees = this.persistence.loadEmployees();
    } catch (Exception e) {
      this.employees = new ArrayList<Employee>();
      e.printStackTrace();
    }
  }

  /**
   * Busca un cliente y retorna la posicion donde se encuentra.
   * Sin no existe retona un -1.
   * @param id Identificador del cliente.
   * @return Posicion  que se encuentra el cliente dentro del clients
   */
  private int searchClient(String id) {
    for (int client = 0; client < vehicles.size(); client++) {
      if (clients.get(client).getId().equals(id)) {
        return client;
      }
    }
    return NOT_ADDED;
  }
}
