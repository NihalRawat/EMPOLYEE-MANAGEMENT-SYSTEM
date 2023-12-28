package Empolyee;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JTextField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 1047, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user12 = new JLabel("Username");
		user12.setFont(new Font("Tahoma", Font.BOLD, 30));
		user12.setForeground(new Color(0, 0, 0));
		user12.setBounds(50, 110, 217, 77);
		contentPane.add(user12);
		
		JLabel pasqw2 = new JLabel("Password");
		pasqw2.setForeground(Color.BLACK);
		pasqw2.setFont(new Font("Tahoma", Font.BOLD, 30));
		pasqw2.setBounds(50, 220, 217, 77);
		contentPane.add(pasqw2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
				Statement st=con.createStatement();
				String sql="Select * from dataemp where userid='"+user.getText().toString()+"' and password='"+password.getText().toString()+"'";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null,"Login... Sucess...");
					EditEmpolyee ep=new EditEmpolyee();
					ep.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect password");
				}con.close();
			}
			
			catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 44));
		btnNewButton.setBounds(149, 344, 260, 77);
		contentPane.add(btnNewButton);
		btnNewButton.setOpaque(true);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.BOLD, 30));
		user.setBounds(259, 122, 349, 54);
		contentPane.add(user);
		user.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 31));
		password.setColumns(10);
		password.setBounds(259, 231, 349, 54);
		contentPane.add(password);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/icons/second.jpg")));
		lblNewLabel.setBounds(647, 39, 349, 337);
		
		contentPane.add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnExit.setOpaque(true);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 44));
		btnExit.setBackground(Color.BLACK);
		btnExit.setBounds(432, 344, 190, 77);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("        Admin-Login ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1.setBounds(223, 0, 371, 57);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setOpaque(true);
		
	}
}
