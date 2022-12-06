

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQL_EXAMPLE {
	Connection con;   
	PreparedStatement pst;
	ResultSet rs;
	Statement stmt;
	String url = "com.mysql.cj.jdbc.Driver";
	
	
	
	public SQL_EXAMPLE() {
		Connect();
		
		String StName = "Abbas", StClass = "CO5IB";
		String StEnrol = "2005690171", Stbatch = "3";
		
		try {
			pst = con.prepareStatement("INSERT INTO STUDENT(Name,Enroll,Class,Batch)values(?,?,?,?)");
			pst.setString(1, StName);
			pst.setString(2, StEnrol);
			pst.setString(3, StClass);
			pst.setString(4, Stbatch);
			pst.executeUpdate();
			System.out.println("Sucessfully Data Inserted");
		}
		
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
		
	private void Connect() {
		{
			try 
			{
				Class.forName(url);
				con = DriverManager.getConnection("jdbc:mysql://localhost/studentdatabase", "root", "");
				pst = con.prepareStatement("Select * from STUDENT");
				rs = pst.executeQuery();
				
			}
			catch (ClassNotFoundException ex) 
			{
				
			}
			catch(SQLException ex)
			{
				
			}
		}	
	}
	public static void main(String args[]) {
		SQL_EXAMPLE pr18_2 = new SQL_EXAMPLE();
	}

}