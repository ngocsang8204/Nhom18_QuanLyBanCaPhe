package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.NhanVien_Entity;
import Entity.TaiKhoan_Entity;

public class TaiKhoan_DAO {
	private Connection con;
	private NhanVien_DAO nhanVien_DAO;
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
	
	public static ArrayList<TaiKhoan_Entity> danhSachTaiKhoan(){
		khoiTao();
		ArrayList<TaiKhoan_Entity> dsTK = new ArrayList<TaiKhoan_Entity>();
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
				NhanVien_Entity nhanVien = nhanVien_dao.timNhanVienTheoMa(maNhanVien);
				TaiKhoan_Entity tk = new TaiKhoan_Entity(maTK, tenDN, matKhau, nhanVien);
				dsTK.add(tk);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	
	public TaiKhoan_Entity timTaiKhoan (String maTK) {
		ArrayList<TaiKhoan_Entity> dsTK = danhSachTaiKhoan();
		return dsTK.stream().filter(x -> x.getMaTaiKhoan().equalsIgnoreCase(maTK)).findFirst().orElse(null);
	}
	
	public boolean themTaiKhoan (TaiKhoan_Entity tk) {
		
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<TaiKhoan_Entity> dsTK = danhSachTaiKhoan();
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
	
	public boolean suaTaiKhoan(TaiKhoan_Entity tk) {
//		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<TaiKhoan_Entity> dsTK = danhSachTaiKhoan();
			if (!dsTK.contains(tk)) {
				System.out.println("Tài khoản không tồn tại");
			} else {
				String updateSql = "UPDATE TaiKhoan SET tenDangNhap = ?, matKhau = ?, maNhanVien = ? WHERE maTaiKhoan = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, tk.getTenDangNhap());
		        updateStmt.setString(2, tk.getMatKhau());
		        updateStmt.setString(3, tk.getNhanVien().getMaNhanVien());
		        updateStmt.setString(4, tk.getMaTaiKhoan());
		        
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
		ArrayList<TaiKhoan_Entity> dsTK = danhSachTaiKhoan();
		dsTK.forEach(x -> System.out.println(x));
	}

	public TaiKhoan_Entity checkUser(String username, String password) {
	    try {
	        con = database.getInstance().getConnection();
	        String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap = ? AND matKhau = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, username);
	        stmt.setString(2, password);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String maTK = rs.getString("maTaiKhoan");
	            String tenDN = rs.getString("tenDangNhap");
	            String matKhau = rs.getString("matKhau");
	            String maNhanVien = rs.getString("maNhanVien");
	            NhanVien_Entity nhanVien = nhanVien_dao.timNhanVienTheoMa(maNhanVien); // Giả sử phương thức này tồn tại
	            return new TaiKhoan_Entity(maTK, tenDN, matKhau, nhanVien);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public int getSLTaiKhoan() {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		String sql= "Select count(*) from TaiKhoan";
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
