package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;  

public class Deposit extends JFrame implements ActionListener{
    
    String pin;
    TextField textField;
    JButton b1,b2;


    Deposit(String pin){

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0,1920,1080);
        add(l3);

        textField=new TextField();
        textField.setBounds(570,299,396,33);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(569,234,495,45);
        l3.add(label1);

        b1=new JButton("DEPOSIT");
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
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource()==b1){
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter a Valid Amount");
                }else{
                    Con c = new Con();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }
            }else if(e.getSource()==b2){
                setVisible(false);
                new main_Class(pin);
            }
        }catch (Exception E) {
            E.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
