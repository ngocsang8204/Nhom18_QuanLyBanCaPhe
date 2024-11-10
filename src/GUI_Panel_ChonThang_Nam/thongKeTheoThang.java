package GUI_Panel_ChonThang_Nam;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.awt.Color;
import java.awt.FlowLayout;

public class thongKeTheoThang extends JPanel {

    private JMonthChooser thangChon;
	private JYearChooser namChon;

	public thongKeTheoThang() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
    	setBackground(new Color(255, 255, 255));
        
        JLabel lbvuilongchonthang = new JLabel("Chọn Tháng-Năm: ");
        lbvuilongchonthang.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbvuilongchonthang.setPreferredSize(new Dimension(150, 30));
        add(lbvuilongchonthang);  // Thêm lbvuilongchonthang vào panel_chonthang
        
        thangChon = new JMonthChooser();
        thangChon.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 16));
        thangChon.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 16));
        thangChon.setPreferredSize(new Dimension(150, 30));
        add(thangChon);  // Thêm thangChon vào panel_chonthang
        
        namChon = new JYearChooser();
        namChon.setPreferredSize(new Dimension(150, 30));
        namChon.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(namChon);
        
    }
	public int getThang() {
	    return thangChon.getMonth() + 1;  // Adding 1 to convert from 0-based to 1-based month (January = 1)
	}

	public int getNam() {
	    return namChon.getYear();
	}

}
