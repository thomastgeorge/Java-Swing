package todolist;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.sql.*;
import javax.swing.*;

public class delete implements ActionListener{
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	JTextField t1=new JTextField();	
	JLabel l1 = new JLabel();
	JPanel p= new JPanel();
	JButton b=new JButton();
	delete(){ 
			f.setTitle("To-Do List - DELETE");								//Sets title to JFrame
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);				//sets JFrame to full screen
			f.setLayout(null);
			f.setVisible(true);										//Enabling the view on
			ImageIcon icon=new ImageIcon("icon.jpg");				//Creating ImageIcon
			f.setIconImage(icon.getImage());
			
			l1.setText("Enter ID");
			l1.setBounds(100,250,300,50);
			t1.setBounds(250,250,500,60);
			p.add(t1);
			p.add(l1);
			f.add(p);
			b=new JButton("ENTER");
			p.add(b);
			b.setBounds(250,400,100,50);
			b.addActionListener(this);
			p.setLayout(null);
			p.setBounds(450, 100, 750, 600);
			p.setVisible(true);
			
			l.setText("TO-DO LIST - DELETE");
			l.setFont(new Font("Times New Roman",Font.BOLD,30));
			l.setBounds(650,-60,500,250);
		    f.add(l);
		    l.setVisible(true);
			 
}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{ 
			//load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
	      
			//create  the connection object 
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1522/xe","system","admin123");  
	      
			//create the statement object  

			String query = "delete from todolist where id = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, t1.getText());

		      // execute the preparedstatement
		      preparedStmt.execute();
		    
	        con.commit();
			
			//close the connection object  
			con.close();  
	      
	    	}
		catch(Exception ae){ System.out.println(ae);
		}
		
		
	}
}
