package com.Restorent.View;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Restorant.Add.Employees;
import com.Restorent.DB.connectivity;
import com.Restorent.Remove.removeEmp;

public class showemployee  extends JFrame implements ActionListener{
	 JTable jt;
	 JScrollPane sp;
	 JButton delete,back,update,search;
	 JLabel searchlbl;
	 Choice cempId;
		 connectivity  c= new connectivity();
		
		public showemployee(){		
			
			jt=new JTable();
			searchlbl = new JLabel("Search by Employee Id ");
			searchlbl.setBounds(20,50,250,20);
			searchlbl.setFont(new Font("Tahoma",Font.PLAIN,20));
			add(searchlbl);
			
			cempId = new Choice();
			cempId.setBounds(300,50,150,20);
			add(cempId);
			
			
			    sp=new JScrollPane(jt); 
			    add(sp);       
			    setSize(1000,00);     
			   setLocation(100,100);
			   sp.setBounds(0,200,1000,520);
			   try {
			   String query ="select * from Employees";
				 ResultSet rs= c.s.executeQuery(query);
				 while(rs.next()) {
					 cempId.add(rs.getString("employee_id"));
				 }
			   }catch(Exception e) {
		        	 e.printStackTrace();         
		        	 }
			   try {
			 String query ="select * from Employees";
			 ResultSet rs= c.s.executeQuery(query);
			 ResultSetMetaData rsmd=rs.getMetaData();
			 DefaultTableModel model = (DefaultTableModel) jt.getModel();
			 
			 int col=rsmd.getColumnCount();
			 String [] cloname=new String [col];
			 for(int i=0;i<col;i++) 
			 cloname[i]=rsmd.getColumnName(i+1);
			 model.setColumnIdentifiers(cloname);
			 
		    String  employee_id, E_name,email,gender,job,salary,contact_no;

		     
		     while(rs.next())   {
		    	 employee_id = rs.getString(1);
		    	 E_name = rs.getString(2);
		    	 email = rs.getString(3);
		    	 gender = rs.getString(4);
		    	 job    =rs.getString(5);
		    	 salary = rs.getString(6);
		    	 contact_no = rs.getString(7);
		    	 
			String row[]= {employee_id, E_name,email,gender,job,salary,contact_no};			
		       	 model.addRow(row); 
		     }	 
		         }
		         catch(Exception e) {
		        	 e.printStackTrace();         
		        	 }
		
		search = new JButton("SEARCH");
		search.setBounds(10,130,100,30);
		search.setBackground(Color.BLACK);
		search.setForeground(Color.WHITE);
		search.addActionListener(this);
		add(search);
			
		update = new JButton("UPDATE");
		update.setBounds(130,130,100,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		delete = new JButton("DELETE");
		delete.setBounds(250,130,100,30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("BACK");
		back.setBounds(370,130,100,30);
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
	    	   	new showemployee();
	    	   	    	   
	       }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==search) {
				try {
				String query = "select * from Employees where employee_id ='"+cempId.getSelectedItem()+"'" ;
				 ResultSet rs= c.s.executeQuery(query);
				
			   }catch(Exception f) {
		        	 f.printStackTrace();         
		        	 }
			}
			else if(e.getSource()==update) {
				new removeEmp();
			}
			else if(e.getSource()== delete) {
				new Employees();
			}
			else if(e.getSource()== back) {
				new Employees();
			}
			
		}	
	       

	
}
