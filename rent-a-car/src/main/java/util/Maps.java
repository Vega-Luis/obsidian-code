package util;
/*
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
*/
public class Maps {
  /*GeoApiContext context;
  Gson gson;
  String placeId; 
  String data = ""; 
  String KEY ="AIzaSyBwK1MLub_zScXWpK_UOK1AklxpGVyxW7Y";
  
  public void ConexionPlace(String placeName) throws ApiException, InterruptedException, IOException {
    this.context = new GeoApiContext.Builder().apiKey(KEY).build();//Obtiene en results los lugares qe coincidan con la busqueda
    GeocodingResult[] results =  GeocodingApi.geocode(context, placeName).await();
    placeId = results[0].placeId;//se guarda en la variable placeid el id del lugar
  }
  
  public String placeDetails(GeoApiContext context, String placeId) throws ApiException, InterruptedException, IOException {
    PlaceDetailsRequest request = new PlaceDetailsRequest(context);//Se guarda en request los detalles que no estan parseados
    request.placeId(placeId);
    gson = new GsonBuilder().setPrettyPrinting().create();//se guarada en gson el json de los datos del lugar 
    data = gson.toJson(request.await());//Se guarda el codigo json en data para luego parsear el codigo 
    return data;
  }
  
  public String getLatitude() {
    try {
      final String regex = "\"lat\": ([\\d].*)";
      String latitude = "";        
      final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
      final Matcher matcher = pattern.matcher(data);
              
      while (matcher.find()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
        latitude = matcher.group(i);         
        }
      }  
      return latitude; 
    }catch(Exception e) {
      return "";
    }
  }
  
  public String getLongitude() {
    try {
      final String regex = "\"lng\": ([\\d].*)";
      String latitude = "";        
      final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
      final Matcher matcher = pattern.matcher(data);
              
      while (matcher.find()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
        latitude = matcher.group(i);         
        }
      }  
      return latitude; 
    }catch(Exception e) {
      return "";
    }
  }*/
}
