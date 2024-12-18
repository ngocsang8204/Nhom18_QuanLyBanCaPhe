package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.database;
import DAO.TaiKhoan_DAO;
import Entity.TaiKhoan_Entity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;

public class Login extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private TaiKhoan_DAO taiKhoan_DAO;
	private JTextField tTenDangNhap;
	private JButton btnDangNhap;
	private JPasswordField tMatKhau;

	public Login() {
		
		try {
			database.getInstance().Connect();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		taiKhoan_DAO = new TaiKhoan_DAO();
		this.setSize(new Dimension(1110, 485));
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));
        FlatLightLaf.setup();
        UIManager.put("PasswordField.showRevealButton", true);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 700));
        getContentPane().add(panel, BorderLayout.WEST);
        this.setTitle("Đăng nhập");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblImage = new JLabel();
        lblImage.setBackground(new Color(255, 255, 255));
        lblImage.setIcon(new ImageIcon(Login.class.getResource("/img/hinh-anh-mau-thiet-ke-quan-cafe.jpg")));
        panel.add(lblImage, BorderLayout.CENTER);
        
        JPanel panel_main = new JPanel();
        panel_main.setPreferredSize(new Dimension(510, 10));
        getContentPane().add(panel_main, BorderLayout.EAST);
        panel_main.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_main.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP VÀO HỆ THỐNG");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel_1.add(lblNewLabel);
        
        Component verticalStrut_2 = Box.createVerticalStrut(90);
        panel_1.add(verticalStrut_2);
        
        
        JPanel panel_2 = new JPanel();
        panel_main.add(panel_2, BorderLayout.CENTER);
        
        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
        
        JPanel panel_4 = new JPanel();
        panel_5.add(panel_4);
        
        JLabel lb1 = new JLabel("Tên đăng nhập:");
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lb1);
        
        panel_5.add(Box.createVerticalStrut(30));
        
        tTenDangNhap = new JTextField();
        tTenDangNhap.setText("quandz");
        tTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tTenDangNhap.setRequestFocusEnabled(true);
        panel_4.add(tTenDangNhap);
        
        JPanel panel_3 = new JPanel();
        panel_5.add(panel_3);
        
        JLabel lb2 = new JLabel("Mật khẩu: ");
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_3.add(lb2);
        
        tMatKhau = new JPasswordField();
        tMatKhau.setToolTipText("");
        tMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_3.add(tMatKhau);
        tMatKhau.setText("123");
        
        lb1.setPreferredSize(new Dimension(150,20));
        lb2.setPreferredSize(new Dimension(150,20));
        
        tTenDangNhap.setPreferredSize(new Dimension(300, 40));
        tMatKhau.setPreferredSize(new Dimension(300, 40));
        
        
        
        Component verticalStrut_1 = Box.createVerticalStrut(30);
        panel_5.add(verticalStrut_1);
        
        JPanel panel_3_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_3_1.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panel_5.add(panel_3_1);
        
        JLabel lblNewLabel_1 = new JLabel("Quên mật khẩu");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setForeground(new Color(0, 128, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_3_1.add(lblNewLabel_1);
        
        btnDangNhap = new JButton("ĐĂNG NHẬP");
        btnDangNhap.setIcon(new ImageIcon(Login.class.getResource("/img/icons8-login-40.png")));
        btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_2.add(btnDangNhap);
        tMatKhau.addKeyListener(new KeyAdapter(){
			@Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                	tTenDangNhap.requestFocus();
                }
            }
		});
        
        tTenDangNhap.addKeyListener(new KeyAdapter(){
			@Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                	tMatKhau.requestFocus();
                }
            }
		});
        btnDangNhap.addActionListener(this);
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
	    if (o.equals(btnDangNhap)) {
	        String textUser = tTenDangNhap.getText().trim();
	        String textPassword = new String(tMatKhau.getPassword());
	        if (textUser.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập.");
	            return;
	        }
	        if (textPassword.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu.");
	            return;
	        }

	        TaiKhoan_Entity taiKhoan = taiKhoan_DAO.checkUser(textUser, textPassword);
	        if (taiKhoan != null) {
	            try {
	                Loading loading = new Loading(taiKhoan);
	                this.dispose();
	                loading.setVisible(true);
	                loading.setLocationRelativeTo(null);

	                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
	                    @Override
	                    protected Void doInBackground() throws Exception {
	                        for (int i = 0; i <= 100; i++) {
	                            Thread.sleep(10); 
	                            publish(i); 
	                        }
	                        return null;
	                    }

	                    @Override
	                    protected void process(java.util.List<Integer> chunks) {
	                        int progressValue = chunks.get(chunks.size() - 1);
	                        loading.updateProgress(progressValue, taiKhoan);
	                    }

	                    @Override
	                    protected void done() {
	                        loading.dispose();
	                    }
	                };

	                worker.execute();
//	                setVisible(false); 
	            } catch (Exception e1) {
	                e1.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Sai thông tin");
	        }

	    }
	}
}
