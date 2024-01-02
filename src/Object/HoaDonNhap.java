package Object;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cong.ConnectURL;

public class HoaDonNhap {

	private String mahoadonnhap;
	private NhanVien a;
	private NhaCungCap b;

	public HoaDonNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	public HoaDonNhap(String mahoadonnhap, NhanVien a, NhaCungCap b) {
		super();
		this.mahoadonnhap = mahoadonnhap;
		this.a = a;
		this.b = b;
	}




	public HoaDonNhap(NhanVien a, NhaCungCap b) {
		super();
		this.a = a;
		this.b = b;
	}


	public String getMahoadonnhap() {
		return mahoadonnhap;
	}

	public void setMahoadonnhap(String mahoadonnhap) {
		this.mahoadonnhap = mahoadonnhap;
	}

	
	public String autoCreateCodeofBills() {
			
			String a="MHDN";
			ConnectURL conn=new ConnectURL();
			conn.ConnectToTKCSDL();
			
			
			try {
			     ResultSet resultSet = conn.view("hoadonnhap");
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
	public void setMahoadon() {
		this.mahoadonnhap=autoCreateCodeofBills();
	}
	public void CreateBill() {
		ConnectURL conn= new ConnectURL();
		conn.ConnectToTKCSDL();
		setMahoadon();
		
		
		 String insertStatement = "INSERT INTO hoadonnhap (manhacungcap, tennhacungcap,mahoadonnhap , manhanvien) VALUES ('"
	                + b.getManhacungcap()+ "', '" + b.getTennhacungcap() + "', '" + this.mahoadonnhap+ " ','"+a.getMa()+"')";

	        conn.update(insertStatement);
	        conn.closeConnection();
	}
	
	public void DeleteBill(String MaHoaDon) {
	   
	        ConnectURL conn = new ConnectURL();
	        conn.ConnectToTKCSDL();
	        try {
	        	
	        	 String deleteChildQuery = "DELETE FROM CT_HoaDonNhap WHERE MaHoaDonnhap ='"+MaHoaDon+"'";
	             conn.update(deleteChildQuery);
	     
	            String deleteParentQuery = "DELETE FROM hoadonnhap WHERE mahoadonnhap= '" + MaHoaDon + "'";
	            conn.update(deleteParentQuery);

	            System.out.println("Da xoa xong.");
	        } catch (Exception e) {
	            System.out.println("Loi xoa du lieu: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	        	conn.closeConnection();
	        }
	        
	    }
	public HoaDonNhap searchDataByMaHDN(String MaHDN) {
		NhaCungCap k=new NhaCungCap();
		NhanVien n=new NhanVien();
		HoaDonNhap h=null;

		ConnectURL conn = new ConnectURL();
		conn.ConnectToTKCSDL();

		try {
			String searchQuery = "SELECT * FROM Hoadonnhap WHERE mahoadonnhap= '" + MaHDN+"'" ;

			ResultSet resultSet = conn.Query(searchQuery);
			boolean found = false;
			while (resultSet.next()) {
				found = true;
				String temp =resultSet.getString("manhanvien");
				n=n.searchDataByMaNV(temp);
				String temp1 =resultSet.getString("manhacungcap");
				k=k.searchDataByMaNCC(temp1);
				h=new HoaDonNhap(resultSet.getString("mahoadonnhap"), n, k);

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

	public void getData() {
		ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
 	try {
     ResultSet resultSet = conn.Query("select * from hoadonnhap");
     // Get metadata to retrieve column names
     ResultSetMetaData metaData = resultSet.getMetaData();
     int columnCount = metaData.getColumnCount();
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
	public void getOneObject(HoaDonNhap h) {
		System.out.println(""+h.mahoadonnhap+"\t"+""+h.a.getMa()+"\t"+h.b.getManhacungcap());
	}
	public static void main(String[] args) {
	
		HoaDonNhap hdn=new HoaDonNhap();
		hdn=hdn.searchDataByMaHDN("7");
		hdn.getOneObject(hdn);

	}

}
