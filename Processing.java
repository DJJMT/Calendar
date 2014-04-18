import java.io.*;
import java.sql.*;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;


//CLASS PROCESSING
class Processing
{
	//MAIN
	public static void main(String[] args) throws Exception
	{
		//VARIABLES
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String input = "", f_name = "", l_name = "", a_code = "", u_name = "", p_word = "", ID = "", g_name = "";
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://99.3.32.166:3306/scheduler","root","mysql");

		//FORMATTING
		System.out.println("||--------------------------------||");
		System.out.println("||            SCHEDULER           ||");
		System.out.println("||--------------------------------||");
		System.out.println("\n\n");
		System.out.print("Are you a new user (y/n): ");
		input = console.readLine();

		//USER ARRAY
		//Administrator - Can do anything
		//Manager - Create/Remove/View - His Users
		//User - View their own calender
		
		//SELECT INPUT
		if(input.equals("y"))
		{
			//ENTER INFORMATION
			//ID, First Name, Last Name, Access Code, Username, Password 
			System.out.println("Please Enter Your Information.\n");
			System.out.print("ID: ");
			ID = console.readLine();

			System.out.print("First Name: ");
			f_name = console.readLine();
			
			System.out.print("Last Name: ");
			l_name = console.readLine();
		
			System.out.print("Username: ");
			u_name = console.readLine();

			System.out.print("Password: ");
			p_word = console.readLine();

			System.out.print("Access Code: ");
			a_code = console.readLine();
			
			System.out.print("Group Name: ");
			g_name = console.readLine();

			System.out.println("The administrator will now set your access level in the hierarchy.");
			System.out.println("Please log out and log back in as a regular user.");
			Statement s1 = con.createStatement();
   			s1.executeUpdate ("INSERT INTO all_users VALUES(\'"+ID+"\',"+"4,"+"\'"+f_name+"\',"+"\'"+l_name+"\',"+"\'"+u_name+"\',"+"\'"+p_word+"\',"+a_code+",\'"+g_name+"\'"+");");
			s1.close();
		}
		else if(input.equals("n"))
		{
			//ENTER INFORMATION
			System.out.println("Please Enter Your Information.\n");	
			System.out.print("Username: ");
			u_name = console.readLine();

			System.out.print("Password: ");
			p_word = console.readLine();

			//READ HIERARCHY FROM DATABASE AND DECIDE ON FUNCTION--||
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Statement s = con.createStatement();
			s.executeQuery ("SELECT Hierarchy, User_Name, Pass_Word FROM all_users");
			ResultSet rs = s.getResultSet();
			boolean found = false;
			int h = 0;
			String d_u_name = "", d_p_word = "";
			while (rs.next() && found == false)
			{
			       h = rs.getInt("Hierarchy");
			       d_u_name = rs.getString ("User_Name");
			       d_p_word = rs.getString ("Pass_Word");
			       if(d_u_name.equals(u_name))
			       {
			            found = true;
			       }			    
			}
			//System.out.println(h + " " + d_u_name + " " + d_p_word);
			rs.close();
			s.close();
			con.close();
			//-------------------------------------||
			
			if(p_word.equals(d_p_word))
			{
				//CHOOSE USER TYPE---------------------------||
				if(h == 1)
				{
					Administrator admin = new Administrator();
					admin.administrator_Main();
				}
				else if(h == 2)
				{
					Manager manager = new Manager();
					manager.manager_Main();
				}
				else if(h == 3)
				{
					Regular_User reg_user = new Regular_User();
					reg_user.regular_user_Main();
				}
				//END CHOOSE USER TYPE-----------------------||
			}
			else
			{
				System.out.println("Password Incorrect");
			}
		}
		//END SELECT INPUT	
	}//END MAIN
}//END CLASS
