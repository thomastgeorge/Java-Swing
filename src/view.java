package todolist;

import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class view {
	int id;
	String task;
	Date startdate;
	Date enddate;
	String Column[] = {"ID","Task","Start Date","End Date"} ; //table heading
	JFrame f=new JFrame();
	JTable t = new JTable();
	JLabel l =new JLabel();
	
	view(){
		try{  
			f.setTitle("To-Do List - VIEW");						//Sets title to JFrame
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);				//sets JFrame to full screen
			f.setLayout(null);
			f.setVisible(true);										//Enabling the view on
			ImageIcon icon=new ImageIcon("icon.jpg");				//Creating ImageIcon
			f.setIconImage(icon.getImage());
			
			DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(Column);
	        t.setModel(model);
	        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        t.setFillsViewportHeight(true);
	        JScrollPane scroll = new JScrollPane(t);
	        scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		      
		    //create  the connection object 
		    Connection con=DriverManager.getConnection(  
		    "jdbc:oracle:thin:@localhost:1522/xe","system","admin123");  
		      
		    //create the statement object  
		    Statement stmt=con.createStatement();  
		      
		    //execute query  
		    ResultSet rs=stmt.executeQuery("select * from todolist");  
		    model.addRow(new Object[]{"ID","Task", "Start Date", "End Date"});
		    while(rs.next()) {
		    	id = rs.getInt(1);
                task = rs.getString(2);
                startdate = rs.getDate(3);
                enddate= rs.getDate(4);
                model.addRow(new Object[]{id,task, startdate, enddate});
            }
		    
		    l.setText("TO-DO LIST");
			l.setFont(new Font("Times New Roman",Font.BOLD,30));
			l.setBounds(700,-50,250,250);
			f.add(l);
		    f.add(t);
		    t.setVisible(true);
		    t.setLayout(null);
		    t.setBounds(450, 100, 750, 600);
		    con.close();  
		      
		}
		catch(Exception e){ System.out.println(e);
		}
	}
		
}
