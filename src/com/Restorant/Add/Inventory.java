package com.Restorant.Add;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.Restorent.DB.connectivity;

import Restorant.frontPage;

public class Inventory extends JFrame implements ActionListener {
     JLabel i,iname,price,category;
     JTextField tfiname,tfprice,tfcat;
     JButton submit,cancle;
	public Inventory(){
	setLayout(null);
	setSize(1000,700);
	setLocation(250,50);
	
     i = new JLabel("Welcome To Inventory");
	 add(i);
 	 i.setFont(new Font("Helvetica",Font.PLAIN,40));
 	 i.setForeground(Color.BLACK);
 	 i.setBounds(300,1,500,100);
	
	 iname = new JLabel("Item name");
	 iname.setBounds(190,110,400,50);
	 iname.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(iname);

	 tfiname = new JTextField();
	 tfiname.setBounds(400,125,200,30);
	 add(tfiname);


	 price = new JLabel("Item price");
	 price.setBounds(190,160,400,50);
	 price.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(price);
	
	 tfprice = new JTextField();
	 tfprice.setBounds(400,175,200,30);
	 add(tfprice);

	 category = new JLabel("category");
	 category.setBounds(190,210,400,50);
	 category.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(category);

	 tfcat = new JTextField("");
	 tfcat.setBounds(400,225,200,30);
	 add(tfcat);

	 submit= new JButton("SUBMIT");
	 submit.setBounds(300,270,90,25);
	 submit.setBackground(Color.BLACK);
	 submit.setForeground(Color.WHITE);
	 submit.addActionListener(this);
	 add(submit);
	  
	   cancle = new JButton("Cancle");
	  cancle.setBounds(400,270,90,25);
	  cancle.setBackground(Color.BLACK);
	  cancle.setForeground(Color.WHITE);
	  cancle.addActionListener(this);
	  add(cancle);
	 setVisible(true);

	}
	public static void main(String[] args) {
		new Inventory();

	}
	
	public void actionPerformed(ActionEvent e) {
		
			String Item_name = tfiname.getText();
			String quantity = tfprice.getText();
			String reorder_level = tfcat.getText();

			try {	
				
				connectivity c = new connectivity();
			String query = "insert into Inventory value ('"+Item_name+"','"+quantity+"','"+reorder_level+"')";
			int rs = c.s.executeUpdate(query); 
			
			}
			catch(Exception e1){
				
				e1.printStackTrace();
				
			}
			if(e.getSource()==submit) {
				JOptionPane.showMessageDialog(null, "orders added added successfully");
				 setVisible(false);
			}
			else if(e.getSource()==cancle) {
				setVisible(false);
				new frontPage();
			}
			
	
	}

}
