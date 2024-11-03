package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import Entity.TaiKhoan_Entity;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;

public class Loading extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar progress;
    private JLabel txtLoad;
    private JLabel value;
    private JLabel lblH;
	private TaiKhoan_Entity taiKhoan_Entity;
	private Color color;

    public Loading(TaiKhoan_Entity taiKhoan) {
    	System.out.println(taiKhoan);
    	FlatIntelliJLaf.setup();
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(color.decode("#181C14"));
        panel.setBounds(0, 0, 900, 550);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(Loading.class.getResource("/img/hinh-anh-mau-thiet-ke-quan-cafe.jpg")));
        lblNewLabel.setBounds(0, 70, 900, 364);
        panel.add(lblNewLabel);

        txtLoad = new JLabel("Loading...");
        txtLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLoad.setForeground(new Color(255, 255, 255));
        txtLoad.setBounds(96, 442, 240, 30);
        panel.add(txtLoad);

        progress = new JProgressBar();
        progress.setBounds(96, 482, 706, 14);
        panel.add(progress);

        lblH = new JLabel("Hệ thống quản lý quán cà phê");
        lblH.setForeground(new Color(255, 255, 255));
        lblH.setFont(new Font("Dialog", Font.BOLD, 30));
        lblH.setHorizontalAlignment(SwingConstants.CENTER);
        lblH.setBounds(0, 0, 900, 53);
        panel.add(lblH);

        value = new JLabel("0 %");
        value.setForeground(new Color(255, 255, 255));
        value.setHorizontalAlignment(SwingConstants.CENTER);
        value.setFont(new Font("Arial", Font.PLAIN, 15));
        value.setBounds(712, 442, 86, 30);
        panel.add(value);
    }
    
    public void updateProgress(int value, TaiKhoan_Entity taiKhoan) {
        this.value.setText(value + " %");
        this.progress.setValue(value);

        // Cập nhật trạng thái dựa trên giá trị của value
        switch (value) {
            case 10:
                txtLoad.setText("Turning On Modules ...");
                break;
            case 20:
                txtLoad.setText("Loading Modules ...");
                break;
            case 50:
                txtLoad.setText("Connecting to database ...");
                break;
            case 70:
                txtLoad.setText("Connection Successful!");
                break;
            case 90:
                txtLoad.setText("Launching Application ...");
                break;
            case 100:
            	this.dispose(); // Đóng cửa sổ tải
                TrangChu trangChu = new TrangChu(taiKhoan);
                trangChu.setVisible(true);
                break;
        }
    }
}
