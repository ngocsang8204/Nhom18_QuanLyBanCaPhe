package Entity;

import java.util.Date;
import java.util.Objects;

public class NguyenLieu {
	private String maNguyenLieu;
	private String tenNguyenLieu;
	private int soLuong;
	private Date thoiGianNhap;
	private Date thoiGianHetHan;
	private NhaCungCap nhaCungCap;
	public NguyenLieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguyenLieu(String maNguyenLieu, String tenNguyenLieu, int soLuong, Date thoiGianNhap, Date thoiGianHetHan,
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
	public Date getThoiGianNhap() {
		return thoiGianNhap;
	}
	public void setThoiGianNhap(Date thoiGianNhap) {
		this.thoiGianNhap = thoiGianNhap;
	}
	public Date getThoiGianHetHan() {
		return thoiGianHetHan;
	}
	public void setThoiGianHetHan(Date thoiGianHetHan) {
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
