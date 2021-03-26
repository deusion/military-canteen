
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class SalemanInfo1 extends JFrame implements ActionListener
{
 JLabel ml,l1,l2,img,name,sup,l3;
 JTextField t1,t2;
 JButton b1,b2;
 JPasswordField p1;
 Font df=new Font("Arial",Font.BOLD,25);
 Font df1=new Font("Georgia",Font.BOLD,15);
 String z1="Enter the Password ",z2=" Name.",z3="PassWord",z4="CTR No: ";
 int count=0;
 public SalemanInfo1()
 {
	 super(" Login");
  setResizable(false);
  setLocation(300,270);
  setLayout(null);
  getContentPane().setBackground(new Color(0.90f,0.9f,0.9f));
  name=new JLabel(" ",JLabel.CENTER);
  name.setFont(new Font("Arial",Font.BOLD,20));
  name.setForeground(Color.RED);
  sup=new JLabel(" ",JLabel.CENTER);
  sup.setFont(new Font("vardona",Font.PLAIN,17));
  sup.setForeground(Color.BLACK);
  ml=new JLabel(z1,JLabel.CENTER);
  ml.setForeground(Color.BLUE);
  ml.setFont(df);
  l1=new JLabel(z2,JLabel.CENTER);
  l1.setFont(df1);
  l1.setForeground(new Color(0.8f,0.0f,0.9f));
  l2=new JLabel(z3,JLabel.CENTER);
  l2.setFont(df1);
  l2.setForeground(new Color(0.8f,0.0f,0.9f));
  l3=new JLabel(z4,JLabel.CENTER);
  l3.setFont(df1);
  l3.setForeground(new Color(0.8f,0.0f,0.9f));
  
  t1=new JTextField(30);
  t1.setFont(df1);
  t2=new JTextField(30);
  t2.setFont(df1);
  p1=new JPasswordField(15);
  p1.setFont(df1);
  p1.setEchoChar('#');
  b1=new JButton("LOGIN");
  b1.setForeground(Color.BLUE);
  b1.setMnemonic('L');
  b2=new JButton("CANCEL");
  b2.setForeground(Color.BLUE);
  b2.setMnemonic('C');
  setSize(340,260);
  name.setBounds(50,100,400,30);
  sup.setBounds(190,140,350,30);
  ml.setBounds(25,30,250,20);
  l1.setBounds(0,80,130,30);
 // l3.setBounds(65,180,100,30);
  t1.setBounds(130,84,150,25);
 // t2.setBounds(190,180,100,30);
  l2.setBounds(0,120,130,30);
  p1.setBounds(130,124,150,25);
  b1.setBounds(65,180,100,30);
  b2.setBounds(190,180,100,30);

  add(name);
  add(sup);
  add(ml);
  add(l1);
 // add(l3);
  add(t1);
  //add(t2);
  add(l2);
  add(p1);
  add(b1);
  add(b2);
  b1.addActionListener(this);
  b2.addActionListener(this);
 
 }
 public void actionPerformed(ActionEvent ae)
 {if(ae.getSource()==b2)
	 {
	 MainFrame  m=new MainFrame();
	setVisible(false);
	 m.setVisible(true);
      }
	 if(ae.getSource()==b1)
	 {
           
		   String g=t1.getText();
		  String g1=p1.getText();
		 try{
			  
			   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection con=DriverManager.getConnection("Jdbc:Odbc:mcm");
               Statement st=con.createStatement();
                
		 	 ResultSet rs=st.executeQuery("select * from SalePerson" );
              
			  while(rs.next())
			 {

				String gs=rs.getString(1);
				 String gs1=rs.getString(2);
				 if(g.equals(gs))
				 {
					 if(g1.equals(gs1))
					 {
						 t1.setEditable(false);
						 p1.setEditable(false);
					        String d=JOptionPane.showInputDialog( "Enter Counter No"); 
                             System.out.println(d);
                      	  String s;
						  if(d.equals(""))
						 {
							   JOptionPane.showMessageDialog(null,"Please Enter Counter Number ","ENTRY",JOptionPane.INFORMATION_MESSAGE);
					    t1.setEditable(true);
					     p1.setEditable(true);
						 t1.setText("");
						 p1.setText("");
					             
 	     			   }else{
						         // try{
									   
									    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
									//	Connection con=DriverManager.getConnection("Jdbc:Odbc:mcm");
										String qry = "Insert into counter values (?,?)";
										PreparedStatement ps=con.prepareStatement(qry);
	                                  	    ps.setString(1, t1.getText());
                                           ps.setString(2,d);
											 ps.executeUpdate();
						   	  	     wineInfo ci=new wineInfo(d);
			                                  setVisible(false);
			                              ci.setVisible(true);
		   
						          }
					
		   			 }else{
						         
								   JOptionPane.showMessageDialog(null," Passwords  is not Match","ENTRY",JOptionPane.INFORMATION_MESSAGE);
 	     					    }
				 }else{
					             //  JOptionPane.showMessageDialog(null,"Name is not Match","ENTRY",JOptionPane.INFORMATION_MESSAGE);
 	     
				             }

			 }
		    


		 }catch(Exception e){ System.out.println(e);}

	
	 }
 }
 public static void main(String args[])
 {   
  
  SalemanInfo1 lk=new SalemanInfo1();
  lk.setVisible(true);
 }
}


