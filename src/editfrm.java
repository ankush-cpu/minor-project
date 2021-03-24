import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editfrm extends JFrame {

	protected static final Component editfrm = null;
	private JPanel contentPane;
	private JTextField nm;
	private JTextField mb;
	private JTextField add;
	private JTextField gen;
	private JTextField bg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editfrm frame = new editfrm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id1 
	 */
	public editfrm(String id1) {
		String nm1="";
		String mb1="";
		String add1="";
		String bg1="";
		String gen1="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
			String qr="SELECT * FROM k1_user WHERE uid='"+id1+"'";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(qr);
			while(rs.next())
			{
				nm1=rs.getString("name");
				mb1=rs.getString("mobile");
				add1=rs.getString("address");
				bg1=rs.getString("blood");
				gen1=rs.getString("gender");
			}
			con.close();
			st.close();
			rs.close();
		}
			catch(Exception x)
			{
				System.out.println(x);
			}
		
		setTitle("Edit Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("User's Information Edit for : " + id1);
		l1.setForeground(new Color(0, 128, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l1.setBounds(87, 11, 636, 37);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("NAME: ");
		l2.setForeground(new Color(0, 128, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2.setBounds(47, 84, 101, 29);
		contentPane.add(l2);
		
		nm = new JTextField(nm1);
		nm.setToolTipText("Update name");
		l2.setLabelFor(nm);
		nm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nm.setBackground(Color.LIGHT_GRAY);
		nm.setBounds(213, 82, 319, 29);
		contentPane.add(nm);
		nm.setColumns(10);
		
		JLabel l4 = new JLabel("ADDRESS:");
		l4.setForeground(new Color(0, 128, 0));
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4.setBounds(47, 197, 101, 24);
		contentPane.add(l4);
		
		mb = new JTextField(mb1);
		mb.setToolTipText("Update mobile number");
		mb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mb.setBackground(Color.LIGHT_GRAY);
		mb.setBounds(213, 131, 319, 29);
		contentPane.add(mb);
		mb.setColumns(10);
		
		JLabel l3 = new JLabel("MOBILE:");
		l3.setLabelFor(mb);
		l3.setForeground(new Color(0, 128, 0));
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3.setBounds(47, 133, 101, 24);
		contentPane.add(l3);
		
		add = new JTextField(add1);
		add.setToolTipText("Enter your updated full address");
		l4.setLabelFor(add);
		add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add.setBackground(Color.LIGHT_GRAY);
		add.setBounds(213, 177, 319, 64);
		contentPane.add(add);
		add.setColumns(10);
		
		JLabel l6 = new JLabel("GENDER:");
		l6.setForeground(new Color(0, 128, 0));
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6.setBounds(47, 307, 101, 29);
		contentPane.add(l6);
		
		gen = new JTextField(gen1);
		gen.setToolTipText("Update gender as male, female or others");
		l6.setLabelFor(gen);
		gen.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		gen.setBackground(Color.LIGHT_GRAY);
		gen.setBounds(213, 307, 319, 29);
		contentPane.add(gen);
		gen.setColumns(10);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id2= id1;
				String nm2= nm.getText();
				String mb2=mb.getText();
				String add2=add.getText();
				String bg2=bg.getText();
				String gen2=gen.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
					String qr="SELECT * FROM med_user WHERE uid='"+id2+"'";
					Statement st=con.createStatement();
					String qr1="UPDATE med_user SET name='"+nm2+"', mobile='"+mb2+"', address='"+add2+"', blood='"+bg2+"' ,gender='"+gen2+"' WHERE uid='"+id2+"'";
					PreparedStatement ps1 = con.prepareStatement(qr1);
					int rs1=ps1.executeUpdate();
					if(rs1>0)
					{
						JOptionPane.showMessageDialog(editfrm,"data update successful and your ID is: " +id2);
						adminfrm af= new adminfrm();
						af.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(editfrm,"invalid ID");
					}
				}
				catch(Exception y)
				{
					System.out.println(y);
				}
				
			}
		});
		update.setForeground(new Color(0, 128, 0));
		update.setFont(new Font("Times New Roman", Font.BOLD, 24));
		update.setBounds(250, 361, 151, 37);
		contentPane.add(update);
		
		JLabel l5 = new JLabel("BLOOD GROUP:");
		l5.setForeground(new Color(0, 128, 0));
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5.setBounds(47, 256, 156, 29);
		contentPane.add(l5);
		
		bg = new JTextField();
		bg.setToolTipText("Update blood group");
		bg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l5.setLabelFor(bg);
		bg.setBackground(Color.LIGHT_GRAY);
		bg.setBounds(213, 258, 319, 29);
		contentPane.add(bg);
		bg.setColumns(10);
	}
}
