package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
	
	
	String sPin, sCardno;
	JPasswordField txt1,txt2;
    JButton btnChange,btnBack;                               
    JLabel lbl2,lbl3,lbl4;
	PinChange(String sCardno, String sPin){
		this.sPin = sPin;
    	this.sCardno =sCardno;
    	setLayout(null);
  	
    	ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(0, 0, 880, 900);
        add(lbl1);
        
        
        lbl2 = new JLabel("Change your PIN");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("System", Font.BOLD, 16));
        lbl2.setBounds(300,320,500,25);
        lbl1.add(lbl2);
        
        lbl3 = new JLabel("New PIN:");
        lbl3.setFont(new Font("System", Font.BOLD, 16));
        lbl3.setForeground(Color.BLACK);
        lbl3.setBounds(240,350,500,25);
        lbl1.add(lbl3);
        
        txt1 = new JPasswordField();
        txt1.setFont(new Font("Raleway", Font.BOLD, 25));
        txt1.setBounds(350,350,180,25);
        lbl1.add(txt1);
        
        lbl4 = new JLabel("Re-Enter New PIN:");
        lbl4.setFont(new Font("System", Font.BOLD, 16));
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(210,380,500,25);
        lbl1.add(lbl4);

        txt2 = new JPasswordField();
        txt2.setFont(new Font("Raleway", Font.BOLD, 25));
        txt2.setBounds(350,380,180,25);
        lbl1.add(txt2);
        
        btnChange = new JButton("CHANGE");
        btnChange.setBounds(390,460,140,20);
        lbl1.add(btnChange);
        btnChange.addActionListener(this);
        
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
		try{        
            String sNewpin = txt1.getText();
            String sRepin = txt2.getText();
            
            if(!sNewpin.equals(sRepin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==btnChange){
                if (txt1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (txt2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String q1 = "update bank set sPin = '"+sRepin+"' where sCardno = '"+sCardno+"' and sPin ='"+sPin+"'";
                String q2 = "update login set sPin = '"+sRepin+"' where sCardno = '"+sCardno+"' and sPin ='"+sPin+"'";
                String q3 = "update signup3 set sPin = '"+sRepin+"' where sCardno = '"+sCardno+"' and sPin ='"+sPin+"'";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(sCardno,sRepin).setVisible(true);
            
            }else if(ae.getSource()==btnBack){
                new Transactions(sCardno,sPin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("","").setVisible(true);
	}

}
