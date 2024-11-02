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
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Mon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tMaMon;
	private JTextField tTenMon;
	private JTextField tDonGia;
	private JTextField tTimKiem;
	private JTable tableSanPham;
	private DefaultTableModel model_SanPham;
	private JButton btnCaPhe;
	private JButton btnDaXay;
	private JButton btnTra;
	private JButton btnSoda;
	private JButton btnThucUongKhac;
	private JButton btnBanh;
	private JButton btnTimKiem;
	private JButton btnSua;
	private JButton btnThem;

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
        
        JComboBox cbLoaiMon = new JComboBox();
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
        
        btnTra = new JButton("TRÀ");
        btnTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnTra);
        
        btnSoda = new JButton("SODA");
        btnSoda.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnSoda);
        
        btnThucUongKhac = new JButton("THỨC UỐNG KHÁC");
        btnThucUongKhac.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnThucUongKhac);
        
        btnBanh = new JButton("BÁNH");
        btnBanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_10.add(btnBanh);
        
        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_12, BorderLayout.CENTER);
        // Table Model and JTable
        String[] colnames = new String[] { "Mã món","Tên món", "Loại món", "Đơn giá"};
        model_SanPham= new DefaultTableModel(colnames, 0);
        model_SanPham = new DefaultTableModel(colnames, 0);
        // Sau khi khởi tạo JTable và JScrollPane
        tableSanPham = new JTable(model_SanPham);
        tableSanPham.setFocusable(false);
        tableSanPham.setShowGrid(true);
        tableSanPham.setShowHorizontalLines(true);
        tableSanPham.setShowVerticalLines(false);
        JScrollPane jsp = new JScrollPane(tableSanPham);
        jsp.setPreferredSize(new Dimension(panel_1.getPreferredSize().width, 873));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Tạo viền màu đen
        tableSanPham.getTableHeader().setBackground(Color.white);
        panel_12.add(jsp);


        // Thiết lập kích thước font cho các ô trong bảng
        Font font = new Font("Tahoma", Font.PLAIN, 16); // Chọn font và kích thước
        tableSanPham.setFont(font);
        tableSanPham.setRowHeight(50); // Thiết lập chiều cao hàng nếu cần

        // Thiết lập renderer cho tiêu đề cột
        tableSanPham.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18)); // Kích thước font cho tiêu đề
        tableSanPham.getTableHeader().setReorderingAllowed(false);
        
        tableSanPham.getTableHeader().setResizingAllowed(false);
	}

}
