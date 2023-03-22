package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


public class Transactions extends JFrame implements ActionListener {

	JLabel lbl2;
    JButton btnDeposit,btnWithdrawl,btnFastCash,btnStatement,btnPinChange,btnBalance,btnExit;
    String sCardno, sPin;
    Transactions(String sCardno,String sPin){
    	setTitle("AUTOMATED TELLER MACHINE");
    	setLayout(null);
    	
    	this.sPin = sPin;
    	this.sCardno = sCardno;
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(0, 0, 880, 900);
        add(lbl1);
        
        lbl2 = new JLabel("Please Select Your Transaction");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("System", Font.BOLD, 16));
        lbl2.setBounds(250,340,500,35);
        lbl1.add(lbl2);
        
        btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBounds(210,410,140,20);
        lbl1.add(btnDeposit);
        btnDeposit.addActionListener(this);
           
        btnWithdrawl = new JButton("WITHDRAWL");
        btnWithdrawl.setBounds(390,410,140,20);
        lbl1.add(btnWithdrawl);
        btnWithdrawl.addActionListener(this);
        
        btnFastCash = new JButton("FAST CASH");
        btnFastCash.setBounds(210,435,140,20);
        lbl1.add(btnFastCash);
        btnFastCash.addActionListener(this);
        
        btnStatement = new JButton("STATEMENT");
        btnStatement.setBounds(390,435,140,20);
        lbl1.add(btnStatement);
        btnStatement.addActionListener(this);
        
        btnPinChange = new JButton("PIN CHANGE");
        btnPinChange.setBounds(210,460,140,20);
        lbl1.add(btnPinChange);
        btnPinChange.addActionListener(this);
        
        btnBalance = new JButton("BALANCE");
        btnBalance.setBounds(390,460,140,20);
        lbl1.add(btnBalance);
        btnBalance.addActionListener(this);
        
        btnExit = new JButton("EXIT");
        btnExit.setBounds(390,485,140,20);
        lbl1.add(btnExit);
        btnExit.addActionListener(this);
        
       
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(880, 900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
    }
    
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		try {
			if(ae.getSource()== btnDeposit){
				setVisible(false);
	            new Deposit(sCardno,sPin).setVisible(true);
	            
			}else if(ae.getSource()== btnWithdrawl) {
				setVisible(false);
	            new Withdrawl(sCardno,sPin).setVisible(true);

			}else if(ae.getSource()== btnFastCash) {
				setVisible(false);
	            new FastCash(sCardno,sPin).setVisible(true);

			}else if(ae.getSource()== btnStatement) {
				new Statement(sCardno,sPin).setVisible(true);
			}else if(ae.getSource()== btnPinChange) {
				setVisible(false);
	            new PinChange(sCardno,sPin).setVisible(true);
			}else if(ae.getSource()== btnBalance) {
				this.setVisible(false);
	            new Balance(sCardno,sPin).setVisible(true);
			}else if(ae.getSource()== btnExit) {
       		 System.exit(0);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args){
        new Transactions("","").setVisible(true);
	}
}
