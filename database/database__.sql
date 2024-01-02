

create database javapro2;
use javapro2;
create table Luong (
 MaCa varchar(10) primary key,
 luongTrenGio int  
 );
create table KhachHang (
MaKhachHang varchar(10) primary key,
TenKhachHang varchar(30),
SoDienThoaiKhachHang char(10),
DiaChiKhachHang varchar(50),
GioiTinh varchar(6),
DiemTichLuy int
);

create table NhanVien (
 MaNhanVien varchar(10) primary key,
 TenNhanVien varchar(30),
 SoDienThoaiNhanVien char(10),
 DiachiNhanVien varchar(30),
 GioiTinh varchar(6),
 MatKhau char(8),
 TenDangNhap varchar(30)
 );

create table NhaCungCap (
 MaNhaCungCap varchar(10) primary key,
 TenNhaCungCap varchar(50),
 SoDienThoaiNhaCungCap char(10),
 NguoiDaiDien varchar(30),
 DiaChiNhaCungCap varchar(30)
 );

create table TheLoai (
 MaTheLoai varchar(10) primary key,
 TenTheLoai varchar(30),
 MoTa text
 );

create table ThamGia (
 MaNhanVien varchar(10),
 MaCa varchar(10),
 primary key (MaNhanVien, MaCa),
 GhiChu text,
 NgayCong int ,
 FOREIGN KEY(MaNhanVien) REFERENCES NhanVien(MaNhanVien),
 FOREIGN KEY(MaCa) REFERENCES Luong(MaCa)
 );

create table HangHoa (
 MaHangHoa varchar(10) primary key,
 TenHangHoa varchar(30),
 MaNhaCungCap varchar(10),
 MaTheLoai varchar(10),
 SoLuong int,
 GiaGoc int,
 GiaBan int,
 FOREIGN KEY(MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap),
 FOREIGN KEY(MaTheLoai) REFERENCES TheLoai(MaTheLoai)
 );

create table HoaDonNhap (
 MaNhaCungCap varchar(10),
 TenNhaCungCap varchar(30),
 MaHoaDonNhap varchar(10) primary key,
 MaNhanVien varchar(10),
 ThoiGian datetime ,
 TongTien float,
 FOREIGN KEY(MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap),
 FOREIGN KEY(MaNhanVien) REFERENCES NhanVien(MaNhanVien)
 );

create table CT_HoaDonNhap (
 MaHoaDonNhap varchar(10),
 MaHangHoa varchar(10),
 SoLuong int check (SoLuong >= 0),
 FOREIGN KEY(MaHoaDonNhap) REFERENCES HoaDonNhap(MaHoaDonNhap),
 FOREIGN KEY(MaHangHoa) REFERENCES HangHoa(MaHangHoa),
 primary key(MaHangHoa, MaHoaDonNhap)
 );

create table Hoadonban (
 MaHoaDonBan varchar(10) primary key,
 MaNhanVien varchar(10),
 MaKhachHang varchar(10),
 PhuongThucThanhToan char(30) ,
 ThoiGian datetime ,
 DiemTichLuyDung int,
 TongTien float,
 FOREIGN KEY(MaKhachHang) REFERENCES KhachHang(MaKhachHang),
 FOREIGN KEY(MaNhanVien) REFERENCES NhanVien(MaNhanVien)
 );


create table CT_HoaDonBan (
 MaHoaDonBan varchar(10),
 MaHangHoa varchar(10),
 SoLuong int check (SoLuong >= 0),
 FOREIGN KEY(MaHoaDonBan) REFERENCES HoaDonBan(MaHoaDonBan),
 FOREIGN KEY(MaHangHoa) REFERENCES HangHoa(MaHangHoa),
 primary key(MaHangHoa, MaHoaDonBan)
 );











