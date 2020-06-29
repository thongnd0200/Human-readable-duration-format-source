package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class helpForm extends JFrame {
	
	GUI gui;
	JPanel contentPane;
	JTextArea text;
	
	public helpForm(GUI gui) {
		this.gui = gui;
		this.setTitle("Help");
		this.setSize(400, 300);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		text = new JTextArea("Hướng dẫn sử dụng: \nInput là một số nguyên không âm với\nđơn vị là giây, Output sẽ là khoảng thời\ngian tương ứng.");
		text.setBounds(10, 10, 360, 230);
		text.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		text.setEditable(false);
		this.setLocationRelativeTo(null);
		contentPane.add(text);
		
		this.setVisible(true);
	}
}
