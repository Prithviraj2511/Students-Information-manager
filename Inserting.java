package firstproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import java.util.Scanner;
class Insert extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,l6,background;
	 JTextField t1,t2,t3,t4,t5;
	 JButton b;
	 JPanel p;
   public Insert(String s) {
	   super(s);
   }
	 
   public void setcomponent() {
	   setVisible(true);
	   setSize(340,400);
	   ImageIcon img=new ImageIcon("C:\\Users\\sanpa\\Desktop\\SQL\\firstproject\\background1.jpg");
	   background=new JLabel("",img,JLabel.CENTER);
  	 background.setBounds(0,0,340,400);
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
	  b=new JButton("I N S E R T");
	  b.addActionListener(new Insert2());
	  p.setLayout(null);
	  p.setBounds(0, 0, 340, 400);
      l1.setBounds(40,20,100,15);
      t1.setBounds(150,20,100,20);
      l2.setBounds(40,60,100,15);
      t2.setBounds(150,60,100,20);
      l3.setBounds(40,100,100,15);
      t3.setBounds(150,100,100,20);
      l4.setBounds(40,140,100,15);
      t4.setBounds(150,140,100,20);
      l5.setBounds(40,180,100,15);
      l6.setBounds(40,280,190,15);
      t5.setBounds(150,180,100,20);
      b.setBounds(80,250,100,30);
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
	   p.add(b);
	   p.add(l6);
	   add(p);
	   p.add(background);
   }
   class Insert2 implements ActionListener{
	   
   
          public void actionPerformed(ActionEvent ae) {
		
		try {
   	     int rn,age;
   	     String fn,ln,bn;
   	     rn=Integer.parseInt(t1.getText());
   	     fn=t2.getText();
   	     ln=t3.getText();
   	     bn=t4.getText();
   	     age=Integer.parseInt(t5.getText());
   	   String query="insert into Student values(?,?,?,?,?)";
   	   Class.forName("com.mysql.cj.jdbc.Driver");
   	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raj","root","Raj2511$g");
   	   PreparedStatement st=con.prepareStatement(query);
   	   st.setInt(1,rn);
   	   st.setString(2,fn);
   	   st.setString(3,ln);
   	   st.setString(4,bn);
   	   st.setInt(5,age);
   	   int count=st.executeUpdate();
   	   if(count!=0)
   		    l6.setText("DATA SAVED SUCCESSFULLY");
   	   else
   		   JOptionPane.showMessageDialog(new JFrame()," E  R  R  O  R","Dialog",JOptionPane.ERROR_MESSAGE);
   	   t1.setText("");
   	   t2.setText("");
    	 t3.setText("");
    	 t4.setText("");
    	 t5.setText("");
      }catch(Exception aex) {
    	  JOptionPane.showMessageDialog(new JFrame()," E  R  R  O  R","Dialog",JOptionPane.ERROR_MESSAGE);
      }
   }
   }
}