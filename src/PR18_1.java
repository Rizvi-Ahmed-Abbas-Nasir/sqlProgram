
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class PR18_1 {
	public static void main (String args[])
	{
	try
	{
//	DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
	System.out. println(" Driver loaded");
	String url= "jdbc:odbc:MSBTE";
	Connection cn= DriverManager.getConnection(url);
	System.out.println("Connection to the database created");
	Statement st= cn.createStatement();
	String str= "select* from student";
	ResultSet rs=st.executeQuery(str);
	String text=" ";
	System.out.println("Roll Number \t Name");
	while(rs.next())
	{
	text= text+rs.getInt(1)+"\t"+rs.getString(2)+"\n";
	}
	System.out.print(text);
	st.close();
	cn.close();
	}
	catch (SQLException s)
	{System.out.println("sql error");}

	}
}
