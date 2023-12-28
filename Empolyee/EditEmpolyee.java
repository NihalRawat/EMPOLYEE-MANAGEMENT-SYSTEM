package Empolyee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditEmpolyee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmpolyee frame = new EditEmpolyee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditEmpolyee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 1131, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNewLabel.setBounds(125, 27, 828, 89);
		contentPane.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		
		JButton btnNewButton = new JButton("VIEW EMPLOYEES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewemp ep=new Viewemp();
				ep.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton.setBounds(92, 196, 331, 89);
		contentPane.add(btnNewButton);
		
		JButton btnAddEmployee = new JButton("ADD EMPLOYEE");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addemo ad=new Addemo();
				ad.setVisible(true);
				dispose();
			}
		});
		btnAddEmployee.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnAddEmployee.setBackground(new Color(128, 255, 128));
		btnAddEmployee.setBounds(524, 196, 331, 89);
		contentPane.add(btnAddEmployee);
		btnAddEmployee.setOpaque(true);
		
		JButton btnUpdateEmployee = new JButton("UPDATE EMPLOYEE");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empupdate up=new Empupdate();
				up.setVisible(true);
				dispose();
			}
		});
		btnUpdateEmployee.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnUpdateEmployee.setBackground(new Color(255, 255, 0));
		btnUpdateEmployee.setBounds(92, 367, 331, 89);
		contentPane.add(btnUpdateEmployee);
		btnUpdateEmployee.setOpaque(true);
		
		JButton btnDeleteEmployee = new JButton("DELETE EMPLOYEE");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Removeemp rp=new Removeemp();
				rp.setVisible(true);
				dispose();
			}
		});
		btnDeleteEmployee.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnDeleteEmployee.setBackground(new Color(255, 0, 0));
		btnDeleteEmployee.setBounds(524, 367, 331, 89);
		contentPane.add(btnDeleteEmployee);
		btnDeleteEmployee.setOpaque(true);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login al=new Login();
				al.setVisible(true);
				dispose();
				
			}
		});
		btnExit.setForeground(new Color(255, 255, 0));
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 59));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(327, 529, 331, 89);
		contentPane.add(btnExit);
		btnExit.setOpaque(true);
		
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(EditEmpolyee.class.getResource("/icons/home.jpg")));
		lblNewLabel1.setBounds(0, 0, 1117, 676);
		contentPane.add(lblNewLabel1);
	}
}
