package Empolyee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.Timer;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 925, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("           EMPLOYEE MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_1.setBounds(43, 10, 868, 83);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Click Here To Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Login().setVisible(true);
			dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(43, 430, 551, 68);
		contentPane.add(btnNewButton);
		btnNewButton.setOpaque(true);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnNewButton_1.setBounds(664, 430, 181, 67);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/icons/front.jpg")));
		lblNewLabel.setBounds(10, 0, 928, 572);
		contentPane.add(lblNewLabel);
		
	
		
	}
}
