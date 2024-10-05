package Entity;

import java.util.Objects;

public class NhaCungCap {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String diaChi;
	private String thongTinLienHe;
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String thongTinLienHe) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.thongTinLienHe = thongTinLienHe;
	}
	public NhaCungCap() {
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
	public NhaCungCap(String maNhaCungCap) {
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
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(maNhaCungCap, other.maNhaCungCap);
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", thongTinLienHe=" + thongTinLienHe + "]";
	}
	
	
}
