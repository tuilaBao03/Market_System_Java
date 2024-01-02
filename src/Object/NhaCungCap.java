package Object;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cong.ConnectURL;

public class NhaCungCap {

    private String manhacungcap;
    private String tennhacungcap;
    private String sodienthoainhacungcap;
    private String nguoidaidien;
    private String diachinhacungcap;

	public NhaCungCap(String manhacungcap, String tennhacungcap, String sodienthoainhacungcap, String nguoidaidien,
			String diachinhacungcap) {
		super();
		this.manhacungcap=manhacungcap;
		this.tennhacungcap = tennhacungcap;
		this.sodienthoainhacungcap = sodienthoainhacungcap;
		this.nguoidaidien = nguoidaidien;
		this.diachinhacungcap = diachinhacungcap;
	}
	
	public NhaCungCap(String tennhacungcap, String sodienthoainhacungcap, String nguoidaidien,
			String diachinhacungcap) {
		super();
		this.tennhacungcap = tennhacungcap;
		this.sodienthoainhacungcap = sodienthoainhacungcap;
		this.nguoidaidien = nguoidaidien;
		this.diachinhacungcap = diachinhacungcap;
	}

	public NhaCungCap() {
 
    }
    public String getManhacungcap() {
        return this.manhacungcap;
    }

    public void setManhacungcap() {
        this.manhacungcap = autoCreateCodeofHuman();
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public String getSodienthoainhacungcap() {
        return sodienthoainhacungcap;
    }

    public void setSodienthoainhacungcap(String sodienthoainhacungcap) {
        this.sodienthoainhacungcap = sodienthoainhacungcap;
    }

    public String getNguoidaidien() {
        return nguoidaidien;
    }

    public void setNguoidaidien(String nguoidaidien) {
        this.nguoidaidien = nguoidaidien;
    }

    public String getDiachinhacungcap() {
        return this.diachinhacungcap;
    }

    public void setDiachinhacungcap(String diachinhacungcap) {
        this.diachinhacungcap = diachinhacungcap;
    }
    
    ///
	public String autoCreateCodeofHuman() {
		
		String a="NCC";
		ConnectURL conn=new ConnectURL();
		conn.ConnectToTKCSDL();
		
		try {
		     ResultSet resultSet = conn.view("nhacungcap");
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
	

	
    
    public ResultSet getData() {
    	   ConnectURL conn = new ConnectURL();
           conn.ConnectToTKCSDL();
           ResultSet rs;
       rs = conn.Query("select * from nhacungcap");
      
		return rs;
    }
    
    public void putData() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 =new Scanner(System.in);
        NhaCungCap cs= new NhaCungCap();
        cs.setManhacungcap();
        System.out.println("nhap vao ten cung cap:");
        cs.setTennhacungcap(sc.nextLine());
        System.out.println("nhap vao 9 so cuoi cua so dien thoai:");
        String sdt="0";
      
        int k;
        do {
        	
        	try {
				k=sc1.nextInt();
				if(k>100000000&&k<=999999999) {
					sdt=sdt+String.valueOf(k);
					break;
				}
				else {
					System.out.println("sai dinh dang so dien thoai! Hay nhap lai 9 so cuoi!");
				}
			} catch (InputMismatchException e) {
				System.out.println("nhap sai, hay nhap lai!");
				sc1.next();
			}
		} while (true);
        cs.setSodienthoainhacungcap(sdt);
        System.out.println("nhap vao ten nguoi dai dien cua nha cung cap:");
        cs.setNguoidaidien(sc.nextLine());
        System.out.println("nhap vao dia chi nha cung cap:");
        cs.setDiachinhacungcap(sc.nextLine());
        
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();

        String insertStatement = "INSERT INTO nhacungcap (manhacungcap, tennhacungcap, sodienthoainhacungcap,nguoidaidien, diachinhacungcap) VALUES ('"
                + cs.getManhacungcap() + "', '" + cs.getTennhacungcap() + "', '" + cs.getSodienthoainhacungcap()+ "', '"+cs.getNguoidaidien()+"', '"
                + cs.getDiachinhacungcap() + " ')";
        conn.update(insertStatement);
        sc.close();
        sc1.close();
        conn.closeConnection();
    }
    public void deleteData(String manhacungcap) {
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        try {
        	
        	 String deleteChildQuery = "DELETE FROM CT_HoaDonNhap WHERE MaHoaDonNhap IN " +
                    "(SELECT MaHoaDonNhap FROM HoadonNhap WHERE MaNhacungcap = '" + manhacungcap+ "')";
             conn.update(deleteChildQuery);
        	 
             String deleteChildQuery1 = "DELETE FROM Hoadonnhap WHERE Manhacungcap = '" + manhacungcap + "'";
             conn.update(deleteChildQuery1);
             String deleteChildQuery3 = "DELETE FROM CT_HoaDonBan WHERE MaHanghoa IN " +
                     "(select mahanghoa FROM Hanghoa WHERE Manhacungcap = '" + manhacungcap + "')";
              conn.update(deleteChildQuery3);
             String deleteChildQuery2 = "DELETE FROM Hanghoa WHERE Manhacungcap = '" + manhacungcap + "'";
             conn.update(deleteChildQuery2);

        	
        	 
            // Deleting child records first from CT_HoaDonBan
           

            // Deleting the parent record from khachhang
            String deleteParentQuery = "DELETE FROM nhacungcap WHERE manhacungcap = '" + manhacungcap + "'";
            conn.update(deleteParentQuery);

            System.out.println("Da xoa xong.");
        } catch (Exception e) {
            System.out.println("Loi xoa du lieu: " + e.getMessage());
            e.printStackTrace();
        } finally {
        	conn.closeConnection();
        }
        
    }
    
    public List<NhaCungCap> searchDataByName(String name) {
        List<NhaCungCap> results = new ArrayList<>();
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM nhacungcap WHERE tennhacungcap LIKE '%" + name + "%'";
            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            
            while (resultSet.next()) {
                found = true;
                NhaCungCap a = new NhaCungCap(
                    resultSet.getString("manhacungcap"),
                    resultSet.getString("tennhacungcap"),
                    resultSet.getString("sodienthoainhacungcap"),
                    resultSet.getString("nguoidaidien"),
                    resultSet.getString("diachinhacungcap")
                );
                
                results.add(a);
            }
            
            if (!found) {
                System.out.println("No matching records found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Make sure to close the connection and release resources
            conn.closeConnection();
        }
        
        return results;
    }

    public NhaCungCap searchDataByMaNCC(String MaNCC) {
        NhaCungCap a = null;
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();

        try {
            String searchQuery = "SELECT * FROM nhacungcap WHERE manhacungcap = '" + MaNCC + "'";

            ResultSet resultSet = conn.Query(searchQuery);
            if (resultSet.next()) {
                a = new NhaCungCap(
                        resultSet.getString("manhacungcap"),
                        resultSet.getString("tennhacungcap"),
                        resultSet.getString("sodienthoainhacungcap"),
                        resultSet.getString("nguoidaidien"),
                        resultSet.getString("diachinhacungcap")
                );
            } else {
                System.out.println("No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


    
    @Override
	public String toString() {
		return "NhaCungCap [manhacungcap=" + manhacungcap + ", tennhacungcap=" + tennhacungcap
				+ ", sodienthoainhacungcap=" + sodienthoainhacungcap + ", nguoidaidien=" + nguoidaidien
				+ ", diachinhacungcap=" + diachinhacungcap + "]";
	}

	public void CreateNewNCC(NhaCungCap a) {
    	ConnectURL conn= new ConnectURL();
    	conn.ConnectToTKCSDL();
    	a.setManhacungcap();
    	String insertStatement = "INSERT INTO nhacungcap (manhacungcap, tennhacungcap, sodienthoainhacungcap, nguoidaidien,diachinhacungcap) VALUES ('"
				+ a.manhacungcap+ "', '" + a.getTennhacungcap() + "', '" + a.getSodienthoainhacungcap()+ "', '" + a.nguoidaidien+ "','"+a.diachinhacungcap+"')";
		conn.update(insertStatement);
		conn.closeConnection();
    }
	public static void main(String[] args) {
		NhaCungCap nc= new NhaCungCap();
		nc=nc.searchDataByMaNCC("NCC1");
		
		System.out.println(nc.toString());
	}
    

   

}


	