package dohoa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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



import Object.ChiTietHoaDonNhap;
import Object.Hanghoa;

import Object.Hanghoalucnhap;

import Object.HoaDonNhap;

import Object.NhaCungCap;
import Object.NhanVien;



@SuppressWarnings("serial")
public class nhaphang extends JFrame {
	private JTextField msp;
	private JTextField sl;
	private JTable hoadonnhap;
	private JTextField MNCC;

	public nhaphang() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1177, 50);
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
		btnngXut.setBounds(800, 10, 129, 29);
		panel_1.add(btnngXut);
		
		
		JLabel lblNhnVin = new JLabel("NHẬP HÀNG");
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
		btnThot.setBackground(Color.WHITE);
		btnThot.setBounds(949, 10, 129, 29);
		panel_1.add(btnThot);
		
		

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 49, 191, 497);
		getContentPane().add(panel);
		
		JButton productButton = new JButton("Bán Hàng");
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ban_hang.main(new String[] {});
				dispose();
			}
		});
		productButton.setForeground(new Color(0, 0, 0));
		productButton.setBackground(new Color(255, 255, 255));
		productButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton.setBounds(10, 280, 171, 60);
		panel.add(productButton);
		
		JButton supplierButton = new JButton("Nhà cung cấp");
		supplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha_cung_cap.main(new String[]{});
				dispose();
			}
		});
		supplierButton.setBackground(new Color(255, 255, 255));
		supplierButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		supplierButton.setBounds(10, 140, 171, 60);
		panel.add(supplierButton);
		
		JButton customerButton = new JButton("Khách hàng");
		customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khach_hang.main(new String[]{});
				dispose();
			}
		});
		customerButton.setBackground(new Color(255, 255, 255));
		customerButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		customerButton.setBounds(10, 70, 171, 60);
		panel.add(customerButton);
		
		JButton employeeButton = new JButton("Nhân viên");
		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhan_vien.main(new String[] {});
				dispose();
			}
		});
		employeeButton.setBackground(new Color(255, 255, 255));
		employeeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		employeeButton.setBounds(10, 0, 171, 60);
		panel.add(employeeButton);
		
		JButton productButton_1 = new JButton("Hàng hoá");
		productButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hang_hoa.main(new String[] {});
				dispose();
			}
		});
		productButton_1.setBackground(new Color(255, 255, 255));
		productButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		productButton_1.setBounds(10, 210, 171, 60);
		panel.add(productButton_1);
		
		JButton statisticButton = new JButton("Thống kê");
		statisticButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thong_ke.main(new String[] {});
				dispose();
			}
		});
		statisticButton.setBackground(new Color(255, 255, 255));
		statisticButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		statisticButton.setBounds(10, 420, 171, 60);
		panel.add(statisticButton);
		
		JButton btnNhpHng = new JButton("Nhập Hàng");
		btnNhpHng.setForeground(Color.RED);
		btnNhpHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNhpHng.setBackground(Color.WHITE);
		btnNhpHng.setBounds(10, 350, 171, 60);
		panel.add(btnNhpHng);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(191, 49, 622, 497);
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
		msp.setBounds(175, 41, 157, 27);
		panel_2.add(msp);
		msp.setColumns(10);
		
		sl = new JTextField();
		sl.setColumns(10);
		sl.setBounds(175, 99, 157, 27);
		panel_2.add(sl);
		
		
		
		// khởi tạo một arraylist hanghoalucban để lưu các giá trị khi nhập sản phẩm vào hóa đơn
		ArrayList<Hanghoalucnhap> hh = new ArrayList<Hanghoalucnhap>();
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.RED);
		panel_3.setBounds(817, 49, 359, 497);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		JLabel lblTngTinHng = new JLabel("Tổng Tiền Hàng :");
		lblTngTinHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngTinHng.setBounds(10, 267, 145, 33);
		panel_3.add(lblTngTinHng);
		
		JLabel lblKhchPhiTr = new JLabel("Cửa hàng Phải Trả :");
		lblKhchPhiTr.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKhchPhiTr.setBounds(10, 335, 145, 33);
		panel_3.add(lblKhchPhiTr);
		
	
		
		JLabel TongtienhangPN = new JLabel("");
		TongtienhangPN.setForeground(new Color(255, 0, 0));
		TongtienhangPN.setFont(new Font("Tahoma", Font.BOLD, 25));
		TongtienhangPN.setBounds(165, 267, 161, 33);
		panel_3.add(TongtienhangPN);
		JLabel CHphaitraPN = new JLabel("");
		CHphaitraPN.setForeground(Color.RED);
		CHphaitraPN.setFont(new Font("Tahoma", Font.BOLD, 25));
		CHphaitraPN.setBounds(165, 335, 161, 33);
		panel_3.add(CHphaitraPN);
		MNCC = new JTextField();
		MNCC.setBounds(133, 63, 138, 26);
		panel_3.add(MNCC);
		MNCC.setColumns(10);
		
		JLabel lblTnNhCung = new JLabel("Tên Nhà Cung Cấp:");
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnNhCung.setBounds(10, 117, 158, 33);
		panel_3.add(lblTnNhCung);
		
		JLabel tennhacungcap = new JLabel("");
		tennhacungcap.setForeground(new Color(0, 0, 0));
		tennhacungcap.setFont(new Font("Tahoma", Font.BOLD, 15));
		tennhacungcap.setBounds(146, 117, 161, 33);
		panel_3.add(tennhacungcap);
		JButton BTtim = new JButton("Tìm");
		BTtim.setBackground(new Color(255, 255, 255));
		BTtim.setFont(new Font("Tahoma", Font.BOLD, 10));
		BTtim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhaCungCap a=new NhaCungCap();
				if(MNCC.getText().length()==0) {
					SPkhongtontai.main(new String[] {});
					return;
				}else {
					a=a.searchDataByMaNCC(MNCC.getText());
					if(a.getManhacungcap().length()==0) {
						return;
					}else {
						tennhacungcap.setText(a.getTennhacungcap());
					}
				
					
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
		    		Hanghoalucnhap m = new Hanghoalucnhap(a.getMahang(), a.getTenhanghoa(), soluong, a.getGiaban());

		    		for (int i = 0; i < hh.size(); i++) {
		    		    if (m.getMasanpham().equals(hh.get(i).getMasanpham())) {
		    		        soluong += hh.get(i).getSoluong();
		    		        m=new Hanghoalucnhap(a.getMahang(), a.getTenhanghoa(), soluong, a.getGiaban());
		    		        hh.set(i, m);
		    		        condition = false;
		    		        break;
		    		    }
		    		}

		    		if (condition) {
		    		    hh.add(m);
		    		}

		    	hoadonnhap.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) hoadonnhap.getModel(); 
		        String column[] = { "Mã sản phẩm", "Tên sản phẩm", "số lượng", "giá bán", "thành tiền" };
		        model.setColumnIdentifiers(column);
		        String MaHang,TenHang,SoLuong,GiaBan,ThanhTien ;
		     
		       double tongtienhang=0;
		     
		        
		        // hiển thị bảng ra ngoài màn hình
		        for(int i=0;i<hh.size();i++) {
		        	MaHang=hh.get(i).getMasanpham();
			        TenHang=hh.get(i).getTensanpham();
			        GiaBan=String.valueOf(hh.get(i).getGianhap());
			        SoLuong=String.valueOf(hh.get(i).getSoluong());
			        ThanhTien=String.valueOf((double)hh.get(i).getSoluong()*hh.get(i).getGianhap());
			        String[] row= {MaHang,TenHang,SoLuong,GiaBan,ThanhTien };
			    	model.addRow(row);
			    	tongtienhang=tongtienhang+hh.get(i).getThanhtien();
		        }
		        String tt=String.valueOf(tongtienhang);
		        TongtienhangPN.setText(tt);
		        CHphaitraPN.setText(tt);
		      
		      }
			
     
		});
		
		// nút xóa và hành động khi bấm vào
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(362, 70, 111, 27);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Xóa");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hh.removeAll(hh);
				hoadonnhap.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) hoadonnhap.getModel(); 
		        String column[] = { "Mã sản phẩm", "Tên sản phẩm", "số lượng", "giá bán", "thành tiền" };
		        model.setColumnIdentifiers(column);
		        String MaHang,TenHang,SoLuong,GiaBan,ThanhTien;
		        for(int i=0;i<hh.size();i++) {
		        	MaHang=hh.get(i).getMasanpham();
			        TenHang=hh.get(i).getTensanpham();
			        GiaBan=String.valueOf(hh.get(i).getGianhap());
			        SoLuong=String.valueOf(hh.get(i).getSoluong());
			        ThanhTien=String.valueOf((double) hh.get(i).getSoluong() * hh.get(i).getGianhap());
			        String[] row= {MaHang,TenHang,SoLuong,GiaBan,ThanhTien };
			    	model.addRow(row);
		        }
			}
		});
		
		
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(503, 70, 111, 27);
		panel_2.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 163, 585, 318);
		panel_2.add(scrollPane);
		
		hoadonnhap = new JTable();
		hoadonnhap.setColumnSelectionAllowed(true);
		hoadonnhap.setCellSelectionEnabled(true);
		scrollPane.setViewportView(hoadonnhap);
		
	
		

		
		JLabel lblNewLabel_2 = new JLabel("Hóa đơn");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(123, 5, 145, 43);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblMKhchHng = new JLabel("Mã Nhà Cung Cấp:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMKhchHng.setBounds(10, 59, 158, 33);
		panel_3.add(lblMKhchHng);

		
	

		
		JLabel lblNhnVinBn = new JLabel("Mã nhân viên nhập: ");
		lblNhnVinBn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNhnVinBn.setBounds(10, 173, 145, 33);
		panel_3.add(lblNhnVinBn);
		
		JTextField manv= new JTextField();
		manv.setColumns(10);
		manv.setBounds(164, 175, 162, 31);
		panel_3.add(manv);
		
// các hành động khi sử bấm vào nút thanh toán.	


					JButton btnNewButton_2 = new JButton("Thanh Toán");
					btnNewButton_2.setBounds(120, 433, 126, 47);
					panel_3.add(btnNewButton_2);
					btnNewButton_2.setBackground(new Color(255, 255, 255));
					btnNewButton_2.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					     

					        NhaCungCap ncc = new NhaCungCap();
					        NhanVien nv = new NhanVien();

					        if (MNCC.getText().length() == 0) {
					            SPkhongtontai.main(new String[] {});
					            ncc = ncc.searchDataByMaNCC("NCC1");
					         
					        } else {
					        	 ncc = ncc.searchDataByMaNCC(MNCC.getText());
					        	 if (ncc.getManhacungcap().length()==0) {
						                SPkhongtontai.main(new String[] {});
						                ncc = ncc.searchDataByMaNCC("NCC1");
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
  		
				HoaDonNhap hdn=new HoaDonNhap( nv, ncc);

				hdn.CreateBill();
				for(int i=0;i<hh.size();i++) {
					ChiTietHoaDonNhap ct=new ChiTietHoaDonNhap(hh.get(i), hh.get(i).getSoluong(), hdn);
					System.out.println(ct.toString());
					ct.createDetailsBill();
				}
				hh.removeAll(hh);
				
				// hiển thị lại hóa đơn mới
				hoadonnhap.setModel(new DefaultTableModel());
		        DefaultTableModel model = (DefaultTableModel) hoadonnhap.getModel(); 
		        String column[] = { "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập", "Thành tiền" };
		        model.setColumnIdentifiers(column);
		        String MaHang,TenHang,SoLuong,GiaNhap,ThanhTien;
		        for(int i=0;i<hh.size();i++) {
		        	MaHang=hh.get(i).getMasanpham();
			        TenHang=hh.get(i).getTensanpham();
			        GiaNhap=String.valueOf(hh.get(i).getGianhap());
			        SoLuong=String.valueOf(hh.get(i).getSoluong());
			        ThanhTien=String.valueOf((double) hh.get(i).getSoluong() * hh.get(i).getGianhap());
			        String[] row= {MaHang,TenHang,SoLuong,GiaNhap,ThanhTien };
			    	model.addRow(row);
		        }
		        TongtienhangPN.setText(null);
		        CHphaitraPN.setText(null);
		      
		        
			}
			
		});
	
		
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhaphang frame = new nhaphang();
					frame.setVisible(true);
					frame.setSize(1187,589);
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
        setTitle("Nhập Hàng");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setVisible(true);
	}
}

