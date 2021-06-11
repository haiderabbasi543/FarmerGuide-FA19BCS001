package chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class FarmerSignIn extends  JFrame {
    
        JFrame frame;
        JLabel l1,l2;
        JTextField t1;
        JPasswordField jpf;
        JButton b1,b2;
        
        private static int index;
        public static int getIndex()
        {
            return index;
        }
        public FarmerSignIn()
        {
            index=0;
           
            frame = new JFrame("Login");
            frame.setSize(450,225);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            l1 = new JLabel ("Enter UserName");
            l2 = new JLabel ("Enter Password");
            
            l1.setBounds(80, 20, 150, 25);
            frame.getContentPane().add(l1);
            l2.setBounds(80, 70, 120, 25);
            frame.getContentPane().add(l2);
            
            t1 = new JTextField(20);
            t1.setBounds(214, 20, 154, 23);
            frame.getContentPane().add(t1);
            
            jpf = new JPasswordField(20);
            jpf.setBounds(214, 70, 154, 23);
            frame.getContentPane().add(jpf);
            
            b1 = new JButton("Login");
            b1.setBounds(120, 130, 89, 30);
            b2 = new JButton("Home");
            b2.setBounds(220, 130, 89, 30);
            
            frame.getContentPane().add(b1);
            frame.getContentPane().add(b2);
            
            b1.addActionListener(new MyListener());
            b2.addActionListener(new MyListener());
            frame.setVisible(true);
        }
        public class MyListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== b1)
                {
                        if (checkLogin())
                            {   
                                frame.dispose();
                                afterFarmerSignIn a = new afterFarmerSignIn();
                            }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invalid Username or Passowrd");
                        }        
                    
                }
                    
                if(e.getSource()== b2)
                {
                    frame.dispose();
                    Start s = new Start();
                }
            }
        }

        private boolean checkLogin(){
            ArrayList<farmerr> list = farmerr.readFromFile();
            try {
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).getUserName().equals(t1.getText()) && list.get(i).getPassword().equals(jpf.getText())){
                        return true;
                    }
                    index++;
                    if(index>=list.size()){
                        index=0;
                        throw new IndexOutOfBoundsException(); 
                    }
                }
                
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
            return false;
        }
        
        
        public static void main(String[] args) {
            FarmerSignIn s = new FarmerSignIn(); 
        }    
    }