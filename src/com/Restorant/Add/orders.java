package com.Restorant.Add;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.Restorent.DB.connectivity;

import Restorant.frontPage;

import java.time.LocalDate;

public class orders extends JFrame implements ActionListener {
	JLabel i, j, k, l, m, n, o;
	JTextField jj, ll, kk, mm, nn, oo;
	int a;
	JButton submit, cancle;

	connectivity c = new connectivity();

	public orders() {

		setLayout(null);
		setSize(1000, 700);
		setLocation(250, 50);

		i = new JLabel("Welcome To Orders");
		add(i);
		i.setFont(new Font("Helvetica", Font.PLAIN, 40));
		i.setForeground(Color.BLACK);
		i.setBounds(300, 1, 500, 100);

		j = new JLabel("Order ID");
		j.setBounds(190, 100, 400, 50);
		j.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(j);

		jj = new JTextField();
		jj.setBounds(400, 115, 200, 30);
		add(jj);

		k = new JLabel("Customer ID");
		k.setBounds(190, 150, 400, 50);
		k.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(k);

		kk = new JTextField();
		kk.setBounds(400, 165, 200, 30);
		add(kk);

		l = new JLabel("Order date");
		l.setBounds(190, 200, 400, 50);
		l.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(l);

		ll = new JTextField();
		ll.setBounds(400, 215, 200, 30);
		add(ll);

		m = new JLabel("Order time");
		m.setBounds(190, 250, 400, 50);
		m.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(m);

		mm = new JTextField();
		mm.setBounds(400, 265, 200, 30);
		add(mm);

		n = new JLabel("Item ID");
		n.setBounds(190, 300, 400, 50);
		n.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(n);

		nn = new JTextField();
		nn.setBounds(400, 315, 200, 30);
		add(nn);

		o = new JLabel("Total price");
		o.setBounds(190, 350, 400, 50);
		o.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(o);

		oo = new JTextField();
		oo.setBounds(400, 365, 200, 30);
		add(oo);

		submit = new JButton("SUBMIT");
		submit.setBounds(350, 420, 100, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);

		cancle = new JButton("Cancle");
		cancle.setBounds(500, 420, 100, 30);
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.addActionListener(this);
		add(cancle);

		setVisible(true);

	}

	public static void main(String[] args) {
		new orders();
		System.out.print("hello ");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {

			String order_ID = jj.getText();
			String customer_ID = kk.getText();
			String Order_date = ll.getText();
			String Order_time = mm.getText();
			String item_id = nn.getText();
			String total_price = oo.getText();
			try {

				String query = "insert into Orders value('" + order_ID + "','" + customer_ID + "','" + Order_date
						+ "','" + Order_time + "','" + item_id + "','" + total_price + "')";
				int rs = c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "orders added added successfully");
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();

			}

		}
		if (e.getSource() == cancle) {
			setVisible(false);
			new frontPage();
		}

	}

}
