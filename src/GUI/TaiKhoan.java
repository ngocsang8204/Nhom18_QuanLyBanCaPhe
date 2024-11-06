package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.NhanVien_Entity;
import Entity.TaiKhoan_Entity;

import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Component;

public class TaiKhoan extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField tMaTaiKhoan;
	private JTextField tTenDangNhap;
	private JTextField tMatKhau;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField tTimKiem;
	private JButton btnTimKiem;
	private JComboBox<String> cbb_MaNhanVien;
	private int previousRow = -1;
	private TaiKhoan_DAO taiKhoan_DAO;
	private NhanVien_DAO nhanVien_DAO;
	private JButton btnXoaRong;

	/**
	 * Create the panel.
	 */
	public TaiKhoan() {
		nhanVien_DAO = new NhanVien_DAO();
		taiKhoan_DAO = new TaiKhoan_DAO();
		
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
        
        JLabel lblNewLabel = new JLabel("Thông tin tài khoản");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_1_1 = new JLabel("                       ");
        panel_2.add(lblNewLabel_1_1);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4);
        
        JLabel lbMaTaiKhoan = new JLabel("Mã tài khoản: ");
        lbMaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lbMaTaiKhoan);
        
        tMaTaiKhoan = new JTextField(28);
        panel_4.add(tMaTaiKhoan);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_1);
        
        JLabel lbTenTaiKhoan = new JLabel("Tên đăng nhập");
        lbTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_1.add(lbTenTaiKhoan);
        
        tTenDangNhap = new JTextField();
        panel_4_1.add(tTenDangNhap);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_2);
        
        JLabel lbMatKhau = new JLabel("Mật khẩu: ");
        lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_2.add(lbMatKhau);
        
        JPanel panel_4_3 = new JPanel();
        panel_4_3.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_3);
        
        JLabel lbMaNhanVien = new JLabel("Mã nhân viên: ");
        lbMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3.add(lbMaNhanVien);
        
        
        cbb_MaNhanVien = new JComboBox<String>();
        panel_4_3.add(cbb_MaNhanVien);
        List<String> listMaNV = nhanVien_DAO.getAllNhanVien();
        for(String maNV : listMaNV) {
        	cbb_MaNhanVien.addItem(maNV);
        }
        
        tMatKhau = new JTextField(); 
        panel_4_2.add(tMatKhau);
        
        tMaTaiKhoan.setPreferredSize(new Dimension(tMaTaiKhoan.getPreferredSize().width,30));
        tMaTaiKhoan.setEditable(false);
        tTenDangNhap.setPreferredSize(new Dimension(tMaTaiKhoan.getPreferredSize().width,30));
        cbb_MaNhanVien.setPreferredSize(new Dimension(tMaTaiKhoan.getPreferredSize().width,30));
        tMatKhau.setPreferredSize(new Dimension(tMaTaiKhoan.getPreferredSize().width,30));
        
        lbMaTaiKhoan.setPreferredSize(new Dimension(170,20));
        lbTenTaiKhoan.setPreferredSize(new Dimension(170,20));
        lbMatKhau.setPreferredSize(new Dimension(170,20));
        lbMaNhanVien.setPreferredSize(new Dimension(170,20));
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_5.setPreferredSize(new Dimension(panel_3.getPreferredSize().width,700));
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
        
        panel_6.add(Box.createHorizontalStrut(2));
        
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(93, 39));
        btnSua.setIcon(new ImageIcon(Mon.class.getResource("/img/icons8-tools-30.png")));
        panel_6.add(btnSua);
        
        Component horizontalStrut = Box.createHorizontalStrut(2);
        panel_6.add(horizontalStrut);
        
        btnXoaRong = new JButton("Xóa rỗng");
        btnXoaRong.setIcon(new ImageIcon(TaiKhoan.class.getResource("/img/icons8-erase-30.png")));
        panel_6.add(btnXoaRong);
        
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
        
        JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ TÀI KHOẢN");
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
        
        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_12, BorderLayout.CENTER);
        // Table Model and JTable
        String[] colnames = new String[] { "Mã tài khoản","Tên đăng nhập", "Mật khẩu", "Mã nhân viên"};
        model = new DefaultTableModel(colnames, 0);
        // Sau khi khởi tạo JTable và JScrollPane
        table = new JTable(model);
        table.setFocusable(false);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(1180, 873));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Tạo viền màu đen
        table.getTableHeader().setBackground(Color.white);
        panel_12.add(jsp);


        // Thiết lập kích thước font cho các ô trong bảng
        Font font = new Font("Tahoma", Font.PLAIN, 16); // Chọn font và kích thước
        table.setFont(font);
        table.setRowHeight(50); // Thiết lập chiều cao hàng nếu cần

        // Thiết lập renderer cho tiêu đề cột
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề

        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        
        table.addMouseListener(this);
        btnThem.addActionListener(this);
        btnTimKiem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoaRong.addActionListener(this);
        loadData();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			int row = table.getSelectedRow();
			if(row == previousRow) {
    	    	clear();
    			previousRow = -1;
    			
    		} else {
	    	    tMaTaiKhoan.setText(model.getValueAt(row, 0).toString());
				tTenDangNhap.setText(model.getValueAt(row, 1).toString());
				tMatKhau.setText(model.getValueAt(row, 2).toString());
				cbb_MaNhanVien.setSelectedItem(model.getValueAt(row, 3));
	    	    previousRow = row;
    	        // Đặt cờ là true khi một hàng được chọn
    	
    	    }
		}
		// TODO Auto-generated method stub
		
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
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			them();
		}
		if (o.equals(btnSua)) {
			sua();
		}
		if (o.equals(btnTimKiem)) {
			
		}
		if (o.equals(btnXoaRong)) {
			clear();
		}
		// TODO Auto-generated method stub
		
	}
	
	private void sua() {
		if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String ma = tMaTaiKhoan.getText().trim();
				String ten = tTenDangNhap.getText().trim();
				String matkhau = tMatKhau.getText().trim();
				String maNV = cbb_MaNhanVien.getSelectedItem().toString();
				// Cập nhật thông tin trong bảng
				model.setValueAt(ma, row, 0);
				model.setValueAt(ten, row, 1);
				model.setValueAt(matkhau, row, 2);
				model.setValueAt(maNV, row, 3);
				NhanVien_Entity nv = nhanVien_DAO.timNhanVienTheoMa(maNV);
				TaiKhoan_Entity tk = new TaiKhoan_Entity(ma, ten, matkhau, nv);
				boolean updated = taiKhoan_DAO.suaTaiKhoan(tk);
				if (updated) {
				    JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				} else {
				    JOptionPane.showMessageDialog(null, "Cập nhật không thành công. Vui lòng thử lại.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ cần sửa.");
			}
		}
		// TODO Auto-generated method stub
		
	}

	private void loadData() {
	    model.setRowCount(0);
        for (TaiKhoan_Entity tk : taiKhoan_DAO.danhSachTaiKhoan()) {
            model.addRow(new Object[]{
                tk.getMaTaiKhoan(),
                tk.getTenDangNhap(),
                tk.getMatKhau(),
                tk.getNhanVien().getMaNhanVien()
            });
	    }
	}
	private void clear() {
		tMaTaiKhoan.setText("");
		tTenDangNhap.setText("");
		tMatKhau.setText("");
		cbb_MaNhanVien.setSelectedIndex(0);
		// TODO Auto-generated method stub
	}
	protected TaiKhoan_Entity revert() {
		String ma;
		if (tMaTaiKhoan.getText().trim().equals("")) {
			ma = taoMa();
		}else {
			ma = tMaTaiKhoan.getText().trim();
		}
		String ten = tTenDangNhap.getText().trim();
		String matkhau = tMatKhau.getText().trim();
		String manv = (String) cbb_MaNhanVien.getSelectedItem();
		NhanVien_Entity nv = nhanVien_DAO.timNhanVienTheoMa(manv);
		return new TaiKhoan_Entity(ma, ten, matkhau, nv);
	}
	private String taoMa() {
		int sl= taiKhoan_DAO.getSLTaiKhoan()+1;
		return String.format("TK%03d",sl);
	}
	
	private void them() {
	    TaiKhoan_Entity tk = revert();
	    List<TaiKhoan_Entity> listTopTaiKhoan = taiKhoan_DAO.danhSachTaiKhoan();
	    
	    // Kiểm tra nếu tài khoản đã tồn tại trong danh sách
	    for (TaiKhoan_Entity tkk : listTopTaiKhoan) {
	        if (tk.getMaTaiKhoan().equals(tkk.getMaTaiKhoan())) {
	            JOptionPane.showMessageDialog(null, "Tài khoản này đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    }

	    // Thêm tài khoản nếu không trùng lặp
	    if (taiKhoan_DAO.themTaiKhoan(tk)) {
	        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thành công", JOptionPane.DEFAULT_OPTION);
	        model.addRow(new Object[]{
	            tk.getMaTaiKhoan(),
	            tk.getTenDangNhap(),
	            tk.getMatKhau(),
	            tk.getNhanVien().getMaNhanVien()
	        });
	    } else {
	        JOptionPane.showMessageDialog(null, "Lỗi khi thêm tài khoản vào cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}


}
