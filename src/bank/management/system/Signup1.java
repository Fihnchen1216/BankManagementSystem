package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;
import java.awt.event.*;


public class Signup1 extends JFrame implements ActionListener{
	
	JLabel lblFormno,lblPersonalDetail, lblFname, lblLname,lblDOB,lblGender,lblEmail, lblMarital, lblAddress,lblCity,lblState,lblPin;
	JTextField txtFname, txtLname, txtEmail, txtAddress, txtCity, txtState, txtPin;
	JButton btnNext;
	JRadioButton radMale, radFemale, radOther, radMarried, radUnmarried;
	JDateChooser dcDOB;
	Random ran = new Random();
	long lRandom = Math.abs((ran.nextLong() % 9000L) + 1000L);
	String sRandom = "" + lRandom;
	
	Signup1(){
		
		setTitle("NEW ACCOUNT APPLICATION FORM");
		setLayout(null);
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(20, 0, 100, 100);
        add(lbl1);
		
		lblFormno = new JLabel("APPLICATION FORM NO. " + sRandom); 
		lblFormno.setFont(new Font("Raleway", Font.BOLD, 38));
		lblFormno.setBounds(140,20,600,40);
		add(lblFormno);
		
		lblPersonalDetail = new JLabel("Page 1: Personal Detals");
		lblPersonalDetail.setFont(new Font("Raleway", Font.BOLD,22));
		lblPersonalDetail.setBounds(290,80,400,30);
		add(lblPersonalDetail);
		
		lblFname = new JLabel("First Name:");
		lblFname.setFont(new Font("Raleway", Font.BOLD,20));
		lblFname.setBounds(100,140,200,30);
		add(lblFname);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Raleway", Font.BOLD, 14));
		txtFname.setBounds(300,140,400,30);
		add(txtFname);
		
		lblLname = new JLabel("Last Name:");
		lblLname.setFont(new Font("Raleway", Font.BOLD,20));
		lblLname.setBounds(100,190,200,30);
		add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Raleway", Font.BOLD, 14));
		txtLname.setBounds(300,190,400,30);
		add(txtLname);
		
		lblDOB = new JLabel("Date of Birth:");
		lblDOB.setFont(new Font("Raleway", Font.BOLD,20));
		lblDOB.setBounds(100,240,200,30);
		add(lblDOB);
		
		dcDOB = new JDateChooser();
		dcDOB.setBounds(300,240,400,30);
		dcDOB.setForeground(new Color(105,105,105));
		add(dcDOB);
		
		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Raleway", Font.BOLD,20));
		lblGender.setBounds(100,290,200,30);
		add(lblGender);
                
		radMale = new JRadioButton("Male");
		radMale.setBounds(300,290,60,30);
		radMale.setBackground(Color.WHITE);
        add(radMale);
                
        radFemale = new JRadioButton("Female");
        radFemale.setBounds(450,290,120,30);
        radFemale.setBackground(Color.WHITE);
        add(radFemale);

        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(radMale);
        bgGender.add(radFemale);
                
		
		lblEmail = new JLabel("Email Address:");
		lblEmail.setFont(new Font("Raleway", Font.BOLD,20));
		lblEmail.setBounds(100,340,200,30);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Raleway", Font.BOLD, 14));
		txtEmail.setBounds(300,340,400,30);
		add(txtEmail);
		
		lblMarital = new JLabel("Marital Status:");
		lblMarital.setFont(new Font("Raleway", Font.BOLD,20));
		lblMarital.setBounds(100,390,200,30);
		add(lblMarital);
                
        radMarried = new JRadioButton("Married");
        radMarried.setBounds(300,390,100,30);
        radMarried.setBackground(Color.WHITE);
        add(radMarried);
                
        radUnmarried = new JRadioButton("Unmarried");
        radUnmarried.setBounds(450,390,100,30);
        radUnmarried.setBackground(Color.WHITE);
        add(radUnmarried);
                
        radOther = new JRadioButton("Other");
        radOther.setBounds(630,390,100,30);
        radOther.setBackground(Color.WHITE);
        add(radOther);
                
        ButtonGroup bgMarital = new ButtonGroup();
        bgMarital.add(radMarried);
        bgMarital.add(radUnmarried);
        bgMarital.add(radOther);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Raleway", Font.BOLD,20));
		lblAddress.setBounds(100,440,200,30);
		add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Raleway", Font.BOLD, 14));
		txtAddress.setBounds(300,440,400,30);
		add(txtAddress);
		
		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Raleway", Font.BOLD,20));
		lblCity.setBounds(100,490,200,30);
		add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Raleway", Font.BOLD, 14));
		txtCity.setBounds(300,490,400,30);
		add(txtCity);
		
		lblState = new JLabel("State:");
		lblState.setFont(new Font("Raleway", Font.BOLD,20));
		lblState.setBounds(100,540,200,30);
		add(lblState);
		
		txtState = new JTextField();
		txtState.setFont(new Font("Raleway", Font.BOLD, 14));
		txtState.setBounds(300,540,400,30);
		add(txtState);
		
		lblPin = new JLabel("PIN code:");
		lblPin.setFont(new Font("Raleway", Font.BOLD,20));
		lblPin.setBounds(100,590,200,30);
		add(lblPin);
		
		txtPin = new JTextField();
		txtPin.setFont(new Font("Raleway", Font.BOLD, 14));
		txtPin.setBounds(300,590,400,30);
		add(txtPin);
                
		btnNext = new JButton("Next");
		btnNext.setBackground(Color.BLACK);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Raleway", Font.BOLD,14));
		btnNext.setBounds(620,660,80,30);
		btnNext.addActionListener(this);
        add(btnNext);
                
       getContentPane().setBackground(Color.WHITE);
		
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String sFormno = sRandom;
		String sFname = txtFname.getText();
		String sLname = txtLname.getText();
		String sDOB = ((JTextField) dcDOB.getDateEditor().getUiComponent()).getText();
		String sGender = null;
		if(radMale.isSelected()) {
			sGender = "Male";
		} else if(radFemale.isSelected()){
			sGender = "Female";
		}
		String sEmail = txtEmail.getText();
		String sMarital = null;
		if(radMarried.isSelected()) {
			sMarital="Married";
		} else if (radUnmarried.isSelected()) {
			sMarital = "Unmarried";
		} else if (radOther.isSelected()) {
			sMarital = "other";
		}
		
		String sAddress = txtAddress.getText();
        String sCity = txtCity.getText();
        String sState = txtState.getText();
        String sPin = txtPin.getText();
       
        try {
        	if(sFname.equals("")) {
        		JOptionPane.showMessageDialog(null, "Fill all the required fields");
        	} else {
        		Conn c = new Conn();
        		String query = "insert into signup1 values('"+sFormno+"','"+sFname+"','"+ sLname+"','"+sDOB+"','"+sGender+"','"+sEmail+"','"+sMarital+"','"+sAddress+"','"+sCity+"','"+sState+"','"+sPin+"')";
        		c.s.executeUpdate(query);
        		
        		new Signup2(sRandom).setVisible(true);
                setVisible(false);
        	}
        } catch(Exception e) {
        	System.out.println(e);
        }
        
	}
	public static void main(String[] args) {
		new Signup1().setVisible(true);
	}
	

}

