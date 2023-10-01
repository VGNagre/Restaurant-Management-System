package com.Restorent.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Restorant.Add.customers;
import com.Restorent.DB.connectivity;
import com.Restorent.Remove.removeCust;

/**
 * 
 */
public class showcustm extends JFrame implements ActionListener{
	JTable jt;
	JScrollPane sp;
	connectivity c = new connectivity();
	JButton delete,back;
         public showcustm(){
   
         try {
	      jt=new JTable(); 
	      
	    sp=new JScrollPane(jt); 
	    add(sp);       
	    setSize(1000,00);     
	   setLocation(100,100);
	   sp.setBounds(0,0,1000,520); 
	 String query ="select * from  Customers";
	 ResultSet rs= c.s.executeQuery(query);
	 ResultSetMetaData rsmd=rs.getMetaData();
	 DefaultTableModel model = (DefaultTableModel) jt.getModel();
	 
	 int col=rsmd.getColumnCount();
	 String [] cloname=new String [col];
	 for(int i=0;i<col;i++) 
	 cloname[i]=rsmd.getColumnName(i+1);
	 model.setColumnIdentifiers(cloname);
     
     String Customer_ID = null,C_name,email,contact_no;
     
     while(rs.next())   {
    Customer_ID = rs.getString(1);
	C_name = rs.getString(2);
	email = rs.getString(3);
	contact_no = rs.getString(4);
	
	String row[]= {Customer_ID,C_name,email,contact_no};
       	 model.addRow(row); 
     }	 
         }
         catch(Exception e) {
        	 e.printStackTrace();         
        	 }
         
         delete = new JButton("Delete");
 		delete.setBounds(10,530,100,30);
 		delete.setBackground(Color.BLACK);
 		delete.setForeground(Color.WHITE);
 		delete.addActionListener(this);
 		add(delete);
 		
 		back = new JButton("Back");
 		back.setBounds(200,530,100,30);
 		back.setBackground(Color.BLACK);
 		back.setForeground(Color.WHITE);
 		back.addActionListener(this);
 		add(back);
         
         getContentPane().setBackground(Color.gray);
    	 setLayout(null);
    	 setSize(1000,650);
    	 setLocation(250,50);
    	
    	 setVisible(true);
         }
       
	public static void main(String[] args) {
		new showcustm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==delete) {
			new removeCust();
			setVisible(false);
		}else if(e.getSource()==back) {
			setVisible(false);
			new customers();
			
		}
	}
	}

	
