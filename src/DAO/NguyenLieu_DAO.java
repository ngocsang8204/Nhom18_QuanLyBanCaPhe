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
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	public int getSLNL(){
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select count(*) from NguyenLieu";
			PreparedStatement stmt= con.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<NguyenLieu_Entity> danhSachNguyenLieuConHan(){
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
	
	public String[] danhSachNguyenLieuTheoTen(){
		khoiTao();
		ArrayList<String> dsNL = new ArrayList<>();
		String[] ds= new String[0];
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select tenNguyenLieu from NguyenLieu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ten = rs.getString(1);
				
				dsNL.add(ten);
			}
			ds=dsNL.stream().toArray(String[]::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public NguyenLieu_Entity getNLTheoTen(String a) {
		
		khoiTao();
		String sql="select * from nguyenlieu where tennguyenlieu like ?";
		NguyenLieu_Entity nl= new NguyenLieu_Entity();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setString(1, a);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				nl= new NguyenLieu_Entity(rs.getNString(1), rs.getNString(2), rs.getInt(3), rs.getTimestamp(4).toLocalDateTime(), 
						rs.getTimestamp(5).toLocalDateTime(), new NhaCungCap_Entity(rs.getNString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nl;
	}
	public NguyenLieu_Entity timNguyenLieuTheoMa (String ma) {
		khoiTao();
		ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
		return dsNL.stream().filter(x -> x.getMaNguyenLieu().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<NguyenLieu_Entity> timNguyenLieuTheoTen (String ten){
		ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
		return dsNL.stream().filter(x -> x.getTenNguyenLieu().matches(".*" + ten +  ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public boolean themNguyenLieu (NguyenLieu_Entity nguyenLieu) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<NguyenLieu_Entity> dsDV = danhSachNguyenLieu();
	    	if (dsDV.contains(nguyenLieu)) {
	    		System.out.println("Nguyên liệu đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO NguyenLieu(maNguyenLieu, tenNguyenLieu, soLuong, thoiGianNhapHang, thoiGianHetHan, maNhaCungCap, trangThaiNguyenLieu) VALUES (?, ?, ?, ?, ?, ?,1)";
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
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
			if (!dsNL.contains(nguyenLieu)) {
				System.out.println("Nguyên liệu không tồn tại");
			} else {
				String updateSql = "UPDATE NguyenLieu SET tenNguyenLieu = ?, soLuong = ?, thoiGianNhapHang = ?, thoiGianHetHan = ?, manhacungcap = ?, trangThaiNguyenLieu = ? WHERE maNguyenLieu = ?";
		        PreparedStatement stmt = connection.prepareStatement(updateSql);
		        stmt.setString(1, nguyenLieu.getTenNguyenLieu());
	    		stmt.setInt(2, nguyenLieu.getSoLuong());
	    		stmt.setTimestamp(3, Timestamp.valueOf(nguyenLieu.getThoiGianNhap()));
	    		stmt.setTimestamp(4, Timestamp.valueOf(nguyenLieu.getThoiGianHetHan()));
	    		stmt.setString(5, nguyenLieu.getNhaCungCap().getMaNhaCungCap());

		        stmt.setInt(6, nguyenLieu.getTrangThai());
		        stmt.setString(7, nguyenLieu.getMaNguyenLieu());
		        
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
	public boolean capNhatSoLuong (String maNL, int soluong) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<NguyenLieu_Entity> dsNL = danhSachNguyenLieu();
			
				String updateSql = "UPDATE NguyenLieu SET soLuong = ? WHERE maNguyenLieu = ?";
		        PreparedStatement stmt = connection.prepareStatement(updateSql);
		        stmt.setInt(1, soluong);
	    		stmt.setString(2, maNL);
	    		
		        
		        int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	public static void main(String[] args) {
		NguyenLieu_DAO dao= new NguyenLieu_DAO();
		System.out.println(dao.getNLTheoTen("Nước cam"));
	}
}
