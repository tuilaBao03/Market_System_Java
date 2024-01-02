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
public class nha_cung_cap extends JFrame {
	private JTextField textField;
	private JTable bangNCC;
	private JTextField textField_3;
	private JTextField TNCC;
	private JTextField NDD;
	private JTextField SDT;
	private JTextField DC;
	public nha_cung_cap() {
		// khởi tạo mảng nhà cung cấp
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1170, 50);
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
		btnngXut.setBounds(894, 13, 141, 29);
		panel_1.add(btnngXut);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(191, 13, 470, 29);
		panel_1.add(textField);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(671, 13, 85, 29);
		panel_1.add(btnNewButton);
		ArrayList<NhaCungCap> NCC = new ArrayList<NhaCungCap>();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	bangNCC.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangNCC.getModel(); 
		        String column[] = { "Mã nhà cung cấp", "Tên nhà cung cấp", "số điện thoại nhà cung cấp", "người đại diện", "địa chỉ" };
		        model.setColumnIdentifiers(column);
		        String manhacungcap,tennhacungcap,sodienthoainhacungcap,nguoidaidien,diachinhacungcap;
		     
		        NhaCungCap nc=new NhaCungCap();
		        NhaCungCap nc1=new NhaCungCap();
		        
		       ResultSet rs= nc.getData();
		       try {	
		    	  boolean check =true;
		       if(textField.getText().length()==0) {
		    	   check=false;
		    		   SPkhongtontai.main(new String [] {});
		    		   return;
		       }else {
		    	   
		    	   nc = nc.searchDataByMaNCC(textField.getText());
   
		    	   if (nc == null) {
		    		   NCC.addAll(nc1.searchDataByName(textField.getText()));
		    	      
		    	   }


		       	}
		       
			     while(rs.next()&&check==true) {
			    	 if ((rs.getString("manhacungcap").equals(nc.getManhacungcap()))) {
				    	manhacungcap = rs.getString(1);
				    	tennhacungcap=rs.getString(2);
				    	sodienthoainhacungcap=rs.getString(3);
				    	nguoidaidien=rs.getString(4);
				    	diachinhacungcap=rs.getString(5);
				    	String[] row= {manhacungcap,tennhacungcap,sodienthoainhacungcap,nguoidaidien,diachinhacungcap };
				    	model.addRow(row);
				    	
			    	 }
			    	 
			    	 
				    }
		       }
		       catch (Exception e1) {
				e1.getMessage();
			}

		        // hiển thị bảng ra ngoài màn hình
		        for(int i=0;i<NCC.size();i++) {
		        	manhacungcap=NCC.get(i).getManhacungcap();
			        tennhacungcap=NCC.get(i).getTennhacungcap();
			        sodienthoainhacungcap=NCC.get(i).getSodienthoainhacungcap();
			        nguoidaidien=NCC.get(i).getNguoidaidien();
			        diachinhacungcap=NCC.get(i).getDiachinhacungcap();
			        String[] row= {manhacungcap,tennhacungcap,sodienthoainhacungcap,nguoidaidien,diachinhacungcap};
			    	model.addRow(row);
		        
			}
		        NCC.removeAll(NCC);
			}
		});
		
		
		JLabel lblNhnVin = new JLabel("NHÀ CUNG CẤP");
		lblNhnVin.setForeground(new Color(255, 0, 0));
		lblNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNhnVin.setBounds(10, 10, 184, 29);
		panel_1.add(lblNhnVin);
		
		JButton btnDisplay = new JButton("Làm mới");
		btnDisplay.setBackground(new Color(255, 255, 255));
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDisplay.setBounds(766, 13, 119, 29);
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
		btnThot.setBounds(1045, 13, 110, 29);
		panel_1.add(btnThot);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 bangNCC.setModel(new DefaultTableModel());
					NhaCungCap ncc= new NhaCungCap();
					 ResultSet rs= ncc.getData();
					  ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) bangNCC.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String MaNhaCungCap,TenNhaCungCap,SoDienThoaiNhaCungCap,NguoiDaiDien,DiaChiNhaCungCap ;
					    while(rs.next()) {
					    	MaNhaCungCap = rs.getString(1);
					    	TenNhaCungCap=rs.getString(2);
					    	SoDienThoaiNhaCungCap=rs.getString(3);
					    	NguoiDaiDien=rs.getString(4);
					    	DiaChiNhaCungCap=rs.getString(5);
					    	
					    	String[] row= {MaNhaCungCap,TenNhaCungCap,SoDienThoaiNhaCungCap,NguoiDaiDien,DiaChiNhaCungCap };
					    	model.addRow(row);
					    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 49, 193, 505);
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
		productButton.setBounds(10, 290, 173, 60);
		panel.add(productButton);
		
		JButton supplierButton = new JButton("Nhà cung cấp");
		supplierButton.setBackground(new Color(255, 255, 255));
		supplierButton.setForeground(new Color(255, 0, 0));
		supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		supplierButton.setBounds(10, 150, 173, 60);
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
		customerButton.setBounds(10, 80, 173, 60);
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
		employeeButton.setBounds(10, 10, 173, 60);
		panel.add(employeeButton);
		
		JButton productButton_1 = new JButton("Hàng hoá");
		productButton_1.setBackground(new Color(255, 255, 255));
		productButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hang_hoa.main(new String[] {});
				dispose();
			}
		});
		productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton_1.setBounds(10, 220, 173, 60);
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
		statisticButton.setBounds(10, 430, 173, 60);
		panel.add(statisticButton);
		
		JButton btnNhpHng = new JButton("Nhập hàng");
		btnNhpHng.setBackground(new Color(255, 255, 255));
		btnNhpHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphang.main(new String[] {});
				dispose();
			}
		});
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNhpHng.setBounds(10, 360, 173, 60);
		panel.add(btnNhpHng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 159, 931, 395);
		getContentPane().add(scrollPane);
		
		bangNCC = new JTable();
		scrollPane.setViewportView(bangNCC);
		
		JMenu menu = new JMenu("New menu");
		scrollPane.setColumnHeaderView(menu);
		
		textField_3 = new JTextField();
		scrollPane.setColumnHeaderView(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTnNhCung = new JLabel("Tên Nhà Cung Cấp :");
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnNhCung.setBounds(255, 107, 122, 24);
		getContentPane().add(lblTnNhCung);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại :");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi.setBounds(587, 73, 101, 24);
		getContentPane().add(lblSinThoi);
		
		JLabel lblSinThoi_1 = new JLabel("Điạ Chỉ  :");
		lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_1.setBounds(587, 107, 88, 24);
		getContentPane().add(lblSinThoi_1);
		
		JLabel lblSinThoi_2 = new JLabel("Người đại diện :");
		lblSinThoi_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi_2.setBounds(256, 73, 130, 24);
		getContentPane().add(lblSinThoi_2);
		
		TNCC = new JTextField();
		TNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TNCC.setColumns(10);
		TNCC.setBounds(387, 111, 167, 19);
		getContentPane().add(TNCC);
		
		NDD = new JTextField();
		NDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NDD.setColumns(10);
		NDD.setBounds(387, 76, 167, 19);
		getContentPane().add(NDD);
		
		SDT = new JTextField();
		SDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SDT.setColumns(10);
		SDT.setBounds(690, 76, 167, 19);
		getContentPane().add(SDT);
		
		DC = new JTextField();
		DC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DC.setColumns(10);
		DC.setBounds(690, 110, 167, 19);
		getContentPane().add(DC);
		
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
		        String ten,sdt=null ,ndd=null,diachi=null;
		    	if(TNCC.getText().length()==0) {
		    		// hiển thị ra của sổ không tạo được vì thiếu tên nhà cung cấp
		    		return;
		    		}
		    	else {
		    		ten=TNCC.getText();
		    	}
		    	if(SDT.getText().length()==0) {
		    		sdt="NULL";
		    	}
		    	else {
		    		sdt=SDT.getText();
		    	}
		    	if(NDD.getText().length()==0){
		    		ndd="NULL";
		    		
		    	}
		    	else {
		    		ndd=NDD.getText();
		    	}
		    	if(DC.getText().length()==0) {
		    		diachi="NULL";
		    	}
		    	else {
		    		diachi=DC.getText();
		    	}
		    	NhaCungCap nc=new NhaCungCap(ten,sdt, ndd, diachi);
		    	
		    	nc.CreateNewNCC(nc);
		    	NCC.add(nc);
		    	bangNCC.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) bangNCC.getModel(); 
		        String column[] = { "Mã nhà cung cấp", "Tên nhà cung cấp", "số điện thoại nhà cung cấp", "người đại diện", "địa chỉ" };
		        model.setColumnIdentifiers(column);
		        String manhacungcap,tennhacungcap,sodienthoainhacungcap,nguoidaidien,diachinhacungcap;
		        
		        for(int i=0;i<NCC.size();i++) {
		        	manhacungcap=NCC.get(i).getManhacungcap();
			        tennhacungcap=NCC.get(i).getTennhacungcap();
			        sodienthoainhacungcap=NCC.get(i).getSodienthoainhacungcap();
			        nguoidaidien=NCC.get(i).getNguoidaidien();
			       diachinhacungcap=NCC.get(i).getDiachinhacungcap();
			        String[] row= {manhacungcap,tennhacungcap,sodienthoainhacungcap,nguoidaidien,diachinhacungcap};
			    	model.addRow(row);
		        
			}
		            
					 
					    
				
		    }
		    
		});

		JButton btnNewButton_2 = new JButton("Xóa  ");
		mnNewMenu.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        NhaCungCap ncc= new NhaCungCap();
	        ncc.deleteData(textField.getText());
	            bangNCC.setModel(new DefaultTableModel());
	            try {
	            	ResultSet rs=ncc.getData();
	            	ResultSetMetaData rsmd = rs.getMetaData();
	            	 DefaultTableModel model = (DefaultTableModel) bangNCC.getModel();
				     int cols = rsmd.getColumnCount();
				     String[] colname=new String[cols];
				     for(int i=0;i<cols;i++)
				    	 colname[i]=rsmd.getColumnName(i+1);
				     model.setColumnIdentifiers(colname);
				     String MaNhaCungCap,TenNhaCungCap,SoDienThoaiNhaCungCap,NguoiDaiDien,DiaChiNhaCungCap ;
				     while(rs.next()) {
					    	MaNhaCungCap = rs.getString(1);
					    	TenNhaCungCap=rs.getString(2);
					    	SoDienThoaiNhaCungCap=rs.getString(3);
					    	NguoiDaiDien=rs.getString(4);
					    	DiaChiNhaCungCap=rs.getString(5);
					    	String[] row= {MaNhaCungCap,TenNhaCungCap,SoDienThoaiNhaCungCap,NguoiDaiDien,DiaChiNhaCungCap };
					    	model.addRow(row);
					    }
				} catch (Exception e2) {
					SPkhongtontai.main(new String[] {});
				}
   
	        } 
	});
		
	
		
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                nha_cung_cap supplierFrame = new nha_cung_cap();
                supplierFrame.createAndShowGUI();
                supplierFrame.setSize(1184, 610);
            }
        });
    }

    public void createAndShowGUI() {
        setTitle("Nhà cung cấp");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setVisible(true);
    }
}
