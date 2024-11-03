package Entity;

import java.util.Objects;

public class TaiKhoan_Entity {
	private String maTaiKhoan;
	private String tenDangNhap;
	private String matKhau;
	private NhanVien_Entity nhanVien;
	public TaiKhoan_Entity(String maTaiKhoan, String tenDangNhap, String matKhau, NhanVien_Entity nhanVien) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien_Entity getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien_Entity nhanVien) {
		this.nhanVien = nhanVien;
	}
	public TaiKhoan_Entity(String maTaiKhoan) {
		super();
		this.maTaiKhoan = maTaiKhoan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan_Entity other = (TaiKhoan_Entity) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", nhanVien=" + nhanVien + "]";
	}
	
}
