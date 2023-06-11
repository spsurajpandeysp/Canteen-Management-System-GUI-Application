package Comp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import JDBC.JdbcConnectivity;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ModifyItemsDetails {
    JFrame frame;
    JTextField tf1, tf2, tf3, tf4,tf5;
    JToggleButton addStockToggle, modifyPortionToggle, modifyPriceToggle,modifyDiscountToggle,modifyIdToggle;
    JComboBox jc1;
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
    public ModifyItemsDetails() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setLayout(null);
        frame.setTitle("Modify Item Details");
        
        ImageIcon backgroundImageIcon = new ImageIcon("add.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
        ((JPanel) frame.getContentPane()).setOpaque(false);

        addStockToggle = new JToggleButton("Add Stock");
        addStockToggle.setBounds(200, 150, 200, 50);
        addStockToggle.setFont(new Font("Arial", Font.BOLD, 16));
        addStockToggle.setForeground(Color.WHITE);
        addStockToggle.setBackground(new Color(52, 152, 219));
        frame.add(addStockToggle);

        tf1 = new JTextField();
        tf1.setBounds(400, 150, 120, 50);
        frame.add(tf1);

        modifyPriceToggle = new JToggleButton("Modify Price");
        modifyPriceToggle.setBounds(200, 200, 200, 50);
        modifyPriceToggle.setFont(new Font("Arial", Font.BOLD, 16));
        modifyPriceToggle.setForeground(Color.WHITE);
        modifyPriceToggle.setBackground(new Color(52, 152, 219));
        frame.add(modifyPriceToggle);

        tf2 = new JTextField();
        tf2.setBounds(400, 200, 120, 50);
        frame.add(tf2);

        modifyDiscountToggle = new JToggleButton("Modify Discount");
        modifyDiscountToggle.setBounds(200, 250, 200, 50);
        modifyDiscountToggle.setFont(new Font("Arial", Font.BOLD, 16));
        modifyDiscountToggle.setForeground(Color.WHITE);
        modifyDiscountToggle.setBackground(new Color(52, 152, 219));
        frame.add(modifyDiscountToggle);
        
        

        tf3 = new JTextField();
        tf3.setBounds(400, 250, 120, 50);
        frame.add(tf3);
        modifyPortionToggle = new JToggleButton("Modify Portion Size");
        modifyPortionToggle.setBounds(200, 300, 200, 50);
        modifyPortionToggle.setFont(new Font("Arial", Font.BOLD, 16));
        modifyPortionToggle.setForeground(Color.WHITE);
        modifyPortionToggle.setBackground(new Color(52, 152, 219));
        frame.add(modifyPortionToggle);
        String []mode1 = {"-SELECT-","half plate", "full plate", "one cup", "200ml","1/2 cup","large","small","mediun","other"};
        
        JComboBox jc1 = new JComboBox(mode1);
        jc1.setBounds(400, 300, 120, 50);
        frame.add(jc1);
        
        JLabel jl5 = new JLabel("Select Portion Size:");
        jl5.setBounds(500, 80, 200, 30);
        jl5.setFont(new Font("Arial", Font.BOLD, 16));
        jl5.setForeground(Color.BLUE);
        frame.add(jl5);
        
        String []mode2 = {"-SELECT-", "half plate", "full plate", "one cup", "200ml","1/2 cup","large","small","mediun","other"};
        JComboBox jc2 = new JComboBox(mode2);
        jc2.setBounds(650, 80, 150, 30);
        frame.add(jc2);
        
        modifyIdToggle = new JToggleButton("Modify  Product Id");
        modifyIdToggle.setBounds(200, 350, 200, 50);
        modifyIdToggle.setFont(new Font("Arial", Font.BOLD, 16));
        modifyIdToggle.setForeground(Color.WHITE);
        modifyIdToggle.setBackground(new Color(52, 152, 219));
        frame.add(modifyIdToggle);
        
        tf5 = new JTextField();
        tf5.setBounds(400, 350, 120, 50);
        frame.add(tf5);

        JLabel jl1 = new JLabel("Enter Product Name:");
        jl1.setBounds(150, 80, 200, 30);
        jl1.setFont(new Font("Arial", Font.BOLD, 16));
        jl1.setForeground(Color.BLUE);
        frame.add(jl1);
        
        tf4 = new JTextField();
        tf4.setBounds(320, 80, 150, 30);
        frame.add(tf4);
        JButton bt1 = createButton("Submit", 300, 420, 120, 40, new Color(46, 204, 113), Color.WHITE, 20);
        frame.add(bt1);
        


        JButton btnBack = createButton("Back", 20, 20, 150, 50, new Color(255, 128, 0), Color.WHITE, 20);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current add item page
            }
        });

        frame.add(btnBack);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String selectedPortionSize = (String)jc2.getSelectedItem();
            	if(tf4.getText().isEmpty()) {
            		JOptionPane.showMessageDialog(frame, "Enter Product Name!");
            	}
            	else if(selectedPortionSize.equals("-SELECT-")){
        			JOptionPane.showMessageDialog(frame, "Please Select portion Size!");
            	}
            	else if(!checkAlphabate(tf4.getText())) {
            		JOptionPane.showMessageDialog(frame, "Enter product name in Alphabate!");
            	}
        		else {
        			String productName = tf4.getText();
        			JdbcConnectivity MyJd = new JdbcConnectivity();
        			int count = MyJd.CheckAvailableInStockOrNot(productName,selectedPortionSize);
        			if(count==0) {
        				JOptionPane.showMessageDialog(frame, "This Product Not Available!");
        			}
        			else {
        				boolean a=true,b=true,c=true,d=true,f=true;
                        int flag1 = 1,flag2 = 1,flag3 =1 ,flag4 = 1,flag5=1,flag6=1;
                        if (addStockToggle.isSelected()) {
                            if (tf1.getText().isEmpty()) {
                                a=false;
                                JOptionPane.showMessageDialog(frame, "Enter QTY:");
                            }
                            else if(!checkNumeric(tf1.getText())){
                            	a=false;
                            	JOptionPane.showMessageDialog(frame, "Enter QTY in numeric:");
                            }
                        }
                        if (modifyPriceToggle.isSelected()) {
                            if (tf2.getText().isEmpty()) {
                                b=false;
                                JOptionPane.showMessageDialog(frame, "Enter price:");
                            }
                            else if(!checkNumeric(tf2.getText())){
                            	b=false;
                            	JOptionPane.showMessageDialog(frame, "Enter Price in numeric:");
                            }
                        }
                        if (modifyDiscountToggle.isSelected()) {
                            String discountText = tf3.getText();
                            if (tf3.getText().isEmpty()) {
                                c=false;
                                JOptionPane.showMessageDialog(frame, "Enter Discount in percent:");
                            }
                            else if(!checkNumeric(tf3.getText())){
                            	c=false;
                            	JOptionPane.showMessageDialog(frame, "Enter Discunt in numeric:");
                            }
                        }
                        if(modifyIdToggle.isSelected()) {
                        	
                        	if (tf5.getText().isEmpty()) {
                                d=false;
                                JOptionPane.showMessageDialog(frame, "Enter Product Id:");
                            }
                            else if(!checkNumeric(tf5.getText())){
                            	d=false;
                            	JOptionPane.showMessageDialog(frame, "Enter Product Id in numeric:");
                            }
                            else {
                            	JdbcConnectivity jdc = new JdbcConnectivity();
                            	int flag = jdc.checkProductIdPresent(Integer.parseInt(tf5.getText()));
                            	if(flag==1) {
                            		JOptionPane.showMessageDialog(frame, "This Id Already Present:");
                            		d=false;
                            	}
                            }
                        }
                        if(modifyPortionToggle.isSelected()) {
                        	String mode = (String) jc1.getSelectedItem();
                        	if (mode.equals("-SELECT-")) {
                        		f = false;
                        		JOptionPane.showMessageDialog(frame, "Please Select Portion Size df:");
                            }
                        }
                        if(a && b && c && d && f) {
                        	boolean flag8 = false;
                        	JdbcConnectivity MyJdbc = new JdbcConnectivity();
                        	if (addStockToggle.isSelected()) {
                                String addStockText = tf1.getText();
                                int addStock = Integer.parseInt(addStockText);
                                flag1 = MyJdbc.UpdateTotalStock(productName, selectedPortionSize,addStock);
                                flag8 = true;
                            }

                            if (modifyPriceToggle.isSelected()) {
                                int MRP = Integer.parseInt(tf2.getText());
                                flag2 = MyJdbc.UpdateMRP(productName,selectedPortionSize,MRP);
                                flag8 = true;
                            }

                            if (modifyDiscountToggle.isSelected()) {
                                int discount = Integer.parseInt(tf3.getText());
                                flag3 =MyJdbc.UpdateDiscount(productName, selectedPortionSize,discount);
                                flag8 = true;
                            }
                            if(modifyIdToggle.isSelected()) {
                            	int id = Integer.parseInt(tf5.getText());
                            	flag4 =MyJdbc.updateProductId(productName, selectedPortionSize,id);
                            	flag8 = true;
                            }
                            if(modifyPortionToggle.isSelected()) {
                            	String mode = (String) jc1.getSelectedItem();
                            	flag5 = MyJdbc.updatePortionSize(productName, selectedPortionSize,mode);
                            	flag8 = true;
                            }
                            if(!flag8) {
                            	JOptionPane.showMessageDialog(frame, "At least one product Detail:");
                            	
                            }
                            else {
                            	JOptionPane.showMessageDialog(frame, "Data Add successfully :");
                            }
                        }
        			}
                    
                    
                    
        		}
                
                
            }
        });

    


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private JButton createButton(String text, int x, int y, int width, int height, Color bgColor, Color fgColor, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setFocusPainted(false);
        return button;
    }
}