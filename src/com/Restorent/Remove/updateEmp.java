package com.Restorent.Remove;

import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.Restorent.DB.connectivity;
import com.Restorent.View.showemployee;

import Restorant.frontPage;

public class updateEmp extends JFrame implements ActionListener {
	 JLabel labelempid, labelname,E_name,labelphone,lblphone,labelemail,email,labelgender,gender,labeljob,job,labelsalary,salary;
	    Choice employee_id;
	    JButton delete,back;
	    
	    			connectivity  c= new connectivity();
	    
		public updateEmp(){
			setLayout(null);
			setSize(1000,700);
			setLocation(250,50);
			
			labelempid = new JLabel("Employee Id");
			labelempid.setBounds(200,50,100,30);
			labelempid.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(labelempid);
			
			employee_id = new Choice();
			employee_id.setBounds(400,60,100,40);
			employee_id.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(employee_id);
			
			try {
				String query = "select * from Employees ";
				ResultSet rs = c.s.executeQuery(query);
//				where employee_id ='"+employee_id+"',E_name='"+E_name+"',email = '"+email+"',gender='"+gender+"',job_title='"+job+"',salary='"+salary+"','\"+contact_no+\"'"
					
					 while(rs.next())   {
						 employee_id.add(rs.getString("employee_id"));

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
			email.setBounds(400,150,200,50);
			email.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(email);
			
			labelgender = new JLabel("Gender");
			labelgender.setBounds(200,200,100,30);
			labelgender.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(labelgender);
			
			gender = new JLabel();
			gender.setBounds(400,200,100,20);
			gender.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(gender);
			
			labeljob = new JLabel("Designation");
			labeljob.setBounds(200,250,100,30);
			labeljob.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(labeljob);
			
			job = new JLabel();
			job.setBounds(400,250,200,20);
			job.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(job);
			
			labelsalary = new JLabel("Salary");
			labelsalary.setBounds(200,300,100,30);
			labelsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(labelsalary);
			
			salary = new JLabel();
			salary.setBounds(400,300,100,20);
			salary.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(salary);
			
			labelphone = new JLabel("Phone");
			labelphone.setBounds(200,350,100,30);
			labelphone.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(labelphone);
			
			lblphone = new JLabel();
			lblphone.setBounds(400,350,100,20);
			lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblphone);
			
			try {
				String query = "select * from Employees where employee_id ='"+employee_id.getSelectedItem()+"'";
				ResultSet rs = c.s.executeQuery(query);
//				,E_name='"+E_name+"',email = '"+email+"',gender='"+gender+"',job_title='"+job+"',salary='"+salary+"','\"+contact_no+\"'"
					
					 while(rs.next())   {

						 E_name.setText(rs.getString("E_name"));	    	
				    	email.setText(rs.getString("email"));
				    	gender.setText(rs.getString("gender"));
				    	job.setText(rs.getString("job_title"));
				    	salary.setText(rs.getString("salary"));
				    	lblphone.setText(rs.getString("contact_no"));
				    	
//				    	 employee_id, E_name,email,gender,job,salary,contact_no
				}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			employee_id.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent ie) {
					// TODO Auto-generated method stub
					try {
						String query = "select * from Employees where employee_id ='"+employee_id.getSelectedItem()+"'";
						ResultSet rs = c.s.executeQuery(query);
//						,E_name='"+E_name+"',email = '"+email+"',gender='"+gender+"',job_title='"+job+"',salary='"+salary+"','\"+contact_no+\"'"
							
							 while(rs.next())   {

								 E_name.setText(rs.getString("E_name"));	    	
						    	email.setText(rs.getString("email"));
						    	gender.setText(rs.getString("gender"));
						    	job.setText(rs.getString("job_title"));
						    	salary.setText(rs.getString("salary"));
						    	lblphone.setText(rs.getString("contact_no"));
						    	
//						    	 employee_id, E_name,email,gender,job,salary,contact_no
						}
							}
							catch(Exception e1) {
								e1.printStackTrace();
							}
				}
				
			});
			
			delete = new JButton("Delete");
			delete.setBounds(200,400,100,30);
			delete.setBackground(Color.BLACK);
			delete.setForeground(Color.WHITE);
			delete.addActionListener(this);
			add(delete);
		
			back = new JButton("Back");
			back.setBounds(400,400,100,30);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			add(back);
			
			setVisible(true);
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new removeEmp();

		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if(ae.getSource()== delete) {
				
				try {
				String query = "delete from Employees where employee_id ='"+employee_id.getSelectedItem()+"'";	
				c.s.execute(query);
				
				JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
				setVisible(false);
				new showemployee();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else if(ae.getSource()== back){
				setVisible(false);
				new frontPage();
			}
		}
}
