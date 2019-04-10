package controller;



public class RefactorThisNameC {

  public static void main(String[] args) {
    Management manager = new Management();
    System.out.println(manager.getBraches().get(0).getVehicles().get(0).getStyle());
  }
}
