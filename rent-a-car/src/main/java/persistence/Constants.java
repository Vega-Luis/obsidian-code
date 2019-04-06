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
  final byte COLOR = 2;
  final byte CAPACITY = 3;
  final byte BRAND = 4;
  final byte DOORS = 5;
  final byte VINNUMBER = 6;
  final byte MPG = 7;
  final byte PRICE = 8;
  final byte SUITCAPACITY = 9;
  final byte TRANSMISION = 10;
  final byte IMAGE = 11;
  final byte VEHICLEBRANCHNAME = 12;
  final byte VEHICLEBRANCHPROVINCE = 13;
  final byte VEHICLEBRANCHCANTON = 14;
  final byte VEHICLEBRANCHDISTRICT = 15;
  final byte VEHICLEBRANCHSINGS = 16;
  
  //Branch constants
  final byte BRANCHNAME = 0;
  final byte BRANCHPROVINCE = 1;
  final byte BRANCHCANTON = 2;
  final byte BRANCHDISTRICT = 3;
  final byte BRANCHSINGS = 4;
  
  //Company constants
  final byte BUSINESSNAME = 0;
  final byte LEGALNUMBER = 1;
  final byte TELEPHONE = 2;
}
