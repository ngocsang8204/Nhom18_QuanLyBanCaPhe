package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Ban_DAO;
import DAO.ChiTietDonHang_DAO;
import DAO.ChiTietMon_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.Mon_DAO;
import DAO.NguyenLieu_DAO;
import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.Ban_Entity;
import Entity.ChiTietDonHang_Entity;
import Entity.ChiTietMon_Entity;
import Entity.HoaDon_Entity;
import Entity.KhachHang_Entity;
import Entity.Mon_Entity;
import Entity.NguyenLieu_Entity;
import Entity.NhanVien_Entity;
import Entity.TaiKhoan_Entity;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TrangChu extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JPanel trangChu;
	private JButton btnTrangChu;
	private JPanel quanLy;
	private JButton btnQuanLy;
	private JPanel thongKe;
	private JButton btnThongKe;
	private JPanel hoaDon;
	private JButton btnHoaDon;
	private JPanel header;
	private JPanel caiDat;
	private JButton btnCaiDat;
	private JPanel main;
	private JPanel left_main;
	private JPanel right_main;
	private JPanel north_l;
	private JPanel left_main_header;
	private JPanel left_main_btn;
	private JLabel l_main_header;
	private JButton btnCafe;
	private JButton btnDaXay;
	private JButton btnTra;
	private JButton btnSoda;
	private JButton btnKhac;
	private JButton btnBanh;
	private JPanel ban;
	private JButton btnBan;
	private JPanel cen_l;
	private JPanel right_header;
	private JPanel lab_head;
	private JLabel right_lab;
	private JPanel tenKH;
	private JLabel ten_lab;
	private JTextField tfTenKH;
	private JPanel soDT;
	private JLabel soDT_lab;
	private JTextField tfSoDT;
	private JPanel r_main;
	private JTable table;
	private JPanel datHang;
	private JButton btnThanhToan;
	private JPanel paneTrong_1;
	private JPanel paneTrong_2;
	private Mon_DAO mon_dao = new Mon_DAO();
	private JPanel body;
	private JPopupMenu manageMenu;
	private DefaultTableModel model;
	private DefaultTableModel model_1;
	private JTable table_1;
	private JPanel n_pane;
	private JPanel s_pane;
	private JButton themMon;
	private JPanel pane_1;
	private JPanel pane_2;
	private JPanel pane_3;
	private JPanel pane_4;
	private JButton btnTatCa;
	private JPanel ban_gg;
	private JPanel pane_l;
	private JPanel pane_r;
	private JLabel giamGia_lab;
	private JComboBox<String> tGiamGia;
	private JLabel ban_lab;
	private JComboBox<String> banTrong;
	private JPanel maMon_pane;
	private JLabel maMon_lab;
	private JTextField tMaMon;
	private JPanel tenMon_pane;
	private JLabel tenMon_lab;
	private JTextField tTenMon;
	private JPanel giaTien_pane;
	private JLabel giaTien_lab;
	private JTextField tGiaTien;
	private JPanel soLuong_pane;
	private JLabel soLuong_lab;
	private JTextField tSoLuong;
	private double tongTien = 0;
	private JButton suaMon;
	private int row = -1;
	private int row_dat = -1;
	private JButton btnXoaTrang;
	private Ban_DAO ban_dao = new Ban_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private ChiTietDonHang_DAO ctdh_dao = new ChiTietDonHang_DAO();
	private ChiTietMon_DAO ctm_dao= new ChiTietMon_DAO();
	private NguyenLieu_DAO nl_dao= new NguyenLieu_DAO();
	private JButton btnHuy;
	private String maNV;
	private JPopupMenu manageMenu2;
	private JButton btnTimKiemTenKHTheoSDT;
	private JLabel logo;

	public TrangChu(TaiKhoan_Entity taiKhoan) {
		maNV = taiKhoan.getNhanVien().getMaNhanVien();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setTitle("Quản lý quán cà phê");
		// setSize(new Dimension(1920, 1080));
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(255, 255, 255));
		navbar.setBorder(new EmptyBorder(0, 5, 0, 20));
		contentPane.add(navbar, BorderLayout.WEST);
		navbar.setLayout(new BoxLayout(navbar, BoxLayout.Y_AXIS));

		paneTrong_1 = new JPanel();
		paneTrong_1.setLayout(new FlowLayout());
		paneTrong_1.setBackground(new Color(24, 28, 20));
		navbar.add(paneTrong_1);
		
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(TrangChu.class.getResource("/img/logo.png")));
		paneTrong_1.add(logo);
		body = new JPanel();
		body.setLayout(new BorderLayout());
		contentPane.add(body, BorderLayout.CENTER);
		

		trangChu = new JPanel();
		trangChu.setBackground(new Color(24, 28, 20));
		navbar.add(trangChu);
		trangChu.setLayout(new BorderLayout(0, 0));

		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setForeground(new Color(255, 255, 255));
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-home-30.png")));
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setContentAreaFilled(false);
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setBorderPainted(false);
		trangChu.add(btnTrangChu);

		ban = new JPanel();
		ban.setBackground(new Color(24, 28, 20));
		navbar.add(ban);
		ban.setLayout(new BorderLayout(0, 0));

		btnBan = new JButton("Bàn");
		btnBan.setForeground(new Color(255, 255, 255));
		btnBan.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-table-30.png")));
		btnBan.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBan.setContentAreaFilled(false);
		btnBan.setHorizontalAlignment(SwingConstants.LEFT);
		btnBan.setBorderPainted(false);
		ban.add(btnBan);

		quanLy = new JPanel();
		quanLy.setBackground(new Color(24, 28, 20));
		navbar.add(quanLy);
		quanLy.setLayout(new BorderLayout(0, 0));

		btnQuanLy = new JButton("Quản lý");
		btnQuanLy.setForeground(new Color(255, 255, 255));
		btnQuanLy.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-manage-30.png")));
		btnQuanLy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuanLy.setContentAreaFilled(false);
		btnQuanLy.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLy.setBorderPainted(false);
		quanLy.add(btnQuanLy);

		manageMenu = new JPopupMenu();
		manageMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		JMenuItem accountItem = createSubmenuItem("Tài khoản");
		JMenuItem employeeItem = createSubmenuItem("Nhân viên");
		JMenuItem customerItem = createSubmenuItem("Khách Hàng");
		JMenuItem productItem = createSubmenuItem("Món");
		JMenuItem ingredientItem = createSubmenuItem("Nguyên liệu");
		JMenuItem supplierItem = createSubmenuItem("Nhà cung cấp");

		manageMenu.add(accountItem);
		manageMenu.add(employeeItem);
		manageMenu.add(customerItem);
		manageMenu.add(productItem);
		manageMenu.add(ingredientItem);
		manageMenu.add(supplierItem);

		accountItem.addActionListener(e -> handleSubmenuSelection("account"));
		employeeItem.addActionListener(e -> handleSubmenuSelection("employee"));
		customerItem.addActionListener(e -> handleSubmenuSelection("customer"));
		productItem.addActionListener(e -> handleSubmenuSelection("product"));
		ingredientItem.addActionListener(e -> handleSubmenuSelection("ingredient"));
		supplierItem.addActionListener(e -> handleSubmenuSelection("supplier"));

		thongKe = new JPanel();
		thongKe.setBackground(new Color(24, 28, 20));
		navbar.add(thongKe);
		thongKe.setLayout(new BorderLayout(0, 0));

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-statistic-30.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setBorderPainted(false);
		thongKe.add(btnThongKe);

		hoaDon = new JPanel();
		hoaDon.setBackground(new Color(24, 28, 20));
		navbar.add(hoaDon);
		hoaDon.setLayout(new BorderLayout(0, 0));

		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setForeground(new Color(255, 255, 255));
		btnHoaDon.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-bill-30.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setBorderPainted(false);
		hoaDon.add(btnHoaDon);

		caiDat = new JPanel();
		caiDat.setBackground(new Color(24, 28, 20));
		navbar.add(caiDat);
		caiDat.setLayout(new BorderLayout(0, 0));

		btnCaiDat = new JButton("Cài đặt");
		btnCaiDat.setForeground(new Color(255, 255, 255));
		btnCaiDat.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-setting-30.png")));
		btnCaiDat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCaiDat.setContentAreaFilled(false);
		btnCaiDat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCaiDat.setBorderPainted(false);
		caiDat.add(btnCaiDat);
		
		manageMenu2 = new JPopupMenu();
		manageMenu2.setBorder(new EmptyBorder(0, 0, 0, 0));
		JMenuItem info = createSubmenuItem("Thông tin cá nhân");
		JMenuItem logout = createSubmenuItem("Đăng xuất");
		
		info.addActionListener(e -> handleSubmenuSelection("info"));
		logout.addActionListener(e -> handleSubmenuSelection("logout"));

		paneTrong_2 = new JPanel();
		paneTrong_2.setBackground(new Color(24, 28, 20));
		navbar.add(paneTrong_2);
		paneTrong_2.setLayout(new BorderLayout(0, 0));

		header = new JPanel();
		header.setBackground(new Color(255, 255, 255));
		contentPane.add(header, BorderLayout.NORTH);
		
		

		main = new JPanel();
		body.add(main, BorderLayout.CENTER);
		main.setLayout(new GridLayout(0, 2, 0, 0));

		left_main = new JPanel();
		main.add(left_main);
		left_main.setLayout(new BorderLayout(0, 0));

		north_l = new JPanel();
		left_main.add(north_l, BorderLayout.NORTH);
		north_l.setLayout(new BoxLayout(north_l, BoxLayout.Y_AXIS));

		left_main_header = new JPanel();
		left_main_header.setBackground(new Color(255, 255, 255));
		left_main_header.setBorder(new EmptyBorder(10, 0, 10, 0));
		north_l.add(left_main_header);
		left_main_header.setLayout(new BorderLayout(0, 0));

		l_main_header = new JLabel("MENU");
		l_main_header.setFont(new Font("Tahoma", Font.BOLD, 30));
		left_main_header.add(l_main_header);

		left_main_btn = new JPanel();
		left_main_btn.setBackground(new Color(255, 255, 255));
		left_main_btn.setBorder(new EmptyBorder(20, 0, 10, 0));
		north_l.add(left_main_btn);

		btnCafe = new JButton("CÀ PHÊ");
		btnCafe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnCafe);

		btnDaXay = new JButton("ĐÁ XAY");
		btnDaXay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnDaXay);

		btnTra = new JButton("TRÀ SỮA");
		btnTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnTra);

		btnSoda = new JButton("SINH TỐ");
		btnSoda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnSoda);

		btnKhac = new JButton("THỨC UỐNG KHÁC");
		btnKhac.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnKhac);

		btnBanh = new JButton("BÁNH");
		btnBanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnBanh);

		btnTatCa = new JButton("TẤT CẢ");
		btnTatCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnTatCa);

		cen_l = new JPanel();
		cen_l.setBackground(new Color(255, 255, 255));
		left_main.add(cen_l, BorderLayout.CENTER);

		JPanel dsMon = new JPanel();
		String[] colNames1 = { "Mã món", "Tên món", "Loại món", "Giá tiền" };
		model_1 = new DefaultTableModel(colNames1, 0);
		table_1 = new JTable(model_1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table_1.setShowGrid(true);
		table_1.setRowHeight(30);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		table_1.getTableHeader().setResizingAllowed(false);
		cen_l.setLayout(new BoxLayout(cen_l, BoxLayout.Y_AXIS));
		dsMon.setLayout(new BorderLayout());
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scr_chinh = new JScrollPane(table_1);
		scr_chinh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		dsMon.add(scr_chinh);
		cen_l.add(dsMon);
		table_1.addMouseListener(this);

		JPanel chonMon = new JPanel();
		chonMon.setLayout(new BorderLayout());

		cen_l.add(chonMon);

		n_pane = new JPanel();
		chonMon.add(n_pane, BorderLayout.CENTER);
		n_pane.setLayout(new GridLayout(2, 2, 0, 0));

		pane_1 = new JPanel();
		pane_1.setBorder(new EmptyBorder(0, 20, 0, 20));
		pane_1.setBackground(new Color(255, 255, 255));
		n_pane.add(pane_1);
		pane_1.setLayout(new BorderLayout(0, 0));

		maMon_pane = new JPanel();
		maMon_pane.setBackground(new Color(255, 255, 255));
		maMon_pane.setBorder(new EmptyBorder(50, 0, 0, 0));
		pane_1.add(maMon_pane, BorderLayout.NORTH);
		maMon_pane.setLayout(new BoxLayout(maMon_pane, BoxLayout.X_AXIS));

		maMon_lab = new JLabel("Mã món: ");
		maMon_lab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		maMon_pane.add(maMon_lab);

		tMaMon = new JTextField();
		tMaMon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tMaMon.setEditable(false);
		maMon_pane.add(tMaMon);
		tMaMon.setColumns(10);

		pane_2 = new JPanel();
		pane_2.setBorder(new EmptyBorder(0, 20, 0, 20));
		pane_2.setBackground(new Color(255, 255, 255));
		n_pane.add(pane_2);
		pane_2.setLayout(new BorderLayout(0, 0));

		tenMon_pane = new JPanel();
		tenMon_pane.setBackground(new Color(255, 255, 255));
		tenMon_pane.setBorder(new EmptyBorder(50, 0, 0, 0));
		pane_2.add(tenMon_pane, BorderLayout.NORTH);
		tenMon_pane.setLayout(new BoxLayout(tenMon_pane, BoxLayout.X_AXIS));

		tenMon_lab = new JLabel("Tên món: ");
		tenMon_lab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tenMon_pane.add(tenMon_lab);

		tTenMon = new JTextField();
		tTenMon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tTenMon.setEditable(false);
		tenMon_pane.add(tTenMon);
		tTenMon.setColumns(10);

		pane_3 = new JPanel();
		pane_3.setBorder(new EmptyBorder(0, 20, 0, 20));
		pane_3.setBackground(new Color(255, 255, 255));
		n_pane.add(pane_3);
		pane_3.setLayout(new BorderLayout(0, 0));

		giaTien_pane = new JPanel();
		giaTien_pane.setBorder(new EmptyBorder(50, 0, 0, 0));
		giaTien_pane.setBackground(new Color(255, 255, 255));
		pane_3.add(giaTien_pane, BorderLayout.NORTH);
		giaTien_pane.setLayout(new BoxLayout(giaTien_pane, BoxLayout.X_AXIS));

		giaTien_lab = new JLabel("Giá tiền: ");
		giaTien_lab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		giaTien_pane.add(giaTien_lab);

		tGiaTien = new JTextField();
		tGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tGiaTien.setEditable(false);
		giaTien_pane.add(tGiaTien);
		tGiaTien.setColumns(10);

		pane_4 = new JPanel();
		pane_4.setBorder(new EmptyBorder(0, 20, 0, 20));
		pane_4.setBackground(new Color(255, 255, 255));
		n_pane.add(pane_4);
		pane_4.setLayout(new BorderLayout(0, 0));

		soLuong_pane = new JPanel();
		soLuong_pane.setBorder(new EmptyBorder(50, 0, 0, 0));
		soLuong_pane.setBackground(new Color(255, 255, 255));
		pane_4.add(soLuong_pane, BorderLayout.NORTH);
		soLuong_pane.setLayout(new BoxLayout(soLuong_pane, BoxLayout.X_AXIS));

		soLuong_lab = new JLabel("Số lượng:");
		soLuong_lab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		soLuong_pane.add(soLuong_lab);

		tSoLuong = new JTextField();
		tSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		soLuong_pane.add(tSoLuong);
		tSoLuong.setText("1");
		tSoLuong.setColumns(10);

		s_pane = new JPanel();
		s_pane.setBackground(new Color(255, 255, 255));
		chonMon.add(s_pane, BorderLayout.SOUTH);

		themMon = new JButton("THÊM MÓN");
		themMon.setFont(new Font("Tahoma", Font.BOLD, 20));
		s_pane.add(themMon);

		suaMon = new JButton("SỬA MÓN");
		suaMon.setFont(new Font("Tahoma", Font.BOLD, 20));
		s_pane.add(suaMon);

		btnXoaTrang = new JButton("XOÁ TRẮNG");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 20));
		s_pane.add(btnXoaTrang);

		right_main = new JPanel();
		main.add(right_main);
		right_main.setLayout(new BorderLayout());

		right_header = new JPanel();
		right_main.add(right_header, BorderLayout.NORTH);
		right_header.setLayout(new BoxLayout(right_header, BoxLayout.Y_AXIS));

		lab_head = new JPanel();
		lab_head.setBackground(new Color(255, 255, 255));
		right_header.add(lab_head);

		right_lab = new JLabel("Giỏ hàng");
		right_lab.setHorizontalAlignment(SwingConstants.CENTER);
		right_lab.setFont(new Font("Tahoma", Font.BOLD, 30));
		lab_head.add(right_lab);

		tenKH = new JPanel();
		tenKH.setBackground(new Color(255, 255, 255));
		tenKH.setBorder(new EmptyBorder(20, 40, 10, 40));
		right_header.add(tenKH);
		tenKH.setLayout(new BoxLayout(tenKH, BoxLayout.X_AXIS));

		ten_lab = new JLabel("Tên khách hàng:");
		ten_lab.setFont(new Font("Tahoma", Font.BOLD, 15));
		tenKH.add(ten_lab);

		tenKH.add(Box.createHorizontalStrut(100));

		tfTenKH = new JTextField();
		tfTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tenKH.add(tfTenKH);

		soDT = new JPanel();
		soDT.setBackground(new Color(255, 255, 255));
		soDT.setBorder(new EmptyBorder(10, 40, 20, 40));
		right_header.add(soDT);
		soDT.setLayout(new BoxLayout(soDT, BoxLayout.X_AXIS));

		soDT_lab = new JLabel("Số điện thoại:");
		soDT_lab.setFont(new Font("Tahoma", Font.BOLD, 15));
		soDT.add(soDT_lab);
		soDT_lab.setPreferredSize(ten_lab.getPreferredSize());

		soDT.add(Box.createHorizontalStrut(100));

		tfSoDT = new JTextField();
		tfSoDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimKiemTenKHTheoSDT = new JButton();
		btnTimKiemTenKHTheoSDT.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-search-30.png")));
		soDT.add(tfSoDT);
		soDT.add(btnTimKiemTenKHTheoSDT);
		
		
		tfSoDT.setPreferredSize(new Dimension(40,41));
		tfTenKH.setPreferredSize(new Dimension(40,41));
		btnTimKiemTenKHTheoSDT.setPreferredSize(new Dimension(41,41));
		btnTimKiemTenKHTheoSDT.addActionListener(this);

		r_main = new JPanel();
		r_main.setBorder(new EmptyBorder(40, 40, 40, 40));
		r_main.setBackground(new Color(255, 255, 255));
		right_main.add(r_main, BorderLayout.CENTER);

		String[] colnames = { "Mã món", "Tên món", "Đơn giá", "Số lượng", "Giá tiền" };
		model = new DefaultTableModel(colnames, 0);
		r_main.setLayout(new BoxLayout(r_main, BoxLayout.Y_AXIS));
		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setShowGrid(true);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getTableHeader().setResizingAllowed(false);
		JScrollPane scr = new JScrollPane(table);
		r_main.add(scr);

		ban_gg = new JPanel();
		ban_gg.setBackground(new Color(255, 255, 255));
		ban_gg.setBorder(new EmptyBorder(100, 0, 0, 0));
		r_main.add(ban_gg);
		ban_gg.setLayout(new GridLayout(0, 2, 0, 0));

		pane_l = new JPanel();
		pane_l.setBackground(new Color(255, 255, 255));
		pane_l.setBorder(new EmptyBorder(10, 10, 10, 10));
		ban_gg.add(pane_l);
		pane_l.setLayout(new BoxLayout(pane_l, BoxLayout.X_AXIS));

		giamGia_lab = new JLabel("Giảm giá: ");
		giamGia_lab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pane_l.add(giamGia_lab);

		// tGiamGia = new JComboBox<String>();
		// tGiamGia.addItem("0");
		// tGiamGia.addItem("10000");
		// tGiamGia.addItem("20000");
		// tGiamGia.addItem("50000");
		// tGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// pane_l.add(tGiamGia);
		// tGiamGia.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// capNhatTongTien(); // Gọi hàm cập nhật khi thay đổi
		// }
		// });
		tGiamGia = new JComboBox<String>();
		tGiamGia.addItem("0");
		tGiamGia.addItem("-10000 VND");
		tGiamGia.addItem("-20000 VND");
		tGiamGia.addItem("-50000 VND");
		tGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pane_l.add(tGiamGia);
		tGiamGia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				capNhatTongTien();
			}
		});

		pane_r = new JPanel();
		pane_r.setBackground(new Color(255, 255, 255));
		pane_r.setBorder(new EmptyBorder(10, 10, 10, 10));
		ban_gg.add(pane_r);
		pane_r.setLayout(new BoxLayout(pane_r, BoxLayout.X_AXIS));

		ban_lab = new JLabel("Bàn: ");
		ban_lab.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pane_r.add(ban_lab);

		banTrong = new JComboBox<String>();
		banTrong.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		pane_r.add(banTrong);

		datHang = new JPanel();
		datHang.setBorder(new EmptyBorder(20, 0, 50, 0));
		datHang.setBackground(new Color(255, 255, 255));
		right_main.add(datHang, BorderLayout.SOUTH);

		DecimalFormat df = new DecimalFormat("#.### VND");
		btnThanhToan = new JButton(df.format(tongTien));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 30));
		datHang.add(btnThanhToan);

		btnHuy = new JButton("HUỶ");
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setBackground(new Color(255, 66, 66));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 30));
		datHang.add(btnHuy);

		btnTrangChu.addActionListener(this);
		btnQuanLy.addActionListener(this);
		btnBan.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnCaiDat.addActionListener(this);
		btnThanhToan.addActionListener(this);

		btnCafe.addActionListener(this);
		btnDaXay.addActionListener(this);
		btnSoda.addActionListener(this);
		btnTra.addActionListener(this);
		btnBanh.addActionListener(this);
		btnKhac.addActionListener(this);
		btnTatCa.addActionListener(this);
		themMon.addActionListener(this);
		suaMon.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnHuy.addActionListener(this);

		themMon.setEnabled(false);
		suaMon.setEnabled(false);

		table_1.addMouseListener(this);
		table.addMouseListener(this);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		

		hienBang();
		themBanTrong();
	}

	private void themBanTrong() {
		banTrong.removeAllItems();
		banTrong.addItem("Mang đi");
		banTrong.setSelectedIndex(0);
		ArrayList<Ban_Entity> dsBan = ban_dao.timBanTheoTrangThai("Trống");
		dsBan.forEach(x -> banTrong.addItem(x.getTenBan()));
	}

	private JMenuItem createSubmenuItem(String text) {
		JMenuItem item = new JMenuItem(text);
		item.setOpaque(true);
		item.setFont(new Font("Tahoma", Font.BOLD, 17));

		return item;
	}

	// private void capNhatTongTien() {
	// double giamGia = Double.parseDouble(tGiamGia.getSelectedItem().toString());
	// double tongTienMoi = tongTien - giamGia;
	// DecimalFormat df = new DecimalFormat("#.### VND");
	// btnThanhToan.setText(String.valueOf(df.format(tongTienMoi)));
	// }

	private void capNhatTongTien() {
		double giamGia = Double.parseDouble(tGiamGia.getSelectedItem().toString().replace("-", "").replace("VND", ""));
		double tongTienMoi = tongTien - giamGia;
		DecimalFormat df = new DecimalFormat("#.### VND");
		btnThanhToan.setText(String.valueOf(df.format(tongTienMoi)));
	}

	private void hienBang() {
		model_1.getDataVector().removeAllElements();
		ArrayList<Mon_Entity> dsMon = mon_dao.danhSachMon();
		dsMon.forEach(x -> themDong(x));
	}

	private void themDong(Mon_Entity a) {
		model_1.addRow(new Object[] { a.getMaMon(),
				a.getTenMon(),
				a.getLoaiMon(),
				a.getDonGia() });
	}

	private void hienDanhSach(String ten) {
		model_1.getDataVector().removeAllElements();
		ArrayList<Mon_Entity> dsMon = mon_dao.timMonTheoLoai(ten);
		if (dsMon == null) {
			model_1.getDataVector().removeAllElements();
		} else
			dsMon.forEach(x -> themDong(x));
	}

	private void handleSubmenuSelection(String menu) {
		body.removeAll();
		switch (menu) {
			case "account":
				body.add(new QLTaiKhoan());
				break;
			case "employee":
				body.add(new QLNhanVien());
				break;
			case "customer":
				body.add(new QLKhachHang());
				break;
			case "product":
				body.add(new QLMon());
				break;
			case "ingredient":
				body.add(new QLNguyenLieu());
				break;
			case "supplier":
				body.add(new QLNhaCungCap());
				break;
		}
		body.revalidate();
		body.repaint();
	}
	private int checkMon(String maMon) {
		for(int i=0;i<table.getRowCount();i++) {
			if(table.getValueAt(i, 0).toString().equalsIgnoreCase(maMon)) {
				return i;
			}
		}
		return -1;
	}
	private int tinhSoLuongMonDuaTheoNguyenLieu(Mon_Entity mon) {
		
		ArrayList<ChiTietMon_Entity> dsCTM= ctm_dao.getDSChiTietMon(mon.getMaMon());
		NguyenLieu_Entity nl= nl_dao.timNguyenLieuTheoMa(dsCTM.get(0).getMaNguyenLieu().getMaNguyenLieu());
		int kq= nl.getSoLuong()/dsCTM.get(0).getSoLuong();
		for (ChiTietMon_Entity x : dsCTM) {
			nl= nl_dao.timNguyenLieuTheoMa(x.getMaNguyenLieu().getMaNguyenLieu());
			int temp=nl.getSoLuong()/x.getSoLuong();
			if(temp<kq) kq=temp;
		}
		return kq;
	}
	private void themMonDat() {
		try {
			
			DecimalFormat df = new DecimalFormat("#.### VND");
			Mon_Entity mon = mon_dao.timMonTheoMa(tMaMon.getText().toString());
			
			int soLuong = Integer.parseInt(tSoLuong.getText().toString());
			int rowMon=checkMon(tMaMon.getText());
			boolean NguyenLieuFlag=true;
			String dsNLThieu = "Thiếu: ";
			ArrayList<ChiTietMon_Entity> dsCTM= ctm_dao.getDSChiTietMon(tMaMon.getText().toString());
			
			//tìm các nguyên liệu của món không đủ số lượng
			for (ChiTietMon_Entity x : dsCTM) {
				int tongSL=soLuong;
				if(rowMon!=-1) {
					tongSL=soLuong+ Integer.parseInt(table.getValueAt(rowMon, 3).toString());
				}
				NguyenLieu_Entity nl= nl_dao.timNguyenLieuTheoMa(x.getMaNguyenLieu().getMaNguyenLieu());
				if(x.getSoLuong()*tongSL>nl.getSoLuong()) {
					dsNLThieu+=nl.getTenNguyenLieu()+" ; ";
					NguyenLieuFlag=false;
					
				}
			}
			//thông báo nếu không đủ nguyên liệu
			if(!NguyenLieuFlag) {
				JOptionPane.showMessageDialog(this,"Nguyên liệu chỉ đủ để làm: "+ tinhSoLuongMonDuaTheoNguyenLieu(mon)+ " "+mon.getTenMon()+"\n"
						+ dsNLThieu
						);
				return;
			}
			//cập nhật lại số lượng món đã có trong bảng
			if(rowMon!=-1) {
				int oldSoLuong = Integer.parseInt(table.getValueAt(rowMon, 3).toString());
				table.setValueAt( soLuong + oldSoLuong, rowMon, 3);
				table.setValueAt(df.format(mon.getDonGia() * (soLuong + oldSoLuong)), rowMon, 4);
			}
			//thêm dòng mới nếu món chưa được chọn
			else {
				model.addRow(new Object[] { tMaMon.getText().toString(), tTenMon.getText().toString(),
						df.format(mon.getDonGia()), tSoLuong.getText().toString(), df.format(mon.getDonGia() * soLuong) });
			}
			tongTien = tongTien + soLuong * mon.getDonGia();
			btnThanhToan.setText(df.format(tongTien));
			row = -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void suaMonDat() {
		try {
			if (row_dat >= 0) {
				Mon_Entity mon = mon_dao.timMonTheoMa(tMaMon.getText().toString());
				int soLuongCu = Integer.parseInt(model.getValueAt(row_dat, 3).toString());
				tongTien = tongTien - mon.getDonGia() * soLuongCu;
				model.removeRow(row_dat);
				themMonDat();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if (btn.equals(btnCafe)) {
			model_1.setRowCount(0);
			hienDanhSach("Cà phê");
		}

		if (btn.equals(btnTra)) {
			model_1.setRowCount(0);
			hienDanhSach("Trà sữa");
		}

		if (btn.equals(btnDaXay)) {
			model_1.setRowCount(0);
			hienDanhSach("Đá xay");
		}

		if (btn.equals(btnSoda)) {
			model_1.setRowCount(0);
			hienDanhSach("Sinh tố");
		}

		if (btn.equals(btnBanh)) {
			model_1.setRowCount(0);
			hienDanhSach("Bánh");
		}

		if (btn.equals(btnKhac)) {
			model_1.setRowCount(0);
			hienDanhSach("Thức uống khác");
		}

		if (btn.equals(btnTatCa)) {
			model_1.setRowCount(0);
			hienBang();
		}

		if (btn.equals(themMon)) {
			themMonDat();
			xoaTrang();
			table_1.clearSelection();
			themMon.setEnabled(false);
			suaMon.setEnabled(false);
		}

		if (btn.equals(btnTrangChu)) {
			body.removeAll();
			themBanTrong();
			hienBang();
			body.add(main);
			body.revalidate();
			body.repaint();
		}

		if (btn.equals(btnBan)) {
			body.removeAll();
			body.add(new Ban());
			body.revalidate();
			body.repaint();
		}

		if (btn.equals(btnQuanLy)) {
			manageMenu.show(btnQuanLy, btnQuanLy.getWidth(), btnQuanLy.getHeight() / 3);
		}

		if (btn.equals(btnThongKe)) {
			body.removeAll();
			body.add(new ThongKe());
			body.revalidate();
			body.repaint();
		}

		if (btn.equals(btnHoaDon)) {
			body.removeAll();
			body.add(new HoaDon());
			body.revalidate();
			body.repaint();
		}

		if (btn.equals(btnCaiDat)) {
			body.removeAll();
			body.add(new CaiDat());
			body.revalidate();
			body.repaint();
		}

		if (btn.equals(btnXoaTrang)) {
			xoaTrang();
		}

		if (btn.equals(suaMon)) {
			suaMonDat();
			xoaTrang();
			themMon.setEnabled(false);
			suaMon.setEnabled(false);
		}

		if (btn.equals(btnThanhToan)) {
			if(valid())
			if(thanhToan()) 
			{	
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				tongTien = 0;
				btnThanhToan.setText(String.valueOf(tongTien));
				banTrong.setSelectedIndex(0);
				tGiamGia.setSelectedIndex(0);
			}
			
		}

		if (btn.equals(btnHuy)) {
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			tongTien = 0;
			btnThanhToan.setText(String.valueOf(tongTien));
			banTrong.setSelectedIndex(0);
			tGiamGia.setSelectedIndex(0);
		}
		if (btn.equals(btnTimKiemTenKHTheoSDT)) {
			String sdt = tfSoDT.getText().trim();
			KhachHang_Entity kh= kh_dao.timKiemTenKhachHangTheoSDT(sdt);
			System.out.println(kh);
			if (kh != null) {
				System.out.println(kh.getTenKhachHang());
				tfTenKH.setText(kh.getTenKhachHang());
			}else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng này!");
				tfTenKH.setText("");
			}
			
		}
	}

	private void xoaTrang() {
		tMaMon.setText("");
		tTenMon.setText("");
		tGiaTien.setText("");
		tSoLuong.setText("1");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		row = table_1.getSelectedRow();
		row_dat = table.getSelectedRow();
		if (row >= 0) {
			themMon.setEnabled(true);
			suaMon.setEnabled(false);
			tMaMon.setText(model_1.getValueAt(row, 0).toString());
			tTenMon.setText(model_1.getValueAt(row, 1).toString());
			tGiaTien.setText(model_1.getValueAt(row, 3).toString());
		}

		if (row_dat >= 0) {
			themMon.setEnabled(false);
			suaMon.setEnabled(true);
			tMaMon.setText(model.getValueAt(row_dat, 0).toString());
			tTenMon.setText(model.getValueAt(row_dat, 1).toString());
			tGiaTien.setText(model.getValueAt(row_dat, 2).toString());
			tSoLuong.setText(model.getValueAt(row_dat, 3).toString());
		}
	}
	private boolean valid() {
		String KH= tfTenKH.getText().trim();
		String sdt= tfSoDT.getText().trim();
		if(KH.trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Tên khách hàng không được rỗng");
			return false;
		}
		else if(KH.matches("[\\p{L}]\\s"))
		{
			JOptionPane.showMessageDialog(this,"Tên khách hàng phải là chữ");
			return false;
		}
		if(table.getRowCount()<1) {
			JOptionPane.showMessageDialog(this,"Hãy chọn món");
			return false;
		}
		return true;
	}
	private void capNhatSLNguyenLieu(Mon_Entity mon, int soLuong) {
		ArrayList<ChiTietMon_Entity> dsCTM= ctm_dao.getDSChiTietMon(mon.getMaMon());
		dsCTM.forEach(x->{
			//duyệt từng nguyên liệu của món, cập nhật lại số lượng dựa theo số lượng tồn kho - số lượng trong chi tiết * số lượng món đặt
			nl_dao.capNhatSoLuong(x.getMaNguyenLieu().getMaNguyenLieu(), x.getMaNguyenLieu().getSoLuong()-(x.getSoLuong()*soLuong));
		});
	}
	private void hienHoaDon(HoaDon_Entity hd) {
	    // Tạo JDialog hiển thị chi tiết hóa đơn
	    JDialog dialog = new JDialog((JFrame) null, "Chi tiết Hóa Đơn", true);
	    dialog.getContentPane().setLayout(new BorderLayout());

	    // Tạo panel chứa thông tin hóa đơn
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    // Tiêu đề hóa đơn
	    JLabel lblTitle = new JLabel("HÓA ĐƠN");
	    lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
	    JPanel title= new JPanel();
	    title.add(lblTitle);
	   

	    // Thêm thông tin chi tiết hóa đơn vào panel
	    panel.add(new JLabel("Mã Hóa Đơn: " + hd.getMaHoaDon()));
	    panel.add(Box.createVerticalStrut(10));
	    panel.add(new JLabel("Tên Khách Hàng: " + hd.getKhachHang().getTenKhachHang()));
	    panel.add(Box.createVerticalStrut(10));
	    panel.add(new JLabel("Ngày Lập: " + hd.getNgayLap()));
	    panel.add(Box.createVerticalStrut(10));

	    // Định dạng số tiền
	    DecimalFormat df = new DecimalFormat("#,###.0 VND");

	    // Cấu hình bảng chi tiết sản phẩm
	    panel.add(new JLabel("Chi Tiết Sản Phẩm:"));
	    panel.add(Box.createVerticalStrut(10));
	    String[] columns = {"Tên món", "SL", "Đơn giá", "Thành tiền"};
	    DefaultTableModel model = new DefaultTableModel(columns, 0);
	    double tongTien=0;
	    // Thêm dữ liệu vào model
	    ArrayList<ChiTietDonHang_Entity> dsCTDH= ctdh_dao.danhSachCTDH(hd);
	    for (ChiTietDonHang_Entity cthd : dsCTDH) {
	        Object[] rowData = {
	            cthd.getMon().getTenMon(),
	            cthd.getSoLuongMon(),
	            df.format(cthd.getMon().getDonGia()),
	            df.format(cthd.getSoLuongMon() * cthd.getMon().getDonGia())
	            
	        };
	        tongTien+=cthd.getSoLuongMon() * cthd.getMon().getDonGia();
	        model.addRow(rowData);
	    }

	    // Tạo bảng với model và thêm vào JScrollPane
	    JTable table = new JTable(model);
	    table.setEnabled(false);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setPreferredSize(new Dimension(550, 300)); // Giới hạn kích thước của bảng
	    panel.add(scrollPane);
	    panel.add(Box.createVerticalStrut(10));
	    panel.add(new JLabel("Tổng tiền: "+df.format(tongTien)));
	    panel.add(Box.createVerticalStrut(30));
	    

	    // Thêm panel và nút vào dialog
	    dialog.getContentPane().add(panel, BorderLayout.CENTER);
	    dialog.getContentPane().add(title, BorderLayout.NORTH);

	    // Thiết lập kích thước và hiển thị dialog
	    dialog.setSize(600, 700);
	    dialog.setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
	    dialog.setVisible(true);
	}


	private boolean thanhToan() {
		boolean isSuccess = false;
		try {
			
			String KH= tfTenKH.getText().trim();
			String sdt= tfSoDT.getText().trim();
			KhachHang_Entity kh= kh_dao.timKiemKhachHangTheoTenVaSDT(KH, sdt);
			if(kh==null) {
				//thêm khách hàng nếu không có trong hệ thống
				kh=taoKhachHang();
				kh_dao.themKhachHang(kh);
			}
			NhanVien_Entity nv = nv_dao.timNhanVienTheoMa(maNV);
			Ban_Entity ban = new Ban_Entity();
			
			ban = ban_dao.timBanTheoTenChinhXac(banTrong.getSelectedItem().toString());
			
			double giamGia = Double
					.parseDouble(tGiamGia.getSelectedItem().toString().replace("-", "").replace("VND", ""));
			LocalDateTime ngayLap = LocalDateTime.now();
			ArrayList<HoaDon_Entity> dsHD = hd_dao.danhSachHoaDon();
			int soLuong = dsHD.size();
			String maHD =  String.format("HD%03d",soLuong+1);
			HoaDon_Entity hd = new HoaDon_Entity(maHD, ngayLap, giamGia, kh, ban, nv);
			
			if(hd_dao.themHoaDon(hd)) {
				for(int i=0;i<table.getRowCount();i++) {
					ChiTietDonHang_Entity ctdh= new ChiTietDonHang_Entity(hd, 
							mon_dao.timMonTheoMa(table.getValueAt(i, 0).toString()), 
							Integer.parseInt(table.getValueAt(i, 3).toString()));
					if(!ctdh_dao.themChiTietDonHang(ctdh)) return false;
//				cập nhật số lượng nguyên liệu
				capNhatSLNguyenLieu(mon_dao.timMonTheoMa(table.getValueAt(i, 0).toString()), Integer.parseInt(table.getValueAt(i, 3).toString()));
				if(ban!=null) {
					ban_dao.capNhatTrangThai(ban);
					themBanTrong();
				}
			}

			JOptionPane.showMessageDialog(this,"Thanh toán thành công");
			hienHoaDon(hd);	
			return true;
				
			};
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}

	private KhachHang_Entity taoKhachHang() {
		ArrayList<KhachHang_Entity> dsKH = kh_dao.danhSachKhachHang();
		String maKH = "";
		if (dsKH.size() + 1 < 10) {
			maKH = "KH00" + String.valueOf(dsKH.size() + 1);
		} else if (dsKH.size() + 1 >= 10) {
			maKH = "KH0" + String.valueOf(dsKH.size() + 1);
		}
		return new KhachHang_Entity(maKH, tfTenKH.getText().toString(), tfSoDT.getText().toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	public static void main(String[] args) {
		TaiKhoan_DAO dao= new TaiKhoan_DAO();
//		System.out.println(dao.timTaiKhoan("TK001"));
		new TrangChu(dao.timTaiKhoan("TK001")).setVisible(true);;
	}
}