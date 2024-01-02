package Object;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cong.ConnectURL;

public class Khachhang extends ConNguoi{

    private int diemtichluy;
    
    public Khachhang() {
		super();
		
	}

	public Khachhang(String ma, String ten, String soDienThoai, String diaChi, String gioiTinh, int diemtichluy) {
		super(ma, ten, soDienThoai, diaChi, gioiTinh);
		this.diemtichluy = diemtichluy;
	}

	public Khachhang(String ma, String ten, String soDienThoai, String diaChi, String gioiTinh) {
		super(ma, ten, soDienThoai, diaChi, gioiTinh);
		// TODO Auto-generated constructor stub
	}
	public Khachhang(String ten, String soDienThoai, String diaChi, String gioiTinh, int diemtichluy) {
		super(ten, soDienThoai, diaChi, gioiTinh);
		this.diemtichluy = diemtichluy;
	}



	public int getDiemtichluy() {
        return diemtichluy;
    }


    public void setDiemtichluy(int diemtichluy) {
        this.diemtichluy = diemtichluy;
    }
    

	public String autoCreateCodeofHuman() {
		
		String a="KH";
		ConnectURL conn=new ConnectURL();
		conn.ConnectToTKCSDL();
		
		try {
		     ResultSet resultSet = conn.view("khachhang");
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
        rs = conn.Query("select * from khachhang");
 		return rs;
    }


    public void putData() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 =new Scanner(System.in);
        Khachhang cs = new Khachhang();
        cs.setMa("a");
        System.out.println("nhap vao ten khach hang:");
        cs.setTen(sc.nextLine());
        System.out.println("nhap vao 9 so cuoi cua so dien thoai:");
        String sdt="0";
      
        int k;
        do {
        	
        	try {
				k=sc1.nextInt();
				if(k>100000000&&k<999999999) {
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
        cs.setSoDienThoai(sdt);
        System.out.println("nhap vao dia chi khach hang:");
        cs.setDiaChi(sc.nextLine());
        while(true) {
        	try {
        		System.out.println("khach hang la:");
        		System.out.println("1. Nam\t\t2. Nu");
        		int i= sc1.nextInt();
        		if(i!=1&&i!=2) {
        			System.out.println("chi duoc chon 1 hoac 2!");
        			continue;
        		}
        		else
        			if(i==1) {
        				cs.setGioiTinh("M");
        			}
        			else
        				cs.setGioiTinh("F");
        		break;
        		
			} catch (Exception e) {
				System.out.println("chi duoc nhap vao so");
			}
        }
        System.out.println("nhap vao diem tich luy:");
        cs.diemtichluy = sc1.nextInt();

        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();

        String insertStatement = "INSERT INTO khachhang (makhachhang, tenkhachhang, sodienthoaikhachhang, diachikhachhang, gioitinh, diemtichluy) VALUES ('"
                + cs.getMa() + "', '" + cs.getTen() + "', '" + cs.getSoDienThoai()+ "', '"
                + cs.getDiaChi() + "', '" + cs.getGioiTinh() + "', " + cs.diemtichluy + ")";

        conn.update(insertStatement);
        sc.close();
        sc1.close();
        conn.closeConnection();
    }
    public void deleteData(String makhachhang) {
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        try {
        	
        	 String deleteChildQuery = "DELETE FROM CT_HoaDonBan WHERE MaHoaDonBan IN " +
                    "(SELECT MaHoaDonBan FROM Hoadonban WHERE MaKhachHang = '" + makhachhang + "')";
             conn.update(deleteChildQuery);
        	 
             String deleteChildQuery1 = "DELETE FROM Hoadonban WHERE MaKhachHang = '" + makhachhang + "'";
             conn.update(deleteChildQuery1);
            // Deleting child records first from CT_HoaDonBan
           

            // Deleting the parent record from khachhang
            String deleteParentQuery = "DELETE FROM khachhang WHERE makhachhang = '" + makhachhang + "'";
            conn.update(deleteParentQuery);

            System.out.println("Da xoa xong.");
        } catch (Exception e) {
            System.out.println("Loi xoa du lieu: " + e.getMessage());
            e.printStackTrace();
        } finally {
        	conn.closeConnection();
        }
        
    }
    
    public List<Khachhang> searchDataByName(String name) {
        List<Khachhang> results = new ArrayList<>();
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM khachhang WHERE tenkhachhang LIKE '%" + name + "%'";
            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            
            while (resultSet.next()) {
                found = true;
                Khachhang a = new Khachhang(
                    resultSet.getString("makhachhang"),
                    resultSet.getString("tenkhachhang"),
                    resultSet.getString("sodienthoaikhachhang"),
                    resultSet.getString("diachikhachhang"),
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
    public Khachhang searchDataByMaKH(String MaKH) {
    	Khachhang a=null;
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM khachhang WHERE makhachhang= '" + MaKH+"'" ;

            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            while (resultSet.next()) {
                found = true;
                a= new Khachhang(resultSet.getString("makhachhang"),resultSet.getString("tenkhachhang") , resultSet.getString("sodienthoaikhachhang"), resultSet.getString("diachikhachhang"), resultSet.getString("gioitinh"), resultSet.getInt("diemtichluy"));

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
    public void CreateNewKH(Khachhang a) {
    	ConnectURL conn= new ConnectURL();
    	conn.ConnectToTKCSDL();
    	a.setMa("1");
    	String insertStatement = "INSERT INTO khachhang (makhachhang, tenkhachhang, sodienthoaikhachhang, diachikhachhang,gioitinh,diemtichluy) VALUES ('"
				+ a.getMa()+ "', '" + a.getTen() + "', '" + a.getSoDienThoai()+ "', '" + a.getDiaChi()+ "','"+a.getGioiTinh()+"','"+a.getDiemtichluy()+"')";
		System.out.println(a.toString());
    	conn.update(insertStatement);
		conn.closeConnection();
    }
    
    @Override
	public String toString() {
		return "Khachhang [diemtichluy=" + diemtichluy + ", getDiemtichluy()=" + getDiemtichluy()
				+ ", autoCreateCodeofHuman()=" + autoCreateCodeofHuman() + ", getData()=" + getData() + ", getMa()="
				+ getMa() + ", getTen()=" + getTen() + ", getSoDienThoai()=" + getSoDienThoai() + ", getDiaChi()="
				+ getDiaChi() + ", getGioiTinh()=" + getGioiTinh() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void getOneObject(Khachhang a) {
    	System.out.println(""+a.getMa()+"\t"+a.getTen()+"\t"+a.getSoDienThoai()+"\t"+a.getDiaChi()+"\t"+a.getGioiTinh()+"\t"+a.getDiemtichluy());
    }
    public static void main(String[] args) {
    	Khachhang n=new Khachhang("bao","0888379199","thaibinh","nam",0);
		n.CreateNewKH(n);
		
		
	}


    



}
