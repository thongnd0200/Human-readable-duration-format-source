package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class DataManager {
		public DataManager() {
			
		}
	  	private Connection connection;
	
	  //hàm tạo kết nối
	    public Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName(DatabaseInfo.driverName);
		connection = DriverManager.getConnection(DatabaseInfo.dbURL);
		//System.out.println("CONNECTTED!");
		return connection;
	    }
	
	   //hàm lấy dữ liệu từ table trong database
	    public Vector<Vector<String>> getHistory() throws SQLException, ClassNotFoundException{
	    	Vector<Vector<String>> data = new Vector<Vector<String>>();
	    	connection = getConnect();
	    	
	    	Statement stm = connection.createStatement();
	    	ResultSet rs = stm.executeQuery("SELECT * FROM IOHISTORY");
	    	
	    	while(rs.next()) {
	    		
	    		String STT = rs.getString(1);
	    		String Input = rs.getString(2);
	    		String Output = rs.getString(3);
	    		String time = rs.getString(4);
	    		
	    		Vector<String> temp = new Vector<String>();
	    		temp.add(STT);
	    		temp.add(Input);
	    		temp.add(Output);
	    		temp.add(time);
	    		
	    		data.add(temp);

	    	}
	    	connection.close();
	    	return data;
	    }
	
	  //hàm đưa dữ liệu từ ứng dụng vào database
	    public void insertData(int STT, String Input, String Output, String time) throws ClassNotFoundException, SQLException {
			connection = getConnect();
			
			Statement stm = connection.createStatement();
			stm.execute("INSERT INTO IOHISTORY VALUES (" + STT + ", \'"+Input+"\' ,\'" + Output + "\',\'"+ time +"\')");
			
			connection.close();
			
		}
	
	   //hàm kiểm tra định dạng input
	    public boolean checkInput(String Input) {
	    	long temp;
	    	try {
				temp = Long.parseLong(Input);
				if( temp < 0) return false;
			} catch (Exception e) {
				return false;
				// TODO: handle exception
			}
	    		return true;
	    }
	 
	   //hàm trả về thời gian của các lần sử dụng  
	    public String getTime() {
	    	Date d = new Date();
			Timestamp ts = new Timestamp(d.getTime());
			return ts+"";
	    }
	
	    //hàm lấy số thứ tự nhập của các lần sử dụng
	    public int setSTT() throws ClassNotFoundException, SQLException {
	    	connection = getConnect();
	    	int STT = 0;
	    	Statement stm = connection.createStatement();
			ResultSet rsSTT = stm.executeQuery("SELECT STT FROM IOHISTORY");
			while (rsSTT.next()) {
				STT = rsSTT.getInt("STT");
			}
			connection.close();
			++STT;
			return STT;
	    }
}
