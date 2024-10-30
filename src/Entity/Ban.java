package Entity;

import java.util.Objects;

public class Ban {
	private String maBan;
	private String tenBan;
	private String trangThaiBan;
	private String ghiChu;
	public Ban(String maBan, String tenBan, String trangThaiBan, String ghiChu) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.trangThaiBan = trangThaiBan;
		this.ghiChu = ghiChu;
	}
	public Ban() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getTenBan() {
		return tenBan;
	}
	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
	public String getTrangThaiBan() {
		return trangThaiBan;
	}
	public void setTrangThaiBan(String trangThaiBan) {
		this.trangThaiBan = trangThaiBan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Ban(String maBan) {
		super();
		this.maBan = maBan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maBan);
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ban other = (Ban) obj;
		return Objects.equals(maBan, other.maBan);
	}
	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", tenBan=" + tenBan + ", trangThaiBan=" + trangThaiBan + ", ghiChu=" + ghiChu
				+ "]";
	}
	
	
}
