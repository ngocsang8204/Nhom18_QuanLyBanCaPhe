package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDon_Entity {
	private String maHoaDon;
	private LocalDateTime ngayLap;
	private double giamGia;
	private KhachHang_Entity khachHang;
	private Ban_Entity ban;
	private NhanVien_Entity nhanVien;
	public HoaDon_Entity(String maHoaDon, LocalDateTime ngayLap, double giamGia, KhachHang_Entity khachHang , Ban_Entity ban, NhanVien_Entity nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.giamGia = giamGia;
		this.nhanVien = nhanVien;
		this.ban = ban;
		this.khachHang = khachHang;
	}
	public HoaDon_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public NhanVien_Entity getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien_Entity nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Ban_Entity getBan() {
		return ban;
	}
	public void setBan(Ban_Entity ban) {
		this.ban = ban;
	}
	public KhachHang_Entity getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang_Entity khachHang) {
		this.khachHang = khachHang;
	}
	public HoaDon_Entity(String maHoaDon) {
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
		HoaDon_Entity other = (HoaDon_Entity) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", giamGia=" + giamGia + ", nhanVien="
				+ nhanVien + ", ban=" + ban + ", khachHang=" + khachHang + "]";
	}
	
	
}
