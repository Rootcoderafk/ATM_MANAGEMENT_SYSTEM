package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JLabel welcomeLabel;
    JLabel CardNumLabel;
    JLabel PinLabel;

    JTextField CardtextFeild;
    JPasswordField passwordField;

    JButton SignIn , Clear , SignUp;

    Login(){
        super("Bank Management System");//title

        ImageIcon imageBank = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));//bank image
        Image imageBank2 = imageBank.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageBank3 = new ImageIcon(imageBank2);
        JLabel image = new JLabel(imageBank3);
        image.setBounds(350,10,100,100);
        add(image);
        
        ImageIcon imageCard = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image imageCard2 = imageCard.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageCard3 = new ImageIcon(imageCard2);
        JLabel image2 = new JLabel(imageCard3);
        image2.setBounds(630,350,100,100);
        add(image2);


        welcomeLabel = new JLabel("WELCOME TO ATM");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("AvantGrande",Font.BOLD,38));
        welcomeLabel.setBounds(230,125,450,40);//respective to frame
        add(welcomeLabel);

        CardNumLabel = new JLabel("Card No.");
        CardNumLabel.setFont(new Font("Ralway",Font.BOLD,28));
        CardNumLabel.setForeground(Color.WHITE);
        CardNumLabel.setBounds(150,190,375,30);
        add(CardNumLabel);

        CardtextFeild = new JTextField(15);
        CardtextFeild.setBounds(325,190,230,30);
        CardtextFeild.setFont(new Font("Arial",Font.BOLD,14));
        add(CardtextFeild);

        PinLabel = new JLabel("Enter PIN");
        PinLabel.setFont(new Font("Ralway",Font.BOLD,28));
        PinLabel.setForeground(Color.WHITE);
        PinLabel.setBounds(150,250,375,30);
        add(PinLabel);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(325,250,230,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField);


        SignIn = new JButton("SIGN IN");
        SignIn.setFont(new Font("Arial",Font.BOLD,14));
        SignIn.setForeground(Color.WHITE);
        SignIn.setBackground(Color.BLACK);
        SignIn.setBounds(300, 300, 100, 30);
        SignIn.addActionListener(this);
        add(SignIn);
          
        Clear = new JButton("CLEAR");
        Clear.setFont(new Font("Arial",Font.BOLD,14));
        Clear.setForeground(Color.WHITE);
        Clear.setBackground(Color.BLACK);
        Clear.setBounds(430, 300, 100, 30);
        Clear.addActionListener(this);
        add(Clear);
        
        SignUp = new JButton("SIGN UP");
        SignUp.setFont(new Font("Arial",Font.BOLD,14));
        SignUp.setForeground(Color.WHITE);
        SignUp.setBackground(Color.BLACK);
        SignUp.setBounds(300, 350, 230, 30);
        SignUp.addActionListener(this);
        add(SignUp);


        ImageIcon imageBackground = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image imageBackground2 = imageBackground.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon imageBackground3 = new ImageIcon(imageBackground2);
        JLabel image3 = new JLabel(imageBackground3);
        image3.setBounds(0,0,850,480);
        add(image3);


        setLayout(null);
        setSize(850,480);//creation of frame
        setLocation(450, 200);//respective to screen
        setUndecorated(true);
        setVisible(true);//by default the frame is not visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==SignIn){
                Con c = new Con();
                String cardNo = CardtextFeild.getText();

                char[] pinChars = passwordField.getPassword();
                String pin = new String(pinChars);//getText() can be used but its not safe 
                Arrays.fill(pinChars, '0'); // Clear sensitive data from memory


                String q = "select * from login where card_No ='"+cardNo+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Inncorrect Details");
                }



            }else if(e.getSource()==Clear){
                CardtextFeild.setText("");
                passwordField.setText("");
            }else if(e.getSource()==SignUp){
                new Signup();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }     
    }

    
    public static void main(String[] args) {
        new Login();
    }


}
