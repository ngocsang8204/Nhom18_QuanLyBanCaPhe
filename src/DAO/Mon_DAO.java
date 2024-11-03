package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.Mon_Entity;

public class Mon_DAO {
	public Mon_DAO() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList<Mon_Entity> danhSachMon(){
		khoiTao();
		ArrayList<Mon_Entity> dsDV = new ArrayList<Mon_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from Mon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maMon = rs.getString(1);
				String tenMon = rs.getString(2);
				double giaTien = rs.getDouble(4);
				String loaiMon = rs.getString(3);
				Mon_Entity mon = new Mon_Entity(maMon, tenMon, loaiMon, giaTien);
				dsDV.add(mon);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	
	public Mon_Entity timMonTheoMa(String ma) {
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getMaMon().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<Mon_Entity> timMonTheoTen (String ten){
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getTenMon().matches(".*" + ten + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Mon_Entity> timMonTheoLoai (String loai){
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getLoaiMon().matches(".*" + loai + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Mon_Entity layMonTheoTenChinhXac (String ten) {
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getTenMon().equalsIgnoreCase(ten)).findFirst().orElse(null);
	}
	
	public boolean themMon(Mon_Entity mon) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<Mon_Entity> dsMon = danhSachMon();
	    	if (dsMon.contains(mon)) {
	    		System.out.println("Món đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO Mon(maMon, tenMon, loaiMon, donGia) VALUES (?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "M00" + String.valueOf(dsMon.size() + 1));
	    		stmt.setString(2, mon.getTenMon());
	    		stmt.setDouble(4, mon.getDonGia());
	    		stmt.setString(3, mon.getLoaiMon());
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
	
	public boolean suaMon(Mon_Entity mon) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<Mon_Entity> dsDV = danhSachMon();
			if (!dsDV.contains(mon)) {
				System.out.println("Món không tồn tại");
			} else {
				String updateSql = "UPDATE Mon SET tenMon = ?, loaiMon = ?, donGia = ? WHERE maMon = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, mon.getTenMon());
		        updateStmt.setString(2, mon.getLoaiMon());
		        updateStmt.setDouble(3, mon.getDonGia());
		        updateStmt.setString(4, mon.getMaMon());
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
}
