package dohoa;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import cong.ConnectURL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;





public class thong_ke extends JFrame {
	private JTextField Ngay;
	private JTextField Thang;
	private JTextField Nam;
	private JTable table;
	public thong_ke() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1150, 50);
		getContentPane().add(panel_1);

		JLabel lblNhnVin = new JLabel("THỐNG KÊ");
		lblNhnVin.setForeground(new Color(255, 0, 0));
		lblNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNhnVin.setBounds(10, 10, 184, 29);
		panel_1.add(lblNhnVin);
		

		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.setBackground(new Color(255, 255, 255));
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(new String[]{});
        		dispose();
			}
		});
		btnngXut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnngXut.setBounds(1014, 11, 130, 29);
		panel_1.add(btnngXut);
		
		Ngay = new JTextField();
		Ngay.setBounds(266, 19, 109, 19);
		panel_1.add(Ngay);
		Ngay.setColumns(10);
		
		Thang = new JTextField();
		Thang.setBounds(489, 19, 109, 19);
		panel_1.add(Thang);
		Thang.setColumns(10);
		
		Nam = new JTextField();
		Nam.setBounds(742, 19, 109, 19);
		panel_1.add(Nam);
		Nam.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ngày : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(180, 22, 76, 17);
		panel_1.add(lblNewLabel);
		
		JLabel lblThng = new JLabel("Tháng :");
		lblThng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThng.setBounds(412, 22, 76, 17);
		panel_1.add(lblThng);
		
		JLabel lblNm = new JLabel("Năm :");
		lblNm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNm.setBounds(665, 22, 76, 17);
		panel_1.add(lblNm);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setBackground(new Color(255, 255, 255));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[] {});
				dispose();
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThot.setBounds(883, 11, 130, 29);
		panel_1.add(btnThot);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 50, 175, 510);
		getContentPane().add(panel);

		// Nút nhân viên
		JButton employeeButton = new JButton("Nhân viên");
		employeeButton.setBackground(new Color(255, 255, 255));
		employeeButton.setBounds(10, 10, 150, 60);
		panel.add(employeeButton);
		employeeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		employeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nhan_vien employeeFrame = new nhan_vien();
				employeeFrame.createAndShowGUI();
				dispose();
			}
		});

		// Nút khách hàng
		JButton customerButton = new JButton("Khách hàng");
		customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khach_hang employeeFrame = new khach_hang();
				employeeFrame.createAndShowGUI();
				dispose();
			}
		});
		customerButton.setBounds(10, 80, 150, 60);
		panel.add(customerButton);
		customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		customerButton.setBackground(new Color(255, 255, 255));
        customerButton.setForeground(new Color(0, 0, 0));

		// Nút nhà cung cấp
		JButton supplierButton = new JButton("Nhà cung cấp");
		supplierButton.setBackground(new Color(255, 255, 255));
		supplierButton.setBounds(10, 150, 150, 60);
		panel.add(supplierButton);
		supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		supplierButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nha_cung_cap supplierFrame = new nha_cung_cap();
				supplierFrame.createAndShowGUI();
				dispose();
			}
		});

		// Nút hàng hoá
		JButton productButton = new JButton("Hàng hoá");
		productButton.setBackground(new Color(255, 255, 255));
		productButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton.setBounds(10, 220, 150, 60);
		panel.add(productButton);
		productButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hang_hoa productFrame = new hang_hoa();
				productFrame.createAndShowGUI();
				dispose();
			}
		});

		// Nút bán hàng
		JButton sellButton = new JButton("Bán Hàng");
		sellButton.setBackground(new Color(255, 255, 255));
		sellButton.setBounds(10, 290, 150, 60);
		panel.add(sellButton);
		sellButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		sellButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ban_hang sellFrame = new ban_hang();
				sellFrame.createAndShowGUI();
				dispose();
			}
		});

		// Nút thống kê 
		JButton statisticButton = new JButton("Thống kê");
		statisticButton.setBackground(new Color(255, 255, 255));
		statisticButton.setForeground(new Color(255, 0, 0));
		statisticButton.setBounds(10, 430, 150, 60);
		panel.add(statisticButton);
		statisticButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btnNhpHng = new JButton("Nhập hàng");
		btnNhpHng.setBackground(new Color(255, 255, 255));
		btnNhpHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphang.main(new String[] {});
				dispose();
			}
		});
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNhpHng.setBounds(10, 360, 150, 60);
		panel.add(btnNhpHng);
		statisticButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thong_ke statisticFrame = new thong_ke();
				statisticFrame.createAndShowGUI();
				dispose();
			}
		});
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(214, 91, 150, 22);
		getContentPane().add(menuBar);
		
		JMenu bcbht = new JMenu("Báo cáo bán hàng ");
		bcbht.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(bcbht);
		
		JButton btnNewButton_1 = new JButton("Ngày");
		bcbht.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String SQL = "select [Mã hàng hóa], [Tên hàng hóa],[Số lượng], [Tiền]  from bao_cao_ban_hang_theo_ngay \r\n"
		        		+ "where ngay = ? ; ";

		        try {
		            ConnectURL c = new ConnectURL();
		            c.ConnectToTKCSDL();
		            PreparedStatement statement = c.prepareStatement(SQL);
		            statement.setString(1, Ngay.getText());
		            table.setModel(new DefaultTableModel());
		            ResultSet rs = statement.executeQuery();
		            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            int cols = rsmd.getColumnCount();
		            String[] colname = new String[cols];
		            for (int i = 0; i < cols; i++)
		                colname[i] = rsmd.getColumnName(i + 1);
		            model.setColumnIdentifiers(colname);
		            String Mã_hàng_hóa, Tên_hàng_hóa, Số_lượng, Tiền;
		            while (rs.next()) {
		                Mã_hàng_hóa = rs.getString(1);
		                Tên_hàng_hóa = rs.getString(2);
		                Số_lượng = rs.getString(3);
		                Tiền = rs.getString(4);

		                String[] row = { Mã_hàng_hóa, Tên_hàng_hóa, Số_lượng, Tiền };
		                model.addRow(row);
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});

		
		
		
		JButton btnNewButton_2 = new JButton("Tháng");
		bcbht.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String SQL = "select [Mã hàng hóa], [Tên hàng hóa],[Số lượng], [Tiền]  from bao_cao_ban_hang_theo_thang \r\n"
		        		+ "where thang = ? ; ";

		        try {
		            ConnectURL c = new ConnectURL();
		            c.ConnectToTKCSDL();
		            PreparedStatement statement = c.prepareStatement(SQL);
		            statement.setString(1, Thang.getText());
		            table.setModel(new DefaultTableModel());
		            ResultSet rs = statement.executeQuery();
		            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            int cols = rsmd.getColumnCount();
		            String[] colname = new String[cols];
		            for (int i = 0; i < cols; i++)
		                colname[i] = rsmd.getColumnName(i + 1);
		            model.setColumnIdentifiers(colname);
		            String Mã_hàng_hóa, Tên_hàng_hóa, Số_lượng, Tiền;
		            while (rs.next()) {
		                Mã_hàng_hóa = rs.getString(1);
		                Tên_hàng_hóa = rs.getString(2);
		                Số_lượng = rs.getString(3);
		                Tiền = rs.getString(4);

		                String[] row = { Mã_hàng_hóa, Tên_hàng_hóa, Số_lượng, Tiền };
		                model.addRow(row);
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		JButton btnNewButton_3 = new JButton("Năm");
		bcbht.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String SQL = "select [Mã hàng hóa], [Tên hàng hóa],[Số lượng], [Tiền]  from bao_cao_ban_hang_theo_thang \r\n"
		        		+ "where thang = ? ; ";

		        try {
		            ConnectURL c = new ConnectURL();
		            c.ConnectToTKCSDL();
		            PreparedStatement statement = c.prepareStatement(SQL);
		            statement.setString(1, Thang.getText());
		            table.setModel(new DefaultTableModel());
		            ResultSet rs = statement.executeQuery();
		            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            int cols = rsmd.getColumnCount();
		            String[] colname = new String[cols];
		            for (int i = 0; i < cols; i++)
		                colname[i] = rsmd.getColumnName(i + 1);
		            model.setColumnIdentifiers(colname);
		            String Mã_hàng_hóa, Tên_hàng_hóa, Số_lượng, Tiền;
		            while (rs.next()) {
		                Mã_hàng_hóa = rs.getString(1);
		                Tên_hàng_hóa = rs.getString(2);
		                Số_lượng = rs.getString(3);
		                Tiền = rs.getString(4);

		                String[] row = { Mã_hàng_hóa, Tên_hàng_hóa, Số_lượng, Tiền };
		                model.addRow(row);
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(510, 91, 150, 22);
		getContentPane().add(menuBar_1);
		
		JMenu dt = new JMenu("Doanh thu");
		dt.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar_1.add(dt);
		
		
		JButton btnNewButton = new JButton("Ngày ");
		dt.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        

		        try  {
		       
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select * from doanh_thu_theo_ngay ");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Ngay, DoanhThu ;
					    while(rs.next()) {
					    	Ngay = rs.getString(1);
					    	DoanhThu=rs.getString(2);
					    	
					    	
					    	String[] row= {Ngay, DoanhThu };
					    	model.addRow(row);}
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		    
		});
		
		JButton btnNewButton_4 = new JButton("Tháng");
		dt.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        

		        try  {
		       
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select * from doanh_thu_theo_thang ");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Thang, DoanhThu ;
					    while(rs.next()) {
					    	Thang = rs.getString(1);
					    	DoanhThu=rs.getString(2);
					    	
					    	
					    	String[] row= {Thang, DoanhThu };
					    	model.addRow(row);}
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		    
		});
		
		
		JButton btnNewButton_5 = new JButton("Năm");
		dt.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        

		        try  {
		       
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select *from doanh_thu_theo_nam ");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Nam, DoanhThu ;
					    while(rs.next()) {
					    	Nam = rs.getString(1);
					    	DoanhThu=rs.getString(2);
					    	
					    	
					    	String[] row= {Nam, DoanhThu };
					    	model.addRow(row);}
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		    
		});
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(848, 91, 101, 22);
		getContentPane().add(menuBar_2);
		
		JMenu mnNewMenu = new JMenu("Khách hàng");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar_2.add(mnNewMenu);
		
		JButton btnNewButton_6 = new JButton("Sắp xếp");
		mnNewMenu.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        

		        try  {
		       
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select *from khachhanglaunam ");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Ma_Khach_Hang, Ten_Khach_Hang, Chi_Tra ;
					    while(rs.next()) {
					    	Ma_Khach_Hang = rs.getString(1);
					    	Ten_Khach_Hang=rs.getString(2);
					    	Chi_Tra=rs.getString(3);
					    	
					    	String[] row= { Ma_Khach_Hang, Ten_Khach_Hang, Chi_Tra};
					    	model.addRow(row);}
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		    
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 149, 943, 413);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                thong_ke statisticFrame = new thong_ke();
                statisticFrame.createAndShowGUI();
                statisticFrame.setSize(1164, 607);
            }
        });
    }

    public void createAndShowGUI() {
        setTitle("Thống kê");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setVisible(true);
    }
}
