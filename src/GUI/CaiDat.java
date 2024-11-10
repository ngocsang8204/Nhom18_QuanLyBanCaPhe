package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.NhanVien_Entity;
import Entity.TaiKhoan_Entity;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class CaiDat extends JPanel implements MouseListener,ActionListener{
	private JTextField tMaNV;
	private JTextField tTenNV;
	private JTextField tMaTK;
	private JTextField tCCCD;
	private JTextField tSDT;
	private JTextArea tDC;
	private JTextField tChucVu;
	private String ma;
	private NhanVien_DAO nv_dao= new NhanVien_DAO();
	private TaiKhoan_DAO tk_dao= new TaiKhoan_DAO();
	private JButton btnSua;
	private JTextField tTenTK;
	private JTextField tMK;
	private JButton btnDoiMK;
	private JButton btnDangXuat;

	public CaiDat(String ma) {
		this.ma=ma;
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1600, 954);
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(CaiDat.class.getResource("/img/a.png")));
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        add(panel_1, BorderLayout.CENTER);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_2.setPreferredSize(new Dimension(800, 500));
        panel_1.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
        
        JPanel maNV = new JPanel();
        maNV.setBackground(new Color(255, 255, 255));
        panel_2.add(maNV);
        
        JLabel lbMaNhanVien = new JLabel("Mã nhân viên: ");
        lbMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbMaNhanVien.setPreferredSize(new Dimension(170,20));
        maNV.add(lbMaNhanVien);
        
        tMaNV = new JTextField(28);
        tMaNV.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        maNV.add(tMaNV);
        
        JPanel tenNV = new JPanel();
        tenNV.setBackground(new Color(255, 255, 255));
        panel_2.add(tenNV);
        
        JLabel lbTenNhanVien = new JLabel("Tên nhân viên: ");
        lbTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbTenNhanVien.setPreferredSize(new Dimension(170,20));
        tenNV.add(lbTenNhanVien);
        
        tTenNV = new JTextField();
        tTenNV.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        tenNV.add(tTenNV);
        
        
        JPanel cccd = new JPanel();
        cccd.setBackground(new Color(255, 255, 255));
        panel_2.add(cccd);
        
        JLabel lbCCCD = new JLabel("Căn cước công dân: ");
        lbCCCD.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbCCCD.setPreferredSize(new Dimension(170,20));
        cccd.add(lbCCCD);
        
        tCCCD = new JTextField();
        tCCCD.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        cccd.add(tCCCD);
        
        
        JPanel sdt = new JPanel();
        sdt.setBackground(new Color(255, 255, 255));
        panel_2.add(sdt);
        
        JLabel lbSDT = new JLabel("Số điện thoại: ");
        lbSDT.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbSDT.setPreferredSize(new Dimension(170,20));
        sdt.add(lbSDT);
        
        tSDT = new JTextField();
        tSDT.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        sdt.add(tSDT);
        
        JPanel dc = new JPanel();
        dc.setBackground(new Color(255, 255, 255));
        panel_2.add(dc);
        
        JLabel lbDC = new JLabel("Địa chỉ: ");
        lbDC.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbDC.setPreferredSize(new Dimension(170,20));
        dc.add(lbDC);
        
        tDC = new JTextArea();
        tDC.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,70));
        tDC.setBorder(BorderFactory.createLineBorder(Color.black));
        dc.add(tDC);
        
        JPanel chucVu = new JPanel();
        chucVu.setBackground(new Color(255, 255, 255));
        panel_2.add(chucVu);
        
        JLabel lbChucVu = new JLabel("Chức vụ: ");
        lbChucVu.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbChucVu.setPreferredSize(new Dimension(170,20));
        chucVu.add(lbChucVu);
        
        tChucVu = new JTextField();
        tChucVu.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        chucVu.add(tChucVu);
        
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(93, 39));
        btnSua.setIcon(new ImageIcon(QLMon.class.getResource("/img/icons8-tools-30.png")));
        panel_2.add(btnSua);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBorder(new TitledBorder(null, "Thông tin tài khoản", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_3.setPreferredSize(new Dimension(800, 500));
        panel_1.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        JPanel maTK = new JPanel();
        maTK.setBackground(new Color(255, 255, 255));
        panel_3.add(maTK);
        
        JLabel lbMaTK= new JLabel("Mã tài khoản: ");
        lbMaTK.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbMaTK.setPreferredSize(new Dimension(170,20));
        maTK.add(lbMaTK);
        
        tMaTK = new JTextField();
        tMaTK.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        panel_3.add(Box.createVerticalStrut(20));
        maTK.add(tMaTK);
        
        JPanel tenTK = new JPanel();
        tenTK.setBackground(new Color(255, 255, 255));
        panel_3.add(tenTK);
        
        JLabel lbTenTK= new JLabel("Tên đăng nhập: ");
        lbTenTK.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbTenTK.setPreferredSize(new Dimension(170,20));
        panel_3.add(Box.createVerticalStrut(20));
        tenTK.add(lbTenTK);
        
        tTenTK = new JTextField();
        tTenTK.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        tenTK.add(tTenTK);
        
        JPanel mk = new JPanel();
        mk.setBackground(new Color(255, 255, 255));
        panel_3.add(mk);
        
        JLabel lbMK= new JLabel("Mật khẩu: ");
        lbMK.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbMK.setPreferredSize(new Dimension(170,20));
        panel_3.add(Box.createVerticalStrut(20));
        mk.add(lbMK);
        
        tMK = new JTextField();
        tMK.setPreferredSize(new Dimension(tMaNV.getPreferredSize().width,30));
        mk.add(tMK);
        
        btnDoiMK = new JButton("Đổi mật khẩu");
        btnDoiMK.setPreferredSize(new Dimension(93, 39));
        btnDoiMK.setIcon(new ImageIcon(QLMon.class.getResource("/img/icons8-tools-30.png")));
        panel_3.add(Box.createVerticalGlue());
        panel_3.add(btnDoiMK);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        add(panel_4, BorderLayout.SOUTH);
        
        btnDangXuat = new JButton("ĐĂNG XUẤT");
        btnDangXuat.setForeground(new Color(255, 255, 255));
        btnDangXuat.setBackground(new Color(255, 66, 66));
        btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel_4.add(btnDangXuat);
        
        tMaNV.setEditable(false);
        tMaTK.setEditable(false);
        tTenTK.setEditable(false);
        tChucVu.setEditable(false);
        
        btnSua.addActionListener(this);
        btnDoiMK.addActionListener(this);
        btnDangXuat.addActionListener(this);
        
        loadNhanVien();
        loadTaiKhoan();
	}
	private void loadTaiKhoan() {
		TaiKhoan_Entity taiKhoan= tk_dao.timTaiKhoanTheoMaNV(ma);
		tMaTK.setText(taiKhoan.getMaTaiKhoan());
		tTenTK.setText(taiKhoan.getTenDangNhap());
		tMK.setText(taiKhoan.getMatKhau());
	}
	private void loadNhanVien() {
		NhanVien_Entity nhanVien= nv_dao.timNhanVienTheoMa(ma);
		tMaNV.setText(nhanVien.getMaNhanVien());
		tTenNV.setText(nhanVien.getTenNhanVien());
		tCCCD.setText(nhanVien.getSoCCCD());
		tSDT.setText(nhanVien.getSoCCCD());
		tDC.setText(nhanVien.getDiaChi());
		tChucVu.setText(nhanVien.getChucVu()==true?"Quản lí":"Nhân viên");
	}
	private boolean validNhanVien() {
		String ten = tTenNV.getText().trim();
		String soCCCD = tCCCD.getText().trim();
		String soDT = tSDT.getText().trim();
		String diaChi = tDC.getText().trim();
		
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
		
		if (soDT.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được rỗng","Sai",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!soDT.matches("^(03|05|07|08|09)[0-9]{8}$")) {
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		if(o.equals(btnSua)){
			if(validNhanVien()) {
				NhanVien_Entity newNV= new NhanVien_Entity(tMaNV.getText().trim(), 
						tTenNV.getText().trim(), 
						tCCCD.getText().trim(), 
						tSDT.getText().trim(), tDC.getText().trim(), tChucVu.getText().trim()=="Quản lí"?true:false);
				if(nv_dao.suaNhanVien(newNV))
					JOptionPane.showMessageDialog(this,"Cập nhật thành công");
			}
		}
		else if(o.equals(btnDoiMK)) {
			if(tMK.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this,"Mật khẩu không được rỗng");
			}else {
				int yes= JOptionPane.showConfirmDialog(this,"Bạn có muốn đổi mật khẩu không");
				if(yes==JOptionPane.YES_OPTION) {
					if(tk_dao.doiMatKhau(tMaTK.getText().trim(), tMK.getText().trim()))
						JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công");
				}
			}
		}
		else if(o.equals(btnDangXuat)) {
			// Kiểm tra xem đối tượng cha có phải là JFrame không
		    Window parentWindow = SwingUtilities.getWindowAncestor(btnDangXuat);
		    if (parentWindow != null) {
		        parentWindow.dispose(); // Đóng cửa sổ hiện tại
		    }
		    // Hiển thị lại màn hình đăng nhập
		    new Login().setVisible(true);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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

}
