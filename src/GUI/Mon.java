package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Mon_DAO;
import DAO.NguyenLieu_DAO;
import Entity.Mon_Entity;
import Entity.NguyenLieu_Entity;

import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Mon extends JPanel implements MouseListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField tMaMon;
	private JTextField tTenMon;
	private JTextField tDonGia;
	private JTextField tTimKiem;
	private JTable tableSanPham;
	private DefaultTableModel model_SanPham;
	private JButton btnCaPhe;
	private JButton btnDaXay;
	private JButton btnTraSua;
	private JButton btnSinhTo;
	private JButton btnThucUongKhac;
	private JButton btnBanh;
	private JButton btnTimKiem;
	private JButton btnSua;
	private JButton btnThem;
	private Mon_DAO mon_dao= new Mon_DAO();
	private NguyenLieu_DAO nl_dao= new NguyenLieu_DAO();
	private JComboBox cbLoaiMon;
	private JComboBox cbNL;
	private JTextField tSLNL;
	private JButton btnThemNL;
	private JButton btnXoaNL;
	private JTable table;
	private DefaultTableModel model_NguyenLieu;
	private JTable tableNguyenLieu;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnAll;

	/**
	 * Create the panel.
	 */
	public Mon() {
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1600, 954);
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        add(panel, BorderLayout.EAST);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new GridLayout(3, 1, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("                       ");
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("Thông tin món");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_1_1 = new JLabel("                       ");
        panel_2.add(lblNewLabel_1_1);
        
//        JPanel panel_trong = new JPanel();
//        panel_trong.setPreferredSize(new Dimension(panel_2.getPreferredSize().width,200));
//        panel.add(panel_trong,BorderLayout.CENTER);
//        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4);
        
        JLabel lbMaMon = new JLabel("Mã món: ");
        lbMaMon.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lbMaMon);
        
        tMaMon = new JTextField(28);
        panel_4.add(tMaMon);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_1);
        
        JLabel lbTenMon = new JLabel("Tên món: ");
        lbTenMon.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_1.add(lbTenMon);
        
        tTenMon = new JTextField();
        panel_4_1.add(tTenMon);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_2);
        
        JLabel lbLoaiMon = new JLabel("Loại món:");
        lbLoaiMon.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_2.add(lbLoaiMon);
        
        cbLoaiMon = new JComboBox();
        cbLoaiMon.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cbLoaiMon.setModel(new DefaultComboBoxModel(new String[] {"Cà phê", "Trà sữa", "Đá xay", "Sinh tố", "Thức uống khác", "Bánh"}));
        cbLoaiMon.setBackground(new Color(255, 255, 255));
        
        panel_4_2.add(cbLoaiMon);
        
        JPanel panel_4_3 = new JPanel();
        panel_4_3.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_3);
        
        JLabel lbDonGia = new JLabel("Đơn giá: ");
        lbDonGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3.add(lbDonGia);
        
        tDonGia = new JTextField();
        panel_4_3.add(tDonGia);
        tMaMon.setPreferredSize(new Dimension(tMaMon.getPreferredSize().width,30));
        tMaMon.setEditable(false);
        tTenMon.setPreferredSize(new Dimension(tMaMon.getPreferredSize().width,30));
        cbLoaiMon.setPreferredSize(new Dimension(tMaMon.getPreferredSize().width,30));
        tDonGia.setPreferredSize(new Dimension(tMaMon.getPreferredSize().width,30));
        
        lbMaMon.setPreferredSize(new Dimension(170,20));
        lbTenMon.setPreferredSize(new Dimension(170,20));
        lbLoaiMon.setPreferredSize(new Dimension(170,20));
        lbDonGia.setPreferredSize(new Dimension(170,20));
        
        JPanel panel4_4 = new JPanel();
        
        panel4_4.setBorder(BorderFactory.createTitledBorder(getBorder(), "Nguyên Liệu", TitledBorder.LEADING, 
        		TitledBorder.DEFAULT_JUSTIFICATION, new Font("Tahoma",Font.BOLD,16), getForeground()));
        panel4_4.setBackground(new Color(255, 255, 255));
        panel_3.add(panel4_4);
        panel4_4.setLayout(new BoxLayout(panel4_4, BoxLayout.Y_AXIS));
        
        JPanel panel4_4_1 = new JPanel();
        panel4_4_1.setBackground(new Color(255, 255, 255));
        panel4_4.add(panel4_4_1);
        
        JLabel lbNL = new JLabel("Nguyên liệu:");
        lbNL.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbNL.setPreferredSize(new Dimension(170,20));
        panel4_4_1.add(lbNL);
        
        String[] dsNL= nl_dao.danhSachNguyenLieuTheoTen();
        cbNL = new JComboBox(dsNL);
        cbNL.setBackground(new Color(255, 255, 255));
        cbNL.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cbNL.setPreferredSize(new Dimension(tMaMon.getPreferredSize().width,30));
        panel4_4_1.add(cbNL);
        
        
        JPanel panel4_4_2 = new JPanel();
        panel4_4_2.setBackground(new Color(255, 255, 255));
        panel4_4_1.setBackground(new Color(255, 255, 255));
        panel4_4.add(panel4_4_2);
        
        JLabel lbSLNL = new JLabel("Số lượng:");
        lbSLNL.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbSLNL.setPreferredSize(new Dimension(170,20));
        panel4_4_2.add(lbSLNL);
        
        tSLNL = new JTextField();
        tSLNL.setPreferredSize(new Dimension(tMaMon.getPreferredSize().width,30));
        panel4_4_2.add(tSLNL);
        
       
       
        
        JPanel panel4_4_3 = new JPanel();
        panel4_4_3.setBackground(new Color(255, 255, 255));
        panel4_4.add(panel4_4_3);
        
        btnThemNL = new JButton("Thêm");
        btnThemNL.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-add-30.png")));
        panel4_4_3.add(btnThemNL);
        
        btnXoaNL = new JButton("Xóa");
        btnXoaNL.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-delete-30.png")));
        panel4_4_3.add(btnXoaNL);
        btnThemNL.addActionListener(this);
        btnXoaNL.addActionListener(this);
        JPanel panel4_4_5 = new JPanel();
        panel4_4_5.setBackground(new Color(255, 255, 255));
        panel4_4.add(panel4_4_5);
        
        String[] colNL = new String[] { "Tên","Số lượng"};
        model_NguyenLieu= new DefaultTableModel(colNL, 0);
        // Sau khi khởi tạo JTable và JScrollPane
        tableNguyenLieu = new JTable(model_NguyenLieu);
        tableNguyenLieu.setFocusable(false);
        tableNguyenLieu.setShowGrid(true);
        tableNguyenLieu.setShowHorizontalLines(true);
        tableNguyenLieu.setShowVerticalLines(false);
        JScrollPane jsp2 = new JScrollPane(tableNguyenLieu);
        jsp2.setPreferredSize(new Dimension(jsp2.getPreferredSize().width, 300));
        jsp2.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Tạo viền màu đen
        tableNguyenLieu.getTableHeader().setBackground(Color.white);
        tableNguyenLieu.getTableHeader().setReorderingAllowed(false);
        tableNguyenLieu.getTableHeader().setResizingAllowed(false);
        panel4_4_5.add(jsp2);
        
        
        
        
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_5.setPreferredSize(new Dimension(panel_3.getPreferredSize().width,300));
        panel.add(panel_5,BorderLayout.SOUTH);
        
        JLabel lblNewLabel_1_2 = new JLabel("                       ");
        panel_5.add(lblNewLabel_1_2);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        panel_6.setPreferredSize(new Dimension(panel_3.getPreferredSize().width,50));
        panel_5.add(panel_6);
        
        btnThem = new JButton("Thêm");
        btnThem.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-add-30.png")));
        panel_6.add(btnThem);
        
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(93, 39));
        btnSua.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-tools-30.png")));
        panel_6.add(btnSua);
        
        btnXoaRong = new JButton("Xóa rỗng");
        btnXoaRong.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-erase-30.png")));
        panel_6.add(btnXoaRong);
        
        btnXoa = new JButton("Xóa");
        btnXoa.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-delete-30.png")));
        panel_6.add(btnXoa);
        
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoaRong.addActionListener(this);
        btnXoa.addActionListener(this);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_7, BorderLayout.NORTH);
        GridBagLayout gbl_panel_7 = new GridBagLayout();
        gbl_panel_7.columnWidths = new int[]{632, 632, 0};
        gbl_panel_7.rowHeights = new int[]{72, 72, 0};
        gbl_panel_7.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_7.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_7.setLayout(gbl_panel_7);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        GridBagConstraints gbc_panel_8 = new GridBagConstraints();
        gbc_panel_8.fill = GridBagConstraints.BOTH;
        gbc_panel_8.insets = new Insets(0, 0, 5, 5);
        gbc_panel_8.gridx = 0;
        gbc_panel_8.gridy = 0;
        panel_7.add(panel_8, gbc_panel_8);
        
        JLabel lblNewLabel_2 = new JLabel("MENU");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel_8.add(lblNewLabel_2);
        
        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        GridBagConstraints gbc_panel_9 = new GridBagConstraints();
        gbc_panel_9.fill = GridBagConstraints.BOTH;
        gbc_panel_9.insets = new Insets(0, 0, 5, 0);
        gbc_panel_9.gridx = 1;
        gbc_panel_9.gridy = 0;
        panel_7.add(panel_9, gbc_panel_9);
        
        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(255, 255, 255));
        panel_11.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
            "Tìm kiếm nhanh:", 
            TitledBorder.LEADING, 
            TitledBorder.TOP, 
            new Font("Tahoma", Font.PLAIN, 16), // Thiết lập kích thước chữ cho tiêu đề
            new Color(0, 0, 0)
        ));

        panel_9.add(panel_11);
        
        btnTimKiem = new JButton("");
        btnTimKiem.setIcon(new ImageIcon(NhaCungCap.class.getResource("/img/icons8-search-30.png")));
        btnTimKiem.setContentAreaFilled(false);
		btnTimKiem.setBorderPainted(false);
        panel_11.add(btnTimKiem);
        
        tTimKiem = new JTextField(25);
        tTimKiem.setOpaque(false);
        tTimKiem.setForeground(Color.BLACK);
        tTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tTimKiem.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        panel_11.add(tTimKiem);
        
        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        GridBagConstraints gbc_panel_10 = new GridBagConstraints();
        gbc_panel_10.gridwidth = 2;
        gbc_panel_10.fill = GridBagConstraints.BOTH;
        gbc_panel_10.insets = new Insets(0, 0, 0, 5);
        gbc_panel_10.gridx = 0;
        gbc_panel_10.gridy = 1;
        panel_7.add(panel_10, gbc_panel_10);
        
        JLabel lblNewLabel_4 = new JLabel("                  ");
        panel_10.add(lblNewLabel_4);
        
        btnCaPhe = new JButton("CÀ PHÊ");
        btnCaPhe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnCaPhe);
        
        btnDaXay = new JButton("ĐÁ XAY");
        btnDaXay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnDaXay);
        
        btnTraSua = new JButton("TRÀ SỮA");
        btnTraSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnTraSua);
        
        btnSinhTo = new JButton("SINH TỐ");
        btnSinhTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnSinhTo);
        
        btnThucUongKhac = new JButton("THỨC UỐNG KHÁC");
        btnThucUongKhac.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnThucUongKhac);
        
        btnBanh = new JButton("BÁNH");
        btnBanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnBanh);
        
        
        
        btnAll = new JButton("TẤT CẢ");
        btnAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnAll);
        
        btnCaPhe.addActionListener(this);
        btnTraSua.addActionListener(this);
        btnSinhTo.addActionListener(this);
        btnDaXay.addActionListener(this);
        btnThucUongKhac.addActionListener(this);
        btnBanh.addActionListener(this);
        btnAll.addActionListener(this);
        
        JPanel panel_12 = new JPanel();
        panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
        panel_12.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_12, BorderLayout.CENTER);
        // Table Model and JTable
        String[] colnames = new String[] { "Mã món","Tên món", "Loại món", "Đơn giá"};
        model_SanPham= new DefaultTableModel(colnames, 0);
        // Sau khi khởi tạo JTable và JScrollPane
        tableSanPham = new JTable(model_SanPham) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Không cho phép chỉnh sửa
				return false;
			}
		};
        tableSanPham.setFocusable(false);
        tableSanPham.setShowGrid(true);
        tableSanPham.setShowHorizontalLines(true);
        tableSanPham.setShowVerticalLines(false);
        JScrollPane jsp = new JScrollPane(tableSanPham);
//        jsp.setPreferredSize(new Dimension(1180, 873));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Tạo viền màu đen
        tableSanPham.getTableHeader().setBackground(Color.white);
        panel_12.add(jsp);


        // Thiết lập kích thước font cho các ô trong bảng
        Font font = new Font("Tahoma", Font.PLAIN, 16); // Chọn font và kích thước
        tableSanPham.setFont(font);
        tableSanPham.setRowHeight(50); // Thiết lập chiều cao hàng nếu cần
     // Các thiết lập khác
        // Thiết lập renderer cho tiêu đề cột
        tableSanPham.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề
        tableSanPham.getTableHeader().setReorderingAllowed(false);
        tableSanPham.getTableHeader().setResizingAllowed(false);
        loadTableData();
        tableSanPham.addMouseListener(this);
	}
	public void loadTableData() {
		ArrayList<Mon_Entity> list= mon_dao.danhSachMon();
		list.forEach(x->{
			model_SanPham.addRow(new Object[] {
				x.getMaMon(),x.getTenMon(),x.getLoaiMon(),x.getDonGia()	
			});
		});
	}
	public void XoaRong() {
		tMaMon.setText("");
		tTenMon.setText("");
		tDonGia.setText("");
		cbLoaiMon.setSelectedIndex(0);
		tSLNL.setText("");;
		cbNL.setSelectedIndex(0);
		model_NguyenLieu.setRowCount(0);
	}
	public void thongBao(String a, JTextField b) {
		JOptionPane.showMessageDialog(this, a);
		b.requestFocus();
		b.selectAll();
	}
	public boolean valid() {
	    String tenMon = tTenMon.getText().trim();
	    String donGia = tDonGia.getText().trim();

	    // Kiểm tra tên món
	    if (tenMon.isEmpty() || !tenMon.matches("[\\p{L}\\s]+")) {
	        thongBao("Tên món phải là chữ và không được rỗng", tTenMon);
	        return false;
	    }

	    // Kiểm tra đơn giá
	    if (donGia.isEmpty()) {
	        thongBao("Đơn giá không được rỗng", tDonGia);
	        return false;
	    }

	    try {
	        double donGiaValue = Double.parseDouble(donGia);
	        if (donGiaValue <= 0) {
	            thongBao("Đơn giá phải lớn hơn 0", tDonGia);
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        thongBao("Đơn giá phải là số", tDonGia);
	        return false;
	    }

	    // Kiểm tra nguyên liệu
	    if (tableNguyenLieu.getRowCount() < 1) {
	        JOptionPane.showMessageDialog(this, "Cần có nguyên liệu");
	        return false;
	    }

	    return true; // Trả về true nếu tất cả các kiểm tra đều hợp lệ
	}
	public void updateTable() {
		model_SanPham.getDataVector().removeAllElements();
		loadTableData();
	}
	public void loadTableTheoLoai(String a) {
		ArrayList<Mon_Entity> list= mon_dao.danhSachMonTheoLoai(a);
		System.out.println(list.size());
		model_SanPham.setRowCount(0);
		list.forEach(x->{
			model_SanPham.addRow(new Object[] {
				x.getMaMon(),x.getTenMon(),x.getLoaiMon(),x.getDonGia()	
			});
		});
		
	}
	public String generateMa() {
		int sl= mon_dao.getSLMon()+1;
		return String.format("M%03d",sl);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row= tableSanPham.getSelectedRow();
		if(row!=-1) {
			tMaMon.setText(tableSanPham.getValueAt(row, 0).toString());
			tTenMon.setText(tableSanPham.getValueAt(row, 1).toString());
			tDonGia.setText(tableSanPham.getValueAt(row, 3).toString());
			cbLoaiMon.setSelectedItem(tableSanPham.getValueAt(row, 2));
			model_NguyenLieu.getDataVector().removeAllElements();
			ArrayList<Object[]> a= mon_dao.getNguyenLieuTheoMaMon(tableSanPham.getValueAt(row, 0).toString());
			a.forEach(x->{
				model_NguyenLieu.addRow(x);
			});
		}
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
		Object o= e.getSource();
		if(o.equals(btnThemNL)) {
			if(!tSLNL.getText().trim().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this,"Số lượng phải là số");
			}
			else {
				model_NguyenLieu.addRow(new Object[] {
					cbNL.getSelectedItem().toString(), tSLNL.getText().trim()	
				});
				
			}
		}
		else if(o.equals(btnXoaNL)) {
			int row= tableNguyenLieu.getSelectedRow();
			if(row<0) {
				JOptionPane.showMessageDialog(this,"Cần chọn dòng để xóa");
			}
			else {
				model_NguyenLieu.removeRow(row);
			}
		}
		else if(o.equals(btnXoaRong)) {
			XoaRong();
		}
		else if(o.equals(btnSua)) {
			String maMon = tMaMon.getText().trim();
			if (maMon.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Cần chọn món trong danh sách");
			} else if (valid()) {
			    try {
			        // Xóa chi tiết món
			        mon_dao.deleteChiTietMon(maMon);
			        
			        Double donGia= Double.parseDouble(tDonGia.getText().trim());
			        // Tạo đối tượng món mới
			        Mon_Entity newMon = new Mon_Entity(maMon, tTenMon.getText().trim(), cbLoaiMon.getSelectedItem().toString(),donGia);
			        
			        // Cập nhật món
			        mon_dao.suaMon(newMon);
			        
			        // Duyệt qua từng nguyên liệu trong bảng
			        for (int i = 0; i < tableNguyenLieu.getRowCount(); i++) {
			            String tenNguyeLieu = tableNguyenLieu.getValueAt(i, 0).toString();
			            int soLuong = Integer.parseInt(tableNguyenLieu.getValueAt(i, 1).toString());
			            
			            // Tìm nguyên liệu theo mã
			            NguyenLieu_Entity nl1 = nl_dao.getNLTheoTen(tenNguyeLieu);
			            
			            // Thêm chi tiết món
			            mon_dao.themChiTietMon(newMon, nl1, soLuong);
			        }
			        
			        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			        updateTable();
			    } catch (Exception e1) {
			        e1.printStackTrace(); // In lỗi ra console để kiểm tra
			        JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
			    }
			}

		}
		else if(o.equals(btnThem)) {
			if(valid()) {
				try {
					Double donGia= Double.parseDouble(tDonGia.getText().trim());
					Mon_Entity newMon = new Mon_Entity(generateMa(), tTenMon.getText().trim(), cbLoaiMon.getSelectedItem().toString(),donGia,1);
					mon_dao.themMon(newMon);
					// Duyệt qua từng nguyên liệu trong bảng
			        for (int i = 0; i < tableNguyenLieu.getRowCount(); i++) {
			            String tenNguyeLieu = tableNguyenLieu.getValueAt(i, 0).toString();
			            int soLuong = Integer.parseInt(tableNguyenLieu.getValueAt(i, 1).toString());
			            
			            // Tìm nguyên liệu theo mã
			            NguyenLieu_Entity nl1 = nl_dao.getNLTheoTen(tenNguyeLieu);
			            
			            // Thêm chi tiết món
			            mon_dao.themChiTietMon(newMon, nl1, soLuong);
			        }
			        JOptionPane.showMessageDialog(this, "Thêm món thành công");
			        updateTable();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Thêm món thất bại");
				}
			}
	        
		}
		else if(o.equals(btnXoa)) {
			int row= tableSanPham.getSelectedRow();
			if(row<0) {
				JOptionPane.showMessageDialog(this,"Cần chọn món để xóa");
			}
			else {
				int confirm= JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa món này không");
				if(confirm==JOptionPane.YES_OPTION) {
					if(mon_dao.xoaMon(tableSanPham.getValueAt(row, 0).toString())) {
						JOptionPane.showMessageDialog(this,"Xóa thành công");
						updateTable();
					}
					else {
						JOptionPane.showMessageDialog(this,"Xóa thất bại");
					}
				}
			}
		}
		else if(o.equals(btnCaPhe)) {
			
			loadTableTheoLoai("Cà phê");
		}
		else if(o.equals(btnAll)) {
			updateTable();
		}
		else if(o.equals(btnDaXay)) {
			loadTableTheoLoai("Đá xay");
		}
		else if(o.equals(btnSinhTo)) {
			loadTableTheoLoai("Sinh tố");
		}
		else if(o.equals(btnTraSua)) {
			loadTableTheoLoai("Trà sữa");
		}
		else if(o.equals(btnThucUongKhac)) {
			loadTableTheoLoai("Thức uống khác");
		}
		else if(o.equals(btnBanh)) {
			loadTableTheoLoai("Bánh");
		}
		
	}

}
