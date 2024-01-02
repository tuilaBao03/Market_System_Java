package Object;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import cong.ConnectURL;

public class HoaDonBan {

	private String mahoadon,phuongthucthanhtoan;
	private NhanVien a;
	private Khachhang b;
	private int diemtichluydung;

	public HoaDonBan( NhanVien a, Khachhang b) {
		this.a = a;
		this.b = b;
	}

	public String getPhuongthucthanhtoan() {
		return phuongthucthanhtoan;
	}
	public HoaDonBan(String phuongthucthanhtoan, NhanVien a, Khachhang b, int diemtichluydung) {
		super();
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.a = a;
		this.b = b;
		this.diemtichluydung = diemtichluydung;
	}

	public HoaDonBan(String phuongthucthanhtoan, NhanVien a, Khachhang b) {
		super();
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.a = a;
		this.b = b;
	}

	public HoaDonBan(NhanVien a, Khachhang b, int diemtichluydung) {
		super();
		this.a = a;
		this.b = b;
		this.diemtichluydung = diemtichluydung;
	}
	

	public HoaDonBan(String mahoadon, String phuongthucthanhtoan, NhanVien a, Khachhang b, int diemtichluydung) {
		super();
		this.mahoadon = mahoadon;
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.a = a;
		this.b = b;
		this.diemtichluydung = diemtichluydung;
	}

	public void setPhuongthucthanhtoan(String phuongthucthanhtoan) {
		this.phuongthucthanhtoan = phuongthucthanhtoan;
	}
	public HoaDonBan() {
		super();
	}
	public String getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon() {
		this.mahoadon=autoCreateCodeofBills();
	}
	public int getDiemtichluydung() {
		return diemtichluydung;
	}
	public void setDiemtichluydung(int diemtichluydung) {
		this.diemtichluydung = diemtichluydung;
	}

	public String autoCreateCodeofBills() {

		String a="MHDB";
		ConnectURL conn=new ConnectURL();
		conn.ConnectToTKCSDL();


		try {
			ResultSet resultSet = conn.view("hoadonban");
			int i=1;
			while (resultSet.next()) {
				i++;

			}
			a=a+String.valueOf(i);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return a;
	}

	public void CreateBill(int diemtichluy) {
		ConnectURL conn= new ConnectURL();
		conn.ConnectToTKCSDL();
		setMahoadon();
		setDiemtichluydung(diemtichluy);
		String insertStatement = "INSERT INTO hoadonban (mahoadonban, maNhanVien, makhachhang, diemtichluydung) VALUES ('"
				+ this.mahoadon+ "', '" + a.getMa() + "', '" + b.getMa()+ "', '" + this.diemtichluydung + "')";
		conn.update(insertStatement);
		conn.closeConnection();
	}

	public void DeleteBill(String MaHoaDon) {

		ConnectURL conn = new ConnectURL();
		conn.ConnectToTKCSDL();
		try {

			String deleteChildQuery = "DELETE FROM CT_HoaDonBan WHERE MaHoaDonBan ='"+MaHoaDon+"'";
			conn.update(deleteChildQuery);



			// Deleting the parent record from khachhang
			String deleteParentQuery = "DELETE FROM hoadonban WHERE mahoadonban = '" + MaHoaDon + "'";
			conn.update(deleteParentQuery);

			System.out.println("Da xoa xong.");
		} catch (Exception e) {
			System.out.println("Loi xoa du lieu: " + e.getMessage());
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}

	}
	public void getData() {
		ConnectURL conn = new ConnectURL();
		conn.ConnectToTKCSDL();

		try {
			ResultSet resultSet = conn.Query("select * from hoadonban");
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
	public HoaDonBan searchDataByMaHDB(String MaHDB) {
		Khachhang k=new Khachhang();
		NhanVien n=new NhanVien();
		HoaDonBan h=null;

		ConnectURL conn = new ConnectURL();
		conn.ConnectToTKCSDL();

		try {
			String searchQuery = "SELECT * FROM Hoadonban WHERE mahoadonban= '" + MaHDB+"'" ;

			ResultSet resultSet = conn.Query(searchQuery);
			boolean found = false;
			while (resultSet.next()) {
				found = true;
				String temp =resultSet.getString("maNhanVien");
				n=n.searchDataByMaNV(temp);
				String temp1 =resultSet.getString("makhachhang");
				k=k.searchDataByMaKH(temp1);
				h=new HoaDonBan(resultSet.getString("mahoadonban"), resultSet.getString("phuongthucthanhtoan"), n, k, resultSet.getInt("diemtichluydung"));

				if (!found) {
					System.out.println("No matching records found.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return h;
	}


	public void getOneObject(HoaDonBan h) {
		System.out.println(""+h.mahoadon+"\t"+h.getPhuongthucthanhtoan()+""+h.a.getMa()+"\t"+h.b.getMa());
	}
	public static void main(String[] args) {
	
		HoaDonBan hdb=new HoaDonBan();
		hdb=hdb.searchDataByMaHDB("hd9");
		hdb.getOneObject(hdb);

	}







}
