package Entity;

public class ChiTietMon_Entity {
	private Mon_Entity maMon;
	private NguyenLieu_Entity maNguyenLieu;
	private int soLuong;
	public Mon_Entity getMaMon() {
		return maMon;
	}
	public void setMaMon(Mon_Entity maMon) {
		this.maMon = maMon;
	}
	public NguyenLieu_Entity getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(NguyenLieu_Entity maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ChiTietMon_Entity(Mon_Entity maMon, NguyenLieu_Entity maNguyenLieu, int soLuong) {
		super();
		this.maMon = maMon;
		this.maNguyenLieu = maNguyenLieu;
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietMon [maMon=" + maMon + ", maNguyenLieu=" + maNguyenLieu + ", soLuong=" + soLuong + "]";
	}
	
	
}
