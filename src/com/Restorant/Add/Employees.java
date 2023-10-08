package com.Restorant.Add;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Restorent.DB.connectivity;

import Restorant.frontPage;
public class Employees extends JFrame implements ActionListener{
	
	JLabel i,name,email,gender,job,salary,phone,ID,IDl;
	JTextField tfname,tfemail,salaryy,phonel;
	JButton submit,cancle;
	JRadioButton abmale,abfemale;
	JComboBox<?> cbjob;
	JTable table;	
					connectivity  c= new connectivity();
	

	public Employees(){
		setLayout(null);
		setSize(1000,700);
		setLocation(250,50);
		
		i = new JLabel("Welcome to Employees");
		i.setBounds(300,1,500,100);
		i.setFont(new Font("Tahoma",Font.PLAIN,40));
		add(i);
		
		
//		ID = new JLabel("Employee Id");
//		ID.setBounds(10,110,400,50);
//		ID.setFont(new Font("Tahoma",Font.PLAIN,17));
//		add(ID);
//		
		IDl = new JLabel();
		IDl.setBounds(150,125,200,30);
		add(IDl);
		
		name = new JLabel("Employee Name");
		name.setBounds(10,160,400,50);
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(150,175,200,30);
		add(tfname);
	
		email = new JLabel("email");
		email.setBounds(10,210,400,50);
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(email);
		
		tfemail = new JTextField();
		tfemail.setBounds(150,225,200,30);
		add(tfemail);
		
		gender = new JLabel("Gender");
		gender.setBounds(10,260,400,50);
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(gender);
		
		abmale = new JRadioButton("male");
		abmale.setBounds(150,270,70,30);
		abmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		abmale.setBackground(Color.DARK_GRAY);
		abmale.setForeground(Color.WHITE);
		add(abmale);
		
		abfemale = new JRadioButton("Female");
		abfemale.setBounds(250,270,70,30);
		abfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		abfemale.setBackground(Color.DARK_GRAY);
		abfemale.setForeground(Color.WHITE);
		add(abfemale);
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(abfemale);
		bg.add(abmale);
		
		job = new JLabel("Job");
		job.setBounds(10,310,400,50);
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(job);
		
		String str[] = {"Front drsk clerk","portel","housekeeping","kitchen staff","Room service","Chefs","waiter/waitress","manager"};	
		cbjob = new JComboBox<Object>(str);
		cbjob.setBounds(150,325,200,30);
		cbjob.setBackground(Color.WHITE);
		add(cbjob);
		
		salary = new JLabel("Salary");
		salary.setBounds(10,360,400,50);
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		salary.setBackground(Color.WHITE);
		add(salary);
		
		salaryy = new JTextField();
		salaryy.setBounds(150,375,200,30);
		add(salaryy);
		
		phone = new JLabel("contact no");
		phone.setBounds(10,410,400,50);
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(phone);
		
		phonel = new JTextField();
		phonel.setBounds(150,425,200,30);
		add(phonel);
		
		
		
		submit = new JButton("SUBMIT");
		submit.setBounds(150,470,90,25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancle = new JButton("Cancle");
		  cancle.setBounds(270,470,90,25);
		  cancle.setBackground(Color.BLACK);
		  cancle.setForeground(Color.WHITE);
		  cancle.addActionListener(this);
		  add(cancle);	  
	
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
		String employee_id = IDl.getText();
		String E_name = tfname.getText();
		String email = tfemail.getText();
		String salary = salaryy.getText();
		String contact_no = phonel.getText();
		String job = (String) cbjob.getSelectedItem();
		
		String gender = null;
		if(abmale.isSelected()) {
			gender = "male";
		}
		else if(abfemale.isSelected()) {
			gender = "female";
		}
		
		char fn = 0;
		for(int i=0;i<=1;i++) {
			fn=E_name.charAt(0);
		}
		char fo = 0;
		for(int i=0;i<=1;i++) {
			fo=E_name.charAt(1);
		}
		
		char d = 0,b=0;
		for(int i=0;i<=1;i++) {
			d=contact_no.charAt(0); }	
		for(int i=0;i<=1;i++) {
			b=contact_no.charAt(1);
			}	
		
		employee_id= Character.toString(fn)+Character.toString(fo)+Character.toString(d)+Character.toString(b);
		
		try {
			
	      String query ="insert into Employees value('"+employee_id+"','"+E_name+"','"+email+"','"+gender+"','"+job+"','"+salary+"','"+contact_no+"')";
			 int rs = c.s.executeUpdate(query);
			
			 
		 }catch(Exception e1){
			 e1.printStackTrace();
			 
		 }
		
			JOptionPane.showMessageDialog(null, "Employee added successfully and Employee ID is '"+employee_id+"'");
			 setVisible(false);
		}
		else if(e.getSource()==cancle) {
			setVisible(false);
			new frontPage();
		}
	}

}
