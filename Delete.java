package firstproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.*;

class Delete extends JFrame{
JLabel l0,l1,l2,l3,background;
JTextField t1;
JButton b1;
JPanel p;
  public Delete(String s) {
	   super(s);
  }
  public void setComponent() {
	   setVisible(true);
	   setSize(250,220);
	   p=new JPanel();
	   l0=new JLabel("Enter Roll No of student ");
	   l1=new JLabel(" which you want to delete:");
      l2=new JLabel("ROLL NO :");
      l3=new JLabel();
      t1=new JTextField();
      b1=new JButton("DELETE");
      ImageIcon img=new ImageIcon("C:\\Users\\sanpa\\Desktop\\SQL\\firstproject\\background1.jpg");
	   background=new JLabel("",img,JLabel.CENTER);
 	 background.setBounds(0,0,340,400);
      p.setLayout(null);
      p.setBounds(0, 0, 250, 250);
      l0.setBounds(10, 10, 150, 15);
      l1.setBounds(10, 30, 150, 15);
      l2.setBounds(10, 60, 100, 15);
      t1.setBounds(100, 60, 50, 20);
      l3.setBounds(10, 100, 200, 15);
      b1.setBounds(50, 130, 90, 20);
      b1.addActionListener(new Deleting());
      p.add(l0);
      p.add(l1);
      p.add(l2);
      p.add(t1);
      p.add(l3);
      p.add(b1);
      add(p);
      p.add(background);
  }
class Deleting implements ActionListener{
  public void actionPerformed(ActionEvent ae) {
	   int rn;
	  
	   rn=Integer.parseInt(t1.getText());
	   try {
		 String query="delete from Student where ROLL_NO="+rn;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raj","root","Raj2511$g");
		PreparedStatement st=con.prepareStatement(query);
	    int count=st.executeUpdate();
	    if(count!=0) {
	    	l3.setText("Data is successfully deleted");
	    }
	    else {
	    	 JOptionPane.showMessageDialog(new JFrame(),"ROLL NO DOESNOT EXIST","Dialog",JOptionPane.ERROR_MESSAGE);
	    }
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(new JFrame(),"ROLL NO DOESNOT EXIST","Dialog",JOptionPane.ERROR_MESSAGE);
	   }
	   
  }
}
}