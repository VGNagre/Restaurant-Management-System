package com.Restorant.Add;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Pattern;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.Restorent.DB.connectivity;

import Restorant.frontPage;

public class customers extends JFrame implements ActionListener{
	connectivity c = new connectivity();

	JLabel i,iD,cid,name,address,contact;
    JTextField cname,cadd,cno;
    JButton submit,cancle;
    String con_no;
//    Random ran = new Random();
    
	public customers() {
	setLayout(null);
	setSize(1000,700);
	setLocation(250,50);
	
	 i = new JLabel("Welcome to the customers");
	add(i);
	i.setFont(new Font("Helvetica",Font.PLAIN,40));
	i.setForeground(Color.BLACK);
	i.setBounds(300,1,500,100);
	
	
//	iD = new JLabel("Customers ID");
//	iD.setBounds(190,110,400,50);
//	iD.setFont(new Font("Helvetica",Font.PLAIN,17));
//	iD.setForeground(Color.BLACK);
//	add(iD);
//
//	cid = new JLabel();
//	cid.setBounds(400,125,200,30);
//	cid.setFont(new Font("Helvetica",Font.PLAIN,17));
//	cid.setForeground(Color.BLACK);
//	add(cid);
	
	name = new JLabel("Customers name");
	name.setBounds(190,160,400,50);
	name.setFont(new Font("Helvetica",Font.PLAIN,17));
	name.setForeground(Color.BLACK);
	add(name);
	
	cname = new JTextField();
	cname.setBounds(400,175,200,30);
	add(cname);
	
    address = new JLabel("Customers Email");
	address.setBounds(190,210,400,50);
	address.setFont(new Font("Helvetica",Font.PLAIN,17));
	address.setForeground(Color.BLACK);
	add(address);
	
	cadd = new JTextField();
	cadd.setBounds(400,225,200,30);
	add(cadd);
	
	 contact = new JLabel("Contact");
	 contact.setBounds(190,260,400,50);
	 contact.setFont(new Font("Helvetica",Font.PLAIN,17));
	 contact.setForeground(Color.BLACK);
		add(contact);
		
		cno = new JTextField();
		cno.setBounds(400,275,200,30);
		add(cno);
	
	   submit=new JButton("Submit");
	   submit.setBounds(400,330,90,25);
	   submit.setBackground(Color.BLACK);
	   submit.setForeground(Color.WHITE);
	   submit.addActionListener(this);
	   add(submit);
	   
	  cancle = new JButton("Cancle");
	  cancle.setBounds(510,330,90,25);
	  cancle.setBackground(Color.BLACK);
	  cancle.setForeground(Color.WHITE);
	  cancle.addActionListener(this);
	  add(cancle);
	
	setVisible(true);
	 }
	 
	        
	 
	 
	public static void main(String[] args) {
		new customers();

	    
	}
//	private void jTextFieldKeyPressed(java.awt.event.KeyEvent evt){
//		JTextComponent jTextField1;
//		 con_no=cno.getText(); 
//		int length= (int) con_no.length();
//		char c=evt.getKeyChar();
//		if(evt.getKeyChar()>='0' && evt.getKeyChar ()<='9') {
//			if (length<10) {
//				
//			
//				cno.setEditable(true);
//			}
//		else {
//			cno.setEditable(false);
//				
//			}
			
				
//		}else {
//			if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
//				phone.setEditable(true);
				
//			}else {
//				phone.setEditable(false);
//		}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit) {
		try {
			
			String Cnames = cname.getText();
			String contactnos = cno.getText();
			String emails = cadd.getText();
			String CustomerIDs = cid.getText();
	
			char fn = 0;
			for(int i=0;i<=1;i++) {
				fn=Cnames.charAt(0);
			}
			char fo = 0;
			for(int i=0;i<=1;i++) {
				fo=Cnames.charAt(1);
			}
			char d = 0,b=0;
			for(int i=0;i<=1;i++) {
				d=contactnos.charAt(0); }	
			for(int i=0;i<=1;i++) {
				b=contactnos.charAt(1);
				}	
			
	 CustomerIDs= Character.toString(fn)+Character.toString(fo)+Character.toString(d)+Character.toString(b);
			
			 String query ="insert into Customers value('"+CustomerIDs+"','"+Cnames+"','"+emails+"','"+contactnos+"');";
			 c.s.execute(query);

			 JOptionPane.showMessageDialog(null, "Customer added successfully and CustomerID is '"+CustomerIDs+"'");
			 setVisible(false);
			 
		 }catch(Exception e1){
			 e1.printStackTrace();				
	  }
		}else if(e.getSource()==cancle) {
			setVisible(false);
			new frontPage();
		}
	
	}

//    public static boolean isValid(String email){  
//    String emailFormate ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."  
//            + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";  
//      
//    Pattern p = Pattern.compile(emailFormate);  
//    if(email == null){  
//    return false;  
//    }   
//    return p.matcher(email).matches();  
//}
	
}

