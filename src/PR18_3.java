



import java.sql.Connection;
import oracle.jdbc.driver.OracleDriver;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PR18_3 {
//   static final String DB_URL = "jdbc:mysql://localhost/studentdatabase";
   
   static String driverName = "com.mysql.cj.jdbc.Driver";
   static String url = "jdbc:mysql://localhost/bookentry";
   static final String USER = "root";
   static final String PASS = "";

   public static void main(String[] args) {
      // Open a connection
	   
      try {
    	  try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      Connection conn = DriverManager.getConnection(url, USER,PASS);
    		  
         Statement stmt = conn.createStatement();
   	      
          String sql = "CREATE TABLE STUDENT " +
                   "(id INTEGER, " +
                   " first VARCHAR(255))"; 

         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         String StName = "Abbas", StClass = "CO5IB";
 		String StEnrol = "2005690171", Stbatch = "3";
         
 		 String qurey = "INSERT INTO STUDENT VALUES (171, 'Abbas', 'Abbas', 18, 95)";
 	      stmt.executeUpdate(qurey);
 	      String qurey1 = "INSERT INTO STUDENT VALUES (172, 'Ali', 'sajjad', 18, 75)";
 	      stmt.executeUpdate(qurey1);
 	      String qurey2 = "INSERT INTO STUDENT VALUES (173, 'shama', 'Fatima', 67, 60)";
 	      stmt.executeUpdate(qurey2);
 	      System.out.println("Inserted records into the table...");
			
			System.out.println("Sucessfully Data Inserted");
			
			
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      
     
		
	
   }
}