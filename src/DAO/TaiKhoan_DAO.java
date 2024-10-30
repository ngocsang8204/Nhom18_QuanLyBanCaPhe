package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class TaiKhoan_DAO {
	public TaiKhoan_DAO() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
	
	public static ArrayList<TaiKhoan> danhSachTaiKhoan(){
		khoiTao();
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTK = rs.getString(1);
				String tenDN = rs.getString(2);
				String matKhau = rs.getString(3);
				String maNhanVien = rs.getString(4);
				NhanVien nhanVien = nhanVien_dao.timNhanVienTheoMa(maNhanVien);
				TaiKhoan tk = new TaiKhoan(maTK, tenDN, matKhau, nhanVien);
				dsTK.add(tk);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	
	public TaiKhoan timTaiKhoan (String maTK) {
		ArrayList<TaiKhoan> dsTK = danhSachTaiKhoan();
		return dsTK.stream().filter(x -> x.getMaTaiKhoan().equalsIgnoreCase(maTK)).findFirst().orElse(null);
	}
	
	public boolean themTaiKhoan (TaiKhoan tk) {
		
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<TaiKhoan> dsTK = danhSachTaiKhoan();
	    	if (dsTK.contains(tk)) {
	    		System.out.println("Tài khoản đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO TaiKhoan(maTaiKhoan, tenDangNhap, matKhau, maNhanVien) VALUES (?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "TK00" + String.valueOf(dsTK.size() + 1));
	    		stmt.setString(2, tk.getTenDangNhap());
	    		stmt.setString(3, tk.getMatKhau());
	    		stmt.setString(4, tk.getNhanVien().getMaNhanVien());
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
	
	public boolean suaTaiKhoan(TaiKhoan tk) {
//		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<TaiKhoan> dsTK = danhSachTaiKhoan();
			if (!dsTK.contains(tk)) {
				System.out.println("Tài khoản không tồn tại");
			} else {
				String updateSql = "UPDATE TaiKhoan SET matKhau = ? WHERE maTaiKhoan = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, tk.getMatKhau());
		        updateStmt.setString(2, tk.getMaTaiKhoan());
		        
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
	
	public static void main(String[] args) {
		ArrayList<TaiKhoan> dsTK = danhSachTaiKhoan();
		dsTK.forEach(x -> System.out.println(x));
	}
}
