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
public class khach_hang extends JFrame {
	private JTextField textField;
	private JTable bangHH;
	private JTextField textField_3;
	private JTextField GT;
	private JTextField TKH;
	private JTextField SDT;
	private JTextField DTL;
	private JTextField DC;
	public khach_hang() {
		// khởi tạo mảng nhà cung cấp
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1180, 50);
		getContentPane().add(panel_1);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.setBackground(new Color(255, 255, 255));
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(new String[]{});
        		dispose();
			}
		});
		btnngXut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnngXut.setBounds(894, 16, 141, 29);
		panel_1.add(btnngXut);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 16, 470, 29);
		panel_1.add(textField);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(670, 16, 85, 29);
		panel_1.add(btnNewButton);
		ArrayList<Khachhang> HH = new ArrayList<Khachhang>();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	bangHH.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangHH.getModel(); 
		        String column[] = { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Giới tính", "Điểm tích lũy" };
		        model.setColumnIdentifiers(column);
		        String mkh,tkh,sdt,dc,gt;
		        String dtl;
			
		        Khachhang nc=new Khachhang();
		        Khachhang nc1=new Khachhang();
		        
		       ResultSet rs= nc.getData();
		       try {	
		    	  boolean check =true;
		       if(textField.getText().length()==0) {
		    	   check=false;
		    		  
		    		   return;
		       }else {
	
		    	   nc = nc.searchDataByMaKH(textField.getText());

		    	   if (nc == null) {
		    		   HH.addAll(nc1.searchDataByName(textField.getText()));
		    	      
		    	   }else {
		    		   HH.add(nc);
		    	   }


		       	}
		       
			     while(rs.next()&&check==true) {
			    	 if ((rs.getString("mahanghoa").equals(nc.getMa()))) {
			    		
				    	mkh = rs.getString("makhachhang");
				    	tkh=rs.getString("tenkhachhang");
				    	sdt=rs.getString("sodienthoaikhachhang");
				    	dc=rs.getString("diachikhachhang");
				    	gt=rs.getString("gioitinh");
				    	dtl = String.valueOf(rs.getInt("diemtichluy"));
				        
				    	String[] row= {mkh,tkh,sdt,dc,dtl };
				    	model.addRow(row);
				    	
			    	 }
			    	 
			    	 
				    }
		       }
		       catch (Exception e1) {
				e1.getMessage();
			}
		       // hiển thị bảng ra ngoài màn hình
			for(int i=0;i<HH.size();i++) {
				mkh=HH.get(i).getMa();
			    tkh=HH.get(i).getTen();
			    sdt=HH.get(i).getSoDienThoai();
			    dc=HH.get(i).getDiaChi();
			    gt=HH.get(i).getGioiTinh();
			    dtl= String.valueOf(HH.get(i).getDiemtichluy());
			    
			    
				String[] row= {mkh,tkh,sdt,dc,gt,dtl };
				model.addRow(row);
			
}
		        HH.removeAll(HH);
			}
		});
		
		
		JLabel lblNhnVin = new JLabel("KHÁCH HÀNG");
		lblNhnVin.setForeground(new Color(255, 0, 0));
		lblNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNhnVin.setBounds(10, 10, 184, 29);
		panel_1.add(lblNhnVin);
		
		JButton btnDisplay = new JButton("Làm mới");
		btnDisplay.setBackground(new Color(255, 255, 255));
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDisplay.setBounds(765, 16, 119, 29);
		panel_1.add(btnDisplay);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setBackground(new Color(255, 255, 255));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[] {});
				dispose();
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThot.setBounds(1037, 16, 141, 29);
		panel_1.add(btnThot);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 bangHH.setModel(new DefaultTableModel());
					Khachhang ncc= new Khachhang();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) bangHH.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String  mkh,tkh,sdt,dc,gt,dtl ;
					    while(rs.next()) {
					    	mkh = rs.getString("makhachhang");
					    	tkh=rs.getString("tenkhachhang");
					    	sdt=rs.getString("sodienthoaikhachhang");
					    	dc=rs.getString("diachikhachhang");
					    	gt=rs.getString("gioitinh");
					    	dtl = String.valueOf(rs.getInt("diemtichluy"));
					        
					    	String[] row= {mkh,tkh,sdt,dc,gt,dtl};
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 49, 193, 535);
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
		productButton.setBounds(10, 313, 173, 60);
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
		supplierButton.setBounds(10, 173, 173, 60);
		panel.add(supplierButton);
		
		JButton customerButton = new JButton("Khách hàng");
		customerButton.setBackground(new Color(255, 255, 255));
		customerButton.setForeground(new Color(255, 0, 0));
		customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		customerButton.setBounds(10, 103, 173, 60);
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
		employeeButton.setBounds(10, 33, 173, 60);
		panel.add(employeeButton);
		
		JButton productButton_1 = new JButton("Hàng hoá");
		productButton_1.setBackground(new Color(255, 255, 255));
		productButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hang_hoa.main(new String[] {});
				dispose();
			}
		});
		productButton_1.setForeground(new Color(0, 0, 0));
		productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton_1.setBounds(10, 243, 173, 60);
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
		statisticButton.setBounds(10, 453, 173, 60);
		panel.add(statisticButton);
		
		JButton btnNhpHng = new JButton("Nhập Hàng");
		btnNhpHng.setBackground(new Color(255, 255, 255));
		btnNhpHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphang.main(new String[] {});
				dispose();
			}
		});
		btnNhpHng.setBounds(10, 383, 173, 60);
		panel.add(btnNhpHng);
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 143, 966, 441);
		getContentPane().add(scrollPane);
		
		bangHH = new JTable();
		scrollPane.setViewportView(bangHH);
		
		JMenu menu = new JMenu("New menu");
		scrollPane.setColumnHeaderView(menu);
		
		textField_3 = new JTextField();
		scrollPane.setColumnHeaderView(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTnNhCung = new JLabel("Giới tính :");
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnNhCung.setBounds(257, 107, 122, 24);
		getContentPane().add(lblTnNhCung);
		
		JLabel lblSinThoi_1 = new JLabel("Điểm tích lũy");
		lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1.setBounds(539, 107, 88, 24);
		getContentPane().add(lblSinThoi_1);
		
		JLabel lblSinThoi_2 = new JLabel("Tên khách hàng :");
		lblSinThoi_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_2.setBounds(256, 73, 130, 24);
		getContentPane().add(lblSinThoi_2);
		
		GT = new JTextField();
		GT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GT.setColumns(10);
		GT.setBounds(387, 111, 121, 19);
		getContentPane().add(GT);
		
		TKH = new JTextField();
		TKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TKH.setColumns(10);
		TKH.setBounds(387, 76, 121, 19);
		getContentPane().add(TKH);
		
		SDT = new JTextField();
		SDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SDT.setColumns(10);
		SDT.setBounds(642, 76, 104, 19);
		getContentPane().add(SDT);
		
		DTL = new JTextField();
		DTL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DTL.setColumns(10);
		DTL.setBounds(642, 110, 104, 19);
		getContentPane().add(DTL);
		
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
		    	String tkh_,sdt_,dc_,gt_;
		    	int dtl_ ;
		        if(TKH.getText().length()==0){
		    		tkh_="NULL";
		    		
		    	}
		        else {
		    		tkh_=TKH.getText();
		    	}
		        if(SDT.getText().length()==0){
		    		sdt_="NULL";
		    		
		    	}
		        else {
		    		sdt_=SDT.getText();
		    	}
		        
		        if(DC.getText().length()==0){
		    		dc_="NULL";
		    		
		    	}
		    	else {
		    		dc_=DC.getText();
		    	}
		        if(GT.getText().length()==0){
		    		gt_="NULL";
		    		
		    	}
		    	else {
		    		gt_=GT.getText();
		    	}
		    	if(DTL.getText().length()==0) {
		    		
		    		return;
		    		}
		    	else {
		    		dtl_= Integer.parseInt(DTL.getText());
		    	}
		    	
		    	
		    	Khachhang nc= new Khachhang(tkh_,sdt_,dc_,gt_,dtl_ );
		    	
		    	nc.CreateNewKH(nc);
		   	    HH.add(nc);
		    	bangHH.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangHH.getModel(); 
		        String column[] = { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Giới tính", "Điểm tích lũy" };
		        model.setColumnIdentifiers(column);
		        String  mkh,tkh,sdt,dc,gt,dtl;
		        
		        for(int i=0;i<HH.size();i++) {
		        	
		        	mkh=HH.get(i).getMa();
				    tkh=HH.get(i).getTen();
				    sdt=HH.get(i).getSoDienThoai();
				    dc=HH.get(i).getDiaChi();
				    gt=HH.get(i).getGioiTinh();
				    dtl= String.valueOf(HH.get(i).getDiemtichluy());
				    
				    
					String[] row= {mkh,tkh,sdt,dc,gt,dtl };
					model.addRow(row);
		        
			}
		       
					    
				
		    }
		    
		});

		JButton btnNewButton_2 = new JButton("Xóa  ");
		mnNewMenu.add(btnNewButton_2);
		
		JLabel lblSinThoi_1_1 = new JLabel("Số điện thoai :");
		lblSinThoi_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1.setBounds(539, 73, 88, 24);
		getContentPane().add(lblSinThoi_1_1);
		
		JLabel lblSinThoi_1_1_1 = new JLabel("Địa chỉ :");
		lblSinThoi_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1_1_1.setBounds(795, 73, 126, 24);
		getContentPane().add(lblSinThoi_1_1_1);
		
		DC = new JTextField();
		DC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DC.setColumns(10);
		DC.setBounds(876, 76, 167, 19);
		getContentPane().add(DC);
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        Khachhang hh= new Khachhang();
	        if(textField.getText().length()==0) {
	        	return;
	        }else {
	        	hh.deleteData(textField.getText());
	        }
	        
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
				     String  mkh,tkh,sdt,dc,gt,dtl;
				     while(rs.next()) {
					    	mkh = rs.getString("makhachhang");
					    	tkh=rs.getString("tenkhachhang");
					    	sdt=rs.getString("sodienthoaikhachhang");
					    	dc=rs.getString("diachikhachhang");
					    	gt=rs.getString("gioitinh");
					    	dtl = String.valueOf(rs.getInt("diemtichluy"));
					        
					    	String[] row= {mkh,tkh,sdt,dc,gt,dtl};
					    	model.addRow(row);
					    }
				} catch (Exception e2) {
					
				}
	            
	        } 
	});
		
	
		
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                khach_hang supplierFrame = new khach_hang();
                supplierFrame.createAndShowGUI();
                supplierFrame.setSize(1193, 633);
            }
        });
    }

    public void createAndShowGUI() {
        setTitle("Hàng Hóa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setVisible(true);
    }
}
