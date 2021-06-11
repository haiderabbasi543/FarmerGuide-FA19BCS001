package chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class FarmerSignUp extends JFrame {
    JLabel l1,l2, l3, l4;
    JTextField t1, t2, t3;
    JButton b1, b2;
    JPanel p1, p2;
    JPasswordField jpf;

    public FarmerSignUp()
    {
        setSize(400,300);
        setLayout (new BorderLayout());
        l1 = new JLabel (" Enter First Name");
        l1.setBounds(10, 10, 150, 25);
        l2 = new JLabel (" Enter Last Name");
        l2.setBounds(10, 60, 150, 25);
        l3 = new JLabel (" Enter Username");
        l3.setBounds(10, 110, 150, 25);
        l4 = new JLabel (" Enter Password");
        l4.setBounds(10, 160, 150, 25);
                         
        t1 = new JTextField(10);
        t1.setBounds(165, 10, 200, 25);
        t2 = new JTextField(20);
        t2.setBounds(165, 60, 200, 25);
        t3 = new JTextField(20);
        t3.setBounds(165, 110, 200, 25);
        jpf = new JPasswordField(20);
        jpf.setBounds(165,160, 200, 25);

              b1 = new JButton("Submit");
              b1.setBounds(30, 210, 150, 25);
              b2 = new JButton("Home");
              b2.setBounds(185,210, 150, 25);
              
              p1 = new JPanel();
              p1.setLayout(null);
         
              p2 = new JPanel();
              p2.setLayout(new FlowLayout());
              
              p1.add(l1);
              p1.add( t1);
              p1.add(l2);
              p1.add( t2);
         
              p1.add(l3);
              p1.add( t3);
         
         
              p1.add(l4);
              p1.add( jpf);
 
              
              p1.add(b1);
              p1.add(b2);
              
              add(p1,BorderLayout.CENTER);
              //add(p2, BorderLayout.CENTER);
              
            b1.addActionListener(new MyListener());
            b2.addActionListener(new MyListener());
              setVisible(true);
    }
              
                public class MyListener implements ActionListener 
                {
                    public void actionPerformed(ActionEvent e)
                    {

                        if (e.getSource()== b1)
                        {
                                    farmerr f1 = new farmerr (); 
                                    f1.setFirstName(t1.getText());
                                    f1.setLastName(t2.getText());
                                    f1.setUserName(t3.getText());
                                    f1.setPassword(jpf.getText());
                                    
                                    farmerr.WriteToFile(f1);                                    
                                    dispose();
                                    FarmerSignIn s = new FarmerSignIn();
                        }
                            else if (e.getSource()== b2)
                            {
                                dispose();
                                Start a = new Start();
                            }
                    }
            }
                
public static void main(String[] args) {
        FarmerSignUp entry = new FarmerSignUp();
    }
}    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    









