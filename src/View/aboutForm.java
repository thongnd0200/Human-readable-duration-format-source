package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class aboutForm extends JFrame {
	JPanel contentPane;
	JTextArea text;
	GUI gui;
	public aboutForm(GUI gui) {
		this.gui = gui;
		this.setTitle("About");
		this.setSize(400, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text = new JTextArea("Đồ Án Lập Trình Ứng Dụng\nĐề Tài: Human readable duration format\n Nhóm 2:\n-Nguyễn Đăng Thông\n-Châu Bảo Nhật Vy");
		text.setBounds(10, 10, 360, 230);
		text.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		text.setEditable(false);
		this.setLocationRelativeTo(null);
		contentPane.add(text);
		
		this.setVisible(true);
		
	}
}
