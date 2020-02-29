package firstproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


class Update extends JFrame{
    	 JLabel l1,l2,l3,l4,l5,l6,background;
    	 JTextField t1,t2,t3,t4,t5;
    	 JButton b1,b2;
    	 JPanel p;
    	 Update(String s){
    		super(s);
    	 }
    	 public void setComponents() {
    		 setVisible(true);
    		 setSize(400,400);
    		 setLayout(null);
    		p=new JPanel();
    		 l1=new JLabel("ROLL NO    :");
       	  l2=new JLabel("FIRST NAME :");
       	  l3=new JLabel("LAST NAME  :");
       	  l4=new JLabel("BRANCH     :");
       	  l5=new JLabel("AGE        :");
       	  l6=new JLabel();
       	  t1=new JTextField();
       	  t2=new JTextField();
       	  t3=new JTextField();
       	  t4=new JTextField();
       	  t5=new JTextField();
       	  l6=new JLabel();
       	  b1=new JButton("SEARCH");
       	  b1.addActionListener(new Search());
       	  b2=new JButton("UPDATE");
       	  b2.addActionListener(new Updating());
       	 ImageIcon img=new ImageIcon("C:\\Users\\sanpa\\Desktop\\SQL\\firstproject\\background1.jpg");
  	   background=new JLabel("",img,JLabel.CENTER);
    	 background.setBounds(0,0,400,400);
       	    p.setLayout(null);
       	    p.setBounds(0, 0, 400, 400);
             l1.setBounds(40,20,100,15);
             t1.setBounds(150,20,100,20);
             l2.setBounds(40,60,100,15);
             t2.setBounds(150,60,100,20);
             l3.setBounds(40,100,100,15);
             t3.setBounds(150,100,100,20);
             l4.setBounds(40,140,100,15);
             t4.setBounds(150,140,100,20);
             l5.setBounds(40,180,100,15);
             l6.setBounds(40,260,220,15);
             t5.setBounds(150,180,100,20);
             b1.setBounds(30,220,100,30);
             b2.setBounds(140,220,100,30);
             p.add(l1);
             p.add(l2);
             p.add(l3);
             p.add(l4);
             p.add(l5);
             p.add(t1);
             p.add(t2);
             p.add(t3);
             p.add(t4);
             p.add(t5);
       	   p.add(b1);
       	   p.add(b2);
       	   p.add(l6);
       	   add(p);
       	   p.add(background);
    	 }
    class Updating implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		int rn=Integer.parseInt(t1.getText());
        	String query="update Student set FIRST_NAME=?,LAST_NAME=?,BRANCH=?,AGE=? WHERE ROLL_NO="+rn;
        	try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
         	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raj","root","Raj2511$g");
         	PreparedStatement st=con.prepareStatement(query);
         	  //st.setInt(1,rn);
          	   st.setString(1,t2.getText());
          	   st.setString(2,t3.getText());
          	   st.setString(3,t4.getText());
          	   st.setInt(4,Integer.parseInt(t5.getText()));
          	   int count=st.executeUpdate();
          	   if(count!=0)
          		    l6.setText("DATA UPDATED SUCCESSFULLY");
          	   else
          		   JOptionPane.showMessageDialog(new JFrame()," E  R  R  O  R (data not updated)","Dialog",JOptionPane.ERROR_MESSAGE);
               t1.setText("");
               t2.setText("");
               t3.setText("");
               t4.setText("");
               t5.setText("");
        	}catch(Exception ae) {
        		 l6.setText("ROLL NO DOES NOT EXIST");
        	}
        }
    }
    class Search implements ActionListener{
    	 
    	 public void actionPerformed(ActionEvent e) {
    		int rn=Integer.parseInt(t1.getText());
    		String query="Select * from Student where ROLL_NO="+rn;
    		try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
         	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raj","root","Raj2511$g");
         	  Statement st=con.createStatement();
        	  ResultSet rs=st.executeQuery(query);
        	  rs.next();
     		  t2.setText(rs.getString(2));
     		  t3.setText(rs.getString(3));
     		  t4.setText(rs.getString(4));
     		  t5.setText(rs.getString(5));
     		  l6.setText("EDIT FOR UPDATE");
    		}
    		catch(Exception ae) {
    			l6.setText("ROLL NUMBER DOESNOT EXIST");
    		}
    	 }
    }
    	
 }
