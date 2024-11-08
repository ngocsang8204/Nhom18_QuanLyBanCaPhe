package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.Ban_Entity;
import Entity.HoaDon_Entity;
import Entity.KhachHang_Entity;
import Entity.NhanVien_Entity;

public class HoaDon_DAO {
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private Ban_DAO ban_dao = new Ban_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();

	public HoaDon_DAO() {

	}

	public ArrayList<HoaDon_Entity> danhSachHoaDon() {
		ArrayList<HoaDon_Entity> dsHD = new ArrayList<HoaDon_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
			if (con == null) {
				System.out.println("Connection is not established.");
			}
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				LocalDateTime ngayLap = rs.getTimestamp(2).toLocalDateTime();
				double giamGia = rs.getDouble(3);
				String maKH = rs.getString(4);
				String maBan = rs.getString(5);
				String maNV = rs.getString(6);
				KhachHang_Entity kh = kh_dao.timKiemKhachHangTheoMa(maKH);
				Ban_Entity ban = ban_dao.timBanTheoMa(maBan);
				NhanVien_Entity nv = nv_dao.timNhanVienTheoMa(maNV);
				HoaDon_Entity hd = new HoaDon_Entity(maHD, ngayLap, giamGia, kh, ban, nv);
				dsHD.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public HoaDon_Entity timKiemHoaDonTheoMa(String ma) {
		ArrayList<HoaDon_Entity> dsHD = danhSachHoaDon();
		return dsHD.stream().filter(x -> x.getMaHoaDon().equalsIgnoreCase(ma)).findFirst().orElse(null);
	}

	public boolean themHoaDon(HoaDon_Entity hd) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stmt = null;
		boolean isSuccess = false;

		try {
			ArrayList<HoaDon_Entity> dsHD = danhSachHoaDon();
			String sql = "INSERT INTO HoaDon(maHoaDon, ngayLap, giamGia, maKhachHang, maBan, maNhanVien) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setTimestamp(2, Timestamp.valueOf(hd.getNgayLap()));
			stmt.setDouble(3, hd.getGiamGia());
			stmt.setString(4, hd.getKhachHang().getMaKhachHang());
			stmt.setString(5,  hd.getBan().getMaBan());
			stmt.setString(6, hd.getNhanVien().getMaNhanVien());
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
