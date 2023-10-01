package com.Restorent.View;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Restorent.DB.connectivity;

public class showMenu extends JFrame{

	JTable jt;
	JScrollPane sp;
	connectivity c = new connectivity();
	
     public showMenu(){
   
         try {
        	 
         
	      jt=new JTable(); 
	      
	    sp=new JScrollPane(jt); 
	    add(sp);       
	    setSize(1000,00);     
	   setLocation(100,100);
	   sp.setBounds(0,0,1000,520); 
	 String query ="select * from menu";
	 ResultSet rs= c.s.executeQuery(query);
	 ResultSetMetaData rsmd=rs.getMetaData();
	 DefaultTableModel model = (DefaultTableModel) jt.getModel();
	 
	 int col=rsmd.getColumnCount();
	 String [] cloname=new String [col];
	 for(int i=0;i<col;i++) 
	 cloname[i]=rsmd.getColumnName(i+1);
	 model.setColumnIdentifiers(cloname);
	 
    String  item_id,I_name,price,category;

     
     while(rs.next())   {
    	 item_id = rs.getString(1);
    	 I_name = rs.getString(2);
    	 price = rs.getString(3);
    	 category = rs.getString(4);
    	
    	 
	String row[]= {item_id,I_name,price,category};
       	 model.addRow(row); 
     }	 
         }
         catch(Exception e) {
        	 e.printStackTrace();         
        	 }
         getContentPane().setBackground(Color.gray);
    	 setLayout(null);
//    	 setSize(1000,650);
//    	 setLocation(250,50);
    	
    	 setVisible(true);
    	 
    	 
     
         }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new showMenu();
	
}
}
