package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class Balance extends JFrame implements ActionListener{

	String sPin,sCardno;
	JButton btnBack;
	JLabel lbl2, lbl3;
	 
	Balance(String sCardno,String sPin){
		this.sPin = sPin;
    	this.sCardno =sCardno;
    	setLayout(null);
  	
    	ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(0, 0, 880, 900);
        add(lbl1);
        
        
        lbl2 = new JLabel("Your Current Account Balance");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("System", Font.BOLD, 16));
        lbl2.setBounds(250, 350, 400, 35);
        lbl1.add(lbl2);
        
        lbl3 = new JLabel();
        lbl3.setForeground(Color.BLACK);
        lbl3.setFont(new Font("System", Font.BOLD, 16));
        lbl3.setBounds(340, 380, 400, 35);
        lbl1.add(lbl3);

        
        btnBack = new JButton("BACK");
        btnBack.setBounds(390,485,140,20);
        lbl1.add(btnBack);
        btnBack.addActionListener(this);
        
        int iBalance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where sPin = '"+sPin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                	iBalance += Integer.parseInt(rs.getString("sAmount"));
                } else {
                	iBalance -= Integer.parseInt(rs.getString("sAmount"));
                }
            }
        }catch(Exception e){}
        
        
        lbl3.setText("$"+iBalance);
        
        setSize(880, 900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
        new Transactions(sCardno,sPin).setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Balance("","").setVisible(true);
	}

}
