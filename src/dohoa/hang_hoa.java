/*package dohoa;
import Object.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class hang_hoa extends JFrame {
	private JTextField textField;
	private JTable bangHH;
	private JTextField textField_3;
	private JTextField SL;
	private JTextField THH;
	private JTextField GB;
	private JTextField GG;
	private JTextField MNCC;
	private JTextField MTL;
	public hang_hoa() {
		// khởi tạo mảng nhà cung cấp
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1421, 50);
		getContentPane().add(panel_1);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(new String[]{});
        		dispose();
			}
		});
		btnngXut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnngXut.setBounds(1062, 10, 141, 29);
		panel_1.add(btnngXut);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(242, 13, 470, 29);
		panel_1.add(textField);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(722, 13, 85, 29);
		panel_1.add(btnNewButton);
		ArrayList<Hanghoa> HH = new ArrayList<Hanghoa>();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	bangHH.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangHH.getModel(); 
		        String column[] = { "Mã hàng hóa", "Tên hàng hóa", "Mã nhà cung cấp", "Mã thể loại", "Số lượng", "Giá Bán" , "Giá Gốc"};
		        model.setColumnIdentifiers(column);
		        String mahanghoa,tenhanghoa,manhacungcap,matheloai;
				String giaban;
				String giagoc;
				String soluong;
		        Hanghoa nc=new Hanghoa();
		        Hanghoa nc1=new Hanghoa();
		        
		       ResultSet rs= nc.getData();
		       try {	
		    	  boolean check =true;
		       if(textField.getText().length()==0) {
		    	   check=false;
		    		   SPkhongtontai.main(new String [] {});
		    		   return;
		       }else {
		    	   
		    	   nc = nc.searchDataByMaHH(textField.getText());
   
		    	   if (nc == null) {
		    		   HH.addAll(nc1.searchDataByName(textField.getText()));
		    	      
		    	   }


		       	}
		       
			     while(rs.next()&&check==true) {
			    	 if ((rs.getString("mahanghoa").equals(nc.getMahang()))) {
			    		
				    	mahanghoa = rs.getString("mahanghoa");
				    	tenhanghoa=rs.getString("tenhanghoa");
				    	manhacungcap=rs.getString("manhacungcap");
				    	matheloai=rs.getString("matheloai");
				        soluong=String.valueOf(rs.getInt("soluong"));
				        giaban=String.valueOf(rs.getDouble("giaban"));
				        giagoc = String.valueOf(rs.getDouble("giagoc"));
				        
				    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
				    	model.addRow(row);
				    	
			    	 }
			    	 
			    	 
				    }
		       }
		       catch (Exception e1) {
				e1.getMessage();
			}
		       // hiển thị bảng ra ngoài màn hình
			for(int i=0;i<HH.size();i++) {
				mahanghoa=HH.get(i).getMahang();
			    tenhanghoa=HH.get(i).getTenhanghoa();
			    manhacungcap=HH.get(i).getManhacungcap();
			    matheloai=HH.get(i).getMatheloai();
			    soluong= String.valueOf(HH.get(i).getSoluong());
			    giaban=String.valueOf(HH.get(i).getGiaban());					
			    giagoc =String.valueOf(HH.get(i).getGiagoc());
			    
				String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc};
				model.addRow(row);
			
}
		        HH.removeAll(HH);
			}
		});
		
		
		JLabel lblNhnVin = new JLabel("HÀNG HÓA ");
		lblNhnVin.setForeground(new Color(255, 0, 0));
		lblNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNhnVin.setBounds(10, 10, 184, 29);
		panel_1.add(lblNhnVin);
		
		JButton btnDisplay = new JButton("Làm mới");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDisplay.setBounds(906, 10, 119, 29);
		panel_1.add(btnDisplay);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[] {});
				dispose();
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThot.setBounds(1211, 10, 141, 29);
		panel_1.add(btnThot);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 bangHH.setModel(new DefaultTableModel());
					Hanghoa ncc= new Hanghoa();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
					    while(rs.next()) {
					    	mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                            giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 49, 193, 678);
		getContentPane().add(panel);
		
		JButton productButton = new JButton("Bán Hàng");
		productButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton.setBounds(10, 389, 173, 80);
		panel.add(productButton);
		
		JButton supplierButton = new JButton("Nhà cung cấp");
		supplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha_cung_cap.main(new String[]{});
				dispose();
			}
		});
		supplierButton.setForeground(new Color(0, 0, 0));
		supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		supplierButton.setBounds(10, 209, 173, 80);
		panel.add(supplierButton);
		
		JButton customerButton = new JButton("Khách hàng");
		customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khach_hang.main(new String[]{});
				dispose();
				
			}
		});
		customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		customerButton.setBounds(10, 119, 173, 80);
		panel.add(customerButton);
		
		JButton employeeButton = new JButton("Nhân viên");
		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhan_vien.main(new String[] {});
				dispose();
			}
		});
		employeeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		employeeButton.setBounds(10, 33, 173, 80);
		panel.add(employeeButton);
		
		JButton productButton_1 = new JButton("Hàng hoá");
		productButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		productButton_1.setForeground(new Color(255, 0, 0));
		productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton_1.setBounds(10, 299, 173, 80);
		panel.add(productButton_1);
		
		JButton statisticButton = new JButton("Thống kê");
		statisticButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thong_ke.main(new String[] {});
				dispose();
			}
		});
		statisticButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		statisticButton.setBounds(10, 567, 173, 80);
		panel.add(statisticButton);
		
		JButton btnNhpHng = new JButton("Nhập Hàng");
		btnNhpHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphang.main(new String[] {});
				dispose();
			}
		});
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNhpHng.setBounds(10, 477, 173, 80);
		panel.add(btnNhpHng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(257, 141, 1044, 527);
		getContentPane().add(scrollPane);
		
		bangHH = new JTable();
		scrollPane.setViewportView(bangHH);
		
		JMenu menu = new JMenu("New menu");
		scrollPane.setColumnHeaderView(menu);
		
		textField_3 = new JTextField();
		scrollPane.setColumnHeaderView(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTnNhCung = new JLabel("Số lượng        :");
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnNhCung.setBounds(257, 107, 122, 24);
		getContentPane().add(lblTnNhCung);
		
		JLabel lblSinThoi_1 = new JLabel("Giá Gốc   : ");
		lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1.setBounds(587, 107, 88, 24);
		getContentPane().add(lblSinThoi_1);
		
		JLabel lblSinThoi_2 = new JLabel("Tên hàng hóa :");
		lblSinThoi_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_2.setBounds(256, 73, 130, 24);
		getContentPane().add(lblSinThoi_2);
		
		SL = new JTextField();
		SL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SL.setColumns(10);
		SL.setBounds(387, 111, 167, 19);
		getContentPane().add(SL);
		
		THH = new JTextField();
		THH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		THH.setColumns(10);
		THH.setBounds(387, 76, 167, 19);
		getContentPane().add(THH);
		
		GB = new JTextField();
		GB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GB.setColumns(10);
		GB.setBounds(690, 76, 167, 19);
		getContentPane().add(GB);
		
		GG = new JTextField();
		GG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GG.setColumns(10);
		GG.setBounds(690, 110, 167, 19);
		getContentPane().add(GG);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setBounds(1200, 72, 101, 22);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tùy Chỉnh");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		// các hành động khi nhấn nút thêm
		JButton btnNewButton_1 = new JButton("Thêm");
		mnNewMenu.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String thh,mncc,mtl=null ;
		        int sl = 0 ;
		        Double gb=null,gg=null;
		        if(THH.getText().length()==0){
		    		thh="NULL";
		    		
		    	}
		        else {
		    		thh=THH.getText();
		    	}
		        if(MNCC.getText().length()==0){
		    		mncc="NULL";
		    		
		    	}
		        else {
		    		mncc=MNCC.getText();
		    	}
		        
		        if(MTL.getText().length()==0){
		    		mtl="NULL";
		    		
		    	}
		    	else {
		    		mtl=MTL.getText();
		    	}
		    	if(SL.getText().length()==0) {
		    		
		    		return;
		    		}
		    	else {
		    		sl= Integer.parseInt(SL.getText());
		    	}
		    	if(GB.getText().length()==0) {
		    		gb= null ;
		    	}
		    	else {
		    		gb=Double.valueOf(GB.getText());
		    	}
		    	
		    	if(GG.getText().length()==0) {
		    		gg= null;
		    	}
		    	else {
		    		gg=Double.valueOf(GG.getText());
		    	}
		    	
		    	Hanghoa nc= new Hanghoa(thh,mncc,mtl,gb,gg,sl);
		    	
		    	nc.CreateNewHH(nc);
		   	    HH.add(nc);
		    	bangHH.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangHH.getModel(); 
		        String column[] = { "Mã nhà cung cấp", "Tên nhà cung cấp", "số điện thoại nhà cung cấp", "người đại diện", "địa chỉ" };
		        model.setColumnIdentifiers(column);
		        String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
		        
		        for(int i=0;i<HH.size();i++) {
		        	mahanghoa=HH.get(i).getMahang();
				    tenhanghoa=HH.get(i).getTenhanghoa();
				    manhacungcap=HH.get(i).getManhacungcap();
				    matheloai=HH.get(i).getMatheloai();
				    soluong= String.valueOf(HH.get(i).getSoluong());
				    giaban=String.valueOf(HH.get(i).getGiaban());					
				    giagoc =String.valueOf(HH.get(i).getGiagoc());
				    
					String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc};
					model.addRow(row);
		        
			}
		        try {
					 bangHH.setModel(new DefaultTableModel());
					Hanghoa ncc= new Hanghoa();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model2 = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model2.setColumnIdentifiers(colname);
					     
					    while(rs.next()) {
					    	mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                           giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc};
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					 
					    
				
		    }
		    
		});

		JButton btnNewButton_2 = new JButton("Xóa  ");
		mnNewMenu.add(btnNewButton_2);
		
		JLabel lblSinThoi_1_1 = new JLabel("Giá Bán   :");
		lblSinThoi_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1.setBounds(587, 73, 88, 24);
		getContentPane().add(lblSinThoi_1_1);
		
		JLabel lblSinThoi_1_1_1 = new JLabel("Mã Nhà Cung Cấp :");
		lblSinThoi_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1_1.setBounds(893, 73, 126, 24);
		getContentPane().add(lblSinThoi_1_1_1);
		
		MNCC = new JTextField();
		MNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MNCC.setColumns(10);
		MNCC.setBounds(1023, 77, 167, 19);
		getContentPane().add(MNCC);
		
		JLabel lblSinThoi_1_1_1_1 = new JLabel("Mã Thể Loại :");
		lblSinThoi_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1_1_1.setBounds(893, 107, 126, 24);
		getContentPane().add(lblSinThoi_1_1_1_1);
		
		MTL = new JTextField();
		MTL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MTL.setColumns(10);
		MTL.setBounds(1023, 111, 167, 19);
		getContentPane().add(MTL);
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        Hanghoa hh= new Hanghoa();
	        hh.deleteData(textField.getText());
	            bangHH.setModel(new DefaultTableModel());
	            try {
	            	ResultSet rs=hh.getData();
	            	ResultSetMetaData rsmd = rs.getMetaData();
	            	 DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
				     int cols = rsmd.getColumnCount();
				     String[] colname=new String[cols];
				     for(int i=0;i<cols;i++) 
				    	 colname[i]=rsmd.getColumnName(i+1);
				     model.setColumnIdentifiers(colname);
				     String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
				     while(rs.next()) {
				    	 mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                         giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
					    	model.addRow(row);
					    }
				} catch (Exception e2) {
					SPkhongtontai.main(new String[] {});
				}
	            try {
					 bangHH.setModel(new DefaultTableModel());
					Hanghoa ncc= new Hanghoa();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
					    while(rs.next()) {
					    	mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                           giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        } 
	});
		
	
		
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hang_hoa supplierFrame = new hang_hoa();
                supplierFrame.createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        setTitle("Hàng Hóa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}
*/
package dohoa;
import Object.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class hang_hoa extends JFrame {
	private JTextField textField;
	private JTable bangHH;
	private JTextField textField_3;
	private JTextField SL;
	private JTextField THH;
	private JTextField GB;
	private JTextField GG;
	private JTextField MNCC;
	private JTextField MTL;
	public hang_hoa() {
		// khởi tạo mảng nhà cung cấp
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1186, 50);
		getContentPane().add(panel_1);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(new String[]{});
        		dispose();
			}
		});
		btnngXut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnngXut.setBounds(874, 13, 141, 29);
		panel_1.add(btnngXut);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(141, 13, 470, 29);
		panel_1.add(textField);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(637, 13, 85, 29);
		panel_1.add(btnNewButton);
		ArrayList<Hanghoa> HH = new ArrayList<Hanghoa>();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	bangHH.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangHH.getModel(); 
		        String column[] = { "Mã hàng hóa", "Tên hàng hóa", "Mã nhà cung cấp", "Mã thể loại", "Số lượng", "Giá Bán" , "Giá Gốc"};
		        model.setColumnIdentifiers(column);
		        String mahanghoa,tenhanghoa,manhacungcap,matheloai;
				String giaban;
				String giagoc;
				String soluong;
		        Hanghoa nc=new Hanghoa();
		        Hanghoa nc1=new Hanghoa();
		        
		       ResultSet rs= nc.getData();
		       try {	
		    	  boolean check =true;
		       if(textField.getText().length()==0) {
		    	   check=false;
		    		   SPkhongtontai.main(new String [] {});
		    		   return;
		       }else {
		    	   
		    	   nc = nc.searchDataByMaHH(textField.getText());
   
		    	   if (nc == null) {
		    		   HH.addAll(nc1.searchDataByName(textField.getText()));
		    	      
		    	   }


		       	}
		       
			     while(rs.next()&&check==true) {
			    	 if ((rs.getString("mahanghoa").equals(nc.getMahang()))) {
			    		
				    	mahanghoa = rs.getString("mahanghoa");
				    	tenhanghoa=rs.getString("tenhanghoa");
				    	manhacungcap=rs.getString("manhacungcap");
				    	matheloai=rs.getString("matheloai");
				        soluong=String.valueOf(rs.getInt("soluong"));
				        giaban=String.valueOf(rs.getDouble("giaban"));
				        giagoc = String.valueOf(rs.getDouble("giagoc"));
				        
				    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
				    	model.addRow(row);
				    	
			    	 }
			    	 
			    	 
				    }
		       }
		       catch (Exception e1) {
				e1.getMessage();
			}
		       // hiển thị bảng ra ngoài màn hình
			for(int i=0;i<HH.size();i++) {
				mahanghoa=HH.get(i).getMahang();
			    tenhanghoa=HH.get(i).getTenhanghoa();
			    manhacungcap=HH.get(i).getManhacungcap();
			    matheloai=HH.get(i).getMatheloai();
			    soluong= String.valueOf(HH.get(i).getSoluong());
			    giaban=String.valueOf(HH.get(i).getGiaban());					
			    giagoc =String.valueOf(HH.get(i).getGiagoc());
			    
				String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc};
				model.addRow(row);
			
}
		        HH.removeAll(HH);
			}
		});
		
		
		JLabel lblNhnVin = new JLabel("HÀNG HÓA ");
		lblNhnVin.setForeground(new Color(255, 0, 0));
		lblNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNhnVin.setBounds(10, 10, 184, 29);
		panel_1.add(lblNhnVin);
		
		JButton btnDisplay = new JButton("Làm mới");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDisplay.setBounds(745, 13, 119, 29);
		panel_1.add(btnDisplay);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[] {});
				dispose();
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThot.setBounds(1031, 13, 141, 29);
		panel_1.add(btnThot);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 bangHH.setModel(new DefaultTableModel());
					Hanghoa ncc= new Hanghoa();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giagoc,giaban;
					    while(rs.next()) {
					    	mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                            giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giagoc,giaban };
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 49, 193, 506);
		getContentPane().add(panel);
		
		JButton productButton = new JButton("Bán Hàng");
		productButton.setBackground(new Color(255, 255, 255));
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ban_hang.main(new String[] {});
				dispose();
			}
		});
		productButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton.setBounds(10, 305, 173, 60);
		panel.add(productButton);
		
		JButton supplierButton = new JButton("Nhà cung cấp");
		supplierButton.setBackground(new Color(255, 255, 255));
		supplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha_cung_cap.main(new String[]{});
				dispose();
			}
		});
		supplierButton.setForeground(new Color(0, 0, 0));
		supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		supplierButton.setBounds(10, 165, 173, 60);
		panel.add(supplierButton);
		
		JButton customerButton = new JButton("Khách hàng");
		customerButton.setBackground(new Color(255, 255, 255));
		customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khach_hang.main(new String[]{});
				dispose();
				
			}
		});
		customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		customerButton.setBounds(10, 95, 173, 60);
		panel.add(customerButton);
		
		JButton employeeButton = new JButton("Nhân viên");
		employeeButton.setBackground(new Color(255, 255, 255));
		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhan_vien.main(new String[] {});
				dispose();
			}
		});
		employeeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		employeeButton.setBounds(10, 25, 173, 60);
		panel.add(employeeButton);
		
		JButton productButton_1 = new JButton("Hàng hoá");
		productButton_1.setBackground(new Color(255, 255, 255));
		productButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		productButton_1.setForeground(new Color(255, 0, 0));
		productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton_1.setBounds(10, 235, 173, 60);
		panel.add(productButton_1);
		
		JButton statisticButton = new JButton("Thống kê");
		statisticButton.setBackground(new Color(255, 255, 255));
		statisticButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thong_ke.main(new String[] {});
				dispose();
			}
		});
		statisticButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		statisticButton.setBounds(10, 445, 173, 60);
		panel.add(statisticButton);
		
		JButton btnNhpHng = new JButton("Nhập Hàng");
		btnNhpHng.setBackground(new Color(255, 255, 255));
		btnNhpHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphang.main(new String[] {});
				dispose();
			}
		});
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNhpHng.setBounds(10, 375, 173, 60);
		panel.add(btnNhpHng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 143, 987, 412);
		getContentPane().add(scrollPane);
		
		bangHH = new JTable();
		scrollPane.setViewportView(bangHH);
		
		JMenu menu = new JMenu("New menu");
		scrollPane.setColumnHeaderView(menu);
		
		textField_3 = new JTextField();
		scrollPane.setColumnHeaderView(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTnNhCung = new JLabel("Số lượng        :");
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnNhCung.setBounds(222, 109, 122, 24);
		getContentPane().add(lblTnNhCung);
		
		JLabel lblSinThoi_1 = new JLabel("Giá Gốc   : ");
		lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1.setBounds(536, 109, 88, 24);
		getContentPane().add(lblSinThoi_1);
		
		JLabel lblSinThoi_2 = new JLabel("Tên hàng hóa :");
		lblSinThoi_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_2.setBounds(221, 75, 130, 24);
		getContentPane().add(lblSinThoi_2);
		
		SL = new JTextField();
		SL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SL.setColumns(10);
		SL.setBounds(352, 113, 122, 19);
		getContentPane().add(SL);
		
		THH = new JTextField();
		THH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		THH.setColumns(10);
		THH.setBounds(352, 78, 122, 19);
		getContentPane().add(THH);
		
		GB = new JTextField();
		GB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GB.setColumns(10);
		GB.setBounds(639, 78, 86, 19);
		getContentPane().add(GB);
		
		GG = new JTextField();
		GG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GG.setColumns(10);
		GG.setBounds(639, 112, 86, 19);
		getContentPane().add(GG);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setBounds(1050, 72, 101, 22);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tùy Chỉnh");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		// các hành động khi nhấn nút thêm
		JButton btnNewButton_1 = new JButton("Thêm");
		mnNewMenu.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String thh,mncc,mtl=null ;
		        int sl = 0 ;
		        Double gb=null,gg=null;
		        if(THH.getText().length()==0){
		    		thh="NULL";
		    		
		    	}
		        else {
		    		thh=THH.getText();
		    	}
		        if(MNCC.getText().length()==0){
		    		mncc="NULL";
		    		
		    	}
		        else {
		    		mncc=MNCC.getText();
		    	}
		        
		        if(MTL.getText().length()==0){
		    		mtl="NULL";
		    		
		    	}
		    	else {
		    		mtl=MTL.getText();
		    	}
		    	if(SL.getText().length()==0) {
		    		
		    		return;
		    		}
		    	else {
		    		sl= Integer.parseInt(SL.getText());
		    	}
		    	if(GB.getText().length()==0) {
		    		gb= null ;
		    	}
		    	else {
		    		gb=Double.valueOf(GB.getText());
		    	}
		    	
		    	if(GG.getText().length()==0) {
		    		gg= null;
		    	}
		    	else {
		    		gg=Double.valueOf(GG.getText());
		    	}
		    	
		    	Hanghoa nc= new Hanghoa(thh,mncc,mtl,gb,gg,sl);
		    	
		    	nc.CreateNewHH(nc);
		   	    HH.add(nc);
		    	bangHH.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangHH.getModel(); 
		        String column[] = { "Mã nhà cung cấp", "Tên nhà cung cấp", "số điện thoại nhà cung cấp", "người đại diện", "địa chỉ" };
		        model.setColumnIdentifiers(column);
		        String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
		        
		        for(int i=0;i<HH.size();i++) {
		        	mahanghoa=HH.get(i).getMahang();
				    tenhanghoa=HH.get(i).getTenhanghoa();
				    manhacungcap=HH.get(i).getManhacungcap();
				    matheloai=HH.get(i).getMatheloai();
				    soluong= String.valueOf(HH.get(i).getSoluong());
				    giaban=String.valueOf(HH.get(i).getGiaban());					
				    giagoc =String.valueOf(HH.get(i).getGiagoc());
				    
					String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc};
					model.addRow(row);
		        
			}
		        try {
					 bangHH.setModel(new DefaultTableModel());
					Hanghoa ncc= new Hanghoa();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model2 = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model2.setColumnIdentifiers(colname);
					     
					    while(rs.next()) {
					    	mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                           giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc};
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					 
					    
				
		    }
		    
		});

		JButton btnNewButton_2 = new JButton("Xóa  ");
		mnNewMenu.add(btnNewButton_2);
		
		JLabel lblSinThoi_1_1 = new JLabel("Giá Bán   :");
		lblSinThoi_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1.setBounds(536, 75, 88, 24);
		getContentPane().add(lblSinThoi_1_1);
		
		JLabel lblSinThoi_1_1_1 = new JLabel("Mã Nhà Cung Cấp :");
		lblSinThoi_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1_1.setBounds(784, 75, 126, 24);
		getContentPane().add(lblSinThoi_1_1_1);
		
		MNCC = new JTextField();
		MNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MNCC.setColumns(10);
		MNCC.setBounds(914, 79, 117, 19);
		getContentPane().add(MNCC);
		
		JLabel lblSinThoi_1_1_1_1 = new JLabel("Mã Thể Loại :");
		lblSinThoi_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1_1_1.setBounds(784, 109, 126, 24);
		getContentPane().add(lblSinThoi_1_1_1_1);
		
		MTL = new JTextField();
		MTL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MTL.setColumns(10);
		MTL.setBounds(914, 113, 117, 19);
		getContentPane().add(MTL);
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        Hanghoa hh= new Hanghoa();
	        hh.deleteData(textField.getText());
	            bangHH.setModel(new DefaultTableModel());
	            try {
	            	ResultSet rs=hh.getData();
	            	ResultSetMetaData rsmd = rs.getMetaData();
	            	 DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
				     int cols = rsmd.getColumnCount();
				     String[] colname=new String[cols];
				     for(int i=0;i<cols;i++) 
				    	 colname[i]=rsmd.getColumnName(i+1);
				     model.setColumnIdentifiers(colname);
				     String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
				     while(rs.next()) {
				    	 mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                         giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
					    	model.addRow(row);
					    }
				} catch (Exception e2) {
					SPkhongtontai.main(new String[] {});
				}
	            try {
					 bangHH.setModel(new DefaultTableModel());
					Hanghoa ncc= new Hanghoa();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String  mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc;
					    while(rs.next()) {
					    	mahanghoa=rs.getString("mahanghoa");
					        tenhanghoa=rs.getString("tenhanghoa");
					        manhacungcap=rs.getString("manhacungcap");
					        matheloai=rs.getString("matheloai");
							soluong=String.valueOf(rs.getInt("soluong"));
                           giaban=String.valueOf(rs.getString("giaban"));				
					        giagoc = String.valueOf(rs.getDouble("giagoc"));
					        
					    	String[] row= {mahanghoa,tenhanghoa,manhacungcap,matheloai, soluong,giaban,giagoc };
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        } 
	});
		
	
		
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hang_hoa supplierFrame = new hang_hoa();
                
                supplierFrame.createAndShowGUI();
                supplierFrame.setSize(1200, 600);
                
            }
        });
    }

    public void createAndShowGUI() {
        setTitle("Hàng Hóa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     
        setVisible(true);
    }
}
//bao


