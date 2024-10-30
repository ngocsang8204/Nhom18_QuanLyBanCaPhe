package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.KhachHang;

public class KhachHang_DAO {
	public KhachHang_DAO() {
		
	}
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static ArrayList<KhachHang> danhSachKhachHang(){
		khoiTao();
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String soDienThoai = rs.getString(3);
				KhachHang kh = new  KhachHang(maKhachHang, tenKhachHang, soDienThoai);
				dsKH.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	public static void main(String[] args) {
		khoiTao();
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		dsKH.stream().forEach(x -> System.out.println(x));
	}
}
