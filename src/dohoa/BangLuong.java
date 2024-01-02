package dohoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cong.ConnectURL;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BangLuong extends JFrame {

	private JPanel contentPane;
	private JTable l;
	private JTable bl;
	private JTextField tk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangLuong frame = new BangLuong();
					frame.setVisible(true);
					frame.setSize(988, 463);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BangLuong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 664, 400);
		contentPane.add(scrollPane);
		
		l = new JTable();
		scrollPane.setViewportView(l);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(663, 77, 316, 400);
		contentPane.add(scrollPane_1);
		
		bl = new JTable();
		scrollPane_1.setViewportView(bl);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 979, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tk = new JTextField();
		tk.setBounds(159, 13, 275, 39);
		panel.add(tk);
		tk.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 16, 121, 36);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 l.setModel(new DefaultTableModel());
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 String SQL = "select * from luongnv where [Mã Nhân Viên] = ? ";
					 PreparedStatement pst = conn.prepareStatement(SQL);
					 pst.setString(1,tk.getText());
					 
					 ResultSet rs = pst.executeQuery();
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) l.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     
					     String mnv,tnv,l;
						    while(rs.next()) {
						    	mnv = rs.getString(1);
						    	tnv=rs.getString(2);
						    	l=rs.getString(3);
						    	
						    	String[] row= {mnv,tnv,l};
						    	model.addRow(row);
						    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(461, 14, 85, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 ConnectURL conn = new  ConnectURL();
					 conn.ConnectToTKCSDL();
					 ResultSet rs = conn.Query("select * from luongnv");
					    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    DefaultTableModel model = (DefaultTableModel) l.getModel();
					     int cols = rsmd.getColumnCount();
					     String[] colname=new String[cols];
					     for(int i=0;i<cols;i++)
					    	 colname[i]=rsmd.getColumnName(i+1);
					     model.setColumnIdentifiers(colname);
					     String mnv,tnv,l;
					    while(rs.next()) {
					    	mnv = rs.getString(1);
					    	tnv=rs.getString(2);
					    	l=rs.getString(3);
					    	
					    	String[] row= {mnv,tnv,l};
					    	model.addRow(row);
					    }
					    ResultSet rs2 = conn.Query("select * from luong");
					    java.sql.ResultSetMetaData rsmd2 = rs2.getMetaData();
					    DefaultTableModel model2 = (DefaultTableModel) bl.getModel();
					     int cols2 = rsmd2.getColumnCount();
					     String[] colname2=new String[cols2];
					     for(int i=0;i<cols2;i++)
					    	 colname2[i]=rsmd2.getColumnName(i+1);
					     model2.setColumnIdentifiers(colname2);
					     String maca,luongtheoh;
					    while(rs2.next()) {
					    	maca = rs2.getString(1);
					    	luongtheoh=rs2.getString(2);
					    	
					    	
					    	String[] row= {maca,luongtheoh};
					    	model2.addRow(row);
					    }
					    
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(717, 14, 126, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Thoát");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[] {});
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(853, 14, 126, 40);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Chỉnh sửa");
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginbangl.main(new String [] {});
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(584, 14, 126, 40);
		panel.add(btnNewButton_1_2);
	}
}
