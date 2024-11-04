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
		khoiTao();
	}
	
	public void khoiTao() {
	    try {
	        con = database.getInstance().getConnection(); // Khởi tạo kết nối và gán cho biến con
	        if (con == null) {
	            System.out.println("Không thể kết nối cơ sở dữ liệu");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
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
	    		stmt.setString(1, nhanVien.getMaNhanVien());
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
        boolean isSuccess = false;
        PreparedStatement updateStmt = null;

        try {
            ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
            // Kiểm tra xem nhân viên có tồn tại không
            if (!dsNV.stream().anyMatch(nv -> nv.getMaNhanVien().equals(nhanVien.getMaNhanVien()))) {
                System.out.println("Nhân viên không tồn tại");
                return false;
            } else {
                String updateSql = "UPDATE NhanVien SET tenNhanVien = ?, soCCCD = ?, soDienThoai = ?, diaChi = ?, chucVu = ? WHERE maNhanVien = ?";
                updateStmt = con.prepareStatement(updateSql);
                updateStmt.setString(1, nhanVien.getTenNhanVien());
                updateStmt.setString(2, nhanVien.getSoCCCD());
                updateStmt.setString(3, nhanVien.getSoDienThoai());
                updateStmt.setString(4, nhanVien.getDiaChi());
                updateStmt.setBoolean(5, nhanVien.getChucVu());
                updateStmt.setString(6, nhanVien.getMaNhanVien()); // Gán mã nhân viên cần cập nhật
                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    isSuccess = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (updateStmt != null) {
                try {
                    updateStmt.close(); // Đóng PreparedStatement
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }
	
	public String getMaxMaNhanVien() {
	    String maNV = "";
	    
	    if (con == null) {
	        System.out.println("Chưa có kết nối cơ sở dữ liệu");
	        return maNV;
	    }
	    
	    try (PreparedStatement stm = con.prepareStatement(
	            "SELECT TOP 1 maNhanVien FROM NhanVien ORDER BY maNhanVien DESC")) {
	        
	        ResultSet rs = stm.executeQuery();
	        if (rs.next()) {
	            maNV = rs.getString("maNhanVien");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return maNV;
	}



}
