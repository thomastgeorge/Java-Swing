package todolist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class frames extends JFrame implements ActionListener {
	
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	JPanel buttonpanel = new JPanel();
	JButton v,d,a,u;	//v-view List, d-delete, a-add, u-update, c-completed, m-list to completed list	
	
	frames(){
	f.setTitle("To-Do List");								//Sets title to JFrame
	f.setExtendedState(JFrame.MAXIMIZED_BOTH);				//sets JFrame to full screen
	f.setLayout(null);
	f.getContentPane().setBackground(new Color(123,50,250));
	f.setVisible(true);										//Enabling the view on
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Close JFrame on pressing close
	ImageIcon icon=new ImageIcon("icon.jpg");				//Creating ImageIcon
	f.setIconImage(icon.getImage());						//Setting icon to frame
	
	l.setText("TO-DO LIST");
	l.setFont(new Font("Times New Roman",Font.BOLD,30));
	l.setBounds(750,250,250,250);
	f.add(l);
	
	v=new JButton("View Task");
	v.setBounds(250,50,100,100);
	v.addActionListener(this);
	
	a=new JButton("Add Task");
	a.setBounds(300,50,100,100);
	a.addActionListener(this);
	
	d=new JButton("Delete Task");
	d.setBounds(350,50,100,100);
	d.addActionListener(this);
	
	u=new JButton("Update Task");
	u.setBounds(400,50,100,100);
	u.addActionListener(this);
	
	buttonpanel.add(v);
	buttonpanel.add(d);
	buttonpanel.add(a);
	buttonpanel.add(u);
	buttonpanel.setBounds(450, 100, 750, 600);
	f.add(buttonpanel);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==v) {
			new view();	
		}
		else if(e.getSource()==a) {
			new add();
		}
		else if(e.getSource()==d) {
			new delete();
		}
		else if(e.getSource()==u) {
			new update();
		}
		
	}
}
