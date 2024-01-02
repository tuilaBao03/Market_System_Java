package Object;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cong.ConnectURL;

public class Luong {
    private int maca;
    private double luongtheoca;
    
    public void getData() {
  	   ConnectURL conn = new ConnectURL();
         conn.ConnectToTKCSDL();
         
  	try {
      ResultSet resultSet = conn.Query("select * from luong");
      // Get metadata to retrieve column names
      ResultSetMetaData metaData = resultSet.getMetaData();
      int columnCount = metaData.getColumnCount();

      // Print column headers
      for (int i = 1; i <= columnCount; i++) {
          System.out.print(metaData.getColumnName(i));
          if (i < columnCount) {
              System.out.print(", ");
          }
      }
      System.out.println();

      // Print data rows
      while (resultSet.next()) {
          for (int i = 1; i <= columnCount; i++) {
              System.out.print(resultSet.getString(i));
              if (i < columnCount) {
                  System.out.print(", ");
              }
          }
          System.out.println();
      }

      System.out.println("xuat du lieu thanh cong.");

 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
  }
    
    @Override
    public String toString() {
        return "Luong [maca=" + maca + ", luongtheoca=" + luongtheoca + "]";
    }
    
    public static void main(String[] args) {
        Luong e=new Luong();
      
            e.getData();
            if (e.maca == 0)
                return;
            System.out.println(e.toString());
        }
    }

