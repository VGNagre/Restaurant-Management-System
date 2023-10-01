package com.Restorent.View;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Restorent.DB.connectivity;

public class showorder extends JFrame {
	JTable jt;
	JScrollPane sp;
	connectivity c = new connectivity();
	JLabel update;
	JTextField tfUpdate;
         public showorder(){
   update = new JLabel();
   
         try {
	      jt=new JTable(); 
	      
	    sp=new JScrollPane(jt); 
	    add(sp);       
	    setSize(1000,00);     
	   setLocation(250,50);
	   sp.setBounds(0,30,1000,520); 
	 String query ="select * from Orders";
	 ResultSet rs= c.s.executeQuery(query);
	 ResultSetMetaData rsmd=rs.getMetaData();
	 DefaultTableModel model = (DefaultTableModel) jt.getModel();
	 
	 int col=rsmd.getColumnCount();
	 String [] cloname=new String [col];
	 for(int i=0;i<col;i++) 
	 cloname[i]=rsmd.getColumnName(i+1);
	 model.setColumnIdentifiers(cloname);
	 
    String  order_ID,customer_ID,Order_date,Order_time,item_id,total_price;

     
     while(rs.next())   {
    	 order_ID = rs.getString(1);
    	 customer_ID = rs.getString(2);
    	 Order_date = rs.getString(3);
    	 Order_time = rs.getString(4);
    	 item_id    =rs.getString(5);
    	 total_price = rs.getString(6);
	
    	 
	String row[]= {order_ID,customer_ID,Order_date,Order_time,item_id,total_price};
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
       new showorder();
	}

}
