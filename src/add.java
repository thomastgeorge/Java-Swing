package todolist;

import java.awt.Font;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class add implements ActionListener{
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();
	JLabel l5 = new JLabel();
	JLabel l6 = new JLabel();
	JPanel p= new JPanel();
	JButton b=new JButton();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	add(){  
			f.setTitle("To-Do List - ADD");								//Sets title to JFrame
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);				//sets JFrame to full screen
			f.setLayout(null);
			f.setVisible(true);										//Enabling the view on
			ImageIcon icon=new ImageIcon("icon.jpg");				//Creating ImageIcon
			f.setIconImage(icon.getImage());
			
			l1.setText("ID");
			l2.setText("TASK");
			l3.setText("Start Date");
			l4.setText("End Date");
			l5.setText("(yyyy-MM-dd HH:mm:ss)");
			l6.setText("(yyyy-MM-dd HH:mm:ss)");
			t1.setBounds(250,50,500,60);
			t2.setBounds(250,120,500,60);
			t3.setBounds(250,190,500,60);
			t4.setBounds(250,260,500,60);
			l1.setBounds(100,50,300,50);
			l2.setBounds(100,120,300,50);
			l3.setBounds(100,190,300,50);
			l4.setBounds(100,260,300,50);
			l5.setBounds(100,210,300,50);
			l6.setBounds(100,270,300,50);
			
			p.add(t1);
			p.add(t2);
			p.add(t3);
			p.add(t4);
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			b=new JButton("ENTER");
			p.add(b);
			b.setBounds(250,400,100,50);
			b.addActionListener(this);
			f.add(p);
			p.setLayout(null);
			p.setBounds(450, 100, 750, 600);
			p.setVisible(true);
		     
			l.setText("TO-DO LIST - ADD");
			l.setFont(new Font("Times New Roman",Font.BOLD,30));
			l.setBounds(650,-60,500,250);
		    f.add(l);
		    l.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b)
		{
			try{
				//load the driver class  
			    Class.forName("oracle.jdbc.driver.OracleDriver");  
			      
			    //create  the connection object 
			    Connection con=DriverManager.getConnection(  
			    "jdbc:oracle:thin:@localhost:1522/xe","system","admin123");  
			      
			    //execute query  
			    PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into todolist values(?,?,?,?)");
			    pst.setString(1, t1.getText());
			    pst.setString(2,t2.getText());
			    pst.setTimestamp(3, java.sql.Timestamp.valueOf(t3.getText()));
			    pst.setTimestamp(4, java.sql.Timestamp.valueOf(t4.getText()));
			    pst.executeUpdate();
			    
		          con.commit();
		          
			  //close the connection object  
			    con.close();  
			      
			    }
			catch(Exception e1){ System.out.println(e1);
			} 
		}
		
	}
}
