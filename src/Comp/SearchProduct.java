package Comp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import JDBC.JdbcConnectivity;

public class SearchProduct {
	JFrame f1;
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
	public SearchProduct() {
		f1 = new JFrame();
		f1.setBounds(100,100,700,400);
		
		f1.setTitle("statistics");
		
		String ProductName = JOptionPane.showInputDialog("Enter Product Name:");
		if(ProductName.isEmpty()){
			JOptionPane.showMessageDialog(f1, "Enter Product Name", "Message", JOptionPane.WARNING_MESSAGE);
		}
		else if(!checkAlphabate(ProductName)){
			JOptionPane.showMessageDialog(f1, "Enter Product Name", "Message", JOptionPane.WARNING_MESSAGE);
		}
		else {
			String portionSize = JOptionPane.showInputDialog("Enter portion size:");
			if(portionSize.isEmpty()){
				JOptionPane.showMessageDialog(f1, "Enter portion size", "Message", JOptionPane.WARNING_MESSAGE);
			}
			else if(!checkAlphabate(portionSize)){
				JOptionPane.showMessageDialog(f1, "portion size must be in numeric form", "Message", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JdbcConnectivity jd = new JdbcConnectivity();
				int flag = jd.checkAvailable(ProductName,portionSize);
				if(flag ==0 ) {
					JOptionPane.showMessageDialog(f1, "This Product is not Available", "Message", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JdbcConnectivity jds = new JdbcConnectivity();
					String [] record= jds.fetchProductDetails(ProductName,portionSize);
					String[] columnName= {"PRODUCT_ID","PRODUCT_NAME","PORTION_UNIT","PRICE","DISCOUNT","TOTAL_QTY"};
					String[][] data = {{record[0],record[1],record[2],record[3],record[4],record[5]}};
					JTable table = new JTable(data,columnName);
					f1.add(new JScrollPane(table));
					f1.setVisible(true);
				}
				
			}
		}
		
	}
}
