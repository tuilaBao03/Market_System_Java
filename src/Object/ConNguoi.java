package Object;



public abstract class ConNguoi {
	
	private String Ma,Ten,SoDienThoai,DiaChi,GioiTinh;

	public String getMa() {
		return Ma;
	}

	public void setMa(String ma) {
		Ma = ma;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public void setMa() {
	}

	public String getTen() {
		return Ten;
	}

	public void setTen() {
	
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai() {
		
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi() {
		
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh() {
	
	}

	public ConNguoi(String ma, String ten, String soDienThoai, String diaChi, String gioiTinh) {
		super();
		Ma = ma;
		Ten = ten;
		SoDienThoai = soDienThoai;
		DiaChi = diaChi;
		GioiTinh = gioiTinh;
	}
	public ConNguoi(String ten, String soDienThoai, String diaChi, String gioiTinh) {
		super();
		
		Ten = ten;
		SoDienThoai = soDienThoai;
		DiaChi = diaChi;
		GioiTinh = gioiTinh;
	}

	public ConNguoi() {
		super();
		
	}

	

	

	
	
	

}