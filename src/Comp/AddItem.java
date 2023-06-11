package Comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JDBC.JdbcConnectivity;

public class AddItem {
    private JFrame frame;
    private JTextField tf1, tf2, tf4, tf5, tf6, tf7;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    private JComboBox<String> jc1;
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
    public AddItem() {
    	
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 700);
        frame.setContentPane(new JLabel(new ImageIcon("add.jpg"))); // Set the background image
        frame.setLayout(null);
        frame.setTitle("Add Item");

        lb1 = createLabel("Enter Item Name:", 200, 120, 300, 40, 24);
        frame.add(lb1);

        tf1 = createTextField(520, 120, 200, 30, 18);
        frame.add(tf1);

        lb2 = createLabel("Enter Item Id:", 200, 180, 300, 40, 24);
        frame.add(lb2);

        tf2 = createTextField(520, 180, 200, 30, 18);
        frame.add(tf2);

        lb3 = createLabel("Portion Size:", 200, 240, 300, 40, 24);
        frame.add(lb3);

        String[] modes = { "-Select-", "half plate", "full plate", "one cup", "200ml","1/2 cup","large","small","mediun","etc","other"};
        jc1 = new JComboBox<>(modes);
        jc1.setBounds(520, 240, 200, 30);
        frame.add(jc1);

        lb4 = createLabel("Enter Discount:", 200, 300, 300, 40, 24);
        frame.add(lb4);

        tf4 = createTextField(520, 300, 200, 30, 18);
        frame.add(tf4);

        lb5 = createLabel("Enter Price:", 200, 360, 300, 40, 24);
        frame.add(lb5);

        tf5 = createTextField(520, 360, 200, 30, 18);
        frame.add(tf5);

        lb7 = createLabel("Enter Total Qty:", 200, 420, 300, 40, 24);
        frame.add(lb7);

        tf7 = createTextField(520, 420, 200, 30, 18);
        frame.add(tf7);

        JButton bt1 = createButton("Submit", 450, 550, 150, 50, new Color(52, 152, 219), Color.WHITE, 20);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String itmPortionSize = (String) jc1.getSelectedItem();
            	if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf5.getText().isEmpty()||tf4.getText().isEmpty() ||tf7.getText().isEmpty()) {
            		JOptionPane.showMessageDialog(frame, "Item added successfully", "ERROR",JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(itmPortionSize.equals("-Select-")){
            		JOptionPane.showMessageDialog(frame, "Please Slecct portion Size", "ERROR",JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		String itmName = tf1.getText();
                    
                    if(!checkAlphabate(itmName)) {
                    	JOptionPane.showMessageDialog(frame, "Enter item Name in alphabate", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(!checkNumeric(tf2.getText())){
                    	JOptionPane.showMessageDialog(frame, "Enter item id in digits", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(!checkNumeric(tf4.getText())){
                    	JOptionPane.showMessageDialog(frame, "Enter discount in percent", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(!checkNumeric(tf5.getText())){
                    	JOptionPane.showMessageDialog(frame, "Enter price in digits", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(!checkNumeric(tf7.getText())){
                    	JOptionPane.showMessageDialog(frame, "Enter Total qty in digits", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(Integer.parseInt(tf4.getText())<0 || Integer.parseInt(tf4.getText())>100) {
                    	JOptionPane.showMessageDialog(frame, "Discount between 0 to 100", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                    	int itmId = Integer.parseInt(tf2.getText());
                        int itmPrice = Integer.parseInt(tf5.getText());
                        int itmDiscount = Integer.parseInt(tf4.getText());
                        int totalQty= Integer.parseInt(tf7.getText());
                        JdbcConnectivity jc = new JdbcConnectivity();
                        int flag = jc.addItem(itmId, itmName, itmPortionSize, itmDiscount, itmPrice, totalQty);
                        if(flag==1) {
                        	JOptionPane.showMessageDialog(frame, "Item added successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                        	JOptionPane.showMessageDialog(frame, "This Product id already Available", "ERROR",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                   
            	}
                
                
            }
        });
        frame.add(bt1);

        JButton btnBack = createButton("Back", 20, 20, 150, 50, new Color(255, 128, 0), Color.WHITE, 20);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();//Close the current add item page
            }
        });

        frame.add(btnBack);
        frame.setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(Color.BLUE);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height, int fontSize) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height, Color bgColor, Color fgColor,
            int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return button;
    }
}