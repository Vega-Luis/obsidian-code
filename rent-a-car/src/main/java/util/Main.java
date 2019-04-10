package util;

import java.io.IOException;
import com.google.maps.errors.ApiException;

public class Main {

  public static void main(String[] args) {
    Maps maps = new Maps();
    try {
      maps.ConexionPlace("Basilica Cartago");
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
