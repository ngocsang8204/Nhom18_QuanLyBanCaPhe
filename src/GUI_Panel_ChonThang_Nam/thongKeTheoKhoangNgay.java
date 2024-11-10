package GUI_Panel_ChonThang_Nam;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.awt.Color;
import java.awt.FlowLayout;

public class thongKeTheoKhoangNgay extends JPanel {

	private JDateChooser ngayBD;
	private JDateChooser ngayKT;

	public thongKeTheoKhoangNgay() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
    	setBackground(new Color(255, 255, 255));
        
        JLabel lbNBD = new JLabel("Chọn Ngày Bắt Đầu: ");
        lbNBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbNBD.setPreferredSize(new Dimension(170, 30));
        add(lbNBD);  
        
        ngayBD = new JDateChooser();
        ngayBD.setPreferredSize(new Dimension(200, 30));
//        ngayBD.setDateFormatString("dd-MM-YYYY");
        add(ngayBD);  
        
        add(Box.createHorizontalStrut(10));
        JLabel lbNKT = new JLabel("Chọn Ngày Kết Thúc: ");
        lbNKT.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbNKT.setPreferredSize(new Dimension(170, 30));
        add(lbNKT); 
        
        ngayKT = new JDateChooser();
        ngayKT.setPreferredSize(new Dimension(200, 30));
//        ngayKT.setDateFormatString("dd-MM-YYYY");
        add(ngayKT); 
    }
	
	public Date getNgayBD() {
		return ngayBD.getDate();
	}
	
	public Date getNgayKT() {
		return ngayKT.getDate();
	}
}
