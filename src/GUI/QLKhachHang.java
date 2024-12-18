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

import DAO.KhachHang_DAO;
import Entity.KhachHang_Entity;
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
import java.util.List;

public class QLKhachHang extends JPanel implements ActionListener, MouseListener{

	private JTextField tMaKhachHang;
	private JTextField tTenKhachHang;
	private JTextField tSoDienThoai;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField tTimKiem;
	private JButton btnTimKiem;
	private JButton btnXoaRong;
	private KhachHang_DAO khachHang_DAO;
	private int previousRow = -1;

	public QLKhachHang() {
		khachHang_DAO = new KhachHang_DAO();
		
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1036, 658);
        setLayout(new BorderLayout(0, 0));
        
        JPanel rigth_panel = new JPanel();
        rigth_panel.setBackground(new Color(255, 255, 255));
        add(rigth_panel, BorderLayout.EAST);
        rigth_panel.setLayout(new BorderLayout(0, 0));
        
        JPanel left_header = new JPanel();
        left_header.setBackground(new Color(255, 255, 255));
        rigth_panel.add(left_header, BorderLayout.NORTH);
        left_header.setLayout(new GridLayout(3, 1, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("                       ");
        left_header.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        left_header.add(lblNewLabel);
        
        JLabel lblNewLabel_1_1 = new JLabel("                       ");
        left_header.add(lblNewLabel_1_1);

        JPanel left_content = new JPanel();
        left_content.setBackground(new Color(255, 255, 255));
        rigth_panel.add(left_content, BorderLayout.CENTER);
        left_content.setLayout(new BoxLayout(left_content, BoxLayout.Y_AXIS));
        
        JPanel maKH = new JPanel();
        maKH.setBackground(new Color(255, 255, 255));
        left_content.add(maKH);
        
        JLabel lb1 = new JLabel("Mã khách hàng: ");
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        maKH.add(lb1);
        
        tMaKhachHang = new JTextField(28);
        maKH.add(tMaKhachHang);
        
        JPanel tenKH = new JPanel();
        tenKH.setBackground(new Color(255, 255, 255));
        left_content.add(tenKH);
        
        JLabel lb2 = new JLabel("Tên khách hàng: ");
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tenKH.add(lb2);
        
        tTenKhachHang = new JTextField();
        tenKH.add(tTenKhachHang);
        
        JPanel soDT = new JPanel();
        soDT.setBackground(new Color(255, 255, 255));
        left_content.add(soDT);
        
        JLabel lb3 = new JLabel("Số điện thoại: ");
        lb3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        soDT.add(lb3);
        
        tSoDienThoai = new JTextField(); 
        soDT.add(tSoDienThoai);
        
        tMaKhachHang.setPreferredSize(new Dimension(tMaKhachHang.getPreferredSize().width,30));
        tMaKhachHang.setEditable(false);
        tTenKhachHang.setPreferredSize(new Dimension(tMaKhachHang.getPreferredSize().width,30));
        tSoDienThoai.setPreferredSize(new Dimension(tMaKhachHang.getPreferredSize().width,30));
        
        lb1.setPreferredSize(new Dimension(170,20));
        lb2.setPreferredSize(new Dimension(170,20));
        lb3.setPreferredSize(new Dimension(170,20));
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_5.setPreferredSize(new Dimension(left_content.getPreferredSize().width,770));
        rigth_panel.add(panel_5,BorderLayout.SOUTH);
        
        JLabel lblNewLabel_1_2 = new JLabel("                       ");
        panel_5.add(lblNewLabel_1_2);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        panel_6.setPreferredSize(new Dimension(left_content.getPreferredSize().width,50));
        panel_5.add(panel_6);
        
        btnThem = new JButton("Thêm");
        btnThem.setIcon(new ImageIcon(QLMon.class.getResource("/img/icons8-add-30.png")));
        panel_6.add(btnThem);
        
        panel_6.add(Box.createHorizontalStrut(2));
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(93, 39));
        btnSua.setIcon(new ImageIcon(QLMon.class.getResource("/img/icons8-tools-30.png")));
        panel_6.add(btnSua);
        
        Component horizontalStrut = Box.createHorizontalStrut(2);
        panel_6.add(horizontalStrut);
        
        btnXoaRong = new JButton("Xóa rỗng");
        btnXoaRong.setIcon(new ImageIcon(QLTaiKhoan.class.getResource("/img/icons8-erase-30.png")));
        panel_6.add(btnXoaRong);
        
        JPanel left_panel = new JPanel();
        left_panel.setBackground(new Color(255, 255, 255));
        add(left_panel, BorderLayout.CENTER);
        left_panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(255, 255, 255));
        left_panel.add(panel_7, BorderLayout.NORTH);
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
        
        JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ KHÁCH HÀNG");
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
            new Font("Tahoma", Font.PLAIN, 16),
            new Color(0, 0, 0)
        ));

        panel_9.add(panel_11);
        
        btnTimKiem = new JButton("");
        btnTimKiem.setIcon(new ImageIcon(QLNhaCungCap.class.getResource("/img/icons8-search-30.png")));
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
        left_panel.add(panel_12, BorderLayout.CENTER);
        String[] colnames = new String[] { "Mã khách hàng","Tên khách hàng", "Số điện thoại"};
        model = new DefaultTableModel(colnames, 0);
        table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
        table.setFocusable(false);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(1180, 873));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        table.getTableHeader().setBackground(Color.white);
        panel_12.add(jsp);

        Font font = new Font("Tahoma", Font.PLAIN, 16);
        table.setFont(font);
        table.setRowHeight(50);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        
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
    			table.clearSelection();
    			
    		} else {
	    	    tMaKhachHang.setText(model.getValueAt(row, 0).toString());
				tTenKhachHang.setText(model.getValueAt(row, 1).toString());
				tSoDienThoai.setText(model.getValueAt(row, 2).toString());
	    	    previousRow = row;
    	
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
			String tim = tTimKiem.getText().trim();
			if (tim.length() <= 0) {
				JOptionPane.showMessageDialog(this, "Nhập vào ô tìm kiếm");
				loadData();
			} else {
				if (tim.matches("^[0-9]{10}$")) {
					KhachHang_Entity kh = khachHang_DAO.timKiemTenKhachHangTheoSDT(tim);
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					themDong(kh);
				} else {
					ArrayList<KhachHang_Entity> dsKH = khachHang_DAO.timKiemKhachHangTheoTen(tim);
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					dsKH.forEach(x -> themDong(x));
				}
			}
 		}
		if (o.equals(btnXoaRong)) {
			clear();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	private void themDong(KhachHang_Entity a) {
		model.addRow(new Object[] {a.getMaKhachHang(), a.getTenKhachHang(), a.getSoDienThoai()});
	}
	
	private void clear() {
		tMaKhachHang.setText("");
		tTenKhachHang.setText("");
		tSoDienThoai.setText("");
		// TODO Auto-generated method stub
		
	}
	
	protected KhachHang_Entity revert() {
		String ma;
		if (tMaKhachHang.getText().trim().equals("")) {
			ma = taoMa();
		}else {
			ma = tMaKhachHang.getText().trim();
		}
		String ten = tTenKhachHang.getText().trim();
		String sdt = tSoDienThoai.getText().trim();
		return new KhachHang_Entity(ma, ten, sdt);
	}
	private String taoMa() {
		int sl= khachHang_DAO.getSLKH()+1;
		return String.format("KH%03d",sl);
	}
	

	private void sua() {
		if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String ma = tMaKhachHang.getText().trim();
				String ten = tTenKhachHang.getText().trim();
				String sdt = tSoDienThoai.getText().trim();
				model.setValueAt(ma, row, 0);
				model.setValueAt(ten, row, 1);
				model.setValueAt(sdt, row, 2);
				KhachHang_Entity kh = new KhachHang_Entity(ma, ten, sdt);
				boolean updated = khachHang_DAO.suaKhachHang(kh);
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

	private void them() {
		KhachHang_Entity kh = revert();
	    List<KhachHang_Entity> listTopKH = khachHang_DAO.danhSachKhachHang();  
	    for (KhachHang_Entity khh : listTopKH) {
	        if (kh.getMaKhachHang().equals(khh.getMaKhachHang())) {
	            JOptionPane.showMessageDialog(null, "Kháchh này đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    }
	    if (khachHang_DAO.themKhachHang(kh)) {
	        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thành công", JOptionPane.DEFAULT_OPTION);
	        model.addRow(new Object[]{
        		kh.getMaKhachHang(),
                kh.getTenKhachHang(),
                kh.getSoDienThoai()
	        });
	    } else {
	        JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng vào cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
		// TODO Auto-generated method stub
		
	}

	private void loadData() {
	    model.setRowCount(0);
        for (KhachHang_Entity kh : khachHang_DAO.danhSachKhachHang()) {
            model.addRow(new Object[]{
               kh.getMaKhachHang(),
               kh.getTenKhachHang(),
               kh.getSoDienThoai()
            });
	    }
	}
	
	private boolean validData() {
		String ten = tTenKhachHang.getText().trim();
		String sdt = tSoDienThoai.getText().trim();
		
		if (ten.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không được rỗng","Sai",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!ten.matches("^([A-ZÀ-Ỵ][a-zà-ỵ]*(\\s[A-ZÀ-Ỵ][a-zà-ỵ]*)*)$")) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng phải 2 từ trở lên","Sai",JOptionPane.ERROR_MESSAGE);
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
		
		return true;
	}
	
	

}
