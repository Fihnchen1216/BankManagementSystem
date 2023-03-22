package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
	
	JComboBox cmbReligion, cmbCategory, cmbIncome, cmbEducation, cmbOccupation;
	JTextField txtEaccount;
	JRadioButton radEaccountY, radEaccountN;
    String sFormno;
    JLabel lblFormnol1,lblFormnol2, lblAdditionalDetail,lblReligion,lblCategory,lblIncome,lblEducation,lblOccupation,lblEaccount;
    JButton btnNext;
    Signup2(String sFormno){
	
		
        this.sFormno = sFormno;

		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img3);
        lbl1.setBounds(150, 0, 100, 100);
        add(lbl1);
		
        lblFormnol1 = new JLabel("Form No:");
        lblFormnol1.setFont(new Font("Raleway", Font.BOLD, 13));
        lblFormnol1.setBounds(700,10,60,30);
	    add(lblFormnol1);
        
	    lblFormnol2 = new JLabel(sFormno);
	    lblFormnol2.setFont(new Font("Raleway", Font.BOLD, 13));
        lblFormnol2.setBounds(760,10,60,30);
        add(lblFormnol2);

		
		lblAdditionalDetail = new JLabel("Page 2: Additonal Details");
		lblAdditionalDetail.setFont(new Font("Raleway", Font.BOLD,22));
		lblAdditionalDetail.setBounds(290,80,400,30);
		add(lblAdditionalDetail);
		
		lblReligion = new JLabel("Religion:");
		lblReligion.setFont(new Font("Raleway", Font.BOLD,20));
		lblReligion.setBounds(100,140,200,30);
		add(lblReligion);
		
		String sReligion[] = {"", "Christianity", "Buddhism", "Hinduism", "Islam","Judaism","other"};
		cmbReligion = new JComboBox(sReligion);
		cmbReligion.setBackground(Color.WHITE);
		cmbReligion.setFont(new Font("Raleway", Font.BOLD,14));
		cmbReligion.setBounds(300,140,400,30);
		add(cmbReligion);
		
		lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Raleway", Font.BOLD,20));
		lblCategory.setBounds(100,190,200,30);
		add(lblCategory);
		
		String sCategory[] = {"A","B","C"};
		cmbCategory = new JComboBox(sCategory);
		cmbCategory.setBackground(Color.WHITE);
		cmbCategory.setFont(new Font("Raleway", Font.BOLD,14));
		cmbCategory.setBounds(300,190,400,30);
		add(cmbCategory);
		
		lblIncome = new JLabel("Income:");
		lblIncome.setFont(new Font("Raleway", Font.BOLD,20));
		lblIncome.setBounds(100,240,200,30);
		add(lblIncome);
		
		String sIncome[] = {"","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		cmbIncome = new JComboBox(sIncome);
		cmbIncome.setBackground(Color.WHITE);
		cmbIncome.setFont(new Font("Raleway", Font.BOLD,14));
		cmbIncome.setBounds(300,240,400,30);
		add(cmbIncome);
		
		lblEducation = new JLabel("Education:");
		lblEducation.setFont(new Font("Raleway", Font.BOLD,20));
		lblEducation.setBounds(100,290,200,30);
		add(lblEducation);
                
		String sEducation[] = {"", "Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		cmbEducation = new JComboBox(sEducation);
		cmbEducation.setBackground(Color.WHITE);
		cmbEducation.setFont(new Font("Raleway", Font.BOLD,14));
		cmbEducation.setBounds(300,290,400,30);
		add(cmbEducation);
                
		
		lblOccupation = new JLabel("Occupation:");
		lblOccupation.setFont(new Font("Raleway", Font.BOLD,20));
		lblOccupation.setBounds(100,340,200,30);
		add(lblOccupation);
		
        String sOccupation[] = {"", "Salaried","Self-Employmed","Business","Student","Retired","Others"};
        cmbOccupation = new JComboBox(sOccupation);
        cmbOccupation.setBackground(Color.WHITE);
        cmbOccupation.setFont(new Font("Raleway", Font.BOLD,14));
        cmbOccupation.setBounds(300,340,400,30);
		add(cmbOccupation);

		lblEaccount = new JLabel("Existing Account:");
		lblEaccount.setFont(new Font("Raleway", Font.BOLD,20));
		lblEaccount.setBounds(100,590,200,30);
		add(lblEaccount);
		
		radEaccountY = new JRadioButton("Yes");
		radEaccountY.setFont(new Font("Raleway", Font.BOLD, 14));
		radEaccountY.setBackground(Color.WHITE);
		radEaccountY.setBounds(350,590,100,30);
        add(radEaccountY);
     
        
        radEaccountN = new JRadioButton("No");
        radEaccountN.setFont(new Font("Raleway", Font.BOLD, 14));
        radEaccountN.setBackground(Color.WHITE);
        radEaccountN.setBounds(460,590,100,30);
        add(radEaccountN);
                
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
		String sReligion = (String)cmbReligion.getSelectedItem(); 
        String sCategory = (String)cmbCategory.getSelectedItem();
        String sIncome = (String)cmbIncome.getSelectedItem();
        String sEducation = (String)cmbEducation.getSelectedItem();
        String sOccupation = (String)cmbOccupation.getSelectedItem();
        String sEaccount = "";
        if(radEaccountY.isSelected()) {
        	sEaccount = "Yes";
        } else if(radEaccountN.isSelected()) {
        	sEaccount = "No";
        }
        
        try {
        	if(sEaccount.equals("")) {
        		JOptionPane.showMessageDialog(null, "Fill all the required fields");
        	} else {
        		Conn c1 = new Conn();
                String query = "insert into signup2 values('"+sFormno+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sEaccount+"')";
                c1.s.executeUpdate(query);
                
                new Signup3(sFormno).setVisible(true);
                setVisible(false);
        	}
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
	}
	public static void main(String[] args) {
		new Signup2("").setVisible(true);

	}
	

}

