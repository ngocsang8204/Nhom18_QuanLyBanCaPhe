package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.Ban_DAO;
import DAO.ChiTietDonHang_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import Entity.Ban_Entity;
import Entity.ChiTietDonHang_Entity;
import Entity.HoaDon_Entity;
import Entity.KhachHang_Entity;
import Entity.NhanVien_Entity;

import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class HoaDon extends JPanel implements ActionListener, MouseListener{

	private JDateChooser thoiGian;
	private DefaultTableModel model;
	private JTable table;
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private Ban_DAO ban_dao = new Ban_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private ChiTietDonHang_DAO ctdh_dao = new ChiTietDonHang_DAO();
	private JTextField tfMaHD;
	private JTextField tNgayLap;
	private JTextField tfGiamGia;
	private JTextField tfTenKH;
	private JTextField tfSoDTKH;
	private JTextField tfTenBan;
	private JTextField tfTenNV;
	private JTextField tfSoDTNV;
	private JTextField tfChucVu;
	private int ngayCat;
	private int thangCat;
	private int namCat;
	private JButton timKiemNgay;
	private JButton btnXemChiTiet;

	public HoaDon() {
		this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1600, 954);
        setLayout(new BorderLayout(0, 0));
        JPanel content = new JPanel();
        content.setBackground(new Color(255, 255, 255));
        content.setBounds(0, 0, 172, 83);
        add(content);
        content.setLayout(new BorderLayout(0, 0));
        
        JPanel p_north = new JPanel();
        p_north.setBackground(new Color(255, 255, 255));
        p_north.setBorder(new EmptyBorder(50, 0, 0, 0));
        content.add(p_north, BorderLayout.NORTH);
        p_north.setLayout(new BoxLayout(p_north, BoxLayout.Y_AXIS));
        
        JPanel header = new JPanel();
        header.setBackground(new Color(255, 255, 255));
        header.setBorder(new EmptyBorder(20, 0, 20, 0));
        p_north.add(header);
        header.setLayout(new BorderLayout(0, 0));
        
        JLabel header_lab = new JLabel("HOÁ ĐƠN");
        header_lab.setFont(new Font("Tahoma", Font.BOLD, 30));
        header.add(header_lab);
        
        JPanel chon = new JPanel();
        p_north.add(chon);
        chon.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel ngay = new JPanel();
        ngay.setBackground(new Color(255, 255, 255));
        ngay.setBorder(new EmptyBorder(25, 0, 0, 0));
        chon.add(ngay);
        ngay.setLayout(new BoxLayout(ngay, BoxLayout.X_AXIS));
        
        JPanel chonNgay = new JPanel();
        chonNgay.setBackground(new Color(255, 255, 255));
        ngay.add(chonNgay);
        
        JLabel ngay_lab = new JLabel("Chọn ngày:");
        ngay_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        chonNgay.add(ngay_lab);
        
        thoiGian = new JDateChooser();
        thoiGian.setDate(new Date());
        thoiGian.setDateFormatString("dd/MM/yyyy");
        chonNgay.add(thoiGian);
        thoiGian.setPreferredSize(new Dimension(200, 40));
        thoiGian.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel timKiembtn = new JPanel();
        timKiembtn.setBackground(new Color(255, 255, 255));
        ngay.add(timKiembtn);
        
        timKiemNgay = new JButton("");
        timKiemNgay.setIcon(new ImageIcon(HoaDon.class.getResource("/img/icons8-search-30.png")));
        timKiembtn.add(timKiemNgay);
        
        JPanel timNhanh = new JPanel();
        timNhanh.setBackground(new Color(255, 255, 255));
        chon.add(timNhanh);
        timNhanh.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel tenKH_lab = new JLabel("Tên khách hàng: ");
        tenKH_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JPanel p_cen = new JPanel();
        p_cen.setBackground(new Color(255, 255, 255));
        p_cen.setBorder(new EmptyBorder(50, 0, 0, 0));
        content.add(p_cen, BorderLayout.CENTER);
        p_cen.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel bangHoaDon = new JPanel();
        p_cen.add(bangHoaDon);
        bangHoaDon.setLayout(new BoxLayout(bangHoaDon, BoxLayout.X_AXIS));
        
        JPanel bang = new JPanel();
        bang.setBorder(new EmptyBorder(0, 0, 50, 0));
        bang.setBackground(new Color(255, 255, 255));
        bangHoaDon.add(bang);
        
        String[] colnames = { "Mã hoá đơn", "Ngày lập", "Giảm giá", "Mã khách hàng", "Mã bàn", "Mã nhân viên" };
		model = new DefaultTableModel(colnames, 0);
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
		bang.setLayout(new BoxLayout(bang, BoxLayout.X_AXIS));
		table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setBackground(Color.WHITE);
		JScrollPane scr = new JScrollPane(table);
		bang.add(scr);
		table.setBackground(new Color(255, 255, 255));
		scr.setBackground(Color.WHITE);
        
        JPanel chiTietHoaDon = new JPanel();
        chiTietHoaDon.setBorder(new CompoundBorder(new EmptyBorder(0, 50, 50, 20), new LineBorder(new Color(0, 0, 0), 1, true)));
        chiTietHoaDon.setBackground(new Color(255, 255, 255));
        p_cen.add(chiTietHoaDon);
        chiTietHoaDon.setLayout(new BoxLayout(chiTietHoaDon, BoxLayout.Y_AXIS));
        
        JPanel p_trong1 = new JPanel();
        chiTietHoaDon.add(p_trong1);
        
        JPanel p_maHD = new JPanel();
        chiTietHoaDon.add(p_maHD);
        p_maHD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel maHD_lab = new JLabel("Mã hoá đơn: ");
        maHD_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        maHD_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        p_maHD.add(maHD_lab);
        
        tfMaHD = new JTextField(30);
        tfMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_maHD.add(tfMaHD);
        
        JPanel p_ngayLap = new JPanel();
        chiTietHoaDon.add(p_ngayLap);
        
        JLabel ngayLap_lab = new JLabel("Ngày lập: ");
        ngayLap_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        ngayLap_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_ngayLap.add(ngayLap_lab);
        
        tNgayLap = new JTextField(30);
        tNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_ngayLap.add(tNgayLap);
        
        JPanel p_giamGia = new JPanel();
        chiTietHoaDon.add(p_giamGia);
        
        JLabel giamGia_lab = new JLabel("Giảm giá: ");
        giamGia_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        giamGia_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_giamGia.add(giamGia_lab);
        
        tfGiamGia = new JTextField(30);
        tfGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_giamGia.add(tfGiamGia);
        
        JPanel p_khachHang = new JPanel();
        chiTietHoaDon.add(p_khachHang);
        p_khachHang.setBorder(BorderFactory.createTitledBorder(getBorder(), "Khách hàng", TitledBorder.LEADING, 
        		TitledBorder.DEFAULT_JUSTIFICATION, new Font("Tahoma",Font.BOLD,16), getForeground()));
        p_khachHang.setLayout(new BoxLayout(p_khachHang, BoxLayout.Y_AXIS));
        
        JPanel p_tenKH = new JPanel();
        p_khachHang.add(p_tenKH);

        p_tenKH.add(tenKH_lab);
        
        tfTenKH = new JTextField(30);
        tfTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_tenKH.add(tfTenKH);
        
        JPanel p_sdt = new JPanel();
        p_khachHang.add(p_sdt);
        
        JLabel soDTKH_lab = new JLabel("Số điện thoại: ");
        soDTKH_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        soDTKH_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_sdt.add(soDTKH_lab);
        
        tfSoDTKH = new JTextField(30);
        tfSoDTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_sdt.add(tfSoDTKH);
        
        JPanel p_Ban = new JPanel();
        chiTietHoaDon.add(p_Ban);
        p_Ban.setBorder(BorderFactory.createTitledBorder(getBorder(), "Bàn", TitledBorder.LEADING, 
        		TitledBorder.DEFAULT_JUSTIFICATION, new Font("Tahoma",Font.BOLD,16), getForeground()));
        p_Ban.setLayout(new BoxLayout(p_Ban, BoxLayout.Y_AXIS));
        
        JPanel p_tenBan = new JPanel();
        p_Ban.add(p_tenBan);
        
        JLabel tenBan_lab = new JLabel("Bàn: ");
        tenBan_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        tenBan_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_tenBan.add(tenBan_lab);
        
        tfTenBan = new JTextField(30);
        tfTenBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_tenBan.add(tfTenBan);
        
        JPanel p_nhanVien = new JPanel();
        chiTietHoaDon.add(p_nhanVien);
        p_nhanVien.setBorder(BorderFactory.createTitledBorder(getBorder(), "Nhân viên", TitledBorder.LEADING, 
        		TitledBorder.DEFAULT_JUSTIFICATION, new Font("Tahoma",Font.BOLD,16), getForeground()));
        p_nhanVien.setLayout(new BoxLayout(p_nhanVien, BoxLayout.Y_AXIS));
        
        JPanel p_tenNV = new JPanel();
        p_nhanVien.add(p_tenNV);
        
        JLabel tenNV_lab = new JLabel("Tên nhân viên: ");
        tenNV_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        tenNV_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_tenNV.add(tenNV_lab);
        
        tfTenNV = new JTextField(30);
        tfTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_tenNV.add(tfTenNV);
        
        JPanel p_sdtNV = new JPanel();
        p_nhanVien.add(p_sdtNV);
        
        JLabel sdtNV_lab = new JLabel("Số điện thoại: ");
        sdtNV_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        sdtNV_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_sdtNV.add(sdtNV_lab);
        
        tfSoDTNV = new JTextField(30);
        tfSoDTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_sdtNV.add(tfSoDTNV);
        
        JPanel p_chucVu = new JPanel();
        p_nhanVien.add(p_chucVu);
        
        JLabel chucVu_lab = new JLabel("Chức vụ: ");
        chucVu_lab.setFont(new Font("Tahoma", Font.BOLD, 20));
        chucVu_lab.setPreferredSize(tenKH_lab.getPreferredSize());
        p_chucVu.add(chucVu_lab);
        
        tfChucVu = new JTextField(30);
        tfChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p_chucVu.add(tfChucVu);
        
        JPanel xemChiTiet = new JPanel();
        chiTietHoaDon.add(xemChiTiet);
        
        btnXemChiTiet = new JButton("XEM CHI TIẾT");
        btnXemChiTiet.setIcon(new ImageIcon(HoaDon.class.getResource("/img/icons8-bill-30-black.png")));
        btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
        xemChiTiet.add(btnXemChiTiet);
        timKiemNgay.addActionListener(this);
        btnXemChiTiet.addActionListener(this);
        table.addMouseListener(this);
        hienBang();
	}
	
	private void catNgay () {
		Date date = thoiGian.getDate();
	    
	    if (date != null) {
	        String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(date);
	        String[] parts = formattedDate.split("/");
	        
	        ngayCat = Integer.parseInt(parts[0]);
	        thangCat = Integer.parseInt(parts[1]);
	        namCat = Integer.parseInt(parts[2]);
	    } else {
	        System.out.println("Ngày không hợp lệ");
	    }
	}

	private void hienBang() {
		catNgay();
		model.getDataVector().removeAllElements();
		ArrayList<HoaDon_Entity> dsHD = hd_dao.timHoaDonTheoNgay(LocalDate.of(namCat, thangCat, ngayCat));
		dsHD.forEach(x -> themDong(x));
	}
	
	private void themDong(HoaDon_Entity a) {
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat deci = new DecimalFormat("#,### VND");
		String ban = (a.getBan() == null) ? "Mang đi" : a.getBan().getMaBan();
		model.addRow(new Object[] {a.getMaHoaDon(), df.format(a.getNgayLap()), deci.format(a.getGiamGia()), a.getKhachHang().getMaKhachHang(), ban, a.getNhanVien().getMaNhanVien()});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		tfMaHD.setText(model.getValueAt(row, 0).toString());
		tNgayLap.setText(model.getValueAt(row, 1).toString());
		tfGiamGia.setText(model.getValueAt(row, 2).toString());
		String maKH = model.getValueAt(row, 3).toString();
		String maBan = model.getValueAt(row, 4).toString();
		String maNV = model.getValueAt(row, 5).toString();
		KhachHang_Entity kh = kh_dao.timKiemKhachHangTheoMa(maKH);
		Ban_Entity ban = ban_dao.timBanTheoMa(maBan);
		NhanVien_Entity nv = nv_dao.timNhanVienTheoMa(maNV);
		tfTenKH.setText(kh.getTenKhachHang());
		tfSoDTKH.setText(kh.getSoDienThoai());
		tfTenBan.setText(ban==null?"Mang đi":ban.getMaBan());
		tfTenNV.setText(nv.getTenNhanVien());
		tfSoDTNV.setText(nv.getSoDienThoai());
		tfChucVu.setText(nv.getChucVu()?"Quản lý":"Nhân viên");
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
	    panel.add(new JLabel("Tên Nhân viên: " + hd.getNhanVien().getTenNhanVien()));
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton)e.getSource();
		if (btn.equals(timKiemNgay)) {
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			hienBang();
		}
		
		if (btn.equals(btnXemChiTiet)) {
			HoaDon_Entity hd = hd_dao.timKiemHoaDonTheoMa(tfMaHD.getText().toString());
			hienHoaDon(hd);
		}
	}

}
