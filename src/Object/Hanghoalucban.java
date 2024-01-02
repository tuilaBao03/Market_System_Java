package Object;

import java.sql.ResultSet;
import java.sql.SQLException;

import cong.ConnectURL;

public class Hanghoalucban {

	private String masanpham;
	private String tensanpham;
	private int soluong;
	private double giaban;
	private double thanhtien;
	public Hanghoalucban(String masanpham, String tensanpham, int soluong, double giaban) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.soluong = soluong;
		this.giaban = giaban;
		this.thanhtien = (double)soluong * giaban;;
	}
	
	public Hanghoalucban(String masanpham, String tensanpham, int giaban) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.giaban = giaban;
		
	}

	public Hanghoalucban() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getGiaban() {
		return giaban;
	}
	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}
	public double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	 public Hanghoalucban searchDataByMaHH(String MaHH) {
	    	Hanghoalucban a=null;
	        ConnectURL conn = new ConnectURL();
	        conn.ConnectToTKCSDL();
	        
	        try {
	            String searchQuery = "SELECT * FROM hanghoa WHERE mahanghoa= '" + MaHH+"'" ;

	            ResultSet resultSet = conn.Query(searchQuery);
	            boolean found = false;
	            while (resultSet.next()) {
	                found = true;
	                a= new Hanghoalucban(resultSet.getString("mahanghoa"), resultSet.getString("tenhanghoa"), resultSet.getInt("giaban"));

	            if (!found) {
	                System.out.println("No matching records found.");
	            }
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	conn.closeConnection();
	        }
	        return a;
	    }
}
