package com.Restorant.Add;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Restorent.DB.connectivity;

import Restorant.frontPage;

public class menu extends JFrame implements ActionListener{
         JLabel i,k,j,price,category;
	    JTextField r,jr,pr,cate;
	    JButton submit,cancle;
	public menu() {
		setLayout(null);
		setSize(1000,700);
		setLocation(250,50);
		
		 i = new JLabel("Welcome to the menu");
		add(i);
		i.setBounds(300,1,500,100);
		i.setFont(new Font("Helvetica",Font.PLAIN,40));
	  
		 k = new JLabel("Item id");
		k.setFont(new Font("Helvetica",Font.PLAIN,17));
		k.setBounds(190,110,400,50);
		add(k);
		
		r = new JTextField();
		r.setBounds(400,125,200,30);
		add(r);
		
		 j = new JLabel("Item name");
		j.setFont(new Font("Helvetica",Font.PLAIN,17));
		j.setBounds(190,160,400,50);
		add(j);
		
		  jr = new JTextField();
		jr.setBounds(400,175,200,30);
		add(jr);
		
		 price = new JLabel("Ietem price");
		price.setFont(new Font("Helvetica",Font.PLAIN,17));
		price.setBounds(190,210,400,50);
		add(price);
			
		 pr = new JTextField();
		pr.setBounds(400,225,200,30);
		add(pr);
		
		 category = new JLabel("category");
		category.setFont(new Font("Helvetica",Font.PLAIN,17));
		category.setBounds(190,260,400,50);
		add(category);
			
		 cate = new JTextField();
		cate.setBounds(400,275,200,30);
		add(cate);
		
		 submit= new JButton("SUBMIT");
			submit.setBounds(350,320,100,30);
			submit.setBackground(Color.BLACK);
			submit.setForeground(Color.WHITE);
		  submit.addActionListener(this);
			  add(submit);
			  
		 cancle= new JButton("Cancle");
				cancle.setBounds(500,320,100,30);
				cancle.setBackground(Color.BLACK);
				cancle.setForeground(Color.WHITE);
			  cancle.addActionListener(this);
				  add(cancle);
		
		  setVisible(true);
		  
		 }
	public static void main(String[] args) {
		new menu();
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			
		String item_id = r.getText();
		String I_name = jr.getText();
		String price = pr.getText();
		String category = cate.getText();
		
		try {
			connectivity c = new connectivity();
			 String query ="insert into menu value('"+item_id+"','"+I_name+"','"+price+"','"+category+"')";
			 int rs = c.s.executeUpdate(query);
			 JOptionPane.showMessageDialog(null, "menu added added successfully");
			 setVisible(false);
			 
		 }catch(Exception e1){
			 e1.printStackTrace();
			 
		 }
		
		}else if (e.getSource() == cancle) {
			setVisible(false);
			new frontPage();
		}
		
	}

}
