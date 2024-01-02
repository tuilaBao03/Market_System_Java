package dohoa;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void main(String[] args) {
    	
        // Tạo JFrame và đặt thuộc tính
        JFrame frame = new JFrame("Phần mềm quản lý cửa hàng tạp hoá");
        frame.setTitle("");
        frame.setFont(new Font("Dialog", Font.BOLD, 13));
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 255, 255));

        // Đặt layout manager của content pane thành Absolute Layout
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 50, 173, 505);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        JButton productButton = new JButton("Bán Hàng");
        productButton.setBackground(new Color(255, 255, 255));
        productButton.setBounds(10, 290, 150, 60);
        panel.add(productButton);
        productButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        JButton supplierButton = new JButton("Nhà cung cấp");
        supplierButton.setBackground(new Color(255, 255, 255));
        supplierButton.setBounds(10, 150, 150, 60);
        panel.add(supplierButton);
        supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        JButton customerButton = new JButton("Khách hàng");
        customerButton.setBackground(new Color(255, 255, 255));
        customerButton.setBounds(10, 80, 150, 60);
        panel.add(customerButton);
        customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        
                // Tạo các lựa chọn bằng JButton
                JButton employeeButton = new JButton("Nhân viên");
                employeeButton.setBackground(new Color(255, 255, 255));
                employeeButton.setBounds(10, 10, 150, 60);
                panel.add(employeeButton);
                employeeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
                
                JButton productButton_1 = new JButton("Hàng hoá");
                productButton_1.setBackground(new Color(255, 255, 255));
                productButton_1.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		hang_hoa.main(new String[] {});
                		frame.dispose();
                	}
                });
                productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
                productButton_1.setBounds(10, 220, 150, 60);
                panel.add(productButton_1);
                JButton statisticButton = new JButton("Thống kê");
                statisticButton.setBackground(new Color(255, 255, 255));
                statisticButton.setBounds(10, 430, 150, 60);
                panel.add(statisticButton);
                statisticButton.setFont(new Font("Tahoma", Font.BOLD, 17));
                
                JButton btnNhpHng = new JButton("Nhập Hàng");
                btnNhpHng.setBackground(new Color(255, 255, 255));
                btnNhpHng.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		nhaphang.main(new String[] {});
                		frame.dispose();
                	}
                });
                btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
                btnNhpHng.setBounds(10, 360, 150, 60);
                panel.add(btnNhpHng);
                
                        // Xử lý sự kiện khi nhấn vào nút Thống kê
                        statisticButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                thong_ke.main(new String[] {});
                                frame.dispose();
                                
                            }
                        });
                
                JPanel panel_1 = new JPanel();
                panel_1.setBounds(0, 0, 1322, 50);
                frame.getContentPane().add(panel_1);
                panel_1.setLayout(null);
                
                JButton btnngXut = new JButton("Đăng xuất");
                btnngXut.setBackground(new Color(255, 255, 255));
                btnngXut.setBounds(987, 11, 144, 29);
                panel_1.add(btnngXut);
                btnngXut.setFont(new Font("Tahoma", Font.BOLD, 17));
                
                JLabel lblNewLabel = new JLabel("Menu");
                lblNewLabel.setForeground(new Color(255, 0, 0));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
                lblNewLabel.setBounds(39, 10, 230, 29);
                panel_1.add(lblNewLabel);
                
                JButton btnLng = new JButton("Lương");
                btnLng.setBackground(new Color(255, 255, 255));
                btnLng.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		BangLuong.main(new String[] {});
                		frame.dispose();
                	}
                });
                btnLng.setFont(new Font("Tahoma", Font.BOLD, 17));
                btnLng.setBounds(851, 11, 126, 29);
                panel_1.add(btnLng);
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/image/sieuthi.jpg")));
                lblNewLabel_1.setBounds(183, 73, 599, 474);
                frame.getContentPane().add(lblNewLabel_1);
                
       
                btnngXut.addActionListener(new ActionListener() {
                	@Override
		    public void actionPerformed(ActionEvent e) {
                		login.main(new String[]{});
                		frame.dispose();
		    	                       // Đóng giao diện hiện tại (saiaMkorTdn)
		    }
		});
                

                // Xử lý sự kiện khi nhấn vào nút Nhân viên
                employeeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nhan_vien.main(new String[] {}); 
                        frame.dispose();
                        
                    }
                });
        
        
        // Xử lý sự kiện khi nhấn vào nút Khách hàng
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khach_hang.main(new String[] {});
                frame.dispose();
            }
        });
        
                // Xử lý sự kiện khi nhấn vào nút Nhà cung cấp
                supplierButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nha_cung_cap.main(new String[]{});
                        frame.dispose();
                    }
                });
        
                // Xử lý sự kiện khi nhấn vào nút Hàng hoá
                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ban_hang.main(new String[] {});
                        frame.dispose();
                        
                    }
                });

        // Đặt kích thước và hiển thị frame
        frame.setSize(1145, 592);
        frame.setVisible(true);
    }

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
