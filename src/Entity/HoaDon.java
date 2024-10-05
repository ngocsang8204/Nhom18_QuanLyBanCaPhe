package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLap;
	private double giamGia;
	private NhanVien nhanVien;
	private Ban ban;
	private KhachHang khachHang;
	public HoaDon(String maHoaDon, LocalDate ngayLap, double giamGia, NhanVien nhanVien, Ban ban, KhachHang khachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.giamGia = giamGia;
		this.nhanVien = nhanVien;
		this.ban = ban;
		this.khachHang = khachHang;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Ban getBan() {
		return ban;
	}
	public void setBan(Ban ban) {
		this.ban = ban;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", giamGia=" + giamGia + ", nhanVien="
				+ nhanVien + ", ban=" + ban + ", khachHang=" + khachHang + "]";
	}
	
	
}
