

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class PR18_2{
	
	static String driverName = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521/xe";
	 static final String USER = "system";
	 static final String PASS = "system";
	 
public static void main (String args[])
{
	

	  try {
    	  try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      Connection conn = DriverManager.getConnection(url, USER,PASS);
      Statement stmt = conn.createStatement();
      System.out. println(" Driver loaded");
      System.out.println("Connection to the database created");
      String str= "select* from student";
      ResultSet rs=stmt.executeQuery(str);
      String text=" ";
      System.out.println("Roll Number \t Name");
      while(rs.next())
      {
    	  text= text+rs.getInt(1)+"\t"+rs.getString(2)+ "\t"+rs.getString(3)+ "\t"+rs.getString(4)+"\n";
      }
      System.out.print(text);
      stmt.close();
      	conn.close();
	  }
	  catch (SQLException s)
{System.out.println("sql error");}


}
}