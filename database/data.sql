use javapro2;

create view luongnv as 
select top 1000 t.MaNhanVien as [Mã Nhân Viên], n.TenNhanVien as [Tên Nhân Viên], t.NgayCong*l.luongTrenGio  as luong  from thamgia as t inner join luong as l on t.MaCa = l.MaCa inner join NhanVien as n on t.MaNhanVien = n.MaNhanVien
group by t.MaNhanVien, n.TenNhanVien, t.NgayCong, l.luongTrenGio

create VIEW doanh_thu_tung_mat_hang_ko_tinh_nhap AS
SELECT top 10 ct.MaHangHoa AS mahanghoa, h.TenHangHoa, SUM(ct.SoLuong) AS SoLuong, SUM(ct.SoLuong * h.GiaBan) AS Tongban
FROM CT_HoaDonBan AS ct
INNER JOIN HangHoa AS h ON ct.MaHangHoa = h.MaHangHoa
GROUP BY ct.MaHangHoa, h.TenHangHoa
order by soluong desc; 


select * from doanh_thu_tung_mat_hang_ko_tinh_nhap;

create VIEW hang_hoa_nhap_nhieu AS
SELECT top 10 ct.mahanghoa  as mahanghoa, hh.TenHangHoa as tenhanghoa, sum(ct.SoLuong) as soluong, sum(ct.soluong * hh.GiaGoc) as tongtien  
from CT_HoaDonNhap as ct 
inner join HangHoa as hh on ct.MaHangHoa = hh.MaHangHoa
group by ct.mahanghoa, TenHangHoa
order by soluong desc; 

select * from hang_hoa_nhap_nhieu





-- báo cáo bán hàng theo ngày tháng năm 

-- ngày

create view bao_cao_ban_hang_theo_ngay as 
select top 1000  ct.MaHangHoa as [Mã hàng hóa] , hh.TenHangHoa as [Tên hàng hóa] , sum(ct.soluong) as [Số lượng], sum(ct.SoLuong)*hh.GiaBan as [Tiền], day(hdb.ThoiGian) as ngay  
from  hoadonban as hdb inner join
CT_HoaDonBan as ct on hdb.MaHoaDonBan = ct.MaHoaDonBan inner join HangHoa as hh on ct.MaHangHoa = hh.MaHangHoa

group by ct.MaHangHoa, hh.TenHangHoa, giaban, day(hdb.ThoiGian)  
order by [Tiền] desc  
  
-- tháng  

create view bao_cao_ban_hang_theo_thang  as 
select top 1000  ct.MaHangHoa as [Mã hàng hóa] , hh.TenHangHoa as [Tên hàng hóa] , sum(ct.soluong) as [Số lượng], sum(ct.SoLuong)*hh.GiaBan as [Tiền], month(hdb.ThoiGian) as thang   
from  hoadonban as hdb inner join
CT_HoaDonBan as ct on hdb.MaHoaDonBan = ct.MaHoaDonBan inner join HangHoa as hh on ct.MaHangHoa = hh.MaHangHoa
group by ct.MaHangHoa, hh.TenHangHoa, giaban, month(hdb.ThoiGian)  
order by [Tiền] desc  


-- năm 


create  view bao_cao_ban_hang_theo_nam  as 
select top 1000 ct.MaHangHoa as [Mã hàng hóa] , hh.TenHangHoa as [Tên hàng hóa] , sum(ct.soluong) as [Số lượng], sum(ct.SoLuong)*hh.GiaBan as [Tiền], year(hdb.ThoiGian) as nam    
from  hoadonban as hdb inner join
CT_HoaDonBan as ct on hdb.MaHoaDonBan = ct.MaHoaDonBan inner join HangHoa as hh on ct.MaHangHoa = hh.MaHangHoa
group by ct.MaHangHoa, hh.TenHangHoa, giaban, year(hdb.ThoiGian)  
order by [Tiền] desc  



---sql 

select [Mã hàng hóa], [Tên hàng hóa],[Số lượng], [Tiền]  from bao_cao_ban_hang_theo_ngay 
where ngay = 4  ; 

select [Mã hàng hóa], [Tên hàng hóa],[Số lượng], [Tiền]  from bao_cao_ban_hang_theo_thang  
where thang  = 7 ; 

select [Mã hàng hóa], [Tên hàng hóa],[Số lượng], [Tiền]  from bao_cao_ban_hang_theo_nam  
where nam = 2023  ; 




----------------------------------------------------------------------------------------------------------------------------------


--ngày 

create view xuatngay  as 
select day(hdb.ThoiGian) as Ngày , sum(tongtien) as [doanh thu] 
from hoadonban as hdb
group by day(hdb.ThoiGian) 

create view nhapngay  as 
select day(hdn.ThoiGian) as Ngày , sum(tongtien) as [doanh thu] 
from HoaDonNhap as hdn
group by day(hdn.ThoiGian)

create  view doanh_thu_theo_ngay as 
select top 1000 x.Ngày as ngay  , x.[doanh thu]-n.[doanh thu] as [Doanh thu] from nhapngay as n inner join xuatngay  as x on n.Ngày = x.Ngày
order by x.Ngày asc 



____________________________________________________________________________________


--tháng


create view xuatthang  as 
select month(hdb.ThoiGian) as thang  , sum(tongtien) as [doanh thu] 
from hoadonban as hdb
group by month(hdb.ThoiGian) 

create view nhapthang  as 
select month(hdn.ThoiGian) as thang  , sum(tongtien) as [doanh thu] 
from HoaDonNhap as hdn
group by month(hdn.ThoiGian)

create view doanh_thu_theo_thang as 
select top 1000 x.thang as thang , x.[doanh thu]-n.[doanh thu] as [Doanh thu] from nhapthang as n inner join xuatthang  as x on n.thang = x.thang
order by x.thang asc 



-----------------------------------------------------------------------------------------------

--năm 

create view xuatnam  as 
select year(hdb.ThoiGian) as nam  , sum(tongtien) as [doanh thu] 
from hoadonban as hdb
group by year(hdb.ThoiGian) 

create view nhapnam  as 
select year(hdn.ThoiGian) as nam   , sum(tongtien) as [doanh thu] 
from HoaDonNhap as hdn
group by year(hdn.ThoiGian)

create view doanh_thu_theo_nam as 
select top 1000 x.nam as nam , x.[doanh thu]-n.[doanh thu] as [Doanh thu] from nhapnam  as n inner join xuatnam  as x on n.nam= x.nam
order by x.nam asc 


select * from doanh_thu_theo_ngay 
select * from doanh_thu_theo_thang 
select * from doanh_thu_theo_nam


-------------------------------------------------------------------------------------------------------------------------

create view khachhanglaunam as 
select top 1000 hdb.MaKhachHang as [Mã Khách Hàng], kh.TenKhachHang as [Tên Khách Hàng], sum(hdb.tongtien) as [Chi Trả]   from hoadonban as hdb  inner join KhachHang as kh on hdb.MaKhachHang = kh.MaKhachHang
group by kh.TenKhachHang, hdb.MaKhachHang
order by [Chi Trả] desc


select *from khachhanglaunam

