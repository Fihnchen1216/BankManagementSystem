package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;
import java.awt.event.*;
import java.sql.*;

public class Signup3 extends JFrame implements ActionListener {
	
	JLabel lblAccountDetail,lblAccountType,lblCardno1,lblCardno2,lblCardno3,lblCardno4,lblPincode,lblPincode2,lblPincode3,lblServiceRequire,lblFormno1,lblFormno2;
	String sFormno;
	JButton btnSubmit, btnCancel;
	JCheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7;
	JRadioButton rad1,rad2,rad3,rad4;
	int applicationId;
	Signup3(int applicationId, String formno){
		this.sFormno = formno;
		this.applicationId = applicationId;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		setLayout(null);
	
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(150, 0, 100, 100);
        add(lbl1);

		lblFormno1 = new JLabel("Form No:");
		lblFormno1.setFont(new Font("Raleway", Font.BOLD, 14));
		lblFormno1.setBounds(700,10,70,30);
        add(lblFormno1);
        
		lblFormno2 = new JLabel(formno);
		lblFormno2.setFont(new Font("Raleway", Font.BOLD, 14));
		lblFormno2.setBounds(770,10,40,30);
	    add(lblFormno2);
	    
		lblAccountDetail = new JLabel("Page 3: Account Details");
		lblAccountDetail.setFont(new Font("Raleway", Font.BOLD, 22));
		lblAccountDetail.setBounds(280,40,400,40);
	    add(lblAccountDetail); 
	        
		lblAccountType = new JLabel("Account Type:");
		lblAccountType.setFont(new Font("Raleway", Font.BOLD, 18));
		lblAccountType.setBounds(100,140,200,30);
        add(lblAccountType);
        
        rad1 = new JRadioButton("Saving Account");
	    rad1.setFont(new Font("Raleway", Font.BOLD, 16));
	    rad1.setBackground(Color.WHITE);
	    rad1.setBounds(100,180,150,30);
        add(rad1);
        
	    rad2 = new JRadioButton("Checking Account");
	    rad2.setFont(new Font("Raleway", Font.BOLD, 16));
	    rad2.setBackground(Color.WHITE);
	    rad2.setBounds(350,180,300,30);
        add(rad2);
        
	    rad3 = new JRadioButton("Joint Account");
	    rad3.setFont(new Font("Raleway", Font.BOLD, 16));
	    rad3.setBackground(Color.WHITE);
	    rad3.setBounds(100,220,250,30);
        add(rad3);
        
	    rad4 = new JRadioButton("Certificate of Deposit (CD)");
	    rad4.setFont(new Font("Raleway", Font.BOLD, 16));
	    rad4.setBackground(Color.WHITE);
	    rad4.setBounds(350,220,250,30);
        add(rad4);    
        
	    ButtonGroup btng = new ButtonGroup();
	    btng.add(rad1);
	    btng.add(rad2);
	    btng.add(rad3);
	    btng.add(rad4);
        
		lblCardno1 = new JLabel("Card Number:");
		lblCardno1.setFont(new Font("Raleway", Font.BOLD, 18));
		lblCardno1.setBounds(100,320,200,30);
        add(lblCardno1);
        
		lblCardno2 = new JLabel("XXXX-XXXX-XXXX-1234");
		lblCardno2.setFont(new Font("Raleway", Font.BOLD, 18));
		lblCardno2.setBounds(330,320,250,30);
        add(lblCardno2);
        
		lblCardno3 = new JLabel("(Your 16-digit Card number)");
		lblCardno3.setFont(new Font("Raleway", Font.BOLD, 12));
		lblCardno3.setBounds(100,350,200,20);
        add(lblCardno3);
        
		lblCardno4 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
		lblCardno4.setFont(new Font("Raleway", Font.BOLD, 12));
		lblCardno4.setBounds(330,350,500,20);
        add(lblCardno4);
        
		lblPincode = new JLabel("PIN:");
		lblPincode.setFont(new Font("Raleway", Font.BOLD, 18));
		lblPincode.setBounds(100,390,200,30);
        add(lblPincode);
        
		lblPincode2 = new JLabel("XXXX");
		lblPincode2.setFont(new Font("Raleway", Font.BOLD, 18));
		lblPincode2.setBounds(330,390,200,30);
        add(lblPincode2);
        
		lblPincode3 = new JLabel("(4-digit password)");
		lblPincode3.setFont(new Font("Raleway", Font.BOLD, 12));
		lblPincode3.setBounds(100,420,200,20);
        add(lblPincode3);
        
        
	    chk7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
	    chk7.setBackground(Color.WHITE);
	    chk7.setFont(new Font("Raleway", Font.BOLD, 12));
	    chk7.setBounds(100,630,600,20);
        add(chk7);
	    
	    
	        
	    btnSubmit = new JButton("Submit");
	    btnSubmit.setFont(new Font("Raleway", Font.BOLD, 14));
	    btnSubmit.setBackground(Color.BLACK);
	    btnSubmit.setForeground(Color.WHITE);
	    btnSubmit.setBounds(250,720,100,30);
	    btnSubmit.addActionListener(this);
       
        add(btnSubmit);
        
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFont(new Font("Raleway", Font.BOLD, 14));
	    btnCancel.setBackground(Color.BLACK);
	    btnCancel.setForeground(Color.WHITE);
	    btnCancel.setBounds(420,720,100,30); 
	    btnCancel.addActionListener(this);
        add(btnCancel);
	    
	    getContentPane().setBackground(Color.WHITE);
        
	    setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
       
	}
	
	public void actionPerformed(ActionEvent ae) {
		String sAccountType="";
		if(rad1.isSelected()) {
			sAccountType = "Saving account";
		} else if(rad2.isSelected()) {
			sAccountType = "Checking Account";
		} else if(rad3.isSelected()) {
			sAccountType = "Joint Account";
		} else if(rad4.isSelected()) {
			sAccountType = "Certificate of Deposit (CD)";
		}
		
		
		Random ran = new Random();
        long lCardno = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String sCardno = "" + Math.abs(lCardno);
        
        long lPin = (ran.nextLong() % 9000L) + 1000L;
        String sPin = "" + Math.abs(lPin);
        
        
        try {
        	 if(ae.getSource()== btnSubmit){
        		 if(sAccountType.equals("")){
                     JOptionPane.showMessageDialog(null, "Fill all the required fields");
                 }else{
                	 Timestamp date = new Timestamp(System.currentTimeMillis());
                     Conn c1 = new Conn();
                     String query1 = "UPDATE application SET account_type = '"+sAccountType+"', application_date = '"+date+"' "
                     		+ "WHERE application_id = '"+applicationId+"'";
                     PreparedStatement pstmt1 = c1.c.prepareStatement(query1);
                     pstmt1.executeUpdate();
                     
                     
                     String query2 = "insert into login (form_no, card_no, pin, application_id) values('"+sFormno+"','"+sCardno+"','"+sPin+"','"+applicationId+"')";
                     PreparedStatement pstmt2 = c1.c.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
                     pstmt2.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Card Number: " + sCardno + "\n Pin:"+ sPin);
                     
                     ResultSet generatedKeys = pstmt2.getGeneratedKeys();
                     if (generatedKeys.next()) {
                         int customerId = generatedKeys.getInt(1);
                         //System.out.println("Generated primary key for new customer: " + customerId);
                         setVisible(false);
                         new Transactions(sCardno,sPin,customerId).setVisible(true);                        
                     } else {
                         throw new SQLException("no ID obtained.");
                     }
                     
                 }
        	 }
        	 else if(ae.getSource() == btnCancel) {
        		 System.exit(0);
        	 }
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	public static void main(String[] args) {
		new Signup3(0,"").setVisible(true);
	}
	
	
}
