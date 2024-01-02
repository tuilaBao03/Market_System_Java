package Object;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cong.ConnectURL;

public class NhanVien extends ConNguoi {

	private String password,user;

	public NhanVien() {
        super();

    }
	
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public NhanVien(String ma, String ten, String soDienThoai, String diaChi, String gioiTinh, String password,
			String user) {
		super(ma, ten, soDienThoai, diaChi, gioiTinh);
		this.password = password;
		this.user = user;
	}
	 public NhanVien(String ma, String ten, String soDienThoai, String diaChi, String gioiTinh) {
			super(ma, ten, soDienThoai, diaChi, gioiTinh);
			// TODO Auto-generated constructor stub
		}
	 
	 public NhanVien( String ten, String soDienThoai, String diaChi, String gioiTinh, String password,
				String user) {
			super(ten, soDienThoai, diaChi, gioiTinh);
			this.password = password;
			this.user = user;
		}
	

	public String autoCreateCodeofHuman() {
		
		String a="NV";
		ConnectURL conn=new ConnectURL();
		conn.ConnectToTKCSDL();
		
		try {
		     ResultSet resultSet = conn.view("nhanvien");
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
	
	@Override
	public void setMa(String a) {
		
		super.setMa(autoCreateCodeofHuman());
	}

	public ResultSet getData() {
		 ConnectURL conn = new ConnectURL();
         conn.ConnectToTKCSDL();
         ResultSet rs;
         rs = conn.Query("select * from nhanvien");
  		return rs;
    }

    public void putData() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        NhanVien cs = new NhanVien();
       cs.setMa("");
        System.out.println("nhap vao ten nhan vien:");
        cs.setTen(sc.nextLine());
        System.out.println("nhap vao 9 so cuoi cua so dien thoai:");
        String sdt = "0";

        int k;
        do {

            try {
                k = sc1.nextInt();
                if (k > 100000000 && k < 999999999) {
                    sdt = sdt + String.valueOf(k);
                    break;
                } else {
                    System.out.println("sai dinh dang so dien thoai! Hay nhap lai 9 so cuoi!");
                }
            } catch (InputMismatchException e) {
                System.out.println("nhap sai, hay nhap lai!");
                sc1.next();
            }
        } while (true);
        cs.setSoDienThoai(sdt);
        System.out.println("nhap vao dia chi nhan vien:");
        cs.setDiaChi(sc.nextLine());
        while (true) {
            try {
                System.out.println("nhan vien la:");
                System.out.println("1. Nam\t\t2. Nu");
                int i = sc1.nextInt();
                if (i != 1 && i != 2) {
                    System.out.println("chi duoc chon 1 hoac 2!");
                    continue;
                } else if (i == 1) {
                    cs.setGioiTinh("M");
                } else {
                    cs.setGioiTinh("F");
                }
                break;

            } catch (Exception e) {
                System.out.println("chi duoc nhap vao so");

            }
            
        }
        System.out.println("tao ten dang nhap cho nhan vien nay");
      cs.setPassword( sc.nextLine());
        System.out.println("tao mat khau cho nhan vien nay");
        cs.setUser(sc.nextLine());
 
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();

        String insertStatement = "INSERT INTO nhanvien (manhanvien, tennhanvien, sodienthoainhanvien, diachinhanvien, gioitinh,matkhau,tendangnhap) VALUES ('"
                + cs.getMa() + "', '" + cs.getTen() + "', '" + cs.getSoDienThoai() + "', '"
                + cs.getDiaChi() + "', '" + cs.getGioiTinh() + "', '" +cs.getPassword()+"', '"+cs.getUser()+"')";

        conn.update(insertStatement);
        sc.close();
        sc1.close();
        conn.closeConnection();
    }

    public void deleteDataByMaNV(String manhanvien) {
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        try {

        	String deleteChildQuery1 = "DELETE FROM Hoadonnhap WHERE MaNhanVien = '" + manhanvien + "'";
            conn.update(deleteChildQuery1);
      
            String deleteChildQuery2 = "DELETE FROM Hoadonban WHERE MaNhanVien = '" + manhanvien + "'";
            conn.update(deleteChildQuery2);
  
            // Deleting the parent record from nhanvien
            String deleteParentQuery = "DELETE FROM nhanvien WHERE manhanvien = '" + manhanvien + "'";
            conn.update(deleteParentQuery);

            System.out.println("Da xoa xong.");
        } catch (Exception e) {
            System.out.println("Loi xoa du lieu: " + e.getMessage());
            e.printStackTrace();
        } finally {
        	conn.closeConnection();
        }

    }
    
    public void deleteDataByName(String Name) {
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        try {
        	String deleteChildQuery1 = "DELETE FROM Hoadonnhap WHERE manhanvien IN "+
        	            " ( select manhanvien from nhanvien where tennhanvien LIKE '%" + Name + "%')";
        	            conn.update(deleteChildQuery1);
        	  
            String deleteChildQuery2 = "DELETE FROM Hoadonban WHERE manhanvien IN "+
            " ( select manhanvien from nhanvien where tennhanvien LIKE '%" + Name + "%')";
            conn.update(deleteChildQuery2);
    

            // Deleting the parent record from nhanvien
            String deleteParentQuery = "DELETE FROM nhanvien WHERE Tennhanvien like '%" + Name + "%'";
            conn.update(deleteParentQuery);

            System.out.println("Da xoa xong.");
        } catch (Exception e) {
            System.out.println("Loi xoa du lieu: " + e.getMessage());
            e.printStackTrace();
        } finally{
        	conn.closeConnection();
        }

    }

    public List<NhanVien> searchDataByName(String name) {
        List<NhanVien> results = new ArrayList<>();
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM nhanvien WHERE tennhanvien LIKE '%" + name + "%'";
            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            
            while (resultSet.next()) {
                found = true;
                NhanVien a = new NhanVien(
                    resultSet.getString("manhanvien"),
                    resultSet.getString("tennhanvien"),
                    resultSet.getString("sodienthoainhanvien"),
                    resultSet.getString("diachinhanvien"),
                    resultSet.getString("gioitinh")
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
   

	public NhanVien searchDataByMaNV(String MaNV) {
    	NhanVien a=null;
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM nhanvien WHERE manhanvien= '" + MaNV +"'" ;

            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            while (resultSet.next()) {
                found = true;
                a= new NhanVien(resultSet.getString("manhanvien"),resultSet.getString("tennhanvien") , resultSet.getString("sodienthoainhanvien"), resultSet.getString("diachinhanvien"), resultSet.getString("gioitinh"), resultSet.getString("matkhau"),resultSet.getString("tendangnhap"));

            if (!found) {
                System.out.println("No matching records found.");
            }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	
        }
        return a;
    }
    public void CreateNewNV(NhanVien a) {
    	ConnectURL conn= new ConnectURL();
    	conn.ConnectToTKCSDL();
    	a.setMa("1");
    	String insertStatement = "INSERT INTO nhanvien (manhanvien, tennhanvien, sodienthoainhanvien, diachinhanvien,gioitinh,matkhau,tendangnhap) VALUES ('"
				+ a.getMa()+ "', '" + a.getTen() + "', '" + a.getSoDienThoai()+ "', '" + a.getDiaChi()+ "','"+a.getGioiTinh()+"','"+a.getPassword()+"','"+a.getUser()+"')";
		System.out.println(a.toString());
    	conn.update(insertStatement);
		conn.closeConnection();
    }
    public void getOneObject(NhanVien a) {
    	System.out.println(""+a.getMa()+"\t"+a.getTen()+"\t"+a.getSoDienThoai()+"\t"+a.getDiaChi()+"\t"+a.getGioiTinh());
    }
    
 
	

	@Override
	public String toString() {
		return "NhanVien [password=" + password + ", user=" + user + ", getPassword()=" + getPassword() + ", getUser()="
				+ getUser() + ", autoCreateCodeofHuman()=" + autoCreateCodeofHuman() + ", getData()=" + getData()
				+ ", getMa()=" + getMa() + ", getTen()=" + getTen() + ", getSoDienThoai()=" + getSoDienThoai()
				+ ", getDiaChi()=" + getDiaChi() + ", getGioiTinh()=" + getGioiTinh() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		NhanVien nv= new NhanVien("bao","1234567890","thaibinh","nam","pajd","12345");
		nv.CreateNewNV(nv);
		
	}

	


	 
}