package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.NhanVien_Entity;

public class NhanVien_DAO {
	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;

	public NhanVien_DAO() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<NhanVien_Entity> danhSachNhanVien(){
		khoiTao();
		ArrayList<NhanVien_Entity> dsNV = new ArrayList<NhanVien_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String cccd = rs.getString(3);
				String soDT = rs.getString(4);
				String diaChi = rs.getString(5);
				boolean chucVu = rs.getBoolean(6);
				NhanVien_Entity nv = new NhanVien_Entity(maNV, tenNV, cccd, soDT, diaChi, chucVu);
				dsNV.add(nv);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public NhanVien_Entity timNhanVienTheoMa(String maNhanVien) {
	    try {
	        Connection con = database.getInstance().getConnection();
	        String sql = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, maNhanVien);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String tenNV = rs.getString("tenNhanVien");
	            String soCCCD = rs.getString("soCCCD");
	            String soDienThoai = rs.getString("soDienThoai");
	            String diaChi = rs.getString("diaChi");
	            boolean chucVu = rs.getBoolean("chucVu");

	            // Khởi tạo đối tượng NhanVien_Entity với các thông tin lấy từ ResultSet
	            return new NhanVien_Entity(maNhanVien, tenNV, soCCCD, soDienThoai, diaChi, chucVu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	


	public ArrayList<NhanVien_Entity> timNhanVienTheoTen (String ten){
		ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
		return dsNV.stream().filter(x -> x.getTenNhanVien().matches(".*" + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public NhanVien_Entity timNhanVienTheoSoDienThoai (String soDT) {
		ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
		return dsNV.stream().filter(x -> x.getSoDienThoai().equals(soDT)).findFirst().orElse(null);
	}
	
	public boolean themNhanVien (NhanVien_Entity nhanVien) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
	    	if (dsNV.contains(nhanVien)) {
	    		System.out.println("Nhân viên đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO NhanVien(maNhanVien, tenNhanVien, soCCCD, soDienThoai, diaChi, chucVu) VALUES (?, ?, ?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "NV00" + String.valueOf(dsNV.size() + 1));
	    		stmt.setString(2, nhanVien.getTenNhanVien());
	    		stmt.setString(3, nhanVien.getSoCCCD());
	    		stmt.setString(4, nhanVien.getSoDienThoai());
	    		stmt.setString(5, nhanVien.getDiaChi());
	    		stmt.setBoolean(6, nhanVien.getChucVu());
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
	
	public boolean suaNhanVien(NhanVien_Entity nhanVien) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
			if (!dsNV.contains(nhanVien)) {
				System.out.println("Nhân viên không tồn tại");
			} else {
				String updateSql = "UPDATE NhanVien SET tenNhanVien = ?, soCCCD = ?, soDienThoai = ?, diaChi = ?, chucVu = ? WHERE maNhanVien = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, nhanVien.getTenNhanVien());
		        updateStmt.setString(2, nhanVien.getSoCCCD());
		        updateStmt.setString(3, nhanVien.getSoDienThoai());
		        updateStmt.setString(4, nhanVien.getDiaChi());
		        updateStmt.setBoolean(5, nhanVien.getChucVu());		        
		        updateStmt.setString(4, nhanVien.getMaNhanVien());		        
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

//	public NhanVien_Entity findById(String id) {
//        con = database.getInstance().getConnection();
//        NhanVien_Entity nhanVien = null;
//        try {
//            stm = con.prepareStatement("SELECT * FROM NhanVien WHERE maNV = ?");
//            stm.setString(1, id);
//            rs = stm.executeQuery();
//
//            if (rs.next()) {
//                String maNV = rs.getString("maNhanVien");
//                String tenNV = rs.getString("tenNhanVien");
//                String soCCCD = rs.getString("soCCCD");
//                String soDienThoai = rs.getString("soDienThoai");
//                String diaChi = rs.getString("diaChi");
//                boolean chucVu = rs.getBoolean("ChucVu");
//                nhanVien = new NhanVien_Entity(maNV, tenNV, soCCCD, soDienThoai, diaChi, chucVu);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return nhanVien;
//    }
}
