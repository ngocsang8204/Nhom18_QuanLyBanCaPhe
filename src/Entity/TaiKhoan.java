package Entity;

import java.util.Objects;

public class TaiKhoan {
	private String maTaiKhoan;
	private String tenDangNhap;
	private String matKhau;
	private NhanVien nhanVien;
	public TaiKhoan(String maTaiKhoan, String tenDangNhap, String matKhau, NhanVien nhanVien) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan() {
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
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public TaiKhoan(String maTaiKhoan) {
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
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", nhanVien=" + nhanVien + "]";
	}
	
}
