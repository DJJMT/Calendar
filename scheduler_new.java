import java.io.*;
import java.awt.*;
import java.util.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

import java.nio.file.Files;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

class scheduler_new extends JFrame
{
	//private static final long serialVersionUID = 1L;
	JPanel pane = new JPanel(); // create pane object	
	JButton Create_Button = new JButton("CREATE");
	JButton Login_Button = new JButton("LOGIN");
	JPanel buttonPanel = new JPanel();
	JTextField FirstName_Box = new JTextField();
	JTextField LastName_Box = new JTextField();
	JTextField Username_Box = new JTextField();
	JTextField Password_Box = new JTextField();
	JLabel FirstName_Label = new JLabel("FIRST NAME: ");
	JLabel LastName_Label = new JLabel("LAST NAME: ");
	JLabel Username_Label = new JLabel("USERNAME: ");
	JLabel Password_Label = new JLabel("PASSWORD: ");
	JLabel Priority_Label = new JLabel("PRIORITY : ");
	JComboBox User_Priority;
	
	scheduler_new()
	{
		 
		/*FRAME*/
		super("Team J's Scheduler!");
		setBounds(350, 350, 350, 350);
		setResizable(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container con = this.getContentPane();
	    con.add(pane);   
	    pane.setLayout(null);
		
		/*LABEL - FIRSTNAME_LABEL*/
		FirstName_Label.setLayout(null);
		FirstName_Label.setLocation(10, 20);
		FirstName_Label.setSize(80,25);
		pane.add(FirstName_Label);
		
		/*TEXT FIELD - FIRSTNAME_BOX*/
	    FirstName_Box.setLayout(null);
	    FirstName_Box.setLocation(100, 20);
	    FirstName_Box.setSize(210, 25);
	    pane.add(FirstName_Box);	
		
		/*LABEL - LASTNAME_LABEL*/
		LastName_Label.setLayout(null);
		LastName_Label.setLocation(10, 60);
		LastName_Label.setSize(80,25);
		pane.add(LastName_Label);
		
		/*TEXT FIELD - USERNAME_BOX*/
	    LastName_Box.setLayout(null);
	    LastName_Box.setLocation(100, 60);
	    LastName_Box.setSize(210, 25);
	    pane.add(LastName_Box);	
		
		/*LABEL - USERNAME_LABEL*/
		Username_Label.setLayout(null);
		Username_Label.setLocation(10, 100);
		Username_Label.setSize(80,25);
		pane.add(Username_Label);
		
		/*TEXT FIELD - USERNAME_BOX*/
	    Username_Box.setLayout(null);
	    Username_Box.setLocation(100, 100);
	    Username_Box.setSize(210, 25);
	    pane.add(Username_Box);	
		
		/*LABEL - PASSWORD_LABEL*/
		Password_Label.setLayout(null);
		Password_Label.setLocation(10, 140);
		Password_Label.setSize(80,25);
		pane.add(Password_Label);
		
		/*TEXT FIELD - PASSWORD_BOX*/
	    Password_Box.setLayout(null);
	    Password_Box.setLocation(100, 140);
	    Password_Box.setSize(210, 25);
	    pane.add(Password_Box);
		
		/*LABEL - PRIORITY_LABEL*/
		Priority_Label.setLayout(null);
		Priority_Label.setLocation(10, 180);
		Priority_Label.setSize(80,25);
		pane.add(Priority_Label);
		
		/*COMBO-BOX - USER_PRIORITY*/
		String [] s = {" ", "USER", "MANAGER", "ADMINISTRATOR"};
		User_Priority = new JComboBox(s);
		User_Priority.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
		User_Priority.setLocation(100, 180);
		User_Priority.setSize(210, 25);
		pane.add(User_Priority);
		
	    
	    /*BUTTON - CREATE*/
	    Create_Button.setLayout(null);
	    Create_Button.setLocation(165, 215);
	    Create_Button.setSize(125, 25);
	    ClickListener cl = new ClickListener();
		Create_Button.addActionListener(cl);
	    pane.add(Create_Button);
	    
	    
	    /*BUTTON - LOG IN*/
	    Login_Button.setLayout(null);
	    Login_Button.setLocation(5, 215);
	    Login_Button.setSize(125, 25);
	    pane.add(Login_Button);	
		//connect.setBackground(Color.gray);
		
		/*CLOCK IMAGE*/
		String path = "clock.jpg";
	    //JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel(new ImageIcon(path));
		label.setLocation(50, 50);
		label.setSize(200,200);
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
