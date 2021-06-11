package chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
    

public class Start extends JFrame{
    JLabel l1;
    JButton b1, b2, b3, b4, b5;
    JPanel p1;
    Start()
    {
        p1 = new JPanel();

        JPanel p2 = new JPanel(); 
        l1 = new JLabel("WELCOME TO FARMERS GUIDE");
        setSize(400,300);
        setLayout(new BorderLayout());
        b1= new JButton(" SIGN UP");
        b2= new JButton("SIGN IN");
        b3= new JButton("EXIT");
        
        b1.setBackground(Color.GREEN);
        b2.setBackground(Color.YELLOW);
        b3.setBackground(Color.RED);
       
        p1.add(b1,BorderLayout.CENTER);
        p1.add(b2);
        p1.add(b3);

        p2.add(l1);

        p1.setLayout(new FlowLayout());
        
        add(p2,BorderLayout.CENTER);
        add(p1,BorderLayout.SOUTH);
        
        setVisible(true);
        
        MyActionListener m = new MyActionListener();
        
        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);

    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource()== b1)
            {
                dispose();
                FarmerSignUp a = new FarmerSignUp();
            }
            if (e.getSource()== b2)
            {
                dispose();
                FarmerSignIn b = new FarmerSignIn();
            }
             
            if (e.getSource() == b3)
            {
                dispose();
                System.exit(0);
            }


        }
    }
    public static void main(String[] args) {
        Start app = new Start();
    }
}
