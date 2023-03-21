//package bank.management.system;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.util.*;
//
//public class Balance extends JFrame implements ActionListener{
//
//	String sPin;
//	Balance(String sPin){
//		this.sPin = sPin;
//    	
//    	setLayout(null);
//  	
//    	ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
//        Image img2 = img1.getImage().getScaledInstance(880,900, Image.SCALE_DEFAULT);
//        ImageIcon img3 = new ImageIcon(img2);
//        JLabel lbl1 = new JLabel(img3);
//        lbl1.setBounds(0, 0, 880, 900);
//        add(lbl1);
//        
//        
//        lbl2 = new JLabel("Enter amount you want to deposit");
//        lbl2.setForeground(Color.BLACK);
//        lbl2.setFont(new Font("System", Font.BOLD, 16));
//        lbl2.setBounds(250,340,500,25);
//        lbl1.add(lbl2);
//	}
//	public void actionPerformed(ActionEvent ae) {
//		
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new Balance("").setVisible(true);
//	}
//
//}
