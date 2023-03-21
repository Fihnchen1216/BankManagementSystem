package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{

	String sPin;
	JLabel lbl2,lbl3;
	JTextField txt1,t2;
    JButton btnWithdrawl,btnBack,b3;
    
	Withdrawl(String sPin){
		this.sPin = sPin;
    	
    	setLayout(null);
  	
    	ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(0, 0, 880, 900);
        add(lbl1);
        
        
        lbl2 = new JLabel("Maximum Withdrawal is $1,000");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("System", Font.BOLD, 16));
        lbl2.setBounds(250,315,500,25);
        lbl1.add(lbl2);
        
        lbl3 = new JLabel("Please enter your amount");
        lbl3.setForeground(Color.BLACK);
        lbl3.setFont(new Font("System", Font.BOLD, 16));
        lbl3.setBounds(250,340,500,25);
        lbl1.add(lbl3);
        
        txt1 = new JTextField();
        txt1.setFont(new Font("Raleway", Font.BOLD, 16));
        txt1.setBounds(250,380,250,25);
        lbl1.add(txt1);
        
        btnWithdrawl = new JButton("WITHDRAWL");
        btnWithdrawl.setBounds(390,460,140,20);
        lbl1.add(btnWithdrawl);
        btnWithdrawl.addActionListener(this);
        
        btnBack = new JButton("BACK");
        btnBack.setBounds(390,485,140,20);
        lbl1.add(btnBack);
        btnBack.addActionListener(this);
        
        
        setSize(880, 900);
        setLocation(350,10);
        //setUndecorated(true);
        setVisible(true);
        
	}
	public void actionPerformed(ActionEvent ae) {
		try{        
            String sAmount = txt1.getText();
            Date date = new Date();
            if(ae.getSource()==btnWithdrawl){
                if(txt1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where sPin = '"+sPin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("sAmount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("sAmount"));
                       }
                    }
                    if(balance < Integer.parseInt(sAmount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+sPin+"', '"+date+"', 'Withdrawl', '"+sAmount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+sAmount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(sPin).setVisible(true);
                }
            }else if(ae.getSource()==btnBack){
                setVisible(false);
                new Transactions(sPin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Withdrawl("").setVisible(true);
	}
	
}
