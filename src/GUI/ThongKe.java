package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

import DAO.HoaDon_DAO;
import DAO.Mon_DAO;
import Entity.TaiKhoan_Entity;
import GUI_Panel_ChonThang_Nam.*;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class ThongKe extends JPanel implements ActionListener, MouseListener{
	private DefaultTableModel model_1;
	private JTable table_1;
	private DefaultTableModel model_2;
	private JTable table_2;
	private JButton btnThongKeTheoNam;
	private JButton btnThongKeTheoThang;
	private JButton btnThongKeTheoNgay;
	private Container body;
	private JPanel panel_chonngay;
	private JButton btnThongKeTheoKhoangNgay;
	private JDateChooser ngayChon;
	private JButton btnThongKe;
	private GUI_Panel_ChonThang_Nam.thongKeTheoThang tktt = new thongKeTheoThang();
	private GUI_Panel_ChonThang_Nam.thongKeTheoNam tktn = new thongKeTheoNam();
	private GUI_Panel_ChonThang_Nam.thongKeTheoKhoangNgay tktkn = new thongKeTheoKhoangNgay();
	
	private Mon_DAO monDAO = new Mon_DAO();
	private HoaDon_DAO hoaDonDAO = new HoaDon_DAO();
	
	private JComponent chart;
	private JLabel lbDoiChieu;
	private JLabel lbTongDoanhThuTheoLoai;
	private JPanel panel_thongketongdoanhthu;

	public ThongKe() {
		
			
		setBackground(new Color(255, 255, 255));
        setBounds(0, 0, 1600, 954);
        setLayout(new BorderLayout(0, 0));
        
        JPanel container = new JPanel();
        add(container);
        container.setLayout(new BorderLayout(0, 0));
        container.setBackground(new Color(255, 255, 255));
        
        JPanel panel_header = new JPanel();
        panel_header.setBackground(new Color(255, 255, 255));
        container.add(panel_header,BorderLayout.NORTH);
        panel_header.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("THỐNG KÊ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel_header.add(lblNewLabel);
        
        JPanel panel_chon_ngay = new JPanel();
        panel_chon_ngay.setBackground(new Color(255, 255, 255));
        panel_header.add(panel_chon_ngay, BorderLayout.SOUTH);
        panel_chon_ngay.setLayout(new BoxLayout(panel_chon_ngay, BoxLayout.Y_AXIS));
        
        JPanel panel_chonkieuthongke = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_chonkieuthongke.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        panel_chonkieuthongke.setBackground(new Color(255, 255, 255));
        panel_chon_ngay.add(panel_chonkieuthongke);
        
        btnThongKeTheoNgay = new JButton("Thống kê theo ngày");
        btnThongKeTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_chonkieuthongke.add(btnThongKeTheoNgay);
        
        btnThongKeTheoThang = new JButton("Thống kê theo tháng");
        btnThongKeTheoThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_chonkieuthongke.add(btnThongKeTheoThang);
        
        btnThongKeTheoNam = new JButton("Thống kê theo năm");
        btnThongKeTheoNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_chonkieuthongke.add(btnThongKeTheoNam);
        
        btnThongKeTheoKhoangNgay = new JButton("Thống kê theo khoảng ngày");
        btnThongKeTheoKhoangNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_chonkieuthongke.add(btnThongKeTheoKhoangNgay);
        
        lbDoiChieu = new JLabel("");
        lbDoiChieu.setBackground(new Color(255, 255, 255));
        lbDoiChieu.setForeground(new Color(255, 255, 255));
        panel_chonkieuthongke.add(lbDoiChieu);
        
        JPanel panel = new JPanel();
        panel_chon_ngay.add(panel);
        panel.setLayout(new GridLayout(0, 2, 0, 0));
        
        body = new JPanel();
        body.setBackground(Color.WHITE);
        panel.add(body);
        body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
        
        panel_chonngay = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_chonngay.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_chonngay.setBackground(Color.WHITE);
        body.add(panel_chonngay);
        
        JLabel lbvuilongchonngay = new JLabel("Chọn Ngày: ");
        lbvuilongchonngay.setPreferredSize(new Dimension(150, 30));
        lbvuilongchonngay.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_chonngay.add(lbvuilongchonngay);
        
        ngayChon = new JDateChooser();
        ngayChon.setPreferredSize(new Dimension(300, 30));
//        ngayChon.setDateFormatString("dd-MM-YYYY");
        panel_chonngay.add(ngayChon);
        
        JPanel panel_ThongKe = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_ThongKe.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel_ThongKe.setBackground(new Color(255, 255, 255));
        panel.add(panel_ThongKe);
        
        btnThongKe = new JButton("Thống Kê");
        btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnThongKe.setBackground(new Color(128, 128, 128));
        btnThongKe.setForeground(new Color(255, 255, 255));
        btnThongKe.setIcon(new ImageIcon(ThongKe.class.getResource("/img/icons8-btnThongKe-30.png")));
        panel_ThongKe.add(btnThongKe);

        
        JPanel panel_center = new JPanel();
        panel_center.setBackground(new Color(255, 255, 255));
        container.add(panel_center, BorderLayout.CENTER);
        GridBagLayout gbl_panel_center = new GridBagLayout();
        gbl_panel_center.columnWidths = new int[]{800, 800, 0};
        gbl_panel_center.rowHeights = new int[]{451, 451, 0};
        gbl_panel_center.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_center.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_center.setLayout(gbl_panel_center);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 0;
        panel_center.add(panel_1, gbc_panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1_header = new JPanel();
        panel_1_header.setBackground(new Color(192, 192, 192));
        panel_1.add(panel_1_header, BorderLayout.NORTH);
        
        JLabel lblNewLabel_2 = new JLabel("TOP 5 MÓN BÁN CHẠY NHẤT");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_1_header.add(lblNewLabel_2);
        
        JPanel panel_table_top5monbanchay = new JPanel();
        panel_1.add(panel_table_top5monbanchay, BorderLayout.CENTER);
        String[] colnames = new String[] { "Tên món","Số lượng món bán ra"};
        model_1 = new DefaultTableModel(colnames, 0);
        table_1 = new JTable(model_1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_1.setFocusable(false);
		table_1.setShowGrid(true);
		table_1.setShowHorizontalLines(true);
		table_1.setShowVerticalLines(false);
        JScrollPane jsp = new JScrollPane(table_1);
        jsp.setPreferredSize(new Dimension(790,410));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table_1.getTableHeader().setBackground(Color.white);
        panel_table_top5monbanchay.add(jsp);

        Font font = new Font("Tahoma", Font.PLAIN, 16);
        table_1.setFont(font);
        table_1.setRowHeight(50);

        table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        table_1.getTableHeader().setResizingAllowed(false);
        table_1.getTableHeader().setReorderingAllowed(false);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_2.gridx = 1;
        gbc_panel_2.gridy = 0;
        panel_center.add(panel_2, gbc_panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2_header = new JPanel();
        panel_2_header.setBackground(new Color(192, 192, 192));
        panel_2.add(panel_2_header, BorderLayout.NORTH);
        
        JLabel lblNewLabel_2_1 = new JLabel("TOP 5 MÓN KHÔNG BÁN CHẠY NHẤT");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_2_header.add(lblNewLabel_2_1);
        
        JPanel panel_table_top5monkhongbanchay = new JPanel();
        panel_2.add(panel_table_top5monkhongbanchay, BorderLayout.CENTER);
        
        String colnames_1[] = {"Tên món","Số lượng món bán ra"};
        model_2 = new DefaultTableModel(colnames_1, 0);
        table_2 = new JTable(model_2) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_2.setFocusable(false);
		table_2.setShowGrid(true);
		table_2.setShowHorizontalLines(true);
		table_2.setShowVerticalLines(false);
        JScrollPane jsp_1 = new JScrollPane(table_2);
        jsp_1.setPreferredSize(new Dimension(790,410));
        jsp_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table_2.getTableHeader().setBackground(Color.white);
        panel_table_top5monkhongbanchay.add(jsp_1);
        table_2.setFont(font);
        table_2.setRowHeight(50);
        table_2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        table_2.getTableHeader().setResizingAllowed(false);
        table_2.getTableHeader().setReorderingAllowed(false);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBorder(null);
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.gridwidth = 2;
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 0;
        gbc_panel_3.gridy = 1;
        panel_center.add(panel_3, gbc_panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        panel_thongketongdoanhthu = new JPanel();
        panel_thongketongdoanhthu.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_thongketongdoanhthu, BorderLayout.CENTER);
        panel_thongketongdoanhthu.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
        flowLayout_3.setAlignment(FlowLayout.LEFT);
        panel_thongketongdoanhthu.add(panel_4);
        
        lbTongDoanhThuTheoLoai = new JLabel("Tổng doanh thu");
        lbTongDoanhThuTheoLoai.setBackground(new Color(255, 255, 255));
        lbTongDoanhThuTheoLoai.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_4.add(lbTongDoanhThuTheoLoai);
        panel_thongketongdoanhthu.add(createLineChartPanel());
        
        btnThongKeTheoNgay.addActionListener(this);
        btnThongKeTheoThang.addActionListener(this);
        btnThongKeTheoNam.addActionListener(this);
        btnThongKeTheoKhoangNgay.addActionListener(this);
        btnThongKe.addActionListener(this);
        
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		if (o.equals(btnThongKeTheoNgay)) {
			body.removeAll();
			body.add(panel_chonngay);
			body.revalidate();
			body.repaint();
			lbDoiChieu.setText(btnThongKeTheoNgay.getText());
		}
		
		if (o.equals(btnThongKeTheoThang)) {
			body.removeAll();
			body.add(tktt);
			body.revalidate();
			body.repaint();
			lbDoiChieu.setText(btnThongKeTheoThang.getText());
		}
		
		if (o.equals(btnThongKeTheoNam)) {
			body.removeAll();
			body.add(tktn);
			body.revalidate();
			body.repaint();
			lbDoiChieu.setText(btnThongKeTheoNam.getText());
		}
		
		if (o.equals(btnThongKeTheoKhoangNgay)) {
			body.removeAll();
			body.add(tktkn);
			body.revalidate();
			body.repaint();
			lbDoiChieu.setText(btnThongKeTheoKhoangNgay.getText());
		}
		
		if (o.equals(btnThongKe)) {
		  
		    if ("Thống kê theo tháng".equals(lbDoiChieu.getText())) {
		        thongKeTop5MonBanChayNhatTheoThang();
		        thongKeTop5MonKhongBanChayNhatTheoThang();
		        doanhThuThang();
		        
		        return;
		    }
		    if ("Thống kê theo năm".equals(lbDoiChieu.getText())) {
		    	System.out.println("yes");
		    	doanhThuTheoNam();
		        thongKeTop5MonBanChayNhatTheoNam();
		        thongKeTop5MonKhongBanChayNhatTheoNam();
		        return;
		    }
		    
		    if ("Thống kê theo khoảng ngày".equals(lbDoiChieu.getText())) {
		        thongKeTop5MonBanChayNhatTheoKhoangNgay();
		        thongKeTop5MonKhongBanChayNhatTheoKhoangNgay();
		        doanhThuKhoangNgay();
		        return;
		    }
		    thongKeTop5MonBanChayNhatTheoNgay();
	        thongKeTop5MonKhongBanChayNhatTheoNgay();
	        doanhThuNgay();
	        return;
		}

	}

	public void thongKeTop5MonBanChayNhatTheoKhoangNgay() {
		Date ngayBD = tktkn.getNgayBD();
		Date ngayKT = tktkn.getNgayKT();
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonBanChayNhatTheoKhoangNgay(ngayBD,ngayKT);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món bán chạy trong khoảng ngày này.");
            return;
        }

        model_1.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_1.addRow(new Object[]{tenMon, soLuong});
        }
	}

	public void thongKeTop5MonKhongBanChayNhatTheoKhoangNgay() {
		Date ngayBD = tktkn.getNgayBD();
		Date ngayKT = tktkn.getNgayKT();
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonKhongBanChayNhatTheoKhoangNgay(ngayBD,ngayKT);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món không bán chạy trong khoảng ngày này.");
            return;
        }

        model_2.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_2.addRow(new Object[]{tenMon, soLuong});
        }
	}

	public void thongKeTop5MonBanChayNhatTheoNgay() {
		Date layNgay = ngayChon.getDate();
		System.out.println(layNgay);
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonBanChayNhatTheoNgay(layNgay);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món bán chạy trong ngày này.");
            return;
        }

        model_1.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_1.addRow(new Object[]{tenMon, soLuong});
        }
	}

	public void thongKeTop5MonKhongBanChayNhatTheoNgay() {
		Date layNgay = ngayChon.getDate();
		System.out.println(layNgay);
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonKhongBanChayNhatTheoNgay(layNgay);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món không bán chạy trong ngày này.");
            return;
        }

        model_2.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_2.addRow(new Object[]{tenMon, soLuong});
        }
	}
	
	public void thongKeTop5MonBanChayNhatTheoThang() {
		int thang = tktt.getThang();
		int nam = tktt.getNam();
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonBanChayNhatTheoThang(thang,nam);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món bán chạy trong tháng này.");
            return;
        }

        model_1.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_1.addRow(new Object[]{tenMon, soLuong});
        }
	}
	
	public void thongKeTop5MonKhongBanChayNhatTheoThang() {
		int thang = tktt.getThang();
		int nam = tktt.getNam();
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonKhongBanChayNhatTheoThang(thang,nam);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món bán chạy trong tháng này.");
            return;
        }

        model_2.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_2.addRow(new Object[]{tenMon, soLuong});
        }
	}
	
	public void thongKeTop5MonBanChayNhatTheoNam() {
		int nam = tktn.getNam();
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonBanChayNhatTheoNam(nam);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món bán chạy trong năm này.");
            return;
        }

        model_1.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_1.addRow(new Object[]{tenMon, soLuong});
        }
	}
	
	public void thongKeTop5MonKhongBanChayNhatTheoNam() {
		int nam = tktn.getNam();
		ArrayList<Object[]> top5Items = monDAO.thongKe5MonKhongBanChayNhatTheoNam(nam);
		System.out.println(top5Items);
		if (top5Items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có top 5 món bán chạy trong năm này.");
            return;
        }

        model_2.setRowCount(0);
        for (Object[] item : top5Items) {
            String tenMon = (String) item[0];
            int soLuong = (int) item[1];
            model_2.addRow(new Object[]{tenMon, soLuong});
        }
	}
	

	private JPanel createLineChartPanel() {

		int nam = tktn.getNam();
	    XYSeries totalRevenueSeries = new XYSeries("Tổng doanh thu");
	    System.out.println(nam);
	    for (int i = 1; i <= 12; i++) {
	        double doanhThu = hoaDonDAO.tinhTongTienTheoThang(i, nam);
	        totalRevenueSeries.add(i, doanhThu);
	    }

	    XYSeriesCollection dataset = new XYSeriesCollection();
	    dataset.addSeries(totalRevenueSeries);

	    JFreeChart lineChart = ChartFactory.createXYLineChart(
	            "Thống kê tổng doanh thu năm " + nam,
	            "Tháng",
	            "Doanh thu (VND)",
	            dataset,
	            PlotOrientation.VERTICAL,
	            true, true, false
	    );

	    XYPlot plot = lineChart.getXYPlot();
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	    renderer.setSeriesPaint(0, new Color(248, 160, 44));
	    plot.setRenderer(renderer);

	    plot.setBackgroundPaint(Color.WHITE);
	    plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
	    plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

	    lineChart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 15));
	    lineChart.getLegend().setItemFont(new Font("Tahoma", Font.PLAIN, 15));
	    plot.getDomainAxis().setLabelFont(new Font("Tahoma", Font.PLAIN, 15));
	    plot.getRangeAxis().setLabelFont(new Font("Tahoma", Font.PLAIN, 15));
	    plot.getDomainAxis().setTickLabelFont(new Font("Tahoma", Font.PLAIN, 12));
	    plot.getRangeAxis().setTickLabelFont(new Font("Tahoma", Font.PLAIN, 12));

	    ChartPanel chartPanel = new ChartPanel(lineChart);
	    chartPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	    chartPanel.setRangeZoomable(false);
	    chartPanel.setPreferredSize(new Dimension(600, 400));
	    chartPanel.setBackground(Color.WHITE);
	    lineChart.setBackgroundPaint(Color.WHITE);

	    return chartPanel;
	}
	
	private void doanhThuNgay() {
	    Date layNgay = ngayChon.getDate();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String ngayFormat = sdf.format(layNgay);
	    DecimalFormat df = new DecimalFormat("##,###,### VND");
	    double doanhThuNgay = hoaDonDAO.tinhTongTienTheoNgay(layNgay);
	    String doanhThuNgayFormat = df.format(doanhThuNgay);
	    if (doanhThuNgay == 0) {
			lbTongDoanhThuTheoLoai.setText("Không có doanh thu trong ngày "+ ngayFormat);
			return;
		}else {
			lbTongDoanhThuTheoLoai.setText("Tổng doanh thu ngày " + ngayFormat + " là: " + doanhThuNgayFormat);
		}
	    
	}
	
	private void doanhThuThang() {
	    int thang = tktt.getThang();
	    int nam = tktt.getNam();
	    DecimalFormat df = new DecimalFormat("##,###,### VND");
	    double doanhThuThang = hoaDonDAO.tinhTongTienTheoThang(thang,nam);
	    String doanhThuThangFormat = df.format(doanhThuThang);
	    if (doanhThuThang == 0) {
			lbTongDoanhThuTheoLoai.setText("Không có doanh thu trong tháng " + thang + " năm " + nam );
			return;
		}else {
			lbTongDoanhThuTheoLoai.setText("Tổng doanh thu trong tháng " + thang + " năm " + nam + " là: " + doanhThuThangFormat);
		}
	}
	
	private void doanhThuTheoNam() {
	    int nam = tktn.getNam();
	    DecimalFormat df = new DecimalFormat("##,###,### VND");
	    double doanhThuNam = 0;
	    for (int i = 1; i <= 12; i++) {
	        doanhThuNam += hoaDonDAO.tinhTongTienTheoThang(i, nam); 
	    }
	    String doanhThuNamFormat = df.format(doanhThuNam);
	    if (doanhThuNam == 0) {
	        lbTongDoanhThuTheoLoai.setText("Không có doanh thu trong năm " + nam);
	        
	    } else {
	        lbTongDoanhThuTheoLoai.setText("Tổng doanh thu trong năm " + nam + " là: " + doanhThuNamFormat);
	    }
	    panel_thongketongdoanhthu.remove(1);
	    panel_thongketongdoanhthu.add(createLineChartPanel());
	    panel_thongketongdoanhthu.revalidate();
	    panel_thongketongdoanhthu.repaint();

	}

	
	private void doanhThuKhoangNgay() {
	    Date ngayBD = tktkn.getNgayBD();
	    Date ngayKT = tktkn.getNgayKT();
	    DecimalFormat df = new DecimalFormat("##,###,### VND");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YY");
	    String ngayBDformat = sdf.format(ngayBD);
	    String ngayKTformat = sdf.format(ngayKT);
	    double doanhThuKhoangNgay = hoaDonDAO.tinhTongTienTheoKhoangNgay(ngayBD, ngayKT);
	    String doanhThuKhoangNgayFormat = df.format(doanhThuKhoangNgay);
	    if (doanhThuKhoangNgay == 0) {
			lbTongDoanhThuTheoLoai.setText("Không có doanh thu trong khoảng ngày từ " + ngayBDformat + " đến " + ngayKTformat );
			return;
		}else {
			lbTongDoanhThuTheoLoai.setText("Tổng doanh thu trong khoảng ngày từ " + ngayBDformat + " đến " + ngayKTformat + " là: " + doanhThuKhoangNgayFormat);
		}
	}

}
