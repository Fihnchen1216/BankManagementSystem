package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Statement extends JFrame implements ActionListener{

	String sPin,sCardno;
	JButton btnExit;
    JLabel lbl1,lbl2,lbl3,lbl4;
	Statement(String sCardno,String sPin){
		setTitle("Statement");
		this.sPin = sPin;
		this.sCardno = sCardno;
		setLayout(null);
		
		
        lbl1 = new JLabel();
        lbl1.setBounds(20, 140, 400, 200);
        add(lbl1);
        
        lbl2 = new JLabel("American Bank");
        lbl2.setBounds(150, 20, 100, 20);
        add(lbl2);
        
        lbl3 = new JLabel();
        lbl3.setBounds(20, 80, 300, 20);
        add(lbl3);
        
        lbl4 = new JLabel();
        lbl4.setBounds(20, 400, 300, 20);
        add(lbl4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where sPin = '"+sPin+"'");
            while(rs.next()){
                lbl3.setText("Card Number:    " + rs.getString("sCardno").substring(0, 4) + "XXXXXXXX" + rs.getString("sCardno").substring(12));
            }
        }catch(Exception e){
        	System.out.println(e);
        }
		
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where sPin = '"+sPin+"'");
            while(rs.next()){
                lbl1.setText(lbl1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$" + rs.getString("sAmount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("sAmount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("sAmount"));
                }
            }
            lbl4.setText("Your total Balance: $"+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        btnExit = new JButton("Exit");
        btnExit.setBounds(20, 500, 100, 25);
        add(btnExit);
        btnExit.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

		setSize(400,600);
        setLocation(20,20);
        setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Statement("","").setVisible(true);
	}


}
