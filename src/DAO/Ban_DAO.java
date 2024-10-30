package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.Ban;

public class Ban_DAO {
	public Ban_DAO () {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<Ban> danhSachBan (){
		khoiTao();
		ArrayList<Ban> dsBan = new ArrayList<Ban>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from Ban";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maBan = rs.getString(1);
				String tenBan = rs.getString(2);
				String trangThai = rs.getString(3);
				String ghiChu = rs.getString(4);
				Ban ban = new Ban(maBan, tenBan, trangThai, ghiChu);
				dsBan.add(ban);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBan;
	}

	public Ban timBanTheoMa (String ma) {
		ArrayList<Ban> dsBan = danhSachBan();
		return dsBan.stream().filter(x -> x.getMaBan().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<Ban> timBanTheoTen (String ten){
		ArrayList<Ban> dsBan = danhSachBan();
		return dsBan.stream().filter(x -> x.getTenBan().matches(".*" + ten + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Ban> timBanTheoTrangThai (String trangThai) {
		ArrayList<Ban> dsBan = danhSachBan();
		return dsBan.stream().filter(x -> x.getTrangThaiBan().equals(trangThai)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themBan (Ban ban) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<Ban> dsBan = danhSachBan();
	    	if (dsBan.contains(ban)) {
	    		System.out.println("Bàn đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO Ban(maBan, tenBan, trangThaiBan, ghiChu) VALUES (?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "Ban00" + String.valueOf(dsBan.size() + 1));
	    		stmt.setString(2, ban.getTenBan());
	    		stmt.setString(3, ban.getTrangThaiBan());
	    		stmt.setString(4, ban.getGhiChu());
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
	
	public boolean suaBan(Ban ban) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<Ban> dsBan = danhSachBan();
			if (!dsBan.contains(ban)) {
				System.out.println("Bàn không tồn tại");
			} else {
				String updateSql = "UPDATE Ban SET tenBan = ?, trangThaiBan = ?, ghiChu = ? WHERE maBan = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, ban.getTenBan());
		        updateStmt.setString(2, ban.getTrangThaiBan());
		        updateStmt.setString(3, ban.getGhiChu());
		        updateStmt.setString(4, ban.getMaBan());
		        
		        
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
