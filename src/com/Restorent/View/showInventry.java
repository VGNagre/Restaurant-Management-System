package com.Restorent.View;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Restorent.DB.connectivity;

public class showInventry extends JFrame{
	JTable jt;
	JScrollPane sp;
	connectivity c = new connectivity();
	
	public showInventry(){
		
		
		try {
		      jt=new JTable(); 
		      
		    sp=new JScrollPane(jt); 
		    add(sp);       
		    setSize(1000,00);     
		   setLocation(100,100);
		   sp.setBounds(0,0,1000,520); 
		 String query ="select * from Inventory";
		 ResultSet rs= c.s.executeQuery(query);
		 ResultSetMetaData rsmd=rs.getMetaData();
		 DefaultTableModel model = (DefaultTableModel) jt.getModel();
		 
		 int col=rsmd.getColumnCount();
		 String [] cloname=new String [col];
		 for(int i=0;i<col;i++) 
		 cloname[i]=rsmd.getColumnName(i+1);
		 model.setColumnIdentifiers(cloname);
		 
	    String  Item_name,quantity,reorder_level;

	     
	     while(rs.next())   {
	    	 Item_name = rs.getString(1);
	    	 quantity = rs.getString(2);
	    	 reorder_level = rs.getString(3);
	    	
		
	    	 
		String row[]= {Item_name,quantity,reorder_level};
	       	 model.addRow(row); 
	     }	 
	         }
	         catch(Exception e) {
	        	 e.printStackTrace();         
	        	 }
	         getContentPane().setBackground(Color.gray);
	    	 setLayout(null);
	    	 setSize(1000,650);
	    	 setLocation(250,50);
	    	
	    	 setVisible(true);
	         }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new showInventry();
	}

}
