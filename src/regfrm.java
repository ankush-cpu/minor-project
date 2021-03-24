import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regfrm {

	protected static final Component frame = null;
	private JFrame frmRegistrationForm;
	private JTextField name;
	private JTextField mobile;
	private JTextField blood;
	private JPasswordField password;
	private JTextField confirm;

	/**
	 * Launch the application.
	 */
	public static void regchk() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regfrm window = new regfrm();
					window.frmRegistrationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public regfrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrationForm = new JFrame();
		frmRegistrationForm.getContentPane().setBackground(new Color(255, 255, 204));
		frmRegistrationForm.setTitle("Registration Form");
		frmRegistrationForm.setBounds(100, 100, 684, 455);
		frmRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationForm.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Name:");
		l1.setForeground(new Color(0, 0, 255));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l1.setBounds(23, 11, 51, 34);
		frmRegistrationForm.getContentPane().add(l1);
		
		name = new JTextField();
		l1.setLabelFor(name);
		name.setToolTipText("Name must be in Block Letters");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		name.setBackground(new Color(211, 211, 211));
		name.setBounds(192, 16, 346, 27);
		frmRegistrationForm.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel l2 = new JLabel("Mobile Number:");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l2.setForeground(Color.BLUE);
		l2.setBounds(23, 53, 124, 22);
		frmRegistrationForm.getContentPane().add(l2);
		
		mobile = new JTextField();
		l2.setLabelFor(mobile);
		mobile.setToolTipText("Mobile number must be 10 digits long");
		mobile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mobile.setBackground(new Color(211, 211, 211));
		mobile.setForeground(Color.BLACK);
		mobile.setBounds(192, 54, 346, 24);
		frmRegistrationForm.getContentPane().add(mobile);
		mobile.setColumns(10);
		
		JLabel l3 = new JLabel("Address:");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l3.setForeground(Color.BLUE);
		l3.setBounds(23, 114, 87, 22);
		frmRegistrationForm.getContentPane().add(l3);
		
		JTextArea address = new JTextArea();
		l3.setLabelFor(address);
		address.setToolTipText("Enter full address");
		address.setBackground(new Color(211, 211, 211));
		address.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		address.setBounds(192, 88, 346, 88);
		frmRegistrationForm.getContentPane().add(address);
		
		JLabel l4 = new JLabel("Blood Group:");
		l4.setForeground(new Color(0, 0, 255));
		l4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l4.setBounds(23, 188, 104, 22);
		frmRegistrationForm.getContentPane().add(l4);
		
		blood = new JTextField();
		blood.setToolTipText("Enter blood group");
		blood.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		l4.setLabelFor(blood);
		blood.setBackground(new Color(211, 211, 211));
		blood.setBounds(192, 188, 87, 23);
		frmRegistrationForm.getContentPane().add(blood);
		blood.setColumns(10);
		
		JLabel l6 = new JLabel("Password:");
		l6.setForeground(new Color(0, 0, 255));
		l6.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l6.setBounds(23, 259, 87, 27);
		frmRegistrationForm.getContentPane().add(l6);
		
		password = new JPasswordField();
		password.setToolTipText("Password must be minimum 8 characters long with at least one uppercase letter, one lowercase letter, one digit and one special character ");
		l6.setLabelFor(password);
		password.setFont(new Font("Times New Roman", Font.BOLD, 15));
		password.setBackground(new Color(211, 211, 211));
		password.setBounds(192, 260, 346, 27);
		frmRegistrationForm.getContentPane().add(password);
		
		JLabel l7 = new JLabel("Confirm Password:");
		l7.setForeground(new Color(0, 0, 255));
		l7.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l7.setBounds(23, 299, 145, 22);
		frmRegistrationForm.getContentPane().add(l7);
		
		confirm = new JTextField();
		confirm.setToolTipText("This must match with the previous entered password");
		l7.setLabelFor(confirm);
		confirm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		confirm.setBackground(new Color(211, 211, 211));
		confirm.setBounds(192, 298, 346, 26);
		frmRegistrationForm.getContentPane().add(confirm);
		confirm.setColumns(10);
		
		JLabel l5 = new JLabel("Gender:");
		l5.setForeground(new Color(0, 0, 255));
		l5.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l5.setBounds(23, 226, 76, 22);
		frmRegistrationForm.getContentPane().add(l5);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBackground(new Color(255, 255, 204));
		male.setForeground(new Color(0, 0, 255));
		male.setFont(new Font("Times New Roman", Font.BOLD, 17));
		male.setBounds(192, 226, 87, 23);
		frmRegistrationForm.getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBackground(new Color(255, 255, 204));
		female.setForeground(new Color(0, 0, 255));
		female.setFont(new Font("Times New Roman", Font.BOLD, 17));
		female.setBounds(309, 226, 109, 22);
		frmRegistrationForm.getContentPane().add(female);
		
		JRadioButton others = new JRadioButton("Others");
		others.setForeground(new Color(0, 0, 255));
		others.setFont(new Font("Times New Roman", Font.BOLD, 17));
		others.setBackground(new Color(255, 255, 204));
		others.setBounds(441, 226, 109, 23);
		frmRegistrationForm.getContentPane().add(others);
		ButtonGroup g=new ButtonGroup();
		g.add(male);
		g.add(female);
		g.add(others);
		
		JButton btn1 = new JButton("SUBMIT");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime instance= LocalDateTime.now();
				DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
				String nm=name.getText().toUpperCase();
				String mb=mobile.getText();
				int c=0,n=0;
				String id="M"+ formatter.format(instance);
				String add1=address.getText();
				String bd=blood.getText();
				String gen="";
				char[] pass=password.getPassword();
				String p=new String(pass);
				String pat="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&=+-_])(?=\\S+$).{8,}";
				if(name.getText().equals("")|| !name.getText().equals(nm))
				{
					JOptionPane.showMessageDialog(frame,"name must be in block letters");
					n++;
				}
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
						JOptionPane.showMessageDialog(frame,"mobile number should contain digits only");
						n++;
					}
					else
					{
						if(mb.length()<10 || mb.length()>10)
						{
							JOptionPane.showMessageDialog(frame,"mobile number must be 10 digits long");
							n++;
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"don't leave mobile number blank");
					n++;
				}
				if(address.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame,"don't leave address blank");
					n++;
				}
				if(blood.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame,"don't leave blood group blank");
					n++;
				}
				if(male.isSelected())
				{
					gen="Male";
				}
				else if(female.isSelected())
				{
					gen="Female";
				}
				else if(others.isSelected())
				{
					gen="Others";	
				}
			    else
				{
			    	JOptionPane.showMessageDialog(frame,"you must select your gender");
				}
				if(p.equals(""))
				{
					JOptionPane.showMessageDialog(frame,"don't leave password field blank");
			    }
				else
				{
					if(p.length()<8)
					{
						JOptionPane.showMessageDialog(frame,"password must be 8 characters long");
					}
					else
					{
						if(!p.matches(pat))
						{
							JOptionPane.showMessageDialog(frame,"password must have at least one uppercase letter, one lowercase letter, one digit and one special character");
							n++;
						}
					}
				}
				if(!confirm.getText().equals(p))
				{
					JOptionPane.showMessageDialog(frame,"confirm password must match with the previous entered password");
					n++;
				}
				if(n!=0)
				{
					JOptionPane.showMessageDialog(frame,"DATA UPLOAD FAILURE!");
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
				String qr="INSERT INTO med_user VALUES ('"+id+"', '"+nm+"', '"+mb+"', '"+add1+"', '"+bd+"', '"+gen+"', '"+p+"')";
				String qr1="INSERT INTO med_login VALUES ('"+id+"', '"+p+"')";
				int x= st.executeUpdate(qr);
				int y= st.executeUpdate(qr1);
				if(x==0 && y==0)
				{
					JOptionPane.showMessageDialog(frame,"data update failure");
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"data update successful and your ID is: "+id);
					loginfrm lgfrm=new loginfrm();
					lgfrm.setVisible(true);
				}
				}	
				catch(Exception f)
				{
					System.out.println(f);
				}
			}
			}
		});
		btn1.setBackground(new Color(135, 206, 250));
		btn1.setForeground(new Color(0, 0, 255));
		btn1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		btn1.setBounds(295, 345, 109, 34);
		frmRegistrationForm.getContentPane().add(btn1);
		
	}
}
