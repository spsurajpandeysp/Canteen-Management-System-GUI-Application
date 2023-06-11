package Comp;

import JDBC.JdbcConnectivity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddEmployee {
    private JFrame frame;
    private JTextField tf1, tf2, tf4, tf5, tf6, tf7;
    private JLabel lb1, lb2, lb4, lb5, lb6, lb7;
    static public boolean checkNumeric(String str) {
    	boolean flag = true;
    	for(int i=0;i<str.length();i++) {
    			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
    				flag = true;
    			}
    			else {
    				flag = false;
    				break;
    			}
    	}
    	return flag;
    }
    static public boolean checkAlphabate(String str) {
    	boolean flag = true;
    	for(int i=0;i<str.length();i++) {
    			if(str.charAt(i)>='a' && str.charAt(i)<='z' || str.charAt(i)>='A' && str.charAt(i)<='Z') {
    				flag = true;
    			}
    			else {
    				flag = false;
    				break;
    			}
    	}
    	return flag;
    }
    static public boolean checkValidPassword(String str) {
    	boolean flag1 = false;
    	boolean flag2 = false;
    	boolean flag3 = false;
    	boolean flag4 = false;
    	for(int i=0;i<str.length();i++) {
    			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
    				flag1 = true;
    			}
    			else if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
    				flag2 = true;
    			}
    			else if(str.charAt(i)>='0' && str.charAt(i)<='9') {
    				flag3 = true;
    			}	
    	}
    	Pattern pattern = Pattern.compile("[@_!#$%^&*()<>?/|}{~:]");
    	Matcher matcher = pattern.matcher(str);

    	if (matcher.find()) {
    		flag4=true;
    	}
    	if(!flag1 || !flag2 || !flag3 || !flag4) {
    		return false;
    	}
    	return true;
    }
    public AddEmployee() {
        initialize();
    }
    
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setTitle("Add Employee");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lb1 = createLabel("Enter Employee First Name:", 45, 120);
        frame.getContentPane().add(lb1);
        tf1 = createTextField(270, 120);
        frame.getContentPane().add(tf1);

        lb2 = createLabel("Enter Employee Last Name:", 500, 120);
        frame.getContentPane().add(lb2);
        tf2 = createTextField(745, 120);
        frame.getContentPane().add(tf2);

        lb4 = createLabel("Enter Employee ID:", 45, 220);
        frame.getContentPane().add(lb4);
        tf4 = createTextField(270, 220);
        frame.getContentPane().add(tf4);

        lb5 = createLabel("Enter Employee Phone Number:", 500, 220);
        frame.getContentPane().add(lb5);
        tf5 = createTextField(745, 220);
        frame.getContentPane().add(tf5);

        lb6 = createLabel("Enter Employee Email ID:", 45, 320);
        frame.getContentPane().add(lb6);
        tf6 = createTextField(270, 320);
        frame.getContentPane().add(tf6);

        lb7 = createLabel("Create Employee Password:", 500, 320);
        frame.getContentPane().add(lb7);
        tf7 = createTextField(745, 320);
        frame.getContentPane().add(tf7);

        JButton submitButton = createButton("Submit", 350, 450, 100, 40);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(tf4.getText().isEmpty()  || tf1.getText().isEmpty() || tf2.getText().isEmpty() ||tf5.getText().isEmpty() ||tf6.getText().isEmpty()|| tf7.getText().isEmpty()) {
            		JOptionPane.showMessageDialog(frame,"Please Enter All Details","Message",JOptionPane.WARNING_MESSAGE);
            	}
            	else {
            		
                    String firstName = tf1.getText();
                    String lastName = tf2.getText();
                   
                    String email = tf6.getText();
                    String password = tf7.getText();
    				if(!checkAlphabate(firstName) || !checkAlphabate(lastName)){
    					JOptionPane.showMessageDialog(frame,"Employee First Name and Last Name Not be Numeric","Message",JOptionPane.WARNING_MESSAGE);
    				}
    				else if(!checkNumeric(tf4.getText())) {
    					JOptionPane.showMessageDialog(frame,"Enter EMP ID in numeric","Message",JOptionPane.WARNING_MESSAGE);
    				}
    				else if(!checkNumeric(tf5.getText()) || tf5.getText().length()!=10){
    					JOptionPane.showMessageDialog(frame,"Phone msut be numeric and of 10 digit","Message",JOptionPane.WARNING_MESSAGE);
    				}
    				else if(email.length()<=9 || !email.substring(email.length()-9,email.length()).equals("gmail.com")) {
    					JOptionPane.showMessageDialog(frame,"Enter valid Email Id","Message",JOptionPane.WARNING_MESSAGE);
    				}
    				else if(password.length()<=7 || !checkValidPassword(password)) {
    					JOptionPane.showMessageDialog(frame,"Password should be minimun 8 character and upper ,lower case,numeric and spacial character","Message",JOptionPane.WARNING_MESSAGE);
    				}
    				else{
    					long phoneNumber = Long.parseLong(tf5.getText());
    					int ID = Integer.parseInt(tf4.getText());
    					JdbcConnectivity jd = new JdbcConnectivity();
        				int flag = jd.AddEmpDetails(ID, firstName, lastName, phoneNumber, email, password);
    					if(flag==1) {
        					JOptionPane.showMessageDialog(frame,"Employee Added Successfully","Message",JOptionPane.WARNING_MESSAGE);
        				}
        				else {
        					JOptionPane.showMessageDialog(frame,"This Employee already present","Message",JOptionPane.WARNING_MESSAGE);
        				}
    				}
            	}
            }
        });
        frame.getContentPane().add(submitButton);
        
        JButton backButton = createButton("Back", 20, 20, 80, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(backButton);
        frame.setVisible(true);
    }
    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 250, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLUE);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(59, 89, 182));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        return button;
    }
}