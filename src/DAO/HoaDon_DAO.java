package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import ConnectDB.database;
import Entity.Ban_Entity;
import Entity.HoaDon_Entity;
import Entity.KhachHang_Entity;
import Entity.NhanVien_Entity;

public class HoaDon_DAO {
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private Ban_DAO ban_dao = new Ban_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();

	public HoaDon_DAO() {

	}

	public ArrayList<HoaDon_Entity> danhSachHoaDon() {
		ArrayList<HoaDon_Entity> dsHD = new ArrayList<HoaDon_Entity>();
		try {
			Connection con = database.getInstance().getConnection();
			if (con == null) {
				System.out.println("Connection is not established.");
			}
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				LocalDateTime ngayLap = rs.getTimestamp(2).toLocalDateTime();
				double giamGia = rs.getDouble(3);
				String maKH = rs.getString(4);
				String maBan = rs.getString(5);
				String maNV = rs.getString(6);
				KhachHang_Entity kh = kh_dao.timKiemKhachHangTheoMa(maKH);
				Ban_Entity ban = ban_dao.timBanTheoMa(maBan);
				NhanVien_Entity nv = nv_dao.timNhanVienTheoMa(maNV);
				HoaDon_Entity hd = new HoaDon_Entity(maHD, ngayLap, giamGia, kh, ban, nv);
				dsHD.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public HoaDon_Entity timKiemHoaDonTheoMa(String ma) {
		ArrayList<HoaDon_Entity> dsHD = danhSachHoaDon();
		return dsHD.stream().filter(x -> x.getMaHoaDon().equalsIgnoreCase(ma)).findFirst().orElse(null);
	}

	public boolean themHoaDon(HoaDon_Entity hd) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stmt = null;
		boolean isSuccess = false;

		try {
			String sql = "INSERT INTO HoaDon(maHoaDon, ngayLap, giamGia, maKhachHang, maBan, maNhanVien) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setTimestamp(2, Timestamp.valueOf(hd.getNgayLap()));
			stmt.setDouble(3, hd.getGiamGia());
			stmt.setString(4, hd.getKhachHang().getMaKhachHang());
			if(hd.getBan()!=null)
				stmt.setString(5,  hd.getBan().getMaBan());
			else
				stmt.setString(5,  null);
			stmt.setString(6, hd.getNhanVien().getMaNhanVien());
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public double tinhTongTienTheoThang(int thang, int nam) {
	    double tongTien = 0;
	    
	    String sql = "SELECT SUM(ctdh.soLuongMon * m.donGia) AS tongTien " +
	                 "FROM HoaDon hd " +
	                 "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon " +
	                 "JOIN Mon m ON m.maMon = ctdh.maMon " +
	                 "WHERE MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ?";
	    try {
	        Connection con = database.getInstance().getConnection();
	        PreparedStatement stmt = con.prepareStatement(sql);
	        
	        stmt.setInt(1, thang);
	        stmt.setInt(2, nam);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            tongTien = rs.getDouble("tongTien");
	        }
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return tongTien;
	}
	
	public double tinhTongTienTheoNgay(Date ngayChon) {
	    double tongTien = 0;
	    
	    String sql = "SELECT SUM(ctdh.soLuongMon * m.donGia) AS tongTien " +
	                 "FROM HoaDon hd " +
	                 "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon " +
	                 "JOIN Mon m ON m.maMon = ctdh.maMon " +
	                 "WHERE CONVERT(DATE, hd.ngayLap) = ?";
	    try {
	        Connection con = database.getInstance().getConnection();
	        PreparedStatement stmt = con.prepareStatement(sql);
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormat.format(ngayChon);
	        stmt.setString(1, formattedDate);
	        
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            tongTien = rs.getDouble("tongTien");
	        }
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return tongTien;
	}
	
	public double tinhTongTienTheoKhoangNgay(Date ngayBD, Date ngayKT) {
	    double tongTien = 0;
	    
	    String sql = "SELECT SUM(ctdh.soLuongMon * m.donGia) AS tongTien " +
	                 "FROM HoaDon hd " +
	                 "JOIN ChiTietDonHang ctdh ON hd.maHoaDon = ctdh.maHoaDon " +
	                 "JOIN Mon m ON m.maMon = ctdh.maMon " +
	                 "WHERE CONVERT(DATE, hd.ngayLap) >= ?" +
	                 "  AND CONVERT(DATE, hd.ngayLap) <= ?";
	    try {
	        Connection con = database.getInstance().getConnection();
	        PreparedStatement stmt = con.prepareStatement(sql);
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDateStart = dateFormat.format(ngayBD);
	        String formattedDateFinal = dateFormat.format(ngayKT);
	        stmt.setString(1, formattedDateStart);
	        stmt.setString(2, formattedDateFinal);
	        
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            tongTien = rs.getDouble("tongTien");
	        }
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return tongTien;
	}

	public ArrayList<HoaDon_Entity> timHoaDonTheoNgay(LocalDate ngay) {
	    ArrayList<HoaDon_Entity> danhSachHoaDonTheoNgay = new ArrayList<HoaDon_Entity>();
	    String sql = "SELECT * FROM HoaDon WHERE DAY(ngayLap) = ? AND MONTH(ngayLap) = ? AND YEAR(ngayLap) = ?";
	        try {
	        	Connection con = database.getInstance().getConnection();
		        PreparedStatement stmt = con.prepareStatement(sql);
		        int ngayLap = ngay.getDayOfMonth();
		        int thangLap = ngay.getMonthValue();
		        int namLap = ngay.getYear();

		        stmt.setInt(1, ngayLap);
		        stmt.setInt(2, thangLap);
		        stmt.setInt(3, namLap);
	        	ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                String maHD = rs.getString("maHoaDon");
	                LocalDateTime ngayLapHD = rs.getTimestamp("ngayLap").toLocalDateTime();
	                double giamGia = rs.getDouble("giamGia");
	                String maKH = rs.getString("maKhachHang");
	                String maBan = rs.getString("maBan");
	                String maNV = rs.getString("maNhanVien");

	                KhachHang_Entity kh = kh_dao.timKiemKhachHangTheoMa(maKH);
	                Ban_Entity ban = ban_dao.timBanTheoMa(maBan);
	                NhanVien_Entity nv = nv_dao.timNhanVienTheoMa(maNV);

	                HoaDon_Entity hoaDon = new HoaDon_Entity(maHD, ngayLapHD, giamGia, kh, ban, nv);
	                danhSachHoaDonTheoNgay.add(hoaDon);
	            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return danhSachHoaDonTheoNgay;
	}
	
	public static void main(String[] args) {
		
	}
}
