CREATE DATABASE QLQuanCoffee
GO
USE QLQuanCoffee
-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan (
    maTaiKhoan NVARCHAR(50) NOT NULL,
    tenDangNhap NVARCHAR(255) NOT NULL,
    matKhau NVARCHAR(255) NOT NULL,
    maNhanVien NVARCHAR(50) NOT NULL,
    PRIMARY KEY (maTaiKhoan)
);

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    maNhanVien NVARCHAR(50) NOT NULL,
    tenNhanVien NVARCHAR(255),
    soCCCD NVARCHAR(12),
    soDienThoai NVARCHAR(255),
    diaChi NVARCHAR(255),
    chucVu BIT NOT NULL,
    PRIMARY KEY (maNhanVien)
);

-- Tạo bảng Ban
CREATE TABLE Ban (
    maBan NVARCHAR(50) NOT NULL,
    tenBan NVARCHAR(255),
    trangThaiBan NVARCHAR(255) NOT NULL,
    ghiChu NVARCHAR(255),
    PRIMARY KEY (maBan)
);

-- Tạo bảng Mon
CREATE TABLE Mon (
    maMon NVARCHAR(50) NOT NULL,
    tenMon NVARCHAR(255),
    loaiMon NVARCHAR(255),
    donGia MONEY NOT NULL,
    PRIMARY KEY (maMon)
);

-- Tạo bảng HoaDon
CREATE TABLE HoaDon (
    maHoaDon NVARCHAR(50) NOT NULL,
    ngayLap DATETIME,
    giamGia MONEY,
    maKhachHang NVARCHAR(50),
    maBan NVARCHAR(50),
    maNhanVien NVARCHAR(50),
    PRIMARY KEY (maHoaDon)
);

-- Tạo bảng ChiTietDonHang
CREATE TABLE ChiTietDonHang (
    maHoaDon NVARCHAR(50) NOT NULL,
    maMon NVARCHAR(50) NOT NULL,
    soLuongMon INT NOT NULL,
    PRIMARY KEY (maHoaDon, maMon)
);

-- Tạo bảng NguyenLieu
CREATE TABLE NguyenLieu (
    maNguyenLieu NVARCHAR(50) NOT NULL,
    tenNguyenLieu NVARCHAR(255),
    soLuong INT,
    thoiGianNhapHang DATETIME,
    thoiGianHetHan DATETIME,
    maNhaCungCap NVARCHAR(50),
    PRIMARY KEY (maNguyenLieu)
);

-- Tạo bảng ChiTietMon
CREATE TABLE ChiTietMon (
    maMon NVARCHAR(50) NOT NULL,
    maNguyenLieu NVARCHAR(50) NOT NULL,
    soLuongNguyenLieuTrongMon INT NOT NULL,
    PRIMARY KEY (maMon, maNguyenLieu)
);

-- Tạo bảng NhaCungCap
CREATE TABLE NhaCungCap (
    maNhaCungCap NVARCHAR(50) NOT NULL,
    tenNhaCungCap NVARCHAR(255),
    diaChi NVARCHAR(255),
    thongTinLienHe NVARCHAR(255),
    PRIMARY KEY (maNhaCungCap)
);

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    maKhachHang NVARCHAR(50) NOT NULL,
    tenKhachHang NVARCHAR(255),
    soDienThoai NVARCHAR(255),
    PRIMARY KEY (maKhachHang)
);

-- Liên kết TaiKhoan với NhanVien
ALTER TABLE TaiKhoan
ADD CONSTRAINT FK_TaiKhoan_NhanVien
FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien);

-- Liên kết HoaDon với Ban, KhachHang và NhanVien
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_Ban
FOREIGN KEY (maBan) REFERENCES Ban(maBan);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_NhanVien
FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien);

-- Liên kết ChiTietDonHang với HoaDon và Mon
ALTER TABLE ChiTietDonHang
ADD CONSTRAINT FK_ChiTietDonHang_HoaDon
FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon);

ALTER TABLE ChiTietDonHang
ADD CONSTRAINT FK_ChiTietDonHang_Mon
FOREIGN KEY (maMon) REFERENCES Mon(maMon);

-- Liên kết ChiTietMon với Mon và NguyenLieu
ALTER TABLE ChiTietMon
ADD CONSTRAINT FK_ChiTietMon_Mon
FOREIGN KEY (maMon) REFERENCES Mon(maMon);

ALTER TABLE ChiTietMon
ADD CONSTRAINT FK_ChiTietMon_NguyenLieu
FOREIGN KEY (maNguyenLieu) REFERENCES NguyenLieu(maNguyenLieu);

-- Liên kết NguyenLieu với NhaCungCap
ALTER TABLE NguyenLieu
ADD CONSTRAINT FK_NguyenLieu_NhaCungCap
FOREIGN KEY (maNhaCungCap) REFERENCES NhaCungCap(maNhaCungCap);

--add values
-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (maNhanVien, tenNhanVien, soCCCD, soDienThoai, diaChi, chucVu)
VALUES
('NV001', N'Nguyễn Văn A', '123456789012', '0987654321', N'123 Đường ABC, Quận 1, TP.HCM', 1),
('NV002', N'Trần Thị B', '123456789013', '0987654322', N'456 Đường DEF, Quận 2, TP.HCM', 0),
('NV003', N'Lê Văn C', '123456789014', '0987654323', N'789 Đường GHI, Quận 3, TP.HCM', 1),
('NV004', N'Phạm Thị D', '123456789015', '0987654324', N'321 Đường JKL, Quận 4, TP.HCM', 0),
('NV005', N'Vũ Thị E', '123456789016', '0987654325', N'654 Đường MNO, Quận 5, TP.HCM', 1);

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (maTaiKhoan, tenDangNhap, matKhau, maNhanVien)
VALUES
('TK001', N'nguyenvana', N'password1', 'NV001'),
('TK002', N'tranthib', N'password2', 'NV002'),
('TK003', N'levanc', N'password3', 'NV003'),
('TK004', N'phamthid', N'password4', 'NV004'),
('TK005', N'vuthie', N'password5', 'NV005');

-- Thêm dữ liệu vào bảng Ban
INSERT INTO Ban (maBan, tenBan, trangThaiBan, ghiChu)
VALUES
('B001', N'Bàn 1', N'Trống', N'Gần cửa sổ'),
('B002', N'Bàn 2', N'Đang sử dụng', N'Gần quầy thu ngân'),
('B003', N'Bàn 3', N'Trống', N'Ngoài trời'),
('B004', N'Bàn 4', N'Đang sử dụng', N'Trong phòng VIP'),
('B005', N'Bàn 5', N'Trống', N'Gần sân vườn');

-- Thêm dữ liệu vào bảng Mon
INSERT INTO Mon (maMon, tenMon, loaiMon, donGia)
VALUES
('M001', N'Cà phê sữa', N'Nước uống', 25000),
('M002', N'Trà sữa', N'Nước uống', 30000),
('M003', N'Bánh mì', N'Thức ăn', 15000),
('M004', N'Sinh tố bơ', N'Nước uống', 35000),
('M005', N'Nước cam', N'Nước uống', 20000);

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (maKhachHang, tenKhachHang, soDienThoai)
VALUES
('KH001', N'Hoàng Anh', '0912345678'),
('KH002', N'Thái Hòa', '0912345679'),
('KH003', N'Lan Hương', '0912345680'),
('KH004', N'Minh Châu', '0912345681'),
('KH005', N'Tuấn Kiệt', '0912345682');

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (maHoaDon, ngayLap, giamGia, maKhachHang, maBan, maNhanVien)
VALUES
('HD001', '2024-10-01', 5000, 'KH001', 'B001', 'NV001'),
('HD002', '2024-10-02', 0, 'KH002', 'B002', 'NV002'),
('HD003', '2024-10-03', 10000, 'KH003', 'B003', 'NV003'),
('HD004', '2024-10-04', 2000, 'KH004', 'B004', 'NV004'),
('HD005', '2024-10-05', 0, 'KH005', 'B005', 'NV005');

-- Thêm dữ liệu vào bảng ChiTietDonHang
INSERT INTO ChiTietDonHang (maHoaDon, maMon, soLuongMon)
VALUES
('HD001', 'M001', 2),
('HD001', 'M003', 1),
('HD002', 'M002', 3),
('HD003', 'M004', 1),
('HD004', 'M005', 2);

-- Thêm dữ liệu vào bảng NhaCungCap
INSERT INTO NhaCungCap (maNhaCungCap, tenNhaCungCap, diaChi, thongTinLienHe)
VALUES
('NCC001', N'Nhà cung cấp A', N'123 Đường ABC, TP.HCM', '0901234567'),
('NCC002', N'Nhà cung cấp B', N'456 Đường DEF, TP.HCM', '0901234568'),
('NCC003', N'Nhà cung cấp C', N'789 Đường GHI, TP.HCM', '0901234569'),
('NCC004', N'Nhà cung cấp D', N'321 Đường JKL, TP.HCM', '0901234570'),
('NCC005', N'Nhà cung cấp E', N'654 Đường MNO, TP.HCM', '0901234571');

-- Thêm dữ liệu vào bảng NguyenLieu
INSERT INTO NguyenLieu (maNguyenLieu, tenNguyenLieu, soLuong, thoiGianNhapHang, thoiGianHetHan, maNhaCungCap)
VALUES
('NL001', N'Cà phê hạt', 100, '2024-10-01', '2025-10-01', 'NCC001'),
('NL002', N'Trà xanh', 50, '2024-10-02', '2025-10-02', 'NCC002'),
('NL003', N'Bơ', 30, '2024-10-03', '2024-12-01', 'NCC003'),
('NL004', N'Sữa tươi', 20, '2024-10-04', '2024-11-01', 'NCC004'),
('NL005', N'Nước cam', 60, '2024-10-05', '2024-12-05', 'NCC005');

-- Thêm dữ liệu vào bảng ChiTietMon
INSERT INTO ChiTietMon (maMon, maNguyenLieu, soLuongNguyenLieuTrongMon)
VALUES
('M001', 'NL001', 10),
('M002', 'NL002', 5),
('M003', 'NL005', 2),
('M004', 'NL003', 3),
('M005', 'NL004', 1);
