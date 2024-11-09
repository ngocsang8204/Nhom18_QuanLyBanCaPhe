package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.ChiTietMon_Entity;

public class ChiTietMon_DAO {
	private Mon_DAO mon_dao= new Mon_DAO();
	private NguyenLieu_DAO nl_dao= new NguyenLieu_DAO();
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<ChiTietMon_Entity> getDSChiTietMon(String maMon){
		khoiTao();
		 ArrayList<ChiTietMon_Entity> ds= new ArrayList<ChiTietMon_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql= "Select * from chitietmon where mamon like ?";
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setString(1, maMon);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				ds.add(new ChiTietMon_Entity(mon_dao.timMonTheoMa(rs.getNString(1)), 
						nl_dao.timNguyenLieuTheoMa(rs.getNString(2)), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
