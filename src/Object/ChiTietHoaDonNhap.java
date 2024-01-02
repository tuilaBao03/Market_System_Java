package Object;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cong.ConnectURL;

public class ChiTietHoaDonNhap {


	private Hanghoalucnhap a;
	private int soluong;
	private HoaDonNhap h;
	

	
	public ChiTietHoaDonNhap(Hanghoalucnhap a, int soluong, HoaDonNhap h) {
		super();
		this.a = a;
		this.soluong = soluong;
		this.h = h;
	}

	 

	public void getData() {
		ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
 	try {
     ResultSet resultSet = conn.Query("select * from ct_hoadonnhap");
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
	
		String insertStatement = "INSERT INTO CT_HoaDonNhap (mahoadonnhap, mahanghoa, soluong) VALUES ('"
                + this.h.getMahoadonnhap() + "', '" + this.a.getMasanpham() + "', '" + this.soluong + "')";
        conn.update(insertStatement);
        conn.closeConnection();
	}
	
	
	


	@Override
	public String toString() {
		return "ChiTietHoaDonNhap [a=" + a + ", soluong=" + soluong + ", h=" + h + "]";
	}

	public static void main(String[] args) {
		HoaDonNhap hdn=new HoaDonNhap();
		hdn=hdn.searchDataByMaHDN("mhdn1");
		Hanghoalucnhap a= new Hanghoalucnhap();
		a=a.searchDataByMaHH("HH4");
		System.out.println(a.toString());
		ChiTietHoaDonNhap ct=new ChiTietHoaDonNhap(a, 10, hdn);
		ct.createDetailsBill();
	
	}
	
	

	
}