package Entity;

public class ChiTietDonHang_Entity {
	private HoaDon_Entity hoaDon;
	private Mon_Entity mon;
	
	private int soLuongMon;
	
	public ChiTietDonHang_Entity(HoaDon_Entity hoaDon, Mon_Entity mon, int soLuongMon) {
		super();
		this.hoaDon = hoaDon;
		this.mon = mon;
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
