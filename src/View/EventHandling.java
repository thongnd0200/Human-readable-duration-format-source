package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.DataManager;
import Database.TimeFormatter;

public class EventHandling{
	GUI gui;
	SubForm form ;
	DataManager manager = new DataManager();
	
	public EventHandling(SubForm sform) {
		form = sform;
	}
	
	public EventHandling(GUI gui2) {
		gui = gui2;
	}
	
	public void btnResultActionPerformed(ActionEvent arg0) throws ClassNotFoundException, SQLException {
		if(manager.checkInput(gui.tfNhap.getText())) {
		Long temp = Long.parseLong(gui.tfNhap.getText());
		gui.tfResult.setText(TimeFormatter.formatDuration(temp));
		manager.insertData(manager.setSTT() , temp+"", TimeFormatter.formatDuration(temp), manager.getTime());
		}// TODO Auto-generated method stub
		else JOptionPane.showMessageDialog(gui, " Bạn nhập sai!\n Input phải là số nguyên không âm!\n Mời bạn nhập lại!", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void btnlHistoryMouseClicked(MouseEvent evt) throws ClassNotFoundException, SQLException {
		new SubForm(gui);
		// TODO Auto-generated method stub
	}
	
	public void btnResetActionPerformed(ActionEvent arg0) {
		gui.tfNhap.setText("");
		gui.tfResult.setText("");
	}
	
	public void btnAboutMouseClicked(MouseEvent evt) {
		new aboutForm(gui);
	}
	
	public void btnHelpMouseClicked(MouseEvent evt) {
		new helpForm(gui);
	}
		// TODO Auto-generated method stub
		
	}
	
	

