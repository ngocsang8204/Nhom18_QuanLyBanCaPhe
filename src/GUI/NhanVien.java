package GUI;

import java.awt.Color;
import java.awt.Component;
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
import Entity.NhanVien_Entity;

import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

public class NhanVien extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField tMaNhanVien;
	private JTextField tTenNhanVien;
	private JTextField tSoDienThoai;
	private JTextField tSoCCCD;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField tTimKiem;
	private JButton btnTimKiem;
	private JTextField tDiaChi;
	private NhanVien_DAO nhanVien_DAO;
	private JComboBox<String> comboBox;
	private int previousRow = -1;
	private JButton btnXoaRong;
	/**
	 * Create the panel.
	 */
	public NhanVien() {
		
		nhanVien_DAO = new NhanVien_DAO();
		
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
        
        JLabel lblNewLabel = new JLabel("Thông tin nhân viên");
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
        
        JLabel lb1 = new JLabel("Mã nhân viên: ");
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lb1);
        
        tMaNhanVien = new JTextField(28);
        panel_4.add(tMaNhanVien);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_1);
        
        JLabel lb2 = new JLabel("Tên nhân viên: ");
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_1.add(lb2);
        
        tTenNhanVien = new JTextField();
        panel_4_1.add(tTenNhanVien);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_2);
        
        JLabel lb3 = new JLabel("Số CCCD: ");
        lb3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_2.add(lb3);
        
        JPanel panel_4_3 = new JPanel();
        panel_4_3.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_3);
        
        JLabel lb4 = new JLabel("Số điện thoại: ");
        lb4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3.add(lb4);
        
        
        tSoDienThoai = new JTextField();
        panel_4_3.add(tSoDienThoai);
        
        tSoCCCD = new JTextField(); 
        panel_4_2.add(tSoCCCD);
        
        JPanel panel_4_3_1 = new JPanel();
        panel_4_3_1.setBackground(Color.WHITE);
        panel_3.add(panel_4_3_1);
        
        JLabel lb5 = new JLabel("Địa chỉ:");
        lb5.setPreferredSize(new Dimension(170, 20));
        lb5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3_1.add(lb5);
        
        tDiaChi = new JTextField();
        tDiaChi.setPreferredSize(new Dimension(230, 30));
        panel_4_3_1.add(tDiaChi);
        
        JPanel panel_4_3_2 = new JPanel();
        panel_4_3_2.setBackground(Color.WHITE);
        panel_3.add(panel_4_3_2);
        
        JLabel lb6 = new JLabel("Chức vụ: ");
        lb6.setPreferredSize(new Dimension(170, 20));
        lb6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3_2.add(lb6);
        
        comboBox = new JComboBox<String>();
        panel_4_3_2.add(comboBox);
        comboBox.addItem("Quản lý");
        comboBox.addItem("Nhân viên");
        
        tMaNhanVien.setPreferredSize(new Dimension(tMaNhanVien.getPreferredSize().width,30));
        tMaNhanVien.setEditable(false);
        tTenNhanVien.setPreferredSize(new Dimension(tMaNhanVien.getPreferredSize().width,30));
        tSoDienThoai.setPreferredSize(new Dimension(tMaNhanVien.getPreferredSize().width,30));
        tSoCCCD.setPreferredSize(new Dimension(tMaNhanVien.getPreferredSize().width,30));
        tDiaChi.setPreferredSize(new Dimension(tMaNhanVien.getPreferredSize().width,30));
        comboBox.setPreferredSize(tDiaChi.getPreferredSize());
        
        lb1.setPreferredSize(new Dimension(170,20));
        lb2.setPreferredSize(new Dimension(170,20));
        lb3.setPreferredSize(new Dimension(170,20));
        lb4.setPreferredSize(new Dimension(170,20));
        lb5.setPreferredSize(new Dimension(170,20));
        lb6.setPreferredSize(new Dimension(170,20));
        
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_5.setPreferredSize(new Dimension(panel_3.getPreferredSize().width,600));
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
        
        JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ NHÂN VIÊN");
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
        String[] colnames = new String[] { "Mã nhân viên","Tên nhân viên", "Số CCCD", "Số điện thoại", "Địa chỉ", "Chức vụ"};
        model = new DefaultTableModel(colnames, 0);
        // Sau khi khởi tạo JTable và JScrollPane
        table = new JTable(model);
        table.setFocusable(false);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(4).setMinWidth(300);
        table.getColumnModel().getColumn(4).setMaxWidth(500); // Giới hạn kích thước tối đa nếu cần
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(1180, 873));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Tạo viền màu đen
        table.getTableHeader().setBackground(Color.white);
        panel_12.add(jsp);
        table.getTableHeader().setReorderingAllowed(false);

        // Thiết lập kích thước font cho các ô trong bảng
        Font font = new Font("Tahoma", Font.PLAIN, 16); // Chọn font và kích thước
        table.setFont(font);
        table.setRowHeight(50); // Thiết lập chiều cao hàng nếu cần
        // Thiết lập renderer cho tiêu đề cột
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề
        table.getTableHeader().setResizingAllowed(false);
        
        loadData();
        table.addMouseListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnTimKiem.addActionListener(this);
        btnXoaRong.addActionListener(this);
        
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
	    	    tMaNhanVien.setText(model.getValueAt(row, 0).toString());
				tTenNhanVien.setText(model.getValueAt(row, 1).toString());
				tSoCCCD.setText(model.getValueAt(row, 2).toString());
				tSoDienThoai.setText(model.getValueAt(row, 3).toString());
				tDiaChi.setText(model.getValueAt(row, 4).toString());
				comboBox.setSelectedItem(model.getValueAt(row, 5));
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
			if (validData()) {
				them();
			}
		}
		if (o.equals(btnSua)) {
			if (validData()) {
				sua();
			}
		}
		if (o.equals(btnTimKiem)) {
			
		}
		if (o.equals(btnXoaRong)) {
			clear();
		}
		// TODO Auto-generated method stub
		
	}
	
	

    private void them() {
		NhanVien_Entity nv = revert();
		List<NhanVien_Entity> listTopNhanVien = nhanVien_DAO.danhSachNhanVien();
		for(NhanVien_Entity nvv: listTopNhanVien) {
			if (nv.getMaNhanVien().equals(nvv.getMaNhanVien())) {
				JOptionPane.showMessageDialog(null, "Nhân viên này đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (nhanVien_DAO.themNhanVien(nv)) {
			JOptionPane.showMessageDialog(null, "Thêm thành công", "Thành công", JOptionPane.DEFAULT_OPTION);
			String chucVu;
			if (nv.getChucVu()==true) {
				chucVu = "Quản lý";
			}else {
				chucVu = "Nhân viên";
			}
			model.addRow(new Object[]{
	                nv.getMaNhanVien(), 
	                nv.getTenNhanVien(), 
	                nv.getSoCCCD(), 
	                nv.getSoDienThoai(), 
	                nv.getDiaChi(), 
	                chucVu
	            });
			
		}else {
			JOptionPane.showMessageDialog(null, "Nhân viên này đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    private void sua() {
    	if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					String ma = tMaNhanVien.getText().trim();
					String ten = tTenNhanVien.getText().trim();
					String soCCCD = tSoCCCD.getText().trim();
					String SDT = tSoDienThoai.getText().trim();
					String diaChi = tDiaChi.getText().trim();
					String chucVuu = comboBox.getSelectedItem().toString();
					boolean chucVu;
					if (comboBox.getSelectedItem()=="Quản lý") {
						chucVu = true;
					}else {
						chucVu = false;
					}
					// Cập nhật thông tin trong bảng
					model.setValueAt(ma, row, 0);
					model.setValueAt(ten, row, 1);
					model.setValueAt(soCCCD, row, 2);
					model.setValueAt(SDT, row, 3);
					model.setValueAt(diaChi, row, 4);
					model.setValueAt(chucVuu, row, 5);

					NhanVien_Entity nv = new NhanVien_Entity(ma, ten, soCCCD, SDT, diaChi, chucVu);
					boolean updated = nhanVien_DAO.suaNhanVien(nv);
					if (updated) {
					    JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
					} else {
					    JOptionPane.showMessageDialog(null, "Cập nhật không thành công. Vui lòng thử lại.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ cần sửa.");
				}
			}
    }
    private void loadData() {
	    model.setRowCount(0);
	    String chucVu;
        for (NhanVien_Entity nv : nhanVien_DAO.danhSachNhanVien()) {
        	if (nv.getChucVu()==true) {
				chucVu = "Quản lý";
			}else {
				chucVu = "Nhân viên";
			}
            model.addRow(new Object[]{
                nv.getMaNhanVien(), 
                nv.getTenNhanVien(), 
                nv.getSoCCCD(), 
                nv.getSoDienThoai(), 
                nv.getDiaChi(), 
                chucVu
            });
	    }
	}
	private void clear() {
		tMaNhanVien.setText("");
		tTenNhanVien.setText("");
		tSoCCCD.setText("");
		tSoDienThoai.setText("");
		tDiaChi.setText("");
		comboBox.setSelectedIndex(0);
		// TODO Auto-generated method stub
		
	}
	protected NhanVien_Entity revert() {
		String ma;
		if (tMaNhanVien.getText().trim().equals("")) {
			ma = taoMa();
		}else {
			ma = tMaNhanVien.getText().trim();
		}
		String ten = tTenNhanVien.getText().trim();
		String soCCCD = tSoCCCD.getText().trim();
		String SDT = tSoDienThoai.getText().trim();
		String diaChi = tDiaChi.getText().trim();
		boolean chucVu;
		if (comboBox.getSelectedItem()=="Quản lý") {
			chucVu = true;
		}else {
			chucVu = false;
		}
		return new NhanVien_Entity(ma, ten, soCCCD, SDT, diaChi, chucVu);
	}
	private String taoMa() {
		String lastMa = nhanVien_DAO.getMaxMaNhanVien();
		int newNumber = 1;
		if (lastMa != null && !lastMa.isEmpty()) {
			String numberPart = lastMa.substring(2);
			newNumber = Integer.parseInt(numberPart) + 1;
		}

		String newMa = String.format("NV%03d", newNumber);
		return newMa;
	}
	
	private boolean validData() {
		String ten = tTenNhanVien.getText().trim();
		String soCCCD = tSoCCCD.getText().trim();
		String sdt = tSoDienThoai.getText().trim();
		String diaChi = tDiaChi.getText().trim();
		
		if (ten.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được rỗng","Sai",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!ten.matches("^([A-ZÀ-Ỵ][a-zà-ỵ]*(\\s[A-ZÀ-Ỵ][a-zà-ỵ]*)*)$")) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng phải 2 từ trở lên","Sai",JOptionPane.ERROR_MESSAGE);
			requestFocus();
			return false;
		}
		
		if (soCCCD.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Số CCCD không được rỗng","Sai",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!soCCCD.matches("^\\d{12}$")) {
			JOptionPane.showMessageDialog(null, "Số CCCD phải 12 số","Sai",JOptionPane.ERROR_MESSAGE);
			requestFocus();
			return false;
		}
		
		if (sdt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được rỗng","Sai",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!sdt.matches("^(03|05|07|08|09)[0-9]{8}$")) {
			JOptionPane.showMessageDialog(null, "số điện thoại phải có 10 chữ số và bắt đầu với các đầu số: 03x, 05x, 07x, 08x hoặc 09x.","Sai",JOptionPane.ERROR_MESSAGE);
			requestFocus();
			return false;
		}
		
		if (diaChi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được rỗng","Sai",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!diaChi.matches("^[\\p{L}0-9\\s,.-]+$")) {
			JOptionPane.showMessageDialog(null, "Địa chỉ sai","Sai",JOptionPane.ERROR_MESSAGE);
			requestFocus();
			return false;
		}
		
		
		
		return true;
	}
}
