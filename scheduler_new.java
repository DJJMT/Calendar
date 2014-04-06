import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

class scheduler_new extends JFrame
{
	//private static final long serialVersionUID = 1L;
	JPanel pane = new JPanel(); // create pane object	
	JButton Create_Button = new JButton("New User? Click Here"); //For New Users
	JButton Login_Button = new JButton("LOGIN"); //For Existing Users
	JPanel buttonPanel = new JPanel();
	JTextField FirstName_Box = new JTextField(); //For New Users
	JTextField LastName_Box = new JTextField(); //For New Users
	JTextField Username_Box = new JTextField(); //For New and Existing Users
	JPasswordField Password_Box = new JPasswordField(); //For New and Existing Users
	JLabel FirstName_Label = new JLabel("FIRST NAME: "); //For New Users
	JLabel LastName_Label = new JLabel("LAST NAME: "); //For New Users
	JLabel Username_Label = new JLabel("USERNAME: "); //For New and Existing Users
	JLabel Password_Label = new JLabel("PASSWORD: "); //For New and Existing Users
	JLabel Priority_Label = new JLabel("PRIORITY : "); //For New Users
	JLabel Title = new JLabel("Team J 2014 Calendar!"); //Both
	JLabel Login_Text = new JLabel("New User?");
	JComboBox User_Priority; //For New Users
	
	scheduler_new()
	{
		 
		/*FRAME*/
		super("Team J's Scheduler!");
		setBounds(550, 100, 350, 200);
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container con = this.getContentPane();
	    con.add(pane);   
	    pane.setLayout(null);
		
	    Title.setLayout(null);
	    Title.setLocation(0,0);
	    Title.setSize(450,50);
	    Title.setFont(new Font("Serif", Font.BOLD, 36));
	    Title.setForeground(Color.BLACK);
	    pane.add(Title);
	    
		/*LABEL - FIRSTNAME_LABEL*/
		FirstName_Label.setLayout(null);
		FirstName_Label.setLocation(10, 20);
		FirstName_Label.setSize(80,25);
//		pane.add(FirstName_Label);
		
		/*TEXT FIELD - FIRSTNAME_BOX*/
	    FirstName_Box.setLayout(null);
	    FirstName_Box.setLocation(100, 20);
	    FirstName_Box.setSize(210, 25);
//	    pane.add(FirstName_Box);	
		
		/*LABEL - LASTNAME_LABEL*/
		LastName_Label.setLayout(null);
		LastName_Label.setLocation(10, 60);
		LastName_Label.setSize(80,25);
//		pane.add(LastName_Label);
		
		/*TEXT FIELD - USERNAME_BOX*/
	    LastName_Box.setLayout(null);
	    LastName_Box.setLocation(100, 60);
	    LastName_Box.setSize(210, 25);
//	    pane.add(LastName_Box);	
		
		/*LABEL - USERNAME_LABEL*/
		Username_Label.setLayout(null);
		Username_Label.setLocation(10, 60);
		Username_Label.setSize(80,25);
		Username_Label.setForeground(Color.white);
		pane.add(Username_Label);
		
		/*TEXT FIELD - USERNAME_BOX*/
	    Username_Box.setLayout(null);
	    Username_Box.setLocation(120, 60);
	    Username_Box.setSize(210, 25);
	    Username_Box.setBackground(Color.BLACK);
		Username_Box.setForeground(Color.white);
	    pane.add(Username_Box);	
		
		/*LABEL - PASSWORD_LABEL*/
		Password_Label.setLayout(null);
		Password_Label.setLocation(10, 100);
		Password_Label.setSize(80,25);
		Password_Label.setForeground(Color.white);
		pane.add(Password_Label);
		
		/*TEXT FIELD - PASSWORD_BOX*/
	    Password_Box.setLayout(null);
	    Password_Box.setLocation(120, 100);
	    Password_Box.setSize(210, 25);
	    Password_Box.setBackground(Color.BLACK);
		Password_Box.setForeground(Color.white);
	    pane.add(Password_Box);
	    
	    Login_Text.setLayout(null);
	    Login_Text.setLocation(10,140);
	    Login_Text.setSize(100,45);
	    Login_Text.setForeground(Color.white);
//	    pane.add(Login_Text);
		
		/*LABEL - PRIORITY_LABEL*/
		Priority_Label.setLayout(null);
		Priority_Label.setLocation(10, 180);
		Priority_Label.setSize(80,25);
//		pane.add(Priority_Label);
		
		/*COMBO-BOX - USER_PRIORITY*/
		String [] s = {" ", "USER", "MANAGER", "ADMINISTRATOR"};
		User_Priority = new JComboBox(s);
		User_Priority.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
		User_Priority.setLocation(100, 180);
		User_Priority.setSize(210, 25);
//		pane.add(User_Priority);
		
	    
	    /*BUTTON - CREATE*/
	    Create_Button.setLayout(null);
	    Create_Button.setLocation(00, 140);
	    Create_Button.setSize(150, 25);
	    Create_Button.setFocusPainted(false);
	    Create_Button.setMargin(new Insets(0,0,0,0));
	    Create_Button.setContentAreaFilled(false);
	    Create_Button.setBorderPainted(false);
	    Create_Button.setOpaque(false);
	    Create_Button.setForeground(Color.BLACK);
	    ClickListener cl = new ClickListener();
		Create_Button.addActionListener(cl);
	    pane.add(Create_Button);
	    
	    
	    /*BUTTON - LOG IN*/
	    Login_Button.setLayout(null);
	    Login_Button.setLocation(185, 140);
	    Login_Button.setSize(125, 25);
	    pane.add(Login_Button);	
		//connect.setBackground(Color.gray);
		
		/*CLOCK IMAGE*/
		String path = "clock.jpg";
	    JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel(new ImageIcon(path));
		label.setLocation(0, 0);
		label.setSize(450,450);
		pane.add(label);
	    setVisible(true);
	}
	
	
		public static void main(String[] args) throws Exception
		{
		  new scheduler_new();
		}
		
	
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
		
			try
		  {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","mysql");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement("INSERT INTO newaccount Values('Spongebob', 'Squarepants', 'sb', 'pineapple00');");
			statement.executeUpdate();
			con.close();
		  }
		  catch(Exception e2)
		  {
			e2.printStackTrace();
		  }
		
        }
    }

		
}
