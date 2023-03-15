package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
	
	
	JButton next;
	JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;
	JTextField eaccountTextField;
	JRadioButton eaccountY, eaccountN;
    String formno;
    JLabel formnol1,formnol2;
    Signup2(String formno){
		
		
        this.formno = formno;

		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
		
		formnol1 = new JLabel("Form No:");
		formnol1.setFont(new Font("Raleway", Font.BOLD, 13));
		formnol1.setBounds(700,10,60,30);
	    add(formnol1);
        
        formnol2 = new JLabel(formno);
        formnol2.setFont(new Font("Raleway", Font.BOLD, 13));
        formnol2.setBounds(760,10,60,30);
        add(formnol2);

		
		JLabel additionalDetails = new JLabel("Page 2: Additonal Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD,20));
		religion.setBounds(100,140,200,30);
		add(religion);
		
		String religions[] = {"", "Christianity", "Buddhism", "Hinduism", "Islam","Judaism","other"};
		religionComboBox = new JComboBox(religions);
		religionComboBox.setBackground(Color.WHITE);
		religionComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		religionComboBox.setBounds(300,140,400,30);
		add(religionComboBox);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD,20));
		category.setBounds(100,190,200,30);
		add(category);
		
		String categories[] = {"A","B","C"};
		categoryComboBox = new JComboBox(categories);
		categoryComboBox.setBackground(Color.WHITE);
		categoryComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		categoryComboBox.setBounds(300,190,400,30);
		add(categoryComboBox);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD,20));
		income.setBounds(100,240,200,30);
		add(income);
		
		String incomes[] = {"","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		incomeComboBox = new JComboBox(incomes);
		incomeComboBox.setBackground(Color.WHITE);
		incomeComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		incomeComboBox.setBounds(300,240,400,30);
		add(incomeComboBox);
		
		JLabel education = new JLabel("Education:");
		education.setFont(new Font("Raleway", Font.BOLD,20));
		education.setBounds(100,290,200,30);
		add(education);
                
		String educations[] = {"", "Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		educationComboBox = new JComboBox(educations);
		educationComboBox.setBackground(Color.WHITE);
		educationComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		educationComboBox.setBounds(300,290,400,30);
		add(educationComboBox);
                
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD,20));
		occupation.setBounds(100,340,200,30);
		add(occupation);
		
        String occupations[] = {"", "Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox(occupations);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setFont(new Font("Raleway", Font.BOLD,14));
        occupationComboBox.setBounds(300,340,400,30);
		add(occupationComboBox);

		JLabel eaccount = new JLabel("Existing Account:");
		eaccount.setFont(new Font("Raleway", Font.BOLD,20));
		eaccount.setBounds(100,590,200,30);
		add(eaccount);
		
		eaccountY = new JRadioButton("Yes");
		eaccountY.setFont(new Font("Raleway", Font.BOLD, 14));
		eaccountY.setBackground(Color.WHITE);
		eaccountY.setBounds(350,590,100,30);
        add(eaccountY);
     
        
        eaccountN = new JRadioButton("No");
        eaccountN.setFont(new Font("Raleway", Font.BOLD, 14));
        eaccountN.setBackground(Color.WHITE);
        eaccountN.setBounds(460,590,100,30);
        add(eaccountN);
                
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
	   next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway", Font.BOLD,14));
       next.setBounds(620,660,80,30);
       next.addActionListener(this);
       add(next);
                
       getContentPane().setBackground(Color.WHITE);
		
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String religion = (String)religionComboBox.getSelectedItem(); 
        String category = (String)categoryComboBox.getSelectedItem();
        String income = (String)incomeComboBox.getSelectedItem();
        String education = (String)educationComboBox.getSelectedItem();
        String occupation = (String)occupationComboBox.getSelectedItem();
        String eaccount = "";
        if(eaccountY.isSelected()) {
        	eaccount = "Yes";
        } else if(eaccountN.isSelected()) {
        	eaccount = "No";
        }
        
        try {
        	if(eaccount.equals("")) {
        		JOptionPane.showMessageDialog(null, "Fill all the required fields");
        	} else {
        		Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+eaccount+"')";
                c.s.executeUpdate(query);
                
                new Signup3(formno).setVisible(true);
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

