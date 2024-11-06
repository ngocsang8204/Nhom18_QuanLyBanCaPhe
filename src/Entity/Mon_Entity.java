package Entity;

import java.util.Objects;

public class Mon_Entity {
	private String maMon;
	private String tenMon;
	private String loaiMon;
	private double donGia;
	private int trangThai;
	
	public Mon_Entity(String maMon, String tenMon, String loaiMon, double donGia) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.loaiMon = loaiMon;
		this.donGia = donGia;
	}
	public Mon_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mon_Entity(String maMon, String tenMon, String loaiMon, double donGia, int trangThai) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.loaiMon = loaiMon;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getLoaiMon() {
		return loaiMon;
	}
	public void setLoaiMon(String loaiMon) {
		this.loaiMon = loaiMon;
	}
	
	public Mon_Entity(String maMon) {
		this.maMon = maMon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maMon);
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mon_Entity other = (Mon_Entity) obj;
		return Objects.equals(maMon, other.maMon);
	}
	@Override
	public String toString() {
		return "Mon [maMon=" + maMon + ", tenMon=" + tenMon + ", loaiMon=" + loaiMon + ", donGia=" + donGia + "]";
	}
	
	
}
