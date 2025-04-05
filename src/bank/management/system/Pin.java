package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Pin extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    
    Pin(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0,1920,1080);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(580, 200, 400, 45);
        l3.add(label1);
        
        JLabel label2 = new JLabel("New PIN");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(580, 270, 200, 40);
        l3.add(label2);


        p1 = new JPasswordField();
        p1.setBounds(800, 270, 250, 40);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p1);
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);


        JLabel label3 = new JLabel("Re-Enter  New PIN");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(580, 340, 250, 40);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBounds(800, 340, 250, 40);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p2);
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);


       b1=new JButton("CHANGE");
        b1.setBounds(867,471,186,46);
        b1.setBackground(new Color(62,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);
        
        b2=new JButton("BACK");
        b2.setBounds(867,528,186,46);
        b2.setBackground(new Color(62,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);
        
        
        setLayout(null);
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        


        try {
            
            char[] pin1Chars = p1.getPassword();
            char[] pin2Chars = p2.getPassword();

            String pin1 = new String(pin1Chars);
            String pin2 = new String(pin2Chars);

            Arrays.fill(pin1Chars, '0');
            Arrays.fill(pin2Chars, '0');


            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if(e.getSource()==b1){
                if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter  NEW PIN ");
                    return;
                }

                if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter NEW PIN ");
                    return;
                }

                Con c = new Con();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";
            
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new main_Class(pin2);
                
            
            }else if(e.getSource()==b2){
                setVisible(false);
                new main_Class(pin);
                return;
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
