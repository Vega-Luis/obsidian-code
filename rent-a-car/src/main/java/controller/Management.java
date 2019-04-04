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

}
