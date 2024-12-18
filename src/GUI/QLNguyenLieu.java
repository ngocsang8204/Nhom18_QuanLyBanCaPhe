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
import javax.swing.text.DateFormatter;

import com.toedter.calendar.JDateChooser;

import DAO.NguyenLieu_DAO;
import DAO.NhaCungCap_DAO;
import Entity.NguyenLieu_Entity;
import Entity.NhaCungCap_Entity;

import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class QLNguyenLieu extends JPanel implements ActionListener,MouseListener{

	private JTextField tMaNguyenLieu;
	private JTextField tTenNguyenLieu;
	private JTextField tSoLuong;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField tTimKiem;
	private JButton btnTimKiem;
	private JDateChooser thoiGianNhapHang;
	private JDateChooser thoiGianHetHan;
	private JButton btnXoaRong;
	private NguyenLieu_DAO nl_dao= new NguyenLieu_DAO();
	private NhaCungCap_DAO ncc_dao= new NhaCungCap_DAO();
	private JComboBox<String> cbNCC;
	private int previousRow=-1;

	public QLNguyenLieu() {
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
        
        JLabel lblNewLabel = new JLabel("Thông tin nguyên liệu");
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
        
        JLabel lb1 = new JLabel("Mã nguyên liệu:");
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lb1);
        
        tMaNguyenLieu = new JTextField(28);
        panel_4.add(tMaNguyenLieu);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_1);
        
        JLabel lb2 = new JLabel("Tên nguyên liệu:");
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_1.add(lb2);
        
        tTenNguyenLieu = new JTextField();
        panel_4_1.add(tTenNguyenLieu);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_2);
        
        JLabel lb3 = new JLabel("Số lượng: ");
        lb3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_2.add(lb3);
        
        JPanel panel_4_3 = new JPanel();
        panel_4_3.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_3);
        
        JLabel lb4 = new JLabel("Thời gian nhập hàng: ");
        lb4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3.add(lb4);
        
        thoiGianNhapHang = new JDateChooser();
        thoiGianNhapHang.setDate(new Date());
        thoiGianNhapHang.setDateFormatString("dd/MM/yyyy");
        panel_4_3.add(thoiGianNhapHang);
        
        tSoLuong = new JTextField(); 
        panel_4_2.add(tSoLuong);
        
        JPanel panel_4_3_1 = new JPanel();
        panel_4_3_1.setBackground(Color.WHITE);
        panel_3.add(panel_4_3_1);
        
        JLabel lb5 = new JLabel("Thời gian hết hạn: ");
        lb5.setPreferredSize(new Dimension(170, 20));
        lb5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3_1.add(lb5);
        
        thoiGianHetHan = new JDateChooser();
        thoiGianHetHan.setDateFormatString("dd/MM/yyyy");
        thoiGianHetHan.setDate(new Date());
        panel_4_3_1.add(thoiGianHetHan);
        
        JPanel panel_4_3_2 = new JPanel();
        panel_4_3_2.setBackground(Color.WHITE);
        panel_3.add(panel_4_3_2);
        
        JLabel lb6 = new JLabel("Tên nhà cung cấp: ");
        lb6.setPreferredSize(new Dimension(170, 20));
        lb6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3_2.add(lb6);
        
        cbNCC = new JComboBox();
        cbNCC.setBackground(new Color(255, 255, 255));
        loadComboBoxNCC();
        panel_4_3_2.add(cbNCC);
        
        
        tMaNguyenLieu.setPreferredSize(new Dimension(tMaNguyenLieu.getPreferredSize().width,30));
        tMaNguyenLieu.setEditable(false);
        tTenNguyenLieu.setPreferredSize(new Dimension(tMaNguyenLieu.getPreferredSize().width,30));
        tSoLuong.setPreferredSize(new Dimension(tMaNguyenLieu.getPreferredSize().width,30));
        thoiGianNhapHang.setPreferredSize(new Dimension(tMaNguyenLieu.getPreferredSize().width,30));
        thoiGianHetHan.setPreferredSize(new Dimension(tMaNguyenLieu.getPreferredSize().width,30));
        cbNCC.setPreferredSize(new Dimension(tMaNguyenLieu.getPreferredSize().width,30));
        
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
        
        JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ NGUYÊN LIỆU");
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
        btnTimKiem.addActionListener(this);
        
        tTimKiem = new JTextField(25);
        tTimKiem.setOpaque(false);
        tTimKiem.setForeground(Color.BLACK);
        tTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tTimKiem.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        panel_11.add(tTimKiem);
        
        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_12, BorderLayout.CENTER);
        String[] colnames = new String[] { "Mã nguyên liệu","Tên nguyên liệu", "Số lượng", "Thời gian nhập hàng", "Thời gian hết hạn", "Tên nhà cung cấp"};
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
        loadTable();
        
        btnXoaRong.addActionListener(this);
        btnSua.addActionListener(this);
        btnThem.addActionListener(this);
	}
	public void loadComboBoxNCC() {
		ArrayList<NhaCungCap_Entity> ncc= ncc_dao.danhSachNhaCungCap();
		ncc.forEach(x->{
			cbNCC.addItem(x.getTenNhaCungCap());
		});
	}
	public void loadTable() {
		model.getDataVector().removeAllElements();
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<NguyenLieu_Entity> ds= nl_dao.danhSachNguyenLieuConHan();
		ds.stream().forEach(x->{
			model.addRow(new Object[] {
					x.getMaNguyenLieu(),x.getTenNguyenLieu(),x.getSoLuong(),df.format(x.getThoiGianNhap()),df.format(x.getThoiGianHetHan()),
					x.getNhaCungCap().getTenNhaCungCap()
			});
		});
		
	}
	public void xoaRong() {
		tMaNguyenLieu.setText("");
		tTenNguyenLieu.setText("");
		tSoLuong.setText("");
		cbNCC.setSelectedIndex(0);
		thoiGianNhapHang.setDate(new Date());
		thoiGianHetHan.setDate(new Date());
	}
	public void setDateFromString(String dateString, JDateChooser dateChooser) {
        try {
           
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(dateString);
            dateChooser.setDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	public void thongBao(String a, JTextField b) {
		JOptionPane.showMessageDialog(this, a);
		b.requestFocus();
		b.selectAll();
	}
	public boolean valid() {
		
		String ten= tTenNguyenLieu.getText().trim();
		String soLuong= tSoLuong.getText().trim();
		Date nhap= thoiGianNhapHang.getDate();
		Date hh= thoiGianHetHan.getDate();
		
		if(!ten.matches("[\\p{L}\\s\\d]+")||ten.equals("")) {
			thongBao("Tên nguyên liệu không được rỗng", tTenNguyenLieu);
			return false;
		}
		try {
			int sl= Integer.parseInt(soLuong);
			if(sl<=0){
				thongBao("Số lượng phải lớn hơn 0", tSoLuong);
				return false;
			}
		} catch (Exception e) {
			thongBao("Số lượng phải là số", tSoLuong);
			return false;
		}
		if(hh.before(nhap)) {
			JOptionPane.showMessageDialog(this,"Ngày nhập phải trước ngày hết hạn");
			return false;
		}
		
		return true;
	}
	private String generateMa() {
		int sl= nl_dao.getSLNL();
		return String.format("NL%03d",sl+1);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row= table.getSelectedRow();
		if(row!=-1) {
			if(row==previousRow) {
				xoaRong();
				previousRow=-1;
				table.clearSelection();
			}
			else {
				tMaNguyenLieu.setText(table.getValueAt(row, 0).toString());;
				tTenNguyenLieu.setText(table.getValueAt(row, 1).toString());
				tSoLuong.setText(table.getValueAt(row, 2).toString());

				String hetHanStr = table.getValueAt(row, 4).toString();
                setDateFromString(hetHanStr, thoiGianHetHan);
				
				String ngayNhapStr = table.getValueAt(row, 3).toString();
                setDateFromString(ngayNhapStr, thoiGianNhapHang);
				
				cbNCC.setSelectedItem(table.getValueAt(row, 5).toString());
				previousRow=row;
			}
			
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
		if(o.equals(btnXoaRong)) {
			xoaRong();
		}
		else if(o.equals(btnSua)) {
			if(valid()) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(this,"Cần chọn nguyên liệu để sửa");
				}
				else {
					NguyenLieu_Entity nlNew= new NguyenLieu_Entity(tMaNguyenLieu.getText().trim(), 
							tTenNguyenLieu.getText().trim(), 
							Integer.parseInt(tSoLuong.getText().trim()), 
							thoiGianNhapHang.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), 
							thoiGianHetHan.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), 
							ncc_dao.getNCCTheoTen(cbNCC.getSelectedItem().toString()),1);
					if(nl_dao.suaNguyenLieu(nlNew))
					{
						loadTable();
						xoaRong();
					}
				}
			}
		}
		else if(o.equals(btnThem)) {
			if(valid()) {
				NguyenLieu_Entity nlNew= new NguyenLieu_Entity(generateMa(), 
						tTenNguyenLieu.getText().trim(), 
						Integer.parseInt(tSoLuong.getText().trim()), 
						thoiGianNhapHang.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), 
						thoiGianHetHan.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), 
						ncc_dao.getNCCTheoTen(cbNCC.getSelectedItem().toString()),1);
				if(nl_dao.themNguyenLieu(nlNew)) {
					JOptionPane.showMessageDialog(this,"Thêm nguyên liệu thành công");
					loadTable();
				}
			}
		}
		if (o.equals(btnTimKiem)) {
			String tim = tTimKiem.getText().trim();
			if (tim.length() <= 0) {
				JOptionPane.showMessageDialog(this, "Nhập vào trường tìm kiếm!");
				loadTable();
			} else {
				if (tim.matches("^NL[0-9]{3,}$")) {
					NguyenLieu_Entity nl = nl_dao.timNguyenLieuTheoMa(tim);
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					themDong(nl);
				} else {
					ArrayList<NguyenLieu_Entity> dsNL = nl_dao.timNguyenLieuTheoTen(tim);
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					dsNL.forEach(x -> themDong(x));
				}
			}
		}
	}

	private void themDong(NguyenLieu_Entity x) {
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		model.addRow(new Object[] {
				x.getMaNguyenLieu(),x.getTenNguyenLieu(),x.getSoLuong(),df.format(x.getThoiGianNhap()),df.format(x.getThoiGianHetHan()),
				x.getNhaCungCap().getTenNhaCungCap()
		});
	}
}
