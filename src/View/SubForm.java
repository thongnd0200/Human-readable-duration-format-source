package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Database.DataManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

public class SubForm extends JFrame{
	DataManager manager = new DataManager();
	JPanel contentPane;
	JScrollPane scrollPane;
	JTable dataTable;
	JLabel lable;
	GUI gui;
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	Vector<String> header = new Vector<String>();
	public SubForm(GUI gui) throws ClassNotFoundException, SQLException {
		this.gui = gui;
		this.setSize(900, 500);
		this.setTitle("I/O History");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lable = new JLabel("I/O History");
		lable.setBounds(380, 5, 300, 40);
		lable.setFont(new Font("arial",Font.BOLD, 30));
		contentPane.add(lable);
		dataTable = new JTable();
		dataTable.setRowSelectionAllowed(true);
		dataTable.setDefaultEditor(Object.class, null);
	    dataTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    
//	    dataTable.getColumnModel().getColumn(0).setPreferredWidth(10);
	    scrollPane = new JScrollPane(dataTable);
	    scrollPane.setBounds(50, 50, 800, 350);
	    
	    data = manager.getHistory(); 
	    
	    header.add("STT");
	    header.add("Input");
	    header.add("Output");
	    header.add("DataAndTime");
		((DefaultTableModel) (dataTable.getModel())).setDataVector(data, header);
		TableColumnModel columnModel = dataTable.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(50);
	    columnModel.getColumn(1).setPreferredWidth(150);
	    columnModel.getColumn(2).setPreferredWidth(400);
	    columnModel.getColumn(3).setPreferredWidth(200);
	    dataTable.setRowHeight(30);
	    contentPane.add(scrollPane);
	    dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	tblHistoryyMouseClicked(evt);
            }
        });
	    this.setLocationRelativeTo(null);
	    setVisible(true);
	}
	    public void tblHistoryyMouseClicked(MouseEvent evt) {
			if (evt.getClickCount() == 2 && !evt.isConsumed()) {
				evt.consume();
				DefaultTableModel model = (DefaultTableModel)dataTable.getModel();
				int selectedRow = dataTable.getSelectedRow();
				gui.tfNhap.setText(model.getValueAt(selectedRow, 1).toString());
				gui.tfResult.setText("");
				setVisible(false);
			}
		
	}
}
