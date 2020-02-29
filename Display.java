package firstproject;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Display extends JFrame{
	 DefaultTableModel t1;
	    JTable table;
	    JScrollPane scroll;
		Display(String s){
	    super(s);
  	}
		void setcomponent(){
			setVisible(true);
		    setSize(600,530);
		    setLayout(null);
		    table=new JTable();
		    t1=new DefaultTableModel(new String[]{"ROLL_NO","FIRST_NAME","LAST_NAME","BRANCH","AGE"},0);
		   scroll=new JScrollPane(table);
		   scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		   scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		   scroll.setBounds(10, 0, 560, 470);
		   table.setModel(t1);
		    getContentPane().add(scroll);
		}   
		public void student_data() {
			String query="select * from Student",str1,str2,str3,str4,str5;
	        	  try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raj","root","Raj2511$g");
	        	  Statement st=con.createStatement();
	        	  ResultSet rs=st.executeQuery(query);
	        	  while(rs.next()) {
		        		  str1=(rs.getString(1));
		        		  str2=rs.getString(2);
		        		  str3=rs.getString(3);
		        		  str4=rs.getString(4);
		        		  str5=rs.getString(5);
		        		  t1.addRow(new Object[] {str1,str2,str3,str4,str5});
	        	  }
	        	  }
	        	  catch(Exception e) {
	        		  System.out.println(e);
	        	  }
	        	  			
		}
}