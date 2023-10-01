package com.Restorant.Add;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.Restorent.DB.connectivity;

import Restorant.frontPage;

public class addUser extends JFrame implements ActionListener {
	connectivity c = new connectivity();
	JLabel a,i,j,k,l;
	JTextField ii,kk,ll;
	JPasswordField jj;
	JButton submit,cancle;
	
	public addUser(){
		setLayout(null);
		setSize(1000,700);
		setLocation(250,50);
		
		 a = new JLabel("Add New User");
			add(a);
			a.setFont(new Font("Helvetica",Font.PLAIN,40));
			a.setForeground(Color.BLACK);
			a.setBounds(300,1,500,100);
		
		i = new JLabel("Set Username");
		add(i);
		i.setFont(new Font("Helvetica",Font.PLAIN,17));
		i.setForeground(Color.BLACK);
		i.setBounds(20,200,400,50);
		
		ii = new JTextField();
		ii.setBounds(200,210,200,30);
		add(ii);
		
		j = new JLabel("Enter Password");
		add(j);
		j.setFont(new Font("Helvetica",Font.PLAIN,17));
		j.setForeground(Color.BLACK);
		j.setBounds(20,250,400,50);
		
		jj = new JPasswordField();
		jj.setBounds(200,260,200,30);
		add(jj);
		
//		k = new JLabel("Re Enter Password");
//		add(k);
//		k.setFont(new Font("Helvetica",Font.PLAIN,17));
//		k.setForeground(Color.BLACK);
//		k.setBounds(50,210,400,50);
//		
//		kk = new JTextField();
//		kk.setBounds(300,220,200,30);
//		add(kk);
		
		ImageIcon pc = new ImageIcon(ClassLoader.getSystemResource("New folder/download.jpg"));
		Image i2 = pc.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT );
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		image.setBounds(500,100,400,400);
		
		 submit=new JButton("Submit");
		   submit.setBounds(200,330,90,25);
		   submit.setBackground(Color.BLACK);
		   submit.setForeground(Color.WHITE);
		   submit.addActionListener(this);
		   add(submit);
		   
		  cancle = new JButton("Cancle");
		  cancle.setBounds(300,330,90,25);
		  cancle.setBackground(Color.BLACK);
		  cancle.setForeground(Color.WHITE);
		  cancle.addActionListener(this);
		  add(cancle);	
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new addUser();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = ii.getText();
		String pass = jj.getText();
		

		if(e.getSource()==submit) {
			try {
				String query = "insert into pass values('"+username+"','"+pass+"')";
				boolean rs  = c.s.execute(query);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "User added successfully");
			 setVisible(false);	
		}
		else if(e.getSource()==cancle) {
			 JOptionPane.showMessageDialog(null, "Are you sure to Cancle?");
			 setVisible(false);	
			 new frontPage();
			
			}
					
		}
	}

