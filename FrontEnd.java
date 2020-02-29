package firstproject;
import java.awt.Font;
import java.awt.event.*;

import java.sql.*;
//import java.util.Scanner;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class FrontEnd extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String str;
	JButton b1,b2,b3,b4;
	JPanel P;
	JLabel background;
	   
     public FrontEnd(String s){
    	 super(s);
    	 setVisible(true);
    	 setResizable(false);
    	 setSize(1024,512);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 setLayout(null);
    	 ImageIcon img=new ImageIcon("C:\\Users\\sanpa\\Desktop\\SQL\\firstproject\\science.jpg");
    	 background=new JLabel("",img,JLabel.CENTER);
    	 background.setBounds(0,0,1024,600);
    	
     }
     public void setComponents() { 
    	 P=new JPanel();
    	 P.setBounds(0, 0, 1024, 512);
    	 
    	// l1=new JLabel("CLICK ON THE BUTTON TO PERFORM OPERATION :");
    	 b1=new JButton("INSERT");
    	 b2=new JButton("DELETE");
    	 b3=new JButton("DISPLAY");
    	 b4=new JButton("UPDATE");
    	 P.setLayout(null);
    	 //l1.setBounds(100,50,350,20);
    	 b1.setBounds(520,70,170,50);
    	 b1.setFont(new Font("Arial",Font.PLAIN,27));
    	 b1.addActionListener(new Insert1());
    	 b2.setBounds(320,180,170,50);
    	 b2.setFont(new Font("Arial",Font.PLAIN,27));
    	 b2.addActionListener(new Delete1());
    	 b3.setBounds(520,300,170,50);
    	 b3.setFont(new Font("Arial",Font.PLAIN,27));
    	 b3.addActionListener(new Display1());
    	 b4.setBounds(720,180,170,50);
    	 b4.setFont(new Font("Arial",Font.PLAIN,27));
    	 b4.addActionListener(new Update1());
    	 P.add(b1);
    	 P.add(b2);
    	 P.add(b3);
    	 P.add(b4);
    	 //P.add(l1);
    	 add(P);
    	 P.add(background);
     }
     class Update1  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Update update=new Update("UPDATE");
			update.setComponents();
		}
    	 
     }
     class Delete1 implements ActionListener{
    	
    	 public void actionPerformed(ActionEvent e) {
    		 Delete jp=new Delete("DELETE");
    		 jp.setComponent();
    		
    	 }
     }
     class Insert1 implements ActionListener{
    	
		public void actionPerformed(ActionEvent e) {
		    Insert ins=new Insert("INSERT");
			ins.setcomponent();
		  //  ins.action();
		}
		
     }
     @SuppressWarnings("serial")
	class Display1 implements ActionListener{
    		  
    			public void actionPerformed(ActionEvent e) {
    				Display disp=new Display("DISPLAY");
    				disp.setcomponent();
    			    disp.student_data();
    			}
     }		
      
}
class MainClass{
	public static void main(String[] args) {
		FrontEnd jf=new FrontEnd("Student Info.");
		jf.setComponents();
	}
}
