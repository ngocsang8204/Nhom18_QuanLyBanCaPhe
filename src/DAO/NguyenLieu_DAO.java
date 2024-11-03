package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.NguyenLieu_Entity;
import Entity.NhaCungCap_Entity;

public class NguyenLieu_DAO {
	NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
	public NguyenLieu_DAO() {
		
	}
	
	public ArrayList<NguyenLieu_Entity> danhSachNguyenLieu(){
		ArrayList<NguyenLieu_Entity> dsNL = new ArrayList<NguyenLieu_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from NguyenLieu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNL = rs.getString(1);
				String tenNL = rs.getString(2);
				int soLuong = rs.getInt(3);
				LocalDateTime thoiGianNhap = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime thoiGianHetHan = rs.getTimestamp(5).toLocalDateTime();
				String maNCC = rs.getString(6);
				NhaCungCap_Entity ncc = ncc_dao.timNhaCungCapTheoMa(maNCC);
				NguyenLieu_Entity nguyenLieu = new NguyenLieu_Entity(maNL, tenNL, soLuong, thoiGianNhap, thoiGianHetHan, ncc);
				dsNL.add(nguyenLieu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNL;
	}
	
	public NguyenLieu_Entity timNguyenLieuTheoMa (String ma) {
		ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
		return dsNL.stream().filter(x -> x.getMaNguyenLieu().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<NguyenLieu_Entity> timNguyenLieuTheoTen (String ten){
		ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
		return dsNL.stream().filter(x -> x.getTenNguyenLieu().matches(".*" + ten +  ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themNguyenLieu (NguyenLieu_Entity nguyenLieu) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<NguyenLieu_Entity> dsDV = danhSachNguyenLieu();
	    	if (dsDV.contains(nguyenLieu)) {
	    		System.out.println("Nguyên liệu đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO NguyenLieu(maNguyenLieu, tenNguyenLieu, soLuong, thoiGianNhapHang, thoiGianHetHan, maNhaCungCap) VALUES (?, ?, ?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "NL00" + String.valueOf(dsDV.size() + 1));
	    		stmt.setString(2, nguyenLieu.getTenNguyenLieu());
	    		stmt.setInt(3, nguyenLieu.getSoLuong());
	    		stmt.setTimestamp(4, Timestamp.valueOf(nguyenLieu.getThoiGianNhap()));
	    		stmt.setTimestamp(5, Timestamp.valueOf(nguyenLieu.getThoiGianHetHan()));
	    		stmt.setString(6, nguyenLieu.getNhaCungCap().getMaNhaCungCap());
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
	
	public boolean suaNguyenLieu (NguyenLieu_Entity nguyenLieu) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
			if (!dsNL.contains(nguyenLieu)) {
				System.out.println("Nguyên liệu không tồn tại");
			} else {
				String updateSql = "UPDATE NguyenLieu SET tenNguyenLieu = ?, soLuong = ?, thoiGianNhapHang = ?, thoiGianHetHan = ? WHERE maNguyenLieu = ?";
		        PreparedStatement stmt = connection.prepareStatement(updateSql);
		        stmt.setString(1, nguyenLieu.getTenNguyenLieu());
	    		stmt.setInt(2, nguyenLieu.getSoLuong());
	    		stmt.setTimestamp(3, Timestamp.valueOf(nguyenLieu.getThoiGianNhap()));
	    		stmt.setTimestamp(4, Timestamp.valueOf(nguyenLieu.getThoiGianHetHan()));
	    		stmt.setString(5, nguyenLieu.getNhaCungCap().getMaNhaCungCap());
		        stmt.setString(6, nguyenLieu.getMaNguyenLieu());
		        
		        int rowsInserted = stmt.executeUpdate();
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
