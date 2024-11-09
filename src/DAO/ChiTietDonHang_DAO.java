package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.Ban_Entity;
import Entity.ChiTietDonHang_Entity;
import Entity.HoaDon_Entity;
import Entity.Mon_Entity;

public class ChiTietDonHang_DAO {
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private Mon_DAO mon_dao = new Mon_DAO();
	
	public ChiTietDonHang_DAO() {
		
	}
	
	public ArrayList<ChiTietDonHang_Entity> danhSachCTDH(){
		ArrayList<ChiTietDonHang_Entity> dsCTDH = new ArrayList<ChiTietDonHang_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from ChiTietDonHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maMon = rs.getString(2);
				int soLuongMon = rs.getInt(3);
				HoaDon_Entity hd = hd_dao.timKiemHoaDonTheoMa(maHD);
				Mon_Entity mon = mon_dao.timMonTheoMa(maMon);
				ChiTietDonHang_Entity ctdh = new ChiTietDonHang_Entity(hd, mon, soLuongMon);
				dsCTDH.add(ctdh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTDH;
	}
	
	public boolean themChiTietDonHang (ChiTietDonHang_Entity ctdh) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stmt = null;
		boolean isSuccess = false;

		try {
			String sql = "INSERT INTO ChiTietDonHang(maHoaDon, maMon, soLuongMon) VALUES (?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ctdh.getHoaDon().getMaHoaDon());
			stmt.setString(2, ctdh.getMon().getMaMon());
			stmt.setInt(3, ctdh.getSoLuongMon());
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
