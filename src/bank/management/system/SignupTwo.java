package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	
	JTextField fnameTextField, lnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField,pinTextField;
	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dateChooser;
	
	JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;
	
	SignupTwo(){
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		
		
		JLabel additionalDetails = new JLabel("Page 2: Additonal Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD,20));
		religion.setBounds(100,140,200,30);
		add(religion);
		
		String religions[] = {"A","B","C"};
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
		
		String incomes[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		incomeComboBox = new JComboBox(incomes);
		incomeComboBox.setBackground(Color.WHITE);
		incomeComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		incomeComboBox.setBounds(300,240,400,30);
		add(incomeComboBox);
		
		JLabel education = new JLabel("Education:");
		education.setFont(new Font("Raleway", Font.BOLD,20));
		education.setBounds(100,290,200,30);
		add(education);
                
		String educations[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		educationComboBox = new JComboBox(educations);
		educationComboBox.setBackground(Color.WHITE);
		educationComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		educationComboBox.setBounds(300,290,400,30);
		add(educationComboBox);
                
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD,20));
		occupation.setBounds(100,340,200,30);
		add(occupation);
		
        String occupations[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox(occupations);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setFont(new Font("Raleway", Font.BOLD,14));
        occupationComboBox.setBounds(300,340,400,30);
		add(occupationComboBox);
/*
		
		JLabel marital = new JLabel("Occupation:");
		marital.setFont(new Font("Raleway", Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
                
        
		
		JLabel address = new JLabel("PAN Number:");
		address.setFont(new Font("Raleway", Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		JLabel city = new JLabel("Aadhar Number:");
		city.setFont(new Font("Raleway", Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway", Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		JLabel pincode = new JLabel("Existing Account:");
		pincode.setFont(new Font("Raleway", Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTextField.setBounds(300,590,400,30);
		add(pinTextField);
		*/
                
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
		//String formno = ""+random;
		String fname = fnameTextField.getText();
		String lname = lnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		} else if(female.isSelected()){
			gender = "Female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital="Married";
		} else if (unmarried.isSelected()) {
			marital = "Unmarried";
		} else if (other.isSelected()) {
			marital = "other";
		}
		
		String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
       
        try {
        	if(fname.equals("")) {
        		JOptionPane.showMessageDialog(null, "Fill all the required fields");
        	} else {
        		Conn c = new Conn();
        		//String query = "insert into signup values('"+formno+"','"+fname+"','"+ lname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
        		//c.s.executeUpdate(query);
        	}
        } catch(Exception e) {
        	System.out.println(e);
        }
        
	}
	public static void main(String[] args) {
		new SignupTwo();

	}
	

}

