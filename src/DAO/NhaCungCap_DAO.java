package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.NguyenLieu_Entity;
import Entity.NhaCungCap_Entity;

public class NhaCungCap_DAO {
	public NhaCungCap_DAO() {
		
	}
	
	public ArrayList<NhaCungCap_Entity> danhSachNhaCungCap(){
		ArrayList<NhaCungCap_Entity> dsNCC = new ArrayList<NhaCungCap_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String thongTinLienHe = rs.getString(4);
				NhaCungCap_Entity ncc = new NhaCungCap_Entity(maNCC, tenNCC, diaChi, thongTinLienHe);
				dsNCC.add(ncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNCC;
	}
	
	public NhaCungCap_Entity timNhaCungCapTheoMa (String ma) {
		ArrayList<NhaCungCap_Entity> dsNCC = danhSachNhaCungCap();
		return dsNCC.stream().filter(x -> x.getMaNhaCungCap().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<NhaCungCap_Entity> timNhaCungCapTheoTen (String ten){
		ArrayList<NhaCungCap_Entity> dsNCC = danhSachNhaCungCap();
		return dsNCC.stream().filter(x -> x.getTenNhaCungCap().matches(".*" + ten + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themNhaCungCap (NhaCungCap_Entity ncc) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<NhaCungCap_Entity> dsDV = danhSachNhaCungCap();
	    	if (dsDV.contains(ncc)) {
	    		System.out.println("Nhà cung cấp đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, thongTinLieuHe) VALUES (?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "NCC00" + String.valueOf(dsDV.size() + 1));
	    		stmt.setString(2, ncc.getTenNhaCungCap());
	    		stmt.setString(3, ncc.getDiaChi());
	    		stmt.setString(4, ncc.getThongTinLienHe());
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
	
	public boolean suaNhaCungCap (NhaCungCap_Entity ncc) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<NhaCungCap_Entity> dsNCC = danhSachNhaCungCap();
			if (!dsNCC.contains(ncc)) {
				System.out.println("Nhà cung cấp không tồn tại");
			} else {
				String updateSql = "UPDATE NhaCungCap SET tenNhaCungCap = ?, diaChi = ?, thongTinLienHe = ? WHERE maNhaCungCap = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, ncc.getTenNhaCungCap());
		        updateStmt.setString(2, ncc.getDiaChi());
		        updateStmt.setString(3, ncc.getThongTinLienHe());
		        updateStmt.setString(4, ncc.getMaNhaCungCap());
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
