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
import Entity.NguyenLieu;
import Entity.NhaCungCap;

public class NguyenLieu_DAO {
	NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
	public NguyenLieu_DAO() {
		
	}
	
	public ArrayList<NguyenLieu> danhSachNguyenLieu(){
		ArrayList<NguyenLieu> dsNL = new ArrayList<NguyenLieu>();
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
				NhaCungCap ncc = ncc_dao.timNhaCungCapTheoMa(maNCC);
				NguyenLieu nguyenLieu = new NguyenLieu(maNL, tenNL, soLuong, thoiGianNhap, thoiGianHetHan, ncc);
				dsNL.add(nguyenLieu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNL;
	}
	
	public NguyenLieu timNguyenLieuTheoMa (String ma) {
		ArrayList<NguyenLieu> dsNL = danhSachNguyenLieu();
		return dsNL.stream().filter(x -> x.getMaNguyenLieu().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<NguyenLieu> timNguyenLieuTheoTen (String ten){
		ArrayList<NguyenLieu> dsNL = danhSachNguyenLieu();
		return dsNL.stream().filter(x -> x.getTenNguyenLieu().matches(".*" + ten +  ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themNguyenLieu (NguyenLieu nguyenLieu) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<NguyenLieu> dsDV = danhSachNguyenLieu();
	    	if (dsDV.contains(nguyenLieu)) {
	    		System.out.println("Nguyên liệu đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO DichVu(maNguyenLieu, tenNguyenLieu, soLuong, thoiGianNhapHang, thoiGianHetHan, maNhaCungCap) VALUES (?, ?, ?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "NL00" + String.valueOf(dsDV.size() + 1));
	    		stmt.setString(2, nguyenLieu.getTenNguyenLieu());
	    		stmt.setInt(3, nguyenLieu.getSoLuong());
	    		stmt.setTimestamp(4, Timestamp.valueOf(nguyenLieu.getThoiGianNhap()));
	    		
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
}
