package Entity;

import java.util.Objects;

public class NhaCungCap_Entity {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String diaChi;
	private String thongTinLienHe;
	private int trangThai;
	public NhaCungCap_Entity(String maNhaCungCap, String tenNhaCungCap, String diaChi, String thongTinLienHe) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.thongTinLienHe = thongTinLienHe;
	}
	
	public NhaCungCap_Entity(String maNhaCungCap, String tenNhaCungCap, String diaChi, String thongTinLienHe,
			int trangThai) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.thongTinLienHe = thongTinLienHe;
		this.trangThai = trangThai;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public NhaCungCap_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getThongTinLienHe() {
		return thongTinLienHe;
	}
	public void setThongTinLienHe(String thongTinLienHe) {
		this.thongTinLienHe = thongTinLienHe;
	}
	public NhaCungCap_Entity(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNhaCungCap);
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap_Entity other = (NhaCungCap_Entity) obj;
		return Objects.equals(maNhaCungCap, other.maNhaCungCap);
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", thongTinLienHe=" + thongTinLienHe + "]";
	}
	
	
}
