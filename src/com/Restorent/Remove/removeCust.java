package com.Restorent.Remove;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;

import com.Restorent.DB.connectivity;
import com.Restorent.View.showcustm;

import Restorant.frontPage;

public class removeCust extends JFrame implements ActionListener {
	JLabel labelempid, labelname,E_name,labelphone,lblphone,labelemail,email,labelgender,gender,labeljob,job,labelsalary,salary;
    Choice CustomerIDs;
    JButton delete,back;
    
    			connectivity  c= new connectivity();
    
	public removeCust(){
		setLayout(null);
		setSize(1000,700);
		setLocation(250,50);
		
		labelempid = new JLabel("Customer Id");
		labelempid.setBounds(200,50,100,30);
		labelempid.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(labelempid);
		
		CustomerIDs = new Choice();
		CustomerIDs.setBounds(400,60,100,40);
		CustomerIDs.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(CustomerIDs);
		
		try {
			String query = "select * from customers ";
			ResultSet rs = c.s.executeQuery(query);
//			where employee_id ='"+employee_id+"',E_name='"+E_name+"',email = '"+email+"',gender='"+gender+"',job_title='"+job+"',salary='"+salary+"','\"+contact_no+\"'"
				
				 while(rs.next())   {
					 CustomerIDs.add(rs.getString("Customer_ID"));

			}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
		
		labelname = new JLabel("Name");
		labelname.setBounds(200,100,100,30);
		labelname.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(labelname);
		
		E_name = new JLabel();
		E_name.setBounds(400,100,100,20);
		E_name.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(E_name);
		
		labelemail = new JLabel("Email");
		labelemail.setBounds(200,150,100,30);
		labelemail.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(labelemail);
		
		email = new JLabel();
		email.setBounds(400,130,100,50);
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(email);
		
//		labelgender = new JLabel("Contact");
//		labelgender.setBounds(200,200,100,30);
//		labelgender.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(labelgender);
//		
//		gender = new JLabel();
//		gender.setBounds(400,200,100,20);
//		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(gender);
//		
//		labeljob = new JLabel("Designation");
//		labeljob.setBounds(200,250,100,30);
//		labeljob.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(labeljob);
//		
//		job = new JLabel();
//		job.setBounds(400,250,200,20);
//		job.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(job);
//		
//		labelsalary = new JLabel("Salary");
//		labelsalary.setBounds(200,300,100,30);
//		labelsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(labelsalary);
//		
//		salary = new JLabel();
//		salary.setBounds(400,300,100,20);
//		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(salary);
		
		labelphone = new JLabel("Phone");
		labelphone.setBounds(200,200,100,30);
		labelphone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(labelphone);
		
		lblphone = new JLabel();
		lblphone.setBounds(400,200,100,20);
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblphone);
		
		try {
			String query = "select * from customers where Customer_ID ='"+CustomerIDs.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
//			,E_name='"+E_name+"',email = '"+email+"',gender='"+gender+"',job_title='"+job+"',salary='"+salary+"','\"+contact_no+\"'"
				
				 while(rs.next())   {

					 E_name.setText(rs.getString("C_name"));	    	
			    	email.setText(rs.getString("email"));
//			    	gender.setText(rs.getString("gender"));
//			    	job.setText(rs.getString("job_title"));
//			    	salary.setText(rs.getString("salary"));
			    	lblphone.setText(rs.getString("contact_no"));
			    	
//			    	 employee_id, E_name,email,gender,job,salary,contact_noC_name varchar(90) 
			    	
			}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
		CustomerIDs.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				// TODO Auto-generated method stub
				try {
					String query = "select * from customers where Customer_ID ='"+CustomerIDs.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
//		 String query ="insert into Customers value('"+CustomerIDs+"','"+Cnames+"','"+emails+"','"+contactnos+"');";

						 while(rs.next())   {

							 E_name.setText(rs.getString("C_name"));	    	
					    	email.setText(rs.getString("email"));
//					    	gender.setText(rs.getString("gender"));
//					    	job.setText(rs.getString("job_title"));
//					    	salary.setText(rs.getString("salary"));
					    	lblphone.setText(rs.getString("contact_no"));
					    	
//					    	 employee_id, E_name,email,gender,job,salary,contact_no
					}
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
			}
			
		});
		
		delete = new JButton("Delete");
		delete.setBounds(200,250,100,30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);
		
		
		
		back = new JButton("Back");
		back.setBounds(400,2500,100,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new removeCust();

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()== delete) {
			
			try {
			String query = "delete from customers where Customer_ID ='"+CustomerIDs.getSelectedItem()+"'";	
			c.s.execute(query);
			
			JOptionPane.showMessageDialog(null,"Customer Information Deleted Successfully");
			setVisible(false);
			new showcustm();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()== back){
			setVisible(false);
			new frontPage();
		}
	}
	}	


