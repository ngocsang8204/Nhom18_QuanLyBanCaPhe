package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
	
	public ArrayList<KhachHang> danhSachKhachHang(){
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
	
	public KhachHang timKiemKhachHangTheoMa (String ma) {
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getMaKhachHang().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<KhachHang> timKiemKhachHangTheoTen (String ten){
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getTenKhachHang().matches(".*" + ten + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themKhachHang (KhachHang khachHang) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<KhachHang> dsKH = danhSachKhachHang();
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
	
	public boolean suaKhachHang(KhachHang khachHang) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<KhachHang> dsKH = danhSachKhachHang();
			if (!dsKH.contains(khachHang)) {
				System.out.println("Khách hàng không tồn tại");
			} else {
				String updateSql = "UPDATE DichVu SET tenKhachHang = ?, soDienThoai = ? WHERE maKhachHang = ?";
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
}
