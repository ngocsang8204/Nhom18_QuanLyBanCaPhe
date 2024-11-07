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

import DAO.NhaCungCap_DAO;
import Entity.NhaCungCap_Entity;

import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class QLNhaCungCap extends JPanel implements ActionListener, MouseListener{

	private JTextField tMaNhaCungCap;
	private JTextField tTenNhaCungCap;
	private JTextField tThongTinLienHe;
	private JTextField tDiaChi;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField tTimKiem;
	private JButton btnTimKiem;
	private JButton btnXoaRong;
	private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
	private int previousRow = -1;

	public QLNhaCungCap() {
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
        
        JLabel lblNewLabel = new JLabel("Thông tin nhà cung cấp");
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
        
        JLabel lbMaNhaCungCap = new JLabel("Mã nhà cung cấp:");
        lbMaNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lbMaNhaCungCap);
        
        tMaNhaCungCap = new JTextField(28);
        panel_4.add(tMaNhaCungCap);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_1);
        
        JLabel lbTenNhaCungCap = new JLabel("Tên nhà cung cấp: ");
        lbTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_1.add(lbTenNhaCungCap);
        
        tTenNhaCungCap = new JTextField();
        panel_4_1.add(tTenNhaCungCap);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_2);
        
        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_2.add(lbDiaChi);
        
        JPanel panel_4_3 = new JPanel();
        panel_4_3.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4_3);
        
        JLabel lbThongTinLienHe = new JLabel("Thông tin liên hệ:");
        lbThongTinLienHe.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4_3.add(lbThongTinLienHe);
        
        
        tThongTinLienHe = new JTextField();
        panel_4_3.add(tThongTinLienHe);
        
        tDiaChi = new JTextField(); 
        panel_4_2.add(tDiaChi);
        
        tMaNhaCungCap.setPreferredSize(new Dimension(tMaNhaCungCap.getPreferredSize().width,30));
        tMaNhaCungCap.setEditable(false);
        tTenNhaCungCap.setPreferredSize(new Dimension(tMaNhaCungCap.getPreferredSize().width,30));
        tThongTinLienHe.setPreferredSize(new Dimension(tMaNhaCungCap.getPreferredSize().width,30));
        tDiaChi.setPreferredSize(new Dimension(tMaNhaCungCap.getPreferredSize().width,30));
        
        lbMaNhaCungCap.setPreferredSize(new Dimension(170,20));
        lbTenNhaCungCap.setPreferredSize(new Dimension(170,20));
        lbDiaChi.setPreferredSize(new Dimension(170,20));
        lbThongTinLienHe.setPreferredSize(new Dimension(170,20));
        
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
        btnThem.setIcon(new ImageIcon(QLNhaCungCap.class.getResource("/img/icons8-add-30.png")));
        panel_6.add(btnThem);
        
        panel_6.add(Box.createHorizontalStrut(2));
        
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(93, 39));
        btnSua.setIcon(new ImageIcon(QLNhaCungCap.class.getResource("/img/icons8-tools-30.png")));
        panel_6.add(btnSua);
        
        Component horizontalStrut = Box.createHorizontalStrut(2);
        panel_6.add(horizontalStrut);
        
        btnXoaRong = new JButton("Xóa rỗng");
        btnXoaRong.setIcon(new ImageIcon(QLNhaCungCap.class.getResource("/img/icons8-erase-30.png")));
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
        
        JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
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
        tTimKiem.addKeyListener(new KeyAdapter(){
			@Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnTimKiem.doClick();
                }
            }
		});
        panel_11.add(tTimKiem);
        
        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_12, BorderLayout.CENTER);
        
        String[] colnames = new String[] { "Mã nhà cung cấp","Tên nhà cung cấp", "Địa chỉ", "Thông tin liên hệ"};
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

        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); 
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.addMouseListener(this);
        btnXoaRong.addActionListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnTimKiem.addActionListener(this);
        hienBang();
	}
	
	public void hienBang () {
		model.getDataVector().removeAllElements();
		ArrayList<NhaCungCap_Entity> dsNCC = ncc_dao.danhSachNhaCungCap();
		dsNCC.forEach(x -> themDong(x));
	}
	
	public void themDong(NhaCungCap_Entity a) {
		model.addRow(new Object[] {a.getMaNhaCungCap(),
									a.getTenNhaCungCap(),
									a.getDiaChi(),
									a.getThongTinLienHe()});
	}
	
	public void xoaRong() {
		tMaNhaCungCap.setText("");
		tTenNhaCungCap.setText("");
		tThongTinLienHe.setText("");
		tDiaChi.setText("");
	}
	
	public void thongBao(String a, JTextField b) {
		JOptionPane.showMessageDialog(this, a);
		b.requestFocus();
		b.selectAll();
	}
	
	public NhaCungCap_Entity taoNCC() {
		return new NhaCungCap_Entity(tMaNhaCungCap.getText().toString(), 
									tTenNhaCungCap.getText().toString(),
									tDiaChi.getText().toString(),
									tThongTinLienHe.getText().toString());
	}
	
	public void hienNCC (NhaCungCap_Entity a) {
		tMaNhaCungCap.setText(a.getMaNhaCungCap());
		tTenNhaCungCap.setText(a.getTenNhaCungCap());
		tThongTinLienHe.setText(a.getThongTinLienHe());
		tDiaChi.setText(a.getDiaChi());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton)e.getSource();
		if (btn.equals(btnXoaRong)) {
			xoaRong();
		} else if (btn.equals(btnThem)) {
			if (kiemTra()) {
				NhaCungCap_Entity ncc = taoNCC();
				boolean dung = ncc_dao.themNhaCungCap(ncc);
				if (dung) {
					JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công");
				} else JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp không thành công");
				xoaRong();
				hienBang();
			}
		} else if (btn.equals(btnSua)) {
			if (kiemTra()) {
				NhaCungCap_Entity ncc = taoNCC();
				boolean dung = ncc_dao.suaNhaCungCap(ncc);
				if (dung) {
					JOptionPane.showMessageDialog(this, "Sửa nhà cung cấp thành công");
				} else JOptionPane.showMessageDialog(this, "Sửa nhà cung cấp không thành công");
				xoaRong();
				hienBang();
			}
		} else if (btn.equals(btnTimKiem)) {
			if (tTimKiem.getText().length() <= 0) {
				JOptionPane.showMessageDialog(this, "Nhập vào ô tìm kiếm");
				hienBang();
			} else {
				String search = tTimKiem.getText().trim();
				if (search.length() >= 3) {
					String kt = search.substring(0, 2);
					if (kt.matches("NCC")) {
						NhaCungCap_Entity ncc_tim = ncc_dao.timNhaCungCapTheoMa(search);
						model.getDataVector().removeAllElements();
						themDong(ncc_tim);
						hienNCC(ncc_tim);
					} else if (search.matches("^0[0-9]{9}$")) {
						xoaRong();
						NhaCungCap_Entity ncc_tim = ncc_dao.timNhaCungCapTheoSoDT(search);
						model.getDataVector().removeAllElements();
						themDong(ncc_tim);
						hienNCC(ncc_tim);
					} else {
						xoaRong();
						ArrayList<NhaCungCap_Entity> dsTim = ncc_dao.timNhaCungCapTheoTen(search);
						model.getDataVector().removeAllElements();
						dsTim.forEach(x -> themDong(x));
					}
				} else {
					thongBao("Nhập đầy đủ hơn để tìm", tTimKiem);
					hienBang();
				} 
			}
		}
	}
	
	public boolean kiemTra () {
		boolean isCorrect = true;
		if (tTenNhaCungCap.getText().length() <= 0 || tThongTinLienHe.getText().length() <= 0 || tDiaChi.getText().length() <= 0) {
			thongBao("Nhập đầy đủ vào các trường", tTenNhaCungCap);
			isCorrect = false;
		} else {
			String ten = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰÝỲỴÝỶỸ]{1}[a-zàáâãèéêìíòóôõùúăđĩũơưạảấầẩẫậắằẳẵặẹẻẽềếểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳýỵỷỹ]*)+(\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰÝỲỴÝỶỸa-zàáâãèéêìíòóôõùúăđĩũơưạảấầẩẫậắằẳẵặẹẻẽềếểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳýỵỷỹ]*)*$";
			if (!tTenNhaCungCap.getText().trim().matches(ten)) {
				thongBao("Nhập đúng tên nhà Cung cấp", tTenNhaCungCap);
				isCorrect = false;
			} else {
				if (!tDiaChi.getText().trim().matches("^[\\p{L}0-9\\s,.-]+$")) {
					thongBao("Nhập đúng định dạng địa chỉ", tDiaChi);
					isCorrect = false;
				} else {
					if (!tThongTinLienHe.getText().trim().matches("^0[0-9]{9}$")) {
						thongBao("Nhập đúng định dạng thông tin liên hệ (Số điện thoại)", tThongTinLienHe);
						isCorrect = false;
					}
				}
			}
		}
		return isCorrect;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			int row = table.getSelectedRow();
			if(row == previousRow) {
    	    	xoaRong();
    			previousRow = -1;
    			
    		} else {
    			tMaNhaCungCap.setText(model.getValueAt(row, 0).toString());
    			tTenNhaCungCap.setText(model.getValueAt(row, 1).toString());
    			tThongTinLienHe.setText(model.getValueAt(row, 3).toString());
    			tDiaChi.setText(model.getValueAt(row, 2).toString());
	    	    previousRow = row;
    	
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
}
