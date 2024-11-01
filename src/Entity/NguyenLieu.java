package Entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class NguyenLieu {
	private String maNguyenLieu;
	private String tenNguyenLieu;
	private int soLuong;
	private LocalDateTime thoiGianNhap;
	private LocalDateTime thoiGianHetHan;
	private NhaCungCap nhaCungCap;
	public NguyenLieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguyenLieu(String maNguyenLieu, String tenNguyenLieu, int soLuong, LocalDateTime thoiGianNhap, LocalDateTime thoiGianHetHan,
			NhaCungCap nhaCungCap) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.soLuong = soLuong;
		this.thoiGianNhap = thoiGianNhap;
		this.thoiGianHetHan = thoiGianHetHan;
		this.nhaCungCap = nhaCungCap;
	}
	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}
	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public LocalDateTime getThoiGianNhap() {
		return thoiGianNhap;
	}
	public void setThoiGianNhap(LocalDateTime thoiGianNhap) {
		this.thoiGianNhap = thoiGianNhap;
	}
	public LocalDateTime getThoiGianHetHan() {
		return thoiGianHetHan;
	}
	public void setThoiGianHetHan(LocalDateTime thoiGianHetHan) {
		this.thoiGianHetHan = thoiGianHetHan;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public NguyenLieu(String maNguyenLieu) {
		super();
		this.maNguyenLieu = maNguyenLieu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNguyenLieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NguyenLieu other = (NguyenLieu) obj;
		return Objects.equals(maNguyenLieu, other.maNguyenLieu);
	}
	@Override
	public String toString() {
		return "NguyenLieu [maNguyenLieu=" + maNguyenLieu + ", tenNguyenLieu=" + tenNguyenLieu + ", soLuong=" + soLuong
				+ ", thoiGianNhap=" + thoiGianNhap + ", thoiGianHetHan=" + thoiGianHetHan + ", nhaCungCap=" + nhaCungCap
				+ "]";
	}
	
}
