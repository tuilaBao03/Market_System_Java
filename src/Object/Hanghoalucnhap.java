package Object;

import java.sql.ResultSet;
import java.sql.SQLException;

import cong.ConnectURL;

public class Hanghoalucnhap {

	private String masanpham;
	private String tensanpham;
	private int soluong;
	private double gianhap;
	private double thanhtien;

	public Hanghoalucnhap(String masanpham, String tensanpham, int soluong, double gianhap) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.soluong = soluong;
		this.gianhap = gianhap;
		this.thanhtien = (double) soluong * gianhap;
	}

	public Hanghoalucnhap(String masanpham, String tensanpham, Double gianhap) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.gianhap = gianhap;
	}

	public Hanghoalucnhap() {
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

	public double getGianhap() {
		return gianhap;
	}

	public void setGianhap(double gianhap) {
		this.gianhap = gianhap;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}

	public Hanghoalucnhap searchDataByMaHH(String MaHH) {
		Hanghoalucnhap a = null;
		ConnectURL conn = new ConnectURL();
		conn.ConnectToTKCSDL();

		try {
			String searchQuery = "SELECT * FROM hanghoa WHERE mahanghoa= '" + MaHH + "'";

			ResultSet resultSet = conn.Query(searchQuery);
			boolean found = false;
			while (resultSet.next()) {
				found = true;
				a = new Hanghoalucnhap(resultSet.getString("mahanghoa"), resultSet.getString("tenhanghoa"),
						resultSet.getDouble("giagoc"));

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
	
	
	@Override
	public String toString() {
		return "Hanghoalucnhap [masanpham=" + masanpham + ", tensanpham=" + tensanpham +"," + gianhap + "]";
	}

	public static void main(String[] args) {
		Hanghoalucnhap a= new Hanghoalucnhap();
		a=a.searchDataByMaHH("HH2");
		System.out.println(a.toString());
	}

	
}
