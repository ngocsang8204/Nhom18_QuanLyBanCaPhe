package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Mon_DAO;
import DAO.TaiKhoan_DAO;
import Entity.Mon_Entity;
import Entity.TaiKhoan_Entity;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.awt.FlowLayout;

public class TrangChu extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
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
	private ArrayList<Mon_Entity> dsMon;
	private JLabel lbTenMon;
	private JButton btnThem;
	private JPanel body;
	private Object selectedButton;
	private JPopupMenu manageMenu;
	private DefaultTableModel model_sanPhamDat;
	private JTable table_sanPhamDat;
	private DefaultTableModel model;
	private DefaultTableModel model_1;
	private JTable table_1;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TrangChu frame = new TrangChu(taiKhoan);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TrangChu(TaiKhoan_Entity taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setTitle("Quản lý quán cà phê");
//		setSize(new Dimension(1920, 1080));
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
		paneTrong_1.setBackground(new Color(24, 28, 20));
		navbar.add(paneTrong_1);
		paneTrong_1.setLayout(new BorderLayout(0, 0));
		
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
		
		 // Tạo submenu cho "Quản Lý"
        manageMenu = new JPopupMenu();
        manageMenu.setBorder(new EmptyBorder(0, 0, 0, 0)); 

        // Danh sách các mục trong submenu
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
        
     // Action listeners cho các mục submenu
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
		btnThongKe.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-statistic-30.png")));btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		
		btnTra = new JButton("TRÀ");
		btnTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnTra);
		
		btnSoda = new JButton("SODA");
		btnSoda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnSoda);
		
		btnKhac = new JButton("THỨC UỐNG KHÁC");
		btnKhac.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnKhac);
		
		btnBanh = new JButton("BÁNH");
		btnBanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		left_main_btn.add(btnBanh);
		
		cen_l = new JPanel();
		cen_l.setBackground(new Color(255, 255, 255));
		left_main.add(cen_l, BorderLayout.CENTER);
		
		JPanel dsMon = new JPanel();
		String[] colNames1 = {"Mã món", "Tên món", "Loại món", "Giá tiền"};
		model_1 = new DefaultTableModel(colNames1, 0);
		table_1 = new JTable(model_1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Không cho phép chỉnh sửa
				return false;
			}
		};
		table_1.setShowGrid(true);
		table_1.setShowHorizontalLines(true);
		table_1.setShowVerticalLines(false);
		table_1.setRowHeight(30);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề
        table_1.getTableHeader().setResizingAllowed(false);
        
        cen_l.setLayout(new GridLayout(2, 1, 0, 0));
        dsMon.setLayout(new BorderLayout());
        table_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JScrollPane scr_chinh = new JScrollPane(table_1);
        scr_chinh.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        dsMon.add(scr_chinh);
        cen_l.add(dsMon);
			
		right_main = new JPanel();
		main.add(right_main);
		right_main.setLayout(new BorderLayout(0, 0));
		
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
		tfTenKH.setColumns(10);
		
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
		soDT.add(tfSoDT);
		tfSoDT.setColumns(10);
		
		r_main = new JPanel();
		r_main.setBorder(new EmptyBorder(40, 40, 40, 40));
		r_main.setBackground(new Color(255, 255, 255));
		right_main.add(r_main, BorderLayout.CENTER);
		
		String[] colnames = {"Tên món", "Loại món", "Số lượng", "Giá tiền"};
        model = new DefaultTableModel(colnames, 0);
        r_main.setLayout(new BoxLayout(r_main, BoxLayout.X_AXIS));
        // Sau khi khởi tạo JTable và JScrollPane
        table = new JTable(model){
			@Override
			public boolean isCellEditable(int row, int column) {
				// Không cho phép chỉnh sửa
				return false;
			}
		};
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane scr = new JScrollPane(table);
        r_main.add(scr);
		
		datHang = new JPanel();
		datHang.setBorder(new EmptyBorder(20, 0, 50, 0));
		datHang.setBackground(new Color(255, 255, 255));
		right_main.add(datHang, BorderLayout.SOUTH);
		
		btnThanhToan = new JButton("0 VND");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 30));
		datHang.add(btnThanhToan);
		
		btnTrangChu.addMouseListener(this);
		btnQuanLy.addMouseListener(this);
		btnBan.addMouseListener(this);
		btnThongKe.addMouseListener(this);
		btnHoaDon.addMouseListener(this);
		btnCaiDat.addMouseListener(this);
		
		hienBang();
	}
	
	private JMenuItem createSubmenuItem(String text) {
        JMenuItem item = new JMenuItem(text);
        item.setOpaque(true);
        item.setFont(new Font("Tahoma", Font.BOLD, 17));

        return item;
    }
	
	private void hienBang() {
		model_1.getDataVector().removeAllElements();
		ArrayList<Mon_Entity> dsMon = mon_dao.danhSachMon();
		dsMon.forEach(x -> themDong(x));
	}
	
	private void themDong(Mon_Entity a) {
		model_1.addRow(new Object[] {a.getMaMon(),
									a.getTenMon(),
									a.getLoaiMon(),
									a.getDonGia()});
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubJButton btn = (JButton)e.getSource();
		
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
	    Object o = e.getSource();
	    
	    if (o.equals(btnTrangChu)) {
	        body.removeAll();
	        body.add(main);
	        body.revalidate();
	        body.repaint();
	    }
	    
	    if (o.equals(btnBan)) {
	        body.removeAll();
	        body.revalidate();
	        body.repaint();
	    }

	    if (o.equals(btnQuanLy)) {
	    	manageMenu.show(btnQuanLy, btnQuanLy.getWidth(), btnQuanLy.getHeight()/3);
	    }

	    if (o.equals(btnThongKe)) {
	        body.removeAll();
	        body.add(new ThongKe());
	        body.revalidate();
	        body.repaint();
	    }

	    if (o.equals(btnHoaDon)) {
	        body.removeAll();
	        body.add(new HoaDon());
	        body.revalidate();
	        body.repaint();
	    }
	    
	    if (o.equals(btnCaiDat)) {
	        body.removeAll();
	        body.add(new CaiDat());
	        body.revalidate();
	        body.repaint();
	    }
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}