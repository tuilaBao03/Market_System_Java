package dohoa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableModel;


import Object.ChiTietHoaDonBan;
import Object.Hanghoa;
import Object.Hanghoalucban;
import Object.HoaDonBan;
import Object.Khachhang;
import Object.NhanVien;

import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ban_hang extends JFrame {

	 private JComboBox<String> tt; 
	private JTextField msp;
	private JTextField sl;
	private JTextField mkh;
	private JTextField dtl;
	private String phuongthucthanhtoan;

	private JTable hoadonban;

	public String getPhuongthucthanhtoan() {
		return phuongthucthanhtoan;
	}
	

	public void setPhuongthucthanhtoan(String phuongthucthanhtoan) {
		this.phuongthucthanhtoan = phuongthucthanhtoan;
	}


	public ban_hang(String phuongthucthanhtoan) throws HeadlessException {
		super();
		this.phuongthucthanhtoan = phuongthucthanhtoan;
	}


	public ban_hang() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1287, 50);
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
		btnngXut.setBounds(929, 11, 129, 29);
		panel_1.add(btnngXut);
		
		
		JLabel lblNhnVin = new JLabel("BÁN HÀNG");
		lblNhnVin.setForeground(new Color(255, 0, 0));
		lblNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNhnVin.setBounds(10, 10, 184, 29);
		panel_1.add(lblNhnVin);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[] {});
				dispose();
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThot.setBackground(new Color(255, 255, 255));
		btnThot.setBounds(1116, 11, 129, 29);
		panel_1.add(btnThot);
		
		

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 49, 191, 663);
		getContentPane().add(panel);
		
		JButton productButton = new JButton("Bán Hàng");
		productButton.setForeground(Color.RED);
		productButton.setBackground(new Color(255, 255, 255));
		productButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton.setBounds(10, 370, 171, 80);
		panel.add(productButton);
		
		JButton supplierButton = new JButton("Nhà cung cấp");
		supplierButton.setBackground(new Color(255, 255, 255));
		supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		supplierButton.setBounds(10, 190, 171, 80);
		panel.add(supplierButton);
		
		JButton customerButton = new JButton("Khách hàng");
		customerButton.setBackground(new Color(255, 255, 255));
		customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		customerButton.setBounds(10, 100, 171, 80);
		panel.add(customerButton);
		
		JButton employeeButton = new JButton("Nhân viên");
		employeeButton.setBackground(new Color(255, 255, 255));
		employeeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		employeeButton.setBounds(10, 10, 171, 80);
		panel.add(employeeButton);
		
		JButton productButton_1 = new JButton("Hàng hoá");
		productButton_1.setBackground(new Color(255, 255, 255));
		productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton_1.setBounds(10, 280, 171, 80);
		panel.add(productButton_1);
		
		JButton statisticButton = new JButton("Thống kê");
		statisticButton.setBackground(new Color(255, 255, 255));
		statisticButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		statisticButton.setBounds(10, 546, 171, 80);
		panel.add(statisticButton);
		
		JButton btnNhpHng = new JButton("Nhập Hàng");
		btnNhpHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphang.main(new String[] {});
				dispose();
			}
		});
		btnNhpHng.setForeground(new Color(0, 0, 0));
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNhpHng.setBackground(new Color(255, 255, 255));
		btnNhpHng.setBounds(10, 460, 171, 80);
		panel.add(btnNhpHng);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(190, 49, 741, 663);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 29, 204, 47);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số lượng         :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 87, 186, 51);
		panel_2.add(lblNewLabel_1);
		
		msp = new JTextField();
		msp.setBounds(175, 41, 237, 27);
		panel_2.add(msp);
		msp.setColumns(10);
		
		sl = new JTextField();
		sl.setColumns(10);
		sl.setBounds(175, 99, 237, 27);
		panel_2.add(sl);
		
		
		
		// khởi tạo một arraylist hanghoalucban để lưu các giá trị khi nhập sản phẩm vào hóa đơn
		ArrayList<Hanghoalucban> hh = new ArrayList<Hanghoalucban>();
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.RED);
		panel_3.setBounds(928, 49, 359, 663);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		JLabel lblTngTinHng = new JLabel("Tổng Tiền Hàng :");
		lblTngTinHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngTinHng.setBounds(10, 342, 145, 33);
		panel_3.add(lblTngTinHng);
		
		JLabel lblKhchPhiTr = new JLabel("Khách Phải Trả :");
		lblKhchPhiTr.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKhchPhiTr.setBounds(10, 413, 145, 33);
		panel_3.add(lblKhchPhiTr);
		
		JLabel label3 = new JLabel("Điểm tích lũy của khách:");
		label3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label3.setBounds(10, 209, 176, 33);
		panel_3.add(label3);
		
		JLabel TongtienhangPN = new JLabel("");
		TongtienhangPN.setForeground(new Color(255, 0, 0));
		TongtienhangPN.setFont(new Font("Tahoma", Font.BOLD, 25));
		TongtienhangPN.setBounds(165, 342, 161, 33);
		panel_3.add(TongtienhangPN);
		JLabel KhachphaitraPN = new JLabel("");
		KhachphaitraPN.setForeground(Color.RED);
		KhachphaitraPN.setFont(new Font("Tahoma", Font.BOLD, 25));
		KhachphaitraPN.setBounds(165, 413, 161, 33);
		panel_3.add(KhachphaitraPN);
		JLabel diemtichluyPN = new JLabel("");
		diemtichluyPN.setForeground(new Color(0, 0, 0));
		diemtichluyPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		diemtichluyPN.setBounds(211, 209, 118, 33);
		panel_3.add(diemtichluyPN);
		JButton BTtim = new JButton("Tìm");
		BTtim.setFont(new Font("Tahoma", Font.BOLD, 10));
		BTtim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khachhang a=new Khachhang();
				if(mkh.getText().length()==0) {
					SPkhongtontai.main(new String[] {});
					return;
				}else {
					a=a.searchDataByMaKH(mkh.getText());
					if(a.getMa().length()==0) {
						return;
					}
					diemtichluyPN.setText( String.valueOf(a.getDiemtichluy()));
					
				}
	
			}
		});
		BTtim.setBounds(281, 65, 69, 23);
		panel_3.add(BTtim);
		// nút thêm và hành động khi nhấn vào
		JButton btnNewButton_1 = new JButton("Thêm ");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
		    	
		    	
		    	Hanghoa a= new Hanghoa();
		    	
		    	int soluong;
		    	if(sl.getText().length()==0) {
				        	soluong=1;
				}
		    	else {
		    		soluong=Integer.parseInt(sl.getText());
		    	}

		    		if(msp.getText().length()==0) {
		    		SPkhongtontai.main(new String [] {});
		    		a=a.searchDataByMaHH("HH1");
		    		}
		    		else {
		    			a=a.searchDataByMaHH(msp.getText());
		    		}

		    		boolean condition = true;
		    		Hanghoalucban m = new Hanghoalucban(a.getMahang(), a.getTenhanghoa(), soluong, a.getGiaban());

		    		for (int i = 0; i < hh.size(); i++) {
		    		    if (m.getMasanpham().equals(hh.get(i).getMasanpham())) {
		    		        soluong += hh.get(i).getSoluong();
		    		        m=new Hanghoalucban(a.getMahang(), a.getTenhanghoa(), soluong, a.getGiaban());
		    		        hh.set(i, m);
		    		        condition = false;
		    		        break;
		    		    }
		    		}

		    		if (condition) {
		    		    hh.add(m);
		    		}

		    	hoadonban.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) hoadonban.getModel(); 
		        String column[] = { "Mã sản phẩm", "Tên sản phẩm", "số lượng", "giá bán", "thành tiền" };
		        model.setColumnIdentifiers(column);
		        String MaHang,TenHang,SoLuong,GiaBan,ThanhTien ;
		     
		       double tongtienhang=0;
		       double khachphaitra=0;
		        
		        // hiển thị bảng ra ngoài màn hình
		        for(int i=0;i<hh.size();i++) {
		        	MaHang=hh.get(i).getMasanpham();
			        TenHang=hh.get(i).getTensanpham();
			        GiaBan=String.valueOf(hh.get(i).getGiaban());
			        SoLuong=String.valueOf(hh.get(i).getSoluong());
			        ThanhTien=String.valueOf((double)hh.get(i).getSoluong()*hh.get(i).getGiaban());
			        String[] row= {MaHang,TenHang,SoLuong,GiaBan,ThanhTien };
			    	model.addRow(row);
			    	tongtienhang=tongtienhang+hh.get(i).getThanhtien();
		        }
		        String tt=String.valueOf(tongtienhang);
		        TongtienhangPN.setText(tt);
		        if(mkh.getText().length()==0) {
		        	KhachphaitraPN.setText(tt);
		        }
		        else {
		        	double a1=Double.parseDouble(dtl.getText());
		        	khachphaitra=tongtienhang-a1*100;
		        	KhachphaitraPN.setText(String.valueOf(khachphaitra));
		        }

		      }
			
     
		});
		
		// nút xóa và hành động khi bấm vào
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(436, 71, 111, 27);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Xóa");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hh.removeAll(hh);
				hoadonban.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) hoadonban.getModel(); 
		        String column[] = { "Mã sản phẩm", "Tên sản phẩm", "số lượng", "giá bán", "thành tiền" };
		        model.setColumnIdentifiers(column);
		        String MaHang,TenHang,SoLuong,GiaBan,ThanhTien;
		        for(int i=0;i<hh.size();i++) {
		        	MaHang=hh.get(i).getMasanpham();
			        TenHang=hh.get(i).getTensanpham();
			        GiaBan=String.valueOf(hh.get(i).getGiaban());
			        SoLuong=String.valueOf(hh.get(i).getSoluong());
			        ThanhTien=String.valueOf((double) hh.get(i).getSoluong() * hh.get(i).getGiaban());
			        String[] row= {MaHang,TenHang,SoLuong,GiaBan,ThanhTien };
			    	model.addRow(row);
		        }
			}
		});
		
		
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(577, 71, 111, 27);
		panel_2.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 148, 690, 473);
		panel_2.add(scrollPane);
		
		hoadonban = new JTable();
		hoadonban.setColumnSelectionAllowed(true);
		hoadonban.setCellSelectionEnabled(true);
		scrollPane.setViewportView(hoadonban);
		
	
		

		
		JLabel lblNewLabel_2 = new JLabel("Hóa đơn");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(123, 5, 145, 43);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng      : ");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMKhchHng.setBounds(10, 59, 158, 33);
		panel_3.add(lblMKhchHng);
		
		mkh = new JTextField();
		mkh.setColumns(10);
		mkh.setBounds(168, 61, 104, 31);
		panel_3.add(mkh);
		
		JLabel lblimTchLy = new JLabel("Điểm tích lũy dùng :");
		lblimTchLy.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblimTchLy.setBounds(10, 126, 145, 33);
		panel_3.add(lblimTchLy);
		
		dtl = new JTextField();
		dtl.setColumns(10);
		dtl.setBounds(168, 128, 100, 31);
		panel_3.add(dtl);

		
	

		
		JLabel lblNhnVinBn = new JLabel("Mã nhân viên bán: ");
		lblNhnVinBn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNhnVinBn.setBounds(10, 281, 145, 33);
		panel_3.add(lblNhnVinBn);
		
		JTextField manv= new JTextField();
		manv.setColumns(10);
		manv.setBounds(168, 283, 162, 31);
		panel_3.add(manv);

	    JLabel lblThanhTon = new JLabel("Phương thức thanh toán:");
        lblThanhTon.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblThanhTon.setBounds(10, 493, 186, 22);
        panel_3.add(lblThanhTon);

        tt = new JComboBox<>();
        tt.setModel(new DefaultComboBoxModel<>(new String[]{"Credit Card", "Cash"}));
        tt.setBounds(205, 495, 145, 21);
        panel_3.add(tt);
		
// các hành động khi sử bấm vào nút thanh toán.	


					JButton btnNewButton_2 = new JButton("Thanh Toán");
					btnNewButton_2.setBounds(123, 547, 126, 47);
					panel_3.add(btnNewButton_2);
					btnNewButton_2.setBackground(new Color(255, 255, 255));
					btnNewButton_2.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        int diemtichluydung;

					        if (dtl.getText().length() == 0) {
					            diemtichluydung = 0;
					        } else {
					            diemtichluydung = Integer.parseInt(dtl.getText());
					        }

					        Khachhang kh = new Khachhang();
					        NhanVien nv = new NhanVien();

					        if (mkh.getText().length() == 0) {
					            SPkhongtontai.main(new String[] {});
					            kh = kh.searchDataByMaKH("KH0");
					            diemtichluydung = 0;
					        } else {
					        	 kh = kh.searchDataByMaKH(mkh.getText());
					        	 if (kh.getMa().length()==0) {
						                SPkhongtontai.main(new String[] {});
						                kh = kh.searchDataByMaKH("KH0");
						            }
					        }

					        if (manv.getText().length() == 0) {
					            SPkhongtontai.main(new String[] {});
					            nv = nv.searchDataByMaNV("NV1");
					        } else {
					            nv = nv.searchDataByMaNV(manv.getText());
					            if (nv.getMa().length()==0) {
					                SPkhongtontai.main(new String[] {});
					                nv = nv.searchDataByMaNV("NV1");
					            }
					        }
					        setPhuongthucthanhtoan("Credit Card");
		  
					        
					        tt.addActionListener(new ActionListener() {
			                    @Override
			                    public void actionPerformed(ActionEvent e) {
			                        // Get the selected item from the JComboBox

			                    		String selectedOption = (String) tt.getSelectedItem();
			                    		if(selectedOption.equals("Credit Card")) {
				                        	setPhuongthucthanhtoan("Credit Card");	
				                        
				                        }
				                        if(selectedOption.equals("Cash")){
				                        	setPhuongthucthanhtoan("Cash");
				                     
				                        }

			                    }
			                });
			       
					       
					        		
				HoaDonBan hdb=new HoaDonBan(  getPhuongthucthanhtoan(), nv, kh);
				
				hdb.CreateBill(diemtichluydung);
				for(int i=0;i<hh.size();i++) {
					ChiTietHoaDonBan ct=new ChiTietHoaDonBan(hh.get(i), hh.get(i).getSoluong(), hdb);
					ct.createDetailsBill();
				}
				hh.removeAll(hh);
				
				// hiển thị lại hóa đơn mới
				hoadonban.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) hoadonban.getModel(); 
		        String column[] = { "Mã sản phẩm", "Tên sản phẩm", "số lượng", "giá bán", "thành tiền" };
		        model.setColumnIdentifiers(column);
		        String MaHang,TenHang,SoLuong,GiaBan,ThanhTien;
		        for(int i=0;i<hh.size();i++) {
		        	MaHang=hh.get(i).getMasanpham();
			        TenHang=hh.get(i).getTensanpham();
			        GiaBan=String.valueOf(hh.get(i).getGiaban());
			        SoLuong=String.valueOf(hh.get(i).getSoluong());
			        ThanhTien=String.valueOf((double) hh.get(i).getSoluong() * hh.get(i).getGiaban());
			        String[] row= {MaHang,TenHang,SoLuong,GiaBan,ThanhTien };
			    	model.addRow(row);
		        }
		        TongtienhangPN.setText(null);
		        KhachphaitraPN.setText(null);
		      
		        
			}
			
		});
	
		
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ban_hang frame = new ban_hang();
					frame.setVisible(true);
					frame.setSize(1302, 746);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public void createAndShowGUI() {
        setTitle("Bán Hàng");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
	}
}
