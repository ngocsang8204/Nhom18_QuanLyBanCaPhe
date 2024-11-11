package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

	public static void khoiTao() {
		try {
			database.getInstance().Connect();
			;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ArrayList<NhanVien_Entity> danhSachNhanVien() {
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
		ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
		return dsNV.stream().filter(x -> x.getMaNhanVien().equals(maNhanVien)).findFirst().orElse(null);
	}

	public ArrayList<NhanVien_Entity> timNhanVienTheoTen(String ten) {
		ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
		return dsNV.stream().filter(x -> x.getTenNhanVien().matches(".*" + ".*"))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public NhanVien_Entity timNhanVienTheoSoDienThoai(String soDT) {
		ArrayList<NhanVien_Entity> dsNV = danhSachNhanVien();
		return dsNV.stream().filter(x -> x.getSoDienThoai().equals(soDT)).findFirst().orElse(null);
	}

	public boolean themNhanVien(NhanVien_Entity nhanVien) {
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
		con= database.getInstance().getConnection();
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

	public int getSLNhanVien() {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		String sql= "Select count(*) from NhanVien";
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

	public List<String> getAllNhanVien() {
		List<String> maNhanVien = new ArrayList<>();
		try {
			con = database.getInstance().getConnection();
			stm = con.prepareStatement("SELECT maNhanVien FROM NhanVien");
			rs = stm.executeQuery();
			while (rs.next()) {
				maNhanVien.add(rs.getString("maNhanVien"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maNhanVien;

	}

}
