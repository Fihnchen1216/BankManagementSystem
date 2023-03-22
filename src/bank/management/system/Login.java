package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    
	JLabel lblWelcome, lblCardno,lblPin;
    JButton btnLogin, btnSignup, btnClear;
	JTextField txtCard;
	JPasswordField pfPin;
	
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
		Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel lbl1 = new JLabel(img3);
		lbl1.setBounds(70,10,100,100);
		add(lbl1);
		
		lblWelcome = new JLabel("Welcome to ATM");	
		lblWelcome.setFont(new Font("Osward", Font.BOLD, 38));
		lblWelcome.setBounds(200,40,400,40);
		add(lblWelcome);
		
		lblCardno = new JLabel("Card No:");
		lblCardno.setFont(new Font("Raleway", Font.BOLD, 28));
		lblCardno.setBounds(120,150,150,40);
		add(lblCardno);
		
		txtCard = new JTextField(15);
		txtCard.setBounds(300,150,230,30);
		txtCard.setFont(new Font("Arial", Font.BOLD, 14));
		add(txtCard);
		
		lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Raleway", Font.BOLD, 28));
		lblPin.setBounds(120,220,250,30);
		add(lblPin);
		
		pfPin = new JPasswordField(15);
		pfPin.setBounds(300,220,230,30);
		pfPin.setFont(new Font("Arial", Font.BOLD, 14));
		add(pfPin);
		
		btnLogin = new JButton("Sign in");
		btnLogin.setBounds(300,300,100,30);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(this);
		add(btnLogin);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(430,300,100,30);
		btnClear.setBackground(Color.BLACK);
		btnClear.setForeground(Color.WHITE);
		btnClear.addActionListener(this);
		add(btnClear);
		
		btnSignup = new JButton("Sign up");
		btnSignup.setBounds(300,350,230,30);
		btnSignup.setBackground(Color.BLACK);
		btnSignup.setForeground(Color.WHITE);
		btnSignup.addActionListener(this);
		add(btnSignup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setLocation(350,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == btnClear) {
				txtCard.setText("");
				pfPin.setText("");
			}
			else if(ae.getSource() == btnLogin) {
				Conn c1 = new Conn();
	            String sCardno  = txtCard.getText();
	            String sPin  = pfPin.getText();
	            String query  = "select * from login where sCardno = '"+sCardno+"' and sPin = '"+sPin+"'";

	            ResultSet rs = c1.s.executeQuery(query);
	            if(rs.next()){
                    setVisible(false);
                    new Transactions(sCardno,sPin).setVisible(true);

	            } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
			}
			else if(ae.getSource() == btnSignup) {
				setVisible(false);
				new Signup1().setVisible(true);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
        new Login().setVisible(true);

	}

}
