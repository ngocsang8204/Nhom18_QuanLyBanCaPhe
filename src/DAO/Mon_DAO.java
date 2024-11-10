package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.Mon_Entity;
import Entity.NguyenLieu_Entity;
import Entity.HoaDon_Entity;

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
	public ArrayList<Object[]> thongKe5MonBanChayNhatTheoNgay(Date ngayChon) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }
	        
	        // Chuyển đổi từ Date sang định dạng yyyy-MM-dd
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormat.format(ngayChon);
	        
	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE CONVERT(DATE, hd.ngayLap) = ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon DESC";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, formattedDate); // Sử dụng ngày đã chọn
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Object[] mon = {rs.getNString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}
	
	public ArrayList<Object[]> thongKe5MonKhongBanChayNhatTheoNgay(Date ngayChon) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }
	        
	        // Chuyển đổi từ Date sang định dạng yyyy-MM-dd
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormat.format(ngayChon);
	        
	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE CONVERT(DATE, hd.ngayLap) = ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon ASC";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, formattedDate); // Sử dụng ngày đã chọn
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Object[] mon = {rs.getNString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}
	
	public ArrayList<Object[]> thongKe5MonBanChayNhatTheoThang(int Thang, int Nam) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }

	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon DESC";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, Thang); // Sử dụng tháng đã chọn
	        stmt.setInt(2, Nam);   // Sử dụng năm đã chọn
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Object[] mon = {rs.getString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}

	
	public ArrayList<Object[]> thongKe5MonKhongBanChayNhatTheoThang(int Thang, int Nam) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }

	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon ASC";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, Thang); // Sử dụng tháng đã chọn
	        stmt.setInt(2, Nam);   // Sử dụng năm đã chọn
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Object[] mon = {rs.getString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}

	public ArrayList<Object[]> thongKe5MonBanChayNhatTheoNam(int Nam) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }

	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE YEAR(hd.ngayLap) = ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon DESC";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, Nam); 
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Object[] mon = {rs.getString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}

	
	public ArrayList<Object[]> thongKe5MonKhongBanChayNhatTheoNam(int Nam) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }

	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE YEAR(hd.ngayLap) = ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon ASC";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, Nam); // Sử dụng tháng đã chọn
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Object[] mon = {rs.getString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}

	public ArrayList<Object[]> thongKe5MonBanChayNhatTheoKhoangNgay(Date ngayBD, Date ngayKT) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }
	        
	        // Chuyển đổi từ Date sang định dạng yyyy-MM-dd
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedNgayBD = dateFormat.format(ngayBD);
	        String formattedNgayKT = dateFormat.format(ngayKT);
	        
	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE hd.ngayLap >= ? and hd.ngayLap <= ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon DESC";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, formattedNgayBD);
	        stmt.setString(2, formattedNgayKT);// Sử dụng ngày đã chọn
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Object[] mon = {rs.getNString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}
	
	public ArrayList<Object[]> thongKe5MonKhongBanChayNhatTheoKhoangNgay(Date ngayBD, Date ngayKT) {
	    khoiTao();
	    ArrayList<Object[]> ds5MonBanChay = new ArrayList<>();
	    try {
	        Connection con = database.getInstance().getConnection();
	        if (con == null) {
	            System.out.println("Connection is not established.");
	        }
	        
	        // Chuyển đổi từ Date sang định dạng yyyy-MM-dd
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedNgayBD = dateFormat.format(ngayBD);
	        String formattedNgayKT = dateFormat.format(ngayKT);
	        
	        // Chỉnh sửa SQL với khoảng trắng và sử dụng ngày hiện tại
	        String sql = "SELECT TOP 5 m.tenMon, SUM(ctdh.soLuongMon) AS soLuongMon "
	                   + "FROM HoaDon hd "
	                   + "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon "
	                   + "JOIN Mon m ON m.maMon = ctdh.maMon "
	                   + "WHERE hd.ngayLap >= ? and hd.ngayLap <= ? "
	                   + "GROUP BY m.tenMon "
	                   + "ORDER BY soLuongMon ASC";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, formattedNgayBD);
	        stmt.setString(2, formattedNgayKT);// Sử dụng ngày đã chọn
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Object[] mon = {rs.getNString(1), rs.getInt(2)};
	            ds5MonBanChay.add(mon);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ds5MonBanChay;
	}

	public static void main(String[] args) {
		Mon_DAO dao= new Mon_DAO();
		LocalDate today = LocalDate.now();
		int thang = today.getMonthValue();
		int nam = today.getYear();
		System.out.println(thang +"+"+ nam);
		ArrayList<Mon_Entity> ds= dao.danhSachMonTheoLoai("Cà phê");

		ArrayList<Object[]> ds6 = dao.thongKe5MonBanChayNhatTheoNam(nam);
		
		if (ds6.isEmpty()) {
	        System.out.println("No top-selling items found.");
	    } else {
	        System.out.println("Top 5 best-selling items:");
	        ds6.forEach(item -> {
	            String tenMon = (String) item[0];
	            int soLuong = (int) item[1];
	            System.out.println("Tên món: " + tenMon + ", Số lượng bán ra: " + soLuong);
	        });
	    }
		if(ds==null) System.out.println("Aaa");
		ds.forEach(x->{
			System.out.println(x.toString());
			
		});
		
	}
	
	
}
