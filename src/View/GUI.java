package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class GUI extends JFrame {
	
	    JMenuBar menuBar;
	    JMenu aboutMenu, historyMenu, helpMenu;
	    JScrollPane scrollPane;
	    JTextArea tfResult;
	    JTextField  tfNhap;
	    JLabel lbInput, lbOutput, lbTitle, lbS;
	    JButton btResult, btReset;
	    JPanel contentPane;
	    EventHandling event = new EventHandling(this);
	
	    public GUI() {
		    
	        this.setTitle("Time Formatter");
	        this.setSize(670,650);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
	        contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.lightGray);
			
	        menuBar = new JMenuBar();

	        aboutMenu = new JMenu("About");
	        aboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	event.btnAboutMouseClicked(evt);
	            }
	        });
	        
	        historyMenu = new JMenu("History");    
	        historyMenu.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	try {
				event.btnlHistoryMouseClicked(evt);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	            }
	        });
	        
	        helpMenu = new JMenu("Help");
	        helpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	event.btnHelpMouseClicked(evt);
	            }
	        });
	        
	        menuBar.add(aboutMenu);
	        menuBar.add(historyMenu);
	        menuBar.add(helpMenu);
	        setJMenuBar(menuBar);

	        lbTitle = new JLabel("Time Formatter");
	        lbTitle.setBackground(Color.GRAY);
	        lbTitle.setForeground(new Color(120, 205, 100));
	        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
	        lbTitle.setFont(new Font("Serif", Font.BOLD, 30));
	        lbTitle.setOpaque(true);
	        lbTitle.setBounds(0, 10, 670, 50);
	        contentPane.add(lbTitle);

	        lbInput = new JLabel("Input");
	        lbInput.setBackground(new Color(120, 205, 100));
	        lbInput.setForeground(Color.GRAY);
	        lbInput.setFont(new Font("Serif", Font.BOLD, 30));
	        lbInput.setOpaque(true);
	        lbInput.setHorizontalAlignment(SwingConstants.CENTER);
	        lbInput.setBounds(100, 130, 90, 40);
	        contentPane.add(lbInput);
	        
	        tfNhap = new JTextField();
	        tfNhap.setFont(new Font("Serif", Font.BOLD, 30));
	        tfNhap.setBounds(70, 180, 400, 50);
	        contentPane.add(tfNhap);

	        lbS = new JLabel("(S)");
	        lbS.setFont(new Font("Serif", Font.BOLD, 30));
	        lbS.setBounds(480, 180, 50, 50);
	        contentPane.add(lbS);

	        lbOutput = new JLabel("Output");
	        lbOutput.setBackground(new Color(120, 205, 100));
	        lbOutput.setForeground(Color.GRAY);
	        lbOutput.setFont(new Font("Serif", Font.BOLD, 30));
	        lbOutput.setOpaque(true);
	        lbOutput.setBounds(100, 270, 110, 40);
	        lbOutput.setHorizontalAlignment(SwingConstants.CENTER);
	        contentPane.add(lbOutput);

	        tfResult = new JTextArea();
	        tfResult.setEditable(false);
	        tfResult.setFont(new Font("Serif", Font.BOLD, 30));

	        scrollPane = new JScrollPane(tfResult);
	        scrollPane.setBounds(70, 330, 500, 70);
	        contentPane.add(scrollPane);

	        btResult = new JButton("Result");
	        
	        btResult.setBounds(70, 430, 200, 50);
	        btResult.setBackground(Color.CYAN);
	        btResult.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					event.btnResultActionPerformed(arg0);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		     	}
		});  
	        contentPane.add(btResult);

	        btReset = new JButton("Reset");
	        btReset.setBounds(370, 430, 200, 50);
	        btReset.setBackground(Color.CYAN);
	        btReset.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				event.btnResetActionPerformed(arg0);
		    	}
		});	
	        contentPane.add(btReset);
	        
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	    }
	    
	    public static void main(String[] args) {
	        new GUI();
	    }
//	}
}
