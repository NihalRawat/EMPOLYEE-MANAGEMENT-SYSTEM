package Empolyee;
import java.sql.*;
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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Removeemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField empid;
	private JTextField name;
	private JTextField email;
	private JTextField phone;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Removeemp frame = new Removeemp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Removeemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1068, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search and Delete Empolyee Records");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel.setBounds(160, 10, 671, 53);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Empolyee_ID =>");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(84, 127, 233, 46);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		empid = new JTextField();
		empid.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		empid.setBounds(327, 123, 377, 46);
		contentPane.add(empid);
		empid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name :");
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(89, 218, 226, 46);
		lblNewLabel_1_1.setOpaque(true);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email :");
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel_1_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setBounds(89, 297, 228, 53);
		lblNewLabel_1_2.setOpaque(true);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone No.");
		lblNewLabel_1_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel_1_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setBounds(89, 377, 226, 53);
		lblNewLabel_1_3.setOpaque(true);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("Delete Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
					Statement st=con.createStatement();
					String sql="delete from details where empid="+empid.getText()+"";
					int rs=st.executeUpdate(sql);
					
					if(rs>0) {
						JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
						EditEmpolyee ep=new EditEmpolyee();
						ep.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Details not found");
					}
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}	
			}
		});
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 40));
		btnNewButton.setBounds(748, 455, 296, 63);
		btnNewButton.setOpaque(true);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setForeground(new Color(0, 0, 0));
		name.setFont(new Font("Trebuchet MS", Font.PLAIN, 31));
		name.setBounds(327, 214, 377, 53);
		contentPane.add(name);
		name.setColumns(10);
		name.setEnabled(false);
		
		email = new JTextField();
		email.setFont(new Font("Trebuchet MS", Font.PLAIN, 31));
		email.setColumns(10);
		email.setBounds(327, 297, 377, 53);
		contentPane.add(email);
		email.setEnabled(false);
		
		phone = new JTextField();
		phone.setFont(new Font("Trebuchet MS", Font.PLAIN, 31));
		phone.setColumns(10);
		phone.setBounds(327, 377, 377, 53);
		contentPane.add(phone);
		phone.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("Search....");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
					Statement st=con.createStatement();
					String sql="select * from details where empid="+empid.getText()+"";
					ResultSet rs=st.executeQuery(sql);
					
					if(rs.next()) {
						name.setText(rs.getString("name"));
						email.setText(rs.getString("email"));
						phone.setText(rs.getString("phone"));
					}
					else {
						JOptionPane.showMessageDialog(null,"Details not found");
					}
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"SYSTEM ERROR");
				}
			}

		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnNewButton_1.setBounds(714, 123, 160, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmpolyee ep=new EditEmpolyee();
				ep.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		btnNewButton_2.setBounds(544, 455, 180, 63);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Removeemp.class.getResource("/icons/delete.png")));
		lblNewLabel_2.setBounds(0, 0, 1054, 528);
		contentPane.add(lblNewLabel_2);
		
		
		
	}
}
