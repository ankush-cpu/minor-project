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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class estckfrm extends JFrame {

	protected static final Component estckfrm = null;
	private JPanel contentPane;
	private JTextField stk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					estckfrm frame = new estckfrm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param pn1 
	 * @param name1 
	 */
	public estckfrm(String pn1) {
		String stk1="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
			String qr="SELECT * FROM med_prod WHERE prodn='"+pn1+"'";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(qr);
			while(rs.next())
			{
				stk1=rs.getString("stock");
			}
			con.close();
			st.close();
			rs.close();
		}
			catch(Exception x)
			{
				System.out.println(x);
			}
		
		setTitle("Edit Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Edit Stock Available For: "+pn1);
		l1.setForeground(new Color(0, 128, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		l1.setBounds(85, 21, 508, 37);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("UPDATED STOCK\r\n:");
		l2.setForeground(new Color(0, 128, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD, 21));
		l2.setBounds(108, 122, 195, 30);
		contentPane.add(l2);
		
		stk = new JTextField();
		stk.setBackground(Color.LIGHT_GRAY);
		l2.setLabelFor(stk);
		stk.setBounds(320, 123, 205, 29);
		contentPane.add(stk);
		stk.setColumns(10);
		
		JButton update = new JButton("UPDATE");
		update.setForeground(new Color(0, 128, 0));
		update.setFont(new Font("Times New Roman", Font.BOLD, 24));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pn2= pn1;
				String stk2= stk.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
					String qr="SELECT * FROM med_prod WHERE prodn='"+pn2+"'";
					Statement st=con.createStatement();
					String qr1="UPDATE med_prod SET stock='"+stk2+"' WHERE prodn='"+pn2+"'";
					PreparedStatement ps1 = con.prepareStatement(qr1);
					int rs1=ps1.executeUpdate();
					if(rs1>0)
					{
						JOptionPane.showMessageDialog(estckfrm,"Stock Update Successful for: " +pn2);
						usrfrm af= new usrfrm(null,null);
						af.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(estckfrm,"Invalid Product Name!");
					}
				}
				catch(Exception y)
				{
					System.out.println(y);
				}
			}
			
		});
		update.setBounds(238, 191, 136, 37);
		contentPane.add(update);
		
		
		
	}

}
