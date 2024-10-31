package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Mon_DAO;
import Entity.Mon;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.awt.FlowLayout;

public class TrangChu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel trangChu;
	private JButton btnTrangChu;
	private JPanel sanPham;
	private JButton btnSanPham;
	private JPanel nguyenLieu;
	private JButton btnNguyenLieu;
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
	private JPanel table1;
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
	private JScrollPane scrollPane_1;
	private JTable table;
	private JPanel datHang;
	private JButton btnThanhToan;
	private JPanel paneTrong_1;
	private JPanel paneTrong_2;
	private Mon_DAO mon_dao = new Mon_DAO();
	private ArrayList<Mon> dsMon;
	private JLabel lbTenMon;
	private JButton btnThem;
	private JPanel body;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setTitle("Quản lý quán cà phê");
		setSize(new Dimension(1920, 1080));
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel navbar = new JPanel();
		navbar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(navbar, BorderLayout.WEST);
		navbar.setLayout(new BoxLayout(navbar, BoxLayout.Y_AXIS));
		
		paneTrong_1 = new JPanel();
		navbar.add(paneTrong_1);
		paneTrong_1.setLayout(new BorderLayout(0, 0));
		
		body = new JPanel();
		body.setLayout(new BorderLayout());
		contentPane.add(body, BorderLayout.CENTER);
		
		trangChu = new JPanel();
		navbar.add(trangChu);
		trangChu.setLayout(new BorderLayout(0, 0));
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-home-30.png")));
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTrangChu.setContentAreaFilled(false);
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setBorderPainted(false);
		trangChu.add(btnTrangChu);
		
		ban = new JPanel();
		navbar.add(ban);
		ban.setLayout(new BorderLayout(0, 0));
		
		btnBan = new JButton("Bàn");
		btnBan.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-table-30.png")));
		btnBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBan.setContentAreaFilled(false);
		btnBan.setHorizontalAlignment(SwingConstants.LEFT);
		btnBan.setBorderPainted(false);
		ban.add(btnBan);
		
		sanPham = new JPanel();
		navbar.add(sanPham);
		sanPham.setLayout(new BorderLayout(0, 0));
		
		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-coffee-30.png")));
		btnSanPham.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSanPham.setContentAreaFilled(false);
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPham.setBorderPainted(false);
		sanPham.add(btnSanPham);
		
		nguyenLieu = new JPanel();
		navbar.add(nguyenLieu);
		nguyenLieu.setLayout(new BorderLayout(0, 0));
		
		btnNguyenLieu = new JButton("Nguyên Liệu");
		btnNguyenLieu.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-cooking-book-30.png")));
		btnNguyenLieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNguyenLieu.setHorizontalAlignment(SwingConstants.LEFT);
		btnNguyenLieu.setContentAreaFilled(false);
		btnNguyenLieu.setBorderPainted(false);
		nguyenLieu.add(btnNguyenLieu);
		
		thongKe = new JPanel();
		navbar.add(thongKe);
		thongKe.setLayout(new BorderLayout(0, 0));
		
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-statistic-30.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setBorderPainted(false);
		thongKe.add(btnThongKe);
		
		hoaDon = new JPanel();
		navbar.add(hoaDon);
		hoaDon.setLayout(new BorderLayout(0, 0));
		
		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-bill-30.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setBorderPainted(false);
		hoaDon.add(btnHoaDon);
		
		caiDat = new JPanel();
		navbar.add(caiDat);
		caiDat.setLayout(new BorderLayout(0, 0));
		
		btnCaiDat = new JButton("Cài đặt");
		btnCaiDat.setIcon(new ImageIcon(TrangChu.class.getResource("/Image/icons8-setting-30.png")));
		btnCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCaiDat.setContentAreaFilled(false);
		btnCaiDat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCaiDat.setBorderPainted(false);
		caiDat.add(btnCaiDat);
		
		paneTrong_2 = new JPanel();
		navbar.add(paneTrong_2);
		paneTrong_2.setLayout(new BorderLayout(0, 0));
		
		header = new JPanel();
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
		left_main_header.setBorder(new EmptyBorder(10, 0, 10, 0));
		north_l.add(left_main_header);
		left_main_header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		l_main_header = new JLabel("MENU");
		l_main_header.setFont(new Font("Tahoma", Font.BOLD, 30));
		left_main_header.add(l_main_header);
		
		left_main_btn = new JPanel();
		left_main_btn.setBorder(new EmptyBorder(20, 0, 20, 0));
		north_l.add(left_main_btn);
		
		btnCafe = new JButton("Cà phê");
		btnCafe.setFont(new Font("Tahoma", Font.BOLD, 20));
		left_main_btn.add(btnCafe);
		
		btnDaXay = new JButton("Đá xay");
		btnDaXay.setFont(new Font("Tahoma", Font.BOLD, 20));
		left_main_btn.add(btnDaXay);
		
		btnTra = new JButton("Trà");
		btnTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		left_main_btn.add(btnTra);
		
		btnSoda = new JButton("Soda");
		btnSoda.setFont(new Font("Tahoma", Font.BOLD, 20));
		left_main_btn.add(btnSoda);
		
		btnKhac = new JButton("Thức uống khác");
		btnKhac.setFont(new Font("Tahoma", Font.BOLD, 20));
		left_main_btn.add(btnKhac);
		
		btnBanh = new JButton("Bánh");
		btnBanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		left_main_btn.add(btnBanh);
		
		cen_l = new JPanel();
		left_main.add(cen_l, BorderLayout.CENTER);
		cen_l.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(240, 240, 240), 10));
		panel_9.setBackground(new Color(255, 255, 255));
		cen_l.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel columns = new JPanel();
		columns.setBackground(new Color(255, 255, 255));
		panel_9.add(columns, BorderLayout.NORTH);
		columns.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.LIGHT_GRAY);
		columns.add(panel_14);

		JLabel lblNewLabel_3 = new JLabel("Tên món");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_14.add(lblNewLabel_3);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.LIGHT_GRAY);
		columns.add(panel_16);

		JLabel lblNewLabel_5 = new JLabel("Giá tiền");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_16.add(lblNewLabel_5);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		columns.add(panel);

		JLabel lblNewLabel = new JLabel("Thêm món");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);

		// Cấu hình table1 và scrollPane
		table1 = new JPanel();
		table1.setBackground(new Color(255, 255, 255));
		JScrollPane scrollPane = new JScrollPane(table1);
		table1.setLayout(new BoxLayout(table1, BoxLayout.Y_AXIS));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel_9.add(scrollPane, BorderLayout.CENTER);
		
		right_main = new JPanel();
		main.add(right_main);
		right_main.setLayout(new BorderLayout(0, 0));
		
		right_header = new JPanel();
		right_main.add(right_header, BorderLayout.NORTH);
		right_header.setLayout(new BoxLayout(right_header, BoxLayout.Y_AXIS));
		
		lab_head = new JPanel();
		right_header.add(lab_head);
		
		right_lab = new JLabel("Giỏ hàng");
		right_lab.setHorizontalAlignment(SwingConstants.CENTER);
		right_lab.setFont(new Font("Tahoma", Font.BOLD, 30));
		lab_head.add(right_lab);
		
		tenKH = new JPanel();
		tenKH.setBorder(new EmptyBorder(20, 20, 20, 20));
		right_header.add(tenKH);
		tenKH.setLayout(new BoxLayout(tenKH, BoxLayout.X_AXIS));
		
		ten_lab = new JLabel("Tên khách hàng");
		ten_lab.setFont(new Font("Tahoma", Font.BOLD, 15));
		tenKH.add(ten_lab);
		
		tfTenKH = new JTextField();
		tfTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenKH.add(tfTenKH);
		tfTenKH.setColumns(10);
		
		soDT = new JPanel();
		soDT.setBorder(new EmptyBorder(20, 20, 20, 20));
		right_header.add(soDT);
		soDT.setLayout(new BoxLayout(soDT, BoxLayout.X_AXIS));
		
		soDT_lab = new JLabel("Số điện thoại");
		soDT_lab.setFont(new Font("Tahoma", Font.BOLD, 15));
		soDT.add(soDT_lab);
		soDT_lab.setPreferredSize(ten_lab.getPreferredSize());
		
		tfSoDT = new JTextField();
		tfSoDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		soDT.add(tfSoDT);
		tfSoDT.setColumns(10);
		
		r_main = new JPanel();
		right_main.add(r_main, BorderLayout.CENTER);
		
		scrollPane_1 = new JScrollPane();
		r_main.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Sản Phẩm", "Giá tiền", "Số lượng", "Tổng giá"
			}
		));
		r_main.add(table);
		
		datHang = new JPanel();
		right_main.add(datHang, BorderLayout.SOUTH);
		
		btnThanhToan = new JButton("0 VND");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 30));
		datHang.add(btnThanhToan);
		updateTable(dsMon, table1);
	}
	
	private void updateTable(ArrayList<Mon> dsMon, JPanel table) {
		table.removeAll();
		dsMon = mon_dao.danhSachMon();
		dsMon.forEach(item -> {
			addItemToTable(item, table);
		});
		table.revalidate();
		table.repaint();
	}
	
	private void addItemToTable(Mon mon, JPanel table) {
		JPanel listMon = new JPanel();
		listMon.setBackground(SystemColor.menu);
		listMon.setPreferredSize(new Dimension(table.getWidth(), 50));
		listMon.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		table.add(listMon);
		listMon.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panelMon = new JPanel();
		listMon.add(panelMon);
		panelMon.setLayout(new BorderLayout(0, 0));

		JPanel panelTT = new JPanel();
		listMon.add(panelTT);
		panelMon.setLayout(new BorderLayout(0, 0));

		lbTenMon = new JLabel(mon.getTenMon());
		panelMon.add(lbTenMon, BorderLayout.CENTER);
		lbTenMon.setFont(new Font("Tahoma", Font.PLAIN, 15));

		DecimalFormat df = new DecimalFormat("#,### VND");
		JLabel lbGiaTien = new JLabel(df.format(mon.getDonGia()));
		panelTT.add(lbGiaTien, BorderLayout.CENTER);
		lbGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panelButton = new JPanel();
		listMon.add(panelButton);
		panelButton.setLayout(new BorderLayout(0, 0));

		btnThem = new JButton("Thêm");
		panelButton.add(btnThem, BorderLayout.CENTER);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog dialog = new JDialog();
	            dialog.setTitle("Thêm món");
	            dialog.setModal(true);
	            dialog.setSize(400, 500);
	            dialog.setLocationRelativeTo(null); 
	            
	            JPanel mon_panel = new JPanel();
	            dialog.add(mon_panel);
	            
	            mon_panel.setLayout(new BorderLayout());
	            
	            JPanel maMon = new JPanel();
	            maMon.setLayout(new GridLayout(1, 2, 0, 0));
	            JLabel maMon_lab = new JLabel("Mã món: ");
	            JTextField tfMaMon = new JTextField();
	            maMon.add(maMon_lab);
	            maMon.add(tfMaMon);
	            
	            JPanel header_pane = new JPanel();
	            header_pane.setLayout(new BoxLayout(header_pane, BoxLayout.X_AXIS));
	            header_pane.add(maMon);
	            
	            
	            
	            mon_panel.add(header_pane, BorderLayout.NORTH);
	            
	            dialog.setVisible(true);
		}});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton)e.getSource();
		
	}
}
