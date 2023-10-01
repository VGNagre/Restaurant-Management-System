package com.Restorant.Add;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import com.Restorent.DB.connectivity;
import com.toedter.calendar.JDateChooser;

import Restorant.frontPage;

public class payments extends JFrame implements ActionListener {
	JLabel tfid,i,id,amount,add,jd,kd;
	JTextField jda,tfamount,addtext;
	JButton submit,cancle;
	JDateChooser tkd;
	 Random ran = new Random();
		int number = ran.nextInt(1);
		
		connectivity c = new connectivity();
		
    public payments(){
    	
    	setLayout(null);
		setSize(1000,700);
		setLocation(250,50);
		
	     i = new JLabel("Welcome To Payments");
		 add(i);
     	 i.setFont(new Font("Helvetica",Font.PLAIN,40));
     	 i.setForeground(Color.BLACK);
     	 i.setBounds(300,1,500,100);
		
		 id = new JLabel("PAYMENT ID ");
		 id.setBounds(190,110,400,50);
		 id.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(id);
	
		 tfid = new JLabel(""+number);
		 tfid.setBounds(400,125,200,30);
		 tfid.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(tfid);
		 
		 jd = new JLabel("Order ID ");
		 jd.setBounds(190,160,400,50);
		 jd.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(jd);
	
		 jda = new JTextField();
		 jda.setBounds(400,175,200,30);
		 add(jda);
	
	
		 amount = new JLabel("PAYMENT AMOUNT");
		 amount.setBounds(190,210,400,50);
		 amount.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(amount);
		
		 tfamount = new JTextField();
		 tfamount.setBounds(400,225,200,30);
		 add(tfamount);	
	
		 kd = new JLabel("Payment Date ");
		 kd.setBounds(190,260,400,50);
		 kd.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(kd);
	
		  tkd= new JDateChooser();
		 tkd.setBounds(400,275,200,30);
		 add(tkd);
	
		 add = new JLabel("PAYMENT method");
		 add.setBounds(190,310,400,50);
		 add.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(add);
	
		 addtext =new JTextField();
		 addtext.setBounds(400,325,200,30);
		 add(addtext);
    
    
    
		  submit= new JButton("SUBMIT");
		 submit.setBounds(400,370,90,25);
		 submit.setBackground(Color.BLACK);
		 submit.setForeground(Color.WHITE);
		 submit.addActionListener(this);
		 add(submit);

		 cancle = new JButton("Cancle");
		  cancle.setBounds(510,370,90,25);
		  cancle.setBackground(Color.BLACK);
		  cancle.setForeground(Color.WHITE);
		  cancle.addActionListener(this);
		  add(cancle);
	setVisible(true);
		

}
	public static void main(String[] args) {
		
    new payments();
}
	
	public void actionPerformed(ActionEvent e) {
		
		String payment_Id = tfid.getText();
		String order_Id = jda.getText();
		String amount = tfamount.getText();
		String payment_date =tkd.getDateFormatString();
		String payment_method = addtext.getText();
		if(e.getSource()==submit) {
		try {	
			
			
		String query = "insert into payments value ('"+payment_Id+"','"+order_Id+"','"+amount+"','"+payment_date+"','"+payment_method+"')";
//		insert into payments value (payment_Id, order_Id,amount,payment_date,payment_method 
		int rs = c.s.executeUpdate(query); 
		
		}
		catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
			JOptionPane.showMessageDialog(null, "payment added successfully");
			 setVisible(false);
		}
		else if(e.getSource()==cancle) {
			setVisible(false);
			new frontPage();
		}
		
	}
		
	
}
