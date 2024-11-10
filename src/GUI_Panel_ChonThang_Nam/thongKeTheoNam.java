package GUI_Panel_ChonThang_Nam;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class thongKeTheoNam extends JPanel {
	private JYearChooser namChon;

	public thongKeTheoNam() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
    	setBackground(new Color(255, 255, 255));
        
        JLabel lbvuilongchonnam = new JLabel("Chọn Năm: ");
        lbvuilongchonnam.setPreferredSize(new Dimension(150, 30));
        lbvuilongchonnam.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbvuilongchonnam);
        namChon = new JYearChooser();
        namChon.setPreferredSize(new Dimension(300, 30));
        namChon.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(namChon);  
    }

	public int getNam() {
		
		// TODO Auto-generated method stub
		return namChon.getYear();
	}
}
