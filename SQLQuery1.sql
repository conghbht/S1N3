create database DuAnXuong1
go

use DuAnXuong1
go

create table HeDieuHanh(
   ma int identity(1,1) not null,
   ten nvarchar(50) not null,
   trangThai bit not null,
   primary key(ma)
)
go  

create table Hang(
  ma int identity(1,1) not null,
  ten nvarchar(30) not null,
  maHeDieuHanh int not null,
  trangThai bit not null,
  primary key(ma),
  foreign key (maHeDieuHanh) references HeDieuHanh(ma)
)
go

create table MauSac(
   ma int identity(1,1) not null,
   ten nvarchar(30) not null,
   trangThai nvarchar(30) not null,
   primary key(ma)
)
go

create table BoNhoTrong(
   ma int identity(1,1) not null,
   loai nvarchar(30) not null,
   dungLuong nvarchar(30) not null,
   trangThai bit not null,
   primary key(ma)
)
go

create table ManHinh(
   ma int identity(1,1) not null,
   ten nvarchar(30) not null,
   trangThai bit not null,
   primary key(ma)
)
go

create table Camera(
   ma int identity(1,1) not null,
   ten nvarchar(30) not null,
   dungLuong nvarchar(30) not null,
   trangThai bit not null,
   primary key(ma)
)
go
 
create table RAM(
   ma int identity(1,1) not null,
   ten nvarchar(30) not null,
   dungLuong nvarchar(30) not null,
   trangThai bit not null,
   primary key(ma)
)
go

create table CPU(
   ma int identity(1,1) not null,
   ten nvarchar(50) not null,
   trangThai bit not null,
   primary key(ma)
)
go

create table XuatXu(
   ma int identity(1,1) not null,
   ten nvarchar(50) not null,
   trangThai bit not null,
   primary key(ma)
)
go

create table LoaiHang(
   ma int identity(1,1) not null,
   ten nvarchar(50) not null,
   trangThai bit not null,
   primary key(ma)
)
go



create table SanPham(
    maSanPham varchar(5) not null,
    tenSanPham nvarchar(30) not null,
    anhSanPham nvarchar(100) not null,
    moTa nvarchar(100) not null,
    maHDH int not null,
    maHang int not null,
    primary key(maSanPham),
    foreign key (maHang) references Hang(ma),
    foreign key (maHDH) references HeDieuHanh(ma)
)
go
-- on delete cascade

create table SanPhamChiTiet(
    maSanPhamChiTiet int identity not null,
    maSanPham varchar(5) not null,
    maMauSac int  not null,
    maManHinh int not null,
    maBoNhoTrong int not null,
    maCamera int not null,
    maRam int not null,
    maCPU int not null,
    maXuatXu int not null,
    maLoaiHang int not null,
    giaSanPham float not null,
    giaNhap float not null,
    ngayTao date not null,
    trangThai bit not null,
    primary key(maSanPhamChiTiet),
    foreign key (maSanPham) references SanPham(maSanPham),
    foreign key (maMauSac) references MauSac(ma) on delete cascade,
    foreign key (maManHinh) references ManHinh(ma) on delete cascade,
    foreign key (maCamera) references Camera(ma) on delete cascade,
    foreign key (maRam) references Ram(ma) on delete cascade,
    foreign key (maXuatXu) references XuatXu(ma) on delete cascade,
    foreign key (maLoaiHang) references LoaiHang(ma) on delete cascade,
    foreign key (maCPU) references CPU(ma) on delete cascade,
    foreign key (maBoNhoTrong) references BoNhoTrong(ma) on delete cascade,
)

create table NhanVien(
    maNhanVien varchar(5) not null,
    matKhau varchar(30) not null,
    tenNhanVien nvarchar(30) not null,
    anhNhanVien nvarchar(30) not null,
    soDienThoai varchar(30) not null,
    ngaySinh date not null,
    gioiTinh bit not null,
    diaChi nvarchar(30) not null,
    email varchar(30) not null,
    vaitro int not null,
    trangThai bit not null,
    ngayTao date not null,
    primary key(maNhanVien)
)
go

create table KhachHang(
    maKhachHang int identity not null,
    tenKhachHang nvarchar(30) not null,
    soDienThoai nvarchar(30) not null,
    ngaySinh date not null,
    diaChi nvarchar(30) not null,
    gioiTinh bit not null,
    email nvarchar(30) not null,
    ngayTao date not null,
    ghiChu  nvarchar(30) null,
    trangThai bit not null,
    primary key(maKhachHang)
)
go

create table Voucher(
    maVoucher varchar(5) not null,
    maNhanVien varchar(5) not null,
    tenChienDich nvarchar(30) not null,
    ngayBatDau date not null,
    ngayKetThuc date not null,
    primary key(maVoucher),
)
go

create table VoucherChiTiet(
    maVoucherChiTiet varchar(5) not null,
    maVoucher varchar(5) not null,
    soLuong int not null,
    giaTriGiam int not null,
    donViGiam nvarchar(30) not null,
    primary key( maVoucherChiTiet)
)
go

Create table HoaDon(
    maHoaDon int identity not null,
    maKhachHang int null,
    maNhanVien varchar(5) null,
    maVoucherChiTiet  varchar(5),
    tenNguoiNhan nvarchar(30) null,
    diaChi nvarchar(50) null,
    soDienThoai varchar(20) null,
    tienHang float null,
    phiShip float null,
    tongTien float null,
    giamGia int,
    donViGiam nvarchar(30),
    tongTienSauGiam float null,
    trangThai int null,
    loaiDonHang int null,
    ngayTao date null,
    primary key(maHoaDon),
    foreign key(maKhachHang) references KhachHang(maKhachHang),
    foreign key(maNhanVien) references NhanVien(maNhanVien),
    foreign key(maVoucherChiTiet) references VoucherChiTiet(maVoucherChiTiet)
)

create table Imei(
    maImei int identity not null,
    soImei varchar(9) not null,
    maSanPhamChiTiet int not null,
    trangThai bit not null,
    primary key(maImei),
    foreign key(maSanPhamChiTiet) references SanPhamChiTiet(maSanPhamChiTiet)
)

create table HoaDonChiTiet(
    maHoaDonChiTiet int identity,
    maHoaDon int null,
    maImei int null,
    donGia float null,
    giaGiam float null,
    soLuong int null,
    TongGia float null,
    trangThai int null,
    primary key(maHoaDonChiTiet),
    foreign key(maHoaDon) references HoaDon(maHoaDon),
    foreign key(maImei) references Imei(maImei)
)
go

create table KhuyenMai
(
    maKhuyenMai varchar(15) not null,
    tenChuongTrinh nvarchar(50) not null,
    ngayBatDau date not null,
    ngayKetThuc date not null,
    moTa nvarchar(255) not null,
    trangThai bit ,
	donViGiam varchar(15) not null,
	giaTriGiam int not null,
    primary key(maKhuyenMai)
)
go
create table KhuyenMaiSanPham
(
    maKhuyenMaiSanPham int identity(1,1) not null,
    maKhuyenMai varchar(15) not null,
    maSanPhamChiTiet int null,
	trangThai bit,
    primary key(maKhuyenMaiSanPham),
    foreign key (maSanPhamChiTiet) references SanPhamChiTiet(maSanPhamChiTiet),
    foreign key (maKhuyenMai) references KhuyenMai(maKhuyenMai)
)
go


insert into HeDieuHanh(ten,trangThai)
    values('IOS',1),
    ('Android',1)
go

insert into Hang(ten,maHeDieuHanh,trangThai)
    values('IPhone',1,1),
    ('Oppo',2,2),
    ('SamSung',2,2),        
    ('Huawei',2,2),
    ('Xiaomi',2,2)
go

insert into ManHinh
    values(N'LCD',1),
    ('OLED ',1),        
    ('AMOLED',1),
    ('Retina',1),
    ('Full HD',1)
go

insert into MauSac
    values(N'Đen sáng',1),
    (N'Bạc',1),        
    (N'Vàng',1),
    (N'Đen bóng',1),
    (N'Tìm',1),
    (N'Xanh biển',1),
    ('Đỏ',1)
go

insert into BoNhoTrong
    values('ROM01','8GB',1),
    ('ROM02','16GB',1),
    ('ROM03','32GB',1),
    ('ROM04','64GB',1),
    ('ROM05','128GB',1),
    ('ROM06','256GB',1),
    ('ROM07','512GB',1)
go

insert into Camera
    values(N'CAMERA KÉP','20MP',1),
    (N'CAMERA ĐƠN','20MP',1),
    (N'CAMERA DỌC','32MP',1),
    (N'CAMERA NGANG','16MP',1),
    (N'CAMERA VUÔNG','48MP',1)
go

insert into RAM
    values('RAM01','2GB',1),
    ('RAM02','4GB',1),
    ('RAM03','6GB',1),
    ('RAM04','8GB',1),
    ('RAM05','16GB',1),
    ('RAM06','32GB',1)
go

insert into CPU
    values(N'Apple A15 Bionic 6 nhân',1),
    (N'MediaTek Dimesity 700 5G 8 nhân',1),
    (N'Snapdragon B65 8 nhân',1),
    (N'Snapdragon 720G 8 nhân',1)
go
    
insert into XuatXu
    values(N'Trung Quốc',1),
    (N'Ấn Độ',1),
    (N'Việt Nam',1),
    (N'Mỹ',1)
go

insert into LoaiHang
    values(N'Cũ',1),
    (N'Mới',1)
go
select * from Hang
insert into SanPham(maSanPham,tenSanPham,anhSanPham,moTa,maHDH,maHang)
    values('IPA',N'iPhone 13 Pro Max','iphone-14-max-600x600.jpg',N'Hệ thống camera kép','1','1'),
    ('IPB',N'iPhone 12 Pro Max','iphone-14-max-600x600.jpg',N'Hệ thống camera kép','1','1'),
    ('IPC',N'iPhone 8 Plus','iphone.jpg',N'Hệ thống camera kép','1','1'),
    ('IPD',N'iPhone 11 Pro','iphone.jpg',N'Hệ thống camera kép','1','1'),
    ('SSA',N'Samsung Galaxy Z Fold 3','samsung-galaxy-a12-trang-600x600.jpg',N'Hệ thống camera kép','2','3'),
    ('SSB',N'Samsung Galaxy Note 20 Ultra',N'samsung-galaxy-a12-trang-600x600.jpg','Hệ thống camera kép','2','3'),
    ('SSC',N'Samsung Galaxy S21 Ultra','samsung-galaxy-a12-trang-600x600.jpg',N'Hệ thống camera kép','2','3'),
    ('HWA',N'Huawei P30 Pro','th.jpg',N'Hệ thống camera kép','2','4'),
    ('HWB',N'Huawei Mate 40 Pro','th.jpg',N'Hệ thống camera kép','2','4'),
    ('HWC',N'Huawei P40 Pro','th.jpg',N'Hệ thống camera kép','2','4'),
    ('OPA',N'OPPO Find X3 Pro','oppo.jpg',N'Hệ thống camera kép','2','2'),
    ('OPB',N'OPPO Reno6 Pro+ 5G ','oppo.jpg',N'Hệ thống camera kép','2','2'),
    ('OPC',N'OPPO A74 5G','oppo.jpg',N'Hệ thống camera kép','2','2')
go

insert into SanPhamChiTiet  (maSanPham,maMauSac,maManHinh,maBoNhoTrong,maCamera,maRam,maCPU,maXuatXu,maLoaiHang,giaSanPham,giaNhap,ngayTao,trangThai)
    values('IPA','3','2','6','1','5','1','1','1',8000000,7000000,'10/4/2023',1),
    ('IPB','3','2','6','2','5','2','1','1',6500000,5500000,'10/4/2023',1),
    ('IPC','2','2','6','1','5','1','2','2',6000000,4500000,'10/4/2023',1),
    ('SSA','1','2','6','1','5','2','1','1',4000000,3500000,'10/4/2023',1)
go
select * from KhachHang
    insert into Imei(soImei,maSanPhamChiTiet,trangThai)
        values('879456','1',1),
    ('264654','1',1),
    ('798798','1',1),
    ('312544','1',1),
    ('789454','2',1),
    ('215454','2',1),
    ('216547','2',1),
    ('781215','2',1),
    ('785455','3',1),
    ('789231','3',1),
    ('874521','4',1),
    ('125415','4',1)
go

insert into NhanVien(maNhanVien,matKhau,tenNhanVien,anhNhanVien,soDienThoai,ngaySinh,gioiTinh,diaChi,email,vaitro,trangThai,ngayTao)
    values('NV001','123456',N'đỗ văn công','nv01.jpg','0793180165','2-07-2002',1,N'Hà nội','congdvph31357',0,1,'2-07-2002'),
    ('NV002','123456',N'đỗ văn chiến','nv02.jpg','0793180165','12-09-2004',1,N'Cao bằng','chiendvph31357',0,1,'2-07-2002'),
    ('NV003','123456',N'nguyễn thị đường','nv03.jpg','0793180165','12-09-2002',0,N'Hà nội','duongdvph31357',1,1,'2-07-2002'),
    ('NV004','123456',N'đỗ thị nhàn','nv04.jpg','0793180165','12-09-2001',0,N'Thái bình','nhandvph31357',0,1,'2-07-2002'),
    ('NV005','123456',N'đỗ thị trang','nv05.jpg','0793180165','12-10-2006',0,N'Hải dương','trangdvph31357',0,1,'2-07-2002')
go
   
insert into KhachHang(tenKhachHang,soDienThoai,ngaySinh,diaChi,gioiTinh,email,ngayTao,ghiChu,trangThai)
    values(N'đỗ văn công','01645694594','12-09-2002',N'Hà Nội',1,'congdvph31357','12/10/2023','',1),
    (N'đỗ văn chiến','01645694594','12-09-2002',N'Bắc Ninh',0,'congdvph31357','12/10/2023','',1),
    (N'đỗ văn nhàn','01645694594','12-09-2002',N'Thái Bình',1,'congdvph31357','12/10/2023','',1),
    (N'đỗ thị trang','01645694594','12-09-2002',N'Hà Nội',0,'congdvph31357','12/10/2023','',1),
    (N'đỗ minh quân','01645694594','12-09-2002',N'Đà Nẵng',1,'congdvph31357','12/10/2023','',1),
    (N'đỗ văn đức','01645694594','12-09-2002',N'Hà Nội',0,'congdvph31357','12/10/2023','',1)
go
select * from SanPhamChiTiet 
select SanPhamChiTiet.maSanPhamChiTiet,SanPham.tenSanPham from SanPham 
inner join SanPhamChiTiet on SanPham.maSanPham = SanPhamChiTiet.maSanPham 
inner join Imei on SanPhamChiTiet.maSanPhamChiTiet = Imei.maSanPhamChiTiet
group by SanPhamChiTiet.maSanPhamChiTiet,SanPham.tenSanPham

 order by maSanPhamChiTiet desc
select * from HoaDon
select * from HoaDonChiTiet
select * from Imei
select * from SanPhamChiTiet
select tenSanPham,maCamera,maRam,maHDH,soImei,Imei.maSanPhamChiTiet,Imei.trangThai from SanPham
inner join SanPhamChiTiet on SanPham.maSanPham = SanPhamChiTiet.maSanPham
inner join Imei on Imei.maSanPhamChiTiet = SanPhamChiTiet.maSanPhamChiTiet
where Imei.trangThai=1
select * from KhachHang
update SanPhamChiTiet set trangThai=0 where maSanPhamChiTiet = 1

select * from KhuyenMai
select * from KhuyenMaiSanPham
delete KhuyenMaiSanPham where maKhuyenMai = 'KM01'