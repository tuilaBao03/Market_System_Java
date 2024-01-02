package Object;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cong.ConnectURL;

public class ChiTietHoaDonBan {


	private Hanghoalucban a;
	private int soluong;
	private HoaDonBan h;
	

	public ChiTietHoaDonBan(Hanghoalucban a, int soluong, HoaDonBan h) {
		super();
		this.a = a;
		this.soluong = soluong;
		
		this.h = h;
	}
	public void getData() {
		ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
 	try {
     ResultSet resultSet = conn.Query("select * from ct_hoadonban");
     // Get metadata to retrieve column names
     ResultSetMetaData metaData = resultSet.getMetaData();
     int columnCount = metaData.getColumnCount();

     System.out.println();

     // Print data rows
     while (resultSet.next()) {
         for (int i = 1; i <= columnCount; i++) {
             System.out.print(resultSet.getString(i));
             if (i < columnCount) {
                 System.out.print("\t ");
             }
         }
         System.out.println();
     }

     System.out.println("xuat du lieu thanh cong.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	conn.closeConnection();
	    }
	}
	
	public void createDetailsBill() {
		ConnectURL conn=new ConnectURL();
		conn.ConnectToTKCSDL();
		
		String insertStatement = "INSERT INTO CT_HoaDonBan (mahoadonban, mahanghoa, soluong) VALUES ('"
                + this.h.getMahoadon() + "', '" + this.a.getMasanpham() + "', '" + this.soluong + "')";
        conn.update(insertStatement);
        conn.closeConnection();
	}
	
	public static void main(String[] args) {
		HoaDonBan hdb=new HoaDonBan();
		hdb=hdb.searchDataByMaHDB("mhdb9");
		Hanghoalucban a= new Hanghoalucban();
		a=a.searchDataByMaHH("HH2");
		ChiTietHoaDonBan ct=new ChiTietHoaDonBan(a, 10, hdb);
		ct.createDetailsBill();
		ct.getData();
		
	}
	
	

	
}