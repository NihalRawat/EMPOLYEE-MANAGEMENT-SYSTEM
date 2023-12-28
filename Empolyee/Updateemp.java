package Empolyee;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Updateemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField empid;
	private JTextField desig;
	private JTextField email;
	private JTextField address;
	private JTextField dob;
	private JTextField name;
	private JTextField addhar;
	private JTextField hq;
	private JTextField phone;
	private JTextField salary;
	private JTextField father;

	public void setEmpid(String empid) {
		this.empid.setText(empid);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateemp frame = new Updateemp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Updateemp() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 80, 1175, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateEmpolyeeDetails = new JLabel("         UPDATE EMPOLYEE DETAILS ");
		lblUpdateEmpolyeeDetails.setOpaque(true);
		lblUpdateEmpolyeeDetails.setForeground(Color.WHITE);
		lblUpdateEmpolyeeDetails.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblUpdateEmpolyeeDetails.setBackground(Color.BLACK);
		lblUpdateEmpolyeeDetails.setBounds(168, 0, 534, 82);
		contentPane.add(lblUpdateEmpolyeeDetails);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 142, 230, 47);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE OF BIRTH");
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(10, 198, 230, 56);
		lblNewLabel_1_1.setOpaque(true);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ADDRESS");
		lblNewLabel_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(10, 264, 230, 56);
		lblNewLabel_1_1_1.setOpaque(true);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL");
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1.setBounds(10, 334, 230, 56);
		lblNewLabel_1_1_1_1.setOpaque(true);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DESIGNATION");
		lblNewLabel_1_1_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1.setBounds(10, 407, 230, 56);
		lblNewLabel_1_1_1_1_1.setOpaque(true);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("EMP--ID ");
		lblNewLabel_1_1_1_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 473, 230, 56);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setOpaque(true);
		
		empid = new JTextField();
		empid.setForeground(new Color(64, 0, 64));
		empid.setFont(new Font("Tahoma", Font.BOLD, 35));
		empid.setColumns(10);
		empid.setBackground(new Color(64, 0, 64));
		empid.setBounds(267, 485, 277, 47);
		contentPane.add(empid);
		empid.setEnabled(false);
		
		desig = new JTextField();
		desig.setFont(new Font("Tahoma", Font.PLAIN, 31));
		desig.setColumns(10);
		desig.setBackground(Color.WHITE);
		desig.setBounds(267, 416, 277, 47);
		contentPane.add(desig);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 31));
		email.setColumns(10);
		email.setBackground(Color.WHITE);
		email.setBounds(267, 339, 277, 47);
		contentPane.add(email);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 31));
		address.setColumns(10);
		address.setBackground(Color.WHITE);
		address.setBounds(267, 274, 277, 47);
		contentPane.add(address);
		
		dob = new JTextField();
		dob.setFont(new Font("Tahoma", Font.PLAIN, 31));
		dob.setColumns(10);
		dob.setBackground(Color.WHITE);
		dob.setBounds(267, 207, 277, 47);
		contentPane.add(dob);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 31));
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		name.setBounds(267, 147, 277, 47);
		contentPane.add(name);
		
		JLabel lblNewLabel_1_2 = new JLabel("FATHER NAME");
		lblNewLabel_1_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(639, 142, 205, 56);
		lblNewLabel_1_2.setOpaque(true);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("SALARY");
		lblNewLabel_1_2_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_1.setBounds(639, 207, 205, 47);
		lblNewLabel_1_2_1.setOpaque(true);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("PHONE-NO");
		lblNewLabel_1_2_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_2.setBounds(639, 264, 205, 56);
		lblNewLabel_1_2_2.setOpaque(true);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("HIGHEST QUALIFICATON");
		lblNewLabel_1_2_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_3.setBounds(639, 330, 222, 56);
		lblNewLabel_1_2_3.setOpaque(true);
		contentPane.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("AADHAR NO");
		lblNewLabel_1_2_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2_4.setBounds(639, 407, 205, 56);
		lblNewLabel_1_2_4.setOpaque(true);
		contentPane.add(lblNewLabel_1_2_4);
		
		addhar = new JTextField();
		addhar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		addhar.setColumns(10);
		addhar.setBounds(869, 416, 281, 43);
		contentPane.add(addhar);
		
		hq = new JTextField();
		hq.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hq.setColumns(10);
		hq.setBounds(871, 337, 269, 43);
		contentPane.add(hq);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 30));
		phone.setColumns(10);
		phone.setBounds(869, 264, 281, 43);
		contentPane.add(phone);
		
		salary = new JTextField();
		salary.setFont(new Font("Tahoma", Font.PLAIN, 30));
		salary.setColumns(10);
		salary.setBounds(869, 203, 281, 43);
		contentPane.add(salary);
		
		father = new JTextField();
		father.setFont(new Font("Tahoma", Font.PLAIN, 30));
		father.setColumns(10);
		father.setBounds(869, 147, 281, 43);
		contentPane.add(father);
		
		JButton btnNewButton = new JButton("Click Here to Update Details");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
					String sql = "update details set name='"+name.getText()+"', db='"+dob.getText()+"', address='"+address.getText()+"', email='"+email.getText()+"', desig='"+desig.getText()+"', father='"+father.getText()+"', hq='"+hq.getText()+"', salary="+salary.getText()+", phone="+phone.getText()+", addhar="+addhar.getText()+" WHERE empid="+empid.getText()+"";
		            PreparedStatement st = con.prepareStatement(sql);
//		            st.setString(1, name.getText());
//		            st.setString(2, dob.getText());
//		            st.setString(3, address.getText());
//		            st.setString(4, email.getText());
//		            st.setString(5, desig.getText());
//		            st.setString(6, father.getText());
//		            st.setString(7, hq.getText());
//		            st.setFloat(8, Float.parseFloat(salary.getText()));  // Assuming salary is a float
//		            st.setLong(9, Long.parseLong(phone.getText()));  // Assuming phone is a long
//		            st.setLong(10, Long.parseLong(addhar.getText()));  // Assuming addhar is a long
//		            st.setString(11, empidText());  // Set the empid parameter last
					int row=st.executeUpdate(sql);
					if(row>0) {
						JOptionPane.showMessageDialog(null,"Updated Succesfully ++");
						EditEmpolyee ep=new EditEmpolyee();
						ep.setVisible(true);
						dispose();
					}else {					
						JOptionPane.showMessageDialog(null, "Employee details not found for ID: " + empid);
					}
					
				}catch(Exception ex) {
					//ex.printStackTrace();
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		btnNewButton.setBounds(655, 570, 495, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmpolyee ep=new EditEmpolyee();
				ep.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnNewButton_1.setBounds(462, 570, 170, 67);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Updateemp.class.getResource("/icons/front.jpg")));
		lblNewLabel.setBounds(12, 0, 1149, 643);
		contentPane.add(lblNewLabel);
		
		
	}
/*
	public void populatedFields(String empid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
			Statement st=con.createStatement();
			String sql="Select * from details where empid='"+empid+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				name.setText(rs.getString("name"));
				dob.setText(rs.getString("db"));
				address.setText(rs.getString("address"));
				email.setText(rs.getString("email"));
				desig.setText(rs.getString("desig"));
				father.setText(rs.getString("father"));
				hq.setText(rs.getString("hq"));
				salary.setText(String.valueOf(rs.getFloat("salary")));
				phone.setText(String.valueOf(rs.getLong("phone")));
				addhar.setText(String.valueOf(rs.getLong("addhar")));
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Employee details not found for ID: " + empid);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}*/
	
}
