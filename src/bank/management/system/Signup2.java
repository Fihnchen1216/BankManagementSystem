package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
	
	JComboBox  cmbIncome, cmbEducation, cmbEmpStatus, cmbResidence,cmbSourceOfIncome;
	JRadioButton radY, radN;
    String sFormno;
    JLabel lblFormnol1,lblFormnol2, lblAdditionalDetail,lblIncome,lblEducation,lblEmpStatus,lblEaccount,lblUScitizen,lblResidence,lblSourceOfIncome;
    JButton btnNext;
    int applicationId;
    Signup2(int applicationId, String sFormno){
	
    	this.applicationId = applicationId;
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
		
		lblUScitizen = new JLabel("Are you a US Citizen?:");
		lblUScitizen.setFont(new Font("Raleway", Font.BOLD,20));
		lblUScitizen.setBounds(100,140,400,30);
		add(lblUScitizen);	
                
		radY = new JRadioButton("Yes");
		radY.setBounds(340,140,60,30);
		radY.setBackground(Color.WHITE);
        add(radY);
                
        radN = new JRadioButton("No");
        radN.setBounds(450,140,120,30);
        radN.setBackground(Color.WHITE);
        add(radN);

        ButtonGroup bgUScitizen = new ButtonGroup();
        bgUScitizen.add(radY);
        bgUScitizen.add(radN);
		
		lblResidence = new JLabel("Country of residence:");
		lblResidence.setFont(new Font("Raleway", Font.BOLD,20));
		lblResidence.setBounds(100,190,400,30);
		add(lblResidence);
		
		String countries[] = {"-- Country --", "United States", "Canada", "United Kingdom", "Australia", "China", "Japan"};
		cmbResidence = new JComboBox(countries);
		cmbResidence.setBackground(Color.WHITE);
		cmbResidence.setFont(new Font("Raleway", Font.BOLD,14));
		cmbResidence.setBounds(320,190,400,30);
		add(cmbResidence);
		
		
		lblEducation = new JLabel("Education:");
		lblEducation.setFont(new Font("Raleway", Font.BOLD,20));
		lblEducation.setBounds(100,240,200,30);
		add(lblEducation);
                
		String sEducation[] = {"-- Education --", "Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		cmbEducation = new JComboBox(sEducation);
		cmbEducation.setBackground(Color.WHITE);
		cmbEducation.setFont(new Font("Raleway", Font.BOLD,14));
		cmbEducation.setBounds(320,240,400,30);
		add(cmbEducation);
                
		
		lblEmpStatus = new JLabel("Employment Status:");
		lblEmpStatus.setFont(new Font("Raleway", Font.BOLD,20));
		lblEmpStatus.setBounds(100,290,200,30);
		add(lblEmpStatus);
		
        String EmpStatus[] = {"-- Employment Status --", "Employmed","Self-Employmed","Business","Student","Retired","Not employmed"};
        cmbEmpStatus = new JComboBox(EmpStatus);
        cmbEmpStatus.setBackground(Color.WHITE);
        cmbEmpStatus.setFont(new Font("Raleway", Font.BOLD,14));
        cmbEmpStatus.setBounds(320,290,400,30);
		add(cmbEmpStatus);

		lblIncome = new JLabel("Annual Income:");
		lblIncome.setFont(new Font("Raleway", Font.BOLD,20));
		lblIncome.setBounds(100,340,200,30);
		add(lblIncome);
		
		String income[] = {"-- Annual Income --","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		cmbIncome = new JComboBox(income);
		cmbIncome.setBackground(Color.WHITE);
		cmbIncome.setFont(new Font("Raleway", Font.BOLD,14));
		cmbIncome.setBounds(320,340,400,30);
		add(cmbIncome);
		
		lblSourceOfIncome = new JLabel("Source of income:");
		lblSourceOfIncome.setFont(new Font("Raleway", Font.BOLD,20));
		lblSourceOfIncome.setBounds(100,390,200,30);
		add(lblSourceOfIncome);
		
		String sourceOfIncome[] = {"-- Source of income --","Employment", "Business", "Investments", "Rental Property", "Other"};
		cmbSourceOfIncome = new JComboBox(sourceOfIncome);
		cmbSourceOfIncome.setBackground(Color.WHITE);
		cmbSourceOfIncome.setFont(new Font("Raleway", Font.BOLD,14));
		cmbSourceOfIncome.setBounds(320,390,400,30);
		add(cmbSourceOfIncome);
                
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
		String sUScitizen = "";
		if(radY.isSelected()) {
			sUScitizen = "Yes";
        } else if(radN.isSelected()) {
        	sUScitizen = "No";
        }
		String sResidence  = (String)cmbResidence.getSelectedItem();
		String sEducation = (String)cmbEducation.getSelectedItem();
		String sEmpStatus = (String)cmbEmpStatus.getSelectedItem();
        String sIncome = (String)cmbIncome.getSelectedItem();
        String sSourceOfIncome = (String)cmbSourceOfIncome.getSelectedItem();
        
        
        try {
        	if(sUScitizen.isEmpty() || sResidence.isEmpty() || sEducation.isEmpty() || sEmpStatus.isEmpty() || sIncome.isEmpty() || sSourceOfIncome.isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Fill all the required fields");
        	} else {
        		Conn c1 = new Conn();
                String query = "UPDATE application SET us_citizen = '"+sUScitizen+"', country_of_residence = '"+sResidence+"', education = '"+sEducation+"', employment_status = '"+sEmpStatus+"' ,annual_income = '"+sIncome+"',source_of_income = '"+sSourceOfIncome+"' "
                		+ "WHERE application_id = '"+applicationId+"'";
                PreparedStatement pstmt = c1.c.prepareStatement(query);
                pstmt.executeUpdate();
                
                new Signup3(applicationId,sFormno).setVisible(true);
                setVisible(false);
        	}
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
	}
	public static void main(String[] args) {
		new Signup2(0,"").setVisible(true);

	}
	

}

