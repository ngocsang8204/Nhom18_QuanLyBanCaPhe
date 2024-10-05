package Entity;

public class ChiTietDonHang {
	private Mon mon;
	private HoaDon hoaDon;
	private int soLuongMon;
	public ChiTietDonHang(Mon mon, HoaDon hoaDon, int soLuongMon) {
		super();
		this.mon = mon;
		this.hoaDon = hoaDon;
		this.soLuongMon = soLuongMon;
	}
	public ChiTietDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mon getMon() {
		return mon;
	}
	public void setMon(Mon mon) {
		this.mon = mon;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
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
