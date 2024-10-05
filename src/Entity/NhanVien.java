package Entity;

import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String soCCCD;
	private String soDienThoai;
	private String diaChi;
	private String chucVu;
	public NhanVien(String maNhanVien, String tenNhanVien, String soCCCD, String soDienThoai, String diaChi,
			String chucVu) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soCCCD = soCCCD;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", soCCCD=" + soCCCD
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", chucVu=" + chucVu + "]";
	}
	
	
}
