package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener{

    String formno;
    JComboBox<String> comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan, textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;


    Signup2(String first){

        super("APPLICATION FORM");

        ImageIcon imageBank = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));//bank image
        Image imageBank2 = imageBank.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageBank3 = new ImageIcon(imageBank2);
        JLabel image = new JLabel(imageBank3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formno=first;

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Detail");
        l2.setFont(new Font("Raleway",Font.BOLD,22));  
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion : ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,120,100,30);
        add(l3);

        String religion[] = {"--SELECT--","Hindu","Muslim","Sikh","Christian","Others"};
        comboBox = new JComboBox<>(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);


        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);

        String category[] = {"--SELECT--","General","OBC","SC","ST","Others"};
        comboBox2 = new JComboBox<>(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);
        
        JLabel l5 = new JLabel("Income : ");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100,220,100,30);
        add(l5);

        String income[] = {"--SELECT--","<1,50,000","<2,50,000","<5,00,000","<8,00,000","Above 8,00,000","NULL"};
        comboBox3 = new JComboBox<>(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);
        
        JLabel l6 = new JLabel("Education : ");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,270,150,30);
        add(l6);

        String education[] = {"--SELECT--","Non-Graduate","Graduate","Post-Gratuate","Doctorate","Other"};
        comboBox4 = new JComboBox<>(education);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);
        
        JLabel l7 = new JLabel("Ocupation : ");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100,330,150,30);
        add(l7);

        String ocupation[] = {"--SELECT--","Salaried","Self-Employeed","Student","Retired","Other"};
        comboBox5 = new JComboBox<>(ocupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,330,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN : ");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,390,150,30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,18));
        textPan.setBounds(350,390,320,30);
        add(textPan);
        
        JLabel l9 = new JLabel("AADHAR : ");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100,440,150,30);
        add(l9);
        
        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway",Font.BOLD,18));
        textAadhar.setBounds(350,440,320,30);
        add(textAadhar);
        
        JLabel l10 = new JLabel("SENIOR CITIZER : ");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,490,180,30);
        add(l10);
        
        r1 = new JRadioButton("YES");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(350,490,100,30);
        add(r1);       
        
        r2 = new JRadioButton("NO");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(460,490,100,30);
        add(r2);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        
        JLabel l11 = new JLabel("EXISTING ACCOUNT : ");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,540,200,30);
        add(l11);
        
        e1 = new JRadioButton("YES");
        e1.setFont(new Font("Raleway",Font.BOLD,14));
        e1.setBackground(new Color(252,208,76));
        e1.setBounds(350,540,100,30);
        add(e1);       
        
        e2 = new JRadioButton("NO");
        e2.setFont(new Font("Raleway",Font.BOLD,14));
        e2.setBackground(new Color(252,208,76));
        e2.setBounds(460,540,100,30);
        add(e2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel l12 = new JLabel("FORM NO : ");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(700,10,120,30);
        add(l12);
        
        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l13.setBounds(780,10,60,30);
        add(l13);

        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setVisible(true);
        
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String)comboBox.getSelectedItem();
        String cate = (String)comboBox2.getSelectedItem();
        String inc = (String)comboBox3.getSelectedItem();
        String edu = (String)comboBox4.getSelectedItem();
        String occ = (String)comboBox5.getSelectedItem();
        
        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = null;
        if(r1.isSelected()){
            scitizen="Yes";
        }else if(r2.isSelected()){
            scitizen="No";
        }
        
        String eaccount = null;
        if(e1.isSelected()){
            eaccount="Yes";
        }else if(e2.isSelected()){
            eaccount="No";
        }


        try{
            if(pan.equals("") || aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "fill all the spaces");
            }else{
                Con c1 = new Con();
                String q = "insert into signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }

}
