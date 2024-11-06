package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.KhachHang_Entity;

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
	
	public ArrayList<KhachHang_Entity> danhSachKhachHang(){
		khoiTao();
		ArrayList<KhachHang_Entity> dsKH = new ArrayList<KhachHang_Entity>();
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
				KhachHang_Entity kh = new  KhachHang_Entity(maKhachHang, tenKhachHang, soDienThoai);
				dsKH.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	public KhachHang_Entity timKiemKhachHangTheoMa (String ma) {
		ArrayList<KhachHang_Entity> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getMaKhachHang().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<KhachHang_Entity> timKiemKhachHangTheoTen (String ten){
		ArrayList<KhachHang_Entity> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getTenKhachHang().matches(".*" + ten + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themKhachHang (KhachHang_Entity khachHang) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<KhachHang_Entity> dsKH = danhSachKhachHang();
	    	if (dsKH.contains(khachHang)) {
	    		System.out.println("Khách hàng đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO KhachHang(maKhachHang, tenKhachHang, soDienThoai) VALUES (?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "KH00" + String.valueOf(dsKH.size() + 1));
	    		stmt.setString(2, khachHang.getTenKhachHang());
	    		stmt.setString(3, khachHang.getSoDienThoai());
	    		int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return isSuccess;
	}
	
	public boolean suaKhachHang(KhachHang_Entity khachHang) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<KhachHang_Entity> dsKH = danhSachKhachHang();
			if (!dsKH.contains(khachHang)) {
				System.out.println("Khách hàng không tồn tại");
			} else {
				String updateSql = "UPDATE KhachHang SET tenKhachHang = ?, soDienThoai = ? WHERE maKhachHang = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, khachHang.getTenKhachHang());
		        updateStmt.setString(2, khachHang.getSoDienThoai());
		        updateStmt.setString(3, khachHang.getMaKhachHang());
		        int rowsInserted = updateStmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}
	public int getSLKH() {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		String sql= "Select count(*) from KhachHang";
		int count=0;
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
