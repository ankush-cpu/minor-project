import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class loginfrm extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JPasswordField passwd;
	protected Component loginfrm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginfrm frame = new loginfrm();
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
	public loginfrm() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("User ID:");
		l1.setForeground(new Color(0, 128, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l1.setBounds(262, 38, 95, 21);
		contentPane.add(l1);
		
		uid = new JTextField();
		uid.setToolTipText("Enter your user ID");
		l1.setLabelFor(uid);
		uid.setBackground(Color.LIGHT_GRAY);
		uid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		uid.setBounds(124, 66, 386, 29);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JLabel l2 = new JLabel("Password:");
		l2.setForeground(new Color(0, 128, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2.setBounds(251, 129, 95, 29);
		contentPane.add(l2);
		
		passwd = new JPasswordField();
		passwd.setToolTipText("Enter your password");
		l2.setLabelFor(passwd);
		passwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwd.setBackground(Color.LIGHT_GRAY);
		passwd.setBounds(124, 161, 386, 29);
		contentPane.add(passwd);
		
		JButton lgn = new JButton("LOGIN");
		lgn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1=uid.getText();
				char[] pass=passwd.getPassword();
				String p=new String(pass);
				String name1="";
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
				PreparedStatement ps= con.prepareStatement("SELECT * FROM med_login WHERE uid='"+id1+"'AND passwd='"+p+"' ");
				ResultSet rs=ps.executeQuery();
				PreparedStatement ps1= con.prepareStatement("SELECT * FROM med_user WHERE uid='"+id1+"'AND passwd='"+p+"' ");
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next())
				{
					name1=rs1.getString("name");
				}
						int c=0;
						while(rs.next())
						{
							c++;
						}
						if(c>0)
						{
							JOptionPane.showMessageDialog(loginfrm,"user login successful");
							usrfrm uf=new usrfrm(id1,name1);
							uf.setVisible(true);
						}
						else if(id1.equals("ADMIN") && p.equals("admin"))
						{
							JOptionPane.showMessageDialog(loginfrm,"ADMIN login successful");
							adminfrm af=new adminfrm();
							af.setVisible(true);
						}
							else
							{
							    JOptionPane.showMessageDialog(loginfrm,"invalid user!");
							}
				}
				catch(Exception f)
				{
					System.out.println(f);
				}
			}
				
		});
		lgn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lgn.setForeground(new Color(0, 128, 0));
		lgn.setBounds(144, 232, 135, 34);
		contentPane.add(lgn);
		
		JButton reg = new JButton("NEW USER");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regfrm rf=new regfrm();
				rf.regchk();
			}
		});
		reg.setFont(new Font("Times New Roman", Font.BOLD, 20));
		reg.setForeground(new Color(0, 128, 0));
		reg.setBounds(335, 233, 152, 33);
		contentPane.add(reg);
		
		JButton fpasswd = new JButton("Forgot Password?");
		fpasswd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fpasswdfrm fpas=new fpasswdfrm();
				fpas.setVisible(true);
			}
		});
		fpasswd.setFont(new Font("Times New Roman", Font.BOLD, 21));
		fpasswd.setForeground(new Color(0, 128, 0));
		fpasswd.setBounds(207, 296, 205, 34);
		contentPane.add(fpasswd);
	}
}
