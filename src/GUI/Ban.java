package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Ban_DAO;
import Entity.Ban_Entity;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ban extends JPanel implements ActionListener,MouseListener{

	private DefaultTableModel model;
	private JTable table;
	private JTextField tMaBan;
	private JTextField tTenBan;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaRong;
	private JTextArea tGhiChu;
	private Ban_DAO ban_dao= new Ban_DAO();
	private JComboBox cbTrangThai;
	private int previousRow=-1;

	public Ban() {
		this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1036, 658);
        setLayout(new BorderLayout(0, 0));
        
        JPanel rigth_panel = new JPanel();
        rigth_panel.setBackground(new Color(255, 255, 255));
        add(rigth_panel, BorderLayout.EAST);
        rigth_panel.setLayout(new BorderLayout(0, 0));
        
        JPanel left_header = new JPanel();
        left_header.setBackground(new Color(255, 255, 255));
        left_header.setLayout(new GridLayout(3, 1, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("                       ");
        left_header.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("Thông tin bàn");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        left_header.add(lblNewLabel);
        
        JLabel lblNewLabel_1_1 = new JLabel("                       ");
        left_header.add(lblNewLabel_1_1);
        
//        JPanel panel_trong = new JPanel();
//        panel_trong.setPreferredSize(new Dimension(panel_2.getPreferredSize().width,200));
//        panel.add(panel_trong,BorderLayout.CENTER);
//        
        JPanel left_content = new JPanel();
        left_content.setBackground(new Color(255, 255, 255));
        rigth_panel.add(left_content, BorderLayout.NORTH);
        left_content.setLayout(new BoxLayout(left_content, BoxLayout.Y_AXIS));
        left_content.add(left_header);
        
        JPanel maBan = new JPanel();
        maBan.setBackground(new Color(255, 255, 255));
        left_content.add(maBan);
        
        JLabel lb1 = new JLabel("Mã bàn: ");
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        maBan.add(lb1);
        
        tMaBan = new JTextField(28);
        maBan.add(tMaBan);
        
        JPanel tenBan = new JPanel();
        tenBan.setBackground(new Color(255, 255, 255));
        left_content.add(tenBan);
        
        JLabel lb2 = new JLabel("Tên bàn: ");
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tenBan.add(lb2);
        
        tTenBan = new JTextField();
        tenBan.add(tTenBan);
        
        JPanel trangThaiBan = new JPanel();
        trangThaiBan.setBackground(new Color(255, 255, 255));
        left_content.add(trangThaiBan);
        
        JLabel lb3 = new JLabel("Trạng thái: ");
        lb3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        trangThaiBan.add(lb3);
        
        cbTrangThai = new JComboBox();
        cbTrangThai.setBackground(new Color(255, 255, 255));
        cbTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Trống", "Đang sử dụng"}));
        trangThaiBan.add(cbTrangThai);
        
        
        JPanel ghiChu= new JPanel();
        ghiChu.setBackground(new Color(255,255,255));
        left_content.add(ghiChu);
        
        JLabel lb4= new JLabel("Ghi chú");
        lb4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ghiChu.add(lb4);
        
        tGhiChu= new JTextArea();
        tGhiChu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ghiChu.add(tGhiChu);
        
        
        tMaBan.setPreferredSize(new Dimension(tMaBan.getPreferredSize().width,30));
        tMaBan.setEditable(false);
        tTenBan.setPreferredSize(new Dimension(tMaBan.getPreferredSize().width,30));
        tGhiChu.setPreferredSize(new Dimension(tMaBan.getPreferredSize().width,100));
        cbTrangThai.setPreferredSize(new Dimension(tMaBan.getPreferredSize().width,30));
        
        lb1.setPreferredSize(new Dimension(170,20));
        lb2.setPreferredSize(new Dimension(170,20));
        lb3.setPreferredSize(new Dimension(170,20));
        lb4.setPreferredSize(new Dimension(170,20));
        
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_5.setPreferredSize(new Dimension(left_content.getPreferredSize().width,600));
        rigth_panel.add(panel_5,BorderLayout.CENTER);
        
        JLabel lblNewLabel_1_2 = new JLabel("                       ");
        panel_5.add(lblNewLabel_1_2);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        panel_6.setPreferredSize(new Dimension(left_content.getPreferredSize().width,50));
        panel_5.add(panel_6);
        
        btnThem = new JButton("Thêm");
        btnThem.setIcon(new ImageIcon(QLMon.class.getResource("/img/icons8-add-30.png")));
        panel_6.add(btnThem);
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(93, 39));
        btnSua.setIcon(new ImageIcon(QLMon.class.getResource("/img/icons8-tools-30.png")));
        panel_6.add(btnSua);
        
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
        
        JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ BÀN");
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
        
        
        
        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 255, 255));
        left_panel.add(panel_12, BorderLayout.CENTER);
        // Table Model and JTable
        String[] colnames = new String[] { "Mã bàn","Tên bàn", "Trạng thái","Ghi chú"};
        model = new DefaultTableModel(colnames, 0);
        // Sau khi khởi tạo JTable và JScrollPane
        table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Không cho phép chỉnh sửa
				return false;
			}
		};
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
        // Các thiết lập khác
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);

        // Thiết lập renderer cho tiêu đề cột
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        
        table.addMouseListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoaRong.addActionListener(this);
        loadTable();
	}
	public void loadTable() {
		model.setRowCount(0);
		ArrayList<Ban_Entity> ds= ban_dao.danhSachBan();
		ds.forEach(x->{
			model.addRow(new Object[] {
				x.getMaBan(),x.getTenBan(),x.getTrangThaiBan(),x.getGhiChu()	
			});
		});
	}
	public void XoaRong() {
		tMaBan.setText("");
		tTenBan.setText("");
		cbTrangThai.setSelectedIndex(0);
		tGhiChu.setText("");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		if(row!=-1) {
			if(previousRow==row) {
				XoaRong();
				previousRow=-1;
				table.clearSelection();
			}
			else {
				tMaBan.setText(table.getValueAt(row, 0).toString());
				tTenBan.setText(table.getValueAt(row, 1).toString());
				cbTrangThai.setSelectedItem(table.getValueAt(row, 2).toString());
				tGhiChu.setText(table.getValueAt(row, 3).toString());
				previousRow=row;
			}
		}
		
	}
	
	public boolean valid() {
		String tenBan= tTenBan.getText().trim();
		String ghiChu=tGhiChu.getText().trim();
		if(!tenBan.matches("[\\p{L}\\d\\s]+")) {
			JOptionPane.showMessageDialog(this,"Tên bàn phải là chữ");
			tTenBan.requestFocus();
			tTenBan.selectAll();
			return false;
		}
		
		return true;
	}
	public String generateMa() {
		int sl= ban_dao.getSLBan();
		return String.format("B%03d",sl+1);
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
			XoaRong();
		}
		else if(o.equals(btnSua)) {
			if(table.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(this,"Hãy chọn dòng cần sửa");
			}
			else
			if(valid()) {
				Ban_Entity banNew= new Ban_Entity(tMaBan.getText().trim(),
						tTenBan.getText().trim(),
						cbTrangThai.getSelectedItem().toString(), 
						tGhiChu.getText());
				if(ban_dao.suaBan(banNew)) {
					JOptionPane.showMessageDialog(this, "Sửa bàn thành công");
					loadTable();
					XoaRong();
				}
				else {
					JOptionPane.showMessageDialog(this, "Sửa bàn thất bại");
				}
			}
			
		}
		else if(o.equals(btnThem)) {
			if(valid()) {
				Ban_Entity banNew= new Ban_Entity(generateMa(),
						tTenBan.getText().trim(),
						cbTrangThai.getSelectedItem().toString(), 
						tGhiChu.getText());
				if(ban_dao.themBan(banNew)) {
					JOptionPane.showMessageDialog(this, "Thêm bàn thành công");
					loadTable();
					XoaRong();
				}
				else {
					JOptionPane.showMessageDialog(this, "Thêm bàn thất bại");
				}
			}
			
		}
		
	}
}
