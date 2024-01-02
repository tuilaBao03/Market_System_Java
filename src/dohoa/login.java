package dohoa;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import cong.*;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import javax.swing.JPasswordField;

public class login extends JFrame {
	int failed =0;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 365);
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
					 String username = textField.getText();
		                String password = textField_1.getText();
	                	ConnectURL c = new ConnectURL();
	                	c.ConnectToTKCSDL();        
	                if (c.login(username, password)== true) {
	                    // Open the menu
	                    Menu.main(new String[]{});
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
		
		textField = new JTextField();
		textField.setBounds(253, 165, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng Nhập :");
		lblNewLabel_2.setBounds(141, 79, 189, 37);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnThot = new JButton("THOÁT");
		btnThot.setBackground(new Color(255, 255, 255));
		btnThot.setFont(new Font("Be Vietnam Pro", Font.BOLD, 12));
		btnThot.setBounds(253, 259, 78, 35);
		contentPane.add(btnThot);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(253, 208, 96, 19);
		contentPane.add(textField_1);
		btnThot.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
                dispose();

               
			}
	});
		 this.setVisible(true);
		 
		
	}
}
