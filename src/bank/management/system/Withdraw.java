package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener{

    String pin;
    TextField textField;
    JButton b1,b2;

    
    Withdraw(String pin){
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0,1920,1080);
        add(l3);

        textField=new TextField();
        textField.setBounds(570,318,396,33);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS Rs 10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(569,234,700,45);
        l3.add(label1);
        
        JLabel label2 = new JLabel("PLEASE ENTER THE AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(569,274,700,45);
        l3.add(label2);


        b1=new JButton("WITHDRAW");
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
            
            if(e.getSource()==b2){
                setVisible(false);
                new main_Class(pin);
                return;
            }


            String amount = textField.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Withdraw");
            }else {
                Con c = new Con();
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if(balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return ; 
                }


                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs "+amount+" debited Successfully");
                setVisible(false);
                new main_Class(pin);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
