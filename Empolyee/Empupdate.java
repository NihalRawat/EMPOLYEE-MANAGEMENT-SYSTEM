package Empolyee;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Empupdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField empid;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empupdate frame = new Empupdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Empupdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Empolyees Details");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(139, 10, 491, 61);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter Empolyee_ID to Update=>");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 31));
		btnNewButton.setBounds(10, 162, 552, 81);
		btnNewButton.setOpaque(true);
		contentPane.add(btnNewButton);
		
		empid = new JTextField();
		empid.setBackground(new Color(255, 255, 255));
		empid.setFont(new Font("Tahoma", Font.BOLD, 30));
		empid.setBounds(572, 162, 262, 81);
		contentPane.add(empid);
		empid.setColumns(10);
		
		JButton btnClickHereTo = new JButton("Click Here to Proced");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
				Statement st=con.createStatement();
				String sql="Select * from details where empid='"+empid.getText()+"'";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null,"ID found!! Click Here to Proced...");
					Updateemp up=new Updateemp();
					up.setEmpid(empid.getText());
					//up.populatedFields(empid.getText());
					up.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Empolyee ID ");
				}con.close();
			}
			
			catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 31));
		btnClickHereTo.setBackground(new Color(128, 255, 0));
		btnClickHereTo.setBounds(241, 336, 415, 81);
		contentPane.add(btnClickHereTo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Empupdate.class.getResource("/icons/print.jpg")));
		lblNewLabel_1.setBounds(0, 0, 595, 544);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmpolyee ep=new EditEmpolyee();
				ep.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 38));
		btnNewButton_1.setBounds(692, 336, 142, 81);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Empupdate.class.getResource("/icons/print.jpg")));
		lblNewLabel_2.setBounds(594, 0, 250, 544);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
