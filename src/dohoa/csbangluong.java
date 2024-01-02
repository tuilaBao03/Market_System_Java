package dohoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cong.ConnectURL;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class csbangluong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField l;
	private JTextField ca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					csbangluong frame = new csbangluong();
					frame.setVisible(true);
					frame.setSize(997, 677);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public csbangluong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 61, 692, 516);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "INSERT INTO Luong (MaCa, luongTrenGio)\r\n"
						+ "				VALUES\r\n"
						+ "				    (?, ?);";
				
		        try  {
		        	ConnectURL c = new  ConnectURL();
					c.ConnectToTKCSDL();
		            PreparedStatement statement = c.prepareStatement(SQL);
					
		            statement.setString(1, ca.getText());
		            statement.setString(2, l.getText());
		            
		            
		            int rowsAffected = statement.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                System.out.println("Data inserted successfully.");
		            } else {
		                System.out.println("Failed to insert data.");
		            }
		            
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select * from luong");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Maca, luong ;
					    while(rs.next()) {
					    	Maca = rs.getString(1);
					    	luong=rs.getString(2);
					    	
					    	
					    	String[] row= {Maca, luong };
					    	model.addRow(row);}
		            
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		        
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(827, 267, 127, 39);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXa.setBackground(Color.WHITE);
		btnXa.setBounds(827, 322, 127, 39);
		contentPane.add(btnXa);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL =  " delete ThamGia where Maca = ?\r\n";
			    String SQL2=  "  delete Luong where MaCa = ? ";
				
		        try  {
		        	ConnectURL c = new  ConnectURL();
					c.ConnectToTKCSDL();
		            PreparedStatement statement = c.prepareStatement(SQL);
					statement.setString(1, ca.getText());
		            
		            
		            
		            
		            int rowsAffected = statement.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                System.out.println("Data deleted successfully.");
		            } else {
		                System.out.println("Failed to insert data.");
		            }
		            PreparedStatement statement2 = c.prepareStatement(SQL2);
					statement2.setString(1, ca.getText());

		            int rowsAffected2 = statement2.executeUpdate();
		            if (rowsAffected2 > 0) {
		                System.out.println("Data deleted successfully.");
		            } else {
		                System.out.println("Failed to insert data.");
		            }
		            
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select * from luong");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Maca, luong ;
					    while(rs.next()) {
					    	Maca = rs.getString(1);
					    	luong=rs.getString(2);
					    	
					    	
					    	String[] row= {Maca, luong };
					    	model.addRow(row);}
		            
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		        
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "update Luong set luongTrenGio =? "
						+ "where MaCa= ?";
						
						
				
		        try  {
		        	ConnectURL c = new  ConnectURL();
					c.ConnectToTKCSDL();
		            PreparedStatement statement = c.prepareStatement(SQL);
					
		            statement.setString(1, l.getText());
		            statement.setString(2, ca.getText());
		            
		            
		            int rowsAffected = statement.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                System.out.println("Data inserted successfully.");
		            } else {
		                System.out.println("Failed to insert data.");
		            }
		            
		            table.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select * from luong");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String Maca, luong ;
					    while(rs.next()) {
					    	Maca = rs.getString(1);
					    	luong=rs.getString(2);
					    	
					    	
					    	String[] row= {Maca, luong };
					    	model.addRow(row);}
		            
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		        
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(827, 382, 127, 39);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Thoát");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   BangLuong.main(new String[] {});
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(827, 536, 127, 39);
		contentPane.add(btnNewButton_1_1_1);
		
		
		
		JLabel lblNewLabel = new JLabel(" Ca : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(788, 105, 82, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblLng = new JLabel("Lương :");
		lblLng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLng.setBounds(788, 143, 82, 17);
		contentPane.add(lblLng);
		
		l = new JTextField();
		l.setBackground(new Color(255, 255, 255));
		l.setBounds(871, 144, 96, 19);
		contentPane.add(l);
		l.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				table.setModel(new DefaultTableModel());
				 ConnectURL conn = new  ConnectURL();
				 conn.ConnectToTKCSDL();
				 ResultSet rs = conn.Query("select * from luong");
				    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				    DefaultTableModel model = (DefaultTableModel) table.getModel();
				     int cols = rsmd.getColumnCount();
				     String[] colname=new String[cols];
				     for(int i=0;i<cols;i++)
				    	 colname[i]=rsmd.getColumnName(i+1);
				     model.setColumnIdentifiers(colname);
				     String Maca, luong ;
				    while(rs.next()) {
				    	Maca = rs.getString(1);
				    	luong=rs.getString(2);
				    	
				    	
				    	String[] row= {Maca, luong };
				    	model.addRow(row);}}
				catch(SQLException er) {
					er.getMessage();
				}
			}
		});
		btnNewButton_1.setBounds(827, 218, 127, 39);
		contentPane.add(btnNewButton_1);
		
		ca = new JTextField();
		ca.setBounds(871, 106, 96, 19);
		contentPane.add(ca);
		ca.setColumns(10);
	}
}
