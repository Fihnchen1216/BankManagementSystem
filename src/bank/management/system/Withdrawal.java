package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{

	String sPin,sCardno;
	JLabel lbl2,lbl3;
	JTextField txt1,t2;
    JButton btnWithdraw,btnBack,b3;
    int customerId;
	Withdrawal(String sCardno,String sPin,int customerId){
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
        
        btnWithdraw = new JButton("WITHDRAW");
        btnWithdraw.setBounds(390,460,140,20);
        lbl1.add(btnWithdraw);
        btnWithdraw.addActionListener(this);
        
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
		try{        
			String sAmount = txt1.getText();
            Timestamp date = new Timestamp(System.currentTimeMillis());
            if(ae.getSource()==btnWithdraw){
                if(txt1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to withdraw");
                }else if (!isValidNumber(txt1.getText())) {
                    JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Conn c1 = new Conn();
                    
                    String query1 = "select * from bank where card_no = '"+sCardno+"' and pin = '"+sPin+"' and cus_id ='"+customerId+"'";
                    ResultSet rs = c1.s.executeQuery(query1);
                    int balance = 0;
                    while(rs.next() && isValidNumber(rs.getString("amount"))){
                       if(rs.getString("transaction_type").equals("deposit")){
                    	   balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                    	   balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(sAmount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    String query2 = "insert into bank (card_no, pin, transaction_date, transaction_type, amount, cus_id)"
                    		+ "values('"+sCardno+"', '"+sPin+"', '"+date+"', 'withdrawal', '"+sAmount+"','"+customerId+"')";
                    c1.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "$"+sAmount+" withdraw Successfully");
                    
                    setVisible(false);
                    new Transactions(sCardno,sPin,customerId).setVisible(true);
                }
            }else if(ae.getSource()==btnBack){
                setVisible(false);
                new Transactions(sCardno,sPin,customerId).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
	}

    private boolean isValidNumber(String number) {
        String numberPattern = "^[0-9]+$";

        return number.matches(numberPattern);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Withdrawal("","",0).setVisible(true);
	}
	
}
