package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

	String sPin,sCardno;
	JLabel lbl2, l2;
	JButton btn100, btn200, btn300, btn400, btn500, btn600, btnBack;
	JTextField txt1;
	
	FastCash(String sCardno,String sPin){
		this.sPin = sPin;
    	this.sCardno = sCardno;
    	setLayout(null);
  	
    	ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(0, 0, 880, 900);
        add(lbl1);
        
        
        lbl2 = new JLabel("SELECT WITHDRAWL AMOUNT");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("System", Font.BOLD, 16));
        lbl2.setBounds(250,340,500,25);
        lbl1.add(lbl2);
        
        btn100 = new JButton("$100");
        btn100.setBounds(210,410,140,20);
        lbl1.add(btn100);
        btn100.addActionListener(this);
        
        btn200 = new JButton("$200");
        btn200.setBounds(390,410,140,20);
        lbl1.add(btn200);
        btn200.addActionListener(this);
        
        btn300 = new JButton("$300");
        btn300.setBounds(210,435,140,20);
        lbl1.add(btn300);
        btn300.addActionListener(this);

        btn400 = new JButton("$400");
        btn400.setBounds(390,435,140,20);
        lbl1.add(btn400);
        btn400.addActionListener(this);
        
        btn500 = new JButton("$500");
        btn500.setBounds(210,460,140,20);
        lbl1.add(btn500);
        btn500.addActionListener(this);
        
        btn600 = new JButton("$600");
        btn600.setBounds(390,460,140,20);
        lbl1.add(btn600);
        btn600.addActionListener(this);
        
        btnBack = new JButton("BACK");
        btnBack.setBounds(390,485,140,20);
        lbl1.add(btnBack);
        btnBack.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);

     
        setSize(880, 900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
       
        
	}
	public void actionPerformed(ActionEvent ae) {
		try {
            String sAmount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where sPin = '"+sPin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("sAmount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("sAmount"));
                }
            } 
            
            if (ae.getSource() != btnBack && balance < Integer.parseInt(sAmount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == btnBack) {
                this.setVisible(false);
                new Transactions(sCardno,sPin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+sCardno+"','"+sPin+"', '"+date+"', 'Withdrawl', '"+sAmount+"')");
                JOptionPane.showMessageDialog(null, "$"+sAmount+" Withdrwal Successfully");
                    
                setVisible(false);
                new Transactions(sCardno,sPin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("","").setVisible(true);
	}

}
