//import statements here
import java.awt.*;
import javax.swing.*;

import java.awt.event.*; 

public class NewFrame2 extends JFrame implements ActionListener
{
        //initialises the frame and opens it
        public NewFrame2()
        {
                JButton open = new JButton("New Window");
                open.addActionListener(this);
                add(open);
                setVisible(true);
        }

        public void actionPerformed(ActionEvent event)
        {
                //code for the new frame
        }
}