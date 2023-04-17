package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
	
	JTextField txtAmount;
    JButton btnDeposit,btnBack,b3;
    JLabel lbl2;
    String sPin,sCardno;
    int customerId;
    Deposit(String sCardno,String sPin,int customerId){
    	this.sPin = sPin;
    	this.sCardno =sCardno;
    	this.customerId = customerId;
    	setLayout(null);
  	
    	ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(0, 0, 880, 900);
        add(lbl1);
        
        
        lbl2 = new JLabel("Enter amount you want to deposit");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("System", Font.BOLD, 16));
        lbl2.setBounds(250,340,500,25);
        lbl1.add(lbl2);
        
        txtAmount = new JTextField();
        txtAmount.setFont(new Font("Raleway", Font.BOLD, 16));
        txtAmount.setBounds(250,380,250,25);
        lbl1.add(txtAmount);
        
        btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBounds(390,460,140,20);
        lbl1.add(btnDeposit);
        btnDeposit.addActionListener(this);
        
        btnBack = new JButton("BACK");
        btnBack.setBounds(390,485,140,20);
        lbl1.add(btnBack);
        btnBack.addActionListener(this);
        
        setSize(880, 900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
         
    }
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			String sAmount = txtAmount.getText();
			Timestamp date = new Timestamp(System.currentTimeMillis());
            if(ae.getSource()==btnDeposit){
                if(txtAmount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    
                    String query = "insert into bank (card_no,pin,transaction_date,transaction_type,amount,cus_id) "
                    		+ "values('"+sCardno+"', '"+sPin+"', '"+date+"', 'Deposit', '"+sAmount+"','"+customerId+"')";
                    c1.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "$"+sAmount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(sCardno,sPin,customerId).setVisible(true);
                }
            }else if(ae.getSource()==btnBack){
                setVisible(false);
                new Transactions(sCardno,sPin,customerId).setVisible(true);
            }
		} catch(Exception e) {
			 e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit("","",0).setVisible(true);
	}

	
}
