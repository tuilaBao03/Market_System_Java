package Object;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cong.ConnectURL;

public class Hanghoa {

	private String mahang , tenhanghoa,manhacungcap,matheloai;
	private double giagoc,giaban;
	private int soluong;
	
	
	public Hanghoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hanghoa(String mahang, String tenhanghoa, String manhacungcap, String matheloai,int soluong, double giagoc,
			double giaban) {
		super();
		this.mahang = mahang;
		this.manhacungcap = manhacungcap;
		this.tenhanghoa = tenhanghoa;
		this.matheloai = matheloai;
		this.giagoc = giagoc;
		this.giaban = giaban;
		this.soluong = soluong;
	}
	


	public Hanghoa(String tenhanghoa, String manhacungcap, String matheloai, double giagoc, double giaban,
			int soluong) {
		super();
		this.mahang=autoCreateCodeofSP();
		this.tenhanghoa = tenhanghoa;
		this.manhacungcap = manhacungcap;
		this.matheloai = matheloai;
		this.giagoc = giagoc;
		this.giaban = giaban;
		this.soluong = soluong;
	}

	public String getMahang() {
		return mahang;
	}
	public void setMahang() {
		this.mahang = autoCreateCodeofSP();
	}
	public String getManhacungcap() {
		return manhacungcap;
	}
	public void setManhacungcap(String manhacungcap) {
		this.manhacungcap = manhacungcap;
	}
	public String getTenhanghoa() {
		return tenhanghoa;
	}
	public void setTenhanghoa(String tenhanghoa) {
		this.tenhanghoa = tenhanghoa;
	}
	public String getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(String matheloai) {
		this.matheloai = matheloai;
	}
	public double getGiagoc() {
		return giagoc;
	}
	public void setGiagoc(double giagoc) {
		this.giagoc = giagoc;
	}
	public double getGiaban() {
		return giaban;
	}
	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String autoCreateCodeofSP() {
		
		String a="HH";
		ConnectURL conn=new ConnectURL();
		conn.ConnectToTKCSDL();
		
		try {
		     ResultSet resultSet = conn.view("hanghoa");
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
         rs = conn.Query("select * from hanghoa");
  		return rs;
  	     }
    

    public void putData() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 =new Scanner(System.in);
        Hanghoa cs = new Hanghoa();
        System.out.println("nhap vao ma hang:");
        cs.mahang= sc.nextLine();
        System.out.println("nhap vao ten hang hoa:");
        cs.tenhanghoa = sc.nextLine();
        System.out.println("nhap vao ma nha cung cap");
        cs.manhacungcap=sc.nextLine();
        System.out.println("nhap vao ma the loai");
        cs.matheloai=sc.nextLine();
        System.out.println("nhap vao so luong hang");
        int k;
        do {
        	
        	try {
				k=sc1.nextInt();
				if(k>0) {
					cs.soluong=k;
					break;
				}
				else {
					System.out.println("so luong khong duoc <0 hay nhap lai !");
				}
			} catch (InputMismatchException e) {
				System.out.println("chi duoc phep nhap so, hay nhap lai!");
				sc1.next();
			}
		} while (true);
        
        do {
        	double gg,gb;
			
			
			try {
				System.out.println("nhap vao gia goc");
				gg=sc1.nextDouble();
				System.out.println("nhap vao gia ban");
				gb=sc1.nextDouble();
				if(gb>gg) {
					cs.giaban=gb;
					cs.giagoc=gg;
					break;
				}
				else {
					System.out.println("gia ban nho hon gia goc");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("chi duoc phep nhap so, hay nhap lai!");
				continue;
			}
			
		} while (true);
        
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();

        String insertStatement = "INSERT INTO hanghoa (mahanghoa, TenHangHoa, manhacungcap, matheloai, soluong, giagoc,giaban) VALUES ('"
                + cs.mahang + "', '" + cs.tenhanghoa + "', '" + cs.manhacungcap + "', '"
                + cs.matheloai+ "', '" + cs.soluong + "', " + cs.giagoc + ","+cs.giaban+")";
        conn.update(insertStatement);
        conn.closeConnection();
        sc.close();
        sc1.close();
    }
    public void deleteData(String mahang) {
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        try {
            String deleteParentQuery = "DELETE FROM hanghoa WHERE mahanghoa = '" + mahang + "'";
            conn.update(deleteParentQuery);

            System.out.println("Da xoa xong.");
        } catch (Exception e) {
            System.out.println("Loi xoa du lieu: " + e.getMessage());
            e.printStackTrace();
        } finally {
        	conn.closeConnection();
        }
        
    }
    public Hanghoa searchDataByMaHH(String MaHH) {
    	Hanghoa a=null;
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM hanghoa WHERE mahanghoa= '" + MaHH+"'" ;

            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            while (resultSet.next()) {
                found = true;
                a= new Hanghoa(resultSet.getString("MaHangHoa"),resultSet.getString("TenHangHoa") , resultSet.getString("MaNhaCungCap"), resultSet.getString("MaTheLoai"), resultSet.getInt("SoLuong"), resultSet.getInt("GiaGoc"),resultSet.getInt("GiaBan"));

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
    public List<Hanghoa> searchDataByName(String name) {
        List<Hanghoa> results = new ArrayList<>();
        ConnectURL conn = new ConnectURL();
        conn.ConnectToTKCSDL();
        
        try {
            String searchQuery = "SELECT * FROM HangHoa WHERE tenhanghoa LIKE '%" + name + "%'";
            ResultSet resultSet = conn.Query(searchQuery);
            boolean found = false;
            
            while (resultSet.next()) {
                found = true;
                Hanghoa a = new Hanghoa(
                    resultSet.getString("mahanghoa"),
                    resultSet.getString("tenhanghoa"),
                    resultSet.getString("manhacungcap"),
                    resultSet.getString("matheloai"),
                    resultSet.getInt("soluong"),
                    resultSet.getDouble("giagoc"),
                    resultSet.getDouble("giaban")   
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
    public void CreateNewHH(Hanghoa a) {
		ConnectURL conn= new ConnectURL();
    	conn.ConnectToTKCSDL();
    	a.setMahang();
    	String insertStatement = "INSERT INTO hanghoa (mahanghoa,tenhanghoa,manhacungcap,matheloai,soluong,giaban,giagoc) VALUES ('"
				+ a.getMahang()+ "', '" + a.getTenhanghoa() + "', '" + a.getManhacungcap()+ "', '"+  a.getMatheloai()+"', '"+ a.getSoluong()+ "','"+a.getGiaban()+"', '"+a.getGiagoc()+"')";
		System.out.println(a.toString());
    	conn.update(insertStatement);
		conn.closeConnection();
		
	}
    
        @Override
	public String toString() {
		return "Hanghoa [mahang=" + mahang + ", tenhanghoa=" + tenhanghoa + ", manhacungcap=" + manhacungcap
				+ ", matheloai=" + matheloai + ", giagoc=" + giagoc + ", giaban=" + giaban + ", soluong=" + soluong
				+ "]";
	}

		public static void main(String[] args) {
			Hanghoa a=new Hanghoa("abc","ncc1","tl1", 1, 7890, 890);
			a.CreateNewHH(a);
		
		}

		


  


	
}