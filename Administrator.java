import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CLASS ADMINISTRATOR
class Administrator
{
	java.sql.Connection con;
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	
	Administrator() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		con = DriverManager.getConnection("jdbc:mysql://99.3.32.166:3306/scheduler","root","mysql");
		Class.forName("com.mysql.jdbc.Driver").newInstance();	
	}
	
	protected void finalize() throws SQLException
	{
		con.close();
	}
	
	//MAIN
	void administrator_Main() throws IOException, SQLException
	{
		System.out.println("||---------------------------------||");
		System.out.println("||     Administrator Main Page     ||");
		System.out.println("||---------------------------------||");
		
		System.out.println("Menu:\n");
		System.out.println("1.)   View All Accounts");
		System.out.println("2.)   View Specific Account");
		System.out.println("3.)   View All Groups");
		System.out.println("4.)   View Specific Group");
		System.out.println("5.)   View All Appointments");
		System.out.println("6.)   View Appointments By Day");
		System.out.println("7.)   View Appointments By Week");
		System.out.println("8.)   View Appointments By Month");
		System.out.println("9.)   Add Account");
		System.out.println("10.)  Delete Account");
		System.out.println("11.)  Change Account Information");
		System.out.println("12.)  Add Group");
		System.out.println("13.)  Delete Group");
		System.out.println("14.)  Change Group Information");
		System.out.println("15.)  Add Appointment");
		System.out.println("16.)  Delete Appointment");
		System.out.println("17.)  Change Appointment Information");
		System.out.println("18.)  View Conflicts Within Groups");	
		
		System.out.print("\nPlease Enter A Selection: ");
		String input = console.readLine();
		if(input.equals("1"))
		{
			view_all_accounts();
		}
		else if(input.equals("2"))
		{
			view_specific_account();
		}
		else if(input.equals("3"))
		{
			view_all_groups();
		}
		else if(input.equals("4"))
		{
			view_specific_group();
		}
		else if(input.equals("5"))
		{
			view_all_appointments();
		}
		else if(input.equals("6"))
		{
			view_appointments_by_day();
		}
		else if(input.equals("7"))
		{
			view_appointments_by_week();
		}
		else if(input.equals("8"))
		{
			view_appointments_by_month();
		}
		else if(input.equals("9"))
		{
			add_account();
		}
		else if(input.equals("10"))
		{
			delete_account();
		}
		else if(input.equals("11"))
		{
			change_account_information();
		}
		else if(input.equals("12"))
		{
			add_group();
		}
		else if(input.equals("13"))
		{
			delete_group();
		}
		else if(input.equals("14"))
		{
			change_group_information();
		}
		else if(input.equals("15"))
		{
			add_appointment();
		}
		else if(input.equals("16"))
		{
			delete_appointment();
		}
		else if(input.equals("17"))
		{
			change_appointment_information();
		}
		else if(input.equals("18"))
		{
			view_conflicts_within_groups();
		}
		else
		{
			System.out.println("Invalid Entry.");
		}
	}
	
	// (1) VIEW ALL ACCOUNTS
	void view_all_accounts() throws SQLException
	{
		System.out.println("||----------------------------Accounts----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM all_users;");
		ResultSet rs = s.getResultSet();
		int h = 0, id = 0, a_code = 0;
		String d_u_name = "", d_p_word = "", d_f_name = "", d_l_name = "",g_name = "";
		while (rs.next())
		{
		       	  id = rs.getInt("ID"); 
		       	  h = rs.getInt("Hierarchy");
		       	  d_f_name = rs.getString("First_Name");
		       	  d_l_name = rs.getString("Last_Name");
		       	  d_u_name = rs.getString("User_Name");
		       	  d_p_word = rs.getString("Pass_Word");
		       	  a_code = rs.getInt("Access_Code");
		       	  g_name = rs.getString("G_Name");
		       	System.out.println(id + " " + h + " " + d_f_name + " " + d_l_name + " " + d_u_name + " " + d_p_word + " " + a_code + " " + g_name);
		}		
		rs.close();
		s.close();
	}
	
	// (2) VIEW SPECIFIC ACCOUNTS
	void view_specific_account() throws SQLException, IOException
	{
		System.out.print("Please Enter the Last Name Of The Account To View: ");
		String input = console.readLine();
		System.out.println("||----------------------------Accounts----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM all_users;");
		ResultSet rs = s.getResultSet();
		int h = 0, id = 0, a_code = 0;
		String d_u_name = "", d_p_word = "", d_f_name = "", d_l_name = "", g_name = "";
		while (rs.next())
		{
				
		       	  id = rs.getInt("ID"); 
		       	  h = rs.getInt("Hierarchy");
		       	  d_f_name = rs.getString("First_Name");
		       	  d_l_name = rs.getString("Last_Name");
		       	  d_u_name = rs.getString("User_Name");
		       	  d_p_word = rs.getString("Pass_Word");
		       	  a_code = rs.getInt("Access_Code");
		       	  g_name = rs.getString("G_Name");
		       	  if(input.equals(d_l_name))
		       	  {
		       		  System.out.println(id + " " + h + " " + d_f_name + " " + d_l_name + " " + d_u_name + " " + d_p_word + " " + a_code + " " + g_name);
		       	  }
		}		
		rs.close();
		s.close();
	}
	
	// (3) VIEW ALL GROUPS
	void view_all_groups() throws SQLException
	{
		System.out.println("||----------------------------Groups----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM groups;");
		ResultSet rs = s.getResultSet();
		int g_id = 0, m_count = 0;
		String g_name = "";
		while (rs.next())
		{
		       	g_id = rs.getInt("G_ID"); 
		       	m_count = rs.getInt("Member_Count");
		       	g_name = rs.getString("G_Name");
		       	System.out.println(g_id + " " + g_name + " " + m_count);
		}		
		rs.close();
		s.close();
	}
	// (4) VIEW SPECIFIC GROUP
	void view_specific_group() throws SQLException, IOException
	{
		System.out.print("Please Enter the Name Of The Group To View: ");
		String input = console.readLine();
		System.out.println("||----------------------------Groups----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM groups;");
		ResultSet rs = s.getResultSet();
		int g_id = 0, m_count = 0;
		String g_name = "";
		while (rs.next())
		{
		       	g_id = rs.getInt("G_ID"); 
		       	m_count = rs.getInt("Member_Count");
		       	g_name = rs.getString("G_Name");
		       	if(input.equals(g_name))
		       	{
		       		System.out.println(g_id + " " + g_name + " " + m_count);
		       	}
		}		
		rs.close();
		s.close();
	}
	
	// (5) VIEW ALL APPOINTMENTS
	void view_all_appointments() throws SQLException
	{
		System.out.println("||----------------------------Appointments----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM appointments;");
		ResultSet rs = s.getResultSet();
		int a_id = 0;
		String g_name = "", start_time = "", end_time = "", a_date="", location="", description="";
		while (rs.next())
		{
		       	a_id = rs.getInt("ID"); 
		       	g_name = rs.getString("G_Name");
		       	start_time = rs.getString("Start_Time");
		       	end_time = rs.getString("End_Time");
		       	a_date = rs.getString("A_Date");
		       	location = rs.getString("Location");
		       	description = rs.getString("Description");
		       	System.out.println(a_id + " " + g_name + " " + start_time + " " + end_time + " " + a_date + " " + location + " " + description);
		}		
		rs.close();
		s.close();
	}
	
	// (6) VIEW APPOINTMENTS BY DAY
	void view_appointments_by_day() throws SQLException, IOException
	{
		System.out.print("Enter the date to view (YEAR-MO-DY): ");
		String view_date = console.readLine();
		System.out.println("||----------------------------Appointments----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM appointments;");
		ResultSet rs = s.getResultSet();
		int a_id = 0;
		String g_name = "", start_time = "", end_time = "", a_date="", location="", description="";
		while (rs.next())
		{
		       	a_id = rs.getInt("ID"); 
		       	g_name = rs.getString("G_Name");
		       	start_time = rs.getString("Start_Time");
		       	end_time = rs.getString("End_Time");
		       	a_date = rs.getString("A_Date");
		       	location = rs.getString("Location");
		       	description = rs.getString("Description");
		       	if(a_date.equals(view_date))
		       	{
		       		System.out.println(a_id + " " + g_name + " " + start_time + " " + end_time + " " + a_date + " " + location + " " + description);
		       	}
		}		
		rs.close();
		s.close();
	}
	
	// (7) VIEW APPOINTMENTS BY WEEK
	void view_appointments_by_week() throws IOException, SQLException
	{
		System.out.print("Enter the date to view (YEAR-MO-DY) (You will be shown the next 7 days from this date): ");
		String view_date = console.readLine();
		System.out.println("||----------------------------Appointments----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM appointments;");
		ResultSet rs = s.getResultSet();
		//CREATE 7 DAYS------------------------------||
		String n_date1 = view_date.substring(8,10);
		String beginning = view_date.substring(0,8);
		int d = Integer.parseInt(n_date1);
		String n_date2 = String.valueOf(d+1);
		String n_date3 = String.valueOf(d+2);
		String n_date4 = String.valueOf(d+3);
		String n_date5 = String.valueOf(d+4);
		String n_date6 = String.valueOf(d+5);
		String n_date7 = String.valueOf(d+6);
		String d1 = beginning + n_date1;
		String d2 = beginning + n_date2;
		String d3 = beginning + n_date3;
		String d4 = beginning + n_date4;
		String d5 = beginning + n_date5;
		String d6 = beginning + n_date6;
		String d7 = beginning + n_date7;
		//-------------------------------------------||
		int a_id = 0;
		String g_name = "", start_time = "", end_time = "", a_date="", location="", description="";
		while (rs.next())
		{
		       	a_id = rs.getInt("ID"); 
		       	g_name = rs.getString("G_Name");
		       	start_time = rs.getString("Start_Time");
		       	end_time = rs.getString("End_Time");
		       	a_date = rs.getString("A_Date");
		       	location = rs.getString("Location");
		       	description = rs.getString("Description");
		       	if(a_date.equals(d1) || a_date.equals(d2) || a_date.equals(d3) || a_date.equals(d4) ||a_date.equals(d5) || a_date.equals(d6) || a_date.equals(d7))
		       	{
		       		System.out.println(a_id + " " + g_name + " " + start_time + " " + end_time + " " + a_date + " " + location + " " + description);
		       	}
		}		
		rs.close();
		s.close();
	}
	
	// (8) VIEW APPOINTMENTS BY MONTH
	void view_appointments_by_month() throws IOException, SQLException
	{
		System.out.print("Enter the date to view (YEAR-MO): ");
		String view_date = console.readLine();
		view_date = view_date + "-00";
		System.out.println("||----------------------------Appointments----------------------------||");
		Statement s = con.createStatement();
		s.executeQuery ("SELECT * FROM appointments;");
		ResultSet rs = s.getResultSet();
		String month = view_date.substring(5,7);
		String year = view_date.substring(0,4);
		int a_id = 0;
		String g_name = "", start_time = "", end_time = "", a_date="", location="", description="";
		while (rs.next())
		{
		       	a_id = rs.getInt("ID"); 
		       	g_name = rs.getString("G_Name");
		       	start_time = rs.getString("Start_Time");
		       	end_time = rs.getString("End_Time");
		       	a_date = rs.getString("A_Date");
		       	location = rs.getString("Location");
		       	description = rs.getString("Description");
		       	String c_month = a_date.substring(5,7);
		       	String c_year = a_date.substring(0,4);
		       	if(c_month.equals(month) && c_year.equals(year))
		       	{
		       		System.out.println(a_id + " " + g_name + " " + start_time + " " + end_time + " " + a_date + " " + location + " " + description);
		       	}
		}		
		rs.close();
		s.close();
	}
	
	// (9) ADD ACCOUNT
	void add_account() throws IOException, SQLException
	{
		String f_name = "", l_name = "", a_code = "", u_name = "", p_word = "", ID = "", g_name = "";
		//ENTER INFORMATION
		//ID, First Name, Last Name, Access Code, Username, Password 
		System.out.println("Please Enter The Information.\n");
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
		
		String h = "";
		System.out.print("Hierarchy: ");
		h = console.readLine();

		Statement s1 = con.createStatement();
		s1.executeUpdate ("INSERT INTO all_users VALUES(\'"+ID+"\',"+h +","+"\'"+f_name+"\',"+"\'"+l_name+"\',"+"\'"+u_name+"\',"+"\'"+p_word+"\',"+a_code+",\'"+g_name+"\'"+");");
		s1.close();
	}
	
	// (10) DELETE ACCOUNT
	void delete_account() throws IOException, SQLException
	{
		System.out.print("Please Enter the Last Name Of The Account To Delete: ");
		String input = console.readLine();
		Statement s = con.createStatement();
		s.executeUpdate ("DELETE FROM all_users WHERE Last_Name = \'" + input + "\';");
		s.close();
	}
	
	// (11) CHANGE ACCOUNT INFORMATION
	void change_account_information() throws IOException, SQLException
	{
		System.out.print("Please Enter the Last Name Of The Account To Change: ");
		String lname = console.readLine();
		System.out.println("Select Atrribute To Change: ");
		System.out.println("1.) Hierarchy");
		System.out.println("2.) First Name");
		System.out.println("3.) Last Name");
		System.out.println("4.) Username");
		System.out.println("5.) Password");
		System.out.println("6.) Access_Code");
		System.out.println("7.) Group Name");
		String input = console.readLine();
		if(input.equals("1"))
		{
			System.out.println("Enter Hierarchy (1-3): ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET Hierarchy = "+h+" WHERE Last_Name = \'" + lname + "\';");
			s.close();			
		}
		else if(input.equals("2"))
		{
			System.out.println("Enter First Name: ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET First_Name = \'"+h+"\' WHERE Last_Name = \'" + lname + "\';");
			s.close();
		}
		else if(input.equals("3"))
		{
			System.out.println("Enter Last Name: ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET Last_Name = \'"+h+"\' WHERE Last_Name = \'" + lname + "\';");
			s.close();
		}
		else if(input.equals("4"))
		{
			System.out.println("Enter Username: ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET User_Name = \'"+h+"\' WHERE Last_Name = \'" + lname + "\';");
			s.close();
		}
		else if(input.equals("5"))
		{
			System.out.println("Enter Password: ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET Pass_Word = \'"+h+"\' WHERE Last_Name = \'" + lname + "\';");
			s.close();
		}
		else if(input.equals("6"))
		{
			System.out.println("Enter Access Code: ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET Access_Code = "+h+" WHERE Last_Name = \'" + lname + "\';");
			s.close();
		}
		else if(input.equals("7"))
		{
			System.out.println("Enter Group Name: ");
			String h = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE all_users SET G_Name = \'"+h+"\' WHERE Last_Name = \'" + lname + "\';");
			s.close();
		}		
	}
	
	// (12) ADD GROUP
	void add_group() throws IOException, SQLException
	{
		String g_id = "", g_name = "", member_count = "";
		
		//ENTER INFORMATION 
		System.out.println("Please Enter Your Information.\n");
		System.out.print("ID: ");
		g_id = console.readLine();

		System.out.print("Group Name: ");
		g_name = console.readLine();
		
		System.out.print("Member Count: ");
		member_count = console.readLine();

		Statement s1 = con.createStatement();
		s1.executeUpdate("INSERT INTO groups VALUES("+g_id+","+"\'"+g_name+"\',"+member_count+");");
		s1.close();
	}
	
	// (13) DELETE GROUP
	void delete_group() throws IOException, SQLException
	{
		System.out.print("Please Enter the Last Name of the Group to Delete: ");
		String input = console.readLine();
		Statement s = con.createStatement();
		s.executeUpdate ("DELETE FROM groups WHERE G_Name = \'" + input + "\';");
		s.close();
	}
	// (14) CHANGE GROUP INFORMATION
	void change_group_information() throws IOException, SQLException
	{
		System.out.print("Please Enter the Group to Change: ");
		String groupName = console.readLine();
		
		System.out.println("Select Atrribute To Change: ");
		System.out.println("1.) Group ID");
		System.out.println("2.) Group Name");
		
		String input = console.readLine();
		if(input.equals("1"))
		{
			System.out.println("Enter New Group ID: ");
			String g = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE groups SET G_ID = "+g+" WHERE G_Name = \'" + groupName + "\';");
			s.close();			
		}
		else if(input.equals("2"))
		{
			System.out.println("Enter New Group Name: ");
			String g = console.readLine();
			Statement s = con.createStatement();
			s.executeUpdate ("UPDATE groups SET G_Name = \'"+g+"\' WHERE G_Name = \'" + groupName + "\';");
			s.close();
		}
	}
	// (15) ADD APPOINTMENT
	void add_appointment() throws IOException, SQLException
	{
		String title = "", desc = "", loc = "", sh = "", sm = "", eh = "", em = "", month = "", day = "", year = "";
		//ENTER INFORMATION
		//Title, Description, Location, Start Hour, Start Minute, End Hour, End Minute, Month, Day of Month, Year
		System.out.println("Please Enter The Information.\n");
		System.out.print("Title: ");
		title = console.readLine();

		System.out.print("Description: ");
		desc = console.readLine();
		
		System.out.print("Location: ");
		loc = console.readLine();
	
		System.out.println("Enter Start and End Times (MILITARY TIME ONLY)");
		System.out.print("Start Hour: ");
		sh = console.readLine();

		System.out.print("Start Minute: ");
		sm = console.readLine();
		
		String start = sh + ":" + sm + ":00";
		
		System.out.print("End Hour: ");
		eh = console.readLine();
		
		System.out.print("End Minute: ");
		em = console.readLine();
		
		String end = eh + ":" + em + ":59";
		
		System.out.print("Month: ");
		month = console.readLine();
		
		System.out.print("Day of Month: ");
		day = console.readLine();
		
		System.out.print("Year: ");
		year = console.readLine();
		
		String date = year + "-" + month + "-" + day;
				
		
		
	}
	// (16) DELETE APPOINTMENT
	void delete_appointment() throws IOException, SQLException
	{}
	// (17) CHANGE APPOINTMENT INFORMATION
	void change_appointment_information() throws IOException, SQLException
	{}
	// (18) VIEW CONFLICTS WITHIN GROUPS
	void view_conflicts_within_groups() throws IOException, SQLException
	{}
	 
		
}
