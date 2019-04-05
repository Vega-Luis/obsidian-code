package persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Constants {
  //Client constants
  final byte CLIENTNAME = 0;
  final byte CLIENTID = 1;
  final byte CLIENTTELEPHONE = 2;
  final byte CLIENTMAIL = 3;
  //Address constants
  final byte PROVINCE = 4;
  final byte CANTON = 5;
  final byte DISTRICT = 6;
  final byte SINGS = 7;
  
  //Employee constants
  final byte EMPLOYEEID = 0;
  final byte EMPLOYEENAME = 1;
  final byte EMPLOYEETELEPHONE = 2;
  final byte EMPLOYEEMAIL = 3;
  final byte PASSWORD = 4;
  final byte USERNAME = 5;
  
  //Vehicle constants
  final byte VEHICLEPLATE = 0;
  final byte FABRICATIONDATE = 1;
  final byte RED = 2;
  final byte GREEN = 3;
  final byte BLUE = 4;
  final byte CAPACITY = 5;
  final byte BRAND = 6;
  final byte DOORS = 7;
  final byte VINNUMBER = 8;
  final byte MPG = 9;
  final byte PRICE = 10;
  final byte SUITCAPACITY = 11;
  final byte TRANSMISION = 12;
  
}
