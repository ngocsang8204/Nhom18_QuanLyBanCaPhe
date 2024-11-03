package Entity;

public class ChiTietDonHang_Entity {
	private Mon_Entity mon;
	private HoaDon_Entity hoaDon;
	private int soLuongMon;
	public ChiTietDonHang_Entity(Mon_Entity mon, HoaDon_Entity hoaDon, int soLuongMon) {
		super();
		this.mon = mon;
		this.hoaDon = hoaDon;
		this.soLuongMon = soLuongMon;
	}
	public ChiTietDonHang_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mon_Entity getMon() {
		return mon;
	}
	public void setMon(Mon_Entity mon) {
		this.mon = mon;
	}
	public HoaDon_Entity getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon_Entity hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuongMon() {
		return soLuongMon;
	}
	public void setSoLuongMon(int soLuongMon) {
		this.soLuongMon = soLuongMon;
	}
	@Override
	public String toString() {
		return "ChiTietDonHang [mon=" + mon + ", hoaDon=" + hoaDon + ", soLuongMon=" + soLuongMon + "]";
	}
}
