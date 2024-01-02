package cong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectURL {
	Connection a;
	
	public void ConnectToTKCSDL() {
		 String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=javapro2;user=sa;password=123456789;trustServerCertificate=true;";
		 this.a= null;
	        try {
	        	a = DriverManager.getConnection(connectionUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	}
	
	
	public ResultSet view(String table){
	    ResultSet resultSet = null;
	    ConnectToTKCSDL();
	    try {
	  
	        Statement statement = (Statement) a.createStatement(); 
	        String sql = "SELECT * FROM "+ table;
	
	        resultSet = statement.executeQuery(sql);
	    } catch (SQLException e) {
	        return null;
	    }
	    return resultSet;
	}
	
	public ResultSet Query(String Statement){
	    ResultSet resultSet = null;
	    ConnectToTKCSDL();
	    try {
	  
	        Statement statement = (Statement) a.createStatement(); 
	        String sql = Statement;
	
	        resultSet = statement.executeQuery(sql);
	    } catch (SQLException e) {
	        return null;
	    }
	    return resultSet;
	}
	public void update(String statement) {
	    ConnectToTKCSDL();
	    try {
	        Statement stmt = a.createStatement();
	        stmt.executeUpdate(statement);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean login(String username, String password) {
		
        try {
            // Kết nối đến cơ sở dữ liệu
            ConnectToTKCSDL();
            
            // Tạo câu truy vấn SQL
            String query = "SELECT * FROM NhanVien WHERE TenDangNhap = '" + username + "' AND MatKhau = '" + password + "'";
            
            // Tạo đối tượng Statement
            Statement statement = a.createStatement();
            
            // Thực thi câu truy vấn
            ResultSet resultSet = statement.executeQuery(query);
            
            // Kiểm tra kết quả trả về
            if (resultSet.next()) {
                // Đăng nhập thành công
                System.out.println("Đăng nhập thành công");
                resultSet.getString("tendangnhap");
                resultSet.getString("matkhau");
                
                return true;
            } else {
                // Đăng nhập thất bại
                System.out.println("Đăng nhập thất bại");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
	public void closeConnection() {
        try {
            if (a != null && !a.isClosed()) {
                a.close();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while closing the connection: " + e.getMessage());
        }
    }


	   public PreparedStatement prepareStatement(String sql) throws SQLException {
	        if (a == null || a.isClosed()) {
	            throw new SQLException("Connection is not established.");
	        }
	        return a.prepareStatement(sql);
	    }

	
	
	
	

        
       
        
        		
}