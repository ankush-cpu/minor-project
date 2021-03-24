import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class usrfrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField pn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usrfrm frame = new usrfrm(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param name1 
	 * @param id1 
	 */
	public usrfrm(String id1, String name1) {
		setTitle("User Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setForeground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome User: " +name1);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(102, 23, 568, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 71, 649, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton show = new JButton("SHOW");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_data();
			}
		});
		show.setFont(new Font("Times New Roman", Font.BOLD, 21));
		show.setForeground(new Color(0, 128, 0));
		show.setBounds(41, 371, 103, 36);
		contentPane.add(show);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT NAME:");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_1.setBounds(149, 372, 155, 36);
		contentPane.add(lblNewLabel_1);
		
		pn = new JTextField();
		pn.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setLabelFor(pn);
		pn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pn.setBounds(306, 376, 252, 26);
		contentPane.add(pn);
		pn.setColumns(10);
		
		JButton edit = new JButton("EDIT");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pn1=pn.getText();
				estckfrm ef=new estckfrm(pn1);
				ef.setVisible(true);
			}
		});
		edit.setForeground(new Color(0, 128, 0));
		edit.setFont(new Font("Times New Roman", Font.BOLD, 21));
		edit.setBounds(568, 371, 122, 36);
		contentPane.add(edit);
		
		JButton btnNewButton = new JButton("ADD PRODUCT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adstckfrm ob=new adstckfrm();
				ob.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(244, 413, 212, 33);
		contentPane.add(btnNewButton);
	}
private void show_data()
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Batch No.");
		model.addColumn("Manufacture Date");
		model.addColumn("Expiry Date");
		model.addColumn("Product Name");
		model.addColumn("Stock Available");
		
		String qr="SELECT * FROM med_prod";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(qr);
		while(rs.next())
		{
			model.addRow(new Object[] {
					rs.getString("bno"),
					rs.getString("mfd"),
					rs.getString("exp"),
					rs.getString("prodn"),
					rs.getString("stock")
			});
		}
		rs.close();
		st.close();
		con.close();
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
	}
	catch(Exception f)
	{
		System.out.println(f);
	}
}
}
	
	



