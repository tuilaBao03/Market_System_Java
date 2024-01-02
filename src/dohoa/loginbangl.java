package dohoa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.border.LineBorder;


import javax.swing.JPasswordField;

public class loginbangl extends JFrame {

	int failed =0;
	private JPanel contentPane;
	private JTextField tk;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginbangl frame = new loginbangl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginbangl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
	                

	                // Check if the password is correct
					 String tk_ = tk.getText();
		             String mk_ = passwordField.getText();
		             System.out.println(tk_);
	                 System.out.println(mk_);
	                	        
	                if (tk_.equals("1111") && mk_.equals("1111")) {
	                	System.out.println(tk_);
	                	System.out.println(mk_);
	                    // Open the menu
	                    csbangluong.main(new String[] {});
	                    dispose(); // Close the login window
	                   
	                } else {
	                	failed ++;
	                	if(failed >=3) {
	                		dangnhapsai.main(new String[]{});
	                		dispose();
	                	}
	                	else {
	                		SaiMKduoi3lan.main(new String[] {});
	                	}
	                    // Show an error message or take appropriate action
	                    
	                    
	                }
	                
	              
				
			}
				

				
		});
		btnNewButton.setFont(new Font("Be Vietnam Pro", Font.BOLD, 12));
		btnNewButton.setBounds(128, 259, 78, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tài Khoản  :");
		lblNewLabel.setFont(new Font("Be Vietnam Pro", Font.BOLD, 14));
		lblNewLabel.setBounds(117, 156, 108, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu   :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Be Vietnam Pro", Font.BOLD, 14));
		lblNewLabel_1.setBounds(117, 201, 89, 31);
		contentPane.add(lblNewLabel_1);
		
		tk = new JTextField();
		tk.setBounds(253, 165, 96, 19);
		contentPane.add(tk);
		tk.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Chỉnh sửa bảng lương");
		lblNewLabel_2.setBounds(20, 34, 406, 37);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnThot = new JButton("THOÁT");
		btnThot.setBackground(new Color(255, 255, 255));
		btnThot.setFont(new Font("Be Vietnam Pro", Font.BOLD, 12));
		btnThot.setBounds(253, 259, 78, 35);
		contentPane.add(btnThot);
		
		JLabel lblNewLabel_3 = new JLabel("Chức năng này chỉ dành cho chủ sở hữu ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(61, 94, 326, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Quên mật khẩu");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lienhe.main(new String[] {});
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton_1.setBounds(253, 237, 95, 12);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 208, 95, 19);
		contentPane.add(passwordField);
		btnThot.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				BangLuong.main(new String[] {});
                dispose();

               
			}
	});
		 this.setVisible(true);
		 
		

	}
}
