package dohoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class lienhe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lienhe frame = new lienhe();
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
	public lienhe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liên hệ với chúng thôi qua số điện thoại 0888379199");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 10, 760, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblHocGmail = new JLabel("Hoặc Gmail : hagiabao980@gmail.com");
		lblHocGmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblHocGmail.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHocGmail.setBounds(118, 72, 760, 40);
		contentPane.add(lblHocGmail);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(new String[] {});
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(880, 118, 85, 21);
		contentPane.add(btnNewButton);
	}

}
