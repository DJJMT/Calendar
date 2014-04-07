//import statements here
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewFrame1 extends JFrame implements ActionListener
{
	private JButton Back_Button;
	private JButton Create_Button;
	
        //initialises the frame and opens it
        public NewFrame1()
        {
        	super("New User Registration");
        	
        	JPanel pane = new JPanel(); // create pane object	
//        	JButton Create_Button = new JButton("CREATE");
//        	JButton Back_Button = new JButton("Existing User?");
        	JTextField FirstName_Box = new JTextField();
        	JTextField LastName_Box = new JTextField();
        	JTextField Username_Box = new JTextField();
        	JPasswordField Password_Box = new JPasswordField();
        	JPasswordField Password_Veri_Box = new JPasswordField();
        	JTextField Priority_Box = new JTextField();
        	JLabel FirstName_Label = new JLabel("First Name: ");
        	JLabel LastName_Label = new JLabel("Last Name: ");
        	JLabel Username_Label = new JLabel("Username: ");
        	JLabel Password_Label = new JLabel("Password: ");
        	JLabel Password_Veri_Label = new JLabel("Retype Password: ");
        	JLabel Priority_Label = new JLabel("Access Code : ");

//        	String userpass = Password_Box.getText();
//            String veripass = Password_Veri_Box.getText();

//                JButton open = new JButton("Jason");
//                open.addActionListener(this);
//                add(open);
    		/*FRAME*/
    		setBounds(350, 350, 350, 350);
    		setResizable(false);
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
    	    FirstName_Box.setLocation(120, 20);
    	    FirstName_Box.setSize(210, 25);
    	    pane.add(FirstName_Box);	


    		/*LABEL - LASTNAME_LABEL*/
    		LastName_Label.setLayout(null);
    		LastName_Label.setLocation(10, 60);
    		LastName_Label.setSize(80,25);
    		pane.add(LastName_Label);


    		/*TEXT FIELD - USERNAME_BOX*/
    	    LastName_Box.setLayout(null);
    	    LastName_Box.setLocation(120, 60);
    	    LastName_Box.setSize(210, 25);
    	    pane.add(LastName_Box);	


    		/*LABEL - USERNAME_LABEL*/
    		Username_Label.setLayout(null);
    		Username_Label.setLocation(10, 100);
    		Username_Label.setSize(80,25);
    		pane.add(Username_Label);


    		/*TEXT FIELD - USERNAME_BOX*/
    	    Username_Box.setLayout(null);
    	    Username_Box.setLocation(120, 100);
    	    Username_Box.setSize(210, 25);
    	    pane.add(Username_Box);	


    		/*LABEL - PASSWORD_LABEL*/
    		Password_Label.setLayout(null);
    		Password_Label.setLocation(10, 140);
    		Password_Label.setSize(80,25);
    		pane.add(Password_Label);


    		/*TEXT FIELD - PASSWORD_BOX*/
    	    Password_Box.setLayout(null);
    	    Password_Box.setLocation(120, 140);
    	    Password_Box.setSize(210, 25);
    	    pane.add(Password_Box);


    	    /*LABEL - Password_Veri_Box_LABEL*/
    	    Password_Veri_Label.setLayout(null);
    	    Password_Veri_Label.setLocation(10, 180);
    	    Password_Veri_Label.setSize(120,25);
    		pane.add(Password_Veri_Label);


    		/*TEXT FIELD - Password_Veri_Box*/
    		Password_Veri_Box.setLayout(null);
    		Password_Veri_Box.setLocation(120, 180);
    		Password_Veri_Box.setSize(210, 25);
    	    pane.add(Password_Veri_Box);


    		/*LABEL - PRIORITY_LABEL*/
    		Priority_Label.setLayout(null);
    		Priority_Label.setLocation(10, 220);
    		Priority_Label.setSize(100,25);
    		pane.add(Priority_Label);


    		/*TEXT FIELD - PRIORITY_BOX*/
    		Priority_Box.setLayout(null);
    		Priority_Box.setLocation(120, 220);
    		Priority_Box.setSize(210, 25);
    	    pane.add(Priority_Box);


    	    /*BUTTON - CREATE*/
    	    Create_Button = new JButton("Create Account");
    	    Create_Button.setLayout(null);
    	    Create_Button.setLocation(185, 260);
    	    Create_Button.setSize(125, 25);
    	//  ClickListener cl = new ClickListener();
    	//	Create_Button.addActionListener(cl);
    	    pane.add(Create_Button);
    	    
    	    /*BUTTON - BACK*/
    	    Back_Button = new JButton("Back_Button");
    	    Back_Button.setLayout(null);
    	    Back_Button.setLocation(00, 260);
    	    Back_Button.setSize(165, 25);
    	    Back_Button.setFocusPainted(false);
    	    Back_Button.setMargin(new Insets(0,0,0,0));
    	    Back_Button.setContentAreaFilled(false);
    	    Back_Button.setBorderPainted(false);
    	    Back_Button.setOpaque(false);
    	    Back_Button.setForeground(Color.BLACK);
    	    Back_Button.setFont(new Font("Arial", Font.ITALIC, 16));
    	    ClickListener cl = new ClickListener();
    		Back_Button.addActionListener(cl);
    	    pane.add(Back_Button);

            ButtonHandler handler = new ButtonHandler();    //creation of a new Object
            Create_Button.addActionListener(handler);          // Attach/register handler to Create_Button
            Back_Button.addActionListener(handler);   
    	    
                setVisible(true);
        }

        private class ButtonHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == Create_Button) {
                    	setVisible(false);
                            new NewFrame1();

                    }
                    if (e.getSource() == Back_Button) {
                    	setVisible(false);
                            new MainFrame();
                    }
            }
    } // end of inner class

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}