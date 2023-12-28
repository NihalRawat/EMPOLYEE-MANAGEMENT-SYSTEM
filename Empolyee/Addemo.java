package Empolyee;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
public class Addemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField dateob;
	private JTextField address;
	private JTextField email;
	private JTextField designation;
	private JTextField eid;
	private JTextField fname;
	private JTextField salary;
	private JTextField pno;
	private JTextField aadhar;
	private JTextField hqf;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addemo frame = new Addemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Addemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1268, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         ADD EMPOLYEE DETAILS ");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(272, 28, 534, 82);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(106, 170, 111, 56);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE OF BIRTH");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(104, 226, 230, 56);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ADDRESS");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(105, 292, 152, 56);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1.setBounds(105, 358, 152, 56);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DESIGNATION");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1.setBounds(105, 435, 212, 56);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("EMP--ID ");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1_1.setBounds(106, 501, 212, 56);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		name = new JTextField();
		name.setBackground(new Color(255, 255, 255));
		name.setFont(new Font("Tahoma", Font.PLAIN, 31));
		name.setBounds(371, 175, 277, 47);
		contentPane.add(name);
		name.setColumns(10);
		
		dateob = new JTextField();
		dateob.setFont(new Font("Tahoma", Font.PLAIN, 31));
		dateob.setColumns(10);
		dateob.setBackground(Color.WHITE);
		dateob.setBounds(371, 235, 277, 47);
		contentPane.add(dateob);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 31));
		address.setColumns(10);
		address.setBackground(Color.WHITE);
		address.setBounds(371, 302, 277, 47);
		contentPane.add(address);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 31));
		email.setColumns(10);
		email.setBackground(Color.WHITE);
		email.setBounds(371, 367, 277, 47);
		contentPane.add(email);
		
		designation = new JTextField();
		designation.setFont(new Font("Tahoma", Font.PLAIN, 31));
		designation.setColumns(10);
		designation.setBackground(Color.WHITE);
		designation.setBounds(371, 444, 277, 47);
		contentPane.add(designation);
		
		eid = new JTextField();
		eid.setFont(new Font("Tahoma", Font.PLAIN, 31));
		eid.setColumns(10);
		eid.setBackground(Color.WHITE);
		eid.setBounds(371, 513, 277, 47);
		contentPane.add(eid);
		
		JButton btnNewButton = new JButton("Create-Id");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmpolyee ep=new EditEmpolyee();
				ep.setVisible(true);
				dispose();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
					String query="insert into details (name,db,address,email,desig,empid,father,salary,phone,hq,addhar) values ('"+name.getText().toString()+"','"+dateob.getText().toString()+"','"+address.getText().toString()+"','"+email.getText().toString()+"','"+designation.getText().toString()+"','"+eid.getText()+"','"+fname.getText().toString()+"','"+salary.getText()+"','"+pno.getText()+"','"+hqf.getText().toString()+"','"+aadhar.getText()+"');";
					Statement st=con.createStatement();
					int i=st.executeUpdate(query);
					if(i>0) {
						JOptionPane.showMessageDialog(null,"employee details added");
					}
					else
						JOptionPane.showMessageDialog(rootPane, "Bad request..!!");

				}
				catch(Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null,"error creating account ");	
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(838, 558, 192, 82);
		btnNewButton.setOpaque(true);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmpolyee up=new EditEmpolyee();
				up.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(1079, 558, 143, 82);
		btnBack.setOpaque(true);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1_2 = new JLabel("FATHER NAME");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(743, 170, 205, 56);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("SALARY");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_1.setBounds(743, 226, 143, 56);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("PHONE-NO");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_2.setBounds(743, 292, 170, 56);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("HIGHEST QUALIFICATON");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_3.setBounds(743, 358, 222, 56);
		contentPane.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("AADHAR NO");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_4.setBounds(743, 435, 175, 56);
		contentPane.add(lblNewLabel_1_2_4);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 30));
		fname.setBounds(973, 175, 281, 43);
		contentPane.add(fname);
		fname.setColumns(10);
		
		salary = new JTextField();
		salary.setFont(new Font("Tahoma", Font.PLAIN, 30));
		salary.setColumns(10);
		salary.setBounds(973, 231, 281, 43);
		contentPane.add(salary);
		
		pno = new JTextField();
		pno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pno.setColumns(10);
		pno.setBounds(973, 292, 281, 43);
		contentPane.add(pno);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		aadhar.setColumns(10);
		aadhar.setBounds(973, 444, 281, 43);
		contentPane.add(aadhar);
		
		hqf = new JTextField();
		hqf.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hqf.setColumns(10);
		hqf.setBounds(975, 365, 269, 43);
		contentPane.add(hqf);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Addemo.class.getResource("/icons/add_employee.jpg")));
		lblNewLabel_2.setBounds(0, -28, 1254, 668);
		contentPane.add(lblNewLabel_2);
	}
}
