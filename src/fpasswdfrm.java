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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fpasswdfrm extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JTextField mobile;
	private JTextField npassw;
	private JTextField cnpassw;
	protected Component fpasswdfrm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fpasswdfrm frame = new fpasswdfrm();
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
	public fpasswdfrm() {
		setTitle("Forgot Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Forgot Password Page");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(101, 21, 399, 33);
		contentPane.add(lblNewLabel);
		
		JLabel l1 = new JLabel("User ID:");
		l1.setForeground(new Color(0, 128, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l1.setBounds(35, 71, 82, 22);
		contentPane.add(l1);
		
		uid = new JTextField();
		l1.setLabelFor(uid);
		uid.setToolTipText("Enter your user id");
		uid.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		uid.setBackground(Color.LIGHT_GRAY);
		uid.setBounds(252, 68, 304, 28);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JLabel l2 = new JLabel("Mobile No.:");
		l2.setForeground(new Color(0, 128, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2.setBounds(35, 121, 109, 22);
		contentPane.add(l2);
		
		mobile = new JTextField();
		l2.setLabelFor(mobile);
		mobile.setToolTipText("Enter valid mobile number");
		mobile.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mobile.setBackground(Color.LIGHT_GRAY);
		mobile.setBounds(252, 118, 304, 28);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		JLabel l3 = new JLabel("New Password:");
		l3.setForeground(new Color(0, 128, 0));
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3.setBounds(35, 175, 142, 22);
		contentPane.add(l3);
		
		npassw = new JTextField();
		npassw.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		l3.setLabelFor(npassw);
		npassw.setToolTipText("Password must be minimum 8 characters long with at least one uppercase letter, one lowercase letter, one digit and one special character ");
		npassw.setBackground(Color.LIGHT_GRAY);
		npassw.setBounds(252, 172, 304, 28);
		contentPane.add(npassw);
		npassw.setColumns(10);
		
		JLabel l4 = new JLabel("Confirm New Password:");
		l4.setForeground(new Color(0, 128, 0));
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4.setBounds(35, 224, 212, 22);
		contentPane.add(l4);
		
		cnpassw = new JTextField();
		l4.setLabelFor(cnpassw);
		cnpassw.setToolTipText("This must match with the previous entered password");
		cnpassw.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		cnpassw.setBackground(Color.LIGHT_GRAY);
		cnpassw.setBounds(252, 221, 304, 28);
		contentPane.add(cnpassw);
		cnpassw.setColumns(10);
		
		JButton submit = new JButton("CHANGE");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		
				int c=0,n=0;
				String id1=uid.getText();
				String mb=mobile.getText();
				String pass= npassw.getText();
				String confirm = cnpassw.getText();
				String pat="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&=+-_])(?=\\S+$).{8,}";
				if(!mb.equals(""))
				{
					for(int i=0; i<mb.length(); i++)
					{
						if(mb.charAt(i)<'0' || mb.charAt(i)>'9')
						{
							c++;
						}
					}
					if(c>0)
					{
						JOptionPane.showMessageDialog(fpasswdfrm,"mobile number should contain digits only");
						n++;
					}
					else
					{
						if(mb.length()<10 || mb.length()>10)
						{
							JOptionPane.showMessageDialog(fpasswdfrm,"mobile number must be 10 digits long");
							n++;
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(fpasswdfrm,"don't leave mobile number blank");
					n++;
				}
				if(pass.equals(""))
				{
					JOptionPane.showMessageDialog(fpasswdfrm,"don't leave password field blank");
					n++;
			    }
				else
				{
					if(pass.length()<8)
					{
						JOptionPane.showMessageDialog(fpasswdfrm,"password must be 8 characters long");
						n++;
					}
					else
					{
						if(!pass.matches(pat))
						{
							JOptionPane.showMessageDialog(fpasswdfrm,"password must have at least one uppercase letter, one lowercase letter, one digit and one special character");
							n++;
						}
					}
				}
				if(!confirm.equals(pass))
				{
					JOptionPane.showMessageDialog(fpasswdfrm,"confirm password must match with the previous entered password");
					n++;
				}
				if(n!=0)
				{
					JOptionPane.showMessageDialog(fpasswdfrm,"DATA UPLOAD FAILURE!");
				}
				else
				{
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
				String qr="UPDATE med_user SET passwd='"+pass+"' WHERE uid='"+id1+"' AND mobile='"+mb+"' ";
				String qr1="UPDATE med_login SET passwd='"+pass+"' WHERE uid='"+id1+"' ";
				PreparedStatement ps1= con.prepareStatement(qr);
				PreparedStatement ps2= con.prepareStatement(qr1);
				int rs1=ps1.executeUpdate();
				int rs2=ps2.executeUpdate();
				if(rs1>0 && rs2>0)
				{
					JOptionPane.showMessageDialog(fpasswdfrm,"Password Changed Successfully");
					loginfrm lfrm=new loginfrm();
					lfrm.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(fpasswdfrm,"Invalid information!");
				}
				}
				catch(Exception f)
				{
					System.out.println(f);
				}			
				}
			}
		});
		submit.setForeground(new Color(0, 128, 0));
		submit.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		submit.setBounds(207, 282, 128, 35);
		contentPane.add(submit);
	}
}
