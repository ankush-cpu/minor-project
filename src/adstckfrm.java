import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class adstckfrm extends JFrame {

	protected static final Component adstckfrm = null;
	private JPanel contentPane;
	private JTextField f1;
	private JTextField f2;
	private JTextField f3;
	private JTextField f4;
	private JTextField f5;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adstckfrm frame = new adstckfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adstckfrm() {
		setTitle("Add New Product Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 424);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Batch No:");
		l1.setForeground(new Color(0, 0, 255));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l1.setBounds(61, 35, 95, 24);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Manufacture Date:");
		l2.setForeground(new Color(0, 0, 255));
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2.setBounds(61, 79, 184, 24);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Expiry Date:");
		l3.setForeground(new Color(0, 0, 255));
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3.setBounds(61, 127, 143, 24);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Product Name:");
		l4.setForeground(new Color(0, 0, 255));
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4.setBounds(61, 172, 143, 24);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Stock Available:");
		l5.setForeground(new Color(0, 0, 255));
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5.setBounds(61, 218, 143, 24);
		contentPane.add(l5);
		
		f1 = new JTextField();
		l1.setLabelFor(f1);
		f1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f1.setBackground(Color.LIGHT_GRAY);
		f1.setBounds(263, 35, 307, 24);
		contentPane.add(f1);
		f1.setColumns(10);
		
		f2 = new JTextField();
		l2.setLabelFor(f2);
		f2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f2.setBackground(Color.LIGHT_GRAY);
		f2.setBounds(263, 79, 307, 24);
		contentPane.add(f2);
		f2.setColumns(10);
		
		f3 = new JTextField();
		l3.setLabelFor(f3);
		f3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f3.setBackground(Color.LIGHT_GRAY);
		f3.setBounds(263, 127, 307, 24);
		contentPane.add(f3);
		f3.setColumns(10);
		
		f4 = new JTextField();
		l4.setLabelFor(f4);
		f4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f4.setBackground(Color.LIGHT_GRAY);
		f4.setBounds(263, 172, 307, 24);
		contentPane.add(f4);
		f4.setColumns(10);
		
		f5 = new JTextField();
		l5.setLabelFor(f5);
		f5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f5.setBackground(Color.LIGHT_GRAY);
		f5.setBounds(263, 218, 307, 24);
		contentPane.add(f5);
		f5.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bn=f1.getText();
				String mf=f2.getText();
				String ex=f3.getText();
				String pr=f4.getText();
				String sto=f5.getText();
					
			
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
					Statement st=con.createStatement();
				if(st != null)
				{
					System.out.println("connection made successfully");
				}
				else
				{
					System.out.println("connection failure");
				}
				String qr="INSERT INTO med_prod VALUES ('"+bn+"', '"+mf+"', '"+ex+"', '"+pr+"', '"+sto+"')";
				int x= st.executeUpdate(qr);
				if(x==0)
				{
					JOptionPane.showMessageDialog(adstckfrm,"stock update failure");
				}
				else
				{
					JOptionPane.showMessageDialog(adstckfrm,"new stock added successfully");
					usrfrm lgfrm=new usrfrm(null,null);
					lgfrm.setVisible(true);
				}
				}	
				catch(Exception f)
				{
					System.out.println(f);
				}
			}
			
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton.setBounds(243, 285, 143, 39);
		contentPane.add(btnNewButton);
	}
}
