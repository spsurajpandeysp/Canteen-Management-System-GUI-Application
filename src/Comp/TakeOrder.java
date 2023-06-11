package Comp;
import javax.swing.*;
import image.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

import JDBC.JdbcConnectivity;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.event.*;
import javax.swing.table.*;
class TransparentPanel extends JPanel {
    private Image backgroundImage;

    public TransparentPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        setOpaque(false);
    }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
 class TakeOrder extends JFrame{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,jb11,lb10,lb12,lb13,lb14,lb15,lb16;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
	JTextArea ta1,ta2,ta3,ta4,ta5,ta6;
	JComboBox cb1,cb2;
    JFrame f1;
    JTable table1,table2; 
    JdbcConnectivity jdbc=null;
    int price,totalAmount,totalDiscount,discount,totalPrice,paidAmount,payingAmount;
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
    public TakeOrder() {
        f1 = new JFrame();
        f1.setBounds(20, 20, 1500, 820);
        f1.setTitle("TakeOrder");
        
        JdbcConnectivity jdb = new JdbcConnectivity();
    	jdb.truncateTablePurchased();
		     
        String imagePath = "C:\\Users\\suraj\\Downloads/TakeOrderBackground.png";
        ImageIcon imageIcon = new ImageIcon("image.TakeOrderBackground.png");
        Image image = imageIcon.getImage().getScaledInstance(f1.getWidth(), f1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        TransparentPanel backgroundPanel = new TransparentPanel(resizedImageIcon.getImage());
        backgroundPanel.setLayout(null);
        f1.setContentPane(backgroundPanel);
        
        
        JdbcConnectivity jd = new JdbcConnectivity();
    	Object[][]record1 = jd.fethAllProductDetails();
        String[] header1 = {"NAME","PORTION_SIZE","DISCOUNT(%)","PRICE","QTY"};
        JPanel panel1 = new JPanel();
        panel1.setBounds(40,20,500,470);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Item Menu", TitledBorder.CENTER, TitledBorder.TOP));
        table1 = new JTable(record1,header1);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  
        panel1.add(new JScrollPane(table1));
        table1.validate();
        f1.add(panel1);        
        
        String[] header2 = {"NAME","PORTION_SIZE","DISCOUNT(%d)","PRICE","SELECT QTY"};
        
        Object[][] record2= new Object[0][5] ;
        JPanel panel2 = new JPanel();
        panel2.setBounds(950,10,500,460);
        panel2.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Purchase Item List", TitledBorder.CENTER, TitledBorder.TOP));
        DefaultTableModel model1 = new DefaultTableModel(record2,header2);
        JTable table2 = new JTable(model1);
        panel2.add(new JScrollPane(table2));
        table2.setBounds(10, 10, 100,50);
        f1.add(panel2);
        
        lb1 = new JLabel(" ");
        lb1.setBounds(900,0,2,820);
        lb1.setBackground(Color.black);
        lb1.setOpaque(true);
        f1.add(lb1);
        
        lb2 = new JLabel("Total Amount:");
		lb2.setBounds(1150,500,100,20);
        lb2.setOpaque(true);
        f1.add(lb2);
        
        ta2 = new JTextArea();
        ta2.setBounds(1240,500,100,20);
        ta2.setText(Integer.toString(totalAmount));
        f1.add(ta2);
        
        lb3 = new JLabel("Total Discount:");
		lb3.setBounds(1150,540,100,20);
        lb3.setOpaque(true);
        f1.add(lb3);
        
        ta3 = new JTextArea();
        ta3.setBounds(1240,540,100,20);
        ta3.setText(Integer.toString(totalDiscount));
        f1.add(ta3);
        
        lb4 = new JLabel("Paying Amount:");
		lb4.setBounds(1150,580,100,20);
        lb4.setOpaque(true);
        f1.add(lb4);
        
        ta4 = new JTextArea();
        ta4.setBounds(1240,580,100,20);
        ta4.setText(Integer.toString(payingAmount));
        f1.add(ta4);
        
        lb5 = new JLabel("ENTER CUSTOMER DETAILS");
		lb5.setBounds(380,520,230,30);
		lb5.setForeground(Color.blue);
        lb5.setOpaque(true);  
        
        lb5.setFont(new Font("Arial", Font.BOLD, 15));
        f1.add(lb5);
		
		lb6 = new JLabel("First Name:");
		lb6.setBounds(280,570,100,40);
		f1.add(lb6);
		
		tf1 = new JTextField();
		tf1.setBounds(350,570,120,40);
		f1.add(tf1);
		
		lb7 = new JLabel("Last Name:");
		lb7.setBounds(490,570,100,40);
		f1.add(lb7);
		
		tf2 = new JTextField();
		tf2.setBounds(560,570,120,40);
		f1.add(tf2);
		
		lb8 = new JLabel("Mobile No:");
		lb8.setBounds(280,620,100,40);
		f1.add(lb8);
		
		tf6 = new JTextField();
		tf6.setBounds(350,620,120,40);
		f1.add(tf6);

		lb9 = new JLabel("Pay Mode");
		lb9.setBounds(490,620,100,40);
		f1.add(lb9);
		
		String[] mode1 = {"-select-","online","cash",};
		cb1 = new JComboBox(mode1);
		cb1.setBounds(560, 620, 120, 40);
		f1.add(cb1);
		
        
        JButton bt5 = new JButton("Place Order");
        bt5.setBounds(1080, 700, 130, 30);
        bt5.setBackground(new Color(52, 152, 219)); 
        bt5.setForeground(Color.WHITE); 
        bt5.setFont(new Font("Arial", Font.BOLD, 14)); 
        bt5.setFocusPainted(false); 
        backgroundPanel.add(bt5);
        
        bt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf6.getText().isEmpty()) {
            		JOptionPane.showMessageDialog(f1,"first name,last should not be empty","Message",JOptionPane.WARNING_MESSAGE);
            	}
            	else {
            		String firstName = tf1.getText();
                	String lastName = tf2.getText();
                	String mode1 = (String) cb1.getSelectedItem();
                	if(!checkAlphabate(firstName) || !checkAlphabate(firstName)) {
                		JOptionPane.showMessageDialog(f1,"First Name and last name must be in albhabate","Message",JOptionPane.WARNING_MESSAGE);
                	}
                	else if(!checkNumeric(tf6.getText()) || tf6.getText().length()!=10) {
                		JOptionPane.showMessageDialog(f1,"mobile should be in numeric form and of 10 digit","Message",JOptionPane.WARNING_MESSAGE);
                	}
                	else if(payingAmount == 0) {
                		JOptionPane.showMessageDialog(f1,"First add item in purchaed list","Message",JOptionPane.WARNING_MESSAGE);
                	}
                	else if(mode1.equals("online")) {
                		long custPhoneNo = Long.parseLong(tf6.getText());
                		jdbc= new JdbcConnectivity();
                		jdbc.addCustomerDetails(firstName,lastName,custPhoneNo,totalAmount,totalDiscount,payingAmount);
                		GenerateBill gb = new GenerateBill(firstName,lastName,custPhoneNo,totalAmount,totalDiscount,payingAmount,mode1);
                		f1.dispose();
                	}
                	else if(mode1.equals("cash")){
                		long custPhoneNo = Long.parseLong(tf6.getText());
                		jdbc= new JdbcConnectivity();
                		jdbc.addCustomerDetails(firstName,lastName,custPhoneNo,totalAmount,totalDiscount,payingAmount);
                		GenerateBill gb = new GenerateBill(firstName,lastName,custPhoneNo,totalAmount,totalDiscount,payingAmount,mode1);
                		f1.dispose();
                	}	
                	else {
                		JOptionPane.showMessageDialog(f1,"Select Mode","Message",JOptionPane.WARNING_MESSAGE);
                	}
            	}
            	
            	
            }
            	
        });
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(1280, 700, 130, 30);
        backButton.setBackground(new Color(231, 76, 60)); 
        backButton.setForeground(Color.WHITE); 
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JdbcConnectivity jd = new JdbcConnectivity();
            	jd.truncateTablePurchased();
                f1.dispose(); 
            }
        });
        backgroundPanel.add(backButton);
        
        lb14 = new JLabel("ENTER PRODUCT DETAILS");
		lb14.setBounds(625,50,210,30);
		lb14.setForeground(Color.blue);
        lb14.setOpaque(true);  
        lb14.setFont(new Font("Arial", Font.BOLD, 15));
        f1.add(lb14);
        
        lb10 = new JLabel("NAME:");
		lb10.setBounds(630,120,100,40);
		f1.add(lb10);
		
		tf10 = new JTextField();
		tf10.setBounds(730,120,120,40);
		f1.add(tf10);
		
		
		lb13 = new JLabel("Portion Size:");
		lb13.setBounds(630,180,100,40);
		f1.add(lb13);
		
		
		String[] mode2 = {"-select-", "half plate", "full plate", "one cup", "200ml","1/2 cup","large","small","mediun","etc","other"};
		cb2 = new JComboBox(mode2);
		cb2.setBounds(730, 180, 120, 40);
		f1.add(cb2);
		
		
		
		lb12 = new JLabel("QTY");
		lb12.setBounds(630,240,100,40);
		f1.add(lb12);
		
		tf11 = new JTextField();
		tf11.setBounds(730,240,120,40);
		f1.add(tf11);
       
		/*bt1 = new JButton("REMOVE");
        bt1.setBounds(660, 400, 130, 30);
        bt1.setBackground(new Color(231, 76, 60)); 
        bt1.setForeground(Color.WHITE); 
        bt1.setFont(new Font("Arial", Font.BOLD, 14));
        bt1.setFocusPainted(false);
        f1.add(bt1);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
                
            }
        });*/
        bt2 = new JButton("ADD");
        bt2.setBounds(660, 320, 130, 30);
        bt2.setBackground(new Color(231, 76, 60)); 
        bt2.setForeground(Color.WHITE); 
        bt2.setFont(new Font("Arial", Font.BOLD, 14));
        bt2.setFocusPainted(false);
        f1.add(bt2);
        
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String portionSize = (String) cb2.getSelectedItem();
            	if (tf10.getText().isEmpty() ||tf11.getText().isEmpty()) {
            		JOptionPane.showMessageDialog(f1,"Product name and QTY not be empty:","Message",JOptionPane.WARNING_MESSAGE);
            	}
            	else if(portionSize.equals("-select-")){
            		JOptionPane.showMessageDialog(f1,"please Select portion Size","Message",JOptionPane.WARNING_MESSAGE);
            	}
            	else {
                	String productName = tf10.getText();
                	jdbc= new JdbcConnectivity();
            		int flag = jdbc.CheckAvailableInStockOrNot(productName, portionSize);
                    
                    if(!checkAlphabate(productName)) {
                    	JOptionPane.showMessageDialog(f1,"Enter Product Name in Alphabate:","Message",JOptionPane.WARNING_MESSAGE);
                    }
                    else if(!checkNumeric(tf11.getText())){
                    	JOptionPane.showMessageDialog(f1,"Enter QTY in numeric","Message",JOptionPane.WARNING_MESSAGE);
                    }
                    else if(flag==0) {
                    	JOptionPane.showMessageDialog(f1,"Product Not available:","Message",JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	jdbc= new JdbcConnectivity();
                    	String[] rec = jdbc.fethAllAddProductDetails(productName,portionSize);
                    	int qty = Integer.parseInt(tf11.getText());
                    	if(qty<=0) {
                    		JOptionPane.showMessageDialog(f1,"qty not will be zero","Message",JOptionPane.WARNING_MESSAGE);
                    	}
                    	else if(Integer.parseInt(rec[4])>=qty) {
                    		jdbc= new JdbcConnectivity();
                    		int flag2 = jdbc.AddPurchasedDetails(productName, portionSize,Integer.parseInt(rec[2]),Integer.parseInt(rec[3])*qty,qty);
                    		Object[] newRow = {rec[0],rec[1],rec[2],Integer.toString(Integer.parseInt(rec[3])*qty),Integer.toString(qty)};
                    		int a = Integer.parseInt(rec[3])*qty;
                    		int b = (a*Integer.parseInt(rec[2]))/100;
                    		totalAmount+=a;
                    		totalDiscount+=b;
                    		payingAmount = totalAmount - totalDiscount;
                    		ta3.setText(Integer.toString(totalDiscount));
                            ta2.setText(Integer.toString(totalAmount));
                            ta4.setText(Integer.toString(payingAmount));
                    		model1.addRow(newRow);
                    	}
                    	else {
                    		JOptionPane.showMessageDialog(f1,"Select QTY under Stock","Message",JOptionPane.WARNING_MESSAGE);
                    	}
                    }
            		
            	}
            	
            }
        });
      
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }
}