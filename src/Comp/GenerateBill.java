package Comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import JDBC.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import JDBC.JdbcConnectivity;

public class GenerateBill {
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,jb11,lb10,lb12,lb13,lb14,lb15,lb16;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
	JTextArea ta1,ta2,ta3,ta4,ta5,ta6,ta7,ta8,ta9;
	JComboBox cb1,cb2;
    JFrame f1;
    JTable table1,table2; 
    JdbcConnectivity jdbc=null;
    public GenerateBill(String firstName,String lastName,long custPhoneNo,int totalAmount,int totalDiscount,int payingAmount,String mode1) {
        f1 = new JFrame();
        f1.setBounds(20, 20, 1000, 600);
        f1.setTitle("Generate bill");
        
        
		     
        String imagePath = "C:\\Users\\suraj\\Downloads/TakeOrderBackground.png";
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\suraj\\Downloads/TakeOrderBackground.png");
        Image image = imageIcon.getImage().getScaledInstance(f1.getWidth(), f1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        TransparentPanel backgroundPanel = new TransparentPanel(resizedImageIcon.getImage());
        backgroundPanel.setLayout(null);
        f1.setContentPane(backgroundPanel);
        
        JdbcConnectivity mj = new JdbcConnectivity();
        String[] header2 = {"NAME","PORTION_SIZE","DISCOUNT(%d)","PRICE","SELECT QTY"};
        Object[][] record2= mj.fethAllPurchasedDetails();
        for(int i=0;i<record2.length;i++) {
        	JdbcConnectivity mjs = new JdbcConnectivity();
        	mjs.decrementQTY((String)(record2[i][0]),(String)record2[i][1],Integer.parseInt((String)record2[i][4]));
        	
        }
        JPanel panel2 = new JPanel();
        panel2.setBounds(400,10,500,460);
        panel2.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Purchased Item List", TitledBorder.CENTER, TitledBorder.TOP));
        JTable table2 = new JTable(record2, header2);
        panel2.add(new JScrollPane(table2));
        table2.setBounds(10, 10, 100,50);
        f1.add(panel2);
        
        
        
        lb2 = new JLabel("Total Amount:");
		lb2.setBounds(100,290,80,20);
        lb2.setOpaque(true);
        f1.add(lb2);
        
        ta2 = new JTextArea();
        ta2.setBounds(190,290,90,20);
        ta2.setText(Integer.toString(totalAmount));
        f1.add(ta2);
        
        lb3 = new JLabel("Total Discount:");
		lb3.setBounds(100,350,90,20);
        lb3.setOpaque(true);
        f1.add(lb3);
        
        ta3 = new JTextArea();
        ta3.setBounds(190,350,90,20);
        ta3.setText(Integer.toString(totalDiscount));
        f1.add(ta3);
        
        lb4 = new JLabel("Paid Amount:");
		lb4.setBounds(100,410,90,20);
        lb4.setOpaque(true);
        f1.add(lb4);
        
        ta4 = new JTextArea();
        ta4.setBounds(190,410,90,20);
        ta4.setText(Integer.toString(payingAmount));
        f1.add(ta4);
        
        lb1 = new JLabel(" ");
        lb1.setBounds(900,0,2,820);
        lb1.setBackground(Color.black);
        lb1.setOpaque(true);
        f1.add(lb1);
        
        lb5 = new JLabel("First Name");
		lb5.setBounds(100,50,90,20);
        lb5.setOpaque(true);
        f1.add(lb5);
        
        ta5 = new JTextArea();
        ta5.setBounds(190,50,90,20);
        ta5.setText(firstName);
        f1.add(ta5);
        
        lb6 = new JLabel("Last Name:");
		lb6.setBounds(100,110,90,20);
        lb6.setOpaque(true);
        f1.add(lb6);
        
        ta6 = new JTextArea();
        ta6.setBounds(190,110,90,20);
        ta6.setText(lastName);
        f1.add(ta6);
        
        lb7 = new JLabel("Phone No");
		lb7.setBounds(100,170,90,20);
        lb7.setOpaque(true);
        f1.add(lb7);
        
        ta7 = new JTextArea();
        ta7.setBounds(190,170,90,20);
        ta7.setText(Long.toString(custPhoneNo));
        f1.add(ta7);
        
        lb8 = new JLabel("Payment Mode:");
		lb8.setBounds(100,230,90,20);
        lb8.setOpaque(true);
        f1.add(lb8);
        
        ta8 = new JTextArea();
        ta8.setBounds(190,230,90,20);
        ta8.setText(mode1);
        f1.add(ta8);
        
        bt2 = new JButton("DONE");
        bt2.setBounds(200, 470, 130, 30);
        bt2.setBackground(new Color(231, 76, 60)); 
        bt2.setForeground(Color.WHITE); 
        bt2.setFont(new Font("Arial", Font.BOLD, 14));
        bt2.setFocusPainted(false);
        f1.add(bt2);
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f1.dispose();
            	TakeOrder tk = new TakeOrder();
            }
        });
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }
}
