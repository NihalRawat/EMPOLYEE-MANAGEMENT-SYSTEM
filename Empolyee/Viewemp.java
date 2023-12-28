package Empolyee;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Viewemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField search;
//	JTable tblData =table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewemp frame = new Viewemp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Viewemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1126, 665);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                            EMPOLYEES-RECORDS ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(46, 10, 1032, 64);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("SEARCH-Eid=>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
					Statement st=con.createStatement();
					String sql="Select * from details where empid='"+search.getText()+"'";
					ResultSet rs=st.executeQuery(sql);
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);  // Clear existing data

                    if (rs.next()) {
                        String[] row = {
                            rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                            rs.getString(9), rs.getString(10), rs.getString(11)
                        };
                        model.addRow(row);
                    } else {
                        JOptionPane.showMessageDialog(null, "No employee found with that ID.");
                    }

                    rs.close();
                    st.close();
                    con.close();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(0, 106, 248, 49);
		contentPane.add(btnNewButton);
		
		JButton btnViewAll = new JButton("VIEW ALL");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empproject","root","0899");
					Statement st=con.createStatement();
					String sql="Select * from details";
					ResultSet rs=st.executeQuery(sql);
					//now creating resultdata to know column
					ResultSetMetaData rd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					  
					int cols=rd.getColumnCount();
					String[] colname=new String[cols];
					for(int i=0; i<cols; i++)
						colname[i]=rd.getColumnName(i+1);
					model.setColumnIdentifiers(colname);
					//displayin the code using jtable
					String name,db,address,email,father,desig,hq;
					String empid,salary,phone,addhar;
//					int empid,salary,phone;
					while(rs.next()) {
						name=rs.getString(1);
						db=rs.getString(2);
						address=rs.getString(3);
						email=rs.getString(4);
						desig=rs.getString(5);
						empid=rs.getString(6);
						father=rs.getString(7);
						salary=rs.getString(8);
						phone=rs.getString(9);
						hq=rs.getString(10);
						addhar=rs.getString(11);
						String[] row= {name,db,address,email,desig,empid,father,salary,phone,hq,addhar};
						model.addRow(row);
						
					}
					
					st.close();
					con.close();
				}
				
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnViewAll.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnViewAll.setBackground(new Color(255, 255, 128));
		btnViewAll.setBounds(448, 106, 192, 49);
		contentPane.add(btnViewAll);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				table.print();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnPrint.setForeground(new Color(255, 255, 255));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnPrint.setBackground(new Color(0, 0, 0));
		btnPrint.setBounds(697, 106, 166, 49);
		btnPrint.setOpaque(true);
		contentPane.add(btnPrint);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmpolyee ep=new EditEmpolyee();
				ep.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(912, 106, 166, 49);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 250, 1102, 368);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setBackground(new Color(192, 192, 192));
		
		search = new JTextField();
		search.setForeground(new Color(0, 0, 0));
		search.setBackground(new Color(255, 255, 255));
		search.setFont(new Font("Times New Roman", Font.BOLD, 30));
		search.setBounds(253, 108, 145, 49);
		contentPane.add(search);
		search.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Viewemp.class.getResource("/icons/view.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1112, 628);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
