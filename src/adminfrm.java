import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class adminfrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton show;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminfrm frame = new adminfrm();
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
	public adminfrm() {
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Admin Panel");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(198, 25, 299, 31);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 67, 616, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		show = new JButton("SHOW");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_data();
			}
		});
		show.setFont(new Font("Times New Roman", Font.BOLD, 21));
		show.setForeground(new Color(0, 128, 0));
		show.setBounds(43, 373, 99, 33);
		contentPane.add(show);
		
		eid = new JTextField();
		eid.setFont(new Font("Times New Roman", Font.BOLD, 17));
		eid.setBounds(240, 377, 299, 26);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USER ID:");
		lblNewLabel_1.setLabelFor(eid);
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_1.setBounds(157, 376, 99, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton edit = new JButton("EDIT");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1=eid.getText();
				editfrm ef=new editfrm(id1);
				ef.setVisible(true);
			}
		});
		edit.setForeground(new Color(0, 128, 0));
		edit.setFont(new Font("Times New Roman", Font.BOLD, 21));
		edit.setBounds(558, 373, 101, 36);
		contentPane.add(edit);
	}

private void show_data()
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_db", "ankush", "Bca_k123");
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Mobile No");
		model.addColumn("Address");
		model.addColumn("Blood Group");
		model.addColumn("Gender");
		
		String qr="SELECT * FROM med_user";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(qr);
		while(rs.next())
		{
			model.addRow(new Object[] {
					rs.getString("uid"),
					rs.getString("name"),
					rs.getString("mobile"),
					rs.getString("address"),
					rs.getString("blood"),
					rs.getString("gender")
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
		table.getColumnModel().getColumn(5).setPreferredWidth(150);	
	}
	catch(Exception f)
	{
		System.out.println(f);
	}
}
}