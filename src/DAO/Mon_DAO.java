package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.Mon_Entity;
import Entity.NguyenLieu_Entity;

public class Mon_DAO {
	public Mon_DAO() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList<Mon_Entity> danhSachMon(){
		khoiTao();
		ArrayList<Mon_Entity> dsDV = new ArrayList<Mon_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from Mon where trangThaiMon=1";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maMon = rs.getString(1);
				String tenMon = rs.getString(2);
				double giaTien = rs.getDouble(4);
				String loaiMon = rs.getString(3);
				int trangThai= rs.getInt(5);
				Mon_Entity mon = new Mon_Entity(maMon, tenMon, loaiMon, giaTien, trangThai);
				dsDV.add(mon);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	public ArrayList<Mon_Entity> danhSachMonTheoLoai(String a){
		khoiTao();
		ArrayList<Mon_Entity> dsDV = new ArrayList<Mon_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from Mon where trangThaiMon=1 and loaiMon like ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, a);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maMon = rs.getString(1);
				String tenMon = rs.getString(2);
				double giaTien = rs.getDouble(4);
				String loaiMon = rs.getString(3);
				int trangThai= rs.getInt(5);
				Mon_Entity mon = new Mon_Entity(maMon, tenMon, loaiMon, giaTien, trangThai);
				dsDV.add(mon);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	public ArrayList<Object[]> getNguyenLieuTheoMaMon(String a) {
	    khoiTao();
	    ArrayList<Object[]> dsNL = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }
	        String sql = "SELECT tenNguyenLieu, soLuongNguyenLieuTrongMon "
	                   + "FROM mon INNER JOIN chitietmon ON mon.mamon = chitietmon.mamon "
	                   + "INNER JOIN NguyenLieu ON NguyenLieu.maNguyenLieu = ChiTietMon.maNguyenLieu "
	                   + "WHERE mon.mamon LIKE ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, a);
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Object[] mon = {rs.getNString(1),rs.getInt(2)};
	            dsNL.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dsNL;
	}
	

	public Mon_Entity timMonTheoMa(String ma) {
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getMaMon().equals(ma)).findFirst().orElse(null);
	}
	
	public ArrayList<Mon_Entity> timMonTheoTen (String ten){
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getTenMon().matches(".*" + ten + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Mon_Entity> timMonTheoLoai (String loai){
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getLoaiMon().matches(".*" + loai + ".*")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Mon_Entity layMonTheoTenChinhXac (String ten) {
		ArrayList<Mon_Entity> dsMon = danhSachMon();
		return dsMon.stream().filter(x -> x.getTenMon().equalsIgnoreCase(ten)).findFirst().orElse(null);
	}
	
	
	public boolean themMon(Mon_Entity mon) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<Mon_Entity> dsMon = danhSachMon();
	    	if (dsMon.contains(mon)) {
	    		System.out.println("Món đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO Mon(maMon, tenMon, loaiMon, donGia,trangThaiMon) VALUES (?, ?, ?, ?,?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "M00" + String.valueOf(dsMon.size() + 1));
	    		stmt.setString(2, mon.getTenMon());
	    		stmt.setDouble(4, mon.getDonGia());
	    		stmt.setString(3, mon.getLoaiMon());
	    		stmt.setInt(5, mon.getTrangThai());
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
	public boolean deleteChiTietMon(String a) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
		String sql= "delete from chitietmon where mamon like ?";
		try {
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setString(1, a);
			int row =stmt.executeUpdate();
			return row>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean themChiTietMon(Mon_Entity mon, NguyenLieu_Entity nl, int soluong) {
		Connection con = database.getInstance().getConnection();
		String sql= "insert chitietmon "
				+ "values(?,?,?)";
		try {
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setString(1, mon.getMaMon());
			stmt.setString(2,nl.getMaNguyenLieu());
			stmt.setInt(3, soluong);
			int row = stmt.executeUpdate();
			return row>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean suaMon(Mon_Entity mon) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<Mon_Entity> dsDV = danhSachMon();
			if (!dsDV.contains(mon)) {
				System.out.println("Món không tồn tại");
			} else {
				String updateSql = "UPDATE Mon SET tenMon = ?, loaiMon = ?, donGia = ? WHERE maMon = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, mon.getTenMon());
		        updateStmt.setString(2, mon.getLoaiMon());
		        updateStmt.setDouble(3, mon.getDonGia());
		        updateStmt.setString(4, mon.getMaMon());
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
	public boolean xoaMon(String maMon) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<Mon_Entity> dsDV = danhSachMon();
			
				String updateSql = "UPDATE Mon SET trangthaimon=0 WHERE maMon = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, maMon);
		        int rowsInserted = updateStmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	public int getSLMon() {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		String sql= "Select count(*) from mon";
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
	public static void main(String[] args) {
		Mon_DAO dao= new Mon_DAO();
		ArrayList<Mon_Entity> ds= dao.danhSachMonTheoLoai("Cà phê");
		if(ds==null) System.out.println("Aaa");
		ds.forEach(x->{
			System.out.println(x.toString());
		});
	}
}
