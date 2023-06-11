package Comp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import JDBC.JdbcConnectivity;

public class DeleteItems {
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
	JFrame f1;
	JTextField tf1,tf2;
	public DeleteItems(){
		f1 = new JFrame();
		f1.setBounds(100,100,400,300);
		f1.setLayout(null);
		f1.setTitle("DeleteAccount");
		
		
		JLabel lb1 = new JLabel("ENTER PRODUCT NAME");
		lb1.setBounds(130,20,170,20);
		f1.add(lb1);
		
		tf1 = new JTextField();
		tf1.setBounds(137,50,120,20);
		f1.add(tf1);
		
		JLabel lb2 = new JLabel("SELECT PORTION SIZE");
		lb2.setBounds(130,80,170,20);
		f1.add(lb2);
		
		String[] modes = {"-SELECT-","half plate", "full plate", "one cup", "200ml","1/2 cup","large","small","mediun","other"};
        JComboBox jc1 = new JComboBox<String>(modes);
        jc1.setBounds(137, 110, 120, 20);
        f1.add(jc1);
		
		JButton bt1 = new JButton("Delete");
		bt1.setBounds(154, 158, 80, 20);
		f1.add(bt1);
		
		bt1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				String mode = (String)jc1.getSelectedItem();
				if(tf1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(f1,"Enter Product Name","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(mode.equals("-SELECT-")) {
					JOptionPane.showMessageDialog(f1,"Select Portion Size","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!checkAlphabate(tf1.getText())) {
					JOptionPane.showMessageDialog(f1,"Enter Product Name in Alphabate","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String productName = tf1.getText();
					int flag =1;
					JdbcConnectivity Myjdbc= new JdbcConnectivity();
					flag = Myjdbc.DeleteIteam(productName,mode);
					if(flag==1) {
						JOptionPane.showMessageDialog(f1,"Item Deleted Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(f1,"This Product Not available","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}	
		});
		
		f1.setVisible(true);
	}
}
