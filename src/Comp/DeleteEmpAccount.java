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

public class DeleteEmpAccount {
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
	JFrame f1;
	JTextField tf1,tf2;
	public DeleteEmpAccount(){
		f1 = new JFrame();
		f1.setBounds(100,100,400,300);
		f1.setLayout(null);
		f1.setTitle("DeleteAccount");
		
		JLabel lb1 = new JLabel("Enter Employee Id:");
		lb1.setBounds(150,90,150,20);
		f1.add(lb1);
		
		tf1 = new JTextField();
		tf1.setBounds(137,120,120,20);
		f1.add(tf1);
		
		JButton bt1 = new JButton("Delete");
		bt1.setBounds(154, 158, 80, 20);
		f1.add(bt1);
		
		bt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(f1,"Enter Employee id","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!checkNumeric(tf1.getText())) {
					JOptionPane.showMessageDialog(f1,"Enter Employee id in numeric","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					int id = Integer.parseInt(tf1.getText());
					JdbcConnectivity Myjdbc= new JdbcConnectivity();
					int flag = Myjdbc.DeleteEmpAccount(id);
					if(flag==1) {
						JOptionPane.showMessageDialog(f1,"Employee Remove Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(f1,"Enter corrent Employee id","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}	
		});
		
		f1.setVisible(true);
	}
}
