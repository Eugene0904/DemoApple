package less07;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyWin extends JFrame {
	JLabel label=new JLabel(new ImageIcon("C:/Users/Евгений/Downloads/apple.png"));
	MyWin(){
		super("Maven project");
		setSize(300,300);
		setVisible(true);
		JLabel label2 = new JLabel(getFromDB());
		JPanel panel = new JPanel();
		
		panel.add(label);
		panel.add(label2);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	String getFromDB() {
		String msg="";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn=null;
			conn= DriverManager.getConnection("jdbc:mysql://localhost/Itea?"+"user=root&password=");
			Statement stmt=null;
			ResultSet rs=null;
			stmt=conn.createStatement();
			rs=stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg+=rs.getString("id")+"-"+rs.getString("name")+"-"+rs.getString("Login");
			}
		} catch (Exception ex) {
			
		}
		return msg;
		
	}

}
