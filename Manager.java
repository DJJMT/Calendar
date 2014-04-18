import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;

//IMPORTS
//import java.io.*;

//CLASS MANAGER
class Manager
{
	java.sql.Connection con;
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	
	Manager() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		con = DriverManager.getConnection("jdbc:mysql://99.3.32.166:3306/scheduler","root","mysql");
		Class.forName("com.mysql.jdbc.Driver").newInstance();	
	}
	
	protected void finalize() throws SQLException
	{
		con.close();
	}
	
	//Manager Main
	void manager_Main()
	{
		System.out.println("||---------------------------------||");
		System.out.println("||        Manager Main Page        ||");
		System.out.println("||---------------------------------||");
		
		System.out.println("Menu:\n");
	}
}
