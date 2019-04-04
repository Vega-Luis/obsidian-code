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
}
